const express = require('express');
const MongoClient = require('mongodb').MongoClient;

const app = express();

const url = 'mongodb://localhost:27017';
const dbName = 'movieDatabase';


MongoClient.connect(url, { useUnifiedTopology: true }, function(err, client) {
    if (err) {
        console.log("Error connecting to MongoDB:", err);
        return;
    }

    console.log("Connected to MongoDB");

    const db = client.db(dbName);

    db.createCollection('Film', function(err, res) {
        if (err) throw err;
        console.log("Collection 'Film' created");

      
        const films = [
            { title: 'Inception', director: 'Christopher Nolan', year: 2010 },
            { title: 'The Shawshank Redemption', director: 'Frank Darabont', year: 1994 },
            { title: 'The Godfather', director: 'Francis Ford Coppola', year: 1972 }
        ];
        db.collection('Film').insertMany(films, function(err, res) {
            if (err) throw err;
            console.log("Documents inserted into 'Film' collection:", res.insertedCount);
        });
    });

   
    db.createCollection('AnotherCollection', function(err, res) {
        if (err) throw err;
        console.log("Collection 'AnotherCollection' created");

        
        const documents = [
            { name: 'Document 1', category: 'Category 1' },
            { name: 'Document 2', category: 'Category 2' },
            { name: 'Document 3', category: 'Category 3' }
        ];
        db.collection('AnotherCollection').insertMany(documents, function(err, res) {
            if (err) throw err;
            console.log("Documents inserted into 'AnotherCollection' collection:", res.insertedCount);
            client.close();
        });
    });
});


const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
