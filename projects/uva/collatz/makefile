cs:
	make clean
	@echo `pwd`
	@rsync -r -t -u -v --delete \
	--include "*.c++"           \
	--include "*.h"             \
	--include "*.html"          \
	--include "*.in"            \
	--include "*.java"          \
	--include "*.out"           \
	--include "*.py"            \
	--include "*.pdf"           \
	--exclude "*"               \
	. downing@$(CS):cs/projects/collatz/

OS       := $(shell uname)
VALGRIND := $(shell which valgrind)

ifeq ($(OS), Darwin)
	BOOST :=
else
	BOOST := -I/public/linux/include/boost-1_38
endif

.PRECIOUS: %.c++.app
.PRECIOUS: %.class

RunCollatz.c++.app: RunCollatz.c++ Collatz.h
	g++ -ansi -pedantic $(BOOST) -Wall $< -o $@

TestCollatz.c++.app: TestCollatz.c++ Collatz.h
	g++ -ansi -pedantic $(BOOST) -lcppunit -ldl -Wall $<  -o $@

RunCollatz.class: RunCollatz.java Collatz.java
	javac -Xlint $<

TestCollatz.class: TestCollatz.java Collatz.java
	javac -Xlint $<

RunCollatz.c++x: RunCollatz.c++.app
	$(VALGRIND) $< < RunCollatz.in

TestCollatz.c++x: TestCollatz.c++.app
	$(VALGRIND) $<

RunCollatz.javax: RunCollatz.class
	java -ea RunCollatz < RunCollatz.in

TestCollatz.javax: TestCollatz.class
	java -ea TestCollatz

RunCollatz.pyx:
	RunCollatz.py < RunCollatz.in

TestCollatz.pyx:
	TestCollatz.py

clean:
	rm -f *.app
	rm -f *.class
	rm -f *.pyc

list:
	ls -al *.app
	ls -al *.class

run:
	make RunCollatz.c++x
	make RunCollatz.javax
	make RunCollatz.pyx

test:
	make TestCollatz.c++x
	make TestCollatz.javax
	make TestCollatz.pyx
