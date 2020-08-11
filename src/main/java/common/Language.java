package common;

public enum Language {
    EN("en"), RU("ru"), AZ("az"), IT("it");

    private final String lang;

    Language(String lang){
        this.lang = lang;
    }

    public String getLang() {
        return lang.toLowerCase();
    }
}
