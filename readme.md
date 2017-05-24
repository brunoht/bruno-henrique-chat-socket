# bruno-henrique-chat-socket
This project goals practicing raw Java knowledge to build a 
chat application. It will serve a connection through network 
using TCP protocol.

## Overview

### Goals to achieve
* Serve a central point for connection
* Clients must be connected to the server in order to start conversation
* Interaction:
    * LIB - YES - Import to a project as a Java library
    * EXE - YES - Run as .jar application using terminal
    * API - YES - Application Programming Interface as Java library
    * CLI - YES - Command Line Interface
    * GUI - NO  - Graphic User Interface
    * WEB - NO  - Web User Interface

### Specification
#### Server
* Send a welcome message when user enters (connects) de chat
* Allows up to 10 connections simultaneously
* Receives a client message e send to all connected clients
* When sending a receive message to all users, it must concatenate
Data, Time, Username to the message
* Threads every incoming message as an individual event and allows
 multiple messages at the same time
* count the number of active connections and print it on console
on every change
* Allows to kick individual or all connected clients

#### Client
* Send message to all connected users
* Defines an automatically name for the connected client
* Allows users change its own name, but validate it checking 
if there's another client using the same name

## Instructions

### Installation

### Configuration

### Running
#### Server
```
java -jar chat-socket.jar --method=server --port=8000
```

##### Commands
Kick a client by its ID
```
!kick [id]
```

Kick a client by username
```
!kick [username]
```

Disconnect all clients
```
!kick all
```

#### Clients
```
java -jar chat-socket.jar --method=client --port=8000
```

#### Both
Close application
```
!close
```
