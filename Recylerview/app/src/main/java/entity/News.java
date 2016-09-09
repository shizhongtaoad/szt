package entity;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */
public class News { // []对应是集合，集合的元素类型--->
    List<Data> data;
    //键值对------>属性--：值
    //关心的值的类型，就是属性的类型
    //键的名字--就是---属性的名字 ，必须对应
    private String message;
    private int status;

    public News(String message, int status, List<Data> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    @Override
    public String toString() {
        return "News{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {
        private String summary;
        private String icon;
        private String stamp;
        private String title;
        private int nid;
        private String link;
        private int type;

        public Data(String summary, String icon, String stamp, String title, int nid, String link, int type) {
            this.summary = summary;
            this.icon = icon;
            this.stamp = stamp;
            this.title = title;
            this.nid = nid;
            this.link = link;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "summary='" + summary + '\'' +
                    ", icon='" + icon + '\'' +
                    ", stamp='" + stamp + '\'' +
                    ", title='" + title + '\'' +
                    ", nid=" + nid +
                    ", link='" + link + '\'' +
                    ", type=" + type +
                    '}';
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getStamp() {
            return stamp;
        }

        public void setStamp(String stamp) {
            this.stamp = stamp;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getNid() {
            return nid;
        }

        public void setNid(int nid) {
            this.nid = nid;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
