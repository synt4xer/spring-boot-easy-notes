package com.example.easynotes.service;

import com.example.easynotes.model.Note;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: FERREL JOHN FERNANDO
 * Date: 15/05/2018.
 * Time: 14:52.
 * To change this template use File | Settings | File Templates.
 */
public interface NoteService {
    List<Note> findAll();

    Note findOne(Long id);

    Note saveNotes(Note note);

    void deleteNote(Long id);
}
