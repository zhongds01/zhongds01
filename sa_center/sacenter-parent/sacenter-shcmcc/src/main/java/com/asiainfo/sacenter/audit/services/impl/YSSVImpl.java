package com.asiainfo.sacenter.audit.services.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sacenter.audit.dao.interfaces.IYSDAO;
import com.asiainfo.sacenter.audit.services.interfaces.IYSSV;
import com.asiainfo.sacenter.audit.ivalues.IBOYSValue;

/**
 * Created by jacky on 2017/8/30.
 */
public class YSSVImpl implements IYSSV {
    public IBOYSValue[] queryByActionId(long actionId) throws Exception {
        IYSDAO iysdao = (IYSDAO) ServiceFactory.getService(IYSDAO.class);
        IBOYSValue[] iboysValues= iysdao.queryByActionId(actionId);
        return iboysValues;
    }

    public IBOYSValue[] getAllActions() throws Exception {
        IYSDAO iysdao = (IYSDAO) ServiceFactory.getService(IYSDAO.class);
        IBOYSValue[] iboysValues= iysdao.getAllActions();
        return iboysValues;
    }
}
