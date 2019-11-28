package model;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.time.*;

public class Worker {
    /**
     * First name of Worker
     * */
    private String fName;
    /**
     * Last name of Worker
     * */
    private String lName;
    /**
     * Birth date of Worker
     * */
    private LocalDate bDay;

    /**
     * Information about Worker Salary
     * */
    private float salary;
    /**
     * Information about Worker Position
     * */
    private String position;

    /**
     * Information about Worker Address
     * */
    private  String address;
    /**
     * Information about Worker Phone
     * */
    private  String phone;

    /**
     * Basic constructor of Worker object
     * */
    Worker(){
        fName = "John";
        lName = "Doe";
        bDay = LocalDate.of(1999,11,12);

        salary = 0.0f;
        position = "Tester";

        address = "Test Hometown";
        phone = "+38(05)08-83-4011";
    }

    public Worker(String fName, String lName, LocalDate bDay, float salary, String position, String address, String phone) {
        this.fName = fName;
        this.lName = lName;
        this.bDay = bDay;
        this.salary = salary;
        this.position = position;
        this.address = address;
        this.phone = phone;
    }

    /**
     * GETTER / SETTER
     */

    public String getFirstName(){
        return fName;
    }
    public String getLastName(){
        return lName;
    }
    public LocalDate getBirthDay(){
        return bDay;
    }
    public float getSalary(){
        return salary;
    }
    public String getPosition(){
        return position;
    }
    public String getAddress(){
        return address;
    }
    public String getPhone(){
        return phone;
    }


    public int getYear(){
        return this.bDay.getYear();
    }

    public void changeName(String firstName, String lastName){
        fName = firstName;
        lName = lastName;
    }

    public float calculateSalary(float taxes){
        if(salary-taxes > 0){
            return salary-taxes;
        }
        else{
            return -1;
        }
    }
    public String getInfo(){
        return(
                "First Name: " + getFirstName() +
                "\nLast Name:" + getLastName() +
                "\nBirth Day: " + getBirthDay() +
                "\nPosition: " + getPosition() +
                "\nSalary: " + getSalary()
        );
    }

    public String howToFind(){
        return (
                "Location: " + getAddress()+
                "\nContact Phone: " + getPhone()
        );
    }
    public String getFullName(){
        return (getFirstName() + " " + getLastName());
    }

    public static final class Builder {
        private String fName;
        private String lName;
        private LocalDate bDay;
        private float salary;
        private String position;
        private  String address;
        private  String phone;

        public Builder() {
        }

        public static Builder aWorker() {
            return new Builder();
        }

        public Builder setFName(String fName) {
            this.fName = fName;
            return this;
        }

        public Builder setLName(String lName) {
            this.lName = lName;
            return this;
        }

        public Builder setBDay(LocalDate bDay) {
            this.bDay = bDay;
            return this;
        }

        public Builder setSalary(float salary) {
            this.salary = salary;
            return this;
        }

        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Worker build() {
            return new Worker(fName, lName, bDay, salary, position, address, phone);
        }
    }
}
