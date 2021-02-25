package com.sparta.ben.controller;

public class WhatTheThreadIsMeantToDo implements Runnable {
        private Employees employees;
        private int firstValue;
        private int lastValue;

    public WhatTheThreadIsMeantToDo(Employees employees, int firstValue, int lastValue) {
        this.employees = employees;
        this.firstValue = firstValue;
        this.lastValue = lastValue;
    }

    public void run(){
        //EmployeeDAO.connectToDB();
        for(int i = firstValue; i<=lastValue; i++) {
            //EmployeeDAO.insertData(employees.getEmployees().get(i));
        }
        System.out.println(Thread.currentThread());

    }

}
