package com.empatkepala.entity.CVEntity;

/**
 * Created by Ryan Bagus Susilo on 3/11/2017.
 */
public class Language {

    private String nameOfLanguage;
    private String notesAchievement;
    private String spokenEnglish;
    private String writtenEnglish;

    public Language(){}
    public Language(String _nameOfLanguage,String  _notesAchievement, String _spokenEnglish,String _writtenEnglish){
        setNameOfLanguage(_nameOfLanguage);
        setNotesAchievement(_notesAchievement);
        setSpokenEnglish(_spokenEnglish);
        setWrittenEnglish(_writtenEnglish);
    }
    public String getNotesAchievement() {
        return notesAchievement;
    }

    public void setNotesAchievement(String notesAchievement) {
        this.notesAchievement = notesAchievement;
    }

    public String getSpokenEnglish() {
        return spokenEnglish;
    }

    public void setSpokenEnglish(String spokenEnglish) {
        this.spokenEnglish = spokenEnglish;
    }

    public String getWrittenEnglish() {
        return writtenEnglish;
    }

    public void setWrittenEnglish(String writtenEnglish) {
        this.writtenEnglish = writtenEnglish;
    }

    public String getNameOfLanguage() {
        return nameOfLanguage;
    }

    public void setNameOfLanguage(String nameOfLanguage) {
        this.nameOfLanguage = nameOfLanguage;
    }
}
