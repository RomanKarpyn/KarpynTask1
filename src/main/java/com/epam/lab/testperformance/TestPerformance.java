package com.epam.lab.testperformance;


import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;

class TestPerformance {
    private static final Logger log = Logger.getLogger(TestPerformance.class);

    private String pathWrite = "wrote.txt";
    private static final long SECUND = 1000000000;

    void testBufferedReader() {
        String pathRead = setPath();
        try (BufferedReader br = new BufferedReader(new FileReader(pathRead))) {
            int c;
            long startTime = System.nanoTime();
            while ((c = br.read()) != -1) {

                String p = "test";
            }
            long endTime = System.nanoTime();
            long timeOfPerformance = (endTime - startTime) / SECUND;
            log.info("Tested");
            System.out.println(String.format("Time of reading by BufferedReader %f secunds", (double) timeOfPerformance));
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    void testReader() {
        String pathRead = setPath();
        try (Reader reader = new FileReader(pathRead)) {

            int c;
            long startTime = System.nanoTime();
            while ((c = reader.read()) != -1) {

                String p = "test";
            }
            long endTime = System.nanoTime();
            long timeOfPerformance = (endTime - startTime) / SECUND;
            log.info("Tested");
            System.out.println(String.format("Time of reading by Reader %f secunds", (double) timeOfPerformance));
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    void testBufferedWriter() {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathWrite))) {

            long startTime = System.nanoTime();
            bw.write("hello");
            long endTime = System.nanoTime();
            long timeOfPerformance = (endTime - startTime);
            log.info("Tested");
            System.out.println("Time of writing by BufferedReader  milisecunds" + timeOfPerformance);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    void testWriter() {


        try (Writer writer = new FileWriter(pathWrite)) {

            long startTime = System.nanoTime();
            writer.write("hello");
            long endTime = System.nanoTime();
            long timeOfPerformance = (endTime - startTime);
            log.info("Tested");
            System.out.println("Time of writing by Writer  milisecunds:" + timeOfPerformance);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    private String setPath() {
        log.info("enter path to your 200mb file");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        return path;
    }

}
