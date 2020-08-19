package service;

import common.Language;
import exceptions.JsonFileStructureException;
import exceptions.LanguageNotSupportedException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;

import static common.JsonSchemaConstants.*;
import static common.JsonSchemaConstants.COMMON_DEF;
import static utils.NumberUtils.getBaseByDigitsCount;
import static utils.NumberUtils.getDigits;
import static utils.NumberUtils.getRuleNameByDigitsCount;
import static utils.NumberUtils.isThousandBase;
import static utils.NumberUtils.isMillionBase;
import static utils.NumberUtils.isBillionBase;

/**
 * @author Elvin
 * @author https://github.com/elaliyev/
 */
public class IntegerNumbersRule implements NumberRule {

    private Logger logger = LoggerFactory.getLogger(IntegerNumbersRule.class);

    private final String language;
    private final String ruleFile;

    private JSONObject rules;
    private JSONObject zero;
    private JSONObject ones;
    private JSONObject tens;
    private JSONObject common;

    private StringBuilder letters;

    public IntegerNumbersRule(final String language, final String ruleFile) {
        this.language = language;
        this.ruleFile = ruleFile;
    }

    public void loadRuleFile() {
        JSONParser parser = new JSONParser();
        try {
            rules = (JSONObject) parser.parse(new FileReader(ruleFile));
        } catch (IOException ioException) {
            logger.error("Could not find a file {} ", ruleFile);
            ioException.printStackTrace();
        } catch (ParseException parseException) {
            logger.error("Could not parse a file {} ", ruleFile);
            parseException.printStackTrace();
        }
    }

    private void checkJsonFileStructure()
            throws JsonFileStructureException, LanguageNotSupportedException {
        checkJsonFileStructure(ZERO);
        checkJsonFileStructure(ONES);
        checkJsonFileStructure(TENS);
        checkJsonFileStructure(COMMON_DEF);
    }

    private void checkJsonFileStructure(final String field)
            throws JsonFileStructureException, LanguageNotSupportedException {
        if (rules.get(field) == null)
            throw new JsonFileStructureException(field + " is not defined");

        if (((JSONObject) rules.get(field)).get(language) == null)
            throw new LanguageNotSupportedException(language + " not defined for " + field + " field");
    }

    private void loadRules() {

        zero = (JSONObject) ((JSONObject) rules.get(ZERO)).get(language);
        ones = (JSONObject) ((JSONObject) rules.get(ONES)).get(language);
        tens = (JSONObject) ((JSONObject) rules.get(TENS)).get(language);
        common = (JSONObject) ((JSONObject) rules.get(COMMON_DEF)).get(language);
    }

    private JSONObject getRuleByRuleName(final String ruleName) {
        JSONObject langs = (JSONObject) rules.get(ruleName);
        JSONObject rules = (JSONObject) langs.get(language);
        return rules;
    }

    @Override
    public String convert(final String value)
            throws JsonFileStructureException, LanguageNotSupportedException {
        logger.info("Given Number {}",value);
        letters = new StringBuilder();
        loadRuleFile();
        checkJsonFileStructure();
        loadRules();

        String number = value.replaceAll("_", ""); // accept java 9 number format

        if (number.startsWith("-")) {
            letters.append(common.get(NEGATIVE_SIGN));
        }
        int digitsCount = number.length();
        long n = Long.parseLong(number);

        if (digitsCount == 1) {
            calculateForOneDigit(number);
        } else if (isBillionBase(digitsCount)) {
            calculateForTenAndHundredBillions(n);
        } else if (isMillionBase(digitsCount)) {
            calculateForTenAndHundredMillions(n);
        } else if (isThousandBase(digitsCount)) {
            calculateForTenAndHundredThousands(n);
        } else {
            calculate(n);
        }

        return letters.toString().trim();
    }

    private void calculateForOneDigit(final String number) {
        if (number.equals("0")) {
            letters.append(zero.get(number));
        } else {
            letters.append(ones.get(number));
        }
    }

    private void calculate(final long number) {
        int digits = getDigits(number);

        if (digits == 1) {
            calculateForOneDigit(String.valueOf(number));
            return;
        }

        String ruleName = getRuleNameByDigitsCount(digits);
        JSONObject rules = getRuleByRuleName(ruleName);
        if (isNumberException(rules, number)) return;

        String rule = rules.get(RULE).toString();

        int base = getBaseByDigitsCount(digits);
        if (isBasePartException(rules, number, base)) return;

        long k = number / base;
        long remainder = number - k * base;

        applyRules(k, remainder, base, rule);

        calculateForSpecialCases(remainder, digits);
    }

    private void calculateForSpecialCases(final long number, final int digitsCount) {
        if (number == 0) return;
        if (isMillionBase(digitsCount) || isBillionBase(digitsCount)) {
            calculateForBigNumbers(number);
        } else if (digitsCount > 2) {
            addSplitter();
            calculate(number);
        }
    }

    private void calculateForBigNumbers(final long number) {
        addSplitter();
        if (number > 999999) calculateForTenAndHundredMillions(number);
        else if (number > 999) calculateForTenAndHundredThousands(number);
        else if (number != 0) calculate(number);
    }

    private void calculateForTenAndHundredThousands(final long number) {
        long thousandPart = number / 1000;
        long remainingPart = number - thousandPart * 1000;

        calculate(thousandPart);

        if (!letters.toString().endsWith(common.get(SPLITTER).toString())) {
            addSplitter();
        }

        letters.append(common.get(THOUSAND));

        if (remainingPart != 0) {
            addSplitter();
            calculate(remainingPart);
        }
    }

    private void calculateForTenAndHundredMillions(final long number) {
        long millionPart = number / 1_000_000L;
        long remainingPart = number - millionPart * 1_000_000L;

        calculate(millionPart);

        if (!letters.toString().endsWith(common.get(SPLITTER).toString())) {
            addSplitter();
        }

        letters.append(common.get(MILLION));
        calculateForBigNumbers(remainingPart);
    }

    private void calculateForTenAndHundredBillions(final long number) {
        long billionPart = number / 1_000_000_000;
        long remainingPart = number - billionPart * 1_000_000_000;

        calculate(billionPart);

        if (!letters.toString().endsWith(common.get(SPLITTER).toString())) {
            addSplitter();
        }

        letters.append(common.get(BILLION));
        calculateForBigNumbers(remainingPart);
    }

    private void applyRules(final long k, final long remainder, final long base, final String rule) {
        String value = rule;
        if (k != 0 && base == 10) {
            value = value
                    .replaceAll(REF_TENS, tens.get(String.valueOf(k * base)).toString())
                    .replaceAll(REF_ONES, ones.getOrDefault(String.valueOf(remainder), "")
                            .toString());
        } else if (k != 0) {
            value = value.replaceAll(REF_ONES, ones.getOrDefault(String.valueOf(k), "")
                    .toString());
        }
        value = value.trim()
                        .replaceAll(SPACE_SYMBOL, patternRuleMap.get(SPACE))
                        .replaceAll(CONCAT_SYMBOL, patternRuleMap.get(CONCAT));
        letters.append(value);
    }

    private boolean isNumberException(final JSONObject rules, final long number) {
        JSONObject exceptions = (JSONObject) rules.get(EXCEPTIONS);
        if (exceptions != null && exceptions.get(String.valueOf(number)) != null) {
            letters.append(exceptions.get(String.valueOf(number)))
                    .append(common.get(SPLITTER));
            return true;
        }
        return false;
    }

    private boolean isBasePartException(final JSONObject rules, final long number, final int base) {
        long d = number / base;
        long val = d * base;

        JSONObject exceptions = (JSONObject) rules.get(EXCEPTIONS);
        if (exceptions != null && exceptions.get(String.valueOf(val)) != null) {
            letters.append(exceptions.get(String.valueOf(val)));
            long reminder = number - val;

            if (reminder != 0) {
                addSplitter();
                calculate(reminder);
            }
            return true;
        }
        return false;
    }

    private void addSplitter() {
        letters.append(common.get(SPLITTER));
    }
}
