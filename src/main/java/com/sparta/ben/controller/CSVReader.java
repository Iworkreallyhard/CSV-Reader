package com.sparta.ben.controller;

import com.sparta.ben.model.EmployeeDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static Employees readValues(String path) {
        Employees employees = new Employees();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            bufferedReader.readLine();
            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineSplit = line.split(",");
                EmployeeDTO employeeDTO = new EmployeeDTO(lineSplit[0],lineSplit[1],lineSplit[2],lineSplit[3],lineSplit[4],lineSplit[5],lineSplit[6],lineSplit[7],lineSplit[8], lineSplit[9]);
                employees.addEmployee(employeeDTO);
                count++;
                if(count%10000 == 0){
                    System.out.println("another ten thousand");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}

