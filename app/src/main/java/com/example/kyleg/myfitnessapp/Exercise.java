package com.example.kyleg.myfitnessapp;

public class Exercise {
    String name = null;
    int setCount = 0;
    int repCount = 0;
    int weight = 0;
    boolean selected = false;


    public Exercise(String name, int setCount, int repCount, int weight,
        boolean selected){
        super();
        this.name = name;
        this.setCount = setCount;
        this.repCount = repCount;
        this.weight = weight;
        this.selected = selected;
    }

    public String getName(){
        return name;
    }

    public int getSetCount(){
        return setCount;
    }

    public int getRepCount(){
        return repCount;
    }

    public int getWeight(){
        return weight;
    }

    public boolean isSelected(){
        return selected;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }
}
