cs:

.PRECIOUS: %.hs.app
.PRECIOUS: %.class

%.hs.app: %.hs
	ghc -Wall $< -o $@

%.class: %.java
	javac -Xlint $<

%.hsx: %.hs.app
	$(patsubst %.hsx,%.hs.app,$@)

%.javax: %.class
	java -ea $(patsubst %.javax,%,$@)

%.pyx:
	$(patsubst %.pyx,%.py,$@)

clean:
	rm -f *.hs.app
	rm -f *.hi *.o
	rm -f *.class
	rm -f *.pyc
