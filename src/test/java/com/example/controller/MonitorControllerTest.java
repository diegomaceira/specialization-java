package com.example.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class MonitorControllerTest {

    static MonitorController monitorController;

    @BeforeAll
    static void init(){
        monitorController = new MonitorController();
    }

    @Test
    void executeThreads() throws InterruptedException {
        assertEquals(ResponseEntity.ok("OK"),monitorController.executeThreads());
    }
}