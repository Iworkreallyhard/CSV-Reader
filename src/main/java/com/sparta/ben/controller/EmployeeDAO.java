package com.sparta.ben.controller;

import com.sparta.ben.model.EmployeeDTO;
import com.sparta.ben.controller.Employees;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

public class EmployeeDAO{

    private static Connection connection;
    private static Properties properties = new Properties();

    private static void createProperties(){
        try {
            properties.load(new FileReader("src/main/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void connectToDB(){
        createProperties();
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");

        try {
            connection = DriverManager.getConnection(url,userName,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Connected to Database");
    }

    public static void queryDB(String query){

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1));
                for(int i=1; i<10;i++){
                    System.out.println(resultSet.getString(i));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insertData(String emp_ID, String namePrefix, String firstName,String middleInit,String lastName, String gender, String Email, LocalDate dateOfBirth, LocalDate dateOfJoining, Integer salary){
        try {
            //Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `employees`.`employees` (`Employee_ID`, `Prefix`, `First_Name`, `Initial`, `Last_Name`, `Gender`, `Email`, `Date_of_Birth`, `Date_of_Joining`, `Salary`) VALUES (?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1,emp_ID);
            preparedStatement.setString(2,namePrefix);
            preparedStatement.setString(3,firstName);
            preparedStatement.setString(4,middleInit);
            preparedStatement.setString(5,lastName);
            preparedStatement.setString(6,gender);
            preparedStatement.setString(7,Email);
            preparedStatement.setDate(8, Date.valueOf(dateOfBirth));
            preparedStatement.setDate(9, Date.valueOf(dateOfJoining));
            preparedStatement.setInt(10,salary);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void insertData(EmployeeDTO employeeDTO){
        insertData(employeeDTO.getEmp_ID(), employeeDTO.getNamePrefix(), employeeDTO.getFirstName(), employeeDTO.getMiddleInit(), employeeDTO.getLastName(), employeeDTO.getGender(), employeeDTO.getEmail(), employeeDTO.getDateOfBirth(),employeeDTO.getDateOfJoining(),employeeDTO.getSalary());
    }

    public static void insertData(EmployeeDTO[] employeeDTOs){
        for(EmployeeDTO e: employeeDTOs){
            insertData(e);
        }
    }

    public static void insertData(ArrayList<EmployeeDTO> employeeDTOs){
        for(EmployeeDTO e: employeeDTOs){
            insertData(e);
        }
    }

    public static void insertData(Employees employees){
        //todo
        insertData(employees.getEmployees());

    }

    public static void truncateTable(){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("Truncate Table employees.employees");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}