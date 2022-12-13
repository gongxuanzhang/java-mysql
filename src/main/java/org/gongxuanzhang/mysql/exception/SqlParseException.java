package org.gongxuanzhang.mysql.exception;

/**
 * 解析Sql错误
 *
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class SqlParseException extends MySQLException {

    public SqlParseException(String message) {
        super(message);
    }
}
