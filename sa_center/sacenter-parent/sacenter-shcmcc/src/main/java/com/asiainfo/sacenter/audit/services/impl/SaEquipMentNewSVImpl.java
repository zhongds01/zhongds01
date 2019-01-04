package com.asiainfo.sacenter.audit.services.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sacenter.audit.dao.interfaces.ISaEquipMentNewDAO;
import com.asiainfo.sacenter.audit.services.interfaces.ISaEquipMentNewSV;
import com.asiainfo.sacenter.audit.ivalues.IBOISAEQUIPMENTNEWValue;

/**
 * Created by jacky on 2017/8/30.
 */
public class SaEquipMentNewSVImpl implements ISaEquipMentNewSV {
    public IBOISAEQUIPMENTNEWValue[] queryByDoneCode(String doneCode) throws Exception {
        ISaEquipMentNewDAO originDAO = (ISaEquipMentNewDAO) ServiceFactory.getService(ISaEquipMentNewDAO.class);
        IBOISAEQUIPMENTNEWValue[] iboisaequipmentnewValues= originDAO.queryByDoneCode(doneCode);
        return iboisaequipmentnewValues;
    }
}
