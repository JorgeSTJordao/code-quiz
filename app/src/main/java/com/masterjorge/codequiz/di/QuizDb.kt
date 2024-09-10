package com.masterjorge.codequiz.di

import android.app.Application
import androidx.room.Room
import com.masterjorge.codequiz.data.QuizDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuizDb {

    @Provides
    @Singleton
    fun oferecerQuizDb(app: Application): QuizDatabase {
        return Room.databaseBuilder(
            context = app,
            klass = QuizDatabase::class.java,
            name = "quiz-database"
        ).build()
    }
}