package com.pinyougou.service;

import com.pinyougou.vo.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService interface
 *
 * @Author: lonelywind
 * @Date: 2018/12/10 23:53
 */
public interface BaseService<T> {

    /**
     * 根据主键查询
     *
     * @param id
     * @return 实体类对象
     */
    public T findOne(Serializable id);

    /**
     * 查询全部
     *
     * @return 实体类对象集合
     */
    public List<T> findAll();

    /**
     * 根据条件查询列表
     *
     * @param t 查询条件对象
     * @return
     */
    public List<T> findByWhere(T t);


    /**
     * 根据分页信息查询
     *
     * @param page 页号
     * @param rows 页大小
     * @return 分页实体类对象
     */
    public PageResult findPage(Integer page, Integer rows);

    /**
     * 根据分页条件查询
     *
     * @param page 页号
     * @param rows 页大小
     * @param t 查询条件对象
     * @return 分页实体类对象
     */
    public PageResult findPage(Integer page,Integer rows,T t);

    /**
     * 新增
     * @param t 实体对象
     */
    public void add(T t);

    /**
     * 根据主键更新
     * @param t 实体对象
     */
    public void update(T t);

    /**
     * 批量删除
     * @param ids
     */
    public void deleteByIds(Serializable[] ids);


}
