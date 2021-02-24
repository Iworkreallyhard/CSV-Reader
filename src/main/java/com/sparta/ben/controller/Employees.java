package com.sparta.ben.controller;

import com.sparta.ben.model.EmployeeDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Employees implements Runnable{

    private ArrayList<EmployeeDTO> employees = new ArrayList<>();
    private ArrayList<EmployeeDTO> corrupt = new ArrayList<>();



    public void addEmployees(EmployeeDTO[] newEmployees) {
        for(EmployeeDTO e: newEmployees){
            addEmployee(e);
        }
    }

    public void addEmployees(ArrayList<EmployeeDTO> newEmployees) {
        for(EmployeeDTO e: newEmployees){
            addEmployee(e);
        }
    }

    public void addEmployee(EmployeeDTO newEmployee) {
        boolean isCorruptTest = false;
        boolean isDuplicateTest = false;
        isCorruptTest = isCorrupt(newEmployee);

        isDuplicateTest = isDuplicate(newEmployee);

        if (isCorruptTest==false&&isDuplicateTest==false) {
            employees.add(newEmployee);
        }


    }

    private boolean isCorrupt(EmployeeDTO employeeDTO) {
        //todo - returns true if it is, false if not

        return false;
    }

    private boolean isDuplicate(EmployeeDTO employeeDTO){
        boolean check = false;
        for(EmployeeDTO employee: employees){

            check = employee.getEmp_ID().equals(employeeDTO.getEmp_ID());
            if(check){
                corrupt.add(employeeDTO);
                EmployeeDTO move = employees.get(employees.indexOf(employee));
                employees.remove(employees.indexOf(employee));
                corrupt.add(move);

                check = true;
                break;
            }
            else {
                check = false;
            }
        }
        return check;
    }

    public ArrayList<EmployeeDTO> getEmployees() {
        return employees;
    }

    public ArrayList<EmployeeDTO> getCorrupt() {
        return corrupt;
    }

    @Override
    public void run() {

    }
    //    private boolean isDuplicate(EmployeeDTO employeeDTO){
//
//        for(EmployeeDTO e: employees){
//            if(e.getEmp_ID().equals(employeeDTO.getEmp_ID())){
//                corrupt.add(employeeDTO);
//                EmployeeDTO move = employees.get(employees.indexOf(e));
//                employees.remove(employees.indexOf(e));
//                corrupt.add(move);
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        return false;
//    }




//    private int isDuplicate(EmployeeDTO employeeDTO) {
//        //todo
//
//        boolean added = false;
//        int highestIndex = employees.size()-1;
//        int lowestIndex = 0;
//        int midIndex;
//
//
//        while(highestIndex>lowestIndex){
//            midIndex = (highestIndex+lowestIndex)/2;
//            if(Integer.valueOf(employeeDTO.getEmp_ID()) > Integer.valueOf(String.valueOf((employees.get(midIndex))))){//employee id greater than midIndex
//                lowestIndex = midIndex+1;
//
//            }else if(Integer.valueOf(employeeDTO.getEmp_ID()) > Integer.valueOf(String.valueOf(employees.get(midIndex)))){//new employee id lower than mid index
//                highestIndex = midIndex-1;
//            }else{//new employee id equals mid index
//
//
//                break;
//            }
//        }
//        if(highestIndex>lowestIndex){
//            return -1;
//        }else{
//            return highestIndex;
//        }
//    }


}
