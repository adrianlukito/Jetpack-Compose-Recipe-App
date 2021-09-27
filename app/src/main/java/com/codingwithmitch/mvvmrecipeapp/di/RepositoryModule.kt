package com.codingwithmitch.mvvmrecipeapp.di

import com.codingwithmitch.mvvmrecipeapp.network.RecipeService
import com.codingwithmitch.mvvmrecipeapp.network.model.RecipeDtoMapper
import com.codingwithmitch.mvvmrecipeapp.repository.RecipeRepository
import com.codingwithmitch.mvvmrecipeapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService,
            recipeDtoMapper
        )
    }
}