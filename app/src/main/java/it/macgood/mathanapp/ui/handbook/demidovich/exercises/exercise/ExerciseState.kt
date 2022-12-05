package it.macgood.mathanapp.ui.handbook.demidovich.exercises.exercise

import it.macgood.mathanapp.ui.handbook.demidovich.exercises.Exercise

data class ExerciseState(
    val isLoading: Boolean = false,
    val exercise: Exercise? = null,
    val error: String = ""
) {
}