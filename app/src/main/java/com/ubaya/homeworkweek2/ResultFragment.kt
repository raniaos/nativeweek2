package com.ubaya.homeworkweek2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val point = ResultFragmentArgs.fromBundle(requireArguments()).point
            textScore.text = "Your score is $point"
        }
        buttonBack.setOnClickListener {
            val action = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}