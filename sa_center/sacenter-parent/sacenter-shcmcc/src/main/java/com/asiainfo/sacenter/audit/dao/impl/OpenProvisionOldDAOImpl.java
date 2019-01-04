package com.asiainfo.sacenter.audit.dao.impl;

import com.asiainfo.sacenter.audit.bo.BOIOPENPROVISIONOLDEngine;
import com.asiainfo.sacenter.audit.dao.interfaces.IOpenProvisionOldDAO;
import com.asiainfo.sacenter.audit.ivalues.IBOIOPENPROVISIONOLDValue;

import java.util.HashMap;

/**
 * Created by jacky on 2017/8/29.
 */
public class OpenProvisionOldDAOImpl implements IOpenProvisionOldDAO {
    public IBOIOPENPROVISIONOLDValue[] queryByDoneCode(String doneCode) throws Exception {
        StringBuilder condition = new StringBuilder(" 1=1 ");
        condition.append(" AND DONE_CODE=:DONE_CODE  ");
        HashMap parameter = new HashMap();
        parameter.put(IBOIOPENPROVISIONOLDValue.S_DoneCode, doneCode);
        return BOIOPENPROVISIONOLDEngine.getBeans(condition.toString(), parameter);
    }
}
