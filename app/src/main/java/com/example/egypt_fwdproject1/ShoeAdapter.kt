package com.example.egypt_fwdproject1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.egypt_fwdproject1.databinding.ListBinding
import com.example.egypt_fwdproject1.model.ShoeModel
import kotlinx.android.synthetic.main.list.view.*

class ShoeAdapter : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder> {

    var arrayList = ArrayList<ShoeModel>()

    constructor(arrayKist:ArrayList<ShoeModel> )
    {
        this.arrayList = arrayList

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false)
        var shoeViewHolder = ShoeViewHolder(view)
        return shoeViewHolder
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        holder.shoeName = arrayList.get(position).shoeName
        holder.shoeSize = arrayList.get(position).shoeSize
        holder.desc = arrayList.get(position).desc
        holder.company = arrayList.get(position).company

    }

    override fun getItemCount(): Int {
       return arrayList.size
    }



    class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var shoeName:String = itemView.shoeName.text.toString()
    var shoeSize:String = itemView.shoeSize.text.toString()
    var company:String = itemView.company.text.toString()
    var desc:String = itemView.description.text.toString()



    }


}