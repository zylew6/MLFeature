package com.example.MLFeature.service;

import com.example.MLFeature.model.AccessFeature;
import com.example.MLFeature.model.Feature;
import com.example.MLFeature.repository.AccessFeaRepository;
import com.example.MLFeature.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private AccessFeaRepository accessFeaRepository;

    public AccessFeature checkAccess(String email, String featureName)
    {
        return accessFeaRepository.findByParams(email,featureName);
    };

    public void updateAccess(Boolean access, String email, String featureName)
    {
        featureRepository.updateEnable(access,email,featureName);
    };

    public Integer checkRecExists(Feature feature)
    {
        return featureRepository.checkExists(feature.getEmail(),feature.getFeatureName());
    };

    //for myself to insert record
    public void saveRec(Feature feature) {
        featureRepository.insertRec(feature.getFeatureName(), feature.getEmail(), feature.isEnable());
    }

}
