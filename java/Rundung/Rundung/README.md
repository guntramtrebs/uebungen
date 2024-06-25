# Rundungsfehler mit double

## Erklärung
- diese Fehler sollten in fast allen Programmiersprachen auftreten
- bei der Umwandlung von endlichen gebrochenen Dezimalzahlen in binäre Zahlen kann eine Periode auftreten
- dadurch entstehen Rundungsfehler
- weitere Rundungsfehler können beim Rechnen mit double auftreten

## Beispiele
- 0.7 + 0.1 != 0.8 (Konvertierungsfehler dezimal -> binär)
- 9 / 100.0 * 10 - 90 / 100.0: -1.1102230246251565E-16 (Java optimiert double nicht beim Kompilieren)

- printRueckgeld1():  
`Rückgeld für 0.03€: 0×50c 0×20c 0×10c 0×5c 1×2c 0×1c , Rest: 0.009999999999999998  
Rückgeld für 0.02€: 0×50c 0×20c 0×10c 0×5c 1×2c 0×1c , Rest: 0.0  
`

- printRueckgeld2():    
`Rückgeld für 0.03€: 0×50c 0×20c 0×10c 0×5c 1×2c 0×1c , Rest: 0.009999999999999998  
Rückgeld für 0.02€: 0×50c 0×20c 0×10c 0×5c 1×2c 0×1c , Rest: 0.0  
`
- 3 cent minus 2 cent (0,03 - 0,02): 0.009999999999999998 (kein voller cent Rückgeld mehr)

- Liste mit Rückgeld für 100, ..., 0 cent: Vergleich der Rechenfehler bei beiden Algorithmen

## Fazit
- kein float oder double für Geldbeträge verwenden
- float oder double nicht miteinander vergleichen (es sei denn mit Toleranz)
- double hat aber seine Berechtigung (z.B. schnelle Berechnung von Grafiken)

