import common.Language;
import service.IntegerNumbersRule;
import service.NumberRule;
import service.SmallTextParse;

public class DigitsToLetters {

    public static void main(String[] args) throws Exception {

        NumberRule integerRule = new IntegerNumbersRule();
        integerRule.loadRuleFile("rules.json");
        integerRule.setLanguage(Language.EN);

        String text = " 69999 7 44 I am 32 years old I have born in 1987 and 54, 6 degree 55 4   0  8";
        System.out.println("size "+text.length());
        SmallTextParse parse = new SmallTextParse(integerRule);
        String result = parse.findAndReplaceIntegerNumber(text);
        System.out.println(result);
    }
}
