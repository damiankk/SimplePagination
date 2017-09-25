package com.restprojects.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String id;

    private String name;

    private Integer age;

    private Date adddate;

    public Employee() {

    }

    public Employee(String id, String name, Integer age, Date adddate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.adddate = adddate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }
}
