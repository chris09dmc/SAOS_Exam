# Implementazione di Spring Cloud API Gateway e del Server Eureka con due microservizi

In questo progetto sono stati realizzati:
1) Service Discovery sulla porta 8761
2) API-Gateway sulla porta 8080
3) Service1 sulla porta 9001
4) Service2 sulla porta 9002

L'architettura di base è realizzata come mostrata nella figura successiva

<img width="541" alt="architettura" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/3c824f99-5b44-43f7-816a-40565c2548fe">

## Service Discovery

Il Service Discovery è il processo di individuazione delle singole istanze che compongono un servizio. Il server Eureka è un'applicazione che contiene le informazioni su tutte le applicazioni client-service. Ogni microservizio si registra nel server Eureka e quest'ultimo conosce tutte le applicazioni client in esecuzione su ciascuna porta e indirizzo IP. Il server Eureka è noto anche come server di rilevamento.
Il Service Discovery ha come dipendenza implementata "Eureka Server".

Su http://localhost:8761/ possiamo trovare Eureka, ove possiamo notare le istanze attualmente registrate con Eureka. Per potersi registrare, le istanze sono munite della relativa dipendenza "Eureka Discovery Client".

<img width="1680" alt="Screenshot 2024-01-23 alle 16 22 58" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/2e6ffe11-3c5e-4ec6-bb85-af4124bf8ac1">

## API-Gateway
Un API-Gateway funge da mediatore tra le applicazioni client e i servizi backend nell'architettura a microservizi. Si tratta di un livello software che funziona come un unico endpoint per varie API, eseguendo compiti quali la composizione delle richieste, l'instradamento e la traduzione dei protocolli. L'API-Gateway controlla le richieste e le risposte gestendo il traffico delle API e applicando i criteri di sicurezza. 

Per poter includere Spring Cloud Gateway all'interno di un progetto, bisogna utilizzare la dipendenza "spring-cloud-starter-gateway".

Esso è composto da alcuni elementi:
- Route: essa è il blocco base del Gateway e consiste in ID, URI di destinazione e collezione di predicati e collezione di filtri;
- Predicate: possiamo abbinare richieste HTTP, URL, cookie o parametri;
- Filter: possiamo modificare la richiesta o la risposta in base alle esgigenze.

Un diagramma semplificato fornito dal sito ufficiale di Spring Cloud Gateway

<img width="424" alt="Screenshot 2024-01-23 alle 17 22 39" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/b2266b42-5eff-49dc-8f79-22f7f8ce9679">

Quando il client effettua una richiesta a Spring Cloud Gateway, il Gateway Handler Mapping verifica se la richiesta corrisponde ad una rotta, e questa viene eseguita mediante l'utilizzo dei predicati. Se corrisponde ai predicati, allora la richiesta viene inviata ai filtri.

Un esempio di instradamento dell'API-Gateway è il seguente:

<img width="497" alt="Screenshot 2024-01-23 alle 17 40 27" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/94279586-4ab0-40d2-abd6-7bb243075e10">

## Service1

Possiamo raggiungere il Service1 digitando http://localhost:9001/registration, oppure mediante l'utilizzo dell'API-Gateway digitando http://localhost:8080/service1/registration

<img width="1014" alt="Screenshot 2024-01-23 alle 16 27 53" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/eebb7965-d540-44a6-adb1-97b7765ac525">

Questo microservizio ci permette di effettuare la registrazione di un utente e di salvare nome completo, e-mail e password (crittografata mediante utilizzo di Spring Security). L'utente sarà registrato presso un Database MySQL. Viene utilizzato MySQL Workbench per la gestione del Database, esso si connette con il Service1 (ma anche con il Service2) mediante properties specificate in application.properties dei due microservizi.
Inoltre, all'interno del Database viene visualizzata un'ulteriore colonna chiamata "role", essa viene utilizzata per il microservizio di Login.

<img width="591" alt="Screenshot 2024-01-23 alle 16 39 29" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/9d9528ad-692b-4192-ac5c-3af0d0bd9a33">

## Service2

Possiamo raggiungere il Service2 digitando http://localhost:9002/login, oppure mediante l'utilizzo dell'API-Gateway digitando http://localhost:8080/service2/login

<img width="820" alt="Screenshot 2024-01-23 alle 16 53 27" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/428bb266-edba-4e5e-821a-66fffb4b60d6">

Questo microservizio, a diffrenza del precedente, ci permette di effeuttuare il login (ed anche il logout) dell'utente registrato nel Database. Prima di poter procedere al Login di un utente, è necessario specificare nalla colonna "role" se l'utente ha accesso come admin o come user. Per far questo, la colonna "role" deve essere modificata aggiungendo USER se l'utente avrà permessi da utente normale, ADMIN se avrà permessi da amministratore.

<img width="598" alt="Screenshot 2024-01-23 alle 16 56 27" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/17ebafb3-3632-43ff-8ea8-37e56c7f1bde">
<img width="1291" alt="Screenshot 2024-01-23 alle 16 55 49" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/80d5df76-94db-4c2f-8a5f-90511244a9dd">
<img width="1291" alt="Screenshot 2024-01-23 alle 16 56 03" src="https://github.com/chris09dmc/SAOS_Exam/assets/98541925/67c8b00c-e881-4ddd-b34f-8c3cbe13d560">

## Riferimenti
- https://www.tutorialspoint.com/spring_boot/spring_boot_eureka_server.htm
- https://cloud.spring.io/spring-cloud-gateway/reference/html/#gateway-how-it-works
- https://konghq.com/learning-center/api-gateway/what-is-an-api-gateway
