package api.model;

public class SucessReg extends Register{

    private Integer id;
    private String token;
    public SucessReg(Integer id, String token) {
        super();
        this.id = id;
        this.token = token;
    }

    public SucessReg(){}

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
