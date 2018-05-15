package com.example.easynotes.controller;

import com.example.easynotes.model.Note;
import com.example.easynotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * User: FERREL JOHN FERNANDO
 * Date: 15/05/2018.
 * Time: 15:17.
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DemoController {

    @Autowired
    NoteService noteService;

    @RequestMapping(value = "/")
    public String noteList(Model model) {
        model.addAttribute("noteList", noteService.findAll());
        return "noteList";
    }

    @RequestMapping(value = {"/noteEdit","/noteEdit/{id}"}, method = RequestMethod.GET)
    public String noteEditForm(Model model, @PathVariable(required = false, name = "id") Long id) {
        if (id != null) {
            model.addAttribute("note", noteService.findOne(id));
        } else {
            model.addAttribute("note", new Note());
        }

        return "noteEdit";
    }

    @RequestMapping(value = "/noteEdit", method = RequestMethod.POST)
    public String noteEdit(Model model, Note note) {
        noteService.saveNotes(note);

        model.addAttribute("noteList", noteService.findAll());

        return "noteList";
    }

    @RequestMapping(value = "/noteDelete/{id}", method = RequestMethod.GET)
    public String noteDelete(Model model, @PathVariable(required = false, name = "id") Long id) {
        noteService.deleteNote(id);

        model.addAttribute("noteList", noteService.findAll());

        return "noteList";
    }
}