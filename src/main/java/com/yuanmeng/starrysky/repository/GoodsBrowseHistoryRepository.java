package com.yuanmeng.starrysky.repository;

import com.yuanmeng.starrysky.model.GoodsBrowseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsBrowseHistoryRepository extends JpaRepository<GoodsBrowseHistory, Long>{

}
