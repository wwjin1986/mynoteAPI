package com.weiweijin.myNoteAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weiweijin.myNoteAPI.Model.Note;
import com.weiweijin.myNoteAPI.repository.NoteRepository;

@Service
public class NoteService {
	@Autowired
	private NoteRepository noteRepository;
	
	public List getAllNotes() {
		return noteRepository.findAll();
	}
	
	public Note addNote(Note note) {
		return noteRepository.save(note);
	}

}