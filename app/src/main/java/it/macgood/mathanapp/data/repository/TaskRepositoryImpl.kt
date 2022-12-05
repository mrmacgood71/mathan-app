package it.macgood.mathanapp.data.repository

import it.macgood.mathanapp.data.datasource.TaskDao
import it.macgood.mathanapp.domain.model.Task
import it.macgood.mathanapp.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    val dao: TaskDao
): TaskRepository {
    override fun getTasks(): Flow<List<Task>> {
        return dao.getTasks()
    }

    override suspend fun getTask(id: Long): Task? {
        return dao.getTask(id)
    }
}