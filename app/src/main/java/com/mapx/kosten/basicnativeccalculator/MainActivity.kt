package com.mapx.kosten.basicnativeccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var value1: Float = 0.0F
    private var value2: Float = 0.0F
    private var operation: String = OPERATION_INIT
    private var flagResult = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        textViewLegend.text = stringFromJNI()

        clearEntry()

        initActionListeners()
        initOperationListeners()
        initNumberListeners()
    }

    private fun initActionListeners() {
        buttonCalculate.setOnClickListener {
            var result = ""
            when(operation) {
                OPERATION_ADD -> {
                    result = add(value1, value2).toString()
                }
                OPERATION_SUB -> {
                    result = sub(value1, value2).toString()
                }
                OPERATION_MUL -> {
                    result = multiply(value1, value2).toString()
                }
                OPERATION_DIV -> {
                    result = divide(value1, value2).toString()
                }
            }
            result_text.text = result
            flagResult = true
        }

        buttonClear.setOnClickListener {
            operation = OPERATION_INIT
            value1 = 0F
            value2 = 0F
            clearEntry()
        }
    }

    private fun initOperationListeners() {
        buttonAdd.setOnClickListener {
            operation = OPERATION_ADD
            clearEntry()
        }
        buttonSub.setOnClickListener {
            operation = OPERATION_SUB
            clearEntry()
        }
        buttonMultiply.setOnClickListener {
            operation = OPERATION_MUL
            clearEntry()
        }
        buttonDivide.setOnClickListener {
            operation = OPERATION_DIV
            clearEntry()
        }
    }

    private fun initNumberListeners() {
        buttonZero.setOnClickListener { setValue("0") }
        buttonOne.setOnClickListener { setValue("1") }
        buttonTwo.setOnClickListener { setValue("2") }
        buttonThree.setOnClickListener { setValue("3") }
        buttonFour.setOnClickListener { setValue("4") }
        buttonFive.setOnClickListener { setValue("5") }
        buttonSix.setOnClickListener { setValue("6") }
        buttonSeven.setOnClickListener { setValue("7") }
        buttonEight.setOnClickListener { setValue("8") }
        buttonNine.setOnClickListener { setValue("9") }
    }

    private fun setValue(value: String) {
        result_text.text = result_text.text.toString() + value
        if (operation == OPERATION_INIT) {
            value1 = result_text.text.toString().toFloat()
        } else {
            value2 = result_text.text.toString().toFloat()
        }
    }

    private fun clearEntry() {
        result_text.text = ""
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun add(x: Float, y: Float): Float
    external fun sub(x: Float, y: Float): Float
    external fun multiply(x: Float, y: Float): Float
    external fun divide(x: Float, y: Float): Float


    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }

        private const val OPERATION_INIT = "INIT"
        private const val OPERATION_ADD = "+"
        private const val OPERATION_SUB = "-"
        private const val OPERATION_MUL = "x"
        private const val OPERATION_DIV = "/"
    }

}
