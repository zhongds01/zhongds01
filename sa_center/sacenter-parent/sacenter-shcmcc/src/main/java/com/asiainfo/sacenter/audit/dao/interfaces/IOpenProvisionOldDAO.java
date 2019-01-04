package com.asiainfo.sacenter.audit.dao.interfaces;

import com.asiainfo.sacenter.audit.ivalues.IBOIOPENPROVISIONOLDValue;

/**
 * Created by jacky on 2017/8/29.
 */
public interface IOpenProvisionOldDAO {
    public IBOIOPENPROVISIONOLDValue[] queryByDoneCode(String doneCode) throws Exception;
}
