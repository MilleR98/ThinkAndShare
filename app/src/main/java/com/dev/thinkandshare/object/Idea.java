package com.dev.thinkandshare.object;


import android.media.Image;

public class Idea {
    private String title;
    private String description;
    private boolean privateAccess;
    private User user;
    private String category;
    private Image ideaImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrivateAccess() {
        return privateAccess;
    }

    public void setPrivateAccess(boolean privateAccess) {
        this.privateAccess = privateAccess;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Image getIdeaImage() {
        return ideaImage;
    }

    public void setIdeaImage(Image ideaImage) {
        this.ideaImage = ideaImage;
    }

    public Idea(String title, String desccription, boolean privateAccess, User user, String category, Image ideaImage) {
        this.title = title;
        this.description = desccription;
        this.privateAccess = privateAccess;
        this.user = user;
        this.category = category;
        this.ideaImage = ideaImage;
    }
}
