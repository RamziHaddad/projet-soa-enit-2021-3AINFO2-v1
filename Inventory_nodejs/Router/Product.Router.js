const ProductController = require("../controller/Product.Controllers")
const express = require("express")
const router = express.Router();
router.get("/",ProductController.read)
router.get("/:id",ProductController.FindById)
router.post("/",ProductController.create) 
router.delete("/:id",ProductController.delete)
router.put("/:id",ProductController.update)
module.exports=router