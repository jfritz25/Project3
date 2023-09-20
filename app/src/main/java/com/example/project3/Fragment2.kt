package com.example.project3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlin.math.round
import kotlin.math.roundToInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {
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
        var eqs = requireArguments().getStringArrayList("eqs")
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        val num1 = view.findViewById<TextView>(R.id.number1TextView)
        val oper = view.findViewById<TextView>(R.id.operatorTextView)
        val num2 = view.findViewById<TextView>(R.id.number2TextView)
        val eqString = eqs!!.get(0)
        num1.text = eqString[0].toString()
        oper.text = eqString[1].toString()
        num2.text = eqString[2].toString()
        eqs.removeAt(0)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var eqs = requireArguments().getStringArrayList("eqs")
        var ans = requireArguments().getStringArrayList("ans")
        var numOfQs = requireArguments().getInt("numofQs")
        var numCorrect = 0
        val buttonDone = view.findViewById<Button>(R.id.buttonDone)
        buttonDone.setOnClickListener {
            if (ans!!.isNotEmpty()) {
                val userInput = view.findViewById<EditText>(R.id.userAnswer)
                val userAnswer = round(userInput.text.toString().toDouble() * 100) / 100
                val correctAnswer = round(ans!!.get(0).toDouble() * 100) / 100
                if (userAnswer == correctAnswer) {
                    numCorrect++
                }
                userInput.hint = "Your Answer..."
                ans.removeAt(0)
                if (eqs!!.isNotEmpty()) {
                    val num1 = view.findViewById<TextView>(R.id.number1TextView)
                    val oper = view.findViewById<TextView>(R.id.operatorTextView)
                    val num2 = view.findViewById<TextView>(R.id.number2TextView)
                    val eqString = eqs!!.get(0)
                    num1.text = eqString[0].toString()
                    oper.text = eqString[1].toString()
                    num2.text = eqString[2].toString()
                    eqs!!.removeAt(0)

                }
                else{
                    val bundle = Bundle()
                    bundle.putString("finalScore","You got $numCorrect out of $numOfQs")
                    findNavController().navigate(R.id.action_fragment2_to_fragment3,bundle)
                }
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
         * @return A new instance of fragment Fragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}