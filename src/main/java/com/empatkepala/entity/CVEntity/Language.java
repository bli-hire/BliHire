package com.empatkepala.entity.CVEntity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ryan Bagus Susilo on 3/11/2017.
 */
public class Language implements Serializable {

    private String nameOfLanguage;
    private ArrayList<String> spokenLanguage;
    private ArrayList<String> writtenLanguage;

    public Language(){}
    public Language(String _nameOfLanguage, ArrayList<String> _spokenLanguage,ArrayList<String> _writtenLanguage){
        setNameOfLanguage(_nameOfLanguage);
        setspokenLanguage(_spokenLanguage);
        setwrittenLanguage(_writtenLanguage);
    }

    public ArrayList<String> getspokenLanguage() {
        return spokenLanguage;
    }

    public void setspokenLanguage(ArrayList<String> spokenLanguage) {
        this.spokenLanguage = spokenLanguage;
    }

    public ArrayList<String> getwrittenLanguage() {
        return writtenLanguage;
    }

    public void setwrittenLanguage(ArrayList<String> writtenLanguage) {
        this.writtenLanguage = writtenLanguage;
    }

    public String getNameOfLanguage() {
        return nameOfLanguage;
    }

    public void setNameOfLanguage(String nameOfLanguage) {
        this.nameOfLanguage = nameOfLanguage;
    }
}
