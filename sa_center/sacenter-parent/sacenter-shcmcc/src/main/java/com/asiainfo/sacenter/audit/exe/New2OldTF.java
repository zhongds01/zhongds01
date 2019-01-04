package com.asiainfo.sacenter.audit.exe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.center.SFCenterFactory;
import com.asiainfo.appframe.ext.exeframe.tf.interfaces.ITransform;
import com.asiainfo.appframe.ext.exeframe.tf.TfFrameWork;

import com.asiainfo.sacenter.audit.services.interfaces.IIOpenProvisionOldSV;
import com.asiainfo.sacenter.audit.services.interfaces.IYSSV;
import com.asiainfo.sacenter.audit.ivalues.IBOIOPENPROVISIONOLDValue;
import com.asiainfo.sacenter.audit.ivalues.IBOYSValue;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class New2OldTF implements ITransform {
    private static Log log = LogFactory.getLog(New2OldTF.class);
    public final static String OLD_PS_PARAM_PREFIX = "OLD_PS_PARAM_";
    public final static String PS_PARAM_PREFIX = "PS_PARAM_";

    public void transform(HashMap[] maps) throws Exception {
        if (maps != null && maps.length > 0) {

            Map YS=new HashMap();


            for (int i = 0; i < maps.length; i++) {

                List sourceKeyList = new ArrayList();
                Map sourceDataMap = new HashMap();
                List targetKeyList = new ArrayList();
                Map targetDataMap = new HashMap();

                Map isaEquipmentNew = maps[i];
                String DONE_CODE_NEW = (String) isaEquipmentNew.get("DONE_CODE");
                String PS_SERVICE_TYPE_NEW = (String) isaEquipmentNew.get("PS_SERVICE_TYPE");
                String BILL_ID_NEW = (String) isaEquipmentNew.get("BILL_ID");
                String SUB_BILL_ID_NEW = (String) isaEquipmentNew.get("SUB_BILL_ID");
                Long ACTION_ID_NEW = null == isaEquipmentNew.get("ACTION_ID") ? 0L : Long.parseLong(isaEquipmentNew.get("ACTION_ID") + "");
                int STOP_TYPE_NEW = null == isaEquipmentNew.get("STOP_TYPE") ? 0 : Integer.parseInt(isaEquipmentNew.get("STOP_TYPE") + "");
                String OLD_PS_PARAM_NEW = (String) isaEquipmentNew.get("OLD_PS_PARAM");
                splintString(sourceDataMap, New2OldTF.OLD_PS_PARAM_PREFIX, OLD_PS_PARAM_NEW, 1, sourceKeyList);
                String PS_PARAM_NEW = (String) isaEquipmentNew.get("PS_PARAM");
                splintString(sourceDataMap, New2OldTF.PS_PARAM_PREFIX, PS_PARAM_NEW, 1, sourceKeyList);
                sourceDataMap.put("DONE_CODE", DONE_CODE_NEW);
                sourceDataMap.put("PS_SERVICE_TYPE", PS_SERVICE_TYPE_NEW);
                sourceDataMap.put("BILL_ID", BILL_ID_NEW);
                sourceDataMap.put("SUB_BILL_ID", SUB_BILL_ID_NEW);
                sourceDataMap.put("ACTION_ID", ACTION_ID_NEW + "");
                sourceDataMap.put("STOP_TYPE", STOP_TYPE_NEW + "");
                sourceKeyList.add("DONE_CODE");
                sourceKeyList.add("PS_SERVICE_TYPE");
                sourceKeyList.add("BILL_ID");
                sourceKeyList.add("SUB_BILL_ID");
                sourceKeyList.add("ACTION_ID");
                sourceKeyList.add("STOP_TYPE");
                SFCenterFactory.pushCenterInfo("200");
                IIOpenProvisionOldSV iiOpenProvisionOldSV = (IIOpenProvisionOldSV) ServiceFactory.getService(IIOpenProvisionOldSV.class);
                IBOIOPENPROVISIONOLDValue[] iboiopenprovisionoldValue = iiOpenProvisionOldSV.queryByDoneCode(DONE_CODE_NEW);
                if (null != iboiopenprovisionoldValue && 1 == iboiopenprovisionoldValue.length) {
                    String DONE_CODE_OLD = iboiopenprovisionoldValue[0].getDoneCode();
                    String PS_SERVICE_TYPE_OLD = iboiopenprovisionoldValue[0].getPsServiceType();
                    String BILL_ID_OLD = iboiopenprovisionoldValue[0].getBillId();
                    String SUB_BILL_ID_OLD = iboiopenprovisionoldValue[0].getSubBillId();
                    Long ACTION_ID_OLD = iboiopenprovisionoldValue[0].getActionId();
                    int STOP_TYPE_OLD = iboiopenprovisionoldValue[0].getStopType();

                    if("1000".equals(PS_SERVICE_TYPE_OLD))
                    {
                        PS_SERVICE_TYPE_OLD="HLR";
                    }else
                    {
                        IYSSV iyssv = (IYSSV) ServiceFactory.getService(IYSSV.class);
                        IBOYSValue[] ts=iyssv.queryByActionId(ACTION_ID_OLD);
                        if(null!=ts&&ts.length>0)
                        {
                            PS_SERVICE_TYPE_OLD=ts[0].getPsServiceType();
                        }
                    }

                    String OLD_PS_PARAM_OLD = iboiopenprovisionoldValue[0].getOldPsParam();
                    splintString(targetDataMap, New2OldTF.OLD_PS_PARAM_PREFIX, OLD_PS_PARAM_OLD, 0, targetKeyList);

                    String PS_PARAM_OLD = iboiopenprovisionoldValue[0].getPsParam();
                    splintString(targetDataMap, New2OldTF.PS_PARAM_PREFIX, PS_PARAM_OLD, 0, targetKeyList);
                    targetDataMap.put("DONE_CODE", DONE_CODE_OLD);
                    targetDataMap.put("PS_SERVICE_TYPE", PS_SERVICE_TYPE_OLD);
                    targetDataMap.put("BILL_ID", BILL_ID_OLD);
                    targetDataMap.put("SUB_BILL_ID", SUB_BILL_ID_OLD);
                    targetDataMap.put("ACTION_ID", ACTION_ID_OLD + "");
                    targetDataMap.put("STOP_TYPE", STOP_TYPE_OLD + "");

                    List errorList = new ArrayList();
                    for (int t = 0; t < sourceKeyList.size(); t++) {
                        if(sourceDataMap.get(sourceKeyList.get(t)) != null) {
                            if (!sourceDataMap.get(sourceKeyList.get(t)).equals(targetDataMap.get(sourceKeyList.get(t)))) {
                                String data = DONE_CODE_NEW + "=" + sourceKeyList.get(t) + "=" + sourceDataMap.get(sourceKeyList.get(t)) + "=" + targetDataMap.get(sourceKeyList.get(t));
                                errorList.add(data);
                            }
                        }else{
                            if(targetDataMap.get(sourceKeyList.get(t)) != null){
                                String data = DONE_CODE_NEW + "=" + sourceKeyList.get(t) + "=" + sourceDataMap.get(sourceKeyList.get(t)) + "=" + targetDataMap.get(sourceKeyList.get(t));
                                errorList.add(data);
                            }
                        }
                    }
                    saveResult(errorList, 1);
                } else {
                   saveSingle(DONE_CODE_NEW,2);
                }
            }
        }
    }

    public void saveResult(List errorData, int diff_type) {
        String sql = "insert into COMPARE_RESULT_NEW2OLD (done_code, diff_type,key_name,new_value,old_value) values (?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement insertStmt = null;

        try {
            SFCenterFactory.pushCenterInfo("200");
            conn = ServiceManager.getSession().getConnection("cmkt11");
            insertStmt = conn.prepareStatement(sql);

            for (int i = 0; i < errorData.size(); i++) {
                String params[] = ((String) errorData.get(i)).split("=");
                if (null != params && 4 == params.length) {
                    insertStmt.setString(1, params[0]);
                    insertStmt.setInt(2, diff_type);
                    insertStmt.setString(3, params[1]);
                    insertStmt.setString(4, params[2]);
                    insertStmt.setString(5, params[3]);
                    insertStmt.addBatch();
                }
            }
            insertStmt.executeBatch(); // insert remaining records
            insertStmt.close();
            conn.close();
        } catch (Exception e) {
            log.error(" INSERT_SQL:" + sql, e);
        } finally {
            if (insertStmt != null) {
                try {
                    insertStmt.close();
                } catch (Exception e) {
                    log.error(e);
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }

    private void saveSingle(String done_code, int diff_type) {
        String sql = "insert into COMPARE_RESULT_NEW2OLD (done_code, diff_type) values (" + done_code + "," + diff_type + ")";
        Connection conn = null;
        PreparedStatement insertStmt = null;
        try {
            SFCenterFactory.pushCenterInfo("200");
            conn = ServiceManager.getSession().getConnection("cmkt11");
            insertStmt = conn.prepareStatement(sql);
            try {
                insertStmt = conn.prepareStatement(sql);
                insertStmt.execute();
            } catch (Exception e) {
                log.error("比对结果保存失败! INSERT_SQL:" + sql, e);
            } finally {
                if (insertStmt != null) {
                    try {
                        insertStmt.close();
                    } catch (Exception e) {
                        log.error(e);
                    }
                }
                if (null != conn) {
                    try {
                        conn.close();
                    } catch (Exception e) {
                        log.error(e);
                    }
                }
            }
        } catch (Exception e1) {
            log.error("insertSql创建失败! INSERT_SQL:" + sql, e1);
        }

    }

    public void splintString(Map dataMap, String prefix, String paramStr, int isNeedKeyList, List keysList) {
        if (StringUtils.isNotEmpty(paramStr)) {
            String params[] = paramStr.split(";");
            if (null != params && params.length > 0) {
                for (int k = 0; k < params.length; k++) {
                    String[] param = params[k].split("=");
                    if (null != param && 2 == param.length) {
                        dataMap.put(prefix + param[0], param[1]);
                    } else {
                        dataMap.put(prefix + param[0], "");
                    }
                    if (1 == isNeedKeyList) {
                        keysList.add(prefix + param[0]);
                    }
                }
            }
        }

    }

    public void compareMap(List allnewkeyList, List errorkeyList, Map newParamMap, Map oldParamMap) {
        for (int i = 0; i < allnewkeyList.size(); i++) {
            if (!newParamMap.get(allnewkeyList.get(i)).equals(oldParamMap.get(allnewkeyList.get(i)))) {
                errorkeyList.add(allnewkeyList.get(i));
            }
        }
    }

    public void compareString(String newStr, String oldStr, String key, List errorList) {
        if (!newStr.equals(oldStr)) {
            errorList.add(key);
        }
    }

    public void compareTnt(int newInt, int oldInt, String key, List errorList) {
        if (newInt != oldInt) {
            errorList.add(key);
        }
    }

    public void compareLong(long newInt, long oldInt, String key, List errorList) {
        if (newInt != oldInt) {
            errorList.add(key);
        }
    }

    public void splitParam(String strParam, Map paramMap, List allKeys, List errKeys) {
        if (StringUtils.isNotEmpty(strParam)) {
            String params[] = strParam.split(";");
            if (null != params && params.length > 0) {
                for (int k = 0; k < params.length; k++) {
                    String[] param = params[k].split("=");
                    if (null != param && 2 == param.length) {
                        paramMap.put(param[0], param[1]);
                        allKeys.add(param[0]);
                    } else {
                        if (null != errKeys) {
                            errKeys.add(param[0]);
                        }
                    }
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        try {
            TfFrameWork.main(new String[]{"ISA_EQUIPMENT_NEW", "1", "0"});
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

}