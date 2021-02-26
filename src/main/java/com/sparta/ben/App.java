package com.sparta.ben;

import com.sparta.ben.controller.Employees;

public class App
{
    public static void main(String[] args) {

        Employees employees = MainProcess.readCSV();
        System.out.println();
        MainProcess.threadTest(employees);

    }
}
