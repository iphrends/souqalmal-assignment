package com.souqalmal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.souqalmal.dao.InputData;

@Service
public class TrackService {

    private final InputData inputData;
    private List<String> data;

    public TrackService(InputData inputData) {
        this.inputData = inputData;
        this.data = inputData.getData();
    }

    public String postTrack(final String input) {
        String output = "null";
        if (!this.data.isEmpty()) {
            output = this.data.get(data.size() - 1);
        }
        this.data.add(input);
        return output;
    }
    

}
