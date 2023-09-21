package com.example.project3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var difficulty = ""
        var type = ""
        var numOfQs = 1

        var equationList = mutableListOf<String>()
        var answerList = mutableListOf<String>()

        val dif = view.findViewById<RadioGroup>(R.id.difficulties)
        dif.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.buttonEasy -> {
                    difficulty = "Easy"
                }
                R.id.buttonMedium -> {
                    difficulty = "Medium"
                }
                R.id.buttonHard -> {
                    difficulty = "Hard"
                }
            }
        }

        val oper = view.findViewById<RadioGroup>(R.id.operators)
        oper.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.buttonAddition -> {
                    type = "+"
                }
                R.id.buttonSubtraction -> {
                    type = "-"
                }
                R.id.buttonMultiplication -> {
                    type = "*"
                }
                R.id.buttonDivision -> {
                    type = "/"
                }

            }
        }
        val buttonStart = view.findViewById<Button>(R.id.buttonStart)
        buttonStart.setOnClickListener {
            if(difficulty == "Easy"){
                for(i in 1..numOfQs){
                    val num1 = (0..10).random()
                    val num2 = if(type == "/") {
                        (1..10).random()
                    }
                    else{
                        (0..10).random()
                    }
                    equationList.add("$num1$type$num2")
                    answerList.add(ExpressionBuilder("$num1$type$num2").build().evaluate().toString())
                }
                val bundle = Bundle()
                val action = Fragment1Directions.actionFragment1ToFragment2(ArrayList(equationList).toTypedArray(),ArrayList(answerList).toTypedArray()
                , numOfQs, type)
                findNavController().navigate(action)


            }
            else if(difficulty == "Medium"){
                for(i in 1..numOfQs){
                    val num1 = (0..25).random()
                    val num2 = if(type == "/") {
                        (1..25).random()
                    }
                    else{
                         (0..25).random()
                    }
                    equationList.add("$num1$type$num2")
                    answerList.add(ExpressionBuilder("$num1$type$num2").build().evaluate().toString())
                }
                val action = Fragment1Directions.actionFragment1ToFragment2(ArrayList(equationList).toTypedArray(),ArrayList(answerList).toTypedArray()
                    , numOfQs, type)
                findNavController().navigate(action)
            }
            else if (difficulty == "Hard"){
                for(i in 1..numOfQs){
                    val num1 = (0..50).random()
                    val num2 = if(type == "/") {
                        (1..50).random()
                    }
                    else{
                        (0..50).random()
                    }
                    equationList.add("$num1$type$num2")
                    answerList.add(ExpressionBuilder("$num1$type$num2").build().evaluate().toString())
                }
                val action = Fragment1Directions.actionFragment1ToFragment2(ArrayList(equationList).toTypedArray(),ArrayList(answerList).toTypedArray()
                    , numOfQs, type)
                findNavController().navigate(action)

            }
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
        buttonSubtractQs.setOnClickListener {
            if (numOfQs > 1){
                numOfQs--
                val QsText = view.findViewById<TextView>(R.id.QsText)
                QsText.text = numOfQs.toString()
            }
        }
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