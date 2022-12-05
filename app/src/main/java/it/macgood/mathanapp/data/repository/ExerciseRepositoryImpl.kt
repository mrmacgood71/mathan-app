package it.macgood.mathanapp.data.repository

import it.macgood.mathanapp.data.MathAnalysisApi
import it.macgood.mathanapp.data.datasource.ExerciseDto
import it.macgood.mathanapp.domain.repository.ExerciseRepository
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    private val api: MathAnalysisApi
): ExerciseRepository {

    override suspend fun getExercises(): List<ExerciseDto> {
        return api.getExercises()
    }

    override suspend fun getExercise(id: String): ExerciseDto {
        return api.getExercise(id)
    }
}