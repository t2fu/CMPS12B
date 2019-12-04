#------------------------------------------------------------------------------
#Makefile
#Programmer: Tiancheng Fu
#CMPS 12M
#cruzid: tfu6
#Date: July 3rd, 2018
#This is is a Makefile with macros and it use HelloUser.java and HelloUser2.java to create a JARFILE calls Hello
#------------------------------------------------------------------------------

JAVASRC = HelloUser.java HelloUser2.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = HelloUser2
CLASSES = HelloUser.class HelloUser2.class
JARFILE = Hello
SUBMIT = submit cmps012b-pt.u18 lab1

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)


$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)
check:
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.u18/lab1/tfu6
