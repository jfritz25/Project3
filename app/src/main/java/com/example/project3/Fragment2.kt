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
import androidx.navigation.fragment.navArgs
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
    val args: Fragment2Args by navArgs()
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
        // creates the view that is seen in the fragment 2 when the user is entering values for desired difficulty level and operator
        var eqs = ArrayList(args.eqs.toList())
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        val num1 = view.findViewById<TextView>(R.id.number1TextView)
        val operView = view.findViewById<TextView>(R.id.operatorTextView)
        val num2 = view.findViewById<TextView>(R.id.number2TextView)
        val eqString = eqs!!.get(0)
        val oper = args.type
        val operLoc = eqString.indexOf(oper)
        num1.text = eqString.subSequence(0,operLoc).toString()
        operView.text = eqString[operLoc].toString()
        num2.text = eqString.subSequence(operLoc + 1, eqString.length).toString()
        eqs.removeAt(0)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // instanciation of the lists used to build up the expected and user given outputs
        super.onViewCreated(view, savedInstanceState)
        var eqs = ArrayList(args.eqs.toList().subList(1, args.eqs.size))
        var ans = ArrayList(args.ans.toList())
        val numOfQs = args.numofQs
        var numCorrect = 0
        val buttonDone = view.findViewById<Button>(R.id.buttonDone)
        buttonDone.setOnClickListener {
            // finds the answer and determines if it matches the expected response (rounding is used in division)
            if (ans!!.isNotEmpty()) {
                val userInput = view.findViewById<EditText>(R.id.userAnswer)
                val userAnswer = round(userInput.text.toString().toDouble() * 100) / 100
                val correctAnswer = round(ans!!.get(0).toDouble() * 100) / 100
                if (userAnswer == correctAnswer) {
                    numCorrect++
                }
                userInput.setText("")
                userInput.hint = "Your Answer..."
                ans.removeAt(0)
                // evaluates the given response and determines the score for the user
                if (eqs!!.isNotEmpty()) {
                    val num1 = view.findViewById<TextView>(R.id.number1TextView)
                    val operView = view.findViewById<TextView>(R.id.operatorTextView)
                    val num2 = view.findViewById<TextView>(R.id.number2TextView)
                    val eqString = eqs!!.get(0)
                    val oper = args.type
                    val operLoc = eqString.indexOf(oper)
                    num1.text = eqString.subSequence(0,operLoc).toString()
                    operView.text = eqString[operLoc].toString()
                    num2.text = eqString.subSequence(operLoc + 1, eqString.length).toString()
                    eqs!!.removeAt(0)

                }
                // passes the score info from fragment 2 -> fragment 3
                else{
                    val action = Fragment2Directions.actionFragment2ToFragment3("You got $numCorrect out of $numOfQs")
                    findNavController().navigate(action)
                }
            }

        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters with safe args.
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