package com.sparta.ben.controller;

import com.sparta.ben.model.EmployeeDTO;

import java.util.ArrayList;

public class Employees{

    private ArrayList<EmployeeDTO> employees = new ArrayList<>();
    private ArrayList<EmployeeDTO> corrupt = new ArrayList<>();
    private ArrayList<EmployeeDTO> duplicates = new ArrayList<>();

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
        DuplicateReturn duplicateReturn;
        isCorruptTest = isCorrupt(newEmployee);
        duplicateReturn = isDuplicate(newEmployee);

        if (isCorruptTest==false&&duplicateReturn.isDuplicate()==false) {
            employees.add(newEmployee);
        }else if(isCorruptTest==true){
            //todo: what happens when it is corrupt
        }else {
            //todo:what happens if duplicate
            switch (duplicateReturn.whichList){
                case 0://if it is in employees
                    duplicates.add(newEmployee);
                    duplicates.add(employees.get(duplicateReturn.getLocation()));
                    employees.remove(duplicateReturn.getLocation());
                    break;
                case 1://if it is in duplicates
                    duplicates.add(newEmployee);
                    break;
                case 2://if it is in corrupt
                    //if one to be added is not corrupt, add it
                    break;
            }
        }
    }

    private boolean isCorrupt(EmployeeDTO employeeDTO) {
        //todo - returns true if it is, false if not
        // TODO: 26/02/2021 what constitutes a corrupt file?
        return false;
    }

    private DuplicateReturn isDuplicate(EmployeeDTO employeeDTO){
        //todo: check employee id and email address for duplicates
        DuplicateReturn ret = new DuplicateReturn();

        for(EmployeeDTO employee: employees){
            ret.setDuplicate(employee.getEmp_ID().equals(employeeDTO.getEmp_ID()));
            if(ret.isDuplicate()){
                ret.setDuplicate(true);
                ret.setWhichList(0);
                break;
            }
            else {
                ret.setDuplicate(false);
            }
        }
        for(EmployeeDTO employee: duplicates){
            ret.setDuplicate(employee.getEmp_ID().equals(employeeDTO.getEmp_ID()));
            if(ret.isDuplicate()){
                ret.setDuplicate(true);
                ret.setWhichList(1);
                break;
            }
            else {
                ret.setDuplicate(false);
            }
        }
        return ret;
    }

    private DuplicateReturn checkIdForDuplicates(EmployeeDTO employee){
        // TODO: 26/02/2021
        // todo: also need to check corrupt arraylist
        int maxIndex = employees.size();
        int minIndex = 0;
        int midIndex;
        DuplicateReturn ret = new DuplicateReturn();
        while(maxIndex>minIndex){
            midIndex = (maxIndex+minIndex)/2;
            if(Integer.valueOf(employee.getEmp_ID()) == Integer.valueOf(employees.get(midIndex).getEmp_ID())){
                ret.setDuplicate(true);
                ret.setLocation(midIndex);
                break;
            }else if(Integer.valueOf(employee.getEmp_ID()) < Integer.valueOf(employees.get(midIndex).getEmp_ID())){
                //todo: employee id less than minIndex employee id
            }else{
                //todo: employee id more than minIndex employee id
            }
        }
        return ret;
    }

    private DuplicateReturn checkEmailforDuplicates(EmployeeDTO employee){
        // TODO: 26/02/2021
        //todo: also need to check corrupt arraylist
        DuplicateReturn ret = new DuplicateReturn();
        ret.setDuplicate(false);

        for(EmployeeDTO e: employees){
            if(e.getEmail().equals(employee.getEmail())){
                ret.setDuplicate(true);
                ret.setLocation(employees.indexOf(e));
                ret.setWhichList(0);
            }
//            if(Integer.valueOf(e.getEmp_ID())==Integer.valueOf(employee.getEmp_ID())){
//
//            }
        }
        for(EmployeeDTO e: duplicates){
            if(e.getEmail().equals(employee.getEmail())){
                ret.setDuplicate(true);
                ret.setLocation(employees.indexOf(e));
                ret.setWhichList(1);
            }
        }
        for(EmployeeDTO e: corrupt){
            if(e.getEmail().equals(employee.getEmail())){
                ret.setDuplicate(true);
                ret.setLocation(employees.indexOf(e));
                ret.setWhichList(2);
            }
        }

        return new DuplicateReturn();
    }

    public ArrayList<EmployeeDTO> getEmployees() {
        return employees;
    }

    public ArrayList<EmployeeDTO> getCorrupt() {
        return corrupt;
    }

    private class DuplicateReturn {
        private boolean duplicate;
        private int location;
        private int whichList;

        public boolean isDuplicate() {
            return duplicate;
        }

        public int getLocation() {
            return location;
        }

        public void setDuplicate(boolean duplicate) {
            this.duplicate = duplicate;
        }

        public void setLocation(int location) {
            this.location = location;
        }

        public int getWhichList() {
            return whichList;
        }

        public void setWhichList(int whichList) {
            this.whichList = whichList;
        }
    }

}
