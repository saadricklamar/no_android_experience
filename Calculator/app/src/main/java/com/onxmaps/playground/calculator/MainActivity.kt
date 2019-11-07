package com.onxmaps.playground.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    /**
     * Instructions: Create a calculator that can perform 5 operations:
     * addition, subtraction, multiplication, division, and find the
     * remainder (modulus). The calculator should only be able to
     * work with 2 real numbers. You will need to display the operation
     * that is currently selected, as well as display a solution and
     * find a way to clear your result and start over. If you have
     * extra time, keep and display a history of all operations done.
     * Use HistoryAdapter for the display
     */
      lateinit var display: TextView

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
        display.text = "0"

    }



}
