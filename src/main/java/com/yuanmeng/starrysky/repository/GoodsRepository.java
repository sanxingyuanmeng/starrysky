package com.yuanmeng.starrysky.repository;

import com.yuanmeng.starrysky.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>{

}
