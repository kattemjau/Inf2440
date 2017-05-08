INF2440 Oblig3
MultiRadix

For kjøring av programmet kjør kommando: make

For å endre kjørings tall, kjør: make ARGS="tallet ditt"
EKS: make ARGS=20000

For å endre antall allokert ram, kjør: make RAM=-Xmx16000m
EKS: make RAM=-Xmx14G ARGS=20000

Programmet kompilerer, kjører den sekvensielle og den parralelle og printer ut Speedup av programmet.
oppgave C) kjører på tilnærmet lik 0 tid, så hver traad kjører en instance av C for å regne ut lokale verdier

Den parralelle programmet heter Sekvensiell.java og benytter seg av OppgA og OppgB .java for løsningen.


CPU:
i7-4710HQ
8 threads 4 cores
3312MHz under testing
L3 cache 6144K


RESULTATER:
Tall:           Sekvensiell         parralell           speedup
2000               0.55ms            4ms                0.14
20.000             2.8ms             5ms                0.6
200.000            10.13ms           16ms               0.65
2.000.000          58,83ms           68ms               0.8
20.000.000         376ms             176ms              2
200.000.000        3122ms            887ms             	3.4
