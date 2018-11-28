JFLAGS = -g -Xlint
JC = javac
MAKEIT = make run
Traverse.class:Traverse.java
	$(JC) $(JFLAGS) Traverse.java
Node.class:Node.java
	$(JC) $(JFLAGS) Node.java
run:
	java Traverse
clean:
	rm *.class
it:
	$(MAKE)
	$(MAKEIT) 