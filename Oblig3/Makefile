# kjor make ARGS="tallverdi"
# for a endre args
ARGS=1000


All: compile sek

run:
	java -Xmx14G MultiRadix ${ARGS}

sek:
	java -Xmx14G Sekvensiell ${ARGS}

fasit:
	java -Xmx14G Sekv/MultiRadix ${ARGS}

compile:
	javac *.java
	javac Sekv/*.java

clean:
	rm -r *.class
