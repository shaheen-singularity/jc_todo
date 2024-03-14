package com.example.jctodo.components
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NormalTextComponents(textValue:String){
    Text(text = textValue,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(textAlign = TextAlign.Center, fontSize = 32.sp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponents(levelValue:String){
   val textValue = remember {
       mutableStateOf("")
   }
    OutlinedTextField(
        label = { Text(text = levelValue)},
        modifier = Modifier.fillMaxWidth(),
        value = textValue.value,
        onValueChange = {
        textValue.value = it
        },
        maxLines = 2

    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDetailsComponents(levelValue:String){
    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        label = { Text(text = levelValue)},
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        maxLines = 2

    )
}

@Composable
fun ButtonComponents(){
    ElevatedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        onClick = {
        print("Clicked !")
    }) {
        Text(text = "Save")
    }
}

@Composable
fun ListComponents(){
    val dataList = listOf(
        "Abhishek", "Harshit", "Gaurav", "Avin", "Avish", "Tanu","Manu","Swarnim","Surbhi","Swati","Shruti","Pranav",
        "Abhishek", "Harshit", "Gaurav", "Avin", "Avish", "Tanu","Manu","Swarnim","Surbhi","Swati","Shruti","Pranav",
        )
    LazyColumn{
        items(dataList){ item : String ->
            NormalTextComponents(textValue = item)
        }
    }

}





@Preview(showSystemUi = true)
@Composable
fun NormalTextComponentsPreview(){
    NormalTextComponents(textValue = "ToDo App")
}

@Preview(showSystemUi = true
)
@Composable
fun TextFieldComponentsPreview(){
    TextFieldComponents(levelValue = "Title")

}

@Preview(showSystemUi = true
)
@Composable
fun TextFieldDetailsComponentsPreview(){
    TextFieldDetailsComponents(levelValue = "Description")

}
@Preview(showSystemUi = true
)
@Composable
fun ListComponentsPreview(){
ListComponents()

}
