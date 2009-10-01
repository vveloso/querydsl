/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.collections.domain;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mysema.query.annotations.Entity;
import com.mysema.query.annotations.NonSearchable;
import com.mysema.query.annotations.Type;
import com.mysema.query.types.TypeCategory;
import com.mysema.query.types.path.PSimple;

@Entity
public class Cat extends Animal {
    
    private int breed;
    
    private Color eyecolor;
    
    private List<Cat> kittens;
    
    private Map<String, Cat> kittensByName;
    
    private Cat mate;
    
    @NonSearchable    
    private String skippedField;
    
    @Type(TypeCategory.SIMPLE)    
    private String stringAsSimple;

    @Test
    public void test() throws SecurityException, NoSuchFieldException {
        assertTrue(QCat.cat.stringAsSimple.getClass().equals(PSimple.class));
    }
    
    @Test(expected=NoSuchFieldException.class)
    public void skippedField() throws SecurityException, NoSuchFieldException{
        QCat.class.getField("skippedField");
    }
    public Cat() {
        this.kittensByName = Collections.emptyMap();
    }

    public Cat(String name) {
        Cat kitten = new Cat();
        this.kittens = Arrays.asList(kitten);
        this.kittensByName = Collections.singletonMap("Kitty", kitten);
        this.name = name;
    }

    public Cat(String name, int id) {
        this(name);
        this.id = id;
    }

    public int getBreed() {
        return breed;
    }

    public Color getEyecolor() {
        return eyecolor;
    }

    public List<Cat> getKittens() {
        return kittens;
    }

    public Map<String, Cat> getKittensByName() {
        return kittensByName;
    }

    public Cat getMate() {
        return mate;
    }

    public String toString() {
        return name;
    }

    public void setBreed(int breed) {
        this.breed = breed;
    }

    public void setEyecolor(Color eyecolor) {
        this.eyecolor = eyecolor;
    }

    public void setKittens(List<Cat> kittens) {
        this.kittens = kittens;
    }

    public void setMate(Cat mate) {
        this.mate = mate;
    }

    public String getSkippedField() {
        return skippedField;
    }

    public void setSkippedField(String skippedField) {
        this.skippedField = skippedField;
    }

//    public String getStringAsSimple() {
//        return stringAsSimple;
//    }

    public void setStringAsSimple(String stringAsSimple) {
        this.stringAsSimple = stringAsSimple;
    }

    public void setKittensByName(Map<String, Cat> kittensByName) {
        this.kittensByName = kittensByName;
    }
    
    

}