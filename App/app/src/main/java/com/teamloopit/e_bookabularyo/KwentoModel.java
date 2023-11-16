package com.teamloopit.e_bookabularyo;

public class KwentoModel {
    private int imageResourceId;
    private String kwentoTitle;

    public KwentoModel(int imageResourceId, String kwentoInfo) {
        this.imageResourceId = imageResourceId;
        this.kwentoTitle = kwentoInfo;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getKwentoTitle() {
        return kwentoTitle;
    }
}
