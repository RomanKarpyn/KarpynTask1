package com.epam.lab.testperformance;


public class Main {
    public static void main(String args[]) {
        TestPerformance testPerformance = new TestPerformance();
        testPerformance.testBufferedReader();
        testPerformance.testReader();
        testPerformance.testBufferedWriter();
        testPerformance.testWriter();
    }
}
