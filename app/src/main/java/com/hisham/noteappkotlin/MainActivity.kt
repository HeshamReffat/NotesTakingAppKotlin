package com.hisham.noteappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.ViewModelProvider
import com.hisham.noteappkotlin.database.NoteDatabase
import com.hisham.noteappkotlin.databinding.ActivityMainBinding
import com.hisham.noteappkotlin.repository.NoteRepository
import com.hisham.noteappkotlin.viewmodel.NoteViewModel
import com.hisham.noteappkotlin.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var noteViewModel: NoteViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar(binding.toolBar)
        setUpViewModel()
    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelFactory = NoteViewModelFactory(application,noteRepository);
        noteViewModel = ViewModelProvider(this,viewModelFactory)[NoteViewModel::class.java]
    }
}