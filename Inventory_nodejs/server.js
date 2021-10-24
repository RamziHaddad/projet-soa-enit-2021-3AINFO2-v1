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

/* 
inventory : responsable de
la gestion des quantités de produits dans le stock
la réservation de produits d'une commande en attente de paiement.
la libération de commandes annulées
la préparation des commandes payées pour livraison.
*/