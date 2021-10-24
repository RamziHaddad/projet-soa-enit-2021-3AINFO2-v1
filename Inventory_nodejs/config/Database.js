const mongoose =require("mongoose");
const db ='mongodb://localhost:27017/aos';
mongoose.connect(db).then(() => {
    console.log("Successfully connect to MongoDB.");
  })
  .catch(err => {
    console.error("Connection error", err);
    process.exit();
  });

mongoose.Promise = global.Promise;
mongoose.connection.on("error",console.error.bind(console,"Mongodb connection error"))
module.exports=mongoose;

