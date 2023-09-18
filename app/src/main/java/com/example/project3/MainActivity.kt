package com.example.project3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var difficulty = ""
        var type = ""
        var numOfQs = 0

        var equationList = mutableListOf<String>()
        var answerList = mutableListOf<Double>()

        val buttonEasy = findViewById<Button>(R.id.buttonEasy)
        buttonEasy.setOnClickListener {
            difficulty = "Easy"
        }
        val buttonMedium = findViewById<Button>(R.id.buttonMedium)
        buttonEasy.setOnClickListener {
            difficulty = "Medium"
        }
        val buttonHard = findViewById<Button>(R.id.buttonHard)
        buttonEasy.setOnClickListener {
            difficulty = "Hard"
        }

        val buttonAddition = findViewById<Button>(R.id.buttonAddition)
        buttonEasy.setOnClickListener {
            type = "+"
        }
        val buttonSubtraction = findViewById<Button>(R.id.buttonSubtraction)
        buttonEasy.setOnClickListener {
            type = "-"
        }
        val buttonMultiplication = findViewById<Button>(R.id.buttonMultiplication)
        buttonEasy.setOnClickListener {
            type = "*"
        }
        val buttonDivision = findViewById<Button>(R.id.buttonDivision)
        buttonEasy.setOnClickListener {
            type = "/"
        }
        val buttonStart = findViewById<Button>(R.id.buttonStart)
        buttonStart.setOnClickListener {
            if(difficulty == "Easy"){
                for(i in 0..numOfQs){
                    val num1 = (0..10).random()
                    val num2 = (0..10).random()
                    equationList.add("$num1$type$num2")
                    answerList.add(ExpressionBuilder("$num1$type$num2").build().evaluate())
                }


            }
            else if(difficulty == "Medium"){
                for(i in 0..numOfQs){
                    val num1 = (0..25).random()
                    val num2 = (0..25).random()
                    equationList.add("$num1$type$num2")
                    answerList.add(ExpressionBuilder("$num1$type$num2").build().evaluate())
                }
            }
            else{
                for(i in 0..numOfQs){
                    val num1 = (0..50).random()
                    val num2 = (0..50).random()
                    equationList.add("$num1$type$num2")
                    answerList.add(ExpressionBuilder("$num1$type$num2").build().evaluate())
                }

            }
        }

    }
}