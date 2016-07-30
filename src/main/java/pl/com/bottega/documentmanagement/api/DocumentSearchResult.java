package pl.com.bottega.documentmanagement.api;

/**
 * Created by arkadiuszarak on 30/07/2016.
 */
public class DocumentSearchResult {

    private Iterable<DocumentDto> documents;

    private int perPage, pageNumber, totalPage;

    public DocumentSearchResult(Iterable<DocumentDto> documents, int perPage, int pageNumber, int totalPages) {
        this.documents = documents;
        this.perPage = perPage;
        this.pageNumber = pageNumber;
        this.totalPage = totalPages;
    }

    public void setDocuments(Iterable<DocumentDto> documents) {
        this.documents = documents;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Iterable<DocumentDto> getDocuments() {

        return documents;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getTotalPage() {
        return totalPage;
    }
}
