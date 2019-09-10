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
	
	@RequestMapping(method = RequestMethod.GET, value = "/notes/{name}/{direction}")
	public List getAllNotes(@PathVariable("name") String name, 
			@PathVariable("direction") String direction){
		return noteService.getAllNotes(name,direction);
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
	
	@RequestMapping(method = RequestMethod.PUT, value="/notes/{id}")
	public Note updateNote(@Valid @RequestBody Note note,@PathVariable Long id) {
		return noteService.updateNote(note,id);
	}
	@RequestMapping(method = RequestMethod.PUT, value="/notes/{id}/like")
	public void changeLiked(@PathVariable Long id) {
		noteService.changeLiked(id);
	}
}
