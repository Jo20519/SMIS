package com.example.students.api



import com.example.students.model.StudentResultDto
import retrofit2.http.GET

// DTO already defined somewhere else
interface ApiService {
    @GET("/students/results")
    suspend fun getResults(): List<StudentResultDto>
}
