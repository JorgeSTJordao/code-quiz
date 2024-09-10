package com.masterjorge.codequiz.data.usuario

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirUsuario(usuario: Usuario)

    @Query("SELECT * FROM usuarios WHERE usuario = :usuario AND senha = :senha")
    fun lerUsuario(usuario: String, senha: String): Usuario?

    @Query("SELECT * FROM usuarios")
    fun lerTodosUsuarios(): Flow<List<Usuario>>
}