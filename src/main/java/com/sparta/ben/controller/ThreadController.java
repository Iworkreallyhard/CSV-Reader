package com.sparta.ben.controller;

import java.util.ArrayList;

public class ThreadController{
    private static ArrayList<Thread> threads = new ArrayList<>();

    public static void doTheThreads(Employees employees, int numberOfThreads) {

        int employeeTotal=employees.getEmployees().size();
        int difference = employeeTotal/numberOfThreads;
        for(int i = 1; i <= numberOfThreads;i++){
            Thread thread = new Thread(new WhatTheThreadIsMeantToDo(employees,getSplitValue(employeeTotal,numberOfThreads,i),difference*i));
            threads.add(thread);
            thread.start();
        }

        //threadOne.start();
        //threadTwo.start();

//        while (threadOne.isAlive()&& threadTwo.isAlive()){
//
//        }

    }
    private static int getSplitValue(int total, int divisions, int divBelow){
        return (total/divisions)*divBelow;
    }
}
