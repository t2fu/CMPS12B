#------------------------------------------------------------------------------
# Makefile
# Programmer: Tiancheng Fu
# CMPS 12M
# Date: July 26th, 2018
# Cruzid: tfu6
# This is a Makefile for charType.c with Macros
#------------------------------------------------------------------------------

PROGRAM_NAME = charType
FLAGS        = -std=c99 -Wall
SOURCES      = $(PROGRAM_NAME).c
OBJECTS      = $(PROGRAM_NAME).o
EXEBIN       = $(PROGRAM_NAME)

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm $(EXEBIN) $(OBJECTS)

check :
	
	ls /afs/cats.ucsc.edu/class/cmps012b-pt.u18/lab4/tfu6
