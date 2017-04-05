# kjor make ARGS="tallverdi"
# for a endre args
ARGS=1000


All: compile run

run:
	java -Xmx14G MultiRadix ${ARGS}

sek:
	java -Xmx14G Sekvensiell ${ARGS}

compile:
	javac *.java

clean:
	rm -r *.class
