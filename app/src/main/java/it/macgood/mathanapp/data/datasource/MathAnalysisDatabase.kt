package it.macgood.mathanapp.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import it.macgood.mathanapp.domain.model.Task

@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)
abstract class MathAnalysisDatabase: RoomDatabase() {
    abstract val taskDao: TaskDao

    companion object {
        const val DATABASE_NAME = "mathanalysis"
    }
}