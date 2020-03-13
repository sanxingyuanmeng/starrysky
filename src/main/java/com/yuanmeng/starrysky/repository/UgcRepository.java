package com.yuanmeng.starrysky.repository;

import com.yuanmeng.starrysky.model.Ugc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UgcRepository extends JpaRepository<Ugc, Long>{

    //Ugc findById(Long id);

}
