package it.macgood.mathanapp.ui.handbook.demidovich.exercises.exercise

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.mathanapp.common.Resource
import it.macgood.mathanapp.domain.usecase.GetExercise
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ExerciseViewModel @Inject constructor(
    private val getExercise: GetExercise,
    val id: String
):ViewModel() {

    private val _state = mutableStateOf(ExerciseState())
    val state: State<ExerciseState> = _state


    init {
        get(id)
    }

    fun get(id: String) {
        getExercise(id).onEach { resource ->
            when(resource) {
                is Resource.Loading -> {
                    _state.value = ExerciseState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = ExerciseState(
                        error = resource.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Success -> {
                    _state.value = ExerciseState(exercise = resource.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}