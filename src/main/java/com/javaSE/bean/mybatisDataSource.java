package com.javaSE.bean;

import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class mybatisDataSource implements DataSourceFactory {
    @Override
    public void setProperties(Properties props) {

    }

    @Override
    public DataSource getDataSource() {
        return null;
    }
}
