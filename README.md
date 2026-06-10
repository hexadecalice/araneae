# Araneae 🕷️

## Project Description
Araneae is a CLI directory scanner for web applications.  
I designed Araneae as a side project to try to familiarize myself with Java's syntax for one of my classes.  
As such, I probably won't be updating it very often.


It's functionality is extremely straight forward. It takes in a wordlist file, with each word seperated by a newline.   
It then appends each word to the end of a specified website as a directory (like, www.website.com/word), and records the status code returned.   
It's designed to try to use lightweight HEAD requests first, but if it's given a 405 status it fallsback to a GET request.  
It logs the status codes and prints them to the terminal.  

This operation is currently single-threaded, but that may change. 

Before performing the scan, Araneae generates a UUID and similarly appends that as a directory.   
This is done to detect if a website uses "soft 404"s.  
If the UUID directory returns a 200 status code, the content-length is logged and soft404 is set to true.  
All future 200 status codes are checked against that content length, if its within an arbitrary number of bytes, its discarded with the 404s.  
If the content-length doesn't match, the page is downloaded and scanned for a list of 404-page related words.  
If one is found, the result is discarded, if not then its logged as a legitimate 200.  

The soft 404 detection is - quite frankly - over engineered to shit.  
If I remember correctly, one particular website was driving me insane by returning all 200's, and I added that feature as a result.  
Again, I doubt this project will see many updates, but thanks to everyone who gives it a look!  

## Prerequisites
To build and run Araneae, you will need the following installed on your system:
* **Java Development Kit (JDK) 17** or higher

## Building from Source
1. Clone the repository and navigate into the directory:
   `git clone https://github.com/hexadecalice/araneae.git`
   `cd araneae`

2. Compile the project and download dependencies:
   `mvn clean compile`

## Running the Scanner
You can run the scanner by using the following command:
`java -cp out com.github.hexadecalice.Main wordlist.txt targetwebsite.com`

Note: hostnames should be formatted as `hostname.com` without a protocol or www. prefix
