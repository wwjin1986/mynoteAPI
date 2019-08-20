package com.weiweijin.myNoteAPI.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.weiweijin.myNoteAPI.Model.Note;
import com.weiweijin.myNoteAPI.Service.NoteService;

@RestController
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/notes")
	public List getAllNotes() {
		return noteService.getAllNotes();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/notes")
	public Note addNote(@Valid @RequestBody Note note) {
		return noteService.addNote(note);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/notes/{id}")
	public void deleteNoteByID(@PathVariable Long id) {
		noteService.deleteNoteByID(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/notes/{id}")
	public Note getNoteByID(@PathVariable Long id) {
		return noteService.getNoteByID(id);
	}
}
