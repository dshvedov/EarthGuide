package ru.d9d.earthguide.models;

public class Place {

    private String mName;

    private String mDescription;

    private int mImageResourceId = NO_RESOURCE_PROVIDED;

    private static final int NO_RESOURCE_PROVIDED = -1;

    /**
     * Place constructor
     *
     * @param image       Place image resource id
     * @param name        Place name (short)
     * @param description Place detailed description
     */
    public Place(int image, String name, String description) {
        this.mName = name;
        this.mDescription = description;
        this.mImageResourceId = image;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_RESOURCE_PROVIDED;
    }

}
