package it.macgood.mathanapp.domain.repository

import it.macgood.mathanapp.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getTasks(): Flow<List<Task>>

    suspend fun getTask(id: Long): Task?
}