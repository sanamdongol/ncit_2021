package com.ncit.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cook {
    @PrimaryKey
    int id;
    String name;
    String address;
    String specialCooking;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialCooking() {
        return specialCooking;
    }

    public void setSpecialCooking(String specialCooking) {
        this.specialCooking = specialCooking;
    }
}
