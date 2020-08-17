package service;

import common.Language;
import common.LanguageNotDefinedException;
import common.NotDefinedRuleException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface NumberRule {

    void loadRuleFile(String jsonFile) throws IOException, ParseException;
    void setLanguage(Language language);
    String convert(String number, StringBuilder letters) throws NotDefinedRuleException, LanguageNotDefinedException, NotDefinedRuleException;

}
