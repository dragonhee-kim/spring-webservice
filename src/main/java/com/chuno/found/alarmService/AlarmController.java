package com.chuno.found.alarmService;


import com.chuno.found.noticeService.AndroidPushPeriodicNotifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/alarm")
public class AlarmController {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AlarmService alarmService;




}
