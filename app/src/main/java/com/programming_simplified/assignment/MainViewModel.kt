package com.programming_simplified.assignment

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.lang.NumberFormatException

class MainViewModel : ViewModel() {

    private val _result:MutableState<String> = mutableStateOf("")
    val result:State<String> = _result

    fun addition(num1:Int,num2:Int){
        _result.value = "$num1 + $num2 = ${num1.plus(num2)}"
    }

    fun subtraction(num1:Int,num2:Int){
        _result.value = "$num1 - $num2 = ${num1.minus(num2)}"
    }

    fun multiplication(num1:Int,num2:Int){
        _result.value = "$num1 * $num2 = ${num1.times(num2)}"
    }

    fun division(num1:Int,num2:Int){
        try {
            _result.value = "$num1 / $num2 = ${num1.div(num2)}"
        }catch (e:NumberFormatException){
            _result.value = "Exception"
        }
    }
}