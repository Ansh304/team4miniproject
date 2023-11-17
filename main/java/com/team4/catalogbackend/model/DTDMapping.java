package com.team4.catalogbackend.model;

import java.sql.Time;

//import com.team4.catalogbackend.model.Deliverables;

import jakarta.persistence.*;

@Entity
public class DTDMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dtdMappingId;

    @ManyToOne
    @JoinColumn(name = "dt_mapping_id")
    private DTMapping dtMapping;

    @ManyToOne
    @JoinColumn(name = "deliverables_id")
    private Deliverables deliverables;
    
    private String createdBy;
    private Time createdOn;
    private String modifiedBy;
    private Time modifiedOn;
    private boolean isEnabled;

    // Getters and setters

    public Long getDtdMappingId() {
        return dtdMappingId;
    }

    public void setDtdMappingId(Long dtdMappingId) {
        this.dtdMappingId = dtdMappingId;
    }

    public DTMapping getDtMapping() {
        return dtMapping;
    }

    public void setDtMapping(DTMapping dtMapping) {
        this.dtMapping = dtMapping;
    }

    public Deliverables getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(Deliverables deliverables) {
        this.deliverables = deliverables;
    }

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Time getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Time createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Time getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Time modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
    
}
