package com.example.MLFeature.repository;
import com.example.MLFeature.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface FeatureRepository
        extends JpaRepository<Feature,Integer> {

    @Modifying
    @Query("update Feature set enable = :access where email = :e_mail and featureName = :feature_Name")
    void updateEnable(@Param(value = "access") boolean access,
                     @Param(value = "e_mail") String email ,
                     @Param(value = "feature_Name") String featureName );


    @Query(value = "select count(email) from mst_feature where email =?1 and featureName =?2", nativeQuery = true)
    Integer checkExists(String email, String featureName);

    //for myself to insert record
    @Modifying
    @Query(value = "insert into mst_feature (featureName,email,enable) VALUES (:featureName,:email,:enable)",
            nativeQuery = true)
    @Transactional
    void insertRec(@Param("featureName") String featureName, @Param("email") String email, @Param("enable") boolean access);
}
