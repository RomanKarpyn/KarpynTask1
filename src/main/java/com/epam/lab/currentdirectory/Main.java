package com.epam.lab.currentdirectory;

class Main {
    public static void main(String args[]) {
        ComandLine comandLine = new ComandLine();
        boolean state = true;
        System.out.println("write:cd(cd(2 spaces)name_of_the_folder on your disc C),dir or exit");
        System.out.println("for example(cd  Program Files)");
        System.out.println("for example(dir)");
        System.out.print("D:");
        while (state) {
            comandLine.enterCommand();
        }

    }

}
