package com.asiainfo.sacenter.audit.services.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sacenter.audit.dao.interfaces.IOpenProvisionOldDAO;
import com.asiainfo.sacenter.audit.ivalues.IBOIOPENPROVISIONOLDValue;
import com.asiainfo.sacenter.audit.services.interfaces.IIOpenProvisionOldSV;

/**
 * Created by jacky on 2017/8/29.
 */
public class IOpenProvisionOldSVImpl implements IIOpenProvisionOldSV {
    public IBOIOPENPROVISIONOLDValue[] queryByDoneCode(String doneCode) throws Exception
    {
        IOpenProvisionOldDAO originDAO = (IOpenProvisionOldDAO) ServiceFactory.getService(IOpenProvisionOldDAO.class);
        IBOIOPENPROVISIONOLDValue[] iboiopenprovisionoldValue= originDAO.queryByDoneCode(doneCode);
        return iboiopenprovisionoldValue;
    }

}
