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

public class TestRoundsIntegerNumberRules {

    NumberRule integerRule;

    @Before
    public void setup() throws IOException, ParseException {
        integerRule = new IntegerNumbersRule();
        integerRule.loadRuleFile("rules.json");
        integerRule.setLanguage(Language.EN);
    }

    @Test
    public void testOnes() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("one", integerRule.convert("1", new StringBuilder()));
        Assert.assertEquals("two", integerRule.convert("2", new StringBuilder()));
        Assert.assertEquals("three", integerRule.convert("3", new StringBuilder()));
        Assert.assertEquals("four", integerRule.convert("4", new StringBuilder()));
        Assert.assertEquals("five", integerRule.convert("5", new StringBuilder()));
        Assert.assertEquals("six", integerRule.convert("6", new StringBuilder()));
        Assert.assertEquals("seven", integerRule.convert("7", new StringBuilder()));
        Assert.assertEquals("eight", integerRule.convert("8", new StringBuilder()));
        Assert.assertEquals("nine", integerRule.convert("9", new StringBuilder()));
    }

    @Test
    public void testTens() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("ten", integerRule.convert("10", new StringBuilder()));
        Assert.assertEquals("twenty", integerRule.convert("20", new StringBuilder()));
        Assert.assertEquals("thirty", integerRule.convert("30", new StringBuilder()));
        Assert.assertEquals("forty", integerRule.convert("40", new StringBuilder()));
        Assert.assertEquals("fifty", integerRule.convert("50", new StringBuilder()));
        Assert.assertEquals("sixty", integerRule.convert("60", new StringBuilder()));
        Assert.assertEquals("seventy", integerRule.convert("70", new StringBuilder()));
        Assert.assertEquals("eighty", integerRule.convert("80", new StringBuilder()));
        Assert.assertEquals("ninety", integerRule.convert("90", new StringBuilder()));
    }

    @Test
    public void testHundreds() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("one hundred", integerRule.convert("100", new StringBuilder()));
        Assert.assertEquals("two hundred", integerRule.convert("200", new StringBuilder()));
        Assert.assertEquals("three hundred", integerRule.convert("300", new StringBuilder()));
        Assert.assertEquals("four hundred", integerRule.convert("400", new StringBuilder()));
        Assert.assertEquals("five hundred", integerRule.convert("500", new StringBuilder()));
        Assert.assertEquals("six hundred", integerRule.convert("600", new StringBuilder()));
        Assert.assertEquals("seven hundred", integerRule.convert("700", new StringBuilder()));
        Assert.assertEquals("eight hundred", integerRule.convert("800", new StringBuilder()));
        Assert.assertEquals("nine hundred", integerRule.convert("900", new StringBuilder()));
    }
    @Test
    public void testThousands() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("one thousand", integerRule.convert("1000", new StringBuilder()));
        Assert.assertEquals("two thousand", integerRule.convert("2000", new StringBuilder()));
        Assert.assertEquals("three thousand", integerRule.convert("3000", new StringBuilder()));
        Assert.assertEquals("four thousand", integerRule.convert("4000", new StringBuilder()));
        Assert.assertEquals("five thousand", integerRule.convert("5000", new StringBuilder()));
        Assert.assertEquals("six thousand", integerRule.convert("6000", new StringBuilder()));
        Assert.assertEquals("seven thousand", integerRule.convert("7000", new StringBuilder()));
        Assert.assertEquals("eight thousand", integerRule.convert("8000", new StringBuilder()));
        Assert.assertEquals("nine thousand", integerRule.convert("9000", new StringBuilder()));
    }
    @Test
    public void testTenThousands() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("ten thousand", integerRule.convert("10000", new StringBuilder()));
        Assert.assertEquals("twenty thousand", integerRule.convert("20000", new StringBuilder()));
        Assert.assertEquals("thirty thousand", integerRule.convert("30000", new StringBuilder()));
        Assert.assertEquals("forty thousand", integerRule.convert("40000", new StringBuilder()));
        Assert.assertEquals("fifty thousand", integerRule.convert("50000", new StringBuilder()));
        Assert.assertEquals("sixty thousand", integerRule.convert("60000", new StringBuilder()));
        Assert.assertEquals("seventy thousand", integerRule.convert("70000", new StringBuilder()));
        Assert.assertEquals("eighty thousand", integerRule.convert("80000", new StringBuilder()));
        Assert.assertEquals("ninety thousand", integerRule.convert("90000", new StringBuilder()));
    }

    @Test
    public void testHundredThousands() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("one hundred thousand", integerRule.convert("100000", new StringBuilder()));
        Assert.assertEquals("two hundred thousand", integerRule.convert("200000", new StringBuilder()));
        Assert.assertEquals("three hundred thousand", integerRule.convert("300000", new StringBuilder()));
        Assert.assertEquals("four hundred thousand", integerRule.convert("400000", new StringBuilder()));
        Assert.assertEquals("five hundred thousand", integerRule.convert("500000", new StringBuilder()));
        Assert.assertEquals("six hundred thousand", integerRule.convert("600000", new StringBuilder()));
        Assert.assertEquals("seven hundred thousand", integerRule.convert("700000", new StringBuilder()));
        Assert.assertEquals("eight hundred thousand", integerRule.convert("800000", new StringBuilder()));
        Assert.assertEquals("nine hundred thousand", integerRule.convert("900000", new StringBuilder()));
    }

    @Test
    public void testMillions() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("one million", integerRule.convert("1000000", new StringBuilder()));
        Assert.assertEquals("two million", integerRule.convert("2000000", new StringBuilder()));
        Assert.assertEquals("three million", integerRule.convert("3000000", new StringBuilder()));
        Assert.assertEquals("four million", integerRule.convert("4000000", new StringBuilder()));
        Assert.assertEquals("five million", integerRule.convert("5000000", new StringBuilder()));
        Assert.assertEquals("six million", integerRule.convert("6000000", new StringBuilder()));
        Assert.assertEquals("seven million", integerRule.convert("7000000", new StringBuilder()));
        Assert.assertEquals("eight million", integerRule.convert("8000000", new StringBuilder()));
        Assert.assertEquals("nine million", integerRule.convert("9000000", new StringBuilder()));
    }
    @Test
    public void testTenMillions() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("ten million", integerRule.convert("10000000", new StringBuilder()));
        Assert.assertEquals("twenty million", integerRule.convert("20000000", new StringBuilder()));
        Assert.assertEquals("thirty million", integerRule.convert("30000000", new StringBuilder()));
        Assert.assertEquals("forty million", integerRule.convert("40000000", new StringBuilder()));
        Assert.assertEquals("fifty million", integerRule.convert("50000000", new StringBuilder()));
        Assert.assertEquals("sixty million", integerRule.convert("60000000", new StringBuilder()));
        Assert.assertEquals("seventy million", integerRule.convert("70000000", new StringBuilder()));
        Assert.assertEquals("eighty million", integerRule.convert("80000000", new StringBuilder()));
        Assert.assertEquals("ninety million", integerRule.convert("90000000", new StringBuilder()));
    }

    @Test
    public void testHundredMillions() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("one hundred million", integerRule.convert("100000000", new StringBuilder()));
        Assert.assertEquals("two hundred million", integerRule.convert("200000000", new StringBuilder()));
        Assert.assertEquals("three hundred million", integerRule.convert("300000000", new StringBuilder()));
        Assert.assertEquals("four hundred million", integerRule.convert("400000000", new StringBuilder()));
        Assert.assertEquals("five hundred million", integerRule.convert("500000000", new StringBuilder()));
        Assert.assertEquals("six hundred million", integerRule.convert("600000000", new StringBuilder()));
        Assert.assertEquals("seven hundred million", integerRule.convert("700000000", new StringBuilder()));
        Assert.assertEquals("eight hundred million", integerRule.convert("800000000", new StringBuilder()));
        Assert.assertEquals("nine hundred million", integerRule.convert("900000000", new StringBuilder()));
    }

    @Test
    public void testBillions() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("one billion", integerRule.convert("1000000000", new StringBuilder()));
        Assert.assertEquals("two billion", integerRule.convert("2000000000", new StringBuilder()));
        Assert.assertEquals("three billion", integerRule.convert("3000000000", new StringBuilder()));
        Assert.assertEquals("four billion", integerRule.convert("4000000000", new StringBuilder()));
        Assert.assertEquals("five billion", integerRule.convert("5000000000", new StringBuilder()));
        Assert.assertEquals("six billion", integerRule.convert("6000000000", new StringBuilder()));
        Assert.assertEquals("seven billion", integerRule.convert("7000000000", new StringBuilder()));
        Assert.assertEquals("eight billion", integerRule.convert("8000000000", new StringBuilder()));
        Assert.assertEquals("nine billion", integerRule.convert("9000000000", new StringBuilder()));
    }
    @Test
    public void testTenBillions() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("ten billion", integerRule.convert("10000000000", new StringBuilder()));
        Assert.assertEquals("twenty billion", integerRule.convert("20000000000", new StringBuilder()));
        Assert.assertEquals("thirty billion", integerRule.convert("30000000000", new StringBuilder()));
        Assert.assertEquals("forty billion", integerRule.convert("40000000000", new StringBuilder()));
        Assert.assertEquals("fifty billion", integerRule.convert("50000000000", new StringBuilder()));
        Assert.assertEquals("sixty billion", integerRule.convert("60000000000", new StringBuilder()));
        Assert.assertEquals("seventy billion", integerRule.convert("70000000000", new StringBuilder()));
        Assert.assertEquals("eighty billion", integerRule.convert("80000000000", new StringBuilder()));
        Assert.assertEquals("ninety billion", integerRule.convert("90000000000", new StringBuilder()));
    }

    @Test
    public void testHundredBillions() throws LanguageNotDefinedException, NotDefinedRuleException {
        Assert.assertEquals("one hundred billion", integerRule.convert("100000000000", new StringBuilder()));
        Assert.assertEquals("two hundred billion", integerRule.convert("200000000000", new StringBuilder()));
        Assert.assertEquals("three hundred billion", integerRule.convert("300000000000", new StringBuilder()));
        Assert.assertEquals("four hundred billion", integerRule.convert("400000000000", new StringBuilder()));
        Assert.assertEquals("five hundred billion", integerRule.convert("500000000000", new StringBuilder()));
        Assert.assertEquals("six hundred billion", integerRule.convert("600000000000", new StringBuilder()));
        Assert.assertEquals("seven hundred billion", integerRule.convert("700000000000", new StringBuilder()));
        Assert.assertEquals("eight hundred billion", integerRule.convert("800000000000", new StringBuilder()));
        Assert.assertEquals("nine hundred billion", integerRule.convert("900000000000", new StringBuilder()));
    }
}
