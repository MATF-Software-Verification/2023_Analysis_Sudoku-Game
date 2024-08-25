# 2023_Analysis_Sudoku-Game

## Kod koji se analizira:
Konzolna igrica Sudoku u jeziku Java. 
Nacin igre:
- ukucati tezinu Sudoku table koju zelite da resavate
- ukucati akciju (popuni polje, ponisti poslednji potez, prikazi resenu sudoku i odustani)
- shodno sa akcijom nastaviti dalje

  https://github.com/xx005fs/Sudoku-Game <br>
  master (default) grana <br>
  3d542e20447fd4c3992e5bdab86977e2f4b08ccc <br>
## Korišćeni alati:
1.jUnit - pisanje unit testova <br>
2.Mockito - pomoc sa *external dependencies* pri pisanju unit testova<br>
3.jaCoCo - pokrivenost koda <br>
4.CheckStyle - statička analiza koda <br>
5.Java Flight Recorder - profajler <br>
## Uputstvo za reprodukciju rezultata:
Potrebno je imati instalirane određene plugins (kliknuti na lupicu i ukucati plugins) u Intellij: <br>
CheckStyle-IDEA, Maven, Maven Extension, jUnit. <br>
Profiler je vec u Intellij. <br>
Desni klik na test -> More Run/Debug -> Run with Coverage/Java flight recorder (mozete promeniti nad kojim paketima ili klasama pokrecete testove). <br>
Sa strane su ikonice za rezultate alata CheckStyle i profajlera.  <br>
## Zaključak
Kod prolazi dobar deo testova, ali radi samo sa četiri različite Sudoku table. Nemoguće je generisati novu tablu, a i kada bi se rešavala nova tabla nije sigurno da bi rešavač (Sudoku solver) koji je autor napisao mogao da reši. Autor u svom README to i sam naglašava, tako da je brute force ipak pogrešan izbor za rešavanje Sudoku. Bolji način je prikazan u MyImplementation folder-u unutar test paketa.
Detaljnije o testovima, korišćenim alatima i samom kodu možete pročitati u ProjectAnalysisReport.pdf
## Autor rada:
Marija Bogavac 1068/23 marijabogavac001@gmail.com  <br>
