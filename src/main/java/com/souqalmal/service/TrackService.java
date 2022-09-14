package com.souqalmal.service;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.souqalmal.dao.InputData;

@Service
public class TrackService {

    private LinkedList<String> data;

    public LinkedList<String> getData() {
        return data;
    }

    public TrackService(InputData inputData) {
        this.data = inputData.getData();
    }

    /**
     * Add input to memory
     * 
     * @param input stored in memory
     * @return previously added element
     */
    public String postTrack(final String input) {
        String output = null;
        if (!this.data.isEmpty()) {
            final ListIterator<String> itr = this.data.listIterator();
            if (itr.hasNext()) {
                output = itr.next();
            }
        }

        this.data.addFirst(input);

        return output;
    }

    /**
     * @return List of last 10 elements (if any) in added order
     */
    public List<String> getHistory() {

        if (this.data.size() < 10) {
            return this.data;
        }

        return this.data.subList(0, 10);

    }

    public void clear() {
        data.clear();
    }

}
