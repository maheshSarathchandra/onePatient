package com.example.personalnote.service.impl;

import com.example.personalnote.Model.Note;
import com.example.personalnote.Repository.NoteRepository;
import com.example.personalnote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(String id, Long userId, Note note) {
        Note noteBefore = noteRepository.findAllByIdAndUserId(id, userId);
        String update = note.getContent();
        noteBefore.setContent(update);
        return noteRepository.save(noteBefore);
    }

    @Override
    public List<Note> getNoteList(Long userId, String status) {
        String notArchive = status;
        List<Note> noteList = noteRepository.findByUserIdAndArchive(userId, notArchive);
        return noteList;
    }


    @Override
    public Long deleteNote(String id, Long userId) {
        return noteRepository.deleteByIdAndUserId(id, userId);
    }

    @Override
    public Note updateArchiveStatus(String id, Long userId, String archiveStatus) {
        Note existingNote = noteRepository.findAllByIdAndUserId(id, userId);
        existingNote.setArchive(archiveStatus);
        return noteRepository.save(existingNote);

    }
}
