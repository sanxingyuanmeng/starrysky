package com.yuanmeng.starrysky.repository;

import com.yuanmeng.starrysky.model.GoodsLabels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsLabelsRepository extends JpaRepository<GoodsLabels, Long>{

}
