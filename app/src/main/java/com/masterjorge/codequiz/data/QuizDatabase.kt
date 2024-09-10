package com.masterjorge.codequiz.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.masterjorge.codequiz.data.usuario.Usuario
import com.masterjorge.codequiz.data.usuario.UsuarioDao

@Database(
    entities = [Usuario::class],
    version = 1)

abstract class QuizDatabase: RoomDatabase(){

    abstract val usuarioDao: UsuarioDao
}