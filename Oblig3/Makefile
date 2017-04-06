# kjor make ARGS="tallverdi"
# for a endre args
ARGS=1000


All: compile sek

run:
	java -Xmx16G MultiRadix ${ARGS}

sek:
	java -Xmx16G Sekvensiell ${ARGS}

fasit:
	java -Xmx16G Sekv/MultiRadix ${ARGS}

compile:
	javac *.java
	javac Sekv/*.java

clean:
	rm -r *.class
