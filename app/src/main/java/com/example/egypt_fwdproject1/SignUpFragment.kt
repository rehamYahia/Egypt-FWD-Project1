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
import com.example.egypt_fwdproject1.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SignUpFragment : Fragment()  {

    lateinit var binding : FragmentSignUpBinding
    private lateinit var mNavController : NavController
    lateinit var databaseReference:DatabaseReference
    var database:FirebaseDatabase? = null

    private val mAuth : FirebaseAuth by lazy {
        FirebaseAuth.getInstance()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNavController = findNavController()
        database = FirebaseDatabase.getInstance()
        databaseReference = database!!.reference.child("users")


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_sign_up, container, false)
        val view = binding.root

        //binding.nameSignup.addTextChangedListener(this)
       // binding.emailSignup.addTextChangedListener(this)
       // binding.passwordSignup.addTextChangedListener(this)

        binding.tSignup.setOnClickListener {
            val name = binding.nameSignup.text.toString().trim()
            val email = binding.emailSignup.text.toString().trim()
            val password = binding.passwordSignup.text.toString().trim()

            if(TextUtils.isEmpty(name))
            {
                binding.nameSignup.setError("please enter your name")
                return@setOnClickListener
            }
            else if (TextUtils.isEmpty(email))
            {
                binding.emailSignup.setError("please enter your email")
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(password))
            {
                binding.emailSignup.setError("please enter your password")
                return@setOnClickListener
            }
            if(name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty())
            {
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                    if(it.isSuccessful){
                        val currentUser = mAuth.currentUser
                        var currentUerDB = databaseReference.child(currentUser?.uid!!)
                        currentUerDB.child("name").setValue(binding.nameSignup.text.toString())
                        currentUerDB.child("email").setValue(binding.emailSignup.text.toString())
                        currentUerDB.child("password").setValue(binding.passwordSignup.text.toString())

                        val action = SignUpFragmentDirections.actionSignUpFragmentToLoginScreenFragment()
                        mNavController.navigate(action)

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
        binding.tSignup.isEnabled = binding.nameSignup.text.trim().isNotEmpty()
                && binding.emailSignup.text.trim().isNotEmpty()
                && binding.passwordSignup.text.trim().isNotEmpty()


    }

    override fun afterTextChanged(s: Editable?) {
        TODO("Not yet implemented")
    }

     */


}