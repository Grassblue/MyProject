package com.ldq.myproject.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LDQ on 2017/5/8.
 */

public class PictureResult implements Parcelable {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"pagebean":{"allNum":1192,"allPages":60,"contentlist":[{"itemId":"36731397","list":[{"big":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q.jpg","middle":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q_680x500.jpg","small":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q_113.jpg"},{"big":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31.jpg","middle":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31_680x500.jpg","small":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31_113.jpg"}],"title":"公园里的模特","type":4001,"typeName":"清纯"}],"currentPage":1,"maxResult":20},"ret_code":0}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean implements Parcelable {
        /**
         * pagebean : {"allNum":1192,"allPages":60,"contentlist":[{"itemId":"36731397","list":[{"big":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q.jpg","middle":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q_680x500.jpg","small":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q_113.jpg"},{"big":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31.jpg","middle":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31_680x500.jpg","small":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31_113.jpg"}],"title":"公园里的模特","type":4001,"typeName":"清纯"}],"currentPage":1,"maxResult":20}
         * ret_code : 0
         */

        private PagebeanBean pagebean;
        private int ret_code;

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public static class PagebeanBean implements Parcelable {
            /**
             * allNum : 1192
             * allPages : 60
             * contentlist : [{"itemId":"36731397","list":[{"big":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q.jpg","middle":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q_680x500.jpg","small":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q_113.jpg"},{"big":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31.jpg","middle":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31_680x500.jpg","small":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31_113.jpg"}],"title":"公园里的模特","type":4001,"typeName":"清纯"}]
             * currentPage : 1
             * maxResult : 20
             */

            private int allNum;
            private int allPages;
            private int currentPage;
            private int maxResult;
            private List<PictureInfo> contentlist;

            public int getAllNum() {
                return allNum;
            }

            public void setAllNum(int allNum) {
                this.allNum = allNum;
            }

            public int getAllPages() {
                return allPages;
            }

            public void setAllPages(int allPages) {
                this.allPages = allPages;
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public int getMaxResult() {
                return maxResult;
            }

            public void setMaxResult(int maxResult) {
                this.maxResult = maxResult;
            }

            public List<PictureInfo> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<PictureInfo> contentlist) {
                this.contentlist = contentlist;
            }

            public static class PictureInfo implements Parcelable {
                /**
                 * itemId : 36731397
                 * list : [{"big":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q.jpg","middle":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q_680x500.jpg","small":"http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q_113.jpg"},{"big":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31.jpg","middle":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31_680x500.jpg","small":"http://image.tianjimedia.com/uploadImages/2014/100/31/A6LHQIIA4O31_113.jpg"}]
                 * title : 公园里的模特
                 * type : 4001
                 * typeName : 清纯
                 */

                private String itemId;
                private String title;
                private int type;
                private String typeName;
                private List<Picture> list;

                public String getItemId() {
                    return itemId;
                }

                public void setItemId(String itemId) {
                    this.itemId = itemId;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getTypeName() {
                    return typeName;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }

                public List<Picture> getList() {
                    return list;
                }

                public void setList(List<Picture> list) {
                    this.list = list;
                }

                public static class Picture implements Parcelable {
                    /**
                     * big : http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q.jpg
                     * middle : http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q_680x500.jpg
                     * small : http://image.tianjimedia.com/uploadImages/2014/100/01/R1TJ0A4E320Q_113.jpg
                     */

                    private String big;
                    private String middle;
                    private String small;

                    public String getBig() {
                        return big;
                    }

                    public void setBig(String big) {
                        this.big = big;
                    }

                    public String getMiddle() {
                        return middle;
                    }

                    public void setMiddle(String middle) {
                        this.middle = middle;
                    }

                    public String getSmall() {
                        return small;
                    }

                    public void setSmall(String small) {
                        this.small = small;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(this.big);
                        dest.writeString(this.middle);
                        dest.writeString(this.small);
                    }

                    public Picture() {
                    }

                    protected Picture(Parcel in) {
                        this.big = in.readString();
                        this.middle = in.readString();
                        this.small = in.readString();
                    }

                    public static final Creator<Picture> CREATOR = new Creator<Picture>() {
                        @Override
                        public Picture createFromParcel(Parcel source) {
                            return new Picture(source);
                        }

                        @Override
                        public Picture[] newArray(int size) {
                            return new Picture[size];
                        }
                    };
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.itemId);
                    dest.writeString(this.title);
                    dest.writeInt(this.type);
                    dest.writeString(this.typeName);
                    dest.writeList(this.list);
                }

                public PictureInfo() {
                }

                protected PictureInfo(Parcel in) {
                    this.itemId = in.readString();
                    this.title = in.readString();
                    this.type = in.readInt();
                    this.typeName = in.readString();
                    this.list = new ArrayList<Picture>();
                    in.readList(this.list, Picture.class.getClassLoader());
                }

                public static final Creator<PictureInfo> CREATOR = new Creator<PictureInfo>() {
                    @Override
                    public PictureInfo createFromParcel(Parcel source) {
                        return new PictureInfo(source);
                    }

                    @Override
                    public PictureInfo[] newArray(int size) {
                        return new PictureInfo[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.allNum);
                dest.writeInt(this.allPages);
                dest.writeInt(this.currentPage);
                dest.writeInt(this.maxResult);
                dest.writeList(this.contentlist);
            }

            public PagebeanBean() {
            }

            protected PagebeanBean(Parcel in) {
                this.allNum = in.readInt();
                this.allPages = in.readInt();
                this.currentPage = in.readInt();
                this.maxResult = in.readInt();
                this.contentlist = new ArrayList<PictureInfo>();
                in.readList(this.contentlist, PictureInfo.class.getClassLoader());
            }

            public static final Creator<PagebeanBean> CREATOR = new Creator<PagebeanBean>() {
                @Override
                public PagebeanBean createFromParcel(Parcel source) {
                    return new PagebeanBean(source);
                }

                @Override
                public PagebeanBean[] newArray(int size) {
                    return new PagebeanBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.pagebean, flags);
            dest.writeInt(this.ret_code);
        }

        public ShowapiResBodyBean() {
        }

        protected ShowapiResBodyBean(Parcel in) {
            this.pagebean = in.readParcelable(PagebeanBean.class.getClassLoader());
            this.ret_code = in.readInt();
        }

        public static final Creator<ShowapiResBodyBean> CREATOR = new Creator<ShowapiResBodyBean>() {
            @Override
            public ShowapiResBodyBean createFromParcel(Parcel source) {
                return new ShowapiResBodyBean(source);
            }

            @Override
            public ShowapiResBodyBean[] newArray(int size) {
                return new ShowapiResBodyBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.showapi_res_code);
        dest.writeString(this.showapi_res_error);
        dest.writeParcelable(this.showapi_res_body, flags);
    }

    public PictureResult() {
    }

    protected PictureResult(Parcel in) {
        this.showapi_res_code = in.readInt();
        this.showapi_res_error = in.readString();
        this.showapi_res_body = in.readParcelable(ShowapiResBodyBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<PictureResult> CREATOR = new Parcelable.Creator<PictureResult>() {
        @Override
        public PictureResult createFromParcel(Parcel source) {
            return new PictureResult(source);
        }

        @Override
        public PictureResult[] newArray(int size) {
            return new PictureResult[size];
        }
    };
}
