package org.gongxuanzhang.mysql.service.parser;

import lombok.extern.slf4j.Slf4j;
import org.gongxuanzhang.mysql.annotation.SQLParser;
import org.gongxuanzhang.mysql.exception.SqlParseException;
import org.gongxuanzhang.mysql.service.executor.DatabaseCreator;
import org.gongxuanzhang.mysql.service.executor.Executor;
import org.gongxuanzhang.mysql.service.executor.TableCreator;

/**
 * create 的解析器
 * 支持创建表，创建数据库
 *
 * @author gxz gongxuanzhang@foxmail.com
 **/
@Slf4j
@SQLParser
public class CreateParser implements DDLSqlParser {

    private static final String PREFIX = "create";


    @Override
    public Executor parse(String[] split) throws SqlParseException {
        if (split.length < 2) {
            throw new SqlParseException("语法错误，无法解析");
        }
        String action = split[1];
        switch (action.toLowerCase()) {
            case "database":
                return new DatabaseCreator(split);
            case "table":
                return new TableCreator(split);
            default:
                throw new SqlParseException(action + "不支持，你可以自定义功能来实现DDL");
        }
    }


    @Override
    public String prefix() {
        return PREFIX;
    }
}