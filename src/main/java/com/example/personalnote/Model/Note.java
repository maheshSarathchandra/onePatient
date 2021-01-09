package com.example.personalnote.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection="personalNote")
public class Note {

    @Id
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Long userId;

    private String archive;



    public Note() {
        super();
    }

    public Note(@NotBlank String title, @NotBlank String content, @NotNull Long userId, String archive) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.archive = archive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", archive='" + archive + '\'' +
                '}';
    }
}
