package com.example.personalnote.Repository;

import com.example.personalnote.Model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note,String> {

    @Query("{ 'id': ?0, 'userId': ?1}")
    Note findAllByIdAndUserId(String id, Long userId);

    @Query("{'userId': ?0, 'archive': ?1}")
    List<Note> findByUserIdAndArchive(Long userId,String archive);

    Long deleteByIdAndUserId(String id, Long userId);
}
