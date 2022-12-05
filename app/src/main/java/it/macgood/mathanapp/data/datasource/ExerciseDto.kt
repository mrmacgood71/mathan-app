package it.macgood.mathanapp.data.datasource

import com.google.gson.annotations.SerializedName

data class ExerciseDto(
    val id: String,
    val questionNumber: String,
    val questionText: String,
    val formula: String
)


