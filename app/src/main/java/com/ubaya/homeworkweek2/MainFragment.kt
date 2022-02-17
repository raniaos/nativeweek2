package com.ubaya.homeworkweek2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    var num1 = 0
    var num2 = 0
    var point = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        randomNumber()
        point = 0
        buttonSubmit.setOnClickListener {
            if ((num1 + num2) == Integer.parseInt(editAnswer.text.toString())) {
                point++
                randomNumber()
            }
            else {
                val action = MainFragmentDirections.actionResultFragment(point)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    fun randomNumber() {
        num1 = (1..100).random()
        num2 = (1..100).random()
        textNumber1.text = num1.toString()
        textNumber2.text = num2.toString()
        editAnswer.text?.clear()
    }
}