package com.example.jctodo.screen

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jctodo.R
import com.example.jctodo.components.ButtonComponents
import com.example.jctodo.components.ListComponents
import com.example.jctodo.components.NormalTextComponents
import com.example.jctodo.components.TextFieldComponents
import com.example.jctodo.components.TextFieldDetailsComponents

@Composable
fun HomeScreen(){

    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
            NormalTextComponents(textValue = stringResource(R.string.todo_list))
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldComponents(levelValue = "HeadLine")
            Spacer(modifier = Modifier.height(10.dp))

            TextFieldDetailsComponents(levelValue = "Description")
            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponents()
            Spacer(modifier = Modifier.height(20.dp))
            ListComponents()
        }


    }

}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}