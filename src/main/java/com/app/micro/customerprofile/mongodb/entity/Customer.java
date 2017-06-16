package com.app.micro.customerprofile.mongodb.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer implements Serializable {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 5448234876798038908L;
    Integer id;
    @Id
    String _mongoid;
    String title;
    String firstName;
    String lastName;
    String dateOfBirth;
    String nationality;
    String preferredLanguage;
    String profileCompleteness;
    @Indexed(unique = true)
    int skywardNumber;
    String tier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getProfileCompleteness() {
        return profileCompleteness;
    }

    public void setProfileCompleteness(String profileCompleteness) {
        this.profileCompleteness = profileCompleteness;
    }

    public int getSkywardNumber() {
        return skywardNumber;
    }

    public void setSkywardNumber(int skywardNumber) {
        this.skywardNumber = skywardNumber;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

}
