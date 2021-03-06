package com.jfinal.ext.codeonline.metadata.impl.db;

import com.google.common.collect.Lists;
import com.jfinal.ext.codeonline.metadata.IDbInfoProvider;
import com.jfinal.ext.codeonline.metadata.impl.db.model.DbInfo;
import com.jfinal.plugin.activerecord.Db;

import java.util.List;

public class DbDbInfoProvider implements IDbInfoProvider {

    @Override
    public String findDriver(String dbType) {
        return Db.queryStr("select driverClass from db_info where type =?", dbType);
    }

    @Override
    public List<String> dbTypes() {
        List<String> result = Lists.newArrayList();
        List<DbInfo> dbInfos = DbInfo.DAO.findAll();
        for (DbInfo dbInfo : dbInfos) {
            result.add(dbInfo.getStr("type"));
        }
        return result;
    }
}
