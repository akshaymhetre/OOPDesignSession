package com.akshay.session;

public class Employee {
    private final int id;
    private String name;
    private Designation designation;

    public Employee(int id, String name, Designation designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    public void promote() {
        this.designation = this.designation.getNext();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }
}

enum Designation {
    SE("Software Engineer"), SSE("Senior Software Engineer"), CONSULTANT("Consultant");
    private final String value;

    Designation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Designation getNext(){
        Designation[] values = Designation.values();
        Designation currentDesignation = this;
        return values[(currentDesignation.ordinal()+1)% values.length];
    }
}
