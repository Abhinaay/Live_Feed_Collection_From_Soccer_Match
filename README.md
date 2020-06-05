# Live_Feed_Collection_From_Soccer_Match

## What is the MEAN stack?

The MEAN stack can be summarized as follows:

* M = MongoDB/Mongoose.js: the popular database, and an elegant         ODM for node.js.
* E = Express.js: a lightweight web application framework.
* A = Angular.js: a robust framework for creating HTML5 and             JavaScript-rich web applications.
* N = Node.js: a server-side JavaScript interpreter.

## What is a REST API?

REST stands for Representational State Transfer. It is a lighter weight alternative to SOAP and WSDL XML-based API protocols.

REST uses a client-server model, where the server is an HTTP server and the client sends HTTP verbs (GET, POST, PUT, DELETE), along with a URL and variable parameters that are URL-encoded. The URL describes the object to act upon and the server replies with a result code and valid JavaScript Object Notation (JSON).

Because the server replies with JSON, it makes the MEAN stack particularly well suited for our application, as all the components are in JavaScript and MongoDB interacts well with JSON.

The CRUD acronym is often used to describe database operations. CRUD stands for CREATE, READ, UPDATE, and DELETE. These database operations map very nicely to the HTTP verbs, as follows:

    POST: A client wants to insert or create an object.
    GET: A client wants to read an object.
    PUT: A client wants to update an object.
    DELETE: A client wants to delete an object.

Some of the common HTTP result codes that are often used inside REST APIs are as follows:

    200 - “OK”.
    201 - “Created” (Used with POST).
    400 - “Bad Request” (Perhaps missing required parameters).
    401 - “Unauthorized” (Missing authentication parameters).
    403 - “Forbidden” (You were authenticated but lacking required privileges).
    404 - “Not Found”.

## Creating our REST API

The application that we will be building will be an RSS Aggregator, similar to Google Reader. Our application will have two main components:

1.  The REST API
2. Feed Grabber (similar to Google Reader)

**We will begin by defining the data model for the following requirements:**

* Store user information in user accounts
* Track RSS feeds that need to be monitored
* Pull feed entries into the database
* Track user feed subscriptions
* Track which feed entry a user has already read

**Users will be able to do the following:**

* Create an account
* Subscribe/unsubscribe to feeds
* Read feed entries
* Mark feeds/entries as read or unread

## Modeling Our Data

We will need 4 collections to manage this information:

* Feed collection
* Feed entry collection
* User collection
* User-feed-entry mapping collection

Let’s take a closer look at each of these collections.

### Feed Collection





