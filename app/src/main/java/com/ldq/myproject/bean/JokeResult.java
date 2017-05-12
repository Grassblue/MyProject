package com.ldq.myproject.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by S01 on 2017/5/6.
 */

public class JokeResult implements Parcelable {

    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"有一天晚上我俩一起吃西瓜，老大把西瓜籽很整洁的吐在了一张纸上，\r\n过了几天，我从教室回但宿舍看到老大在磕瓜子，\r\n我就问他：老大，你什么时候买的瓜子？\r\n老大说：刚晒好，说着抓了一把要递给我\u2026\u2026","hashId":"bcc5fdc2fb6efc6db33fa242474f108a","unixtime":1418814837,"updatetime":"2014-12-17 19:13:57"},{"content":"＂我女朋友气跑了＂\r\n＂怎么回事？严重吗？你怎么着她了？＂\r\n＂不严重，我只是很久没用了＂","hashId":"03a6095c18e1d6fe7e2c19b2a20d03d1","unixtime":1418814837,"updatetime":"2014-12-17 19:13:57"},{"content":"还说神马来一场说走就走的旅行，\r\n工作后就连一场说走就走的下班都不行。","hashId":"10edf75c1e7d0933c91f0f39a28a2c84","unixtime":1418814837,"updatetime":"2014-12-17 19:13:57"},{"content":"高速路上堵车，路边葡萄地里有一哥们竟然在偷葡萄，心想太没素质了吧！\r\n不管了我也去，刚溜进葡萄地，那哥们竟问我干嘛，\r\n我撇了一眼反问道你干嘛呢？\r\n那哥们答道摘葡萄呢！\r\n我答道：我也摘葡萄呢！\r\n哥们郁闷了说我摘我家的你呢？\r\n我顿时脸红，哥你家葡萄咋卖呢？","hashId":"bb572bb5b4844badb31012983f7324f5","unixtime":1418814837,"updatetime":"2014-12-17 19:13:57"},{"content":"和老婆在街边散步，我手上捏着一张已揉成一团的传单，\r\n走了好一会终于看到个垃圾桶，我赶紧跑过去想扔掉，\r\n没想到老婆从后边一把拉住我说：老公，那个肯定吃不得了，别捡。\r\n我一愣，发现垃圾桶顶盖上放着半个西瓜。","hashId":"7ebccd3bbfaf24e010f9eb3ee68234bd","unixtime":1418814837,"updatetime":"2014-12-17 19:13:57"},{"content":"某考生考了个倒数第一，回到家被他爸一顿暴揍，\r\n来到学校老师让他谈谈落后的体会，\r\n学生：\u201c我终于明白了\u201c落后就要挨打\u201d的道理。\u201d","hashId":"4aee2aa6a79c67682f605c4146a8eca4","unixtime":1418814837,"updatetime":"2014-12-17 19:13:57"},{"content":"很多人不喜欢朝九晚五的生活，然后开始创业。\r\n最终，他的生活变成了朝五晚九。","hashId":"7b358c4b96cf4a8d82b85545ea8f9603","unixtime":1418814837,"updatetime":"2014-12-17 19:13:57"},{"content":"钱这个东西，真是害人精。\r\n小到人与人之间的矛盾，大到国家之间的战争，无不是为了钱。\r\n钱可以把人推上万众瞩目之颠，也可以使人瞬间变成阶下囚。\r\n可是，富人们却没认识到，当钱几辈子花不完时，\r\n挣再多已经没有意义，还不如早日尽点社会责任，\r\n捐助给需要的人，求得个平安幸福。\r\n看到这个的有钱人们呐，你们什么时侯能捐我点啊！","hashId":"94e18075f8c9c8211dfed5f8d6a62983","unixtime":1418814837,"updatetime":"2014-12-17 19:13:57"},{"content":"看到一句很好的名言：我们无法拉伸生命的长度，但是我们可以拓展生命的宽度。\r\n我觉得这句话太有道理了！\r\n意思就是：虽然我们无法再长高了，但是我们还可以继续长胖。","hashId":"fd8e364a4c70d46e77c1610879748a9a","unixtime":1418814837,"updatetime":"2014-12-17 19:13:57"},{"content":"女生口中所说的\u201c理工男好萌好棒好想嫁！\u201d，\r\n其实理工男是指\u201c会修电脑、会设置手机、会安家用电器、\r\n会帮做PPT打EXCEL表PS修图、话少、高冷、专一、不和乱七八糟的女生来往、\r\n不爱打扮却又干净清爽、高高瘦瘦、手指纤长、戴黑框眼镜超好看的帅哥\u201d。\r\n其实找个帅哥让他学电脑，再戴个眼镜就OK了。","hashId":"5001c08a3cc8a281b15c467bc15a4911","unixtime":1418814837,"updatetime":"2014-12-17 19:13:57"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public JokeResult() {
    }

    public JokeResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

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
        private List<Joke> data;

        public ResultBean() {
        }

        public ResultBean(List<Joke> data) {
            this.data = data;
        }

        public List<Joke> getData() {
            return data;
        }

        public void setData(List<Joke> data) {
            this.data = data;
        }

        public static class Joke implements Parcelable {
            /**
             * content : 有一天晚上我俩一起吃西瓜，老大把西瓜籽很整洁的吐在了一张纸上，
             * 过了几天，我从教室回但宿舍看到老大在磕瓜子，
             * 我就问他：老大，你什么时候买的瓜子？
             * 老大说：刚晒好，说着抓了一把要递给我……
             * hashId : bcc5fdc2fb6efc6db33fa242474f108a
             * unixtime : 1418814837
             * updatetime : 2014-12-17 19:13:57
             */

            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            public Joke(String content, String hashId, int unixtime, String updatetime) {
                this.content = content;
                this.hashId = hashId;
                this.unixtime = unixtime;
                this.updatetime = updatetime;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public Joke() {
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.content);
                dest.writeString(this.hashId);
                dest.writeInt(this.unixtime);
                dest.writeString(this.updatetime);
            }

            protected Joke(Parcel in) {
                this.content = in.readString();
                this.hashId = in.readString();
                this.unixtime = in.readInt();
                this.updatetime = in.readString();
            }

            public static final Creator<Joke> CREATOR = new Creator<Joke>() {
                @Override
                public Joke createFromParcel(Parcel source) {
                    return new Joke(source);
                }

                @Override
                public Joke[] newArray(int size) {
                    return new Joke[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeTypedList(this.data);
        }

        protected ResultBean(Parcel in) {
            this.data = in.createTypedArrayList(Joke.CREATOR);
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
        dest.writeInt(this.error_code);
        dest.writeString(this.reason);
        dest.writeParcelable(this.result, flags);
    }

    protected JokeResult(Parcel in) {
        this.error_code = in.readInt();
        this.reason = in.readString();
        this.result = in.readParcelable(ResultBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<JokeResult> CREATOR = new Parcelable.Creator<JokeResult>() {
        @Override
        public JokeResult createFromParcel(Parcel source) {
            return new JokeResult(source);
        }

        @Override
        public JokeResult[] newArray(int size) {
            return new JokeResult[size];
        }
    };
}
