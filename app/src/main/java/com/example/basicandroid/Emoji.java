package com.example.basicandroid;

public class Emoji {
    private String emojiCode;

    public Emoji(String code) {
        this.emojiCode = code;
    }

    public String getEmojiCode() {
        return this.emojiCode;
    }

    public void setEmojiCode(String emojiCode) {
        this.emojiCode = emojiCode;
    }
}
