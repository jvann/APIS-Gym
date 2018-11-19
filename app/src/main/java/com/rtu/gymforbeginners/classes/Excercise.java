package com.rtu.gymforbeginners.classes;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Excercise implements Serializable{
    String name;
    int sets;
    int reps;
    String mainMuscle;
    String otherMuscles;
    String equipment;
    String type;
    String description;
    int image;


    public Excercise(){}

    public Excercise(String name, int sets, int reps, String mainMuscle, String otherMuscles,
                     String equipment, String type, String description, int image){
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.mainMuscle = mainMuscle;
        this.otherMuscles = otherMuscles;
        this.equipment = equipment;
        this.type = type;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getMainMuscle() {
        return mainMuscle;
    }

    public void setMainMuscle(String mainMuscle) {
        this.mainMuscle = mainMuscle;
    }

    public String getOtherMuscles() {
        return otherMuscles;
    }

    public void setOtherMuscles(String otherMuscles) {
        this.otherMuscles = otherMuscles;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
