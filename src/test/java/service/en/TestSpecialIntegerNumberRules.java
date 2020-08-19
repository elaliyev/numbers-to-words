package service.en;

import common.Language;
import exceptions.JsonFileStructureException;
import exceptions.LanguageNotSupportedException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.IntegerNumbersRule;
import service.NumberRule;


public class TestSpecialIntegerNumberRules {

    NumberRule integerRule;

    @Before
    public void setup() {
        integerRule = new IntegerNumbersRule(Language.EN.getLang(), "rules.json");
    }

    @Test
    public void testExceptionNumbers() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("eleven", integerRule.convert("11"));
        Assert.assertEquals("twelve", integerRule.convert("12"));
        Assert.assertEquals("thirteen", integerRule.convert("13"));
        Assert.assertEquals("fourteen", integerRule.convert("14"));
        Assert.assertEquals("fifteen", integerRule.convert("15"));
        Assert.assertEquals("sixteen", integerRule.convert("16"));
        Assert.assertEquals("seventeen", integerRule.convert("17"));
        Assert.assertEquals("eighteen", integerRule.convert("18"));
        Assert.assertEquals("nineteen", integerRule.convert("19"));
    }

    @Test
    public void testTensRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("twenty one", integerRule.convert("21"));
        Assert.assertEquals("twenty three", integerRule.convert("23"));
        Assert.assertEquals("thirty one", integerRule.convert("31"));
        Assert.assertEquals("thirty eight", integerRule.convert("38"));
        Assert.assertEquals("forty one", integerRule.convert("41"));
        Assert.assertEquals("forty four", integerRule.convert("44"));
        Assert.assertEquals("fifty three", integerRule.convert("53"));
        Assert.assertEquals("sixty nine", integerRule.convert("69"));
        Assert.assertEquals("seventy seven", integerRule.convert("77"));
        Assert.assertEquals("eighty seven", integerRule.convert("87"));
        Assert.assertEquals("ninety six", integerRule.convert("96"));
    }

    @Test
    public void testHundredsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one hundred one", integerRule.convert("101"));
        Assert.assertEquals("one hundred three", integerRule.convert("103"));
        Assert.assertEquals("one hundred ten", integerRule.convert("110"));
        Assert.assertEquals("one hundred eleven", integerRule.convert("111"));
        Assert.assertEquals("one hundred nineteen", integerRule.convert("119"));
        Assert.assertEquals("two hundred one", integerRule.convert("201"));
        Assert.assertEquals("two hundred twenty two", integerRule.convert("222"));
        Assert.assertEquals("three hundred eight", integerRule.convert("308"));
        Assert.assertEquals("three hundred ninety nine", integerRule.convert("399"));
        Assert.assertEquals("four hundred forty four", integerRule.convert("444"));
        Assert.assertEquals("five hundred twenty", integerRule.convert("520"));
    }

    @Test
    public void testThousandsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one thousand one", integerRule.convert("1001"));
        Assert.assertEquals("one thousand ten", integerRule.convert("1010"));
        Assert.assertEquals("one thousand one hundred", integerRule.convert("1100"));
        Assert.assertEquals("one thousand fourteen", integerRule.convert("1014"));
        Assert.assertEquals("one thousand one hundred one", integerRule.convert("1101"));
        Assert.assertEquals("one thousand one hundred ninety", integerRule.convert("1190"));
        Assert.assertEquals("one thousand one hundred ninety five", integerRule.convert("1195"));

        Assert.assertEquals("nine thousand eight", integerRule.convert("9008"));
        Assert.assertEquals("nine thousand eighty", integerRule.convert("9080"));
        Assert.assertEquals("nine thousand eight hundred", integerRule.convert("9800"));
        Assert.assertEquals("nine thousand eighty four", integerRule.convert("9084"));
        Assert.assertEquals("nine thousand eight hundred eight", integerRule.convert("9808"));
        Assert.assertEquals("nine thousand eight hundred ninety", integerRule.convert("9890"));
        Assert.assertEquals("nine thousand eight hundred ninety five", integerRule.convert("9895"));

        Assert.assertEquals("nine thousand one hundred five", integerRule.convert("9105"));
    }

    @Test
    public void testTenThousandsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("ten thousand one", integerRule.convert("10001"));
        Assert.assertEquals("ten thousand ten", integerRule.convert("10010"));
        Assert.assertEquals("eleven thousand", integerRule.convert("11000"));
        Assert.assertEquals("ten thousand one hundred", integerRule.convert("10100"));
        Assert.assertEquals("ten thousand fourteen", integerRule.convert("10014"));
        Assert.assertEquals("ten thousand one hundred one", integerRule.convert("10101"));
        Assert.assertEquals("ten thousand one hundred ninety", integerRule.convert("10190"));
        Assert.assertEquals("ten thousand one hundred ninety five", integerRule.convert("10195"));

        Assert.assertEquals("thirty one thousand six", integerRule.convert("31006"));
        Assert.assertEquals("forty four thousand forty four", integerRule.convert("44044"));
        Assert.assertEquals("thirty three thousand three hundred thirty three", integerRule.convert("33333"));
        Assert.assertEquals("thirty three thousand three hundred three", integerRule.convert("33303"));
        Assert.assertEquals("eighty thousand one hundred twenty three", integerRule.convert("80123"));
        Assert.assertEquals("ninety nine thousand one hundred five", integerRule.convert("99105"));
    }

    @Test
    public void testHundredThousandsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one hundred thousand", integerRule.convert("100000"));
        Assert.assertEquals("one hundred thousand one", integerRule.convert("100001"));
        Assert.assertEquals("one hundred thousand ten", integerRule.convert("100010"));
        Assert.assertEquals("one hundred thousand one hundred", integerRule.convert("100100"));
        Assert.assertEquals("one hundred one thousand", integerRule.convert("101000"));
        Assert.assertEquals("one hundred ten thousand", integerRule.convert("110000"));

        Assert.assertEquals("one hundred thousand eleven", integerRule.convert("100011"));
        Assert.assertEquals("one hundred thousand one hundred eleven", integerRule.convert("100111"));
        Assert.assertEquals("one hundred one thousand one hundred eleven", integerRule.convert("101111"));
        Assert.assertEquals("one hundred eleven thousand one hundred eleven", integerRule.convert("111111"));
        Assert.assertEquals("one hundred one thousand eleven", integerRule.convert("101011"));
        Assert.assertEquals("one hundred one thousand one", integerRule.convert("101001"));

        Assert.assertEquals("three hundred thirty three thousand four hundred fifty six", integerRule.convert("333456"));
    }

    @Test
    public void testMillionsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one million one", integerRule.convert("1_000_001"));
        Assert.assertEquals("one million ten", integerRule.convert("1_000_010"));
        Assert.assertEquals("one million one hundred", integerRule.convert("1_000_100"));

        Assert.assertEquals("one million one thousand", integerRule.convert("1_001_000"));
        Assert.assertEquals("one million ten thousand", integerRule.convert("1_010_000"));
        Assert.assertEquals("one million one hundred thousand", integerRule.convert("1_100_000"));


        Assert.assertEquals("one million one hundred thousand eleven", integerRule.convert("1_100_011"));
        Assert.assertEquals("one million one hundred thousand one hundred eleven", integerRule.convert("1_100_111"));
        Assert.assertEquals("one million one hundred one thousand one hundred eleven", integerRule.convert("1_101_111"));
        Assert.assertEquals("one million one hundred eleven thousand one hundred eleven", integerRule.convert("1_111_111"));

        Assert.assertEquals("one million one hundred thousand one hundred one", integerRule.convert("1_100_101"));
        Assert.assertEquals("one million one hundred one thousand one hundred one", integerRule.convert("1_101_101"));
        Assert.assertEquals("one million one hundred eleven thousand one hundred one", integerRule.convert("1_111_101"));
        Assert.assertEquals("one million one hundred sixteen thousand one hundred one", integerRule.convert("1_116_101"));
        Assert.assertEquals("one million one hundred ten thousand one hundred one", integerRule.convert("1_110_101"));
        Assert.assertEquals("one million one hundred ten thousand one", integerRule.convert("1_110_001"));
        Assert.assertEquals("one million eleven thousand eleven", integerRule.convert("1_011_011"));
        Assert.assertEquals("one million eleven thousand sixteen", integerRule.convert("1_011_016"));

        Assert.assertEquals("eight million eight hundred eighty eight thousand eight hundred eighty eight", integerRule.convert("8_888_888"));
    }

    @Test
    public void testTenMillionsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("ten million one", integerRule.convert("10_000_001"));
        Assert.assertEquals("ten million ten", integerRule.convert("10_000_010"));
        Assert.assertEquals("ten million one hundred", integerRule.convert("10_000_100"));
        Assert.assertEquals("seventeen million one hundred", integerRule.convert("17_000_100"));

        Assert.assertEquals("ten million one thousand", integerRule.convert("10_001_000"));
        Assert.assertEquals("ten million ten thousand", integerRule.convert("10_010_000"));
        Assert.assertEquals("ten million one hundred thousand", integerRule.convert("10_100_000"));


        Assert.assertEquals("ten million one hundred thousand eleven", integerRule.convert("10_100_011"));
        Assert.assertEquals("ten million one hundred thousand one hundred eleven", integerRule.convert("10_100_111"));
        Assert.assertEquals("ten million one hundred one thousand one hundred eleven", integerRule.convert("10_101_111"));
        Assert.assertEquals("ten million one hundred eleven thousand one hundred eleven", integerRule.convert("10_111_111"));
        Assert.assertEquals("nineteen million one hundred eleven thousand one hundred eleven", integerRule.convert("19_111_111"));

        Assert.assertEquals("ten million one hundred thousand one hundred one", integerRule.convert("10_100_101"));
        Assert.assertEquals("ten million one hundred one thousand one hundred one", integerRule.convert("10_101_101"));
        Assert.assertEquals("ten million one hundred eleven thousand one hundred one", integerRule.convert("10_111_101"));
        Assert.assertEquals("ten million one hundred sixteen thousand one hundred one", integerRule.convert("10_116_101"));
        Assert.assertEquals("ten million one hundred ten thousand one hundred one", integerRule.convert("10_110_101"));
        Assert.assertEquals("ten million one hundred ten thousand one", integerRule.convert("10_110_001"));
        Assert.assertEquals("ten million eleven thousand eleven", integerRule.convert("10_011_011"));
        Assert.assertEquals("ten million eleven thousand sixteen", integerRule.convert("10_011_016"));

        Assert.assertEquals("eighty million eight hundred eighty eight thousand eight hundred eighty eight", integerRule.convert("80_888_888"));
    }

    @Test
    public void testTenAndHundredMillionsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one hundred million one", integerRule.convert("100_000_001"));
        Assert.assertEquals("one hundred million ten", integerRule.convert("100_000_010"));
        Assert.assertEquals("one hundred million one hundred", integerRule.convert("100_000_100"));
        Assert.assertEquals("one hundred seventy million one hundred", integerRule.convert("170_000_100"));

        Assert.assertEquals("one hundred million one thousand", integerRule.convert("100_001_000"));
        Assert.assertEquals("one hundred million ten thousand", integerRule.convert("100_010_000"));
        Assert.assertEquals("one hundred million one hundred thousand", integerRule.convert("100_100_000"));


        Assert.assertEquals("one hundred million one hundred thousand eleven", integerRule.convert("100_100_011"));
        Assert.assertEquals("one hundred million one hundred thousand one hundred eleven", integerRule.convert("100_100_111"));
        Assert.assertEquals("one hundred million one hundred one thousand one hundred eleven", integerRule.convert("100_101_111"));
        Assert.assertEquals("one hundred million one hundred eleven thousand one hundred eleven", integerRule.convert("100_111_111"));
        Assert.assertEquals("one hundred ninety million one hundred eleven thousand one hundred eleven", integerRule.convert("190_111_111"));

        Assert.assertEquals("one hundred million one hundred thousand one hundred one", integerRule.convert("100_100_101"));
        Assert.assertEquals("one hundred million one hundred one thousand one hundred one", integerRule.convert("100_101_101"));
        Assert.assertEquals("one hundred million one hundred eleven thousand one hundred one", integerRule.convert("100_111_101"));
        Assert.assertEquals("one hundred million one hundred sixteen thousand one hundred one", integerRule.convert("100_116_101"));
        Assert.assertEquals("one hundred million one hundred ten thousand one hundred one", integerRule.convert("100_110_101"));
        Assert.assertEquals("one hundred million one hundred ten thousand one", integerRule.convert("100_110_001"));
        Assert.assertEquals("one hundred million eleven thousand eleven", integerRule.convert("100_011_011"));
        Assert.assertEquals("one hundred million eleven thousand sixteen", integerRule.convert("100_011_016"));

        Assert.assertEquals("eight hundred million eight hundred eighty eight thousand eight hundred eighty eight", integerRule.convert("800_888_888"));


        Assert.assertEquals("one hundred one million one", integerRule.convert("101_000_001"));
        Assert.assertEquals("one hundred ten million ten", integerRule.convert("110_000_010"));
        Assert.assertEquals("one hundred eleven million one hundred", integerRule.convert("111_000_100"));
        Assert.assertEquals("one hundred eleven million one hundred thousand one hundred", integerRule.convert("111_100_100"));
        Assert.assertEquals("one hundred eleven million one thousand one hundred", integerRule.convert("111_001_100"));
        Assert.assertEquals("two hundred seventy seven million one hundred", integerRule.convert("277_000_100"));
    }

    @Test
    public void testBillionsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one billion one", integerRule.convert("1_000_000_001"));
        Assert.assertEquals("one billion ten", integerRule.convert("1_000_000_010"));
        Assert.assertEquals("one billion one hundred", integerRule.convert("1_000_000_100"));

        Assert.assertEquals("one billion one thousand", integerRule.convert("1_000_001_000"));

        Assert.assertEquals("one billion ten thousand", integerRule.convert("1_000_010_000"));
        Assert.assertEquals("one billion one hundred thousand", integerRule.convert("1_000_100_000"));


        Assert.assertEquals("one billion one hundred thousand eleven", integerRule.convert("1_000_100_011"));
        Assert.assertEquals("one billion one hundred thousand one hundred eleven", integerRule.convert("1_000_100_111"));
        Assert.assertEquals("one billion one hundred one thousand one hundred eleven", integerRule.convert("1_000_101_111"));
        Assert.assertEquals("one billion one hundred eleven million one hundred eleven thousand one hundred eleven", integerRule.convert("1_111_111_111"));

        Assert.assertEquals("one billion one hundred thousand one hundred one", integerRule.convert("1_000_100_101"));
        Assert.assertEquals("one billion one hundred one thousand one hundred one", integerRule.convert("1_000_101_101"));
        Assert.assertEquals("one billion one hundred eleven thousand one hundred one", integerRule.convert("1_000_111_101"));
        Assert.assertEquals("one billion one hundred sixteen thousand one hundred one", integerRule.convert("1_000_116_101"));
        Assert.assertEquals("one billion one hundred ten thousand one hundred one", integerRule.convert("1_000_110_101"));
        Assert.assertEquals("one billion one hundred ten thousand one", integerRule.convert("1_000_110_001"));
        Assert.assertEquals("one billion two million eleven thousand eleven", integerRule.convert("1_002_011_011"));
        Assert.assertEquals("one billion one hundred two million eleven thousand eleven", integerRule.convert("1_102_011_011"));
        Assert.assertEquals("one billion two hundred twenty two million eleven thousand sixteen", integerRule.convert("1_222_011_016"));

        Assert.assertEquals("eight billion nine hundred ninety nine million eight hundred eighty eight thousand eight hundred eighty eight", integerRule.convert("8_999_888_888"));
    }

    @Test
    public void testTenBillionsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("ten billion one", integerRule.convert("10_000_000_001"));
        Assert.assertEquals("ten billion ten", integerRule.convert("10_000_000_010"));
        Assert.assertEquals("ten billion one hundred", integerRule.convert("10_000_000_100"));

        Assert.assertEquals("ten billion one thousand", integerRule.convert("10_000_001_000"));

        Assert.assertEquals("ten billion ten thousand", integerRule.convert("10_000_010_000"));
        Assert.assertEquals("ten billion one hundred thousand", integerRule.convert("10_000_100_000"));


        Assert.assertEquals("ten billion one hundred thousand eleven", integerRule.convert("10_000_100_011"));
        Assert.assertEquals("ten billion one hundred thousand one hundred eleven", integerRule.convert("10_000_100_111"));
        Assert.assertEquals("ten billion one hundred one thousand one hundred eleven", integerRule.convert("10_000_101_111"));
        Assert.assertEquals("eleven billion one hundred eleven million one hundred eleven thousand one hundred eleven", integerRule.convert("11_111_111_111"));

        Assert.assertEquals("ten billion one hundred thousand one hundred one", integerRule.convert("10_000_100_101"));
        Assert.assertEquals("ten billion one hundred one thousand one hundred one", integerRule.convert("10_000_101_101"));
        Assert.assertEquals("ten billion one hundred eleven thousand one hundred one", integerRule.convert("10_000_111_101"));
        Assert.assertEquals("ten billion one hundred sixteen thousand one hundred one", integerRule.convert("10_000_116_101"));
        Assert.assertEquals("ten billion one hundred ten thousand one hundred one", integerRule.convert("10_000_110_101"));
        Assert.assertEquals("ten billion one hundred ten thousand one", integerRule.convert("10_000_110_001"));
        Assert.assertEquals("ten billion two million eleven thousand eleven", integerRule.convert("10_002_011_011"));
        Assert.assertEquals("thirteen billion one hundred two million eleven thousand eleven", integerRule.convert("13_102_011_011"));
        Assert.assertEquals("sixteen billion two hundred twenty two million eleven thousand sixteen", integerRule.convert("16_222_011_016"));

        Assert.assertEquals("eighty five billion nine hundred ninety nine million eight hundred eighty eight thousand eight hundred eighty eight", integerRule.convert("85_999_888_888"));
    }

    @Test
    public void testHundredBillionsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("one hundred billion one", integerRule.convert("100_000_000_001"));
        Assert.assertEquals("one hundred billion ten", integerRule.convert("100_000_000_010"));
        Assert.assertEquals("one hundred billion one hundred", integerRule.convert("100_000_000_100"));

        Assert.assertEquals("one hundred billion one thousand", integerRule.convert("100_000_001_000"));

        Assert.assertEquals("one hundred billion ten thousand", integerRule.convert("100_000_010_000"));
        Assert.assertEquals("one hundred billion one hundred thousand", integerRule.convert("100_000_100_000"));


        Assert.assertEquals("one hundred billion one hundred thousand eleven", integerRule.convert("100_000_100_011"));
        Assert.assertEquals("one hundred billion one hundred thousand one hundred eleven", integerRule.convert("100_000_100_111"));
        Assert.assertEquals("one hundred billion one hundred one thousand one hundred eleven", integerRule.convert("100_000_101_111"));
        Assert.assertEquals("one hundred eleven billion one hundred eleven million one hundred eleven thousand one hundred eleven", integerRule.convert("111_111_111_111"));

        Assert.assertEquals("one hundred billion one hundred thousand one hundred one", integerRule.convert("100_000_100_101"));
        Assert.assertEquals("one hundred billion one hundred one thousand one hundred one", integerRule.convert("100_000_101_101"));
        Assert.assertEquals("one hundred billion one hundred eleven thousand one hundred one", integerRule.convert("100_000_111_101"));
        Assert.assertEquals("one hundred billion one hundred sixteen thousand one hundred one", integerRule.convert("100_000_116_101"));
        Assert.assertEquals("one hundred billion one hundred ten thousand one hundred one", integerRule.convert("100_000_110_101"));
        Assert.assertEquals("one hundred billion one hundred ten thousand one", integerRule.convert("100_000_110_001"));
        Assert.assertEquals("one hundred billion two million eleven thousand eleven", integerRule.convert("100_002_011_011"));
        Assert.assertEquals("one hundred thirty billion one hundred two million eleven thousand eleven", integerRule.convert("130_102_011_011"));
        Assert.assertEquals("one hundred sixty two billion two hundred twenty two million eleven thousand sixteen", integerRule.convert("162_222_011_016"));

        Assert.assertEquals("eight hundred fifty one billion nine hundred ninety nine million eight hundred eighty eight thousand eight hundred eighty eight", integerRule.convert("851_999_888_888"));
    }
}
