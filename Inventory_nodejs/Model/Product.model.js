const mongoose = require('mongoose')
const Schema = mongoose.Schema
const ProductSchema = new Schema({
    price :{
        type:String,
        trim : true, 
        required:true
    },
    name : {
        type:String,
        trim : true,
        required:true
    },
    refProduct :{
        type:String,
        trim : true,
       required:true
    },
    description :{
        type:String,
        trim : true,
        required:true
    },
    qte : {
        type:Number,
        required:true
    },
    etat:{
        type:String,
        trim:true,
        required:true
    }

})

module.exports=mongoose.model("Products",ProductSchema);