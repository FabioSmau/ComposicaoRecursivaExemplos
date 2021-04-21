package com.composicao.recursiva.create

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.composicao.recursiva.R

class CreateUserActivity : AppCompatActivity(R.layout.activity_create_user) {

    private val viewModel: CreateUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModelObserver()
        setupClickButtonCreateUser()
        setupStateObserver()
    }

    private fun setupViewModelObserver() {
        lifecycle.addObserver(viewModel)
    }

    private fun setupClickButtonCreateUser() {
        val buttonCreate: Button = findViewById(R.id.buttton_create_user)
        buttonCreate.setOnClickListener {
            createNewUser()
        }
    }

    private fun createNewUser() {
        val textUserName: EditText = findViewById(R.id.edit_text_username)
        val textUsePassword: EditText = findViewById(R.id.edit_text_password)
        val userName = textUserName.text.toString()
        val password = textUsePassword.text.toString()
        viewModel.createUser(userName, password)
    }

    private fun setupStateObserver() {
        viewModel.createUserStateLiveData().observe(this, Observer { viewState ->
            when (viewState) {
                is CreateUserState.Error -> showError(viewState.message)
                is CreateUserState.Success -> createNewUserWithSuccess()
            }
        })
    }

    private fun showError(errorMessage: String?) {
        showToast(errorMessage)
    }

    private fun createNewUserWithSuccess() {
        showToast("Usuário criado com sucesso!")
        finish()
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, CreateUserActivity::class.java)
    }
}