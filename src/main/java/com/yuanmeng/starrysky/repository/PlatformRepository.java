package com.yuanmeng.starrysky.repository;

import com.yuanmeng.starrysky.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long>{

}
