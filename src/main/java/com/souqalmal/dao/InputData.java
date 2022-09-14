package com.souqalmal.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class InputData {
    private List<String> data;

    public InputData() {
        data = new ArrayList<>();
    }

    public List<String> getData() {
        return data;
    }

}
