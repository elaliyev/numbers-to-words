package common;

import static common.Message.NOT_DEFINED;

public class NotDefinedRuleException extends Throwable {
    public NotDefinedRuleException(String rule, int digit) {
        super(" rule is not defined for the " + digit + " digits count");
    }
}
