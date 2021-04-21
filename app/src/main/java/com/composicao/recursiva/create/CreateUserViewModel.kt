package com.composicao.recursiva.create

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.composicao.recursiva.create.model.User

class CreateUserViewModel : ViewModel(), LifecycleObserver {

    private val createUserState = MutableLiveData<CreateUserState>()

    fun createUser(userName: String, password: String) {
        try {
            val newUser = User(userName, password)
            newUser.validateUser()
            createUserState.value = CreateUserState.Success
        } catch (exception: Exception) {
            createUserState.value = CreateUserState.Error(exception.message)
        }
    }

    fun createUserStateLiveData(): LiveData<CreateUserState> {
        return createUserState
    }
}

sealed class CreateUserState {
    data class Error(val message: String?) : CreateUserState()
    object Success : CreateUserState()
}