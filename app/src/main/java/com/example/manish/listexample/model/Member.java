package com.example.manish.listexample.model;

/**
 * Created by Manish on 9/11/2017.
 */

public class Member {
    public Member(String name,String age,String gender,String image,String contactnumber)
    {
        this.name =name;
        this.age = age;
        this.gender = gender;
        this.image =image;
        this.contact_number =contactnumber;
    }
    String name;
    String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    String gender;
    String image;
    String contact_number;
}
