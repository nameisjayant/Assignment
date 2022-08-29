package com.programming_simplified.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programming_simplified.assignment.ui.theme.AssignmentTheme

class MainActivity : ComponentActivity() {
    private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Calculation(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Calculation(viewModel: MainViewModel) {

    var numberOne by remember { mutableStateOf("") }
    var numberTwo by remember { mutableStateOf("") }
    val res = viewModel.result.value
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Enter two number : ")
                TextField(
                    value = numberOne,
                    onValueChange = { numberOne = it },
                    modifier = Modifier.width(50.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
                TextField(
                    value = numberTwo,
                    onValueChange = { numberTwo = it },
                    modifier = Modifier.width(50.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
            }
        }
        
        item { 
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    viewModel.addition(numberOne.toInt(),numberTwo.toInt())
                }) {
                    Text(text = "Addition")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    viewModel.subtraction(numberOne.toInt(),numberTwo.toInt())
                }) {
                    Text(text = "Subtraction")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    viewModel.multiplication(numberOne.toInt(),numberTwo.toInt())
                }) {
                    Text(text = "Multiplication")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    viewModel.division(numberOne.toInt(),numberTwo.toInt())
                }) {
                    Text(text = "Division")
                }
            }
        }
        item { 
            Text(text = "Answer : $res" , modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            )
        }
    }

}
