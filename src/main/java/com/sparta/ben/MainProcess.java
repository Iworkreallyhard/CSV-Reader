package com.sparta.ben;

import com.sparta.ben.controller.CSVReader;
import com.sparta.ben.controller.EmployeeDAO;
import com.sparta.ben.controller.Employees;
import com.sparta.ben.controller.ThreadController;

public class MainProcess {

    public static void start(){
        long timeOne = System.currentTimeMillis();

        Employees employees = CSVReader.readValues("src/main/resources/EmployeeRecords.csv");

        long timeTwo = System.currentTimeMillis() - timeOne;
        System.out.println("info read: " + timeTwo + "ms");

        EmployeeDAO.connectToDB();
        long timeThree = System.currentTimeMillis() - timeOne;
        System.out.println("DB connected time: " + timeThree + "ms");

        EmployeeDAO.truncateTable();
        long timeFour = System.currentTimeMillis() - timeOne;
        System.out.println("table deleted time: " + timeFour + "ms");

        ThreadController.doTheThreads(employees);

        long timeFive = (System.currentTimeMillis() - timeOne) / 1000;
        System.out.println("Data inserted time: " + timeFive + "s");
    }

}
