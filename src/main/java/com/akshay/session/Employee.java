package com.akshay.session;

import java.util.Set;

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

interface SalaryPay {
    double getMonthlyGrossedSalary();
    double getMonthlyFixedSalary();
}

class InternalEmployee extends Employee implements Promotable {
    SalaryPay salaryPay;
    public InternalEmployee(int id, String name, Designation designation, SalaryPay salaryPay) {
        super(id, name, designation);
        this.salaryPay = salaryPay;
    }

    @Override
    public void promote() {
        this.setDesignation(this.getDesignation().getNext());
    }

    public double getSalary(){
        return salaryPay.getMonthlyGrossedSalary();
    }
}

class ExternalEmployee extends Employee implements Promotable {
    SalaryPay salaryPay;
    public ExternalEmployee(int id, String name, Designation designation, SalaryPay salaryPay) {
        super(id, name, designation);
        this.salaryPay = salaryPay;
    }

    @Override
    public void promote() {
        this.setDesignation(this.getDesignation().getNext());
    }

    public double getSalary(){
        return salaryPay.getMonthlyGrossedSalary();
    }
}

interface Taxable {
    double getTax(double amount);
}

class IndianTax implements Taxable {
    Set<Deduction> deductions;
    @Override
    public double getTax(double amount) {
        // deduciton
        return 0;
    }
}
class FixedSalaryPay implements SalaryPay {
    double basePay;
    Taxable taxable;

    public FixedSalaryPay(double basePay, Taxable taxable) {
        this.basePay = basePay;
        this.taxable = taxable;
    }

    @Override
    public double getMonthlyGrossedSalary() {
        return basePay;
    }

    @Override
    public double getMonthlyFixedSalary() {
        double monthlyGrossedSalary = getMonthlyGrossedSalary();
        return monthlyGrossedSalary -taxable.getTax(monthlyGrossedSalary);
    }
}

class HourlySalaryPay implements SalaryPay {
    double hourlyRate;
    @Override
    public double getMonthlyGrossedSalary() {
        return 0;
    }

    @Override
    public double getMonthlyFixedSalary() {
        return 0;
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
