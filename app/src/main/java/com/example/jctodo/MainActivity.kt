package com.example.jctodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jctodo.components.NormalTextComponents
import com.example.jctodo.screen.HomeScreen
import com.example.jctodo.ui.theme.JcTodoTheme

data class Todo(val title:String, val description:String)
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            HomeScreen()
            val title = remember {
                mutableStateOf("")
                
            }
            val description = remember {
                mutableStateOf("")
            }

            val todos = remember {
                mutableStateOf<List<Todo>>(mutableListOf())
            }

            val todo = remember {
                mutableStateOf<Todo?>(null)
            }

            Column {
                TextField(value = title.value, onValueChange ={
                    title.value = it
                } )
                TextField(value = description.value, onValueChange ={
                    description.value = it
                } )
                ElevatedButton(onClick = {
                    val todo = Todo(title.value, description.value)
                    val previous = todos.value.toMutableList()
                    previous.add(todo)
                    todos.value = previous
                }) {
                    Text(text = "Save")
                    
                }

                LazyColumn{
                    itemsIndexed(todos.value){ index, item ->
                        Card(
                            modifier = Modifier.fillMaxSize(),
                            onClick = {
                            val previous = todos.value.toMutableList()
                            previous.removeAt(index)
                            todos.value = previous
                        }) {

                            NormalTextComponents(textValue = item.title)
                        }
                    }
                }
            }



        }
    }
}

