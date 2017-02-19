package com.pay4later.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 14:00
 * Class:       com.pay4later.model.User
 */
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User implements Comparable {

    private int userId;

    private String firstName;
    private String lastName;
    private String username;
    private String userType;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date lastLoginTime;

    public User() {
    }

    public User(int userId, String firstName, String lastName, String username, String userType) {

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.userType = userType;
    }

    /**
     * to use A string to parse the data
     *
     * @param lastLoginTime
     */
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
        return "User{" +
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
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getUserId() != user.getUserId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
            return false;
        if (getUserType() != null ? !getUserType().equals(user.getUserType()) : user.getUserType() != null)
            return false;
        return getLastLoginTime() != null ? getLastLoginTime().equals(user.getLastLoginTime()) : user.getLastLoginTime() == null;

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

    /**
     * @return list of user properties as String array
     */
    public String[] toStringArray() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        String[] usr = {
                String.valueOf(userId),
                firstName,
                lastName,
                username,
                userType,
                df.format(lastLoginTime)
        };

        return usr;
    }

    @Override
    public int compareTo(Object obj) {
        User user = (User) obj;
        return this.getUserId() - user.getUserId();
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
    @JacksonXmlProperty(localName = "surname")
    public String getLastName() {
        return lastName;
    }
    @JacksonXmlProperty(localName = "surname")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JacksonXmlProperty(localName = "type")
    public String getUserType() {
        return userType;
    }
    @JacksonXmlProperty(localName = "type")
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//        try {
//            Date d = df.parse(lastLoginTime);
//            this.lastLoginTime = df.parse(lastLoginTime);
//        } catch (ParseException pse) {
//            pse.printStackTrace();
//            System.exit(-1);
//        }

        this.lastLoginTime = lastLoginTime;

    }

}
