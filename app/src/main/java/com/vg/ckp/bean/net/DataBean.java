package com.vg.ckp.bean.net;



public class DataBean {

    @Override
    public String toString() {
        return "DataBean{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", nickname_code='" + nickname_code + '\'' +
                ", nickname='" + nickname + '\'' +
                ", is_ever=" + is_ever +
                ", end_time=" + end_time +
                ", is_end=" + is_end +
                ", token='" + token + '\'' +
                '}';
    }

    /**
         * uid : 359056
         * username : 12315284512
         * avatar : /assets/img/avatar.png
         * nickname_code : 8XLNIZ
         * nickname : 肝榷算
         * is_ever : 0
         * end_time : 1539253380
         * is_end : 1
         * token : 7aeb2ccf3994b2ccb3ff95987c24cf63
         */

        private int uid;
        private String username;
        private String avatar;
        private String nickname_code;
        private String nickname;
        private int is_ever;
        private int end_time;
        private int is_end;
        private String token;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickname_code() {
            return nickname_code;
        }

        public void setNickname_code(String nickname_code) {
            this.nickname_code = nickname_code;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getIs_ever() {
            return is_ever;
        }

        public void setIs_ever(int is_ever) {
            this.is_ever = is_ever;
        }

        public int getEnd_time() {
            return end_time;
        }

        public void setEnd_time(int end_time) {
            this.end_time = end_time;
        }

        public int getIs_end() {
            return is_end;
        }

        public void setIs_end(int is_end) {
            this.is_end = is_end;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

}
