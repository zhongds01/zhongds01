package com.asiainfo.sacenter.audit.dao.interfaces;

import com.asiainfo.sacenter.audit.ivalues.IBOISAEQUIPMENTNEWValue;

/**
 * Created by jacky on 2017/8/30.
 */
public interface ISaEquipMentNewDAO {
    public IBOISAEQUIPMENTNEWValue[] queryByDoneCode(String doneCode) throws Exception;

}
