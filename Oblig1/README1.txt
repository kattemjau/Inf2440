RESULTATER TESTKJØRING

Cpu: i7-5820k
2.87 Ghz
6c 12t


Fikset k og n som inputs
fikset at sortering blir riktig resultat
fikset readme fil
fikset kjøring av 100 000 000


K=20
N=1000

tid pa Array.sort: 1.277951
tid pa Array.sort: 0.607055
tid pa Array.sort: 0.603382
tid pa Array.sort: 0.627959
tid pa Array.sort: 0.420334
tid pa Array.sort: 0.416944
tid pa Array.sort: 0.422594
MEDIAN: 0.627959
tid pa sekvensielSortering: 0.399715
tid pa sekvensielSortering: 0.394913
tid pa sekvensielSortering: 0.387286
tid pa sekvensielSortering: 0.384744
tid pa sekvensielSortering: 0.091525
tid pa sekvensielSortering: 0.070056
tid pa sekvensielSortering: 0.061582
MEDIAN: 0.384744


K: 20 N: 10000
tid pa Array.sort: 6.822798
tid pa Array.sort: 2.286413
tid pa Array.sort: 2.260424
tid pa Array.sort: 2.312966
tid pa Array.sort: 2.579912
tid pa Array.sort: 3.082166
tid pa Array.sort: 4.320569
MEDIAN: 2.312966
tid pa sekvensielSortering: 1.980484
tid pa sekvensielSortering: 0.072033
tid pa sekvensielSortering: 0.039548
tid pa sekvensielSortering: 0.037853
tid pa sekvensielSortering: 0.038418
tid pa sekvensielSortering: 0.038135
tid pa sekvensielSortering: 0.036158
MEDIAN: 0.037853

K: 20 N: 100000000
ant traader: 12
tid pa Array.sort: 55274.502598
tid pa Array.sort: 56956.301661
tid pa Array.sort: 54262.180996
tid pa Array.sort: 56728.985495
tid pa Array.sort: 61400.323668
tid pa Array.sort: 60090.636188
tid pa Array.sort: 60832.97491
MEDIAN: 56728.985495
tid pa sekvensielSortering: 1372.323726
tid pa sekvensielSortering: 164.905907
tid pa sekvensielSortering: 180.413063
tid pa sekvensielSortering: 177.078641
tid pa sekvensielSortering: 177.0809
tid pa sekvensielSortering: 178.473256
tid pa sekvensielSortering: 177.640498
MEDIAN: 177.078641

K: 100 N: 1000
tid pa Array.sort: 1.314956
tid pa Array.sort: 0.743211
tid pa Array.sort: 0.640952
tid pa Array.sort: 0.674285
tid pa Array.sort: 0.452537
tid pa Array.sort: 0.44039
tid pa Array.sort: 0.346606
MEDIAN: 0.640952
tid pa sekvensielSortering: 2.212967
tid pa sekvensielSortering: 0.036723
tid pa sekvensielSortering: 0.009887
tid pa sekvensielSortering: 0.017232
tid pa sekvensielSortering: 0.015819
tid pa sekvensielSortering: 0.019209
tid pa sekvensielSortering: 0.013842
MEDIAN: 0.017232

K: 100 N: 10000
tid pa Array.sort: 8.238601
tid pa Array.sort: 2.310141
tid pa Array.sort: 3.898823
tid pa Array.sort: 4.635537
tid pa Array.sort: 4.721129
tid pa Array.sort: 8.090579
tid pa Array.sort: 8.758086
MEDIAN: 4.635537
tid pa sekvensielSortering: 8.246228
tid pa sekvensielSortering: 0.053106
tid pa sekvensielSortering: 0.052541
tid pa sekvensielSortering: 0.118078
tid pa sekvensielSortering: 0.049434
tid pa sekvensielSortering: 0.044067
tid pa sekvensielSortering: 0.112711
MEDIAN: 0.052541

K: 100 N: 100000000
tid pa Array.sort: 60125.404409
tid pa Array.sort: 64186.180507
tid pa Array.sort: 57941.576416
tid pa Array.sort: 110416.939003
tid pa Array.sort: 58352.810969
tid pa Array.sort: 55413.195828
tid pa Array.sort: 80986.621913
MEDIAN: 58352.810969
tid pa sekvensielSortering: 4818.378608
tid pa sekvensielSortering: 4813.951228
tid pa sekvensielSortering: 4971.614834
tid pa sekvensielSortering: 4957.119992
tid pa sekvensielSortering: 4958.877046
tid pa sekvensielSortering: 4951.355332
tid pa sekvensielSortering: 4944.974856
MEDIAN: 177.660554

For parraleliseringen valgte jeg å dele opp arrayet i mindre deler over de forskjellige threadene,
etterfølgt av en sammenslåing av "main"

K: 20 N: 1000
tid pa parralellisering: 1.311011
tid pa parralellisering: 1.279654
tid pa parralellisering: 1.114684
tid pa parralellisering: 1.05056
tid pa parralellisering: 1.570331
tid pa parralellisering: 1.146887
tid pa parralellisering: 3.242921

MEDIAN: 1.279654

SPEEDUP: 0.384744/1.279654 = 0.3


K: 20 N :10000
tid pa parralellisering: 4.501955
tid pa parralellisering: 5.80449
tid pa parralellisering: 8.223405
tid pa parralellisering: 3.292638
tid pa parralellisering: 4.905342
tid pa parralellisering: 4.881896
tid pa parralellisering: 1.186152

MEDIAN: 4.881896

SPEEDUP: 0.511014/4.881896 = 0.1

K: 20 N: 100000000
tid pa parralellisering: 453.014081
tid pa parralellisering: 430.232558
tid pa parralellisering: 405.314606
tid pa parralellisering: 413.246769
tid pa parralellisering: 409.931814
tid pa parralellisering: 421.014244
tid pa parralellisering: 423.175815

MEDIAN: 421.014244


SPEEDUP: 909.608934/421.014244 = 2.1


K: 100 N: 1000
for lite arrays, klarer ikke a utnytte threads
ant traader: 10
tid pa parralellisering: 2.740382
for lite arrays, klarer ikke a utnytte threads
ant traader: 10
tid pa parralellisering: 1.325134
for lite arrays, klarer ikke a utnytte threads
ant traader: 10
tid pa parralellisering: 1.649427
for lite arrays, klarer ikke a utnytte threads
ant traader: 10
tid pa parralellisering: 1.257056
for lite arrays, klarer ikke a utnytte threads
ant traader: 10
tid pa parralellisering: 1.667788
for lite arrays, klarer ikke a utnytte threads
ant traader: 10
tid pa parralellisering: 2.442078
for lite arrays, klarer ikke a utnytte threads
ant traader: 10
tid pa parralellisering: 1.988408

MEDIAN: 1.649427


SPEEDUP: 0.291524/1.649427 = 0.17

K: 100 N: 10000
tid pa parralellisering: 16.201895
tid pa parralellisering: 6.448273
tid pa parralellisering: 6.322849
tid pa parralellisering: 1.423156
tid pa parralellisering: 4.40139
tid pa parralellisering: 1.782759
tid pa parralellisering: 4.53783


MEDIAN: 4.53783


SPEEDUP: 1.555076/4.53783 = 0.34

K: 100 N: 100000000
tid pa parralellisering: 1972.202118
tid pa parralellisering: 1938.31246
tid pa parralellisering: 1814.215917
tid pa parralellisering: 1811.07017
tid pa parralellisering: 1833.431638
tid pa parralellisering: 1851.010362
tid pa parralellisering: 1801.464851


MEDIAN: 1833.431638


SPEEDUP: 4951.355332/1833.431638 = 2.7

