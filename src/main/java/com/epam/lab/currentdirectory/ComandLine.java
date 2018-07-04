package com.epam.lab.currentdirectory;


import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ComandLine {
    private static final Logger log = Logger.getLogger(ComandLine.class);

    private static final int MEGA_BYTE = 1024;
    private String pathToFolder = "D:";
    private static final String DEFAULT_PATH = "D:";
    private static final String SPLIT_SYMBOL = " {2}";
    private static final int LIMIT_SPLIT = 2;
    private static final int INDEX_OF_ARRAY = 1;
    private Scanner sc = new Scanner(System.in);

    void enterCommand() {
        String enteredCommand = sc.nextLine();
        processEnteredCommand(enteredCommand);
    }

    private void processEnteredCommand(String enteredCommand) {
        if (enteredCommand.contains("cd")) {
            processCdCommand(enteredCommand);
        } else if (enteredCommand.contains("dir")) {
            processDirCommand(enteredCommand);
        } else if (enteredCommand.contains("exit")) {
            System.exit(0);
            log.info("program exit");
        }
    }

    private void processCdCommand(String enteredCommand) {
        pathToFolder = generatePath(enteredCommand);
    }

    private void processDirCommand(String enteredCommand) {
        Path path = Paths.get(pathToFolder);
        showAttributes(path);
        showPath(pathToFolder, path);
    }

    private String generatePath(String enteredCommand) {
        String[] parts = enteredCommand.split(SPLIT_SYMBOL, LIMIT_SPLIT);
        Path path = Paths.get(DEFAULT_PATH);
        try {
            pathToFolder = pathToFolder + "\\" + parts[INDEX_OF_ARRAY];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("enter 2 spaces after cd");
        }
        if (isFileReal(pathToFolder)) {

            path = Paths.get(pathToFolder);
            System.out.print(pathToFolder);

        } else if (!isFileReal(pathToFolder)) {
            System.out.println("such file not exist");
            pathToFolder = DEFAULT_PATH;
            path = Paths.get(DEFAULT_PATH);
            System.out.print(DEFAULT_PATH);
        }
        return pathToFolder;
    }

    private boolean isFileReal(String pathToFolder) {
        File file = new File(pathToFolder);
        return file.exists();
    }

    private void showPath(String pathToFolder, Path path) {
        if (isFileReal(pathToFolder)) {
            System.out.print(path.toAbsolutePath());
        } else {
            System.out.print(path.toAbsolutePath());
        }
    }

    private void showAttributes(Path path) {

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path file : stream) {
                BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                FileTime date = attrs.creationTime();
                System.out.print(String.format("%s   %f Mb  ", convertDateFileToString(date),
                        (double) attrs.size() / MEGA_BYTE, file.getFileName()));
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {

            System.err.println(x);
        }
    }

    private String convertDateFileToString(FileTime date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss");
        return df.format(date.toMillis());
    }
}
