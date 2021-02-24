package com.sparta.ben.controller;

import com.sparta.ben.model.EmployeeDTO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteDataToFile {
    public static void write(ArrayList<EmployeeDTO> employees) throws IOException {
        try {
            File corruptFile = new File("src/main/resources/corruptFiles.txt");
            if (corruptFile.createNewFile()) {
                System.out.println("File created: " + corruptFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        FileWriter fileWriter = new FileWriter("src/main/resources/corruptFiles");
        fileWriter.write("Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary\n");

        for (EmployeeDTO employee : employees) {
            fileWriter.write(employee.getEmp_ID() + ","+ employee.getFirstName()+ ","+employee.getMiddleInit()+ ","+employee.getLastName()+ ","+employee.getGender()+ ","+employee.getEmail()+ ","+employee.getDateOfBirth()+ ","+employee.getDateOfJoining()+ ","+ employee.getSalary());
        }
    }
}
