package com.swisscode.addressbook.addressbook.entity;

import java.util.List;

public class Information
{
    String identifier;
    List<String[]> data;

    public Information(String identifier, List<String[]> data) {
        this.identifier = identifier;
        this.data = data;
    }

    public Information() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<String[]> getData() {
        return data;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }
}
