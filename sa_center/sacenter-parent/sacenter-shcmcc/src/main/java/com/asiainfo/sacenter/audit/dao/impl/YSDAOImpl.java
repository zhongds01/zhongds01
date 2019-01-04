package com.asiainfo.sacenter.audit.dao.impl;

import com.asiainfo.sacenter.audit.bo.BOYSEngine;
import com.asiainfo.sacenter.audit.dao.interfaces.IYSDAO;
import com.asiainfo.sacenter.audit.ivalues.IBOYSValue;

import java.util.HashMap;

/**
 * Created by jacky on 2017/8/30.
 */
public class YSDAOImpl implements IYSDAO {
    public IBOYSValue[] queryByActionId(long actionId) throws Exception {
        StringBuilder condition = new StringBuilder(" 1=1 ");
        condition.append(" AND ACTION_ID=:ACTION_ID  ");
        HashMap parameter = new HashMap();
        parameter.put(IBOYSValue.S_ActionId, actionId);
        return BOYSEngine.getBeans(condition.toString(), parameter);
    }

    public IBOYSValue[] getAllActions() throws Exception {
        StringBuilder condition = new StringBuilder(" 1=1 ");
        HashMap parameter = new HashMap();
        return BOYSEngine.getBeans(condition.toString(), parameter);
    }
}
