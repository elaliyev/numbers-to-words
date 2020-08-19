import common.Language;
import service.IntegerNumbersRule;
import service.NumberRule;
import service.SmallTextParse;

public class DigitsToLetters {

    public static void main(String[] args) throws Exception {

        NumberRule integerRule = new IntegerNumbersRule(Language.EN.getLang(), "rules.json");

        String text = "a 13.";
        System.out.println("size "+text.length());
        SmallTextParse parse = new SmallTextParse(integerRule);
        String result = parse.findAndReplaceIntegerNumber(text);
        System.out.println(result);
    }
}
