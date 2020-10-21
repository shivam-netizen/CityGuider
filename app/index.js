const express = require("express");
const bodyParser = require("body-parser");
const request = require("request");
const fetch = require("node-fetch");


const app = express();

app.use(bodyParser.urlencoded({extended: true}));

app.get("/",function(req,res){
  res.sendFile(__dirname + "/index.html");
});


app.post("/",function(req,res){
  // let url="https://apiv2.bitcoinaverage.com/indices/global/ticker/BTCUSD";
  //   fetch(url).then((response)=>{return response.json()}).then((data)=>{console.log(data)});

    request.get('https://apiv2.bitcoinaverage.com/convert/global?from=BTC&to=USD&amount=2', function (error, response, body) {
      console.log(body);
      res.send(body);
    });
});



// request.get('https://api.github.com/users', function (error, response, body) {
// // console.log('statusCode:', response && response.statusCode); // Print the response status code if a response was received
// // console.log('body:', body); // Print the HTML for the Google homepage.
// console.log(JSON.parse(body));


app.listen(3000,function() {
  console.log("Server is running on port 3000.");
});
