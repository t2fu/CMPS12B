#------------------------------------------------------------------------------
# Makefile
# Programmer: Tiancheng Fu
# CMPS 12M
# Date: July 18th, 2018
# Cruzid: tfu6
# This is a Makefile for FileReverse.c
# A Makefile with macros
#------------------------------------------------------------------------------

FLAGS = -std=c99 -Wall
SOURCES = FileReverse.c
OBJECTS = FileReverse.o
EXEBIN = FileReverse

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:

	ls /afs/cats.ucsc.edu/class/cmps012b-pt.u18/lab3/tfu6
