Uppgift 1

"Ett vanligt tidsfördriv är att försöka täcka en given yta med många likadana bitar. 
I denna uppgift ska du konstruera en algoritm som (nästan) täcker en kvadrat med sidan m=2n med bitar som ser ut som små L. 
Varje L-bit har ytan 3 och kan vridas och läggas på 4 sätt. Det går inte att täcka precis hela kvadraten, så innan vi börjar 
klipper vi bort en 1×1-ruta i övre högra hörnet på kvadraten. I vänstra figuren nedan visas hur en täckning av en 4×4-kvadrat 
med utklippt hörn kan göras. Din algoritm ska ta m som indata (som måste vara en jämn tvåpotens) och returnera 
en m×m-matris som beskriver hur täckningen kan göras. Ge varje L ett eget nummer och märk dom tre platserna i matrisen 
som den täcker med detta nummer, se exemplet nedan till höger."

Uppgift 2

"En oboist har fått ett genomskinligt rör med chokladbitar som tack för sina insatser på en fyrverkerikonsert. 
Oboisten äter en chokladbit varje dag, antingen från den vänstra eller högra änden av röret. 
(Vid varje läge är bara yttersta bitarna tillgängliga att plocka, för dom spärrar dom inre bitarna.)

Chokladbitarna är försedda med positiva heltal som berättar hur gott de smakar. 
Eftersom smak är subjektivt så finns det också en förväntanseffekt. 
En chokladbit blir lite godare för varje dag man väntar med att äta upp den. 
Om biten smakar m (som i mums) den första dagen så smakar den mk den k-te dagen.

Designa en effektiv algoritm som beräknar ett sätt att äta upp chokladen som optimerar oboistens lycka.

Din algoritm ska, givet chokladbitarnas initiala smakvärden, mata ut en följd med instruktioner (vänster eller höger) 
för hur chokladen ska ätas, till exempel höger höger vänster höger vänster vänster"
