var express = require('express');
var bodyParser = require('body-parser');
var app = express();

var port = process.env.PORT || 4200;

var users  = [
    {
        name: "Usamah",
        age: 22
    },
    {
        name: "Sean",
        age: 21
    },
    {
        name: "Bob",
        age: 25
    }
]

app.use(bodyParser.json())

app.get('/users', (req, res) => {res.send(
        users
    )}
)

app.get('/users/id', (req, res) => {res.send(
        users[req.query.id]
    )}
)

app.post('/users/save', (req, res)=>{
    let newObj = {
        name: req.body.name,
        age: parseInt(req.body.age)
    }
users.push(newObj)
{res.send(
        newObj
    )}}
)

app.get('/', (req, res) => {res.send('Hello from Sean!')} )

app.listen(port, () => {console.log(`listening on port`, port)})