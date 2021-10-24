const express=require("express");
const bodyParser=require("body-parser");

const db = require("./config/Database")
const app=express();
// import router
app.use(express.json())
const ProductRouter = require("./Router/Product.Router")
app.use("/Product",ProductRouter)
app.listen(8083,function(){
    console.log("start server")
})

