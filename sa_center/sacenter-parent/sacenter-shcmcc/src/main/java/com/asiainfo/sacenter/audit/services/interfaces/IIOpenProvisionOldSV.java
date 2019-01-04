package com.asiainfo.sacenter.audit.services.interfaces;

import com.asiainfo.sacenter.audit.ivalues.IBOIOPENPROVISIONOLDValue;

/**
 * Created by jacky on 2017/8/29.
 */
public interface IIOpenProvisionOldSV {
    public IBOIOPENPROVISIONOLDValue[] queryByDoneCode(String doneCode) throws Exception;

}
