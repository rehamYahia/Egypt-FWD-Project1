package com.example.egypt_fwdproject1.ui.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.egypt_fwdproject1.R
import com.example.egypt_fwdproject1.ShoeAdapter
import com.example.egypt_fwdproject1.databinding.FragmentShoeListingScreenBinding
import com.example.egypt_fwdproject1.model.ShoeModel


class ShoeListingScreenFragment : Fragment() {
    lateinit var binding : FragmentShoeListingScreenBinding
    private lateinit var mNavController : NavController
    lateinit var recyclerView: RecyclerView
    lateinit var arrayList :ArrayList<ShoeModel>
    lateinit var shoeAdapter :ShoeAdapter

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
            R.layout.fragment_shoe_listing_screen, container, false)
        val view = binding.root
        initRecyclerView()

        binding.floatBtn.setOnClickListener{

            val action = ShoeListingScreenFragmentDirections.actionShoeListingScreenFragmentToShoeDetailScreenFragment()
            mNavController.navigate(action)
        }


        binding.loggout.setOnClickListener {

        }
        return view
    }

    fun initRecyclerView()
    {

        recyclerView = binding.shoeRecyclerView
        arrayList = ArrayList()
        var model1 = ShoeModel("bghbh","40","fn","fkfmk","mkmfkfme")
        var model2 = ShoeModel("bghbh","40","fn","fkfmk","fmierfm")
        var model3 = ShoeModel("bghbh","40","fn","fkfmk","firfm")
        var model4 = ShoeModel("bghbh","40","fn","fkfmk","mfifmi")
        arrayList.add(model1)
        arrayList.add(model2)
        arrayList.add(model3)
        arrayList.add(model4)
        shoeAdapter = ShoeAdapter(arrayList)
        recyclerView.adapter = shoeAdapter


    }


}