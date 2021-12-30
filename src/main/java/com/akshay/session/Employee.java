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

interface Promotable {
    void promote();
}

class InternalEmployee extends Employee implements Promotable{
    public InternalEmployee(int id, String name, Designation designation) {
        super(id, name, designation);
    }

    @Override
    public void promote() {
        this.setDesignation(this.getDesignation().getNext());
    }
}


class ExternalEmployee extends Employee {
    public ExternalEmployee(int id, String name, Designation designation) {
        super(id, name, designation);
    }
}

// class SpecialEmployee extends Employee implements Promotable

class PromotionService {
    public static void promote(Employee employee) {
        if(!employee.getDesignation().equals(Designation.CONSULTANT))
            employee.setDesignation(employee.getDesignation().getNext());
        //else if(true)

        //else if(true)
        //else if(true)
        //else

    }
}

enum Designation {
    SE("Software Engineer"), SSE("Senior Software Engineer"), CONSULTANT("Consultant"), SPECIAL("Special");
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
