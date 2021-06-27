package com.example.MLFeature.controller;

import com.example.MLFeature.model.AccessFeature;
import com.example.MLFeature.model.Feature;
import com.example.MLFeature.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Objects;


@RestController
@RequestMapping("/feature")
public class FeatureController {
    @Autowired
    FeatureService featureService;

    @GetMapping("")
    public AccessFeature getAccess(@RequestParam String email, @RequestParam String featureName)
    {
        try
        {
            AccessFeature accessFeature = featureService.checkAccess(email,featureName);
            if(Objects.isNull(accessFeature))
            {
                return null;
            }
            else
            {
                return accessFeature;
            }
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody Feature detail)
    {
        try {
                if(Objects.isNull(detail))
                {
                    return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                }
                else
                {
                    Integer rowCount = featureService.checkRecExists(detail);
                    if(rowCount>0)
                    {
                        featureService.updateAccess(detail.isEnable(),
                                detail.getEmail(),
                                detail.getFeatureName());
                        return new ResponseEntity<>(HttpStatus.OK);
                    }
                    else
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                }
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    //for myself to insert record
    @PostMapping("")
    public String insert(@RequestBody Feature detail)
    {
        try {
            if(Objects.isNull(detail))
            {
                return "Request Body not found.";
            }
            else
            {
                Integer recCount = featureService.checkRecExists(detail);
                if(recCount==0)
                {
                    featureService.saveRec(detail);
                    return "Record inserted.";
                }
                else
                    return "Records exists.";
            }
        }
        catch (NoSuchElementException e)
        {
            return "Failed";
        }
    }

}
