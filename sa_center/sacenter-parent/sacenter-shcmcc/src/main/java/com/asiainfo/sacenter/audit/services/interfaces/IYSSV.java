package com.asiainfo.sacenter.audit.services.interfaces;

import com.asiainfo.sacenter.audit.ivalues.IBOYSValue;

/**
 * Created by jacky on 2017/8/30.
 */
public interface IYSSV {
    public IBOYSValue[] queryByActionId(long actionId) throws Exception;

    public IBOYSValue[] getAllActions() throws Exception ;

}
