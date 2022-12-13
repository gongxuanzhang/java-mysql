package org.gongxuanzhang.mysql.service.executor;

import lombok.extern.slf4j.Slf4j;
import org.gongxuanzhang.mysql.core.PropertiesConstant;
import org.gongxuanzhang.mysql.entity.DatabaseInfo;
import org.gongxuanzhang.mysql.entity.GlobalProperties;
import org.gongxuanzhang.mysql.exception.ExecuteException;
import org.gongxuanzhang.mysql.exception.SqlParseException;
import org.gongxuanzhang.mysql.service.Result;

import java.io.File;

/**
 * 建数据库执行器
 *
 * @author gxz gongxuanzhang@foxmail.com
 **/
@Slf4j
public class DatabaseCreator extends AbstractInfoExecutor<DatabaseInfo> {


    public DatabaseCreator(String sql) throws SqlParseException {
        super(sql);
    }

    public DatabaseCreator(String[] split) throws SqlParseException {
        super(split);
    }

    @Override
    public DatabaseInfo analysisInfo(String[] split) throws SqlParseException {
        if (split.length > 4) {
            throw new SqlParseException(split[4] + "解析失败");
        }
        DatabaseInfo databaseInfo = new DatabaseInfo();
        databaseInfo.setDatabaseName(split[2]);
        return databaseInfo;
    }

    @Override
    public Result doExecute() {
        try {
            String dataDir = GlobalProperties.getInstance().get(PropertiesConstant.DATA_DIR);
            File db = new File(dataDir);
            String databaseName = getInfo().getDatabaseName();
            File file = new File(db, databaseName);
            if (file.exists()) {
                throw new ExecuteException("数据库" + databaseName + "已经存在");
            }
            file.mkdirs();
            log.info("创建数据库{}", databaseName);
        } catch (ExecuteException e) {
            e.printStackTrace();
            //  todo
            return null;
        }
        return null;
    }


}