package cn.upsoftinc.common;


import lombok.Data;

@Data
public class DataResult<T> extends Result {

    private T data;
}
