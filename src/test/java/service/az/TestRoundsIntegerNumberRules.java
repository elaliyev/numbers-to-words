package service.az;

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
        integerRule = new IntegerNumbersRule(new Locale("az"), "rules.json");
    }

    @Test
    public void testOnes() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("bir", integerRule.convert("1"));
        Assert.assertEquals("iki", integerRule.convert("2"));
        Assert.assertEquals("üç", integerRule.convert("3"));
        Assert.assertEquals("dörd", integerRule.convert("4"));
        Assert.assertEquals("beş", integerRule.convert("5"));
        Assert.assertEquals("altı", integerRule.convert("6"));
        Assert.assertEquals("yeddi", integerRule.convert("7"));
        Assert.assertEquals("səkkiz", integerRule.convert("8"));
        Assert.assertEquals("doqquz", integerRule.convert("9"));

        Assert.assertEquals("mənfi doqquz", integerRule.convert("-9"));
    }

    @Test
    public void testTens() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("on", integerRule.convert("10"));
        Assert.assertEquals("iyirmi", integerRule.convert("20"));
        Assert.assertEquals("otuz", integerRule.convert("30"));
        Assert.assertEquals("qırx", integerRule.convert("40"));
        Assert.assertEquals("əlli", integerRule.convert("50"));
        Assert.assertEquals("altmış", integerRule.convert("60"));
        Assert.assertEquals("yetmiş", integerRule.convert("70"));
        Assert.assertEquals("səksən", integerRule.convert("80"));
        Assert.assertEquals("doxsan", integerRule.convert("90"));
    }

    @Test
    public void testHundreds() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("yüz", integerRule.convert("100"));
        Assert.assertEquals("iki yüz", integerRule.convert("200"));
        Assert.assertEquals("üç yüz", integerRule.convert("300"));
        Assert.assertEquals("dörd yüz", integerRule.convert("400"));
        Assert.assertEquals("beş yüz", integerRule.convert("500"));
        Assert.assertEquals("altı yüz", integerRule.convert("600"));
        Assert.assertEquals("yeddi yüz", integerRule.convert("700"));
        Assert.assertEquals("səkkiz yüz", integerRule.convert("800"));
        Assert.assertEquals("doqquz yüz", integerRule.convert("900"));
    }

    @Test
    public void testThousands() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("min", integerRule.convert("1000"));
        Assert.assertEquals("iki min", integerRule.convert("2000"));
        Assert.assertEquals("üç min", integerRule.convert("3000"));
        Assert.assertEquals("dörd min", integerRule.convert("4000"));
        Assert.assertEquals("beş min", integerRule.convert("5000"));
        Assert.assertEquals("altı min", integerRule.convert("6000"));
        Assert.assertEquals("yeddi min", integerRule.convert("7000"));
        Assert.assertEquals("səkkiz min", integerRule.convert("8000"));
        Assert.assertEquals("doqquz min", integerRule.convert("9000"));
    }

    @Test
    public void testTenThousands() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("on min", integerRule.convert("10000"));
        Assert.assertEquals("iyirmi min", integerRule.convert("20000"));
        Assert.assertEquals("otuz min", integerRule.convert("30000"));
        Assert.assertEquals("qırx min", integerRule.convert("40000"));
        Assert.assertEquals("əlli min", integerRule.convert("50000"));
        Assert.assertEquals("altmış min", integerRule.convert("60000"));
        Assert.assertEquals("yetmiş min", integerRule.convert("70000"));
        Assert.assertEquals("səksən min", integerRule.convert("80000"));
        Assert.assertEquals("doxsan min", integerRule.convert("90000"));
    }

    @Test
    public void testHundredTousands() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("yüz min", integerRule.convert("100000"));
        Assert.assertEquals("iki yüz min", integerRule.convert("200000"));
        Assert.assertEquals("üç yüz min", integerRule.convert("300000"));
        Assert.assertEquals("dörd yüz min", integerRule.convert("400000"));
        Assert.assertEquals("beş yüz min", integerRule.convert("500000"));
        Assert.assertEquals("altı yüz min", integerRule.convert("600000"));
        Assert.assertEquals("yeddi yüz min", integerRule.convert("700000"));
        Assert.assertEquals("səkkiz yüz min", integerRule.convert("800000"));
        Assert.assertEquals("doqquz yüz min", integerRule.convert("900000"));
    }

    @Test
    public void testMillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("bir milyon", integerRule.convert("1000000"));
        Assert.assertEquals("iki milyon", integerRule.convert("2000000"));
        Assert.assertEquals("üç milyon", integerRule.convert("3000000"));
        Assert.assertEquals("dörd milyon", integerRule.convert("4000000"));
        Assert.assertEquals("beş milyon", integerRule.convert("5000000"));
        Assert.assertEquals("altı milyon", integerRule.convert("6000000"));
        Assert.assertEquals("yeddi milyon", integerRule.convert("7000000"));
        Assert.assertEquals("səkkiz milyon", integerRule.convert("8000000"));
        Assert.assertEquals("doqquz milyon", integerRule.convert("9000000"));
    }

    @Test
    public void testTenMillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("on milyon", integerRule.convert("10000000"));
        Assert.assertEquals("iyirmi milyon", integerRule.convert("20000000"));
        Assert.assertEquals("otuz milyon", integerRule.convert("30000000"));
        Assert.assertEquals("qırx milyon", integerRule.convert("40000000"));
        Assert.assertEquals("əlli milyon", integerRule.convert("50000000"));
        Assert.assertEquals("altmış milyon", integerRule.convert("60000000"));
        Assert.assertEquals("yetmiş milyon", integerRule.convert("70000000"));
        Assert.assertEquals("səksən milyon", integerRule.convert("80000000"));
        Assert.assertEquals("doxsan milyon", integerRule.convert("90000000"));
    }

    @Test
    public void testHundredMillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("yüz milyon", integerRule.convert("100000000"));
        Assert.assertEquals("iki yüz milyon", integerRule.convert("200000000"));
        Assert.assertEquals("üç yüz milyon", integerRule.convert("300000000"));
        Assert.assertEquals("dörd yüz milyon", integerRule.convert("400000000"));
        Assert.assertEquals("beş yüz milyon", integerRule.convert("500000000"));
        Assert.assertEquals("altı yüz milyon", integerRule.convert("600000000"));
        Assert.assertEquals("yeddi yüz milyon", integerRule.convert("700000000"));
        Assert.assertEquals("səkkiz yüz milyon", integerRule.convert("800000000"));
        Assert.assertEquals("doqquz yüz milyon", integerRule.convert("900000000"));
    }

    @Test
    public void testBillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("bir milyard", integerRule.convert("1000000000"));
        Assert.assertEquals("iki milyard", integerRule.convert("2000000000"));
        Assert.assertEquals("üç milyard", integerRule.convert("3000000000"));
        Assert.assertEquals("dörd milyard", integerRule.convert("4000000000"));
        Assert.assertEquals("beş milyard", integerRule.convert("5000000000"));
        Assert.assertEquals("altı milyard", integerRule.convert("6000000000"));
        Assert.assertEquals("yeddi milyard", integerRule.convert("7000000000"));
        Assert.assertEquals("səkkiz milyard", integerRule.convert("8000000000"));
        Assert.assertEquals("doqquz milyard", integerRule.convert("9000000000"));
    }

    @Test
    public void testTenBillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("on milyard", integerRule.convert("10000000000"));
        Assert.assertEquals("iyirmi milyard", integerRule.convert("20000000000"));
        Assert.assertEquals("otuz milyard", integerRule.convert("30000000000"));
        Assert.assertEquals("qırx milyard", integerRule.convert("40000000000"));
        Assert.assertEquals("əlli milyard", integerRule.convert("50000000000"));
        Assert.assertEquals("altmış milyard", integerRule.convert("60000000000"));
        Assert.assertEquals("yetmiş milyard", integerRule.convert("70000000000"));
        Assert.assertEquals("səksən milyard", integerRule.convert("80000000000"));
        Assert.assertEquals("doxsan milyard", integerRule.convert("90000000000"));
    }

    @Test
    public void testHundredBillions() throws JsonFileStructureException, LanguageNotSupportedException {
        Assert.assertEquals("yüz milyard", integerRule.convert("100000000000"));
        Assert.assertEquals("iki yüz milyard", integerRule.convert("200000000000"));
        Assert.assertEquals("üç yüz milyard", integerRule.convert("300000000000"));
        Assert.assertEquals("dörd yüz milyard", integerRule.convert("400000000000"));
        Assert.assertEquals("beş yüz milyard", integerRule.convert("500000000000"));
        Assert.assertEquals("altı yüz milyard", integerRule.convert("600000000000"));
        Assert.assertEquals("yeddi yüz milyard", integerRule.convert("700000000000"));
        Assert.assertEquals("səkkiz yüz milyard", integerRule.convert("800000000000"));
        Assert.assertEquals("doqquz yüz milyard", integerRule.convert("900000000000"));
    }
}
