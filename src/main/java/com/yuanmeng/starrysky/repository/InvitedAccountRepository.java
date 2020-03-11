package com.yuanmeng.starrysky.repository;

import com.yuanmeng.starrysky.model.InvitedAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitedAccountRepository extends JpaRepository<InvitedAccount, Long>{

}
