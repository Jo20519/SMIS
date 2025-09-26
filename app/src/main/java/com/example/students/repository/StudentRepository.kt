package com.example.students.repository

import androidx.lifecycle.LiveData
import com.example.students.Dao.StudentDao
import com.example.students.model.Student

class StudentRepository (private val studentDao: StudentDao){
    // Get all students as LiveData
    val allStudents: LiveData<List<Student>> = studentDao.getAllStudents()

    // Insert a new student (suspend function for coroutines)
    suspend fun insert(student: Student) {
        studentDao.insert(student)
    }

    // Get all students immediately (for report)
    suspend fun getAllStudentsNow(): List<Student> {
        return studentDao.getAllStudentsNowSimple()
    }


    // Placeholder for Retrofit API calls (can add later)
}
