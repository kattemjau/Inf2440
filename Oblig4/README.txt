Oblig4 Inf2440

For kjøring av programmet kjør kommando: make

For å endre kjørings tall, kjør: make ARGS="tallet ditt"
EKS: make ARGS=20000

For å endre antall allokert ram, kjør: make RAM=-Xmx16000m
EKS: make RAM=-Xmx14G ARGS=20000

Programmet kompilerer, kjører den sekvensielle og den parralelle og printer ut Speedup av programmet.

Utskrift av N=1000 av sekvensielle og parralelle kjøringen

Sorterte 1000 tall sekvensielt paa:2.764374millisek.
485 290 396 896 782 178 172 433 466 228 341 836 588 789 212 83 275 551 826 840 712 311 326 62 432 196 214 98 154 615 643 922 828 394 181 783 67 721 938 932 69 682 237 545 732 569 110 785

parralellt
485 290 396 896 782 178 172 433 466 228 341 836 588 789 212 83 275 551 826 840 712 311 326 62 432 196 214 98 154 615 643 922 828 394 181 783 67 721 938 932 69 682 237 545 732 569 110 785

Sorterte 1000 tall parralelt paa:2.23184millisek.
Speedup for n=1000 Speedup: 1.2386076062800202



CPU:
i7-4710HQ
8 threads 4 cores
3312MHz under testing
L3 cache 6144K


RESULTATER:
Sorterte 100 tall sekvensielt paa:0.921428millisek.
Sorterte 100 tall parralelt paa:0.871017millisek.
Speedup for n=100 Speedup: 1.0578760230856574

Sorterte 10000 tall sekvensielt paa:17.521941millisek.
Sorterte 10000 tall parralelt paa:13.02515millisek.
Speedup for n=10000 Speedup: 1.345239095135181

Sorterte 100000 tall sekvensielt paa:75.890958millisek.
Sorterte 100000 tall parralelt paa:38.54057millisek.
Speedup for n=100000 Speedup: 1.9691187234646501

Sorterte 1000000 tall sekvensielt paa:373.038133millisek.
Sorterte 1000000 tall parralelt paa:242.614071millisek.
Speedup for n=1000000 Speedup: 1.5375783088854729

Sorterte 10000000 tall sekvensielt paa:2834.041333millisek.
Sorterte 10000000 tall parralelt paa:1948.450187millisek.
Speedup for n=10000000 Speedup: 1.4545105396630806
