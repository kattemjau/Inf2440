# kjor make ARGS="tallverdi"
# for a endre args


ARGS=1000


All: compile run

run:
	java -Xmx14G MultiRadix ${ARGS}

compile:
	javac *.java

clean:
	rm -r *.class
