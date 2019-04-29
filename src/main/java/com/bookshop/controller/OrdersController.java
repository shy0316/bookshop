package com.bookshop.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bookshop.modle.OrdersExample;
import com.github.pagehelper.PageInfo;


    OrdersService ordersSV;

    @RequestMapping(value="/ordersQry")
    public Map ordersQry(
             @RequestParam(name="oId",required=false)String oId,
             @RequestParam(name="oNum",required=false)String oNum,
             @RequestParam(name="oPrice",required=false)String oPrice,
             @RequestParam(name="oTimeStart",required=false)String oTimeStart,
             @RequestParam(name="oTimeEnd",required=false)String oTimeEnd,
             @RequestParam(name="uAccount",required=false)String uAccount,
             @RequestParam(name="uAddress",required=false)String uAddress,
             @RequestParam(name="oPhone",required=false)String oPhone,
             @RequestParam(name="uReceiver",required=false)String uReceiver,
             @RequestParam(name="oCheaper",required=false)String oCheaper,
             @RequestParam(name="page",required=false)String page,@RequestParam(name="limit",required=false)String limit){
        List<Map> mapList = new ArrayList<>();
        int pageNum =  page == null ? 1 : Integer.parseInt(page);
        int pageSize =  limit == null ? 10 : Integer.parseInt(limit);
        Map<String, String> ordersExmMap = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ordersExmMap.put("oId", oId);
        ordersExmMap.put("oNum", oNum);
        ordersExmMap.put("oPrice", oPrice);
        ordersExmMap.put("oTimeStart", oTimeStart);
        ordersExmMap.put("oTimeEnd", oTimeEnd);
        //ordersExmMap.put("uAccount", uAccount);
        ordersExmMap.put("uAddress", uAddress);
        ordersExmMap.put("oPhone", oPhone);
        ordersExmMap.put("uReceiver", uReceiver);
        ordersExmMap.put("oCheaper", oCheaper);
        OrdersExample example = ordersSV.createOrdersExm(ordersExmMap);
        List<Orders> ordersList = ordersSV.selectByExample(example,pageNum,pageSize);
        int total = ordersSV.countByExample(example);
            Map<String,Object> tMap = new HashMap<>();
            tMap.put("oId", orders.getoId());
            if(orders.getoNum()!=null){
                tMap.put("oNum", orders.getoNum().toString());
            }
            if(orders.getoPrice()!=null){
                tMap.put("oPrice", orders.getoPrice().toString());
            }
            if(orders.getoTime()!=null){
                tMap.put("oTime", sdf.format(orders.getoTime()));
            }
            tMap.put("uAccount", orders.getuAccount());
            tMap.put("uAddress", orders.getuAddress());
            tMap.put("oPhone", orders.getoPhone());
            tMap.put("uReceiver", orders.getuReceiver());
            if(orders.getoCheaper()!=null){
                tMap.put("oCheaper", orders.getoCheaper().toString());
            }
        }
       return resultMap;
    }

    public String addOrders(@RequestBody Map<String, Object>req){
            //判断非空字段是否为空以及设置创建时间
            if(StringUtils.isEmpty(id)){
                id = StringUtil.seqGenerate().toString();
                orders.setoId(id);
            if (ordersSV.insert(orders) == 1) {
            }else {
                return "addOrderError";
            }
        } catch (Exception e) {
            return "error";
        }
    }

    public String updateOrders(@RequestBody Map<String, String>req){
        String id = req.get("oId");
        try {
            if(StringUtils.isEmpty(id)){
                return "oIdNull";
            }
           
            Orders orders = ordersSV.createOrders(req);
            if (ordersSV.updateByPrimaryKeySelective(orders) == 1) {
                return "success";
            }else {
               return "error";
            }
        } catch (Exception e) {
            return "error";
        }
    }

    public String deleteOrders(@RequestBody Map<String, Object>req){
        List<String> idList = (List<String>) req.get("ids");
        String strSuc = "";
        String strFail = "";
        String strNotExist = "";      
            if (idList.size() != 0 && idList != null) {
                for (int i = 0; i < idList.size(); i++) {
                    String id = idList.get(i);
                    if (ordersSV.selectByPrimaryKey(id) != null) {
                        if (ordersSV.deleteByPrimaryKey(id) == 1) {
                            strSuc += (id + " ");
                        } else {
                            strFail += (id + " ");
                        }
                    } else {
                       strNotExist += (id + " ");                   
                if (strNotExist.equals("") && strFail.equals("")) {
                    return strSuc + "delete success";
                } else {
                    return strFail + strNotExist + "delete error";
                }
            } else {
                return "idsNull";
            }
        } catch (Exception e) {
            return "error";
        }
    }
}