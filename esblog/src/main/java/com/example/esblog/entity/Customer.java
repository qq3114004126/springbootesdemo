package com.example.esblog.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Arrays;

@Document(indexName = "customer",type = "customer",shards = 1,replicas = 0,refreshInterval = "-1")
public class Customer {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String[] arr;

    public Customer() {
    }

    public Customer(String id, String firstName, String lastName, String[] arr) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.arr = arr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}