package com.epam.lab.serealizede;


import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String args[]) {
        List<Droid> droids = new ArrayList<>();
        droids.add(new Droid(34, 54, "Prompt"));
        droids.add(new Droid(34, 54, "Pro"));
        serealize(droids);
        log.info("object serealized");
        deserealize();
        log.info("object deserealized");
    }

    private static void serealize(List<Droid> droids) {
        try {
            FileOutputStream fos = new FileOutputStream("serializedObj.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Ship ship = new Ship(droids, "Ship", 140);
            oos.writeObject(ship);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserealize() {
        try {
            FileInputStream fis = new FileInputStream("serializedObj.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Ship ship = (Ship) ois.readObject();
            System.out.println(ship);
            ois.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.getCause();
        }
    }
}