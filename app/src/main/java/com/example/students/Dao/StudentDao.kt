package com.example.students.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.students.model.Student

@Dao
interface StudentDao {

    @Insert
    suspend fun insert(student: Student): Long

    // Use this for observing the list in the UI
    @Query("SELECT * FROM students")
    fun getAllStudents(): LiveData<List<Student>>

    // Use this for one-time fetch in reports
    @Query("SELECT * FROM students")
    suspend fun getAllStudentsNowSimple(): List<Student>
}
