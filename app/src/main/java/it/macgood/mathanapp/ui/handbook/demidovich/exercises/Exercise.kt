package it.macgood.mathanapp.ui.handbook.demidovich.exercises

import it.macgood.mathanapp.data.datasource.ExerciseDto

data class Exercise(
    val id: String = "0",
    val questionNumber: String,
    var questionText: String,
    val formula: String
)

fun ExerciseDto.toExercise(): Exercise {
    return Exercise(
        id, questionNumber, questionText, formula
    )
}

