specs:
cpu: i7-4710hq
Thread(s) per core:    2
Core(s) per socket:    4
Socket(s):             1
CPU MHz:               3311.718
CPU max MHz:           3500.0000
CPU min MHz:           800.0000

n = 1000

tid pa Array.sort: 4.586912

Testing av instikk sortering A2
Times per thread in order to finishing K20
Trad[0]: 0.123304
Trad[1]: 0.039957
Trad[2]: 0.047284
Trad[3]: 0.131398
Trad[4]: 0.053406
Trad[5]: 0.051091
Trad[6]: 0.045817
Gjennomsnitts tiden K20: 0.07032242857142858

Times per thread in order to finishing for K100
Trad[0]: 0.045866
Trad[1]: 0.061619
Trad[2]: 0.03846
Trad[3]: 0.027262
Trad[4]: 0.035891
Trad[5]: 0.034237
Trad[6]: 0.03922
Gjennomsnitts tiden K100: 0.040365

n = 10 000

tid pa Array.sort: 17.499105

Testing av instikk sortering A2
Times per thread in order to finishing K20
Trad[0]: 0.132805
Trad[1]: 0.080904
Trad[2]: 0.083161
Trad[3]: 0.19034
Trad[4]: 0.051102
Trad[5]: 0.515302
Trad[6]: 5.631423
Gjennomsnitts tiden K20: 0.9550052857142857


Times per thread in order to finishing for K100
Trad[0]: 0.085577
Trad[1]: 0.051762
Trad[2]: 0.046469
Trad[3]: 0.029356
Trad[4]: 0.036752
Trad[5]: 0.032546
Trad[6]: 0.030699
Gjennomsnitts tiden K100: 0.04473728571428571



n = 100 000 000
Ram usage: 27% av 16GB ram (~5000 MB)

tid pa Array.sort: 82563.079429

Testing av instikk sortering A2
Times per thread in order to finishing K20
Trad[0]: 6.037852
Trad[1]: 6.151436
Trad[2]: 6.086501
Trad[3]: 37846.311762
Trad[4]: 6.091284
Trad[5]: 6.206102
Trad[6]: 6.130883
Gjennomsnitts tiden K20: 5411.8594028571415

K=100 avbrutt etter 45 minutter. 
