const ProductController = require("../controller/Product.Controllers")
const express = require("express")
const router = express.Router();
router.get("/",ProductController.read)
router.post("/",ProductController.create)
router.delete("/:id",ProductController.delete)
router.put("/:id",ProductController.update)
router.put("/:id/reserver",ProductController.Reserver)
router.put("/:id/liberer",ProductController.Liberer)
module.exports=router