package com.jl.demo.spring.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;

/**
 * @author jerry chan
 * @date 2023/7/23 21:35
 */
public abstract class AbstractDataSourceConfig {

    protected DruidXADataSource createDruidXADataSource(String url, String username, String password) {
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        //<a href="https://github.com/alibaba/druid/wiki/DruidDataSource%E9%85%8D%E7%BD%AE%E5%B1%9E%E6%80%A7%E5%88%97%E8%A1%A8"/>
        druidXADataSource.setUrl(url);
        druidXADataSource.setUsername(username);
        druidXADataSource.setPassword(password);
        druidXADataSource.setMaxActive(5);
        druidXADataSource.setInitialSize(1);
        druidXADataSource.setMaxWait(15000);
        druidXADataSource.setMinIdle(1);
        druidXADataSource.setTestOnBorrow(false);
        druidXADataSource.setTestWhileIdle(true);
        druidXADataSource.setValidationQuery("select 1");
        druidXADataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidXADataSource.setMinEvictableIdleTimeMillis(300000);
        druidXADataSource.setAsyncInit(true);
        return druidXADataSource;
    }

}
