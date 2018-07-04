package com.epam.lab.commentsfound;


public class Main {
    public static void main(String args[]) {
        JavaCodeReader javaCodeReader = new JavaCodeReader();
        System.out.println("comments:");
        javaCodeReader.readFile("JavaSourceCode.txt");

    }
}
