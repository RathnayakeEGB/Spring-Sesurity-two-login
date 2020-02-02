package lk.sesurity.models;

public class ResponseJwt {

    private String jwt;

    private String userName;

    public ResponseJwt() {

    }

    public ResponseJwt(String jwt, String userName) {
        this.jwt = jwt;
        this.userName = userName;
    }


    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ResponseJwt{" +
                "jwt='" + jwt + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
