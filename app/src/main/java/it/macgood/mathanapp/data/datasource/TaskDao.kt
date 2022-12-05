package it.macgood.mathanapp.data.datasource

import androidx.room.Dao
import androidx.room.Query
import it.macgood.mathanapp.domain.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task where id = :id")
    suspend fun getTask(id: Long): Task?
}