package com.example.students.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.students.database.AppDatabase
import com.example.students.model.Student
import com.example.students.repository.StudentRepository
import kotlinx.coroutines.launch

class StudentsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: StudentRepository
    val allStudents: LiveData<List<Student>>

    init {
        val dao = AppDatabase.getInstance(application).studentDao()
        repository = StudentRepository(dao)
        allStudents = repository.allStudents
    }

    fun insert(student: Student) = viewModelScope.launch {
        repository.insert(student)
    }

    suspend fun getAllStudentsNow(): List<Student> {
        return repository.getAllStudentsNow()
    }


}
