package com.petclinic.persistence.model;

public class VetModel extends Model {

    private String firstName;
    private String lastName;
    private String speciality;
    private String address;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getAddress() {
        return address;
    }
}
