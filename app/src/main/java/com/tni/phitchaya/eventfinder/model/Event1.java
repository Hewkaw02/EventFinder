package com.tni.phitchaya.eventfinder.model;

public class Event1 {

    public static final String FIELD_NAME = "name";
    public static final String FIELD_POPULARITY = "popularity";

    private  String name;
    private  int popularity;

    public Event1() {}

    public Event1(String name,int popularity){
        this.name = name;
        this.popularity = popularity;
    }

//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("popularity")
//    @Expose
//    private Integer popularity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

}

