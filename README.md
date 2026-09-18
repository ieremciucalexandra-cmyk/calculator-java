# Calculator Java - Raport de analiza

## 1. Metrici

### LOC (tot proiectul)

Calculator.java: 188 linii (134 linii de cod)
Start.java: 26 linii (19 linii de cod)
Total: 214 linii (153 linii de cod)

### Complexitate

evaluateExpression: ciclomatica 12, cognitiva 16
Calculate: ciclomatica 12, cognitiva 18

Ambele metode trec de 10, care e pragul recomandat. Asta inseamna ca
sunt prea lungi si greu de citit, si ar trebui impartite in metode
mai mici.

## 2. Observatii

Format: fisier - linia - observatie

Calculator.java - 6 - rezultatul e tinut intr-o variabila comuna
(finalResult) in loc sa fie returnat de metoda Calculate

Calculator.java - 18 - metoda ToString ar trebui sa inceapa cu litera
mica, iar numele nu spune ce face de fapt (lipsesc simbolurile
operatiilor)

Calculator.java - 24 - metoda Run ar trebui sa se numeasca run

Calculator.java - 32 - nu se verifica daca utilizatorul a introdus
ceva; daca apasa Enter fara text, programul da eroare

Calculator.java - 74 - metoda Calculate ar trebui sa se numeasca
calculate

Calculator.java - 86 - de aici incepe un bloc de cod care se repeta
de mai multe ori aproape identic

Calculator.java - 98 - nu se verifica impartirea la zero; rezultatul
afisat este Infinity

Start.java - 6 - variabila Expression ar trebui sa inceapa cu litera
mica

Start.java - 12 - se creeaza un Scanner nou la fiecare rulare a
buclei, desi unul singur ar fi de ajuns

Start.java - 16 - Scanner-ul se inchide doar cand utilizatorul scrie
"exit"

## 3. Concluzie

Codul functioneaza pentru calcule normale, dar nu trateaza cazurile
neobisnuite: expresie goala, impartire la zero, litere in loc de
cifre. Cele doua metode sunt prea complexe, iar in Calculate acelasi
cod se repeta de mai multe ori.
