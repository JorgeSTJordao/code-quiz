package com.masterjorge.codequiz.data.UserData

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface Repository{

    suspend fun insertUser(user: User)

    suspend fun getUser(email: String, senha: String): Flow<User?>

    suspend fun getAllUsers(): Flow<List<User>>
}

class UserRepository (private val userDao: UserDao): Repository {
    override suspend fun insertUser(user: User) {
        withContext(IO){
            userDao.insertUser(user)
        }
    }

    override suspend fun getUser(email: String, senha: String): Flow<User?> {
        return withContext(IO){
            userDao.getUser(email, senha)
        }
    }

    override suspend fun getAllUsers(): Flow<List<User>> {
        return withContext(IO){
            userDao.getAllUsers()
        }
    }

}