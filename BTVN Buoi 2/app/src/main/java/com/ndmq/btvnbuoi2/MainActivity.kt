package com.ndmq.btvnbuoi2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    /* Display */
    private lateinit var tvFirstNumber: TextView
    private lateinit var tvOperator: TextView
    private lateinit var tvSecondNumber: TextView
    private lateinit var tvResult: TextView


    /* Number */
    private lateinit var btnNumber0: TextView
    private lateinit var btnNumber1: TextView
    private lateinit var btnNumber2: TextView
    private lateinit var btnNumber3: TextView
    private lateinit var btnNumber4: TextView
    private lateinit var btnNumber5: TextView
    private lateinit var btnNumber6: TextView
    private lateinit var btnNumber7: TextView
    private lateinit var btnNumber8: TextView
    private lateinit var btnNumber9: TextView


    /* Operator */
    private lateinit var btnPlus: TextView
    private lateinit var btnSub: TextView
    private lateinit var btnMul: TextView
    private lateinit var btnDiv: TextView
    private lateinit var btnCal: TextView


    /* Tool */
    private lateinit var btnAC: TextView
    private lateinit var btnDelete: ImageView


    private var firstNumber = 0

    private var secondNumber = 0

    private var currentOperator = "+"

    // true: Currently editing the first number
    // false: Currently editing the second number
    private var isFirstNumber = true

    private var tempNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()
        handleEvents()
    }


    private fun findViews() {
        tvFirstNumber = findViewById(R.id.tvFirstNumber)
        tvOperator = findViewById(R.id.tvOperator)
        tvSecondNumber = findViewById(R.id.tvSecondNumber)
        tvResult = findViewById(R.id.tvResult)

        btnNumber0 = findViewById(R.id.btnNumber0)
        btnNumber1 = findViewById(R.id.btnNumber1)
        btnNumber2 = findViewById(R.id.btnNumber2)
        btnNumber3 = findViewById(R.id.btnNumber3)
        btnNumber4 = findViewById(R.id.btnNumber4)
        btnNumber5 = findViewById(R.id.btnNumber5)
        btnNumber6 = findViewById(R.id.btnNumber6)
        btnNumber7 = findViewById(R.id.btnNumber7)
        btnNumber8 = findViewById(R.id.btnNumber8)
        btnNumber9 = findViewById(R.id.btnNumber9)

        btnPlus = findViewById(R.id.btnPlus)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)
        btnCal = findViewById(R.id.btnCalculate)

        btnAC = findViewById(R.id.btnAllClear)
        btnDelete = findViewById(R.id.btnDelete)
    }


    private fun handleEvents() {
        handleToolClickEvents()
        handleNumberClickEvents()
        handleOperatorClickEvents()
    }


    private fun handleToolClickEvents() {
        btnAC.setOnClickListener { onACButtonClick() }
        btnDelete.setOnClickListener { onDeleteButtonClick() }
    }

    private fun handleNumberClickEvents() {
        btnNumber0.setOnClickListener { onNumberButtonClick(0) }
        btnNumber1.setOnClickListener { onNumberButtonClick(1) }
        btnNumber2.setOnClickListener { onNumberButtonClick(2) }
        btnNumber3.setOnClickListener { onNumberButtonClick(3) }
        btnNumber4.setOnClickListener { onNumberButtonClick(4) }
        btnNumber5.setOnClickListener { onNumberButtonClick(5) }
        btnNumber6.setOnClickListener { onNumberButtonClick(6) }
        btnNumber7.setOnClickListener { onNumberButtonClick(7) }
        btnNumber8.setOnClickListener { onNumberButtonClick(8) }
        btnNumber9.setOnClickListener { onNumberButtonClick(9) }
    }

    private fun handleOperatorClickEvents() {
        btnPlus.setOnClickListener { onOperatorButtonClick("+") }
        btnSub.setOnClickListener { onOperatorButtonClick("-") }
        btnMul.setOnClickListener { onOperatorButtonClick("*") }
        btnDiv.setOnClickListener { onOperatorButtonClick("/") }
        btnCal.setOnClickListener { calculateAndDisplayResult() }
    }


    private fun onNumberButtonClick(number: Int) {
        tempNumber = tempNumber * 10 + number
        if (isFirstNumber) {
            firstNumber = tempNumber
            tvFirstNumber.text = firstNumber.toString()
        } else {
            secondNumber = tempNumber
            tvSecondNumber.text = secondNumber.toString()
        }
    }

    private fun onOperatorButtonClick(operator: String) {
        currentOperator = operator
        tvOperator.text = currentOperator
        if (isFirstNumber) {
            isFirstNumber = false
            tempNumber = 0
        }
    }

    private fun onACButtonClick() {
        tempNumber = 0
        firstNumber = 0
        secondNumber = 0
        currentOperator = "+"
        isFirstNumber = true
        tvFirstNumber.text = firstNumber.toString()
        tvOperator.text = currentOperator
        tvSecondNumber.text = secondNumber.toString()
        tvResult.text = "0"
    }

    // Delete last digit of current number
    // If current number is the second number and it's 0, delete the last digit of the first number
    private fun onDeleteButtonClick() {
        if (!isFirstNumber && secondNumber != 0) {
            secondNumber /= 10
            tempNumber = secondNumber
            tvSecondNumber.text = secondNumber.toString()
            return
        }

        isFirstNumber = true
        firstNumber /= 10
        tempNumber = firstNumber
        tvFirstNumber.text = firstNumber.toString()
    }


    private fun calculateAndDisplayResult() {
        val result = try {
            when (currentOperator) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber
                else -> 0
            }
        } catch (e: ArithmeticException) {
            0
        }.toString()
        tvResult.text = result
    }
}