package com.masterjorge.codequiz.data.usuario

import kotlinx.coroutines.flow.Flow

class UsuarioRepositorio (private val usuarioDao: UsuarioDao): UsuarioDao {

    override suspend fun inserirUsuario(usuario: Usuario) {
        usuarioDao.inserirUsuario(usuario)
    }

    override fun lerUsuario(usuario: String, senha: String): Usuario? =
        usuarioDao.lerUsuario(usuario, senha)


    override fun lerTodosUsuarios(): Flow<List<Usuario>> =
        usuarioDao.lerTodosUsuarios()

}