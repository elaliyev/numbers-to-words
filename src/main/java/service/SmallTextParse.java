package service;

import common.LanguageNotDefinedException;
import common.NotDefinedRuleException;

public class SmallTextParse implements TextParse {

    private NumberRule rule;

    private SmallTextParse() {

    }

    public SmallTextParse(NumberRule rule) {
        this.rule = rule;
    }

    @Override
    public String findAndReplaceIntegerNumber(String text) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= '0' && text.charAt(i) <= '9') {
                int end = i;
                while (end < text.length() && text.charAt(end) >= '0' && text.charAt(end) <= '9') {
                    end++;
                }
                System.out.println(text.substring(i, end));
                try {
                    result.append(rule.convert(text.substring(i, end), new StringBuilder())).append(" ");
                } catch (NotDefinedRuleException e) {
                    e.printStackTrace();
                } catch (LanguageNotDefinedException e) {
                    e.printStackTrace();
                }
                i = end;
            } else {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }
}
