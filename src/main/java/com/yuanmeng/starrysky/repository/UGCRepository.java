package com.yuanmeng.starrysky.repository;

import com.yuanmeng.starrysky.model.UGC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UGCRepository extends JpaRepository<UGC, Long>{

}
