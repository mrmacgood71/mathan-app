package it.macgood.mathanapp.ui.guidebook.tasks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.mathanapp.domain.usecase.TasksUseCases
import it.macgood.mathanapp.domain.util.TaskOrder
import it.macgood.mathanapp.ui.guidebook.tasks.task.TaskState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val tasksUseCases: TasksUseCases
): ViewModel() {

    private val _state = mutableStateOf(TaskState())
    val state: State<TaskState> = _state

    private var getTasksJob: Job? = null
    private fun getNotes(noteOrder: TaskOrder) {
        getTasksJob?.cancel()
        getTasksJob = tasksUseCases.getTasks(noteOrder)
            .onEach { task ->
                _state.value = state.value.copy(
                    notes = task,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }
}