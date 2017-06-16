package com.app.micro.customerprofile.domain;

public class Customer {
    int id;
    String title;
    String firstName;
    String lastName;
    String dateOfBirth;
    String nationality;
    String preferredLanguage;
    String profileCompleteness;
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

    public static com.app.micro.customerprofile.mongodb.entity.Customer createMongoObject(Customer customer) {
        com.app.micro.customerprofile.mongodb.entity.Customer customerMongo = new com.app.micro.customerprofile.mongodb.entity.Customer();

        customerMongo.setTitle(customer.title);
        customerMongo.setFirstName(customer.firstName);
        customerMongo.setLastName(customer.lastName);
        customerMongo.setDateOfBirth(customer.dateOfBirth);
        customerMongo.setNationality(customer.nationality);
        customerMongo.setPreferredLanguage(customer.preferredLanguage);
        customerMongo.setProfileCompleteness(customer.profileCompleteness);
        customerMongo.setSkywardNumber(customer.skywardNumber);
        customerMongo.setTier(customer.tier);

        return customerMongo;
    }

    public static Customer createObject(com.app.micro.customerprofile.mongodb.entity.Customer customerMongo) {
        Customer customer = new Customer();

        customer.setTitle(customerMongo.getTitle());
        customer.setFirstName(customerMongo.getFirstName());
        customer.setLastName(customerMongo.getLastName());
        customer.setDateOfBirth(customerMongo.getDateOfBirth());
        customer.setNationality(customerMongo.getNationality());
        customer.setPreferredLanguage(customerMongo.getPreferredLanguage());
        customer.setProfileCompleteness(customerMongo.getProfileCompleteness());
        customer.setSkywardNumber(customerMongo.getSkywardNumber());
        customer.setTier(customerMongo.getTier());
        customer.setId(customerMongo.getId());

        return customer;
    }

}
