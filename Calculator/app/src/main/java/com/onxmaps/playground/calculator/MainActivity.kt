package com.onxmaps.playground.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { _ ->

            // Numbers. When button is clicked the displayValue function is invoked
            // with two arguments, the value of the button as a string and a boolean

            button1.setOnClickListener { displayValue("1", true) }
            button2.setOnClickListener { displayValue("2", true) }
            button3.setOnClickListener { displayValue("3", true) }
            button4.setOnClickListener { displayValue("4", true) }
            button5.setOnClickListener { displayValue("5", true) }
            button6.setOnClickListener { displayValue("6", true) }
            button7.setOnClickListener { displayValue("7", true) }
            button8.setOnClickListener { displayValue("8", true) }
            button9.setOnClickListener { displayValue("9", true) }
            button0.setOnClickListener { displayValue("0", true) }
            buttonDecimal.setOnClickListener { displayValue(".", true) }

            //Operators. Similarly as above.

            buttonAdd.setOnClickListener { displayValue("+", false) }
            buttonSubtract.setOnClickListener { displayValue("-", false) }
            buttonMultiply.setOnClickListener { displayValue("*", false) }
            buttonDivide.setOnClickListener { displayValue("/", false) }

            // This ensures the the display Text Field is cleared when AC is clicked.

            buttonClear.setOnClickListener {
                expression.text = ""
                result.text = ""
            }

        }


        // This function appends the value to the display

        fun displayValue(string: String, canClear: Boolean) {
            if(result.text.isNotEmpty()){
                expression.text = ""
            }
            if (canClear) {
                result.text = ""
                expression.append(string)
            } else {
                expression.append(result.text)
                expression.append(string)
                result.text = ""
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.

        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // TODO: Handle action bar item clicks here. Change the
        //  symbol of the operator to match the operation
        //  that was selected. Pressing the "equals"
        //  button should also perform that operation

        Toast.makeText(this, "Clicked ${item.title}", Toast.LENGTH_LONG).show()

        return super.onOptionsItemSelected(item)
    }
}
