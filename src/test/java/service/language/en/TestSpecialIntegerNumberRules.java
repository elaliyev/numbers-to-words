package service.language.en;

import common.Language;
import common.LanguageNotDefinedException;
import common.NotDefinedRuleException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.IntegerNumbersRule;
import service.NumberRule;

import java.io.IOException;

public class TestSpecialIntegerNumberRules {

    NumberRule integerRule;

    @Before
    public void setup() throws IOException, ParseException {
        integerRule = new IntegerNumbersRule();
        integerRule.loadRuleFile("rules.json");
        integerRule.setLanguage(Language.EN);
    }

    @Test
    public void testExceptionNumbers() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("eleven", integerRule.convert("11", new StringBuilder()));
        Assert.assertEquals("twelve", integerRule.convert("12", new StringBuilder()));
        Assert.assertEquals("thirteen", integerRule.convert("13", new StringBuilder()));
        Assert.assertEquals("fourteen", integerRule.convert("14", new StringBuilder()));
        Assert.assertEquals("fifteen", integerRule.convert("15", new StringBuilder()));
        Assert.assertEquals("sixteen", integerRule.convert("16", new StringBuilder()));
        Assert.assertEquals("seventeen", integerRule.convert("17", new StringBuilder()));
        Assert.assertEquals("eighteen", integerRule.convert("18", new StringBuilder()));
        Assert.assertEquals("nineteen", integerRule.convert("19", new StringBuilder()));
    }

    @Test
    public void testTensRules() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("twenty one", integerRule.convert("21", new StringBuilder()));
        Assert.assertEquals("twenty three", integerRule.convert("23", new StringBuilder()));
        Assert.assertEquals("thirty one", integerRule.convert("31", new StringBuilder()));
        Assert.assertEquals("thirty eight", integerRule.convert("38", new StringBuilder()));
        Assert.assertEquals("forty one", integerRule.convert("41", new StringBuilder()));
        Assert.assertEquals("forty four", integerRule.convert("44", new StringBuilder()));
        Assert.assertEquals("fifty three", integerRule.convert("53", new StringBuilder()));
        Assert.assertEquals("sixty nine", integerRule.convert("69", new StringBuilder()));
        Assert.assertEquals("seventy seven", integerRule.convert("77", new StringBuilder()));
        Assert.assertEquals("eighty seven", integerRule.convert("87", new StringBuilder()));
        Assert.assertEquals("ninety six", integerRule.convert("96", new StringBuilder()));
    }

    @Test
    public void testHundredsRules() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("one hundred one", integerRule.convert("101", new StringBuilder()));
        Assert.assertEquals("one hundred three", integerRule.convert("103", new StringBuilder()));
        Assert.assertEquals("one hundred ten", integerRule.convert("110", new StringBuilder()));
        Assert.assertEquals("one hundred eleven", integerRule.convert("111", new StringBuilder()));
        Assert.assertEquals("one hundred nineteen", integerRule.convert("119", new StringBuilder()));
        Assert.assertEquals("two hundred one", integerRule.convert("201", new StringBuilder()));
        Assert.assertEquals("two hundred twenty two", integerRule.convert("222", new StringBuilder()));
        Assert.assertEquals("three hundred eight", integerRule.convert("308", new StringBuilder()));
        Assert.assertEquals("three hundred ninety nine", integerRule.convert("399", new StringBuilder()));
        Assert.assertEquals("four hundred forty four", integerRule.convert("444", new StringBuilder()));
        Assert.assertEquals("five hundred twenty", integerRule.convert("520", new StringBuilder()));
    }
    @Test
    public void testThousandsRules() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("one hundred one", integerRule.convert("101", new StringBuilder()));
        Assert.assertEquals("one hundred three", integerRule.convert("103", new StringBuilder()));
        Assert.assertEquals("one hundred ten", integerRule.convert("110", new StringBuilder()));
        Assert.assertEquals("one hundred eleven", integerRule.convert("111", new StringBuilder()));
        Assert.assertEquals("one hundred nineteen", integerRule.convert("119", new StringBuilder()));
        Assert.assertEquals("two hundred one", integerRule.convert("201", new StringBuilder()));
        Assert.assertEquals("two hundred twenty two", integerRule.convert("222", new StringBuilder()));
        Assert.assertEquals("three hundred eight", integerRule.convert("308", new StringBuilder()));
        Assert.assertEquals("three hundred ninety nine", integerRule.convert("399", new StringBuilder()));
        Assert.assertEquals("four hundred forty four", integerRule.convert("444", new StringBuilder()));
        Assert.assertEquals("five hundred twenty", integerRule.convert("520", new StringBuilder()));
    }
}
