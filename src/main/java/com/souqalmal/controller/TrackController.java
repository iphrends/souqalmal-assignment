package com.souqalmal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.souqalmal.dto.PostTrackRequest;
import com.souqalmal.service.TrackService;

@RestController
@RequestMapping("/track")
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping(value = "/trackValue", produces = MediaType.APPLICATION_JSON_VALUE)
    public String postTrack(@Valid @RequestBody PostTrackRequest request) {
        final String value = trackService.postTrack(request.input());
        return "{\"output\": \"" + value + "\"}";
    }

    @GetMapping("/getHistory")
    public String getHistory() {
        return "null";
    }
}
