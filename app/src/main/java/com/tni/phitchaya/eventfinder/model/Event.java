package com.tni.phitchaya.eventfinder.model;

public class Event {

    public static final String FIELD_NAME = "name";
    public static final String FIELD_POPULARITY = "popularity";

    private String name;
    private String provide;
    private String location;
    private String startTime;
    private String endTime;
    private String startdate;
    private String enddate;
    private String category;
    private String img;
    private String detail;
    private  int popularity;


    public Event(String name,String provide , String location , String startTime, String endTime,
                 String startdate,/*String enddate,*/
                 String category , String img , String detail, int popularity){
        this.name = name;
        this.provide = provide;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime ;
        this.startdate = startdate;
//        this.enddate = enddate;
        this.category = category;
        this.img = img;
        this.detail = detail;
        this.popularity = popularity;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvide() {
        return provide;
    }

    public void setProvide(String provide) {
        this.provide = provide;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

//    public String getEnddate() {
//        return enddate;
//    }
//
//    public void setEnddate(String enddate) {
//        this.enddate = enddate;
//    }

}
