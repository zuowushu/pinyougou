package com.pinyougou.vo;

import java.io.Serializable;
import java.util.List;

/**
 * PageResult class
 *
 * @Author: lonelywind
 * @Date: 2018/12/11 0:02
 */
public class PageResult implements Serializable {
    private long total;
    private List<?> rows;

    public PageResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
