package com.example.project3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import net.objecthunter.exp4j.ExpressionBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        var difficulty = ""
        var type = ""
        var numOfQs = 0

        var equationList = mutableListOf<String>()
        var answerList = mutableListOf<Double>()

        val buttonEasy = view.findViewById<Button>(R.id.buttonEasy)
        buttonEasy.setOnClickListener {
            difficulty = "Easy"
        }
        val buttonMedium = view.findViewById<Button>(R.id.buttonMedium)
        buttonEasy.setOnClickListener {
            difficulty = "Medium"
        }
        val buttonHard = view.findViewById<Button>(R.id.buttonHard)
        buttonEasy.setOnClickListener {
            difficulty = "Hard"
        }

        val buttonAddition = view.findViewById<Button>(R.id.buttonAddition)
        buttonEasy.setOnClickListener {
            type = "+"
        }
        val buttonSubtraction = view.findViewById<Button>(R.id.buttonSubtraction)
        buttonEasy.setOnClickListener {
            type = "-"
        }
        val buttonMultiplication = view.findViewById<Button>(R.id.buttonMultiplication)
        buttonEasy.setOnClickListener {
            type = "*"
        }
        val buttonDivision = view.findViewById<Button>(R.id.buttonDivision)
        buttonEasy.setOnClickListener {
            type = "/"
        }
        val buttonStart = view.findViewById<Button>(R.id.buttonStart)
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
            //Something to load second fragment
        }
        val buttonAddQs = view.findViewById<Button>(R.id.buttonAddQs)
        buttonAddQs.setOnClickListener {
            if (numOfQs < 10){
                numOfQs++
                val QsText = view.findViewById<TextView>(R.id.QsText)
                QsText.text = numOfQs.toString()
            }
        }
        val buttonSubtractQs = view.findViewById<Button>(R.id.buttonSubtractQs)
        buttonAddQs.setOnClickListener {
            if (numOfQs > 0){
                numOfQs--
                val QsText = view.findViewById<TextView>(R.id.QsText)
                QsText.text = numOfQs.toString()
            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}