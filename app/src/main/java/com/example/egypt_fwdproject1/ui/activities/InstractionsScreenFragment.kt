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
import com.example.egypt_fwdproject1.databinding.FragmentInstractionsScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class InstractionsScreenFragment : Fragment() {
    private lateinit var mNavController : NavController
    lateinit var binding : FragmentInstractionsScreenBinding

    lateinit var databaseReference: DatabaseReference
    var database: FirebaseDatabase? = null

    private val mAuth : FirebaseAuth by lazy {
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
        binding = DataBindingUtil.inflate(inflater ,
            R.layout.fragment_instractions_screen, container, false)
        val view = binding.root

        database = FirebaseDatabase.getInstance()
        databaseReference = database!!.reference.child("users")

        binding.shoeListBtn.setOnClickListener {
            val action = InstractionsScreenFragmentDirections.actionInstractionsScreenFragmentToShoeListingScreenFragment()
            mNavController.navigate(action)
        }
        return view
    }

    fun loadProfile()
    {
        val user = mAuth.currentUser
        val userreferance = databaseReference.child(user?.uid!!)

        binding.textView4.text = "Email - - > " +user.email
        userreferance.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.textView3.text = "Name - - > "+snapshot.child("name").value.toString()
                //binding.textView4.text = snapshot.child("email").value.toString()

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }


}