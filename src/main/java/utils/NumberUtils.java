package utils;

import static common.JsonSchemaConstants.TENS_RULES;
import static common.JsonSchemaConstants.HUNDREDS_RULES;
import static common.JsonSchemaConstants.THOUSANDS_RULES;
import static common.JsonSchemaConstants.MILLIONS_RULES;
import static common.JsonSchemaConstants.BILLIONS_RULES;
import static common.JsonSchemaConstants.NOT_DEFINED_RULES;

public class NumberUtils {

    public static boolean isThousandBase(final int digitsCount) {
        return (digitsCount > 3 && digitsCount <= 6);
    }

    public static boolean isMillionBase(final int digitsCount) {
        return (digitsCount > 6 && digitsCount <= 9);
    }

    public static boolean isBillionBase(final int digitsCount) {
        return (digitsCount > 9 && digitsCount <= 12);
    }

    public static int getDigits(final long number) {
        int digitsCount = 0;
        long k = number;
        while (k != 0) {
            k = k / 10;
            ++digitsCount;
        }
        return digitsCount;
    }

    public static String getRuleNameByDigitsCount(final int digitsCount) {

        String ruleName;
        switch (digitsCount) {
            case 2:
                ruleName = TENS_RULES;
                break;
            case 3:
                ruleName = HUNDREDS_RULES;
                break;
            case 4:
                ruleName = THOUSANDS_RULES;
                break;
            case 7:
                ruleName = MILLIONS_RULES;
                break;
            case 10:
                ruleName = BILLIONS_RULES;
                break;
            default:
                ruleName = NOT_DEFINED_RULES;
                break;

        }
        return ruleName;
    }

    public static int getBaseByDigitsCount(final int digitsCount) {
        return (int) Math.pow(10, digitsCount - 1);
    }

}
