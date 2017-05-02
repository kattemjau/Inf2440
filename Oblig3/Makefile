# kjor make ARGS="tallverdi"
# for a endre args
ARGS=200000
RAM=-Xmx16G

All: compile sek

run:
	java $(RAM) MultiRadix ${ARGS}

sek:
	java $(RAM) Sekvensiell ${ARGS}

fasit:
	java $(RAM) Sekv/MultiRadix ${ARGS}

compile:
	javac *.java
	javac Sekv/*.java

clean:
	rm -r *.class
