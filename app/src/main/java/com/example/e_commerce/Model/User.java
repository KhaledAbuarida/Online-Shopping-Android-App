package com.example.e_commerce.Model;

public class User implements Cloneable {
    private int id;
    private String name, email, password, gender, job, birthdate;

    private static User user = null;

    private User() {}

    // TODO: SINGLETON DESIGN PATTERN
    public static User getInstance() {
        if (user == null)
            user = new User();
        return user;
    }
    public void initialize(int id, String name, String email, String password, String gender, String job,String birthdate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender= gender;
        this.birthdate= birthdate;
        this.job=job;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
