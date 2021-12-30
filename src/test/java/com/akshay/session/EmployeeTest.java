package com.akshay.session;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void shouldWork(){
        Employee akshay = new Employee(1, "akshay", Designation.SE);
        assertEquals(Designation.SE, akshay.getDesignation());
    }
}