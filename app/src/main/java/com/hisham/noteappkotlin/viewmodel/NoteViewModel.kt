package com.hisham.noteappkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hisham.noteappkotlin.model.Note
import com.hisham.noteappkotlin.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(
    private val application: Application,
    private val noteRepository: NoteRepository
) : AndroidViewModel(application) {
    fun insertNote(note: Note) {
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }

    fun getAllNotes() = noteRepository.getAllNotes()
    fun searchNotes(keyword: String?) = noteRepository.searchNotes(keyword)

}