package jiyun.com.myapplication;

import java.util.List;

/**
 * Created by Windows on 2019/7/29.
 */

public class BeanWord {

    /**
     * status : 0
     * content : {"ph_en":"bɔɪ","ph_am":"bɔɪ","ph_en_mp3":"http://res.iciba.com/resource/amp3/oxford/0/86/95/8695d6ad90bffe5e66eabe5c3e6cb359.mp3","ph_am_mp3":"http://res.iciba.com/resource/amp3/1/0/1a/69/1a699ad5e06aa8a6db3bcf9cfb2f00f2.mp3","ph_tts_mp3":"http://res-tts.iciba.com/1/a/6/1a699ad5e06aa8a6db3bcf9cfb2f00f2.mp3","word_mean":["n. 男孩，少年;儿子;小伙子，家伙;服务员;"]}
     */

    private int status;
    private ContentBean content;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * ph_en : bɔɪ
         * ph_am : bɔɪ
         * ph_en_mp3 : http://res.iciba.com/resource/amp3/oxford/0/86/95/8695d6ad90bffe5e66eabe5c3e6cb359.mp3
         * ph_am_mp3 : http://res.iciba.com/resource/amp3/1/0/1a/69/1a699ad5e06aa8a6db3bcf9cfb2f00f2.mp3
         * ph_tts_mp3 : http://res-tts.iciba.com/1/a/6/1a699ad5e06aa8a6db3bcf9cfb2f00f2.mp3
         * word_mean : ["n. 男孩，少年;儿子;小伙子，家伙;服务员;"]
         */

        private String ph_en;
        private String ph_am;
        private String ph_en_mp3;
        private String ph_am_mp3;
        private String ph_tts_mp3;
        private List<String> word_mean;

        public String getPh_en() {
            return ph_en;
        }

        public void setPh_en(String ph_en) {
            this.ph_en = ph_en;
        }

        public String getPh_am() {
            return ph_am;
        }

        public void setPh_am(String ph_am) {
            this.ph_am = ph_am;
        }

        public String getPh_en_mp3() {
            return ph_en_mp3;
        }

        public void setPh_en_mp3(String ph_en_mp3) {
            this.ph_en_mp3 = ph_en_mp3;
        }

        public String getPh_am_mp3() {
            return ph_am_mp3;
        }

        public void setPh_am_mp3(String ph_am_mp3) {
            this.ph_am_mp3 = ph_am_mp3;
        }

        public String getPh_tts_mp3() {
            return ph_tts_mp3;
        }

        public void setPh_tts_mp3(String ph_tts_mp3) {
            this.ph_tts_mp3 = ph_tts_mp3;
        }

        public List<String> getWord_mean() {
            return word_mean;
        }

        public void setWord_mean(List<String> word_mean) {
            this.word_mean = word_mean;
        }
    }
}
