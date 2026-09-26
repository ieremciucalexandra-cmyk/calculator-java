# TEST-RESULTS - Calculator Java

Data testarii: 26.09.2026

## 1. Testare black box

Am pornit programul in IntelliJ si am introdus pe rand mai multe
expresii, ca un utilizator obisnuit, ca sa vad unde greseste.

### Ce a functionat corect

| Am introdus | Ar fi trebuit sa dea | A dat |
|---|---|---|
| 4+5 | 9 | 9.0 |
| 10-3 | 7 | 7.0 |
| 6*7 | 42 | 42.0 |
| 20/4 | 5 | 5.0 |
| 10+5*4+3 | 33 | 33.0 |
| 2*3+4*5 | 26 | 26.0 |
| 100/5/2 | 10 | 10.0 |
| 10-5+2 | 7 | 7.0 |
| +5 | 5 | 5.0 |
| -5 | -5 | -5.0 |
| 2.5+1 | 3.5 | 3.5 |
| 10 + 5 | 15 | 15.0 |
| abc | ERROR | ERROR |
| 5++3 | ERROR | ERROR |
| 5.5.5 | ERROR | ERROR |

Calculatorul respecta prioritatea operatiilor si ordinea de la stanga
la dreapta.

### Probleme pe care le-am gasit

**1. Programul se inchide daca nu scriu nimic**

Daca apas Enter fara sa scriu nicio expresie, programul crapa si se
inchide de tot. In consola apare:
StringIndexOutOfBoundsException: Index 0 out of bounds for length 0

Eroarea vine de la Calculator.java, linia 32. Aceasta este cea mai
grava problema, pentru ca utilizatorul pierde tot si trebuie sa
porneasca programul din nou.

**2. Impartirea la zero**

Daca scriu 5/0, programul imi raspunde Infinity. Ar trebui sa imi
spuna ca nu se poate imparti la zero.

**3. La 0/0 primesc NaN**

Acelasi lucru, dar aici raspunsul e NaN, care nu inseamna nimic pentru
un om obisnuit.

**4. Expresiile neterminate sunt acceptate**

Daca scriu 5+ sau 5*, programul imi da 5.0 in loc sa imi spuna ERROR.
Practic ignora operatorul si imi da inapoi primul numar.

### Alte lucruri pe care le-am observat

Rezultatele apar mereu cu zecimale, chiar si cand sunt numere
intregi: 4+5 da 9.0 in loc de 9.

Numerele mari apar scrise ciudat: la 1000000*1000000 imi da 1.0E12,
ceea ce e greu de citit.

Nu pot scrie numere cu virgula, doar cu punct. Daca scriu 2,5+1 imi
da ERROR si nicaieri nu scrie ce format trebuie folosit.

Expresia 5+-3 da ERROR, desi pe alte calculatoare merge.

## 2. Test unitar pentru metoda Calculate

Am scris testul in fisierul CalculatorTest.java.

Mentiune: Testul este scris dupa modelul din lectia niveluri de testare, adaptat pentru metoda Calculate din Java.

Ca sa pot testa metoda Calculate a trebuit sa o schimb din private in
public. Metoda nici nu returneaza rezultatul, ci il scrie in variabila
finalResult, de unde trebuie citit separat. Asta face codul greu de
testat, ceea ce este si el un semn ca metoda nu e bine scrisa.

Cand am rulat testul, rezultatul a fost:

Teste trecute: 8
Teste esuate: 1

Testul care esueaza este cel cu impartirea la zero si confirma
problema numarul 2 de mai sus.

## 3. Concluzie

Calculatorul isi face treaba pentru calculele obisnuite. Cele patru
operatii merg, respecta prioritatea si ordinea corecta.

Problemele apar cand utilizatorul scrie ceva neasteptat. Cel mai rau
e ca programul se inchide complet daca apesi Enter pe gol. In rest,
impartirea la zero nu e tratata si expresiile neterminate sunt
acceptate in loc sa fie respinse.
