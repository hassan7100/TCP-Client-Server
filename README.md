# Server
The server binds to port number 3000, and keep on waiting for connections requests to be received from clients. The client sends the double values,
which the server will send back to the client sorted in ascending order. In addition, the server keeps a log file named log.txt, in which it logs the date/time info and info of clients addressing
(IP address in dotted decimal notation and port number) and their sorted numbers.The server is multi-threaded such that more than client connection can be handled at the same time.
# Client
The client reads the double values from the user, until the user enters -1 (positive doubles are only assumed to be entered).
It must send these double values to the server, then wait for the server response. When the response is received,
it must print the returned sorted numbers to the console.

