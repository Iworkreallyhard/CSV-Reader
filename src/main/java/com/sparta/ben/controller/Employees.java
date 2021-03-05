package com.sparta.ben.controller;

import com.sparta.ben.model.EmployeeDTO;

import java.util.ArrayList;
import java.util.Iterator;

public class Employees {

    private ArrayList<EmployeeDTO> employees = new ArrayList<>();
    private ArrayList<EmployeeDTO> corrupt = new ArrayList<>();
    private ArrayList<EmployeeDTO> duplicates = new ArrayList<>();

    private final int employeeListNum = 0;
    private final int duplicateListNum = 1;
    private final int corruptListNum = 2;

    public void addEmployees(EmployeeDTO[] newEmployees) {
        for (EmployeeDTO e : newEmployees) {
            addEmployee(e);
        }
    }

    public void addEmployees(ArrayList<EmployeeDTO> newEmployees) {
        for (EmployeeDTO e : newEmployees) {
            addEmployee(e);
        }
    }

    public void addEmployee(EmployeeDTO newEmployee) {
        boolean isCorruptTest = false;
        DuplicateReturn duplicateReturn;
        isCorruptTest = isCorrupt(newEmployee);
        duplicateReturn = isDuplicate(newEmployee);
        //todo:have to completely redo this now that whichlist has been removed and isDuplicate returns an array of booleans
        if (isCorruptTest == false && duplicateReturn.isDuplicate()[0] == false &&duplicateReturn.isDuplicate()[1] == false&&duplicateReturn.isDuplicate()[2] == false) {
            employees.add(newEmployee);
        } else if (isCorruptTest == true) {
            corrupt.add(newEmployee);
        } else {
            switch (duplicateReturn.whichList) {
                case employeeListNum://if it is in employees
                    duplicates.add(newEmployee);
                    duplicates.add(employees.get(duplicateReturn.getLocation()));
                    employees.remove(duplicateReturn.getLocation());
                    break;

                case duplicateListNum://if it is in duplicates
                    duplicates.add(newEmployee);
                    break;

                case corruptListNum://if it is in corrupt
                    //if one to be added is not corrupt, add it
                    duplicates.add(newEmployee);
                    break;
                case duplicateListNum+corruptListNum://if it is in both corrupt and duplicate
                    //todo
                    break;
            }
        }
    }

    private boolean isCorrupt(EmployeeDTO employeeDTO) {
        //todo - returns true if it is, false if not
        // TODO: 26/02/2021 what constitutes a corrupt file?
        return false;
    }

    private DuplicateReturn isDuplicate(EmployeeDTO employeeDTO) {
        //todo: check employee id and email address for duplicates
        DuplicateReturn ret = new DuplicateReturn();

        ret = checkEmailforDuplicates(employeeDTO);
        if(ret.isDuplicate()){
            return ret;
        }
        ret = checkIdForDuplicates(employeeDTO);

        return ret;
    }

    private DuplicateReturn checkIdForDuplicates(EmployeeDTO employee) {

        DuplicateReturn ret = new DuplicateReturn();
        ret.setDuplicate(false);

        ret = checkListForDuplicateIds(employees,employee);
        if(ret.isDuplicate()){
            ret.setWhichList(employeeListNum);
            return ret;
        }

        ret = checkListForDuplicateIds(duplicates,employee);
        if(ret.isDuplicate()){
            ret.setWhichList(duplicateListNum);
            return ret;
        }

        ret = checkListForDuplicateIds(corrupt,employee);
        if(ret.isDuplicate()){
            ret.setWhichList(corruptListNum);
            return ret;
        }

        return new DuplicateReturn();
    }
    //this is a next step. the intention is to use a binary search
//    private DuplicateReturn checkIdForDuplicates(EmployeeDTO employee) {
        // TODO: 26/02/2021
        // todo: also need to check corrupt and duplicates arraylist

//        int maxIndex = employees.size();
//        int minIndex = 0;
//        int midIndex;
//        DuplicateReturn ret = new DuplicateReturn();
//        ret.setDuplicate(false);
//        while (maxIndex > minIndex) {
//            midIndex = (maxIndex + minIndex) / 2;
//            if (Integer.valueOf(employee.getEmp_ID()) == Integer.valueOf(employees.get(midIndex).getEmp_ID())) {
//                ret.setDuplicate(true);
//                ret.setLocation(midIndex);
//                break;
//            } else if (Integer.valueOf(employee.getEmp_ID()) < Integer.valueOf(employees.get(midIndex).getEmp_ID())) {
//                maxIndex = midIndex-1;
//            } else {
//                minIndex=midIndex+1;
//            }
//        }
//        return ret;
//    }

    private DuplicateReturn checkEmailforDuplicates(EmployeeDTO employee) {
        // TODO: 26/02/2021
        //todo: also need to check corrupt arraylist
        DuplicateReturn ret = new DuplicateReturn();
        ret.setDuplicate(false);

        ret = checkListForDuplicateEmails(employees,employee);
        if(ret.isDuplicate()){
            ret.setWhichList(employeeListNum);
            return ret;
        }

        ret = checkListForDuplicateEmails(duplicates,employee);
        if(ret.isDuplicate()){
            ret.setWhichList(duplicateListNum);
            return ret;
        }

        ret = checkListForDuplicateEmails(corrupt,employee);
        if(ret.isDuplicate()){
            ret.setWhichList(corruptListNum);
            return ret;
        }

        return new DuplicateReturn();
    }

    private DuplicateReturn checkListForDuplicateEmails(ArrayList<EmployeeDTO> listToBeChecked,EmployeeDTO employee){

        DuplicateReturn ret = new DuplicateReturn();
        ret.setDuplicate(false);
        for (EmployeeDTO e : listToBeChecked) {
            if (e.getEmail().equals(employee.getEmail())) {
                ret.setDuplicate(true);
                ret.setLocation(listToBeChecked.indexOf(e));
            }
        }
        return ret;
    }

    private DuplicateReturn checkListForDuplicateIds(ArrayList<EmployeeDTO> listToBeChecked,EmployeeDTO employee){
        DuplicateReturn ret = new DuplicateReturn();
        ret.setDuplicate(false);

        for (EmployeeDTO e : listToBeChecked) {
            if(Integer.valueOf(e.getEmp_ID()).equals(Integer.valueOf(employee.getEmp_ID()))){
                ret.setDuplicate(true);
                ret.setLocation(listToBeChecked.indexOf(e));
            }
        }
        return ret;
    }

    public ArrayList<EmployeeDTO> getEmployees() {
        return employees;
    }

    public ArrayList<EmployeeDTO> getCorrupt() {
        return corrupt;
    }

    private class DuplicateReturn {
        private boolean[] duplicate = new boolean[3];//this means it can be a duplicate in multiple lists
        private int location;

        public boolean[] isDuplicate() {
            return duplicate;
        }

        public int getLocation() {
            return location;
        }

        public void setDuplicate(boolean duplicate,int index) {
            this.duplicate[index] = duplicate;
        }

        public void setLocation(int location) {
            this.location = location;
        }
    }

}
