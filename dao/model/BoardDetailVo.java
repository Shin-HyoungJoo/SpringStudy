package com.green.java.dao.model;

public class BoardDetailVo {
    private int iboard;
    private String title;
    private String ctnt;
    private String writer;
    private String createdAt;
    private String writerMainPic;

    public BoardDetailVo(int iboard, String title, String ctnt, String writer, String createdAt , String writerMainPic) {
        this.iboard = iboard;
        this.title = title;
        this.ctnt = ctnt;
        this.writer = writer;
        this.createdAt = createdAt;
        this.writerMainPic = writerMainPic;
    }

    public int getIboard() {
        return iboard;
    }

    public String getTitle() {
        return title;
    }

    public String getCtnt() {
        return ctnt;
    }

    public String getWriter() {
        return writer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getWriterMainPic() {
        return writerMainPic;
    }

    public String toString() {
        return String.format("iboard: %d, title: %s, ctnt: %s" +
                ", createdAt: %s, writer: %s, writerMainPic: %s", iboard, title, ctnt, createdAt,writer,writerMainPic);
    }
}
