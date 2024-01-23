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
