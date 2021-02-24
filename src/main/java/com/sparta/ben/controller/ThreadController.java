package com.sparta.ben.controller;

public class ThreadController{

    public static void doTheThreads(Employees employees) {

        Thread threadOne = new Thread(new WhatTheThreadIsMeantToDo(employees,0,employees.getEmployees().size()/2));
        Thread threadTwo = new Thread(new WhatTheThreadIsMeantToDo(employees,employees.getEmployees().size()/2,employees.getEmployees().size()-1));

        threadOne.start();
        threadTwo.start();

        while (threadOne.isAlive()&& threadTwo.isAlive()){

        }
    }
    //public static void
}
