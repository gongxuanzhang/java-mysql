package org.gongxuanzhang.mysql.core;

/**
 * ζεθΏε
 *
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class SuccessResult implements Result {


    private String sqlTime;


    @Override
    public int getCode() {
        return 100;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public String getSqlTime() {
        return sqlTime;
    }

    @Override
    public void setSqlTime(String sqlTime) {
        this.sqlTime = sqlTime;
    }

}
