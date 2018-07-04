package com.epam.lab.formattext;


import org.apache.log4j.Logger;

import java.io.*;

class Formater {
    private static final Logger log = Logger.getLogger(Formater.class);

    private String readLine;
    private String filePath = "fileToFormat.txt";
    private String formatedFilePath = "formatedFile.txt";

    void readAndWriteFile() {
        File sourceFile = new File(filePath);
        File outputFile = new File(formatedFilePath);
        String lineSeparator = System.getProperty("line.separator");
        try (BufferedReader in = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter out = new BufferedWriter(new FileWriter(outputFile))) {

            while ((readLine = in.readLine()) != null) {

                String newText = formatString(readLine) + lineSeparator;
                out.write(newText);
            }
            sourceFile.delete();
            outputFile.renameTo(sourceFile);
            log.info("text has been formatted");

        } catch (IOException ex) {
            ex.getMessage();
        }

    }


    private String formatString(String line) {
        String firstFormat = inspectionColon(line);
        String secondFormat = inspectionSpaces(firstFormat);
        String thirdFormat = inspectionExclamationMark(secondFormat);
        String fourthFormat = inspectionComa(thirdFormat);
        return fourthFormat;
    }

    private String inspectionComa(String line) {
        if (line.contains(",,")) {
            String newLine = line.replaceAll(",,", ",");
            return newLine;
        }
        return line;
    }

    private String inspectionExclamationMark(String line) {
        if (line.contains("!!")) {
            String newLine = line.replaceAll("!!", "!");
            return newLine;
        }
        return line;
    }

    private String inspectionSpaces(String line) {
        if (line.contains("!!")) {
            String newLine = line.replaceAll("  ", " ");
            return newLine;
        }
        return line;
    }

    private String inspectionColon(String line) {
        if (line.contains("::")) {
            String newLine = line.replaceAll("::", ":");
            return newLine;
        }
        return line;
    }

}

