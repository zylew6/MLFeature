package com.example.MLFeature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MST_FEATURE")
public class AccessFeature {
    @Id
    @Column(name="enable")
    private boolean canAccess;

    public AccessFeature() {
    }

    public AccessFeature(boolean canAccess) {
        this.canAccess = canAccess;
    }

    public boolean isCanAccess() {
        return canAccess;
    }

    public void setCanAccess(boolean canAccess) {
        this.canAccess = canAccess;
    }
}
