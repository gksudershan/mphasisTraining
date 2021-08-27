package com.mphasis.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;


public class TextEditor {
    @Autowired
    @Qualifier("spellChecker1")
    private SpellChecker spellChecker;


    /* public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }


    */

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }
    /*
    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

     */
}
