const mongoose = require("mongoose");

mongoose
  .connect("mongodb://localhost:27017/Blog", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => console.log("Connected to MongoDB"))
  .catch((err) => console.error("Failed to connect to MongoDB", err));

// const ugSchema = new mongoose.Schema({
//   name: String,
//   rollNumber: Number,
// });

// const pgSchema = new mongoose.Schema({
//   name: String,
//   rollNumber: Number,
// });

// const ugModel = mongoose.model("Ug", ugSchema);
// const pgModel = mongoose.model("Pg", pgSchema);

// const newUgStudent = new ugModel({
//   name: "harish",
//   rollNumber: 1,
// });

// newUgStudent
//   .save()
//   .then(() => console.log("UG Student saved successfully"))
//   .catch((err) => console.error("Failed to save UG Student", err));

// const newPgStudent = new pgModel({
//   name: "priyanka",
//   rollNumber: 3,
// });

// newPgStudent
//   .save()
//   .then(() => console.log("PG Student saved successfully"))
//   .catch((err) => console.error("Failed to save PG Student", err));
