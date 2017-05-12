package com.ldq.myproject.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LDQ on 2017/5/8.
 */

public class NewsResult implements Parcelable {

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"6c4caa0c3ba6e05e2a272892af43c00e","title":"杨幂的发际线再也回不去了么？网友吐槽像半秃","date":"2017-01-05 11:03","category":"yule","author_name":"腾讯娱乐","url":"","thumbnail_pic_s":"","thumbnail_pic_s02":"","thumbnail_pic_s03":""}]}
     */

    private String reason;
    private ResultBean result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean implements Parcelable {
        /**
         * stat : 1
         * data : [{"uniquekey":"6c4caa0c3ba6e05e2a272892af43c00e","title":"杨幂的发际线再也回不去了么？网友吐槽像半秃","date":"2017-01-05 11:03","category":"yule","author_name":"腾讯娱乐","url":"","thumbnail_pic_s":"","thumbnail_pic_s02":"","thumbnail_pic_s03":""}]
         */

        private String stat;
        private List<News> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<News> getData() {
            return data;
        }

        public void setData(List<News> data) {
            this.data = data;
        }

        public static class News implements Parcelable {
            /**
             * uniquekey : 6c4caa0c3ba6e05e2a272892af43c00e
             * title : 杨幂的发际线再也回不去了么？网友吐槽像半秃
             * date : 2017-01-05 11:03
             * category : yule
             * author_name : 腾讯娱乐
             * url :
             * thumbnail_pic_s :
             * thumbnail_pic_s02 :
             * thumbnail_pic_s03 :
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.uniquekey);
                dest.writeString(this.title);
                dest.writeString(this.date);
                dest.writeString(this.category);
                dest.writeString(this.author_name);
                dest.writeString(this.url);
                dest.writeString(this.thumbnail_pic_s);
                dest.writeString(this.thumbnail_pic_s02);
                dest.writeString(this.thumbnail_pic_s03);
            }

            public News() {
            }

            protected News(Parcel in) {
                this.uniquekey = in.readString();
                this.title = in.readString();
                this.date = in.readString();
                this.category = in.readString();
                this.author_name = in.readString();
                this.url = in.readString();
                this.thumbnail_pic_s = in.readString();
                this.thumbnail_pic_s02 = in.readString();
                this.thumbnail_pic_s03 = in.readString();
            }

            public static final Creator<News> CREATOR = new Creator<News>() {
                @Override
                public News createFromParcel(Parcel source) {
                    return new News(source);
                }

                @Override
                public News[] newArray(int size) {
                    return new News[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.stat);
            dest.writeList(this.data);
        }

        public ResultBean() {
        }

        protected ResultBean(Parcel in) {
            this.stat = in.readString();
            this.data = new ArrayList<News>();
            in.readList(this.data, News.class.getClassLoader());
        }

        public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
            @Override
            public ResultBean createFromParcel(Parcel source) {
                return new ResultBean(source);
            }

            @Override
            public ResultBean[] newArray(int size) {
                return new ResultBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.reason);
        dest.writeParcelable(this.result, flags);
    }

    public NewsResult() {
    }

    protected NewsResult(Parcel in) {
        this.reason = in.readString();
        this.result = in.readParcelable(ResultBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<NewsResult> CREATOR = new Parcelable.Creator<NewsResult>() {
        @Override
        public NewsResult createFromParcel(Parcel source) {
            return new NewsResult(source);
        }

        @Override
        public NewsResult[] newArray(int size) {
            return new NewsResult[size];
        }
    };
}
