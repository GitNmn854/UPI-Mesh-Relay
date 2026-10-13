package com.naman.upi_mesh_relay.dao;

import com.naman.upi_mesh_relay.model.Account;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private final EntityManager entityManager;

    public AccountDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Account account) {
        entityManager.persist(account);
    }
}