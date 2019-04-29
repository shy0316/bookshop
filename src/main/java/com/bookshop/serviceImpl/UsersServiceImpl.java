package com.bookshop.serviceImpl;import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookshop.service.UsersService;
import com.bookshop.modle.Users;
import com.bookshop.modle.UsersExample;
import com.bookshop.dao.UsersMapper;
import com.github.pagehelper.PageHelper;



public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper dao;
    @Override
    public int countByExample(UsersExample example){
        return (int)dao.countByExample(example);
    }

    public int deleteByExample(UsersExample example){
        return dao.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id){
        return (int)dao.deleteByPrimaryKey(id);
    }

    public int insert(Users record)  {
        return dao.insert(record);
    }

    public int insertSelective(Users record)  {
        return dao.insertSelective(record);
    }

    public List<Users> selectByExample(UsersExample example)  {
        return dao.selectByExample(example);
    }

    public Users selectByPrimaryKey(String id)  {
        return dao.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example)  {
        return dao.updateByExampleSelective(record, example);
    }

    public int updateByExample(@Param("record") Users record, @Param("example") UsersExample example)  {
        return dao.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(Users record)  {
        return dao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Users record)  {
        return dao.updateByPrimaryKey(record);
    }

    public Users createUsers(Map<String, String>req) {
        String uAccount = req.get("uAccount");
        String uName = req.get("uName");
        String uPassword = req.get("uPassword");
        String uPhone = req.get("uPhone");
        String uMail = req.get("uMail");
        String uRole = req.get("uRole");
        Users users = new Users();
        if (StringUtils.isNotEmpty(uAccount)) {
            users.setuAccount(uAccount);
        }
        if (StringUtils.isNotEmpty(uName)) {
            users.setuName(uName);
        }
        if (StringUtils.isNotEmpty(uPassword)) {
            users.setuPassword(uPassword);
        }
        if (StringUtils.isNotEmpty(uPhone)) {
            users.setuPhone(uPhone);
        }
        if (StringUtils.isNotEmpty(uMail)) {
            users.setuMail(uMail);
        }
        if (StringUtils.isNotEmpty(uRole)) {
            users.setuRole(uRole);
        }
        return users;
    }

    public UsersExample createUsersExm(Map<String, String>req){
        String uAccount = req.get("uAccount");
        String uName = req.get("uName");
        String uPassword = req.get("uPassword");
        String uPhone = req.get("uPhone");
        String uMail = req.get("uMail");
        String uRole = req.get("uRole");
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isNotEmpty(uAccount)) {
            criteria.andUAccountEqualTo(uAccount);
        }
        if (StringUtils.isNotEmpty(uName)) {
            criteria.andUNameLike("%"+uName+"%");
        }
        if (StringUtils.isNotEmpty(uPassword)) {
            criteria.andUPasswordEqualTo(uPassword);
        }
        if (StringUtils.isNotEmpty(uPhone)) {
            criteria.andUPhoneEqualTo(uPhone);
        }
        if (StringUtils.isNotEmpty(uMail)) {
            criteria.andUMailEqualTo(uMail);
        }
        if (StringUtils.isNotEmpty(uRole)) {
            criteria.andURoleEqualTo(uRole);
        }
        return example;
    }

    public List<Users> selectByExample(UsersExample example, int pageNum, int pageSize)  {
        PageHelper.startPage(pageNum, pageSize);
        return dao.selectByExample(example);
    }
}