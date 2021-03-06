package pl.com.bottega.documentmanagement.api;

import com.google.common.base.Objects;
import pl.com.bottega.documentmanagement.domain.DocumentStatus;

import java.util.Date;


/**
 * Created by maciuch on 12.06.16.
 */
public class DocumentDto {

    private String number;
    private String title;
    private String content;
    private String status;

    private Long creatorId, verificatorId;

    private Date createdAt, verificatedAt, updatedAt;
    public DocumentDto(String number, String title, String content, DocumentStatus status, Date createdAt, Date verificatedAt, Date updatedAt, Long creatorId, Long verificatorId) {
        this.number = number;
        this.title = title;
        this.content = content;
        this.status = status.name();
        this.createdAt = createdAt;
        this.verificatedAt = verificatedAt;
        this.updatedAt = updatedAt;
        this.creatorId = creatorId;
        this.verificatorId = verificatorId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public Long getVerificatorId() {
        return verificatorId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getVerificatedAt() {
        return verificatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentDto that = (DocumentDto) o;
        return java.util.Objects.equals(getNumber(), that.getNumber()) &&
                java.util.Objects.equals(getTitle(), that.getTitle()) &&
                java.util.Objects.equals(getContent(), that.getContent()) &&
                java.util.Objects.equals(getStatus(), that.getStatus()) &&
                java.util.Objects.equals(getCreatorId(), that.getCreatorId()) &&
                java.util.Objects.equals(getVerificatorId(), that.getVerificatorId()) &&
                java.util.Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                java.util.Objects.equals(getVerificatedAt(), that.getVerificatedAt()) &&
                java.util.Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getNumber(), getTitle(), getContent(), getStatus(), getCreatorId(), getVerificatorId(), getCreatedAt(), getVerificatedAt(), getUpdatedAt());
    }
}
