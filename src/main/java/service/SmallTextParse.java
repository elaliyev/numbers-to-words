package service;

import exceptions.JsonFileStructureException;
import exceptions.LanguageNotSupportedException;

/**
 * @author Elvin
 * @author https://github.com/elaliyev/
 */
public class SmallTextParse implements TextParse {

    private NumberRule rule;

    private SmallTextParse() {

    }

    public SmallTextParse(final NumberRule rule) {
        this.rule = rule;
    }

    /**
     * implemented for find positive integer in the text and replaced it with given language (ignored "-" sign)
     *
     * @param text
     * @return
     */
    @Override
    public String findAndReplacePositiveIntegerNumber(final String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (isNumber(text.charAt(i))) {
                int end = i;
                while (end < text.length() && isNumber(text.charAt(end))) {
                    end++;
                }
                try {
                    result.append(rule.convert(text.substring(i, end)));
                } catch (LanguageNotSupportedException | JsonFileStructureException e) {
                    e.printStackTrace();
                }
                i = end - 1;
            } else {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }

    @Override
    public String findAndReplaceIntegerNumber(String text) {
        return null;
    }

    private boolean isNumber(final char ch) {
        return ch >= '0' && ch <= '9';
    }
}
