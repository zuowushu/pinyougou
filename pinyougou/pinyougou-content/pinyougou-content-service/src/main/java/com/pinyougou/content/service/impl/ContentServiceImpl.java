package com.pinyougou.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.ContentMapper;
import com.pinyougou.pojo.TbContent;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.service.impl.BaseServiceImpl;
import com.pinyougou.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(interfaceClass = ContentService.class)
public class ContentServiceImpl extends BaseServiceImpl<TbContent> implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Override
    public PageResult search(Integer page, Integer rows, TbContent content) {
        PageHelper.startPage(page, rows);

        Example example = new Example(TbContent.class);
        Example.Criteria criteria = example.createCriteria();
        /*if(!StringUtils.isEmpty(content.get***())){
            criteria.andLike("***", "%" + content.get***() + "%");
        }*/

        List<TbContent> list = contentMapper.selectByExample(example);
        PageInfo<TbContent> pageInfo = new PageInfo<>(list);

        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public List<TbContent> findContentListByCategoryId(Long categoryId) {
        Example example = new Example(TbContent.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId","1");
        example.orderBy("sortOrder").desc();

        List<TbContent> list = contentMapper.selectByExample(example);
        return list;
    }
}
