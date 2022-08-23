package com.example.egypt_fwdproject1.ui.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.egypt_fwdproject1.R
import com.example.egypt_fwdproject1.databinding.FragmentWelcomeScreenBinding


class WelcomeScreenFragment : Fragment() {
    private lateinit var mNavController : NavController

    lateinit var binding : FragmentWelcomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNavController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater ,
            R.layout.fragment_welcome_screen, container, false)
        val view = binding.root

        binding.instructionsScreenBtn.setOnClickListener {
            val action = WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstractionsScreenFragment()
            mNavController.navigate(action)

        }
        return view
    }


}