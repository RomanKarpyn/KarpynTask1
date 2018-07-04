package com.epam.lab.serealizede;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ship implements Serializable {
    private List<Droid> droids;
    private transient String name;
    private int speed;

    Ship(List<Droid> droids, String name, int speed) {
        this.droids = new ArrayList<>();
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Ship{" + "droids=" + droids + ", name='" + name + '\'' + ", speed=" + speed + '}';
    }
}
