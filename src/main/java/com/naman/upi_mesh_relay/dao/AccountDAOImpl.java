package com.naman.upi_mesh_relay.dao;

import com.naman.upi_mesh_relay.model.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Account findById(Integer id) {
        // returns null if no account has this id
        return entityManager.find(Account.class, id);
    }

    @Override
    public List<Account> findAll() {
        TypedQuery<Account> query =
                entityManager.createQuery("FROM Account ORDER BY id", Account.class);
        return query.getResultList();
    }

    @Override
    public Account findByVpa(String vpa) {
        TypedQuery<Account> query =
                entityManager.createQuery("FROM Account WHERE vpa = :theVpa", Account.class);
        query.setParameter("theVpa", vpa);

        List<Account> results = query.getResultList();
        // vpa is UNIQUE, so there is either 0 or 1 match
        return results.isEmpty() ? null : results.get(0);
    }
}