package it.macgood.mathanapp.domain.repository

import it.macgood.mathanapp.data.datasource.ExerciseDto
import it.macgood.mathanapp.ui.handbook.demidovich.exercises.Exercise
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {

    suspend fun getExercises(): List<ExerciseDto>

    suspend fun getExercise(id: String): ExerciseDto
}