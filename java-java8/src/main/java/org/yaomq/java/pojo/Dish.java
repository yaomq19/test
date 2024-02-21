package org.yaomq.java.pojo;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;
    public Dish(String name, boolean vagetarian, int calories, Type type, String name1, boolean vegetarian, int calories1, Type type1){
        this.name = name1;
        this.vegetarian = vegetarian;
        this.calories = calories1;
        this.type = type1;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    public enum Type{MEAT, FISH, OTHER}
}
