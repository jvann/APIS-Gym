package com.rtu.gymforbeginners.classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Workout {
    String woTitle;
    String woDay;
    int woSets;
    ArrayList<Excercise> woExcList;

    public Workout(String title, String day, int sets, ArrayList<Excercise> exList ) {
        this.woTitle = title;
        this.woDay = day;
        this.woSets = sets;
        this.woExcList = exList;
    }
}