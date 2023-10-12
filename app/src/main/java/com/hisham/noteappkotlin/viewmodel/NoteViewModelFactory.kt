package com.hisham.noteappkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hisham.noteappkotlin.repository.NoteRepository

class NoteViewModelFactory(
    private val application: Application,
    private val noteRepository: NoteRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(application, noteRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}