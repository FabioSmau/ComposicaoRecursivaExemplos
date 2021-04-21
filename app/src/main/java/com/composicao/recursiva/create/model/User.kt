package com.composicao.recursiva.create.model

class User(private val userName: String, private val password: String) {

    // TODO Refactor using Decorator Pattern

    @Throws(Exception::class)
    fun validateUser() {
        if (userName.isEmpty()) {
            throw Exception("Usuário não pode ser vazío!")
        }

        if (password.isEmpty()) {
            throw Exception("A senha não pode ser vazia!")
        }

        if (password.length < 8) {
            throw Exception("A senha precisa ter mais que 8 caracteres")
        }

//        if (password.all { it.isLetterOrDigit() }) {
//            throw Exception("A senha precisa de letras e números")
//        }
    }


}