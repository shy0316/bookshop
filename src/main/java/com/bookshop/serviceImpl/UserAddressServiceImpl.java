package com.bookshop.serviceImpl;import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookshop.service.UserAddressService;
import com.bookshop.modle.UserAddress;
import com.bookshop.modle.UserAddressExample;
import com.bookshop.dao.UserAddressMapper;
import com.github.pagehelper.PageHelper;


public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    UserAddressMapper dao;
    @Override
    public int countByExample(UserAddressExample example){
        return (int)dao.countByExample(example);
    }

    public int deleteByExample(UserAddressExample example){
        return dao.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return (int)dao.deleteByPrimaryKey(id);
    }

    public int insert(UserAddress record)  {
        return dao.insert(record);
    }

    public int insertSelective(UserAddress record)  {
        return dao.insertSelective(record);
    }

    public List<UserAddress> selectByExample(UserAddressExample example)  {
        return dao.selectByExample(example);
    }

    public UserAddress selectByPrimaryKey(String id)  {
        return dao.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(@Param("record") UserAddress record, @Param("example") UserAddressExample example)  {
        return dao.updateByExampleSelective(record, example);
    }

    public int updateByExample(@Param("record") UserAddress record, @Param("example") UserAddressExample example)  {
        return dao.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(UserAddress record)  {
        return dao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserAddress record)  {
        return dao.updateByPrimaryKey(record);
    }

    public UserAddress createUserAddress(Map<String, String>req) {
        String uaddrId = req.get("uaddrId");
        String uAccount = req.get("uAccount");
        String uAddress = req.get("uAddress");
        String oPhone = req.get("oPhone");
        String uIsdefault = req.get("uIsdefault");
        String oReceiver = req.get("oReceiver");
        UserAddress userAddress = new UserAddress();
        if (StringUtils.isNotEmpty(uaddrId)) {
            userAddress.setUaddrId(uaddrId);
        }
        if (StringUtils.isNotEmpty(uAccount)) {
            userAddress.setuAccount(uAccount);
        }
        if (StringUtils.isNotEmpty(uAddress)) {
            userAddress.setuAddress(uAddress);
        }
        if (StringUtils.isNotEmpty(oPhone)) {
            userAddress.setoPhone(oPhone);
        }
        if (StringUtils.isNotEmpty(uIsdefault)) {
            userAddress.setuIsdefault(Integer.parseInt(uIsdefault));
        }
        if (StringUtils.isNotEmpty(oReceiver)) {
            userAddress.setoReceiver(oReceiver);
        }
        return userAddress;
    }

    public UserAddressExample createUserAddressExm(Map<String, String>req){
        String uaddrId = req.get("uaddrId");
        String uAccount = req.get("uAccount");
        String uAddress = req.get("uAddress");
        String oPhone = req.get("oPhone");
        String uIsdefault = req.get("uIsdefault");
        String oReceiver = req.get("oReceiver");
        UserAddressExample example = new UserAddressExample();
        UserAddressExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isNotEmpty(uaddrId)) {
            criteria.andUaddrIdEqualTo(uaddrId);
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
        if (StringUtils.isNotEmpty(uIsdefault)) {
            criteria.andUIsdefaultEqualTo(Integer.parseInt(uIsdefault));
        }
        if (StringUtils.isNotEmpty(oReceiver)) {
            criteria.andOReceiverEqualTo(oReceiver);
        }
        return example;
    }

    public List<UserAddress> selectByExample(UserAddressExample example, int pageNum, int pageSize)  {
        PageHelper.startPage(pageNum, pageSize);
        return dao.selectByExample(example);
    }
}