package com.example.project3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment3 : Fragment() {
    /**
     * Fragment 3 uses the parameters to store the values it holds
     *
     * @param param1 Parameter 1 - String.
     * @param param2 Parameter 2 - String.
     */

    private var param1: String? = null
    private var param2: String? = null
    val args: Fragment3Args by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * Overriding the onCreate() to accommodate the values save instance states and replaces any
         * previous instances of the state
         * *
         * @param Bundle
         * @return A new instance of fragment Fragment3.
         */
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        /**
         * By overwriting onCreateView we are able to dictate the layout that will be inflated and retrieve
         * the results from the user's input and displaying it on the screen
         *
         * @param LayoutInflater inflater
         * @param ViewGroup container
         * @param savedInstanceState Bundle
         * @return the view
         */

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_3, container, false)
        var results = args.finalScore
        // shows the answers and retives them from the safe args passed into fragment 3 by fragment 2
        var answerText = view.findViewById<TextView>(R.id.answers)
        answerText.text = results
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         * Overriding the onViewCreate() to direct Fragment3 to Fragmetn 2 when the button "Retry" is
         * pressed
         *
         * @param view View
         * @param savedInstanceState Bundle
         * @return A new instance of fragment Fragment3.
         */

        // when they want to retry -> go back to fragment 1
        val buttonRetry = view.findViewById<Button>(R.id.buttonRetry)
        buttonRetry.setOnClickListener {
            findNavController().navigate(R.id.action_fragment3_to_fragment1)
        }
    }
    companion object {
        /**
         * The companion object is used when passing parameters as an argument and passing the values
         * to this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}