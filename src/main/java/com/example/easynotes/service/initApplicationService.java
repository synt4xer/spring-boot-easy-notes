package com.example.easynotes.service;

import com.example.easynotes.model.Note;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: FERREL JOHN FERNANDO
 * Date: 15/05/2018.
 * Time: 15:09.
 * To change this template use File | Settings | File Templates.
 */
public class initApplicationService {
    private static final Logger mLogger = (Logger) LoggerFactory.getLogger(initApplicationService.class);

    @Autowired
    NoteService noteService;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeTestData() {
        mLogger.info("Initialize test data!");

        noteService.saveNotes(new Note("First Note","Content 1 default"));
        noteService.saveNotes(new Note("Second Note", "Content 2 default"));

        mLogger.info("Initialization Complete!");
    }
}
