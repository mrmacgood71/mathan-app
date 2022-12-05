package it.macgood.mathanapp.data

import it.macgood.mathanapp.data.datasource.ExerciseDto
import it.macgood.mathanapp.domain.model.Task
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MathAnalysisApi {
    @GET("/api/v1/demidovich")
    suspend fun getExercises(): List<ExerciseDto>
    @GET("/api/v1/demidovich/{id}")
    suspend fun getExercise(@Path("id") id: String): ExerciseDto
    @GET("/api/v1/demidovich/{id}")
    suspend fun getExercise1(@Path("id") id: String): Response<ExerciseDto>

}