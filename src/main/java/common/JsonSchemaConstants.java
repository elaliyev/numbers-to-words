package common;

import java.util.Map;

public class JsonSchemaConstants {

    //common definition
    public static final String COMMON_DEF = "common_def";
    public static final String EXCEPTIONS = "exceptions";
    public static final String SPLITTER = "splitter";
    public static final String SPLITTER_ONES_TENS = "splitter_ones_tens";
    public static final String THOUSAND = "thousand";
    public static final String MILLION = "million";
    public static final String BILLION = "billion";
    public static final String NEGATIVE_SIGN = "negative_sign";

    public static final String RULE = "rule";
    public static final String ZERO = "zero";
    public static final String ONES = "ones";
    public static final String TENS = "tens";
    public static final String CONCAT = "CONCAT";
    public static final String SPACE = "SPACE";


    //rules name
    public static final String TENS_RULES = "tens_rules";
    public static final String HUNDREDS_RULES = "hundreds_rules";
    public static final String THOUSANDS_RULES = "thousands_rules";
    public static final String MILLIONS_RULES = "millions_rules";
    public static final String BILLIONS_RULES = "billions_rules";
    public static final String NOT_DEFINED_RULES = "billions_rules";


    //REF NAMES
    public static final String REF_ONES = "#ones";
    public static final String REF_TENS = "#tens";

    //rule symbol
    public static final String CONCAT_SYMBOL = "\\$CONCAT\\$";
    public static final String SPACE_SYMBOL = "\\$SPACE\\$";

    //pattern rule map
    public static final Map<String, String> patternRuleMap = Map.of(
            SPACE, " ",
            CONCAT, "");

}
