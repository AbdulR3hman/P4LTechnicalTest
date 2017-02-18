package com.pay4later.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 14:00
 * Class:       com.pay4later.model.Person
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Person {

    private int userId;

    private String firstName;
    private String lastName;
    private String username;
    private String userType;

    private Date lastLoginTime;

    public Person() {
    }

    public Person(int userId, String firstName, String lastName, String username, String userType) {

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        try {
            Date d = df.parse(lastLoginTime);
            this.lastLoginTime = df.parse(lastLoginTime);
        } catch (ParseException pse) {
            pse.printStackTrace();
            System.exit(-1);
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", userType='" + userType + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getUserId() != person.getUserId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(person.getFirstName()) : person.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(person.getLastName()) : person.getLastName() != null)
            return false;
        if (getUsername() != null ? !getUsername().equals(person.getUsername()) : person.getUsername() != null)
            return false;
        if (getUserType() != null ? !getUserType().equals(person.getUserType()) : person.getUserType() != null)
            return false;
        return getLastLoginTime() != null ? getLastLoginTime().equals(person.getLastLoginTime()) : person.getLastLoginTime() == null;

    }

    @Override
    public int hashCode() {
        int result = getUserId();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getUserType() != null ? getUserType().hashCode() : 0);
        result = 31 * result + (getLastLoginTime() != null ? getLastLoginTime().hashCode() : 0);
        return result;
    }
}
