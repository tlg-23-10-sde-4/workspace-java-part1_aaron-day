package com.hr.personnel;

import gov.irs.TaxPayer;

import java.time.LocalDate;

//supported types: Object, Dept, Employee, TaxPayer

public class SalariedEmployee
        extends Employee{
    //field
    private double salary;
    private static final double STANDARD_DEDUCTION = 10_000;

    //ctor
    public SalariedEmployee() {
        //super(); calls super weather typed or not
    }

    public SalariedEmployee(String name, LocalDate hireDate) {
        super(name, hireDate);
    }

    public SalariedEmployee(String name, LocalDate hireDate, double salary){
        this(name, hireDate);
        setSalary(salary);
    }

    //action methods
    @Override
    public void pay(){
        System.out.println(getName() + " is paid salary " + getSalary());
    }

    public void takeVacation(){
        System.out.println(getName() + " is on vacation");
    }

    @Override
    public void payTaxes(){
        double taxes = salary * TaxPayer.SALARIED_TAX_RATE;
        System.out.println(getName() + " has paid taxes of " + taxes);
    }

    @Override
    public double getStandardDeduction() {
        return STANDARD_DEDUCTION;
    }

    //get&set
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", salary=" + getSalary();
    }
}
