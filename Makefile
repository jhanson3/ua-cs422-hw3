JFLAGS = -g
JC = javac
		  
all: Barber

default: Barber

Barber: 
	javac Barber.java BarberJobs.java Customer.java

clean:
	$(RM) *.class