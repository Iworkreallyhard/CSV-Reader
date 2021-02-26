package com.sparta.ben.controller;

import com.sparta.ben.model.EmployeeDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Employees{

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
        //todo: check employee id and email address for duplicates
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

    private void checkIdForDuplicates(){
        // TODO: 26/02/2021
        // todo: also need to check corrupt arraylist
    }

    private void checkEmailforDuplicates(){
        // TODO: 26/02/2021
        //todo: also need to check corrupt arraylist
    }

    public ArrayList<EmployeeDTO> getEmployees() {
        return employees;
    }

    public ArrayList<EmployeeDTO> getCorrupt() {
        // TODO: 26/02/2021 what constitutes a corrupt file?
        return corrupt;
    }


}
