package service;

import common.Language;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTextParse {

    TextParse textParse;
    NumberRule integerRule;

    @Before
    public void setup() {
        integerRule = new IntegerNumbersRule(Language.EN.getLang(), "rules.json");
        textParse = new SmallTextParse(integerRule);
    }

    @Test
    public void testIfTheNumberInTheBeginning() {
        String text = "13 Lorem ipsum dolor sit amet, consectetuer adipiscing elit.";
        String expected = "thirteen Lorem ipsum dolor sit amet, consectetuer adipiscing elit.";
        Assert.assertEquals(expected, textParse.findAndReplaceIntegerNumber(text));
    }
    @Test
    public void testIfTheNumberInTheEnd() {
        String text = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit 13.";
        String expected = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit thirteen.";
        Assert.assertEquals(expected, textParse.findAndReplaceIntegerNumber(text));
    }

    @Test
    public void testIfTheNumberInTheMiddle() {
        String text = "Lorem ipsum dolor sit 13 amet, consectetuer adipiscing elit.";
        String expected = "Lorem ipsum dolor sit thirteen amet, consectetuer adipiscing elit.";
        Assert.assertEquals(expected, textParse.findAndReplaceIntegerNumber(text));
    }

    @Test
    public void testIfTheNumberInEverywhere() {
        String text = "12 Lorem ipsum dolor sit 13 amet, consectetuer adipiscing elit.11";
        String expected = "twelve Lorem ipsum dolor sit thirteen amet, consectetuer adipiscing elit.eleven";
        Assert.assertEquals(expected, textParse.findAndReplaceIntegerNumber(text));
    }

    @Test
    public void testIfTheTwoNumbersAreConsistent() {
        String text = "12 10 Lorem ipsum dolor sit 13 1514 27 amet, consectetuer adipiscing elit.9 11";
        String expected = "twelve ten Lorem ipsum dolor sit " +
                "thirteen one thousand five hundred fourteen twenty seven " +
                "amet, consectetuer adipiscing elit.nine eleven";
        Assert.assertEquals(expected, textParse.findAndReplaceIntegerNumber(text));
    }
    @Test
    public void testIfTheTwoNumbersAreConsistentAndSomeOfThemSeperatedByComma() {
        String text = "12 10 Lorem ipsum dolor sit 13,1514 27 amet, consectetuer adipiscing elit.9, 11";
        String expected = "twelve ten Lorem ipsum dolor sit " +
                "thirteen,one thousand five hundred fourteen twenty seven " +
                "amet, consectetuer adipiscing elit.nine, eleven";
        Assert.assertEquals(expected, textParse.findAndReplaceIntegerNumber(text));
    }

    @Test
    public void testIfTheTextNotContainingNumber() {
        String text = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.";
        String expected = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.";
        Assert.assertEquals(expected, textParse.findAndReplaceIntegerNumber(text));
    }

    @Test
    public void testIfTheOnlyNumbers() {
        String text = "12 13 11 1514";
        String expected = "twelve thirteen eleven one thousand five hundred fourteen";
        Assert.assertEquals(expected, textParse.findAndReplaceIntegerNumber(text));
    }
}
