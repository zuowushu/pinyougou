package com.pinyougou.service.impl;

import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * BaseServiceImpl class
 *
 * @Author: lonelywind
 * @Date: 2018/12/11 0:12
 */
public class BaseServiceImpl<T> implements BaseService<T> {
    @Override
    public T findOne(Serializable id) {
        return null;
    }

    @Override
    public List<T> finAll() {
        return null;
    }

    @Override
    public List<T> findByWhere(T t) {
        return null;
    }

    @Override
    public PageResult findPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public PageResult findPage(Integer page, Integer rows, T t) {
        return null;
    }

    @Override
    public void add(T t) {

    }

    @Override
    public void update(T t) {

    }

    @Override
    public void deleteByIds(Serializable[] ids) {

    }
}
