package service;

import exceptions.JsonFileStructureException;
import exceptions.LanguageNotSupportedException;

/**
 * @author Elvin
 * @author https://github.com/elaliyev/
 */
public interface NumberRule {

    String convert(String number) throws JsonFileStructureException, LanguageNotSupportedException;
}
