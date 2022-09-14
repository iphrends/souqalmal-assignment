package com.souqalmal.dao;

import java.util.LinkedList;

import org.springframework.stereotype.Repository;

@Repository
public class InputData {
    private LinkedList<String> data;

    public InputData() {
        data = new LinkedList<>();
    }

    public LinkedList<String> getData() {
        return data;
    }

}
