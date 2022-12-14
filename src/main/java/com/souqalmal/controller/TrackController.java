package com.souqalmal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<String> getHistory() {
        if (trackService.getData().size() < 10) {
            return trackService.getData();
        }

        return trackService.getData().subList(0, 10);
    }

    @GetMapping("/clear")
    public void clear() {
        trackService.clear();
    }
}
