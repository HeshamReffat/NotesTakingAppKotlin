package com.hisham.noteappkotlin.repository

import com.hisham.noteappkotlin.database.NoteDatabase
import com.hisham.noteappkotlin.model.Note

class NoteRepository(private val database: NoteDatabase) {
    suspend fun insertNote(note: Note) = database.noteDao().insertNote(note)
    suspend fun deleteNote(note: Note) = database.noteDao().deleteNote(note)
    suspend fun updateNote(note: Note) = database.noteDao().updateNote(note)
    fun getAllNotes() = database.noteDao().getAllNote()
    fun searchNotes(query: String?) = database.noteDao().searchNote(query)
}