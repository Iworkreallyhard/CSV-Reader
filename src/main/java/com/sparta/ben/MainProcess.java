package com.sparta.ben;

import com.sparta.ben.controller.CSVReader;
import com.sparta.ben.controller.EmployeeDAO;
import com.sparta.ben.controller.Employees;
import com.sparta.ben.controller.ThreadController;
import com.sparta.ben.model.PropertiesContainer;

public class MainProcess {

    public static void start(){
        long timeOne = System.currentTimeMillis();

        Employees employees = readCSV();
        long timeTwo = System.currentTimeMillis() - timeOne;
        System.out.println("info read: " + timeTwo + "ms");

        connectToDB();
        long timeThree = System.currentTimeMillis() - timeOne;
        System.out.println("DB connected time: " + timeThree + "ms");

        EmployeeDAO.truncateTable();
        long timeFour = System.currentTimeMillis() - timeOne;
        System.out.println("table deleted time: " + timeFour + "ms");

        ThreadController.doTheThreads(employees,1);

        long timeFive = (System.currentTimeMillis() - timeOne) / 1000;
        System.out.println("Data inserted time: " + timeFive + "s");
    }

    public static Employees readCSV(){
        long timeOne = System.currentTimeMillis();
        PropertiesContainer.createProperties();
        Employees employees = CSVReader.readValues(PropertiesContainer.getCsvLocation());

        long timeTwo = System.currentTimeMillis() - timeOne;
        System.out.println("info read: " + timeTwo + "ms");
        return employees;
    }

    public static void threadTest(Employees employees){
        ThreadController.doTheThreads(employees,10);
    }

    public static void connectToDB(){
        EmployeeDAO.connectToDB();
    }
}
