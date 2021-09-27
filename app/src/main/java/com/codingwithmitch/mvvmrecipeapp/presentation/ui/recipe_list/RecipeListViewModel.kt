package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.codingwithmitch.mvvmrecipeapp.repository.RecipeRepository
import javax.inject.Named

class RecipeListViewModel @ViewModelInject constructor(
    private val repository: RecipeRepository,
    private @Named("auth_token") val token: String
): ViewModel() {

    init {
        println("VIEWMODEL: ${repository}")
        println("VIEWMODEL: ${token}")
    }

    fun getRepo() = repository

    fun getToken() = token
}