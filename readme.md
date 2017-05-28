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
    
### Core Details

#### Layers Hierarchy

* ChatSocketApplication   -   Where the application starts
* Application             -   Register de dependency injections. Implements the method responsible for 
                            initializate the application 
* Routes                  -   Register the routes
* Controllers             -   Implement business rules and application logic
* Handlers                -   These are middleware classes that intermediates Controllers and Services to 
                              execute background commands like the one to close application. It receives
                              a user input from terminal and check if is a command or just a message. If it is
                              a command, executes the command, if not it just shows the message on clients
* Services                -   Implement the methods that will execute actions and functions
* Models                  -   Classes of object models


### Specification
#### Server
* Send a welcome message when user enters (connects) de chat
* Allows unlimited simultaneous connections
* Receives a client message e send to all connected clients
* When sending a receive message to all users, it must concatenate
Username to the message
* Threads every incoming message as an individual event and allows
 multiple messages at the same time
* Allows to kick individual or all connected clients

#### Client
* Send message to all connected users
* Allows users choose its own name when connecting to the server

## Instructions
### Download
#### From Github
* Access https://github.com/brunoht/bruno-henrique-chat-socket or download it directly from
https://github.com/brunoht/bruno-henrique-chat-socket/archive/master.zip
* Once you have the source code you must build your application
    * using IntelliJ IDEA IDE: https://www.jetbrains.com/help/idea/2017.1/working-with-artifacts.html
    * using Eclipse IDE: https://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Ftasks%2Ftasks-35.htm
    * using Java CLI: https://docs.oracle.com/javase/tutorial/deployment/jar/build.html
    
#### From Repository
https://sites.google.com/a/lohl.com.br/repository/chat-socket

### Installation
After downloading or building chat-socket.jar place this file on:
```
c:/chat
```

### Running
#### Server
```
// Sintax:
java -jar chat-socket.jar server [portNumber]

// Example:
java -jar chat-socket.jar server 8000
```

##### Commands
Kick a client by username (not implemented yet)
```
!kick [username]
```

Disconnect all clients (not implemented yet)
```
!kick all
```

#### Clients
```
// Sintax:
java -jar chat-socket.jar client [address] [portNumber] [username]

// Example:
java -jar chat-socket.jar client localhost 8000 myname
```

##### Commands
Set a new username (not implemented yet)
```
!username [new_username]
```

Close connection and finish client application
```
!close
```

Close all connections and finish server application
```
!close-server
```

## References
https://docs.oracle.com/javase/tutorial/networking/TOC.html