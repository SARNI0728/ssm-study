package com.sarni.spring01ioc.dao;

import com.sarni.spring01ioc.datasource.MyDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderDAO {
    MyDataSource myDataSource;

    public OrderDAO(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }
}
