package com.masterjorge.codequiz.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masterjorge.codequiz.data.UserData.User
import com.masterjorge.codequiz.data.UserData.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserViewModel  constructor(private val repository: UserRepository): ViewModel() {
    private val _user = MutableStateFlow(null as User?)
    val user = _user.asStateFlow()

    private val _users = MutableStateFlow(emptyList<User>())
    val users = _users.asStateFlow()

    fun insertUser(user: User) =
        viewModelScope.launch {
            repository.insertUser(user)
    }

    fun getUser(email: String, password: String) =
        viewModelScope.launch {
            repository.getUser(email, password).collectLatest {
                _user.tryEmit(it)
            }
    }
}