package com.example.h_dj.recognizefacedemo;

import java.util.List;

/**
 * Created by H_DJ on 2017/4/18.
 */

public class FaceConfig {

    /**
     * result_num : 1
     * result : [{"location":{"left":88,"top":38,"width":55,"height":59},"face_probability":1,"rotation_angle":13,"yaw":-15.363721847534,"pitch":-1.8399250507355,"roll":9.26780128479,"landmark":[{"x":109,"y":55},{"x":132,"y":60},{"x":123,"y":72},{"x":116,"y":86}],"landmark72":[{"x":84,"y":52},{"x":82,"y":63},{"x":82,"y":73},{"x":85,"y":84},{"x":93,"y":95},{"x":102,"y":102},{"x":113,"y":105},{"x":121,"y":101},{"x":127,"y":93},{"x":131,"y":86},{"x":135,"y":79},{"x":137,"y":71},{"x":138,"y":63},{"x":102,"y":54},{"x":106,"y":52},{"x":110,"y":52},{"x":113,"y":54},{"x":114,"y":58},{"x":111,"y":58},{"x":108,"y":57},{"x":105,"y":56},{"x":109,"y":55},{"x":100,"y":45},{"x":105,"y":43},{"x":111,"y":43},{"x":115,"y":45},{"x":119,"y":49},{"x":115,"y":48},{"x":110,"y":46},{"x":105,"y":45},{"x":127,"y":61},{"x":130,"y":58},{"x":133,"y":58},{"x":135,"y":59},{"x":136,"y":62},{"x":135,"y":63},{"x":132,"y":63},{"x":129,"y":62},{"x":132,"y":60},{"x":128,"y":51},{"x":132,"y":49},{"x":135,"y":49},{"x":138,"y":50},{"x":139,"y":53},{"x":137,"y":52},{"x":135,"y":52},{"x":132,"y":52},{"x":118,"y":59},{"x":117,"y":64},{"x":116,"y":68},{"x":112,"y":74},{"x":117,"y":75},{"x":124,"y":77},{"x":126,"y":76},{"x":126,"y":70},{"x":126,"y":65},{"x":125,"y":60},{"x":123,"y":72},{"x":106,"y":83},{"x":113,"y":82},{"x":118,"y":83},{"x":122,"y":84},{"x":123,"y":88},{"x":120,"y":90},{"x":116,"y":90},{"x":111,"y":87},{"x":112,"y":85},{"x":117,"y":86},{"x":121,"y":87},{"x":120,"y":87},{"x":117,"y":86},{"x":112,"y":85}],"age":22.720384597778,"beauty":28.864500045776,"expression":0,"expression_probablity":0.76390594244003,"faceshape":[{"type":"square","probability":0.015609827823937},{"type":"triangle","probability":0.0070503568276763},{"type":"oval","probability":0.5149872303009},{"type":"heart","probability":0.21292947232723},{"type":"round","probability":0.24942310154438}],"gender":"female","gender_probability":0.99997067451477,"glasses":0,"glasses_probability":0.99999737739563,"race":"yellow","race_probability":0.99988162517548,"qualities":{"occlusion":{"left_eye":0,"right_eye":0,"nose":0,"mouth":0,"left_cheek":0,"right_cheek":0,"chin":0},"blur":0,"illumination":0,"completeness":0,"type":{"human":0.93309128284454,"cartoon":0.066908724606037}}}]
     * log_id : 3014508743
     */

    private int result_num;
    private long log_id;
    private List<ResultBean> result;

    public int getResult_num() {
        return result_num;
    }

    public void setResult_num(int result_num) {
        this.result_num = result_num;
    }

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * location : {"left":88,"top":38,"width":55,"height":59}
         * face_probability : 1
         * rotation_angle : 13
         * yaw : -15.363721847534
         * pitch : -1.8399250507355
         * roll : 9.26780128479
         * landmark : [{"x":109,"y":55},{"x":132,"y":60},{"x":123,"y":72},{"x":116,"y":86}]
         * landmark72 : [{"x":84,"y":52},{"x":82,"y":63},{"x":82,"y":73},{"x":85,"y":84},{"x":93,"y":95},{"x":102,"y":102},{"x":113,"y":105},{"x":121,"y":101},{"x":127,"y":93},{"x":131,"y":86},{"x":135,"y":79},{"x":137,"y":71},{"x":138,"y":63},{"x":102,"y":54},{"x":106,"y":52},{"x":110,"y":52},{"x":113,"y":54},{"x":114,"y":58},{"x":111,"y":58},{"x":108,"y":57},{"x":105,"y":56},{"x":109,"y":55},{"x":100,"y":45},{"x":105,"y":43},{"x":111,"y":43},{"x":115,"y":45},{"x":119,"y":49},{"x":115,"y":48},{"x":110,"y":46},{"x":105,"y":45},{"x":127,"y":61},{"x":130,"y":58},{"x":133,"y":58},{"x":135,"y":59},{"x":136,"y":62},{"x":135,"y":63},{"x":132,"y":63},{"x":129,"y":62},{"x":132,"y":60},{"x":128,"y":51},{"x":132,"y":49},{"x":135,"y":49},{"x":138,"y":50},{"x":139,"y":53},{"x":137,"y":52},{"x":135,"y":52},{"x":132,"y":52},{"x":118,"y":59},{"x":117,"y":64},{"x":116,"y":68},{"x":112,"y":74},{"x":117,"y":75},{"x":124,"y":77},{"x":126,"y":76},{"x":126,"y":70},{"x":126,"y":65},{"x":125,"y":60},{"x":123,"y":72},{"x":106,"y":83},{"x":113,"y":82},{"x":118,"y":83},{"x":122,"y":84},{"x":123,"y":88},{"x":120,"y":90},{"x":116,"y":90},{"x":111,"y":87},{"x":112,"y":85},{"x":117,"y":86},{"x":121,"y":87},{"x":120,"y":87},{"x":117,"y":86},{"x":112,"y":85}]
         * age : 22.720384597778
         * beauty : 28.864500045776
         * expression : 0
         * expression_probablity : 0.76390594244003
         * faceshape : [{"type":"square","probability":0.015609827823937},{"type":"triangle","probability":0.0070503568276763},{"type":"oval","probability":0.5149872303009},{"type":"heart","probability":0.21292947232723},{"type":"round","probability":0.24942310154438}]
         * gender : female
         * gender_probability : 0.99997067451477
         * glasses : 0
         * glasses_probability : 0.99999737739563
         * race : yellow
         * race_probability : 0.99988162517548
         * qualities : {"occlusion":{"left_eye":0,"right_eye":0,"nose":0,"mouth":0,"left_cheek":0,"right_cheek":0,"chin":0},"blur":0,"illumination":0,"completeness":0,"type":{"human":0.93309128284454,"cartoon":0.066908724606037}}
         */

        private LocationBean location;
        private int face_probability;
        private int rotation_angle;
        private double yaw;
        private double pitch;
        private double roll;
        private double age;
        private double beauty;
        private int expression;
        private double expression_probablity;
        private String gender;
        private double gender_probability;
        private int glasses;
        private double glasses_probability;
        private String race;
        private double race_probability;
        private QualitiesBean qualities;
        private List<LandmarkBean> landmark;
        private List<Landmark72Bean> landmark72;
        private List<FaceshapeBean> faceshape;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public int getFace_probability() {
            return face_probability;
        }

        public void setFace_probability(int face_probability) {
            this.face_probability = face_probability;
        }

        public int getRotation_angle() {
            return rotation_angle;
        }

        public void setRotation_angle(int rotation_angle) {
            this.rotation_angle = rotation_angle;
        }

        public double getYaw() {
            return yaw;
        }

        public void setYaw(double yaw) {
            this.yaw = yaw;
        }

        public double getPitch() {
            return pitch;
        }

        public void setPitch(double pitch) {
            this.pitch = pitch;
        }

        public double getRoll() {
            return roll;
        }

        public void setRoll(double roll) {
            this.roll = roll;
        }

        public double getAge() {
            return age;
        }

        public void setAge(double age) {
            this.age = age;
        }

        public double getBeauty() {
            return beauty;
        }

        public void setBeauty(double beauty) {
            this.beauty = beauty;
        }

        public int getExpression() {
            return expression;
        }

        public void setExpression(int expression) {
            this.expression = expression;
        }

        public double getExpression_probablity() {
            return expression_probablity;
        }

        public void setExpression_probablity(double expression_probablity) {
            this.expression_probablity = expression_probablity;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public double getGender_probability() {
            return gender_probability;
        }

        public void setGender_probability(double gender_probability) {
            this.gender_probability = gender_probability;
        }

        public int getGlasses() {
            return glasses;
        }

        public void setGlasses(int glasses) {
            this.glasses = glasses;
        }

        public double getGlasses_probability() {
            return glasses_probability;
        }

        public void setGlasses_probability(double glasses_probability) {
            this.glasses_probability = glasses_probability;
        }

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        public double getRace_probability() {
            return race_probability;
        }

        public void setRace_probability(double race_probability) {
            this.race_probability = race_probability;
        }

        public QualitiesBean getQualities() {
            return qualities;
        }

        public void setQualities(QualitiesBean qualities) {
            this.qualities = qualities;
        }

        public List<LandmarkBean> getLandmark() {
            return landmark;
        }

        public void setLandmark(List<LandmarkBean> landmark) {
            this.landmark = landmark;
        }

        public List<Landmark72Bean> getLandmark72() {
            return landmark72;
        }

        public void setLandmark72(List<Landmark72Bean> landmark72) {
            this.landmark72 = landmark72;
        }

        public List<FaceshapeBean> getFaceshape() {
            return faceshape;
        }

        public void setFaceshape(List<FaceshapeBean> faceshape) {
            this.faceshape = faceshape;
        }

        public static class LocationBean {
            /**
             * left : 88
             * top : 38
             * width : 55
             * height : 59
             */

            private int left;
            private int top;
            private int width;
            private int height;

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }

        public static class QualitiesBean {
            /**
             * occlusion : {"left_eye":0,"right_eye":0,"nose":0,"mouth":0,"left_cheek":0,"right_cheek":0,"chin":0}
             * blur : 0
             * illumination : 0
             * completeness : 0
             * type : {"human":0.93309128284454,"cartoon":0.066908724606037}
             */

            private OcclusionBean occlusion;
            private int blur;
            private int illumination;
            private int completeness;
            private TypeBean type;

            public OcclusionBean getOcclusion() {
                return occlusion;
            }

            public void setOcclusion(OcclusionBean occlusion) {
                this.occlusion = occlusion;
            }

            public int getBlur() {
                return blur;
            }

            public void setBlur(int blur) {
                this.blur = blur;
            }

            public int getIllumination() {
                return illumination;
            }

            public void setIllumination(int illumination) {
                this.illumination = illumination;
            }

            public int getCompleteness() {
                return completeness;
            }

            public void setCompleteness(int completeness) {
                this.completeness = completeness;
            }

            public TypeBean getType() {
                return type;
            }

            public void setType(TypeBean type) {
                this.type = type;
            }

            public static class OcclusionBean {
                /**
                 * left_eye : 0
                 * right_eye : 0
                 * nose : 0
                 * mouth : 0
                 * left_cheek : 0
                 * right_cheek : 0
                 * chin : 0
                 */

                private int left_eye;
                private int right_eye;
                private int nose;
                private int mouth;
                private int left_cheek;
                private int right_cheek;
                private int chin;

                public int getLeft_eye() {
                    return left_eye;
                }

                public void setLeft_eye(int left_eye) {
                    this.left_eye = left_eye;
                }

                public int getRight_eye() {
                    return right_eye;
                }

                public void setRight_eye(int right_eye) {
                    this.right_eye = right_eye;
                }

                public int getNose() {
                    return nose;
                }

                public void setNose(int nose) {
                    this.nose = nose;
                }

                public int getMouth() {
                    return mouth;
                }

                public void setMouth(int mouth) {
                    this.mouth = mouth;
                }

                public int getLeft_cheek() {
                    return left_cheek;
                }

                public void setLeft_cheek(int left_cheek) {
                    this.left_cheek = left_cheek;
                }

                public int getRight_cheek() {
                    return right_cheek;
                }

                public void setRight_cheek(int right_cheek) {
                    this.right_cheek = right_cheek;
                }

                public int getChin() {
                    return chin;
                }

                public void setChin(int chin) {
                    this.chin = chin;
                }
            }

            public static class TypeBean {
                /**
                 * human : 0.93309128284454
                 * cartoon : 0.066908724606037
                 */

                private double human;
                private double cartoon;

                public double getHuman() {
                    return human;
                }

                public void setHuman(double human) {
                    this.human = human;
                }

                public double getCartoon() {
                    return cartoon;
                }

                public void setCartoon(double cartoon) {
                    this.cartoon = cartoon;
                }
            }
        }

        public static class LandmarkBean {
            /**
             * x : 109
             * y : 55
             */

            private int x;
            private int y;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }
        }

        public static class Landmark72Bean {
            /**
             * x : 84
             * y : 52
             */

            private int x;
            private int y;

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }
        }

        public static class FaceshapeBean {
            /**
             * type : square
             * probability : 0.015609827823937
             */

            private String type;
            private double probability;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public double getProbability() {
                return probability;
            }

            public void setProbability(double probability) {
                this.probability = probability;
            }
        }
    }

}