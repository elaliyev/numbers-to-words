package common;

public class NotDefinedRuleException extends Exception{
    private String message;
    private int digitsCount;

    public NotDefinedRuleException(String message, int digitsCount){
        this.message = message;
        this.digitsCount = digitsCount;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
