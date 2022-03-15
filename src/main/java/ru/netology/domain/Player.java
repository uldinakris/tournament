package ru.netology.domain;

public class Player implements Comparable<Player>{
    private int id;
    private String name;
    private int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    @Override
    public int compareTo(Player o) {
        if (strength > o.getStrength()) {
            return 1;
        }
        if (strength < o.getStrength()) {
            return -1;
        }
        return 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
