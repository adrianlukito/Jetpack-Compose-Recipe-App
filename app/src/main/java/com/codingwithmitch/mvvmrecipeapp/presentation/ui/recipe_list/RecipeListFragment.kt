package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.codingwithmitch.mvvmrecipeapp.R
import com.codingwithmitch.mvvmrecipeapp.presentation.components.FoodCategoryChip
import com.codingwithmitch.mvvmrecipeapp.presentation.components.RecipeCard
import com.codingwithmitch.mvvmrecipeapp.util.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment: Fragment() {

//    sharing viewmodel method
    val viewModel: RecipeListViewModel by activityViewModels()

//    general method
//    val viewModel: RecipeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("RecipeListFragment ${viewModel}")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = viewModel.recipes.value

                val query = viewModel.query.value

                val selectedCategory = viewModel.selectedCategory.value
                
                Column {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White,
                        elevation = 8.dp,
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth(0.9f)
                                        .padding(8.dp),
                                    value = query,
                                    onValueChange = { newValue ->
                                        viewModel.onQueryChange(newValue)
                                    },
                                    label = {
                                        Text(text = "Search")
                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Text,
                                        imeAction = ImeAction.Search
                                    ),
                                    leadingIcon = {
                                        Icon(Icons.Filled.Search)
                                    },
                                    onImeActionPerformed = { action, softKeyboardController ->
                                        if(action == ImeAction.Search) {
                                            viewModel.search()
                                            softKeyboardController?.hideSoftwareKeyboard()
                                        }
                                    },
                                    textStyle = TextStyle(
                                        color = MaterialTheme.colors.onSurface
                                    ),
                                    backgroundColor = MaterialTheme.colors.surface
                                )
                            }
                            ScrollableRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 8.dp, bottom = 8.dp)
                            ) {
                                for(category in getAllFoodCategories()) {
                                    FoodCategoryChip(
                                        category = category.value,
                                        isSelected = selectedCategory == category,
                                        onSelectedCategory = {
                                            viewModel.onSelectedCategoryChange(it)
                                        },
                                        onExecuteSearch = viewModel::search
                                    )
                                }
                            }
                        }
                    }
                    LazyColumn {
                        itemsIndexed(items = recipes) { index, recipe ->
                            RecipeCard(recipe = recipe, onClick = {})
                        }
                    }
                }
            }
        }
    }
}