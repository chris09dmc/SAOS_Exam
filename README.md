# Implementazione di Spring Cloud API Gateway e del Server Eureka con due microservizi

In questo progetto sono stati realizzati:
1) Service Discovery sulla porta 8761
2) API-Gateway sulla porta 8080
3) Service1 sulla porta 9001
4) Service2 sulla porta 9002

<img width="541" alt="architettura" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/3c824f99-5b44-43f7-816a-40565c2548fe">

## Service Discovery

Su http://localhost:8761/ possiamo trovare Eureka, ove possiamo notare le istanze attualmente registrate con Eureka

<img width="1680" alt="Screenshot 2024-01-23 alle 16 22 58" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/2e6ffe11-3c5e-4ec6-bb85-af4124bf8ac1">

## API-Gateway

**

## Service1

Il Service1 possiamo trovarlo sia su http://localhost:9001/registration, che mediante API-Gateway su http://localhost:8080/service1/registration

<img width="1014" alt="Screenshot 2024-01-23 alle 16 27 53" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/eebb7965-d540-44a6-adb1-97b7765ac525">

Questo microservizio ci permette di effettuare la registrazione di un utente e di salvare nome completo, e-mail e password (crittografata mediante utilizzo di Spring Security).
L'utente sarà salvato all'interno di un Database MySQL, ove sarà presente un'ulteriore colonna chiamata "Role".

<img width="591" alt="Screenshot 2024-01-23 alle 16 39 29" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/9d9528ad-692b-4192-ac5c-3af0d0bd9a33">

La colonna "Role" sarà riempita poi dal ruolo effettivo che l'utente avrà per effettuare il login nel Service2. Il ruolo che può avere è USER oppure ADMIN.

## Service2

Il Service2 possiamo trovarlo sua su http://localhost:9002/login, che mediante API-Gateway su http://localhost:8080/service2/login

<img width="820" alt="Screenshot 2024-01-23 alle 16 53 27" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/428bb266-edba-4e5e-821a-66fffb4b60d6">

Questo microservizio, a diffrenza del precedente, ci permette di effeuttuare il login (ed anche il logout) dell'utente registrato nel database. Come specificato precedentemente, il login sarà effettuato una volta che l'utente ha avuto assegnato il suo "Role".

<img width="598" alt="Screenshot 2024-01-23 alle 16 56 27" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/17ebafb3-3632-43ff-8ea8-37e56c7f1bde">
<img width="1291" alt="Screenshot 2024-01-23 alle 16 55 49" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/80d5df76-94db-4c2f-8a5f-90511244a9dd">
<img width="1291" alt="Screenshot 2024-01-23 alle 16 56 03" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/67c8b00c-e881-4ddd-b34f-8c3cbe13d560">
