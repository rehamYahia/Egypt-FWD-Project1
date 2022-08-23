package com.example.egypt_fwdproject1.ui.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.egypt_fwdproject1.R
import com.example.egypt_fwdproject1.databinding.FragmentShoeDetailScreenBinding
import com.example.egypt_fwdproject1.model.ShoeModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class ShoeDetailScreenFragment : Fragment() {

    lateinit var binding : FragmentShoeDetailScreenBinding
    lateinit var mDatabaseReference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater ,
            R.layout.fragment_shoe_detail_screen, container, false)
        val view = binding.root

        binding.addToStoreBtn.setOnClickListener {
            insertDataToDatabase()
        }


        return view
    }

    fun insertDataToDatabase()
    {
        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")

        /*
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Shoe Data")
        var shoeKey = mDatabaseReference.push().key
        var model = ShoeModel(shoeKey,binding.shoeNameEditText.text.toString(),binding.shoeSizeEditText.text.toString(),
                                binding.companyNameEditText.text.toString(),binding.descEditText.text.toString())

        mDatabaseReference.child(shoeKey).setValue(model)

         */
    }




}