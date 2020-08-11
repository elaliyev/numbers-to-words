import common.Language;
import service.IntegerTypeRule;
import service.Rule;

public class DigitsToLetters {

    public static void main(String[] args) throws Exception {

        Rule integerRule = new IntegerTypeRule();
        integerRule.loadRuleFile("rules.json");
        integerRule.setLanguage(Language.EN);
        System.out.println("10_426_250_321->"+integerRule.convert("10426250321", new StringBuilder()));

    }
}
