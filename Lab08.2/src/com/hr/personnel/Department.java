/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.hr.personnel;

/**
 * The Department class manages employees.
 *
 * Properties:
 *   String name
 *   String location
 *   Employee[] employees  the Employees in this department.
 *   int currentIndex      internal counter for number of employees in the department.
 *
 * Methods (excluding get/set methods):
 *   void listEmployees()  print info on all employees in the department.
 *   void workEmployees()  make all employees in the department work.
 *   String toString()     self-explanatory.
 */
public class Department {
    // fields
    private String name;
    private String location;
    private final Employee[] employees = new Employee[100];
    private int currentIndex = 0;  // for dealing with the array

    // constructors
    //none of the IS-A relationships are mentioned here, ie no hourly employee/salaried employee ctor
    public Department() {
        //super(); calls super weather typed or not
    }

    public Department(String name, String location) {
        setName(name);
        setLocation(location);
    }

    // helper method to add an Employee to the array
    public void addEmployee(Employee emp) {
        employees[currentIndex++] = emp;
    }

    // business, action, methods
    public void listEmployees() {
        // Note: we don't use for-each here because we only want to access the array where employees were added.
        // Question: what is in the array for indices where no Employee was added?  null!
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(employees[i]);  // toString() automatically called
        }
    }

    public void workEmployees() {
        for (int i = 0; i < currentIndex; i++) {
            employees[i].work();
        }
    }

    public void payEmployees(){
        for (int i = 0; i < currentIndex; i++){
            employees[i].pay();
        }
    }

    /*
     * "Forced" vacation
     */
    public void takeVacation(){
        for (int i = 0; i < currentIndex; i++){
            //if employees[i] is pointing to a SalariedEmployee
            //downcast reference to a type SalariedEmployee
           if (employees[i] instanceof SalariedEmployee){
               //downcast and method call in one line
           //    ((SalariedEmployee) employees[i]).takeVacation();

               //explicit downcast to new reference 'semp'
               SalariedEmployee semp = (SalariedEmployee) employees[i];
               semp.takeVacation();
            }
        }
    }

    // accessor methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}