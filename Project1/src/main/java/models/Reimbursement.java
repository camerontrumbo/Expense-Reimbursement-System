package models;

import java.io.FileInputStream;
import java.sql.*;

public class Reimbursement {
    private Integer reimbId;
    private Double reimbAmount;
    private String reimbSubmitted;
    private String reimbResolved;
    private String reimbDescription;
    private FileInputStream reimbReciept;
    private Integer reimbAuthor;
    private Integer reimbResolver;
    private Integer reimbStatusId;
    private Integer reimbTypeId;

    public Reimbursement() {
    }

    public Reimbursement(Integer reimbId, Double reimbAmount, String reimbSubmitted, String reimbResolved,
                         String reimbDescription, FileInputStream reimbReciept, Integer reimbAuthor, Integer reimbResolver,
                         Integer reimbStatusId, Integer reimbTypeId) {
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbReciept = reimbReciept;
        this.reimbAuthor = reimbAuthor;
        this.reimbResolver = reimbResolver;
        this.reimbStatusId = reimbStatusId;
        this.reimbTypeId = reimbTypeId;
    }

    public Integer getReimbId() {
        return reimbId;
    }

    public void setReimbId(Integer reimbId) {
        this.reimbId = reimbId;
    }

    public Double getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(Double reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public String getReimbSubmitted() {
        return reimbSubmitted;
    }

    public void setReimbSubmitted(String reimbSubmitted) {
        this.reimbSubmitted = reimbSubmitted;
    }

    public String getReimbResolved() {
        return reimbResolved;
    }

    public void setReimbResolved(String reimbResolved) {
        this.reimbResolved = reimbResolved;
    }

    public String getReimbDescription() {
        return reimbDescription;
    }

    public void setReimbDescription(String reimbDescription) {
        this.reimbDescription = reimbDescription;
    }

    public FileInputStream getReimbReciept() {
        return reimbReciept;
    }

    public void setReimbReciept(FileInputStream reimbReciept) {
        this.reimbReciept = reimbReciept;
    }

    public Integer getReimbAuthor() {
        return reimbAuthor;
    }

    public void setReimbAuthor(Integer reimbAuthor) {
        this.reimbAuthor = reimbAuthor;
    }

    public Integer getReimbResolver() {
        return reimbResolver;
    }

    public void setReimbResolver(Integer reimbResolver) {
        this.reimbResolver = reimbResolver;
    }

    public Integer getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatusId(Integer reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

    public Integer getReimbTypeId() {
        return reimbTypeId;
    }

    public void setReimbTypeId(Integer reimbTypeId) {
        this.reimbTypeId = reimbTypeId;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbId=" + reimbId +
                ", reimbAmount=" + reimbAmount +
                ", reimbSubmitted=" + reimbSubmitted +
                ", reimbResolved=" + reimbResolved +
                ", reimbDescription='" + reimbDescription + '\'' +
                ", reimbReciept='" + reimbReciept + '\'' +
                ", reimbAuthor=" + reimbAuthor +
                ", reimbResolver=" + reimbResolver +
                ", reimbStatusId=" + reimbStatusId +
                ", reimbTypeId=" + reimbTypeId +
                '}';
    }
}
