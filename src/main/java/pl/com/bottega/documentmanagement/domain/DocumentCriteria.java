package pl.com.bottega.documentmanagement.domain;

import java.util.Date;

/**
 * Created by arkadiuszarak on 12/06/2016.
 */
public class DocumentCriteria {
    private DocumentStatus status;
    private Long verifiedBy;
    private Long createdBy;
    private Date createdFrom, createdUntil;
    private Date verifiedFrom, verifiedUntil;
    private String query;

    public boolean isStatusDefined(){
        return status != null;
    }

    public boolean isCreatedByDefined(){
        return createdBy != null;
    }

    public boolean isCreatedDatesDefined(){
        return createdFrom != null;
    }

    public boolean isCreatedUntilDefined(){
        return createdUntil != null;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public boolean isQueryDefined(){

    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public Long getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(Long verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedFrom() {
        return createdFrom;
    }

    public void setCreatedFrom(Date createdFrom) {
        this.createdFrom = createdFrom;
    }

    public Date getCreatedUntil() {
        return createdUntil;
    }

    public void setCreatedUntil(Date createdUntil) {
        this.createdUntil = createdUntil;
    }

    public Date getVerifiedFrom() {
        return verifiedFrom;
    }

    public void setVerifiedFrom(Date verifiedFrom) {
        this.verifiedFrom = verifiedFrom;
    }

    public Date getVerifiedUntil() {
        return verifiedUntil;
    }

    public void setVerifiedUntil(Date verifiedUntil) {
        this.verifiedUntil = verifiedUntil;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
