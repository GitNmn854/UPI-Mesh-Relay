package com.naman.upi_mesh_relay.dao;

import com.naman.upi_mesh_relay.model.Account;

import java.util.List;

public interface AccountDAO {

    void save(Account account);

    Account findById(Integer id);

    List<Account> findAll();

    Account findByVpa(String vpa);
}