package cn.upsoftinc.common;


import lombok.Data;

@Data
public class  Result {

    public static final Result TURE = new Result(1);
    public static final Result FALSE = new Result(0);

    public Result() {

    }

    public Result(int code) {
        this.code = code;
    }

    private int code;
    private String message;
}
