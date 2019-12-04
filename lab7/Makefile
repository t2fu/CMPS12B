#------------------------------------------------------------------------------
# Makefile for CMPS 12M lab7
# Programmer: Tiancheng Fu
# CMPS 12M
# Date: August 17th, 2018
# Cruzis: tfu6
# This is a Makefile for java files in lab7
# This Makefile uses wildcards and pattern substitution
#------------------------------------------------------------------------------

JAVAC      = javac 
MAINCLASS  = DictionaryClient
JAVASRC    = $(wildcard *.java)
SOURCES    = $(JAVASRC) Makefile README
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
	rm -f *.class $(JARFILE)

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)

check:

	ls /afs/cats.ucsc.edu/class/cmps012b-pt.u18/lab7/tfu6