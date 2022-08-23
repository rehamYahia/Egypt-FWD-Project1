package com.example.egypt_fwdproject1.model

 class ShoeModel {
     lateinit var shoeKey:String
      lateinit var shoeName:String
      lateinit var shoeSize:String
      lateinit var company:String
      lateinit var desc:String

      constructor(shoeKey:String , shoeName:String , shoeSize:String ,company:String , desc:String)
      {
          this.shoeKey = shoeKey
          this.shoeName = shoeName
          this.shoeSize = shoeSize
          this.company = company
          this.desc = desc

      }


}