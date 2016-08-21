package pl.com.bottega.documentmanagement.api;

import pl.com.bottega.documentmanagement.domain.DocumentStatus;

import java.util.Date;
import java.util.Objects;

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
        return Objects.equals(getNumber(), that.getNumber()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getContent(), that.getContent()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getCreatorId(), that.getCreatorId()) &&
                Objects.equals(getVerificatorId(), that.getVerificatorId()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(getVerificatedAt(), that.getVerificatedAt()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getTitle(), getContent(), getStatus(), getCreatorId(), getVerificatorId(), getCreatedAt(), getVerificatedAt(), getUpdatedAt());
    }
}
