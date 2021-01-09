package com.example.personalnote.Controller;

import com.example.personalnote.Model.Note;
import com.example.personalnote.Repository.NoteRepository;
import com.example.personalnote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class NoteController {


    @Autowired
    NoteService noteService;


    /* this method save the notes */
    @PostMapping("/note")
    public String saveNote(@Valid @RequestBody Note patient) {

        return noteService.createNote(patient).getId();
    }

    /* this method update the note */
    @PostMapping(value = "/note/{id}/{userId}")
    public Note updateSavedNote(@PathVariable("id") String id, @PathVariable("userId") Long userId,
                                @Valid @RequestBody Note note) {
        return noteService.updateNote(id, userId, note);
    }

    /* this delete the note for specific user and specific id */
    @DeleteMapping("/note/{id}/{userId}")
    public Long deleteNote(@PathVariable("id") String id, @PathVariable("userId") Long userId) {

        return noteService.deleteNote(id, userId);
    }

    /* this method update the note */
    @PostMapping("/note/{id}/{userId}/{archiveStatus}")
    public Note updateArchiveStatus(@PathVariable("id") String id, @PathVariable("userId") Long userId,
                                    @PathVariable("archiveStatus") String archiveStatus) {
        return noteService.updateArchiveStatus(id, userId, archiveStatus);
    }


    /*this method get archive or not archive list for specific user */
    @GetMapping("/note/{userId}/{status}")
    public List<Note> GetNoteFromArchiveStatus(@PathVariable("userId") Long userId,
                                               @PathVariable("status") String status) {
        return noteService.getNoteList(userId, status);
    }

}
