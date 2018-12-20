package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.*;
import com.pinyougou.pojo.*;
import com.pinyougou.sellergoods.service.GoodsService;
import com.pinyougou.service.impl.BaseServiceImpl;
import com.pinyougou.vo.Goods;
import com.pinyougou.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service(interfaceClass = GoodsService.class)
public class GoodsServiceImpl extends BaseServiceImpl<TbGoods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsDescMapper goodsDescMapper;

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public PageResult search(Integer page, Integer rows, TbGoods goods) {
        PageHelper.startPage(page, rows);

        Example example = new Example(TbGoods.class);
        Example.Criteria criteria = example.createCriteria();
        /*if(!StringUtils.isEmpty(goods.get***())){
            criteria.andLike("***", "%" + goods.get***() + "%");
        }*/

        List<TbGoods> list = goodsMapper.selectByExample(example);
        PageInfo<TbGoods> pageInfo = new PageInfo<>(list);

        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public void addGoods(Goods goods) {
        goodsMapper.insertSelective(goods.getGoods());
        goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());
        goodsDescMapper.insertSelective(goods.getGoodsDesc());

        //新增商品SKU
        for (TbItem item: goods.getItemList() ) {
            String title = goods.getGoods().getGoodsName();
            Map<String,Object> map = JSON.parseObject(item.getSpec());

            Set<Map.Entry<String,Object>> entries = map.entrySet();
            for (Map.Entry<String,Object> entry : entries){
                title += " " + entry.getValue().toString();
            }

            item.setTitle(title);

            List<Map> imgList = JSONArray.parseArray(goods.getGoodsDesc().getItemImages(), Map.class);

            if (imgList != null && imgList.size() > 0){
                item.setImage(imgList.get(0).get("url").toString());
            }

            item.setCategoryid(goods.getGoods().getCategory3Id());
            TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(goods.getGoods().getCategory3Id());
            item.setCategory(itemCat.getName());

            //创建时间
            item.setCreateTime(new Date());
            //更新时间
            item.setUpdateTime(item.getCreateTime());
            //SPU商品id
            item.setGoodsId(goods.getGoods().getId());
            //商品id
            item.setSellerId(goods.getGoods().getSellerId());
            //商家名称
            TbSeller seller = sellerMapper.selectByPrimaryKey(goods.getGoods().getSellerId());
            item.setSeller(seller.getName());
            //品牌名称
            TbBrand brand = brandMapper.selectByPrimaryKey(goods.getGoods().getBrandId());
            item.setBrand(brand.getName());

            itemMapper.insertSelective(item);

        }
    }
}
