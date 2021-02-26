package com.sparta.ben.controller.attributes;

import java.util.ArrayList;

public class AttributeController {
    private static ArrayList<Attribute> attributeList = new ArrayList<>();
    private static ArrayList<String> attributeNames = new ArrayList<>();

    public AttributeController() {

    }

    public static void setUpAttributeList(){
        attributeList.add(new Attribute(1,"emp_ID"));
        attributeList.add(new Attribute(2,"namePrefix"));
        attributeList.add(new Attribute(3,"firstName"));
        attributeList.add(new Attribute(4,"middleInit"));
        attributeList.add(new Attribute(5,"lastName"));
        attributeList.add(new Attribute(6,"gender"));
        attributeList.add(new Attribute(7,"Email"));
        attributeList.add(new Attribute(8,"Date.valueOf(dateOfBirth)"));
        attributeList.add(new Attribute(9,"Date.valueOf(dateOfJoining)"));
        attributeList.add(new Attribute(10,"salary"));
    }
}
//        preparedStatement.setString(1,emp_ID);
//        preparedStatement.setString(2,namePrefix);
//        preparedStatement.setString(3,firstName);
//        preparedStatement.setString(4,middleInit);
//        preparedStatement.setString(5,lastName);
//        preparedStatement.setString(6,gender);
//        preparedStatement.setString(7,Email);
//        preparedStatement.setDate(8, Date.valueOf(dateOfBirth));
//        preparedStatement.setDate(9, Date.valueOf(dateOfJoining));
//        preparedStatement.setInt(10,salary);