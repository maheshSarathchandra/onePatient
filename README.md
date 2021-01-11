# Personal Note API</br>


## Required bellow things to intall for running this application</br>
JDK 1.8 or later</br>
maven 3.2 or later</br>
mongodb</br>

## Steps to up and running this application</br>

* Start mongdb in your local machine</br>
* open the location of spring boot project folder using IDE or cmd</br>
* Start to run Spring boot project</br>



## Assumption</br>
* The Note message is conating only String</br>
* it is not using different kind of authetication to secure api</br>

## Rest APIs</br>

### using postman response</br>

* #### Save new note</br>

api:http://localhost:8080/note</br>

sample request body:</br>
{</br>
    "title": "greeting",</br>
    "content": "good morning",</br>
    "userId": 3,</br>
    "archive": "no"</br>
}</br>
response:</br>
{</br>
    "id": "5ff930053a6c934cc0d4705f",</br>
    "title": "greeting",</br>
    "content": "good morning",</br>
    "userId": 3,</br>
    "archive": "no"</br>
}</br>


* #### Update previously saved note

api:http://localhost:8080/note/{noteId}/{userId}</br>
example : http://localhost:8080/note/5ff930903a6c934cc0d47060/3</br>

sample request body:</br>
{</br>
    "title": "greeting",</br>
    "content": "good evening",</br>
    "userId": 3,</br>
    "archive": "no"</br>
}</br>
response</br>
{</br>
    "id": "5ff930903a6c934cc0d47060",</br>
    "title": "greeting",</br>
    "content": "good afterNoon",</br>
    "userId": 3,</br>
    "archive": "no"</br>
}</br>

* #### Delete saved note</br>

api:http://localhost:8080/note/{noteId}/{userId}</br>
example : http://localhost:8080/note/5ff930903a6c934cc0d47060/3</br>

sample request body:</br>
{</br>
    "title": "greeting",</br>
    "content": "good evening",</br>
    "userId": 3,</br>
    "archive": "no"</br>
}</br>
response:</br>
Status 202 Accepted</br>



* #### Archive and unarchive note</br>

api:http://localhost:8080/note/{noteId}/{userId}/{archiveFlag}</br>

example for archive : http://localhost:8080/note/5ff930903a6c934cc0d47060/3/yes</br>

sample request body:</br>
{</br>
    "title": "greeting",</br>
    "content": "good evening",</br>
    "userId": 3,</br>
    "archive": "no"</br>
}</br>

response:</br>
{  </br> 
    "id": "5ff930903a6c934cc0d47060",</br>
    "title": "greeting",</br>
    "content": "good evening",</br>
    "userId": 3,</br>
    "archive": "yes"</br>
}</br>


example for unarcive :http://localhost:8080/note/5ff930903a6c934cc0d47060/3/no</br>

sample request body:</br>
{</br>
    "title": "greeting",</br>
    "content": "good evening",</br>
    "userId": 3,</br>
    "archive": "yes"</br>
}</br>
response:</br>
{</br>
    "id": "5ff930903a6c934cc0d47060",</br>
    "title": "greeting",</br>
    "content": "good afterNoon",</br>
    "userId": 3,</br>
    "archive": "no"</br>
}</br>

* #### List save notes that are not archived</br>

api:http://localhost:8080/note/{userId}/{archiveFlag}</br>

example for unarchive list : http://localhost:8080/note/3/no</br>

response:</br>
[
    {
        "id": "5ff909023a6c934a0c762c15",
        "title": "accoring",
        "content": "getting",
        "userId": 3,
        "archive": "no"
    },</br>
    {
        "id": "5ff930053a6c934cc0d4705f",
        "title": "greeting",
        "content": "good morning",
        "userId": 3,
        "archive": "no"
    },</br>
    {
        "id": "5ff930903a6c934cc0d47060",
        "title": "greeting",
        "content": "good evening",
        "userId": 3,
        "archive": "no"
    }
]</br>


example for arcive :http://localhost:8080/note/3/yes</br>

response:</br>
[
    {
        "id": "5ff908d03a6c934a0c762c14",
        "title": "maaaaa",
        "content": "amoaokaoa",
        "userId": 3,
        "archive": "yes"
    },</br>
    {
        "id": "5ff930053a6c934cc0d4705f",
        "title": "greeting",
        "content": "good morning",
        "userId": 3,
        "archive": "yes"
    },</br>
    {
        "id": "5ff930903a6c934cc0d47060",
        "title": "greeting",
        "content": "good evening",
        "userId": 3,
        "archive": "yes"
    }
]

## Reasons for choosing this technology
* spring boot is best java based backend development framework. it supports many databases as well. 
it can used to easly expand this application further using microservice architecture
* mongodb is best object oriented database.it is performance is very well. it can be archive high througth put. 
therefore it can be used to further development as well in this project

## Considering Further improvement
* it should be added authentication for the apis
* unit test cases shoud be added(Spring boot test using mock beans)
* futher bean configuration because of autowiring is not best practic in bean inject
* error handling shoud be done  using custom error handlers
* considering expand ,the system should be expand for different type of note(with hashtag,numbers,large size, file that is included many notes)
