package com.example.demo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

/**
 * Created by river on 2017/7/18.
 */
//指定集合名字，否则默认为类名
@Document(collection = "CarTest")
public class Car {

    @Id
    private Integer id;
    private String owner;
    private int[] location;


    public Car(Integer id,String owner,int[] location){
        this.id=id;
        this.owner=owner;
        this.location=location;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", location=" + Arrays.toString(location) +
                '}';
    }
}
