RESULTATER TESTKJØRING

Cpu: i7-5820k
2.87 Ghz
6c 12t




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
tid pa sekvensielSortering: 0.464119
tid pa sekvensielSortering: 0.040677
tid pa sekvensielSortering: 0.033898
tid pa sekvensielSortering: 0.037288
tid pa sekvensielSortering: 0.032203
tid pa sekvensielSortering: 0.033615
tid pa sekvensielSortering: 0.033616
MEDIAN: 0.037288


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
tid pa sekvensielSortering: 5696.402275
tid pa sekvensielSortering: 169.033822
tid pa sekvensielSortering: 178.906584
tid pa sekvensielSortering: 178.465629
tid pa sekvensielSortering: 177.660554
tid pa sekvensielSortering: 177.290219
tid pa sekvensielSortering: 177.066775
MEDIAN: 177.660554

For parraleliseringen valgte jeg å dele opp arrayet i mindre deler over de forskjellige threadene,
etterfølgt av en sammenslåing av "main"

K: 20 N: 1000
ant traader: 12
tid pa sekvensielSortering: 0.369488
tid pa parralellisering: 1.877944
ant traader: 12
tid pa sekvensielSortering: 0.030226
tid pa parralellisering: 0.419204
ant traader: 12
tid pa sekvensielSortering: 0.030226
tid pa parralellisering: 0.549146
ant traader: 12
tid pa sekvensielSortering: 0.030226
tid pa parralellisering: 0.412142
ant traader: 12
tid pa sekvensielSortering: 0.030225
tid pa parralellisering: 0.428809
ant traader: 12
tid pa sekvensielSortering: 0.029943
tid pa parralellisering: 0.616659
ant traader: 12
tid pa sekvensielSortering: 0.029661
tid pa parralellisering: 0.515813

MEDIAN: 0.515813

SPEEDUP: 0.037288 - 0.515813 = -0.478525


K: 20 N: 10000
ant traader: 12
tid pa sekvensielSortering: 1.936982
tid pa parralellisering: 3.411823
ant traader: 12
tid pa sekvensielSortering: 0.041243
tid pa parralellisering: 0.411577
ant traader: 12
tid pa sekvensielSortering: 0.040395
tid pa parralellisering: 2.751944
ant traader: 12
tid pa sekvensielSortering: 0.04887
tid pa parralellisering: 0.491802
ant traader: 12
tid pa sekvensielSortering: 0.082485
tid pa parralellisering: 0.435305
ant traader: 12
tid pa sekvensielSortering: 0.021469
tid pa parralellisering: 0.754511
ant traader: 12
tid pa sekvensielSortering: 0.021186
tid pa parralellisering: 0.408187

MEDIAN: 0.491802

SPEEDUP: 0.491802 - 0.037853 = 0.453949

K: 20 N: 100000000
ant traader: 12
tid pa sekvensielSortering: 1190.336954
tid pa parralellisering: 1192.212072
ant traader: 12
tid pa sekvensielSortering: 166.499955
tid pa parralellisering: 166.779048
ant traader: 12
tid pa sekvensielSortering: 176.75096
tid pa parralellisering: 177.038809
ant traader: 12
tid pa sekvensielSortering: 176.75661
tid pa parralellisering: 177.007454
ant traader: 12
tid pa sekvensielSortering: 176.567347
tid pa parralellisering: 176.901806
ant traader: 12
tid pa sekvensielSortering: 176.577234
tid pa parralellisering: 176.83401
ant traader: 12
tid pa sekvensielSortering: 176.838812
tid pa parralellisering: 177.118753

MEDIAN: 177.007454


SPEEDUP: 177.078641-177.660554 = 0


K: 100 N: 1000
ant traader: 12
tid pa sekvensielSortering: 1.575405
tid pa parralellisering: 3.001941
ant traader: 12
tid pa sekvensielSortering: 0.007909
tid pa parralellisering: 0.4096
ant traader: 12
tid pa sekvensielSortering: 0.007628
tid pa parralellisering: 0.657902
ant traader: 12
tid pa sekvensielSortering: 0.00791
tid pa parralellisering: 2.739797
ant traader: 12
tid pa sekvensielSortering: 0.009322
tid pa parralellisering: 1.071174
ant traader: 12
tid pa sekvensielSortering: 0.01017
tid pa parralellisering: 1.345747
ant traader: 12
tid pa sekvensielSortering: 0.008192
tid pa parralellisering: 0.419204

MEDIAN: 1.071174


SPEEDUP: 0.017232 - 1.071174 = 1.053942

K: 100 N: 10000
ant traader: 12
tid pa sekvensielSortering: 4.234129
tid pa parralellisering: 5.665185
ant traader: 12
tid pa sekvensielSortering: 0.058756
tid pa parralellisering: 0.544626
ant traader: 12
tid pa sekvensielSortering: 0.095197
tid pa parralellisering: 0.741234
ant traader: 12
tid pa sekvensielSortering: 0.081637
tid pa parralellisering: 0.48474
ant traader: 12
tid pa sekvensielSortering: 0.08644
tid pa parralellisering: 6.94935
ant traader: 12
tid pa sekvensielSortering: 0.022034
tid pa parralellisering: 0.426266
ant traader: 12
tid pa sekvensielSortering: 0.022598
tid pa parralellisering: 0.65536

MEDIAN: 0.65536


SPEEDUP: 0.052541 - 0.65536 = 0.602819

K: 100 N: 100000000
ant traader: 12
tid pa sekvensielSortering: 5104.765112
tid pa parralellisering: 5106.646727
ant traader: 12
tid pa sekvensielSortering: 164.310999
tid pa parralellisering: 164.572859
ant traader: 12
tid pa sekvensielSortering: 176.754915
tid pa parralellisering: 177.029488
ant traader: 12
tid pa sekvensielSortering: 177.266491
tid pa parralellisering: 177.514793
ant traader: 12
tid pa sekvensielSortering: 176.772429
tid pa parralellisering: 177.051804
ant traader: 12
tid pa sekvensielSortering: 176.971862
tid pa parralellisering: 177.221576
ant traader: 12
tid pa sekvensielSortering: 177.232028
tid pa parralellisering: 177.516488

MEDIAN: 177.029488


SPEEDUP: 177.660554 - 177.029488 = 0