Nucleus Server
================

This is the HTTP server for Project Nucleus. 

This project contains just one main verticle which is responsible for spawning off of HTTP Server. This is the gateway to Nucleus components.

TODO
----
* Provide authorization/authentication for the end points. Based on success or failure, either provide response to caller or pass on auth data to other subsystems
* Provide any other throttling or gateway characteristics that we need

To understand build related stuff, take a look at **BUILD_README.md**.


