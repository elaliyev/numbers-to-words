package service.ru;

import exceptions.JsonFileStructureException;
import exceptions.LanguageNotSupportedException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.IntegerNumbersRule;
import service.NumberRule;

import java.util.Locale;


public class TestSpecialIntegerNumberRules {

    NumberRule integerRule;

    @Before
    public void setup() {
        integerRule = new IntegerNumbersRule(new Locale("ru"), "rules.json");
    }


    @Test
    public void testTensRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("двадцать один", integerRule.convert("21"));
        Assert.assertEquals("двадцать три", integerRule.convert("23"));
        Assert.assertEquals("тридцать один", integerRule.convert("31"));
        Assert.assertEquals("тридцать восемь", integerRule.convert("38"));
        Assert.assertEquals("сорок один", integerRule.convert("41"));
        Assert.assertEquals("сорок четыре", integerRule.convert("44"));
        Assert.assertEquals("пятьдесят три", integerRule.convert("53"));
        Assert.assertEquals("шестьдесят девять", integerRule.convert("69"));
        Assert.assertEquals("семьдесят семь", integerRule.convert("77"));
        Assert.assertEquals("восемьдесят семь", integerRule.convert("87"));
        Assert.assertEquals("девяносто шесть", integerRule.convert("96"));
    }

    @Test
    public void testHundredsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("сто один", integerRule.convert("101"));
        Assert.assertEquals("сто три", integerRule.convert("103"));
        Assert.assertEquals("сто десять", integerRule.convert("110"));
        Assert.assertEquals("сто одиннадцать", integerRule.convert("111"));
        Assert.assertEquals("сто девятнадцать", integerRule.convert("119"));
        Assert.assertEquals("двести один", integerRule.convert("201"));
        Assert.assertEquals("двести двадцать два", integerRule.convert("222"));
        Assert.assertEquals("триста восемь", integerRule.convert("308"));
        Assert.assertEquals("триста девяносто девять", integerRule.convert("399"));
        Assert.assertEquals("четыреста сорок четыре", integerRule.convert("444"));
        Assert.assertEquals("пятьсот двадцать", integerRule.convert("520"));
    }

}
