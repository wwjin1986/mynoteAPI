package com.weiweijin.myNoteAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weiweijin.myNoteAPI.Model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{

}
