INF2440 Oblig3
MultiRadix

For kjøring av programmet kjør kommando: make

For å endre kjørings tall, kjør: make ARGS="tallet ditt"
EKS: make ARGS=20000

For å endre antall allokert ram, kjør: make RAM=-Xmx16000m
EKS: make RAM=-Xmx14G ARGS=20000

Programmet kompilerer, kjører den sekvensielle og den parralelle og printer ut Speedup av programmet.
oppgave C) kjører på tilnærmet lik 0 tid, så hver traad kjører en instance av C for å regne ut lokale verdier


CPU:
i7-4710HQ
8 threads 4 cores
3312MHz under testing
L3 cache 6144K


RESULTATER:
Tall:           Sekvensiell         parralell           speedup
2000               0.55ms             1.46ms               0.4
20.000             2.8ms               2.41ms               1.16
200.000            10.13ms              5.9ms               1.74
2.000.000          58,83ms              38.4ms              1.5
20.000.000         365ms                107.19ms            3.4
200.000.000        3005.9ms             1375ms                2.2
