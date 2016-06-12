package pl.com.bottega.documentmanagement.infrastructure;

/**
 * Created by arkadiuszarak on 12/06/2016.
 */
public class DocumentDto {

    private String number;
    private String title;
    private String content;
    private String status;

    public String getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
