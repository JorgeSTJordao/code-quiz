package com.masterjorge.codequiz.domain

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.masterjorge.codequiz.data.Question
import com.masterjorge.codequiz.data.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SurveyViewModel: ViewModel(){
    private val _listQuestions = MutableStateFlow<List<Question>>(arrayListOf())
    val listQuestions = _listQuestions.asStateFlow()

    private val _index = MutableStateFlow(0)
    val index = _index.asStateFlow()

    private val _score = MutableStateFlow(0)
    val score = _score.asStateFlow()

    private val _user = MutableStateFlow(null as User?)
    val user = _user.asStateFlow()

    fun setScore(score: Int){
        _score.value = score
    }

    fun incrementIndex(){
        _index.value++
    }

    fun getNewList(array: List<Question>){
        _listQuestions.value = array.shuffled()
    }

    fun incrementScore(score: Int){
        _score.value += score
    }

    fun zeroIndex(){
        _index.value = 0
    }

    fun getMainUser(user: User){
        _user.value = user
    }
}