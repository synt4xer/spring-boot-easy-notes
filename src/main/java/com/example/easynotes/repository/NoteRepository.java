package com.example.easynotes.repository;

import com.example.easynotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: FERREL JOHN FERNANDO
 * Date: 15/05/2018.
 * Time: 12:09.
 * To change this template use File | Settings | File Templates.
 */

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
