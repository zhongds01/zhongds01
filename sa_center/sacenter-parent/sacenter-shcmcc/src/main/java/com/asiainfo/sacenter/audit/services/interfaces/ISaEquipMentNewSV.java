package com.asiainfo.sacenter.audit.services.interfaces;

import com.asiainfo.sacenter.audit.ivalues.IBOISAEQUIPMENTNEWValue;

/**
 * Created by jacky on 2017/8/30.
 */
public interface ISaEquipMentNewSV {
    public IBOISAEQUIPMENTNEWValue[] queryByDoneCode(String doneCode) throws Exception;
}
