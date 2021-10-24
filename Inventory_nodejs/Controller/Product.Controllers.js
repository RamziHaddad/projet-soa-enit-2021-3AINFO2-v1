const ProductModel=require("../Model/Product.model")


module.exports={
    create: function(req,res,next) {
        const Product = new ProductModel(req.body)
        console.log(req.body)
        Product.save(req.body,function(err , item){
            if(err) {
                res.status(406).json({status: 406,message:'error create Product'+err,data:null})

            }
            else {
                res.status(201).json({status:201,message:'create Product',data:item})
            }
        })
    },
    update: function(req,res,next) {
        ProductModel.findByIdAndUpdate(req.params.id,req.body,{new:true},function(err,item){
            if(err) {
                res.status(406).json({status: 406,message:'error update Products',data:null})

            }
            else {
                res.status(200).json({status:200,message:'update Products',data:item})
            }
        })

    },
    read: function(req,res,next) {
        ProductModel.find({},function(err,item){
            if(err) {
                res.status(406).json({status: 406,message:'error read all Products',data:null})

            }
            else {
                res.status(201).json({status:201,message:'read all Products',data:item})
            }
        })

    },

    delete: function(req,res,next) {
        ProductModel.findByIdAndRemove(req.params.id,function(err,item){
            if(err) {
                res.status(406).json({status: 406,message:'error delete Products',data:null})

            }
            else {
                res.status(201).json({status:200,message:'delete Product',data:item})
            }
        })


    },

    FindById : function(req,res,next){
        ProductModel.findById(req.params.id,function(err,item){
            if(err) {
                res.status(406).json({status: 406,message:'error Find Products ID',data:null})

            }
            else {
                res.status(201).json({status:200,message:'Find Product',data:item})
            }
        })
    },
    
    Reserver:function(req,res,next){
        ProductModel.findById(req.params.id)
    }
}