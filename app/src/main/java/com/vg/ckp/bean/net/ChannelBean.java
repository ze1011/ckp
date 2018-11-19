package com.vg.ckp.bean.net;

import java.util.List;

/**
 * 直播列表下面节目
 */
public class ChannelBean {
    @Override
    public String toString() {
        return "ChannelBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * msg : 操作成功
     * data : {"count":11,"lists":[{"title":"暖心小宝！！","img":"http://os.166kk8.com/public/attachment/201811/07/10/origin/15415282551956501.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a7.womantea.com/live/44724_a9274fa63953d98ea0d2.flv?auth_key=1542339230-0-0-d1b4784b48a1b7788a0994f3aef1ed93&t=OTcwNjY5MzIzMA==","flag":1,"id":1},{"title":"Fi美妮","img":"http://os.166kk8.com/public/attachment/201811/03/08/origin/1541177676191034.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a9.womantea.com/live/44718_13a78ea63430290612d8.flv?auth_key=1542339232-0-0-6f91e5ca7046d0dd99f7cd077871b0f4&t=OTcwNjY5MzIzMA==","flag":1,"id":2},{"title":"奇缘小溪","img":"http://os.166kk8.com/public/attachment/201811/03/12/origin/154119183867756467.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a10.womantea.com/live/44704_9ce7076e99fc95fbe22f.flv?auth_key=1542339236-0-0-7771341b6ab548d80031eb5d73a58fd6&t=OTcwNjY5MzIzMA==","flag":1,"id":3},{"title":"eoeoeo","img":"http://os.166kk8.com/public/attachment/201811/16/10/origin/154230724356579722.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://jingduo33.top/70156_314edcd687359121fa2a.flv","flag":1,"id":4},{"title":"苏西全国可约","img":"http://os.166kk8.com/public/attachment/201811/03/12/origin/1541191247198874.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a7.womantea.com/live/44661_036dd8a50f192f3ff7c1.flv?auth_key=1542339247-0-0-28d4f3dc0b65d1e732758a4fc7371fe1&t=OTcwNjY5MzIzMA==","flag":1,"id":5},{"title":"可可爱～","img":"http://os.166kk8.com/public/attachment/201811/16/10/origin/15423065492007258.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a9.womantea.com/live/44648_251afe38ef1c02aa6864.flv?auth_key=1542339250-0-0-3b38259e11a98b261e7850d29e16e6da&t=OTcwNjY5MzIzMA==","flag":1,"id":6},{"title":"小玲妹妹","img":"http://os.166kk8.com/public/attachment/201811/16/10/origin/154230640384408745.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://macrotrader.top/39760_08096451486138caaa8c.flv","flag":1,"id":7},{"title":"萌萌哒的小魔女","img":"http://os.166kk8.com/public/attachment/201811/16/09/origin/154230468129877738.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a8.womantea.com/live/44624_b78548884f9cff1319a3.flv?auth_key=1542339256-0-0-1828c0d81eaefdb95a41493c1b1ef218&t=OTcwNjY5MzIzMA==","flag":1,"id":8},{"title":"小表妹","img":"http://os.166kk8.com/public/attachment/201811/16/09/origin/154230469230705044.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a9.womantea.com/live/44599_16045a6943ba5b847580.flv?auth_key=1542339265-0-0-76c0343ea7084d52fcfd5e59c3aeda45&t=OTcwNjY5MzIzMA==","flag":1,"id":9},{"title":"小柚柚","img":"http://os.166kk8.com/public/attachment/201811/15/14/origin/1542233615225227.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a8.womantea.com/live/44587_a0ad1c626b8ceb4ee637.flv?auth_key=1542339275-0-0-46523acf4daac72742d6407592e9b6cb&t=OTcwNjY5MzIzMA==","flag":1,"id":10},{"title":"kkb\u2015\u2015一个人的电影","img":"http://os.166kk8.com/public/attachment/201811/05/09/origin/1541352870101622.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a10.womantea.com/live/44537_e4abfc607d2773e5dad2.flv?auth_key=1542339289-0-0-0f80fdea2ed689d3877a08439ca8af18&t=OTcwNjY5MzIzMA==","flag":1,"id":11}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "count=" + count +
                    ", lists=" + lists +
                    '}';
        }

        /**
         * count : 11
         * lists : [{"title":"暖心小宝！！","img":"http://os.166kk8.com/public/attachment/201811/07/10/origin/15415282551956501.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a7.womantea.com/live/44724_a9274fa63953d98ea0d2.flv?auth_key=1542339230-0-0-d1b4784b48a1b7788a0994f3aef1ed93&t=OTcwNjY5MzIzMA==","flag":1,"id":1},{"title":"Fi美妮","img":"http://os.166kk8.com/public/attachment/201811/03/08/origin/1541177676191034.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a9.womantea.com/live/44718_13a78ea63430290612d8.flv?auth_key=1542339232-0-0-6f91e5ca7046d0dd99f7cd077871b0f4&t=OTcwNjY5MzIzMA==","flag":1,"id":2},{"title":"奇缘小溪","img":"http://os.166kk8.com/public/attachment/201811/03/12/origin/154119183867756467.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a10.womantea.com/live/44704_9ce7076e99fc95fbe22f.flv?auth_key=1542339236-0-0-7771341b6ab548d80031eb5d73a58fd6&t=OTcwNjY5MzIzMA==","flag":1,"id":3},{"title":"eoeoeo","img":"http://os.166kk8.com/public/attachment/201811/16/10/origin/154230724356579722.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://jingduo33.top/70156_314edcd687359121fa2a.flv","flag":1,"id":4},{"title":"苏西全国可约","img":"http://os.166kk8.com/public/attachment/201811/03/12/origin/1541191247198874.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a7.womantea.com/live/44661_036dd8a50f192f3ff7c1.flv?auth_key=1542339247-0-0-28d4f3dc0b65d1e732758a4fc7371fe1&t=OTcwNjY5MzIzMA==","flag":1,"id":5},{"title":"可可爱～","img":"http://os.166kk8.com/public/attachment/201811/16/10/origin/15423065492007258.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a9.womantea.com/live/44648_251afe38ef1c02aa6864.flv?auth_key=1542339250-0-0-3b38259e11a98b261e7850d29e16e6da&t=OTcwNjY5MzIzMA==","flag":1,"id":6},{"title":"小玲妹妹","img":"http://os.166kk8.com/public/attachment/201811/16/10/origin/154230640384408745.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://macrotrader.top/39760_08096451486138caaa8c.flv","flag":1,"id":7},{"title":"萌萌哒的小魔女","img":"http://os.166kk8.com/public/attachment/201811/16/09/origin/154230468129877738.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a8.womantea.com/live/44624_b78548884f9cff1319a3.flv?auth_key=1542339256-0-0-1828c0d81eaefdb95a41493c1b1ef218&t=OTcwNjY5MzIzMA==","flag":1,"id":8},{"title":"小表妹","img":"http://os.166kk8.com/public/attachment/201811/16/09/origin/154230469230705044.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a9.womantea.com/live/44599_16045a6943ba5b847580.flv?auth_key=1542339265-0-0-76c0343ea7084d52fcfd5e59c3aeda45&t=OTcwNjY5MzIzMA==","flag":1,"id":9},{"title":"小柚柚","img":"http://os.166kk8.com/public/attachment/201811/15/14/origin/1542233615225227.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a8.womantea.com/live/44587_a0ad1c626b8ceb4ee637.flv?auth_key=1542339275-0-0-46523acf4daac72742d6407592e9b6cb&t=OTcwNjY5MzIzMA==","flag":1,"id":10},{"title":"kkb\u2015\u2015一个人的电影","img":"http://os.166kk8.com/public/attachment/201811/05/09/origin/1541352870101622.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260","play_url":"http://a10.womantea.com/live/44537_e4abfc607d2773e5dad2.flv?auth_key=1542339289-0-0-0f80fdea2ed689d3877a08439ca8af18&t=OTcwNjY5MzIzMA==","flag":1,"id":11}]
         */

        private int count;
        private List<ListsBean> lists;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListsBean> getLists() {
            return lists;
        }

        public void setLists(List<ListsBean> lists) {
            this.lists = lists;
        }

        public static class ListsBean {
            /**
             * title : 暖心小宝！！
             * img : http://os.166kk8.com/public/attachment/201811/07/10/origin/15415282551956501.jpg?x-oss-process=image/resize,m_mfit,h_260,w_260
             * play_url : http://a7.womantea.com/live/44724_a9274fa63953d98ea0d2.flv?auth_key=1542339230-0-0-d1b4784b48a1b7788a0994f3aef1ed93&t=OTcwNjY5MzIzMA==
             * flag : 1
             * id : 1
             */

            private String title;
            private String img;
            private String play_url;
            private int flag;
            private int id;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getPlay_url() {
                return play_url;
            }

            public void setPlay_url(String play_url) {
                this.play_url = play_url;
            }

            public int getFlag() {
                return flag;
            }

            public void setFlag(int flag) {
                this.flag = flag;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
