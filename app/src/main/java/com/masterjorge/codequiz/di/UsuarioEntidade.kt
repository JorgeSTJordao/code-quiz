package com.masterjorge.codequiz.di

import com.masterjorge.codequiz.data.QuizDatabase
import com.masterjorge.codequiz.data.usuario.UsuarioRepositorio
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsuarioEntidade {

    @Provides
    @Singleton
    fun oferecerUsuarioEntitade(quizDatabase: QuizDatabase): UsuarioRepositorio {
        return UsuarioRepositorio(quizDatabase.usuarioDao)
    }
}