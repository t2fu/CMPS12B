#------------------------------------------------------------------------------
# Makefile for CMPS 12B pa4
# Programmer: Tiancheng Fu
# CMPS 12B
# Date: August 6th, 2018
# Cruzid: tfu6
# This is a Makefile for java files in pa4
# This Makefile uses wildcards and pattern substitution
#------------------------------------------------------------------------------

JAVAC      = javac 
MAINCLASS  = Simulation
JAVASRC    = $(wildcard *.java)
SOURCES    = $(JAVASRC) makefile README
CLASSES    = $(patsubst %.java, %.class, $(JAVASRC))
JARCLASSES = $(patsubst %.class, %*.class, $(CLASSES))
JARFILE    = $(MAINCLASS) 


all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(JARCLASSES)
	chmod +x $(JARFILE)
	rm Manifest

%.class: %.java
	$(JAVAC) $<

clean:
	rm *.class $(JARFILE)

check:
	
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.u18/pa4/tfu6
