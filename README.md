# UPI Mesh Relay

A Spring Boot backend that simulates how UPI payments could work **without internet access on the sender's device**. A payment request is passed device to device through a mesh of nearby nodes (gossip-style relay) until it reaches a "bridge node" that has connectivity and can submit it to the server, which validates and settles it.

> A simulation project: no real UPI network or bank is involved.

## Tech Stack
- Java, Spring Boot
- Hibernate / JPA (EntityManager)
- MySQL
- Maven

## How It Is Meant to Work
```
Sender device -> mesh nodes (gossip relay) -> bridge node -> Spring Boot server -> database
```
1. The sender creates a payment request while offline.
2. Nearby nodes pass it on to each other (simulated in code).
3. A bridge node with internet submits it to the server.
4. The server validates it, rejects duplicates, and updates the account balances in a single transaction.

## Project Structure
```
com.naman.upi_mesh_relay
├── config
├── controller
├── crypto
├── dao
├── model
└── service
```

## Status

Updated as the project progresses.

- [x] Project setup (Spring Boot, MySQL connection, layered package structure)
- [x] `Account` entity (VPA, holder name, balance) mapped with JPA
- [x] Account persistence with DAO + EntityManager (save)
- [ ] Account lookup operations (find by id, find all, find by VPA)
- [ ] Update and delete for accounts
- [ ] REST API for accounts
- [ ] Service layer with transactional logic
- [ ] Payment submission endpoint
- [ ] Money transfer between accounts in one transaction (all or nothing)
- [ ] Duplicate payment protection (idempotency)
- [ ] Mesh gossip and bridge node simulation
- [ ] Global exception handling with JSON error responses

## Database

MySQL database `upi_mesh_relay`, table `account`:

| Column | Type | Notes |
|--------|------|-------|
| id | INT | Primary key |
| vpa | VARCHAR | Unique payment address |
| holder_name | VARCHAR | Account holder |
| balance |
