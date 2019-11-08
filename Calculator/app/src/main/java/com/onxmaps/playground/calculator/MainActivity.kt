package com.onxmaps.playground.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import timber.log.Timber

import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

       lateinit var display: TextView
       var num1 = ""
       var num2 = ""
       var operator = ""
       var isOperatorClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        display = findViewById(R.id.display)
    }

    fun displayNumber(view: View) {
        if(display.text == "0") {
            display.text = ""
            display.text = (view as Button).text
        } else {
            display.append((view as Button).text)
        }
    }

    fun clearDisplay(view: View) {
        display.text = ""
    }

    fun addDecimal(view: View) {
        if(display.text.contains(".")) {
            return;
        } else {
            display.append(".")
        }
    }

    fun displayOperator(view: View) {
        isOperatorClicked = true
        if( display.text.contains("x") ||
            display.text.contains("+") ||
            display.text.contains("-") ||
            display.text.contains("/") ||
            display.text.contains("%"))
        {
            return;
        } else {
            display.append((view as Button).text)
        }
    }

    fun evaluateExpression(view: View) {
        var expression = display.getText().toString()
        if (expression.contains("/")) {
            divisionEvaluation()
        } else if(expression.contains("x")) {
            productEvaluation()
        } else if(expression.contains("+")) {
            sumEvaluation()
        } else if(expression.contains("-")) {
            differenceEvaluation()
        } else if(expression.contains("%")) {
            modulusEvaluation()
        }
    }

     fun divisionEvaluation() {
         var expression = display.getText().toString()
         var numList = expression.split("/")
         var firstNumber = numList.toMutableList().removeAt(0)
         var secondNumber = numList.toMutableList().removeAt(1)
         var result = firstNumber.toFloat() / secondNumber.toFloat()
         var remainder = firstNumber.toFloat() % secondNumber.toFloat()
         if(remainder.toString() == "0.0") {
             display.text = (Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber)).toString()
         } else {
             display.text = result.toString()
         }
     }

     fun productEvaluation() {
         var expression = display.getText().toString()
         var numList = expression.split("x")
         var firstNumber = numList.toMutableList().removeAt(0)
         var secondNumber = numList.toMutableList().removeAt(1)
         var result = firstNumber.toFloat() * secondNumber.toFloat()
         var remainder = firstNumber.toFloat() % secondNumber.toFloat()
         if(remainder.toString() > "0.0") {
             display.text = (Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber)).toString()
         } else {
             display.text = result.toString()
         }
    }

    fun sumEvaluation() {
        var expression = display.getText().toString()
        var numList = expression.split("+")
        var firstNumber = numList.toMutableList().removeAt(0)
        var secondNumber = numList.toMutableList().removeAt(1)
        var result = firstNumber.toFloat() + secondNumber.toFloat()
        var remainder = firstNumber.toFloat() % secondNumber.toFloat()
        if(remainder.toString() > "0.0") {
            display.text = result.toString()
        } else {
            display.text = (Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber)).toString()
        }
    }

    fun differenceEvaluation() {
        var expression = display.getText().toString()
        var numList = expression.split("-")
        var firstNumber = numList.toMutableList().removeAt(0)
        var secondNumber = numList.toMutableList().removeAt(1)
        var result = firstNumber.toFloat() - secondNumber.toFloat()
        var remainder = firstNumber.toFloat() % secondNumber.toFloat()
        if(remainder.toString() > "0.0") {
            display.text =  result.toString()
        } else {
            display.text = (Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber)).toString()
        }
    }

    fun modulusEvaluation() {
        var expression = display.getText().toString()
        var numList = expression.split("%")
        var firstNumber = numList.toMutableList().removeAt(0)
        var secondNumber = numList.toMutableList().removeAt(1)
        var result = (Integer.parseInt(firstNumber) % Integer.parseInt(secondNumber)).toString()
        display.text = result
    }





}
