package com.pigey.toodoolist.accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserModelRepository extends
        JpaRepository<UserModel, Long> {

    UserModel findByUsername (String username);

}
