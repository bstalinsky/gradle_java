package api.model;

public class UnSucessReg {

    private String error;

    public UnSucessReg(String error) {
        this.error = error;
    }

    public UnSucessReg() {
    }

    public String getError() {
        return error;
    }
}
