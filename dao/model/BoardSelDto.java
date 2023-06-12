package com.green.java.dao.model;

public class BoardSelDto {
    private int iboard;
    private String title;
    private String ctnt;
    private String writer;
    private String createdAt;
    private String writerMainPic;

    public int getIboard() {
        return iboard;
    }

    public void setIboard(int iboard) {
        this.iboard = iboard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCtnt() {
        return ctnt;
    }

    public void setCtnt(String ctnt) {
        this.ctnt = ctnt;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getWriterMainPic() {
        return writerMainPic;
    }

    public void setWriterMainPic(String writerMainPic) {
        this.writerMainPic = writerMainPic;
    }
}
