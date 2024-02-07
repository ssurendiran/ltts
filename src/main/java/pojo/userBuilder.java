package pojo;


    public  class userBuilder{
        public userBuilder setEmail(String email) {
            this.email = email;
            return this ;
        }

        private String email;

        public userBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        private String password;



        public userBuilder builder(){
            return this;
        }

        public  user build(){
            return new user(this.email,this.password);
        }

    }
