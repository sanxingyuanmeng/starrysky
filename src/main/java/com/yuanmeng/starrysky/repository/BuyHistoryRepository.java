package com.yuanmeng.starrysky.repository;

import com.yuanmeng.starrysky.model.BuyHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyHistoryRepository extends JpaRepository<BuyHistory, Long>{

}
