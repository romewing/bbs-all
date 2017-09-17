package cn.upsoftinc.common;

import lombok.Data;

import java.util.List;

@Data
public class ListResult<T> extends DataResult<List<T>> {

    private int total;

    public List<T> getList() {
        return getData();
    }
}
