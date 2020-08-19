package service.az;

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
        integerRule = new IntegerNumbersRule(new Locale("az"), "rules.json");
    }

    @Test
    public void testExceptionNumbers() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("on bir", integerRule.convert("11"));
        Assert.assertEquals("on iki", integerRule.convert("12"));
        Assert.assertEquals("on üç", integerRule.convert("13"));
        Assert.assertEquals("on dörd", integerRule.convert("14"));
        Assert.assertEquals("on beş", integerRule.convert("15"));
        Assert.assertEquals("on altı", integerRule.convert("16"));
        Assert.assertEquals("on yeddi", integerRule.convert("17"));
        Assert.assertEquals("on səkkiz", integerRule.convert("18"));
        Assert.assertEquals("on doqquz", integerRule.convert("19"));
    }

    @Test
    public void testTensRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("iyirmi bir", integerRule.convert("21"));
        Assert.assertEquals("iyirmi üç", integerRule.convert("23"));
        Assert.assertEquals("otuz bir", integerRule.convert("31"));
        Assert.assertEquals("otuz səkkiz", integerRule.convert("38"));
        Assert.assertEquals("qırx bir", integerRule.convert("41"));
        Assert.assertEquals("qırx dörd", integerRule.convert("44"));
        Assert.assertEquals("əlli üç", integerRule.convert("53"));
        Assert.assertEquals("altmış doqquz", integerRule.convert("69"));
        Assert.assertEquals("yetmiş yeddi", integerRule.convert("77"));
        Assert.assertEquals("səksən yeddi", integerRule.convert("87"));
        Assert.assertEquals("doxsan altı", integerRule.convert("96"));
    }

    @Test
    public void testHundredsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("yüz bir", integerRule.convert("101"));
        Assert.assertEquals("yüz üç", integerRule.convert("103"));
        Assert.assertEquals("yüz on", integerRule.convert("110"));
        Assert.assertEquals("yüz on bir", integerRule.convert("111"));
        Assert.assertEquals("yüz on doqquz", integerRule.convert("119"));
        Assert.assertEquals("iki yüz bir", integerRule.convert("201"));
        Assert.assertEquals("iki yüz iyirmi iki", integerRule.convert("222"));
        Assert.assertEquals("üç yüz səkkiz", integerRule.convert("308"));
        Assert.assertEquals("üç yüz doxsan doqquz", integerRule.convert("399"));
        Assert.assertEquals("dörd yüz qırx dörd", integerRule.convert("444"));
        Assert.assertEquals("beş yüz iyirmi", integerRule.convert("520"));
    }

    @Test
    public void testThousandsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("min bir", integerRule.convert("1001"));
        Assert.assertEquals("min on", integerRule.convert("1010"));
        Assert.assertEquals("min yüz", integerRule.convert("1100"));
        Assert.assertEquals("min on dörd", integerRule.convert("1014"));
        Assert.assertEquals("min yüz bir", integerRule.convert("1101"));
        Assert.assertEquals("min yüz doxsan", integerRule.convert("1190"));
        Assert.assertEquals("min yüz doxsan beş", integerRule.convert("1195"));

        Assert.assertEquals("doqquz min səkkiz", integerRule.convert("9008"));
        Assert.assertEquals("doqquz min səksən", integerRule.convert("9080"));
        Assert.assertEquals("doqquz min səkkiz yüz", integerRule.convert("9800"));
        Assert.assertEquals("doqquz min səksən dörd", integerRule.convert("9084"));
        Assert.assertEquals("doqquz min səkkiz yüz səkkiz", integerRule.convert("9808"));
        Assert.assertEquals("doqquz min səkkiz yüz doxsan", integerRule.convert("9890"));
        Assert.assertEquals("doqquz min səkkiz yüz doxsan beş", integerRule.convert("9895"));

        Assert.assertEquals("doqquz min yüz beş", integerRule.convert("9105"));
    }

    @Test
    public void testTenThousandsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("on min bir", integerRule.convert("10001"));
        Assert.assertEquals("on min on", integerRule.convert("10010"));
        Assert.assertEquals("on bir min", integerRule.convert("11000"));
        Assert.assertEquals("on min yüz", integerRule.convert("10100"));
        Assert.assertEquals("on min on dörd", integerRule.convert("10014"));
        Assert.assertEquals("on min yüz bir", integerRule.convert("10101"));
        Assert.assertEquals("on min yüz doxsan", integerRule.convert("10190"));
        Assert.assertEquals("on min yüz doxsan beş", integerRule.convert("10195"));

        Assert.assertEquals("otuz bir min altı", integerRule.convert("31006"));
        Assert.assertEquals("qırx dörd min qırx dörd", integerRule.convert("44044"));
        Assert.assertEquals("otuz üç min üç yüz otuz üç", integerRule.convert("33333"));
        Assert.assertEquals("otuz üç min üç yüz üç", integerRule.convert("33303"));
        Assert.assertEquals("səksən min yüz iyirmi üç", integerRule.convert("80123"));
        Assert.assertEquals("doxsan doqquz min yüz beş", integerRule.convert("99105"));
    }

    @Test
    public void testHundredThousandsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("yüz min", integerRule.convert("100000"));
        Assert.assertEquals("yüz min bir", integerRule.convert("100001"));
        Assert.assertEquals("yüz min on", integerRule.convert("100010"));
        Assert.assertEquals("yüz min yüz", integerRule.convert("100100"));
        Assert.assertEquals("yüz bir min", integerRule.convert("101000"));
        Assert.assertEquals("yüz on min", integerRule.convert("110000"));

        Assert.assertEquals("yüz min on bir", integerRule.convert("100011"));
        Assert.assertEquals("yüz min yüz on bir", integerRule.convert("100111"));
        Assert.assertEquals("yüz bir min yüz on bir", integerRule.convert("101111"));
        Assert.assertEquals("yüz on bir min yüz on bir", integerRule.convert("111111"));
        Assert.assertEquals("yüz bir min on bir", integerRule.convert("101011"));
        Assert.assertEquals("yüz bir min bir", integerRule.convert("101001"));

        Assert.assertEquals("üç yüz otuz üç min dörd yüz əlli altı", integerRule.convert("333456"));
    }

    @Test
    public void testMillionsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("bir milyon bir", integerRule.convert("1_000_001"));
        Assert.assertEquals("bir milyon on", integerRule.convert("1_000_010"));
        Assert.assertEquals("bir milyon yüz", integerRule.convert("1_000_100"));

        Assert.assertEquals("bir milyon min", integerRule.convert("1_001_000"));
        Assert.assertEquals("bir milyon on min", integerRule.convert("1_010_000"));
        Assert.assertEquals("bir milyon yüz min", integerRule.convert("1_100_000"));


        Assert.assertEquals("bir milyon yüz min on bir", integerRule.convert("1_100_011"));
        Assert.assertEquals("bir milyon yüz min yüz on bir", integerRule.convert("1_100_111"));
        Assert.assertEquals("bir milyon yüz bir min yüz on bir", integerRule.convert("1_101_111"));
        Assert.assertEquals("bir milyon yüz on bir min yüz on bir", integerRule.convert("1_111_111"));

        Assert.assertEquals("bir milyon yüz min yüz bir", integerRule.convert("1_100_101"));
        Assert.assertEquals("bir milyon yüz bir min yüz bir", integerRule.convert("1_101_101"));
        Assert.assertEquals("bir milyon yüz on bir min yüz bir", integerRule.convert("1_111_101"));
        Assert.assertEquals("bir milyon yüz on altı min yüz bir", integerRule.convert("1_116_101"));
        Assert.assertEquals("bir milyon yüz on min yüz bir", integerRule.convert("1_110_101"));
        Assert.assertEquals("bir milyon yüz on min bir", integerRule.convert("1_110_001"));
        Assert.assertEquals("bir milyon on bir min on bir", integerRule.convert("1_011_011"));
        Assert.assertEquals("bir milyon on bir min on altı", integerRule.convert("1_011_016"));

        Assert.assertEquals("səkkiz milyon səkkiz yüz səksən səkkiz min səkkiz yüz səksən səkkiz", integerRule.convert("8_888_888"));
    }

    @Test
    public void testTenMiillionsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("on milyon bir", integerRule.convert("10_000_001"));
        Assert.assertEquals("on milyon on", integerRule.convert("10_000_010"));
        Assert.assertEquals("on milyon yüz", integerRule.convert("10_000_100"));
        Assert.assertEquals("on yeddi milyon yüz", integerRule.convert("17_000_100"));

        Assert.assertEquals("on milyon min", integerRule.convert("10_001_000"));
        Assert.assertEquals("on milyon on min", integerRule.convert("10_010_000"));
        Assert.assertEquals("on milyon yüz min", integerRule.convert("10_100_000"));


        Assert.assertEquals("on milyon yüz min on bir", integerRule.convert("10_100_011"));
        Assert.assertEquals("on milyon yüz min yüz on bir", integerRule.convert("10_100_111"));
        Assert.assertEquals("on milyon yüz bir min yüz on bir", integerRule.convert("10_101_111"));
        Assert.assertEquals("on milyon yüz on bir min yüz on bir", integerRule.convert("10_111_111"));
        Assert.assertEquals("on doqquz milyon yüz on bir min yüz on bir", integerRule.convert("19_111_111"));

        Assert.assertEquals("on milyon yüz min yüz bir", integerRule.convert("10_100_101"));
        Assert.assertEquals("on milyon yüz bir min yüz bir", integerRule.convert("10_101_101"));
        Assert.assertEquals("on milyon yüz on bir min yüz bir", integerRule.convert("10_111_101"));
        Assert.assertEquals("on milyon yüz on altı min yüz bir", integerRule.convert("10_116_101"));
        Assert.assertEquals("on milyon yüz on min yüz bir", integerRule.convert("10_110_101"));
        Assert.assertEquals("on milyon yüz on min bir", integerRule.convert("10_110_001"));
        Assert.assertEquals("on milyon on bir min on bir", integerRule.convert("10_011_011"));
        Assert.assertEquals("on milyon on bir min on altı", integerRule.convert("10_011_016"));

        Assert.assertEquals("səksən milyon səkkiz yüz səksən səkkiz min səkkiz yüz səksən səkkiz", integerRule.convert("80_888_888"));
    }

    @Test
    public void testTenAndHundredMillionsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("yüz milyon bir", integerRule.convert("100_000_001"));
        Assert.assertEquals("yüz milyon on", integerRule.convert("100_000_010"));
        Assert.assertEquals("yüz milyon yüz", integerRule.convert("100_000_100"));
        Assert.assertEquals("yüz yetmiş milyon yüz", integerRule.convert("170_000_100"));

        Assert.assertEquals("yüz milyon min", integerRule.convert("100_001_000"));
        Assert.assertEquals("yüz milyon on min", integerRule.convert("100_010_000"));
        Assert.assertEquals("yüz milyon yüz min", integerRule.convert("100_100_000"));


        Assert.assertEquals("yüz milyon yüz min on bir", integerRule.convert("100_100_011"));
        Assert.assertEquals("yüz milyon yüz min yüz on bir", integerRule.convert("100_100_111"));
        Assert.assertEquals("yüz milyon yüz bir min yüz on bir", integerRule.convert("100_101_111"));
        Assert.assertEquals("yüz milyon yüz on bir min yüz on bir", integerRule.convert("100_111_111"));
        Assert.assertEquals("yüz doxsan milyon yüz on bir min yüz on bir", integerRule.convert("190_111_111"));

        Assert.assertEquals("yüz milyon yüz min yüz bir", integerRule.convert("100_100_101"));
        Assert.assertEquals("yüz milyon yüz bir min yüz bir", integerRule.convert("100_101_101"));
        Assert.assertEquals("yüz milyon yüz on bir min yüz bir", integerRule.convert("100_111_101"));
        Assert.assertEquals("yüz milyon yüz on altı min yüz bir", integerRule.convert("100_116_101"));
        Assert.assertEquals("yüz milyon yüz on min yüz bir", integerRule.convert("100_110_101"));
        Assert.assertEquals("yüz milyon yüz on min bir", integerRule.convert("100_110_001"));
        Assert.assertEquals("yüz milyon on bir min on bir", integerRule.convert("100_011_011"));
        Assert.assertEquals("yüz milyon on bir min on altı", integerRule.convert("100_011_016"));

        Assert.assertEquals("səkkiz yüz milyon səkkiz yüz səksən səkkiz min səkkiz yüz səksən səkkiz", integerRule.convert("800_888_888"));


        Assert.assertEquals("yüz bir milyon bir", integerRule.convert("101_000_001"));
        Assert.assertEquals("yüz on milyon on", integerRule.convert("110_000_010"));
        Assert.assertEquals("yüz on bir milyon yüz", integerRule.convert("111_000_100"));
        Assert.assertEquals("yüz on bir milyon yüz min yüz", integerRule.convert("111_100_100"));
        Assert.assertEquals("yüz on bir milyon min yüz", integerRule.convert("111_001_100"));
        Assert.assertEquals("iki yüz yetmiş yeddi milyon yüz", integerRule.convert("277_000_100"));
    }

    @Test
    public void testBillionRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("bir milyard bir", integerRule.convert("1_000_000_001"));
        Assert.assertEquals("bir milyard on", integerRule.convert("1_000_000_010"));
        Assert.assertEquals("bir milyard yüz", integerRule.convert("1_000_000_100"));

        Assert.assertEquals("bir milyard min", integerRule.convert("1_000_001_000"));

        Assert.assertEquals("bir milyard on min", integerRule.convert("1_000_010_000"));
        Assert.assertEquals("bir milyard yüz min", integerRule.convert("1_000_100_000"));


        Assert.assertEquals("bir milyard yüz min on bir", integerRule.convert("1_000_100_011"));
        Assert.assertEquals("bir milyard yüz min yüz on bir", integerRule.convert("1_000_100_111"));
        Assert.assertEquals("bir milyard yüz bir min yüz on bir", integerRule.convert("1_000_101_111"));
        Assert.assertEquals("bir milyard yüz on bir milyon yüz on bir min yüz on bir", integerRule.convert("1_111_111_111"));

        Assert.assertEquals("bir milyard yüz min yüz bir", integerRule.convert("1_000_100_101"));
        Assert.assertEquals("bir milyard yüz bir min yüz bir", integerRule.convert("1_000_101_101"));
        Assert.assertEquals("bir milyard yüz on bir min yüz bir", integerRule.convert("1_000_111_101"));
        Assert.assertEquals("bir milyard yüz on altı min yüz bir", integerRule.convert("1_000_116_101"));
        Assert.assertEquals("bir milyard yüz on min yüz bir", integerRule.convert("1_000_110_101"));
        Assert.assertEquals("bir milyard yüz on min bir", integerRule.convert("1_000_110_001"));
        Assert.assertEquals("bir milyard iki milyon on bir min on bir", integerRule.convert("1_002_011_011"));
        Assert.assertEquals("bir milyard yüz iki milyon on bir min on bir", integerRule.convert("1_102_011_011"));
        Assert.assertEquals("bir milyard iki yüz iyirmi iki milyon on bir min on altı", integerRule.convert("1_222_011_016"));

        Assert.assertEquals("səkkiz milyard doqquz yüz doxsan doqquz milyon səkkiz yüz səksən səkkiz min səkkiz yüz səksən səkkiz", integerRule.convert("8_999_888_888"));
        Assert.assertEquals("mənfi səkkiz milyard doqquz yüz doxsan doqquz milyon səkkiz yüz səksən səkkiz min səkkiz yüz səksən səkkiz", integerRule.convert("-8_999_888_888"));
    }

    @Test
    public void testTenBillionsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("on milyard bir", integerRule.convert("10_000_000_001"));
        Assert.assertEquals("on milyard on", integerRule.convert("10_000_000_010"));
        Assert.assertEquals("on milyard yüz", integerRule.convert("10_000_000_100"));

        Assert.assertEquals("on milyard min", integerRule.convert("10_000_001_000"));

        Assert.assertEquals("on milyard on min", integerRule.convert("10_000_010_000"));
        Assert.assertEquals("on milyard yüz min", integerRule.convert("10_000_100_000"));


        Assert.assertEquals("on milyard yüz min on bir", integerRule.convert("10_000_100_011"));
        Assert.assertEquals("on milyard yüz min yüz on bir", integerRule.convert("10_000_100_111"));
        Assert.assertEquals("on milyard yüz bir min yüz on bir", integerRule.convert("10_000_101_111"));
        Assert.assertEquals("on bir milyard yüz on bir milyon yüz on bir min yüz on bir", integerRule.convert("11_111_111_111"));

        Assert.assertEquals("on milyard yüz min yüz bir", integerRule.convert("10_000_100_101"));
        Assert.assertEquals("on milyard yüz bir min yüz bir", integerRule.convert("10_000_101_101"));
        Assert.assertEquals("on milyard yüz on bir min yüz bir", integerRule.convert("10_000_111_101"));
        Assert.assertEquals("on milyard yüz on altı min yüz bir", integerRule.convert("10_000_116_101"));
        Assert.assertEquals("on milyard yüz on min yüz bir", integerRule.convert("10_000_110_101"));
        Assert.assertEquals("on milyard yüz on min bir", integerRule.convert("10_000_110_001"));
        Assert.assertEquals("on milyard iki milyon on bir min on bir", integerRule.convert("10_002_011_011"));
        Assert.assertEquals("on üç milyard yüz iki milyon on bir min on bir", integerRule.convert("13_102_011_011"));
        Assert.assertEquals("on altı milyard iki yüz iyirmi iki milyon on bir min on altı", integerRule.convert("16_222_011_016"));

        Assert.assertEquals("səksən beş milyard doqquz yüz doxsan doqquz milyon səkkiz yüz səksən səkkiz min səkkiz yüz səksən səkkiz", integerRule.convert("85_999_888_888"));
    }

    @Test
    public void testHundredBillionsRules() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("yüz milyard bir", integerRule.convert("100_000_000_001"));
        Assert.assertEquals("yüz milyard on", integerRule.convert("100_000_000_010"));
        Assert.assertEquals("yüz milyard yüz", integerRule.convert("100_000_000_100"));

        Assert.assertEquals("yüz milyard min", integerRule.convert("100_000_001_000"));

        Assert.assertEquals("yüz milyard on min", integerRule.convert("100_000_010_000"));
        Assert.assertEquals("yüz milyard yüz min", integerRule.convert("100_000_100_000"));


        Assert.assertEquals("yüz milyard yüz min on bir", integerRule.convert("100_000_100_011"));
        Assert.assertEquals("yüz milyard yüz min yüz on bir", integerRule.convert("100_000_100_111"));
        Assert.assertEquals("yüz milyard yüz bir min yüz on bir", integerRule.convert("100_000_101_111"));
        Assert.assertEquals("yüz on bir milyard yüz on bir milyon yüz on bir min yüz on bir", integerRule.convert("111_111_111_111"));

        Assert.assertEquals("yüz milyard yüz min yüz bir", integerRule.convert("100_000_100_101"));
        Assert.assertEquals("yüz milyard yüz bir min yüz bir", integerRule.convert("100_000_101_101"));
        Assert.assertEquals("yüz milyard yüz on bir min yüz bir", integerRule.convert("100_000_111_101"));
        Assert.assertEquals("yüz milyard yüz on altı min yüz bir", integerRule.convert("100_000_116_101"));
        Assert.assertEquals("yüz milyard yüz on min yüz bir", integerRule.convert("100_000_110_101"));
        Assert.assertEquals("yüz milyard yüz on min bir", integerRule.convert("100_000_110_001"));
        Assert.assertEquals("yüz milyard iki milyon on bir min on bir", integerRule.convert("100_002_011_011"));
        Assert.assertEquals("yüz otuz milyard yüz iki milyon on bir min on bir", integerRule.convert("130_102_011_011"));
        Assert.assertEquals("yüz altmış iki milyard iki yüz iyirmi iki milyon on bir min on altı", integerRule.convert("162_222_011_016"));

        Assert.assertEquals("səkkiz yüz əlli bir milyard doqquz yüz doxsan doqquz milyon səkkiz yüz səksən səkkiz min səkkiz yüz səksən səkkiz", integerRule.convert("851_999_888_888"));
    }
}
