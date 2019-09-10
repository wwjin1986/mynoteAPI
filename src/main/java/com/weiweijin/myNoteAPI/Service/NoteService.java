package com.weiweijin.myNoteAPI.Service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weiweijin.myNoteAPI.Model.Note;
import com.weiweijin.myNoteAPI.Repository.NoteRepository;

@Service
public class NoteService {
	@Autowired
	private NoteRepository noteRepository;
	
	public List getAllNotes() {
		return noteRepository.findAll(orderByIdAsc());
	}
	
	public Note addNote(Note note) {
		return noteRepository.save(note);
	}
	
	public Note getNoteByID(Long id) {
		return noteRepository.findById(id).orElse(null);
	}
	public void deleteNoteByID(Long id) {
		noteRepository.deleteById(id);
	}
	public void changeLiked(Long id) {
		Note note = noteRepository.findById(id).orElse(null);
		if (note.getLiked() == null) 
		{
			note.setLiked(true);
		}else {
			note.setLiked(!note.getLiked());
		}
		noteRepository.save(note);
	}
	private Sort orderByIdAsc() {
		return new Sort(Sort.Direction.ASC,"id");
				
	}

}
