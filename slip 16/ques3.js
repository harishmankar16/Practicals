const express = require('express')
const bodyParser = require('body-parser')
const mongoose = require('mongoose')

const app = express()
const port = 3000

mongoose.connect("mongodb://localhost:27017/Blog")
.then(()=>{
    console.log('====================================');
    console.log("connected");
    console.log('====================================');
})
.catch((e)=>{
    console.log(e);
})

const 