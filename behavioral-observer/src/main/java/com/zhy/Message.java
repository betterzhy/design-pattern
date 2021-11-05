package com.zhy;

// 消息载体
public class Message {
    String action;
    String description;
    String link;

    public Message(String action, String description, String link) {
        this.action = action;
        this.description = description;
        this.link = link;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
