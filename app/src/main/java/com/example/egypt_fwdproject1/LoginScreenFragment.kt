package com.example.egypt_fwdproject1

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.egypt_fwdproject1.databinding.FragmentLoginScreenBinding
import com.google.firebase.auth.FirebaseAuth


class LoginScreenFragment : Fragment()  {

    private lateinit var mNavController : NavController
    lateinit var binding : FragmentLoginScreenBinding

     val mAuth : FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNavController = findNavController()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_screen, container, false)
        val view =  binding.root

       // binding.emailSignip.addTextChangedListener(this)
        //binding.passwordSignip.addTextChangedListener(this@LoginScreenFragment)

        binding.signupBtn.setOnClickListener {
            val action2 = LoginScreenFragmentDirections.actionLoginScreenFragmentToSignUpFragment()
            mNavController.navigate(action2)
        }

        binding.loginBtn.setOnClickListener {
            val email = binding.emailSignip.text.toString()
            val password = binding.passwordSignip.text.toString()

            if (TextUtils.isEmpty(email))
        {
            binding.emailSignip.setError("please enter your email")
            return@setOnClickListener
        }
        else if(TextUtils.isEmpty(password))
        {
            binding.passwordSignip.setError("please enter your password")
            return@setOnClickListener
        }

            if( email.isNotEmpty() && password.isNotEmpty())
            {
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                    if(it.isSuccessful){

                        val action1 = LoginScreenFragmentDirections.actionLoginScreenFragmentToWelcomeScreenFragment()
                        mNavController.navigate(action1)
                    }

                }
            }


        }

        return view
    }


/*
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
      binding.loginBtn.isEnabled = binding.emailSignip.text.trim().isNotEmpty()
              && binding.passwordSignip.text.trim().isNotEmpty()


    }

    override fun afterTextChanged(s: Editable?) {
        TODO("Not yet implemented")
    }
    */



}