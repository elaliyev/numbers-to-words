package service.ru;

import exceptions.JsonFileStructureException;
import exceptions.LanguageNotSupportedException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import service.IntegerNumbersRule;
import service.NumberRule;

import java.util.Locale;

@Ignore
public class TestRoundsIntegerNumberRules {

    NumberRule integerRule;

    @Before
    public void setup() {
        integerRule = new IntegerNumbersRule(new Locale("ru"), "rules.json");
    }

    @Test
    public void testOnes() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("один", integerRule.convert("1"));
        Assert.assertEquals("два", integerRule.convert("2"));
        Assert.assertEquals("три", integerRule.convert("3"));
        Assert.assertEquals("четыре", integerRule.convert("4"));
        Assert.assertEquals("пять", integerRule.convert("5"));
        Assert.assertEquals("шесть", integerRule.convert("6"));
        Assert.assertEquals("семь", integerRule.convert("7"));
        Assert.assertEquals("восемь", integerRule.convert("8"));
        Assert.assertEquals("девять", integerRule.convert("9"));

        Assert.assertEquals("отрицательный девять", integerRule.convert("-9"));
    }

    @Test
    public void testTens() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("десять", integerRule.convert("10"));
        Assert.assertEquals("двадцать", integerRule.convert("20"));
        Assert.assertEquals("тридцать", integerRule.convert("30"));
        Assert.assertEquals("сорок", integerRule.convert("40"));
        Assert.assertEquals("пятьдесят", integerRule.convert("50"));
        Assert.assertEquals("шестьдесят", integerRule.convert("60"));
        Assert.assertEquals("семьдесят", integerRule.convert("70"));
        Assert.assertEquals("восемьдесят", integerRule.convert("80"));
        Assert.assertEquals("девяносто", integerRule.convert("90"));
    }

    @Test
    public void testHundreds() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("сто", integerRule.convert("100"));
        Assert.assertEquals("двести", integerRule.convert("200"));
        Assert.assertEquals("триста", integerRule.convert("300"));
        Assert.assertEquals("четыреста", integerRule.convert("400"));
        Assert.assertEquals("пятьсот", integerRule.convert("500"));
        Assert.assertEquals("шестьсот", integerRule.convert("600"));
        Assert.assertEquals("семьсот", integerRule.convert("700"));
        Assert.assertEquals("восемьсот", integerRule.convert("800"));
        Assert.assertEquals("девятьсот", integerRule.convert("900"));
    }

    @Test
    public void testThousands() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("одна тысяча", integerRule.convert("1000"));
        Assert.assertEquals("два тысяча", integerRule.convert("2000"));
        Assert.assertEquals("три тысяча", integerRule.convert("3000"));
        Assert.assertEquals("четыре тысяча", integerRule.convert("4000"));
        Assert.assertEquals("пять тысяч", integerRule.convert("5000"));
        Assert.assertEquals("шесть тысяч", integerRule.convert("6000"));
        Assert.assertEquals("семь тысяч", integerRule.convert("7000"));
        Assert.assertEquals("восемь тысяч", integerRule.convert("8000"));
        Assert.assertEquals("девять тысяч", integerRule.convert("9000"));
    }

    @Test
    public void testTenThousands() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("десять тысяч", integerRule.convert("10000"));
        Assert.assertEquals("двадцать тысяч", integerRule.convert("20000"));
        Assert.assertEquals("тридцать тысяч", integerRule.convert("30000"));
        Assert.assertEquals("сорок тысяч", integerRule.convert("40000"));
        Assert.assertEquals("пятьдесят тысяч", integerRule.convert("50000"));
        Assert.assertEquals("шестьдесят тысяч", integerRule.convert("60000"));
        Assert.assertEquals("семьдесят тысяч", integerRule.convert("70000"));
        Assert.assertEquals("восемьдесят тысяч", integerRule.convert("80000"));
        Assert.assertEquals("девяносто тысяч", integerRule.convert("90000"));
    }

    @Test
    public void testHundredThousands() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("сто тысяч", integerRule.convert("100000"));
        Assert.assertEquals("двести тысяч", integerRule.convert("200000"));
        Assert.assertEquals("триста тысячь", integerRule.convert("300000"));
        Assert.assertEquals("четыреста тысячь", integerRule.convert("400000"));
        Assert.assertEquals("пятьсот тысяч", integerRule.convert("500000"));
        Assert.assertEquals("шестьсот тысяч", integerRule.convert("600000"));
        Assert.assertEquals("семьсот тысяч", integerRule.convert("700000"));
        Assert.assertEquals("восемьсот тысяч", integerRule.convert("800000"));
        Assert.assertEquals("девятьсот тысяч", integerRule.convert("900000"));
    }

    @Test
    public void testMillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("один миллион", integerRule.convert("1000000"));
        Assert.assertEquals("два миллион", integerRule.convert("2000000"));
        Assert.assertEquals("три миллион", integerRule.convert("3000000"));
        Assert.assertEquals("четыре миллион", integerRule.convert("4000000"));
        Assert.assertEquals("пять миллион", integerRule.convert("5000000"));
        Assert.assertEquals("шесть миллион", integerRule.convert("6000000"));
        Assert.assertEquals("семь миллион", integerRule.convert("7000000"));
        Assert.assertEquals("восемь миллион", integerRule.convert("8000000"));
        Assert.assertEquals("девять миллион", integerRule.convert("9000000"));
    }

    @Test
    public void testTenMillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("десять миллион", integerRule.convert("10000000"));
        Assert.assertEquals("двадцать миллион", integerRule.convert("20000000"));
        Assert.assertEquals("тридцать миллион", integerRule.convert("30000000"));
        Assert.assertEquals("сорок миллион", integerRule.convert("40000000"));
        Assert.assertEquals("пятьдесят миллион", integerRule.convert("50000000"));
        Assert.assertEquals("шестьдесят миллион", integerRule.convert("60000000"));
        Assert.assertEquals("семьдесят миллион", integerRule.convert("70000000"));
        Assert.assertEquals("восемьдесят миллион", integerRule.convert("80000000"));
        Assert.assertEquals("девяносто миллион", integerRule.convert("90000000"));
    }

    @Test
    public void testHundredMillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("сто миллион", integerRule.convert("100000000"));
        Assert.assertEquals("двести миллион", integerRule.convert("200000000"));
        Assert.assertEquals("триста миллион", integerRule.convert("300000000"));
        Assert.assertEquals("четыреста миллион", integerRule.convert("400000000"));
        Assert.assertEquals("пятьсот миллион", integerRule.convert("500000000"));
        Assert.assertEquals("шестьсот миллион", integerRule.convert("600000000"));
        Assert.assertEquals("семьсот миллион", integerRule.convert("700000000"));
        Assert.assertEquals("восемьсот миллион", integerRule.convert("800000000"));
        Assert.assertEquals("девятьсот миллион", integerRule.convert("900000000"));
    }

    @Test
    public void testBillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("один миллиард", integerRule.convert("1000000000"));
        Assert.assertEquals("два миллиард", integerRule.convert("2000000000"));
        Assert.assertEquals("три миллиард", integerRule.convert("3000000000"));
        Assert.assertEquals("четыре миллиард", integerRule.convert("4000000000"));
        Assert.assertEquals("пять миллиард", integerRule.convert("5000000000"));
        Assert.assertEquals("шесть миллиард", integerRule.convert("6000000000"));
        Assert.assertEquals("семь миллиард", integerRule.convert("7000000000"));
        Assert.assertEquals("восемь миллиард", integerRule.convert("8000000000"));
        Assert.assertEquals("девять миллиард", integerRule.convert("9000000000"));
    }

    @Test
    public void testTenBillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("десять миллиард", integerRule.convert("10000000000"));
        Assert.assertEquals("двадцать миллиард", integerRule.convert("20000000000"));
        Assert.assertEquals("тридцать миллиард", integerRule.convert("30000000000"));
        Assert.assertEquals("сорок миллиард", integerRule.convert("40000000000"));
        Assert.assertEquals("пятьдесят миллиард", integerRule.convert("50000000000"));
        Assert.assertEquals("шестьдесят миллиард", integerRule.convert("60000000000"));
        Assert.assertEquals("семьдесят миллиард", integerRule.convert("70000000000"));
        Assert.assertEquals("восемьдесят миллиард", integerRule.convert("80000000000"));
        Assert.assertEquals("девяносто миллиард", integerRule.convert("90000000000"));
    }

    @Test
    public void testHundedBillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("сто миллиард", integerRule.convert("100000000000"));
        Assert.assertEquals("двести миллиард", integerRule.convert("200000000000"));
        Assert.assertEquals("триста миллиард", integerRule.convert("300000000000"));
        Assert.assertEquals("четыреста миллиард", integerRule.convert("400000000000"));
        Assert.assertEquals("пятьсот миллиард", integerRule.convert("500000000000"));
        Assert.assertEquals("шестьсот миллиард", integerRule.convert("600000000000"));
        Assert.assertEquals("семьсот миллиард", integerRule.convert("700000000000"));
        Assert.assertEquals("восемьсот миллиард", integerRule.convert("800000000000"));
        Assert.assertEquals("девятьсот миллиард", integerRule.convert("900000000000"));
    }
}
