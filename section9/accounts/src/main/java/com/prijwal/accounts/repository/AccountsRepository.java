package com.prijwal.accounts.repository;

import com.prijwal.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(Long customerId);

//    Whenever we write a custom function ( coz we are deleting the data with a non-primary key attribute)
//    which update the data in DB, always add the below two annotations.
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);

}
