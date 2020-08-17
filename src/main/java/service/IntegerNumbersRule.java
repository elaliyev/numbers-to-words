package service;

import common.*;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;

import static common.JsonSchemaConstants.*;
import static common.JsonSchemaConstants.COMMON_DEF;

public class IntegerNumbersRule implements NumberRule {

    Logger logger = LoggerFactory.getLogger(IntegerNumbersRule.class);

    private String language;
    private JSONObject rules;
    private JSONObject zero;
    private JSONObject ones;
    private JSONObject tens;
    private JSONObject common;

    @Override
    public void loadRuleFile(String jsonFile) {
        JSONParser parser = new JSONParser();
        try {
            rules = (JSONObject) parser.parse(new FileReader(jsonFile));
        } catch (IOException ioException) {
            logger.error("Could not find a file {} ", jsonFile);
            ioException.printStackTrace();
        } catch (ParseException parseException) {
            logger.error("Could not parse a file {} ", jsonFile);
            parseException.printStackTrace();
        }
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language.getLang();
    }

    @Override
    public String convert(String number, StringBuilder letters) throws LanguageNotDefinedException, NotDefinedRuleException {
        if (StringUtils.isEmpty(language)) {
            logger.error("The language is not defined");
            throw new LanguageNotDefinedException("The " + language + " language is not defined");
        }
        if (rules == null) {
            logger.info("The rule file is not loaded properly");
            throw new RuntimeException("The rule file is not loaded properly");
        }
        loadRules();

        if (number.startsWith("-")) {
            letters.append(common.get(NEGATIVE_SIGN));
        }
        if (number.length() == 1) {
            calculateForOneDigit(number, letters);
        } else {
            calculate(number, letters);
        }

        return letters.toString();
    }

    private void loadRules() {

        zero = (JSONObject) ((JSONObject) rules.get(ZERO)).get(language);
        ones = (JSONObject) ((JSONObject) rules.get(ONES)).get(language);
        tens = (JSONObject) ((JSONObject) rules.get(TENS)).get(language);
        common = (JSONObject) ((JSONObject) rules.get(COMMON_DEF)).get(language);
    }

    private void checkJsonFileStructure(String field) throws JsonFileStructureException, LanguageNotSupportedException {
        if (rules.get(field) == null)
            throw new JsonFileStructureException(field + " is not defined");
        if (((JSONObject) rules.get(field)).get(language) == null)
            throw new LanguageNotSupportedException(language + " not defined for " + field + " field");
    }

    private void calculateForOneDigit(String number, StringBuilder letters) {
        if (number.equals("0"))
            letters.append(zero.get(number));
        else
            letters.append(ones.get(number));
    }

    private JSONObject getRuleByRuleName(String ruleName) {
        JSONObject langs = (JSONObject) rules.get(ruleName);
        JSONObject rules = (JSONObject) langs.get(language);
        return rules;
    }

    private boolean isNumberException(JSONObject rules, long number, StringBuilder letters) {
        JSONObject exceptions = (JSONObject) rules.get(EXCEPTIONS);
        if (exceptions != null && exceptions.get(String.valueOf(number)) != null) {
            letters.append(exceptions.get(String.valueOf(number)));
            return true;
        }
        return false;
    }

    private boolean isBasePartException(JSONObject rules, long number, int digitsCount, int base, StringBuilder letters) throws LanguageNotDefinedException, NotDefinedRuleException {
        long d = number / base;
        long val = d * base;

        JSONObject exceptions = (JSONObject) rules.get(EXCEPTIONS);
        if (exceptions != null && exceptions.get(String.valueOf(val)) != null) {
            letters.append(exceptions.get(String.valueOf(val)));
            long reminder = number - val;
            if (reminder != 0)
                calculate(reminder, digitsCount - 1, letters.append(common.get(SPLITTER)));
            return true;
        }
        return false;
    }

    private void calculate(String number, StringBuilder letters) throws LanguageNotDefinedException, NotDefinedRuleException {
        long n = Long.parseLong(number);
        if (n >= 10_000_000_000l && n <= 1_000_000_000_000l) {
            calculateForTenAndHundredBillions(n, letters);
        } else if (n >= 10_000_000 && n < 1_000_000_000) {
            calculateForTenAndHundredMillions(n, letters);
        } else if (n >= 10_000 && n < 1_000_000) {
            calculateForTenAndHundredThousands(n, letters);
        } else {
            calculate(n, number.length(), letters);
        }
    }

    private void calculateForTenAndHundredThousands(long number, StringBuilder letters) throws LanguageNotDefinedException, NotDefinedRuleException {
        long thousandPart = number / 1000;
        long remainingPart = number - thousandPart * 1000;
        int digits = thousandPart / 100 == 0 ? 2 : 3;

        calculate(thousandPart, digits, letters);
        letters.append(common.get(SPLITTER)).append(common.get(THOUSAND));
        if (remainingPart != 0) calculate(remainingPart, 3, letters);
    }

    private void calculateForTenAndHundredMillions(long number, StringBuilder letters) throws LanguageNotDefinedException, NotDefinedRuleException {
        long millionPart = number / 1_000_000l;
        long remainingPart = number - millionPart * 1_000_000l;
        int digits = millionPart / 100 == 0 ? 2 : 3;

        calculate(millionPart, digits, letters);
        letters.append(common.get(MILLION));
        if (remainingPart != 0) calculateForTenAndHundredThousands(remainingPart, letters);
    }

    private void calculateForTenAndHundredBillions(long number, StringBuilder letters) throws LanguageNotDefinedException, NotDefinedRuleException {
        long billionPart = number / 1_000_000_000;
        long remainingPart = number - billionPart * 1_000_000_000;
        int digits = billionPart / 100 == 0 ? 2 : 3;

        calculate(billionPart, digits, letters);
        letters.append(common.get(BILLION));
        if (remainingPart != 0) calculateForTenAndHundredMillions(remainingPart, letters);
    }

    private void calculate(long number, int digitsCount, StringBuilder letters) throws NotDefinedRuleException, LanguageNotDefinedException {
        if (digitsCount == 2 && number % 10 == 0) {
            letters.append(tens.get(String.valueOf(number)));
            return;
        }
        String ruleName = getRuleNameByDigitsCount(digitsCount);
        JSONObject rules = getRuleByRuleName(ruleName);
        if (isNumberException(rules, number, letters))
            return;

        String rule = rules.get(RULE).toString();

        int base = getBaseByDigitsCount(digitsCount);
        if (isBasePartException(rules, number, digitsCount, base, letters)) return;

        long k = number / base;
        long remainder = number - k * base;

        applyRules(k, remainder, base, rule, letters);

        //this condition for if the number 3 digits and second digit is zero
        if(base ==100 && (number/10) %10 ==0){
            letters.append(common.get(SPLITTER)).append(ones.get(String.valueOf(remainder)));
            return;
        }

        calculateForSpecialCases(remainder, digitsCount, letters);

    }

    private void calculateForSpecialCases(long number, int digitsCount, StringBuilder letters) throws
            LanguageNotDefinedException, NotDefinedRuleException {
        if (number != 0 && (digitsCount == 6 || digitsCount == 7)) {
            calculateForTenAndHundredThousands(number, letters.append(common.get(SPLITTER)));
        } else if (number != 0 && (digitsCount == 10 || digitsCount == 9)) {
            calculateForTenAndHundredMillions(number, letters.append(common.get(SPLITTER)));
        } else if (number != 0 && digitsCount > 2) {
            calculate(number, digitsCount - 1, letters.append(common.get(SPLITTER)));
        }
    }

    private void applyRules(long k, long remainder, long base, String rule, StringBuilder letters) {
        if (k != 0 && base == 10) {
            rule = rule.replaceAll(REF_TENS, tens.get(String.valueOf(k * base)).toString());
            rule = rule.replaceAll(REF_ONES, ones.getOrDefault(String.valueOf(remainder), "").toString());
        } else if (k != 0) {
            rule = rule.replaceAll(REF_ONES, ones.getOrDefault(String.valueOf(k), "").toString());
        }
        rule = rule
                .replaceAll(SPACE_SYMBOL, patternRuleMap.get(SPACE))
                .replaceAll(CONCAT_SYMBOL, patternRuleMap.get(CONCAT));
        letters.append(rule);

    }

    private String getRuleNameByDigitsCount(int digitsCount) throws NotDefinedRuleException {

        String ruleName = "";
        switch (digitsCount) {
            case 2:
                ruleName = TENS_RULES;
                break;
            case 3:
                ruleName = HUNDREDS_RULES;
                break;
            case 4:
                ruleName = THOUSANDS_RULES;
                break;
            case 7:
                ruleName = MILLIONS_RULES;
                break;
            case 10:
                ruleName = BILLIONS_RULES;
                break;
            default:
                throw new NotDefinedRuleException(ruleName, digitsCount);
        }

        return ruleName;
    }

    private int getBaseByDigitsCount(int digitsCount) {
        return (int) Math.pow(10, digitsCount - 1);
    }
}
