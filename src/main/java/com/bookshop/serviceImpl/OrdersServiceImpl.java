package com.bookshop.serviceImpl;import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookshop.service.OrdersService;
import com.bookshop.modle.Orders;
import com.bookshop.modle.OrdersExample;
import com.bookshop.dao.OrdersMapper;
import com.github.pagehelper.PageHelper;


public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersMapper dao;
    @Override
    public int countByExample(OrdersExample example){
        return (int)dao.countByExample(example);
    }

    public int deleteByExample(OrdersExample example){
        return dao.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return (int)dao.deleteByPrimaryKey(id);
    }

    public int insert(Orders record)  {
        return dao.insert(record);
    }

    public int insertSelective(Orders record)  {
        return dao.insertSelective(record);
    }

    public List<Orders> selectByExample(OrdersExample example)  {
        return dao.selectByExample(example);
    }

    public Orders selectByPrimaryKey(String id)  {
        return dao.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example)  {
        return dao.updateByExampleSelective(record, example);
    }

    public int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example)  {
        return dao.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(Orders record)  {
        return dao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Orders record)  {
        return dao.updateByPrimaryKey(record);
    }

    public Orders createOrders(Map<String, String>req) {
        String oId = req.get("oId");
        String oNum = req.get("oNum");
        String oPrice = req.get("oPrice");
        String oTime = req.get("oTime");
        String uAccount = req.get("uAccount");
        String uAddress = req.get("uAddress");
        String oPhone = req.get("oPhone");
        String uReceiver = req.get("uReceiver");
        String oCheaper = req.get("oCheaper");
        Orders orders = new Orders();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isNotEmpty(oId)) {
            orders.setoId(oId);
        }
        if (StringUtils.isNotEmpty(oNum)) {
            orders.setoNum(Integer.parseInt(oNum));
        }
        if(StringUtils.isNotEmpty(oPrice)) {
        	orders.setoPrice(Float.valueOf(oPrice));
        }
        try{
            if (StringUtils.isNotEmpty(oTime)) {
                orders.setoTime(sdf.parse(oTime)); 
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotEmpty(uAccount)) {
            orders.setuAccount(uAccount);
        }
        if (StringUtils.isNotEmpty(uAddress)) {
            orders.setuAddress(uAddress);
        }
        if (StringUtils.isNotEmpty(oPhone)) {
            orders.setoPhone(oPhone);
        }
        if (StringUtils.isNotEmpty(uReceiver)) {
            orders.setuReceiver(uReceiver);
        }
        if(StringUtils.isNotEmpty(oCheaper)) {
        	orders.setoCheaper(Float.parseFloat(oCheaper));
        }
        return orders;
    }

    public OrdersExample createOrdersExm(Map<String, String>req){
        String oId = req.get("oId");
        String oNum = req.get("oNum");
        String oPrice = req.get("oPrice");
        String oTimeStart = req.get("oTimeStart");
        String oTimeEnd = req.get("oTimeEnd");
        String uAccount = req.get("uAccount");
        String uAddress = req.get("uAddress");
        String oPhone = req.get("oPhone");
        String uReceiver = req.get("uReceiver");
        String oCheaper = req.get("oCheaper");
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isNotEmpty(oId)) {
            criteria.andOIdEqualTo(oId);
        }
        if (StringUtils.isNotEmpty(oNum)) {
            criteria.andONumEqualTo(Integer.parseInt(oNum));
        }
        try{
            if (StringUtils.isNotEmpty(oTimeStart) && StringUtils.isNotEmpty(oTimeEnd)) {
                criteria.andOTimeBetween(sdf.parse(oTimeStart),sdf.parse(oTimeEnd));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotEmpty(uAccount)) {
            criteria.andUAccountEqualTo(uAccount);
        }
        if (StringUtils.isNotEmpty(uAddress)) {
            criteria.andUAddressEqualTo(uAddress);
        }
        if (StringUtils.isNotEmpty(oPhone)) {
            criteria.andOPhoneEqualTo(oPhone);
        }
        if (StringUtils.isNotEmpty(uReceiver)) {
            criteria.andUReceiverEqualTo(uReceiver);
        }
        return example;
    }

    public List<Orders> selectByExample(OrdersExample example, int pageNum, int pageSize)  {
        PageHelper.startPage(pageNum, pageSize);
        return dao.selectByExample(example);
    }
}