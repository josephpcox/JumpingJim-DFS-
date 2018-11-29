# Graph Modeling and Graph Algorithms README
## Joseph Cox (U00594912)

---
# Files
* README.html - Allows you to view the same information but much more elegently. I recommend viewing this file in the html through the browser
* makefile - Calling *make it* will compile and run the code, you could also use *javac Traverse.java* to compile and run it with *java Traverse* 
* Node.java - This is the class that contains the functions that solve the problem including the dfs sfunction that travese the maze 
* Traverse.java - This is the main() method it opens and writes the solution to the file.
* markdownfolder -contains the README.md and the REPORT.md used to generate the REPORT.pdf and the README.html
---

# makefile
* *make it* - compiles and runs the code
* *make* - compiles the code
* *make run* - will run the code only if the code was already compiled
* *make clean* - will delete all class files 
* *make cleanAll* - will delete all the class files and the output.txt
---

# compiler
Java 10 compiler from the standard JDK  was used, but I did test it with the java 5 compiler on the student cluster and it also works.
When testing on both compilers make sure all the .class files are removed before switching to another jdk compiler, be extra carful of this.
I had issues compiling because I did not notice that a .class file from a previous build was lingering in the source directory. 
