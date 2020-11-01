package com.zyq.movehome.common;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 9:09
 */
public interface HomeEnums {

    //枚举

    enum Status {
        YES("0", "可用"),
        NO("1", "不可用");

        private String code;
        private String message;

        Status(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

    //角色
    enum Role {
        ADNIM("1", "管理员"),

        SERVICE("2", "提供服务"),

        SERVICEED("3", "需要服务"),
        ;

        private String code;
        private String message;

        Role(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

    //申请类型
    enum applytype {
        YAOQING("0", "邀请"),

        SHENGQING("1", "申请"),

        ;

        private String code;
        private String message;

        applytype(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

    //申请内容
    enum apply {
        YAOQING("0", "团队邀请您加入"),

        SHENGQING("1", "申请加入您的团队"),

        ;

        private String code;
        private String message;

        apply(String code, String message) {
            this.code = code;
            this.message = message;
        }
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
        //申请类型
//        enum applytype {
//            YAOQING("0", "邀请"),
//
//            SHENGQING("1", "申请"),
//
//            ;
//
//            private String code;
//            private String message;
//
//            applytype(String code, String message) {
//                this.code = code;
//                this.message = message;
//            }
//
//            public String getCode() {
//                return code;
//            }
//
//            public void setCode(String code) {
//                this.code = code;
//            }
//
//            public String getMessage() {
//                return message;
//            }
//
//            public void setMessage(String message) {
//                this.message = message;
//            }
//
//        }

        //申请内容
        enum pingluntype {
            PINGLUN("1", "评论"),

            HUIFU("2", "回复"),

            ;

            private String code;
            private String message;

            pingluntype(String code, String message) {
                this.code = code;
                this.message = message;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

        }
    }



