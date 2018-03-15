JFLAGS = -g
JC = javac
		  
all: classes

default: classes

classes: 
	javac Barber.java BarberJobs.java Customer.java

clean:
	$(RM) *.class