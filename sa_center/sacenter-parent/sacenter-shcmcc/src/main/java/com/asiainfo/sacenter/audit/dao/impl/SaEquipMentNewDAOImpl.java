package com.asiainfo.sacenter.audit.dao.impl;

import com.asiainfo.sacenter.audit.bo.BOISAEQUIPMENTNEWEngine;
import com.asiainfo.sacenter.audit.dao.interfaces.ISaEquipMentNewDAO;
import com.asiainfo.sacenter.audit.ivalues.IBOISAEQUIPMENTNEWValue;

import java.util.HashMap;

/**
 * Created by jacky on 2017/8/30.
 */
public class SaEquipMentNewDAOImpl implements ISaEquipMentNewDAO {
    public IBOISAEQUIPMENTNEWValue[] queryByDoneCode(String doneCode) throws Exception {
        StringBuilder condition = new StringBuilder(" 1=1 ");
        condition.append(" AND DONE_CODE=:DONE_CODE  ");
        HashMap parameter = new HashMap();
        parameter.put(IBOISAEQUIPMENTNEWValue.S_DoneCode, doneCode);
        return BOISAEQUIPMENTNEWEngine.getBeans(condition.toString(), parameter);
    }
}
