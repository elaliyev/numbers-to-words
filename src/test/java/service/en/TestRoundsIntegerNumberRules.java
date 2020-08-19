package service.en;

import exceptions.JsonFileStructureException;
import exceptions.LanguageNotSupportedException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.IntegerNumbersRule;
import service.NumberRule;

import java.util.Locale;

public class TestRoundsIntegerNumberRules {

    NumberRule integerRule;

    @Before
    public void setup() {
        integerRule = new IntegerNumbersRule(new Locale("en"), "rules.json");
    }

    @Test
    public void testOnes() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one", integerRule.convert("1"));
        Assert.assertEquals("two", integerRule.convert("2"));
        Assert.assertEquals("three", integerRule.convert("3"));
        Assert.assertEquals("four", integerRule.convert("4"));
        Assert.assertEquals("five", integerRule.convert("5"));
        Assert.assertEquals("six", integerRule.convert("6"));
        Assert.assertEquals("seven", integerRule.convert("7"));
        Assert.assertEquals("eight", integerRule.convert("8"));
        Assert.assertEquals("nine", integerRule.convert("9"));
    }

    @Test
    public void testTens() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("ten", integerRule.convert("10"));
        Assert.assertEquals("twenty", integerRule.convert("20"));
        Assert.assertEquals("thirty", integerRule.convert("30"));
        Assert.assertEquals("forty", integerRule.convert("40"));
        Assert.assertEquals("fifty", integerRule.convert("50"));
        Assert.assertEquals("sixty", integerRule.convert("60"));
        Assert.assertEquals("seventy", integerRule.convert("70"));
        Assert.assertEquals("eighty", integerRule.convert("80"));
        Assert.assertEquals("ninety", integerRule.convert("90"));
    }

    @Test
    public void testHundreds() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one hundred", integerRule.convert("100"));
        Assert.assertEquals("two hundred", integerRule.convert("200"));
        Assert.assertEquals("three hundred", integerRule.convert("300"));
        Assert.assertEquals("four hundred", integerRule.convert("400"));
        Assert.assertEquals("five hundred", integerRule.convert("500"));
        Assert.assertEquals("six hundred", integerRule.convert("600"));
        Assert.assertEquals("seven hundred", integerRule.convert("700"));
        Assert.assertEquals("eight hundred", integerRule.convert("800"));
        Assert.assertEquals("nine hundred", integerRule.convert("900"));
    }

    @Test
    public void testThousands() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one thousand", integerRule.convert("1000"));
        Assert.assertEquals("two thousand", integerRule.convert("2000"));
        Assert.assertEquals("three thousand", integerRule.convert("3000"));
        Assert.assertEquals("four thousand", integerRule.convert("4000"));
        Assert.assertEquals("five thousand", integerRule.convert("5000"));
        Assert.assertEquals("six thousand", integerRule.convert("6000"));
        Assert.assertEquals("seven thousand", integerRule.convert("7000"));
        Assert.assertEquals("eight thousand", integerRule.convert("8000"));
        Assert.assertEquals("nine thousand", integerRule.convert("9000"));
    }

    @Test
    public void testTenThousands() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("ten thousand", integerRule.convert("10000"));
        Assert.assertEquals("twenty thousand", integerRule.convert("20000"));
        Assert.assertEquals("thirty thousand", integerRule.convert("30000"));
        Assert.assertEquals("forty thousand", integerRule.convert("40000"));
        Assert.assertEquals("fifty thousand", integerRule.convert("50000"));
        Assert.assertEquals("sixty thousand", integerRule.convert("60000"));
        Assert.assertEquals("seventy thousand", integerRule.convert("70000"));
        Assert.assertEquals("eighty thousand", integerRule.convert("80000"));
        Assert.assertEquals("ninety thousand", integerRule.convert("90000"));
    }

    @Test
    public void testHundredThousands() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one hundred thousand", integerRule.convert("100000"));
        Assert.assertEquals("two hundred thousand", integerRule.convert("200000"));
        Assert.assertEquals("three hundred thousand", integerRule.convert("300000"));
        Assert.assertEquals("four hundred thousand", integerRule.convert("400000"));
        Assert.assertEquals("five hundred thousand", integerRule.convert("500000"));
        Assert.assertEquals("six hundred thousand", integerRule.convert("600000"));
        Assert.assertEquals("seven hundred thousand", integerRule.convert("700000"));
        Assert.assertEquals("eight hundred thousand", integerRule.convert("800000"));
        Assert.assertEquals("nine hundred thousand", integerRule.convert("900000"));
    }

    @Test
    public void testMillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one million", integerRule.convert("1000000"));
        Assert.assertEquals("two million", integerRule.convert("2000000"));
        Assert.assertEquals("three million", integerRule.convert("3000000"));
        Assert.assertEquals("four million", integerRule.convert("4000000"));
        Assert.assertEquals("five million", integerRule.convert("5000000"));
        Assert.assertEquals("six million", integerRule.convert("6000000"));
        Assert.assertEquals("seven million", integerRule.convert("7000000"));
        Assert.assertEquals("eight million", integerRule.convert("8000000"));
        Assert.assertEquals("nine million", integerRule.convert("9000000"));
    }

    @Test
    public void testTenMillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("ten million", integerRule.convert("10000000"));
        Assert.assertEquals("twenty million", integerRule.convert("20000000"));
        Assert.assertEquals("thirty million", integerRule.convert("30000000"));
        Assert.assertEquals("forty million", integerRule.convert("40000000"));
        Assert.assertEquals("fifty million", integerRule.convert("50000000"));
        Assert.assertEquals("sixty million", integerRule.convert("60000000"));
        Assert.assertEquals("seventy million", integerRule.convert("70000000"));
        Assert.assertEquals("eighty million", integerRule.convert("80000000"));
        Assert.assertEquals("ninety million", integerRule.convert("90000000"));
    }

    @Test
    public void testHundredMillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one hundred million", integerRule.convert("100000000"));
        Assert.assertEquals("two hundred million", integerRule.convert("200000000"));
        Assert.assertEquals("three hundred million", integerRule.convert("300000000"));
        Assert.assertEquals("four hundred million", integerRule.convert("400000000"));
        Assert.assertEquals("five hundred million", integerRule.convert("500000000"));
        Assert.assertEquals("six hundred million", integerRule.convert("600000000"));
        Assert.assertEquals("seven hundred million", integerRule.convert("700000000"));
        Assert.assertEquals("eight hundred million", integerRule.convert("800000000"));
        Assert.assertEquals("nine hundred million", integerRule.convert("900000000"));
    }

    @Test
    public void testBillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one billion", integerRule.convert("1000000000"));
        Assert.assertEquals("two billion", integerRule.convert("2000000000"));
        Assert.assertEquals("three billion", integerRule.convert("3000000000"));
        Assert.assertEquals("four billion", integerRule.convert("4000000000"));
        Assert.assertEquals("five billion", integerRule.convert("5000000000"));
        Assert.assertEquals("six billion", integerRule.convert("6000000000"));
        Assert.assertEquals("seven billion", integerRule.convert("7000000000"));
        Assert.assertEquals("eight billion", integerRule.convert("8000000000"));
        Assert.assertEquals("nine billion", integerRule.convert("9000000000"));
    }

    @Test
    public void testTenBillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("ten billion", integerRule.convert("10000000000"));
        Assert.assertEquals("twenty billion", integerRule.convert("20000000000"));
        Assert.assertEquals("thirty billion", integerRule.convert("30000000000"));
        Assert.assertEquals("forty billion", integerRule.convert("40000000000"));
        Assert.assertEquals("fifty billion", integerRule.convert("50000000000"));
        Assert.assertEquals("sixty billion", integerRule.convert("60000000000"));
        Assert.assertEquals("seventy billion", integerRule.convert("70000000000"));
        Assert.assertEquals("eighty billion", integerRule.convert("80000000000"));
        Assert.assertEquals("ninety billion", integerRule.convert("90000000000"));
    }

    @Test
    public void testHundredBillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one hundred billion", integerRule.convert("100000000000"));
        Assert.assertEquals("two hundred billion", integerRule.convert("200000000000"));
        Assert.assertEquals("three hundred billion", integerRule.convert("300000000000"));
        Assert.assertEquals("four hundred billion", integerRule.convert("400000000000"));
        Assert.assertEquals("five hundred billion", integerRule.convert("500000000000"));
        Assert.assertEquals("six hundred billion", integerRule.convert("600000000000"));
        Assert.assertEquals("seven hundred billion", integerRule.convert("700000000000"));
        Assert.assertEquals("eight hundred billion", integerRule.convert("800000000000"));
        Assert.assertEquals("nine hundred billion", integerRule.convert("900000000000"));
    }
}
