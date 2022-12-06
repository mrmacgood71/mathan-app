package it.macgood.mathanapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.macgood.mathanapp.common.Constants
import it.macgood.mathanapp.data.MathAnalysisApi
import it.macgood.mathanapp.data.datasource.MathAnalysisDatabase
import it.macgood.mathanapp.data.datasource.MathAnalysisDatabase.Companion.DATABASE_NAME
import it.macgood.mathanapp.data.repository.ExerciseRepositoryImpl
import it.macgood.mathanapp.data.repository.TaskRepositoryImpl
import it.macgood.mathanapp.domain.repository.ExerciseRepository
import it.macgood.mathanapp.domain.repository.TaskRepository
import it.macgood.mathanapp.domain.usecase.GetTasks
import it.macgood.mathanapp.domain.usecase.TasksUseCases
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMathAnalysisDatabase(app: Application): MathAnalysisDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            MathAnalysisDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): MathAnalysisApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MathAnalysisApi::class.java)
    }


    @Provides
    @Singleton
    fun provideExerciseRepository(api: MathAnalysisApi): ExerciseRepository {
        return return ExerciseRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(database: MathAnalysisDatabase): TaskRepository {
        return TaskRepositoryImpl(database.taskDao)
    }

    @Provides
    @Singleton
    fun providesUseCases(repository: TaskRepository): TasksUseCases {
        return TasksUseCases(getTasks = GetTasks(repository))

    }
}