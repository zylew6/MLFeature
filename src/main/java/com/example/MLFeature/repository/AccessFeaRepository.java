package com.example.MLFeature.repository;

import com.example.MLFeature.model.AccessFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccessFeaRepository
        extends JpaRepository<AccessFeature, Integer> {

    @Query(value = "select enable from mst_feature where email =?1 and featureName =?2", nativeQuery = true)
    AccessFeature findByParams(String email, String featureName);
}
