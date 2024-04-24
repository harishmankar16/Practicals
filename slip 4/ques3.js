const express = require('express');
const app = express();

const students = [
    { id: 1, name: "Alice" },
    { id: 2, name: "Bob" },
    { id: 3, name: "Charlie" },
  ];
  
  const courses = [
    { id: 1, name: "Mathematics" },
    { id: 2, name: "Science" },
    { id: 3, name: "History" },
  ];

app.get("/",(req,res)=>{
    res.send("Welcome to elearning system")
})

app.get("/students",(req,res)=>{
    res.json(students);
})

app.get("/courses",(req,res)=>{
    res.json(courses);
    
})

app.listen(3000,()=>{
    console.log("server started at 3000")
})