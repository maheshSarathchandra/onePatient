package com.example.personalnote.service;

import com.example.personalnote.Model.Note;

import java.util.List;

public interface NoteService {

    Note createNote(Note note);
    Note updateNote(String id,Long userId,Note note);
    List<Note> getNoteList(Long userId,String status);
    Long deleteNote(String id, Long userId);
    Note updateArchiveStatus(String id, Long userId, String archiveStatus);
}
