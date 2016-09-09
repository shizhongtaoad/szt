package com.myhttpjson.hjson.entity;

/**
 * Created by Administrator on 2016/8/26.
 */
public class news {

    String template;
    String hasCover;
    String alias;
    String subnum;
    String img;
    String color;
    String tname;
    String showType;
    String ename;
    int topicid;
    int recommendOr;
    int isNew;
    int isHot;
    int cid;
    int recommend;
    int bannerOrder;
    int special;
    int tid;


    public news(String template, String hasCover, String alias, String subnum, String img, String color, String tname, String showType, String ename, int topicid, int recommendOrder, int isNew, int isHot, int cid, int recommend, int bannerOrder, int special, int tid, boolean hasIcon) {
        this.alias = alias;
        this.bannerOrder = bannerOrder;
        this.cid = cid;
        this.color = color;
        this.ename = ename;
        this.hasCover = hasCover;
        this.img = img;
        this.isHot = isHot;
        this.isNew = isNew;
        this.recommend = recommend;
        this.recommendOr = recommendOr;
        this.showType = showType;
        this.special = special;
        this.subnum = subnum;
        this.template = template;
        this.tid = tid;
        this.tname = tname;
        this.topicid = topicid;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getBannerOrder() {
        return bannerOrder;
    }

    public void setBannerOrder(int bannerOrder) {
        this.bannerOrder = bannerOrder;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getHasCover() {
        return hasCover;
    }

    public void setHasCover(String hasCover) {
        this.hasCover = hasCover;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public int getRecommendOr() {
        return recommendOr;
    }

    public void setRecommendOr(int recommendOr) {
        this.recommendOr = recommendOr;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    public String getSubnum() {
        return subnum;
    }

    public void setSubnum(String subnum) {
        this.subnum = subnum;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }
}
