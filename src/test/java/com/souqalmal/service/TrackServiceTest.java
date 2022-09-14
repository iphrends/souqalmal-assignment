package com.souqalmal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.souqalmal.dao.InputData;

public class TrackServiceTest {

    private TrackService service;

    @BeforeEach
    public void setUp() {
        service = new TrackService(new InputData());
    }

    @ParameterizedTest
    @ValueSource(strings = { "1", "2", "3", "4", "5", "6" })
    public void postTrackDataTest(String input) {

        service.postTrack(input);

        assertFalse(service.getData().isEmpty());

    }

    @Test
    public void postTrackTest() {

        assertTrue(service.getData().isEmpty());

        String output = service.postTrack("1");

        assertFalse(service.getData().isEmpty());
        assertNull(output);

        output = service.postTrack("12");

        assertFalse(service.getData().isEmpty());
        assertNotNull(output);
        Assertions.assertEquals("1", output);
    }

    @Test
    public void getHistoryTest() {
        service.getData().addFirst("1");
        service.getData().addFirst("12");
        service.getData().addFirst("123");
        service.getData().addFirst("1234");
        service.getData().addFirst("12345");

        List<String> history = service.getHistory();

        assertEquals(5, history.size());
        assertEquals("12345", history.get(0));
        assertEquals("1234", history.get(1));
        assertEquals("123", history.get(2));
        assertEquals("12", history.get(3));
        assertEquals("1", history.get(4));
    }

    @Test
    public void getHistoryMoreThan10ElementsTest() {
        service.getData().addFirst("1");
        service.getData().addFirst("12");
        service.getData().addFirst("123");
        service.getData().addFirst("1234");
        service.getData().addFirst("12345");
        service.getData().addFirst("123456");
        service.getData().addFirst("1234567");
        service.getData().addFirst("12345678");
        service.getData().addFirst("123456789");
        service.getData().addFirst("12345678910");
        service.getData().addFirst("1234567891011");

        List<String> history = service.getHistory();

        assertEquals(10, history.size());
        assertEquals("1234567891011", history.get(0));
        assertEquals("12345678910", history.get(1));
        assertEquals("123456789", history.get(2));
        assertEquals("12345678", history.get(3));
        assertEquals("1234567", history.get(4));

        final String output = service.postTrack("input");

        assertEquals("1234567891011", output);

        history = service.getHistory();
        assertEquals("input", history.get(0));
        assertEquals("1234567891011", history.get(1));
        assertEquals("12345678910", history.get(2));
        assertEquals("123456789", history.get(3));
        assertEquals("12345678", history.get(4));
        assertEquals("1234567", history.get(5));
    }
}
