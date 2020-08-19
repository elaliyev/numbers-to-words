import service.IntegerNumbersRule;
import service.NumberRule;
import service.SmallTextParse;

import java.util.Locale;

public class DigitsToLetters {

    public static void main(String[] args) throws Exception {

        NumberRule integerRule = new IntegerNumbersRule(new Locale("en"), "rules.json");

        String text = "a 13.";
        System.out.println("size "+text.length());
        SmallTextParse parse = new SmallTextParse(integerRule);
        String result = parse.findAndReplacePositiveIntegerNumber(text);
        System.out.println(result);
    }
}
