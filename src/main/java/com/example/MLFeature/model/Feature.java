package com.example.MLFeature.model;

import javax.persistence.*;

@Entity
@Table(name="MST_FEATURE")
public class Feature {
    @Id
    private String featureName;
    private String email;
    private boolean enable;

    public Feature() {
    }

    public Feature(String featureName, String email, boolean enable) {
        this.featureName = featureName;
        this.email = email;
        this.enable = enable;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
