package com.bookshop.service;import com.bookshop.modle.Books;
import com.bookshop.modle.BooksExample;

import java.util.Map;
import org.apache.ibatis.annotations.Param;

    public int countByExample(BooksExample example);













    
    public List<Books> getNewsetBook(int count);
    
    public List<Books> getdiscountBook(int count);
    
    public List<Books> getdiscountBookWithLimit(int count);
    
    public List<Books> getBestSaleBook(int count);
    
    public List<Books> getBookByConditions(String category,String saleNum,String discount,String newset,String price,Float lowestPrice,Float highestPrice);

    public int updateBSaleNum(int bSaleNum,String bId);