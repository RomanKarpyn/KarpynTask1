package com.epam.lab.commentsfound;


import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class JavaCodeReader {
    private static final Logger log = Logger.getLogger(JavaCodeReader.class);

    private String readLine;
    private int countOfComments = 0;

    void readFile(String filePath) {

        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {

            while ((readLine = in.readLine()) != null) {
                searchComments(readLine);
            }

        } catch (IOException ex) {
            ex.getMessage();
            log.error("error");
        }

    }

    private int countComments(String line) {
        char[] charArray = line.toCharArray();
        for (char symbol : charArray) {
            if (symbol == '/') {
                countOfComments++;
            }
        }
        return countOfComments;
    }

    private void searchComments(String line) {
        if (line.contains("//")) {
            int countOfComments = countComments(line);
            String[] parts = line.split("//", countOfComments);
            for (String part : parts) {
                System.out.println(String.format(" //%s", part));
            }
        }
    }

}
