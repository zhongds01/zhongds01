package com.asiainfo.sacenter.audit.exe;

import com.ai.aif.csf.common.utils.StringUtils;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.sacenter.center.SFCenterFactory;
import com.ai.sacenter.util.CenterUtils;
import com.asiainfo.appframe.ext.exeframe.tf.TfFrameWork;
import com.asiainfo.appframe.ext.exeframe.tf.interfaces.ITransform;
import com.asiainfo.sacenter.audit.ivalues.IBOYSValue;
import com.asiainfo.sacenter.audit.services.interfaces.IYSSV;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ZiJunLi on 2018/1/10.
 */
public class DataInfoTF implements ITransform {

    private static Log log = LogFactory.getLog(New2OldTF.class);
    // ��������1�޲��죬2Ӫҵ��ͨ�п�ͨ���������ݣ�3��ͨ������Ӫҵ��ͨ�����ݣ�4���е����в���
    private final static Long RESULT_TYPE_1 = 1L;
    private final static Long RESULT_TYPE_2 = 2L;
    private final static Long RESULT_TYPE_3 = 3L;
    private final static Long RESULT_TYPE_4 = 4L;

    public void transform(HashMap[] hashMaps) throws Exception {

        // ������ʼ�ĵط��������е�action_id����
        Map<Long, String> actMap;
        actMap = getAllActions();

        List<Map> paramList = new ArrayList(); //�����е�paramMap�ŵ�list�У����һ�𱣴�
        /*
        * paramMap����   ��DONE_CODE+BILL_ID+ACTION_IDΪΨһ��λ
            DONE_CODE,BILL_ID,ACTION_ID
            YY_PS_PARAM             ���Ӫҵ��ͨ��ps_param                     YY_PS_PARAM_MORE        ���Ӫҵ��ͨps_param��Ĳ���
            YY_OLD_PS_PARAM         ���Ӧ��Ҳ��ͨ��old_ps_param               YY_OLD_PS_PARAM_MORE    ���Ӫҵ��ͨold_ps_pararm��Ĳ���
            YY_SUB_BILL_ID          ���Ӫҵ��ͨ��sub_bill_id                  YY_STOP_TYPE            ���Ӫҵ��ͨ��stop_type
            YY_PS_NET_CODE          ���Ӫҵ��ͨ��ps_net_code                  YY_PS_SERVICE_TYPE      ���Ӫҵ��ͨ��ps_service_type
            KT_PS_PARAM             ��ſ�ͨ���ĵ�ps_param                     KT_PS_PARAM_MORE        ��ſ�ͨ����ps_param��Ĳ���
            KT_OLD_PS_PARAM         ��ſ�ͨ���ĵ�old_ps_param                 KT_OLD_PS_PARAM_MORE    ��Ź���ͨ����old_ps_param��Ĳ���
            KT_SUB_BILL_ID          ��ſ�ͨ����sub_bill_id                    KT_STOP_TYPE            ��ſ�ͨ����stop_type
            KT_PS_NET_CODE          ��Ź���ͨ����ps_net_code                  KT_PS_SERVICE_TYPE      ��ſ�ͨ����ps_service_type
            DIFF_PS_PARAM           ���ps_param����                           DIFF_OLD_PS_PARAM       ���old_ps_param����
            DIFF_SUB_BILL_ID        ���sub_bill_id����                        DIFF_STOP_TYPE          ��Ź�stop_type����
            DIFF_PS_NET_CODE        ���ps_net_code����                        DIFF_PS_SERVICE_TYPE    ���ps_service_type����
            STATE                   ����״̬��0������1�Ѵ���2�ѷ�����9����   ORDER_TIME              ��Ŷ���ʱ��
            RESULT_TYPE             ��������1�޲��죬2Ӫҵ��ͨ�п�ͨ���������ݣ�3��ͨ������Ӫҵ��ͨ�����ݣ�4���е����в���
        * */
        Map<String, Object> paramMap; //�����еĿ�ͨ�����ŵ����map�У�Ȼ��ȶ�
        Map<String, Map<String, Object>> equiMap; // ��ſ�ͨ���ĵĿ�ͨ����
        Map<String, Map<String, Object>> provMap;  // ���Ӫҵ��ͨ�Ŀ�ͨ����
        Set<String> provSet;
        Set<String> equiSet;
        String doneCode;
        String billId;
        Timestamp orderTime;
        String key;
        for (Map rstMap : hashMaps) {
            try {
                doneCode = rstMap.get("DONE_CODE").toString(); //��ȡdone_code
                billId = rstMap.get("BILL_ID").toString(); //��ȡbill_id
                orderTime = (Timestamp) rstMap.get("ORDER_TIME");
                equiMap = getIsaEquipment(doneCode, billId, orderTime);// Ĭ`��ֱ������result_typeΪ3
                provMap = getIOpenProvision(doneCode, billId, orderTime);// Ĭ��ֱ������result_typeΪ4
                if (equiMap.isEmpty() && provMap.isEmpty()) {
                    continue;
                }
                provSet = provMap.keySet();
                equiSet = equiMap.keySet();
                // ѭ��Ӫҵ��ͨ������
                Iterator provIt = provSet.iterator();
                while (provIt.hasNext()) {
                    key = provIt.next().toString();
                    paramMap = provMap.get(key);
                    // ����ps_service_type
                    setPsServiceType(paramMap, actMap);
                    if (equiSet.contains(key)) {
                        // ����Ӫҵ��ͨ�뿪ͨ���Ķ������ݣ��ߴ��߼����ȶ����ݡ�������Ҫ��result_type�ĳ�1��4
                        compareData(provMap.get(key), equiMap.get(key), paramMap);

                        /* ����״̬
                        * STATE                   ����״̬��0������1�Ѵ���2�ѷ�����9����
                        * RESULT_TYPE             ��������1�޲��죬2Ӫҵ��ͨ�п�ͨ���������ݣ�3��ͨ������Ӫҵ��ͨ�����ݣ�4���е����в���
                        * */
                        if (paramMap.get("DIFF_SUB_BILL_ID").toString().equals("")
                                && paramMap.get("DIFF_STOP_TYPE").toString().equals("")
                                && paramMap.get("DIFF_PS_NET_CODE").toString().equals("")
                                && paramMap.get("DIFF_PS_SERVICE_TYPE").toString().equals("")
                                && paramMap.get("YY_PS_PARAM_MORE").toString().equals("")
                                && paramMap.get("KT_PS_PARAM_MORE").toString().equals("")
                                && paramMap.get("DIFF_PS_PARAM").toString().equals("")
                                && paramMap.get("YY_OLD_PS_PARAM_MORE").toString().equals("")
                                && paramMap.get("KT_OLD_PS_PARAM_MORE").toString().equals("")
                                && paramMap.get("DIFF_OLD_PS_PARAM").toString().equals("")) {
                            paramMap.put("RESULT_TYPE", RESULT_TYPE_1);
                        } else {
                            paramMap.put("RESULT_TYPE", RESULT_TYPE_4);
                        }
                        paramMap.put("STATE",1L) ;
                    } else {
                        // ���Ӫҵ��ͨû�л��߿�ͨ�������ݣ����ߴ��߼���ֱ�ӱ���
                        paramMap.put("RESULT_TYPE", RESULT_TYPE_2);
                        paramMap.put("STATE",1L) ;
                    }
                    paramList.add(paramMap);
                }

                // ѭ����ͨ���ĵ�����
                Iterator equiIt = equiSet.iterator();
                while (equiIt.hasNext()) {
                    key = equiIt.next().toString();
                    paramMap = equiMap.get(key);
                    if (!provSet.contains(key)) {
                        // ����״̬
                        paramMap.put("RESULT_TYPE",RESULT_TYPE_3) ;
                        paramMap.put("STATE",1L) ;
                        // ���������������ѭ�����Ѿ���Ӫҵ����ͨ���Ķ��е����ݱȶԲ��ŵ�paramList���ˣ����Դ˴�ֻ�Կ�ͨ�����У�Ӫҵ��ͨû�е�����������
                        paramList.add(paramMap);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        // ��������
        try {
            saveLists(paramList);
        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }

    /*
    * ����billId��doneCode��ѯӪҵ��ͨ������
    * */
    public Map<String, Map<String, Object>> getIOpenProvision(String doneCode, String billId, Timestamp ordTime) throws Exception {
        Map<String, Map<String, Object>> retMap = new HashMap<String, Map<String, Object>>();
        Map<String, Object> provMap;
        // ��ȡӪҵ��ͨ������
        String sql = "";
        String region_id = StringUtils.substring(doneCode, 0, 3);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
        String splitTab = sf.format(new Timestamp(new Date().getTime())); // ���˽�����������Ӫҵ��ͨ�����ݣ�����ȡ���µ�Ӫҵ��ͨ����
        SFCenterFactory.pushCenterInfo("200");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            if (Integer.parseInt(region_id) < 215) {
                conn = ServiceManager.getSession().getConnection("shcrmso1");
            } else {
                conn = ServiceManager.getSession().getConnection("shcrmso2");
            }
            sql = "select t.done_code,t.action_id,t.bill_id,t.sub_bill_id,t.old_ps_param,t.ps_param,t.stop_type,t.ps_service_type,t.ps_net_code from i_open_provision_" + region_id + " t where t.done_code = " + Long.parseLong(doneCode) + " and t.bill_id = '" + billId + "' ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                provMap = new HashMap<String, Object>();
                provMap.put("DONE_CODE", rs.getString(1));
                provMap.put("ACTION_ID", rs.getLong(2));
                provMap.put("BILL_ID", rs.getString(3));
                provMap.put("YY_SUB_BILL_ID", rs.getString(4));
                provMap.put("YY_OLD_PS_PARAM", rs.getString(5));
                provMap.put("YY_PS_PARAM", rs.getString(6));
                provMap.put("YY_STOP_TYPE", rs.getInt(7));
                provMap.put("YY_PS_SERVICE_TYPE", rs.getInt(8));
                provMap.put("YY_PS_NET_CODE", rs.getString(9));
                provMap.put("RESULT_TYPE", RESULT_TYPE_2);
                provMap.put("ORDER_TIME", ordTime);
                retMap.put(provMap.get("DONE_CODE").toString() + "|" + provMap.get("BILL_ID").toString() + "|" + provMap.get("ACTION_ID").toString(), provMap);
            }
        } catch (Exception e) {
            log.error(" QUERY_SQL:" + sql, e);
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
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
        return retMap;
    }


    /**
     * ����billId��doneCode��ѯ��ͨ���ĵĿ�ͨ����
     */
    public Map<String, Map<String, Object>> getIsaEquipment(String doneCode, String billId, Timestamp ordTime) throws Exception {
        Map<String, Map<String, Object>> retMap = new HashMap<String, Map<String, Object>>();
        Map<String, Object> provMap;
        // ��ȡӪҵ��ͨ������
        String sql = "";
        String region_id = CenterUtils.getSFUpfgkmOffice(billId).getREGION_ID();
        SFCenterFactory.pushCenterInfo(region_id);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {
            conn = ServiceManager.getSession().getConnection("cmkt11");
            sql = "select t.done_code,t.action_id,t.bill_id,t.sub_bill_id,t.old_ps_param,t.ps_param,t.stop_type,t.ps_service_type,t.ps_net_code from isa_equipment_" + region_id + " t where t.done_code = " + Long.parseLong(doneCode) + " and t.bill_id = '" + billId + "' ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                provMap = new HashMap<String, Object>();
                provMap.put("DONE_CODE", rs.getString(1));
                provMap.put("ACTION_ID", rs.getLong(2));
                provMap.put("BILL_ID", rs.getString(3));
                provMap.put("KT_SUB_BILL_ID", rs.getString(4));
                provMap.put("KT_OLD_PS_PARAM", rs.getString(5));
                provMap.put("KT_PS_PARAM", rs.getString(6));
                provMap.put("KT_STOP_TYPE", rs.getInt(7));
                provMap.put("KT_PS_SERVICE_TYPE", rs.getString(8));
                provMap.put("KT_PS_NET_CODE", rs.getString(9));
                provMap.put("RESULT_TYPE", RESULT_TYPE_3);
                provMap.put("ORDER_TIME", ordTime);
                retMap.put(provMap.get("DONE_CODE").toString() + "|" + provMap.get("BILL_ID").toString() + "|" + provMap.get("ACTION_ID").toString(), provMap);
            }
        } catch (Exception e) {
            log.error(" QUERY_SQL:" + sql, e);
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
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
        return retMap;
    }

    /*
    * �������ã����б���logerr���ǲ��׳�
    * */
    public void saveLists(List<Map> paramList) throws Exception {
        Map<String, Object> paramMap;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "insert into cmkt.data_compare (done_code, bill_id, action_id, yy_param_more, yy_old_param_more, kt_param_more, kt_old_param_more, diff_param, diff_old_param, diff_sub_bill_id, diff_stop_type, diff_ps_net_code, diff_service_type, state, result_type, order_time, done_date, remarks) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,null)";
        Connection conn = null;
        PreparedStatement insertStmt = null;

        try {
            SFCenterFactory.pushCenterInfo("200");
            conn = ServiceManager.getSession().getConnection("cmkt11");
            insertStmt = conn.prepareStatement(sql);

            for (int i = 0; i < paramList.size(); i++) {
                paramMap = paramList.get(i);
                insertStmt.setLong(1, Long.parseLong(paramMap.get("DONE_CODE").toString()));
                insertStmt.setString(2, paramMap.get("BILL_ID").toString());
                insertStmt.setLong(3, Long.parseLong(paramMap.get("ACTION_ID").toString()));
                insertStmt.setString(4, paramMap.get("YY_PS_PARAM_MORE") == null ? null : paramMap.get("YY_PS_PARAM_MORE").toString());
                insertStmt.setString(5, paramMap.get("YY_OLD_PS_PARAM_MORE") == null ? null : paramMap.get("YY_OLD_PS_PARAM_MORE").toString());
                insertStmt.setString(6, paramMap.get("KT_PS_PARAM_MORE") == null ? null : paramMap.get("KT_PS_PARAM_MORE").toString());
                insertStmt.setString(7, paramMap.get("KT_OLD_PS_PARAM_MORE") == null ? null : paramMap.get("KT_OLD_PS_PARAM_MORE").toString());
                insertStmt.setString(8, paramMap.get("DIFF_PS_PARAM") == null ? null : paramMap.get("DIFF_PS_PARAM").toString());
                insertStmt.setString(9, paramMap.get("DIFF_OLD_PS_PARAM") == null ? null : paramMap.get("DIFF_OLD_PS_PARAM").toString());
                insertStmt.setString(10, paramMap.get("DIFF_SUB_BILL_ID") == null ? null : paramMap.get("DIFF_SUB_BILL_ID").toString());
                insertStmt.setString(11, paramMap.get("DIFF_STOP_TYPE") == null ? null : paramMap.get("DIFF_STOP_TYPE").toString());
                insertStmt.setString(12, paramMap.get("DIFF_PS_NET_CODE") == null ? null : paramMap.get("DIFF_PS_NET_CODE").toString());
                insertStmt.setString(13, paramMap.get("DIFF_PS_SERVICE_TYPE") == null ? null : paramMap.get("DIFF_PS_SERVICE_TYPE").toString());
                insertStmt.setLong(14, Long.parseLong(paramMap.get("STATE").toString()));
                insertStmt.setLong(15, Long.parseLong(paramMap.get("RESULT_TYPE").toString()));
                insertStmt.setDate(16, new java.sql.Date(sf.parse(paramMap.get("ORDER_TIME").toString()).getTime()));
                insertStmt.addBatch();
            }
            insertStmt.executeBatch();
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

    /**
     * ��action_id��ps_service_type�ŵ�map��
     */
    public Map<Long, String> getAllActions() throws Exception {
        Map<Long, String> actMap = new HashMap<Long, String>();
        IYSSV iyssv = (IYSSV) ServiceFactory.getService(IYSSV.class);
        IBOYSValue[] ts = iyssv.getAllActions();
        if (ts != null && ts.length > 0) {
            for (IBOYSValue ys : ts) {
                actMap.put(ys.getActionId(), ys.getPsServiceType());
            }
        }
        return actMap;
    }


    /*
    * ����action_id����ps_service_type
    * */
    public void setPsServiceType(Map<String, Object> pMap, Map<Long, String> actMap) {
        // ΪӪҵ��ͨ���ݻ�ȡps_service_typeֵ
        if (null != pMap.get("ACTION_ID") && !"".equals(pMap.get("ACTION_ID").toString())) {
            // ���action_idΪ6����ps_service_typeΪ1000����ʵ������HLR
            if (1000 == Integer.parseInt(pMap.get("YY_PS_SERVICE_TYPE").toString())) {
                pMap.put("YY_PS_SERVICE_TYPE", "HLR");
            } else {
                pMap.put("YY_PS_SERVICE_TYPE", actMap.get(pMap.get("ACTION_ID")));
            }
        }
    }


    /*
    * �ȶԱ��ģ��������д��paramMap��
    * */
    public void compareData(Map<String, Object> provMap, Map<String, Object> equiMap, Map<String, Object> paramMap) throws Exception {
        DataInfoCompareTF dic = new DataInfoCompareTF();
        // �Ƚ�SUB_BILL_ID
        if (null != provMap.get("YY_SUB_BILL_ID") && !"".equals(provMap.get("YY_SUB_BILL_ID").toString())
                && null != equiMap.get("KT_SUB_BILL_ID") && !"".equals(equiMap.get("KT_SUB_BILL_ID").toString())) {
            paramMap.put("DIFF_SUB_BILL_ID", dic.dataCompare(provMap.get("YY_SUB_BILL_ID").toString(), equiMap.get("KT_SUB_BILL_ID").toString(), 2));
        } else {
            paramMap.put("DIFF_SUB_BILL_ID", provMap.get("YY_SUB_BILL_ID") + "---" + equiMap.get("KT_SUB_BILL_ID"));
        }

        // �Ƚ�STOP_TYPE
        if (null != provMap.get("YY_STOP_TYPE") && !"".equals(provMap.get("YY_STOP_TYPE").toString())
                && null != equiMap.get("KT_STOP_TYPE") && !"".equals(equiMap.get("KT_STOP_TYPE").toString())) {
            paramMap.put("DIFF_STOP_TYPE", dic.dataCompare(provMap.get("YY_STOP_TYPE").toString(), equiMap.get("KT_STOP_TYPE").toString(), 2));
        } else {
            paramMap.put("DIFF_STOP_TYPE", provMap.get("YY_STOP_TYPE") + "---" + equiMap.get("KT_STOP_TYPE"));
        }

        // �Ƚ�PS_NET_CODE
        if (null != provMap.get("YY_PS_NET_CODE") && !"".equals(provMap.get("YY_PS_NET_CODE").toString())
                && null != equiMap.get("KT_PS_NET_CODE") && !"".equals(equiMap.get("KT_PS_NET_CODE").toString())) {
            paramMap.put("DIFF_PS_NET_CODE", dic.dataCompare(provMap.get("YY_PS_NET_CODE").toString(), equiMap.get("KT_PS_NET_CODE").toString(), 2));
        } else {
            paramMap.put("DIFF_PS_NET_CODE", provMap.get("YY_PS_NET_CODE") + "---" + equiMap.get("KT_PS_NET_CODE"));
        }

        // �Ƚ�PS_SERVICE_TYPE
        if (null != provMap.get("YY_PS_SERVICE_TYPE") && !"".equals(provMap.get("YY_PS_SERVICE_TYPE").toString())
                && null != equiMap.get("KT_PS_SERVICE_TYPE") && !"".equals(equiMap.get("KT_PS_SERVICE_TYPE").toString())) {
            paramMap.put("DIFF_PS_SERVICE_TYPE", dic.dataCompare(provMap.get("YY_PS_SERVICE_TYPE").toString(), equiMap.get("KT_PS_SERVICE_TYPE").toString(), 2));
        } else {
            paramMap.put("DIFF_PS_SERVICE_TYPE", provMap.get("YY_PS_SERVICE_TYPE") + "---" + equiMap.get("KT_PS_SERVICE_TYPE"));
        }

        // �Ƚ�PS_PARAM���Ƚ�Ӫҵ��ͨ��Ĳ���
        if (null != provMap.get("YY_PS_PARAM") && !"".equals(provMap.get("YY_PS_PARAM").toString())
                && null != equiMap.get("KT_PS_PARAM") && !"".equals(equiMap.get("KT_PS_PARAM").toString())) {
            paramMap.put("YY_PS_PARAM_MORE", dic.dataCompare(provMap.get("YY_PS_PARAM").toString(), equiMap.get("KT_PS_PARAM").toString(), 1));
        } else {
            paramMap.put("YY_PS_PARAM_MORE", provMap.get("YY_PS_PARAM") + "---" + equiMap.get("KT_PS_PARAM"));
        }

        // �Ƚ�PS_PARAM���ȽϿ�ͨ���Ķ�Ĳ���
        if (null != provMap.get("YY_PS_PARAM") && !"".equals(provMap.get("YY_PS_PARAM").toString())
                && null != equiMap.get("KT_PS_PARAM") && !"".equals(equiMap.get("KT_PS_PARAM").toString())) {
            paramMap.put("KT_PS_PARAM_MORE", dic.dataCompare(equiMap.get("KT_PS_PARAM").toString(), provMap.get("YY_PS_PARAM").toString(), 1));
        } else {
            paramMap.put("KT_PS_PARAM_MORE", provMap.get("YY_PS_PARAM") + "---" + equiMap.get("KT_PS_PARAM"));
        }

        // �Ƚ�PS_PARAM,�Ƚϲ��첻����
        if (null != provMap.get("YY_PS_PARAM") && !"".equals(provMap.get("YY_PS_PARAM").toString())
                && null != equiMap.get("KT_PS_PARAM") && !"".equals(equiMap.get("KT_PS_PARAM").toString())) {
            paramMap.put("DIFF_PS_PARAM", dic.dataCompare(provMap.get("YY_PS_PARAM").toString(), equiMap.get("KT_PS_PARAM").toString(), 2));
        } else {
            paramMap.put("DIFF_PS_PARAM", provMap.get("YY_PS_PARAM") + "---" + equiMap.get("KT_PS_PARAM"));
        }

        // �Ƚ�OLD_PS_PARAM���Ƚ�Ӫҵ��ͨ��Ĳ���
        if (null != provMap.get("YY_OLD_PS_PARAM") && !"".equals(provMap.get("YY_OLD_PS_PARAM").toString())
                && null != equiMap.get("KT_OLD_PS_PARAM") && !"".equals(equiMap.get("KT_OLD_PS_PARAM").toString())) {
            paramMap.put("YY_OLD_PS_PARAM_MORE", dic.dataCompare(provMap.get("YY_OLD_PS_PARAM").toString(), equiMap.get("KT_OLD_PS_PARAM").toString(), 1));
        } else {
            paramMap.put("YY_OLD_PS_PARAM_MORE", provMap.get("YY_OLD_PS_PARAM") + "---" + equiMap.get("KT_OLD_PS_PARAM"));
        }

        // �Ƚ�OLD_PS_PARAM���ȽϿ�ͨ���Ķ�Ĳ���
        if (null != provMap.get("YY_OLD_PS_PARAM") && !"".equals(provMap.get("YY_OLD_PS_PARAM").toString())
                && null != equiMap.get("KT_OLD_PS_PARAM") && !"".equals(equiMap.get("KT_OLD_PS_PARAM").toString())) {
            paramMap.put("KT_OLD_PS_PARAM_MORE", dic.dataCompare(equiMap.get("KT_OLD_PS_PARAM").toString(), provMap.get("YY_OLD_PS_PARAM").toString(), 1));
        } else {
            paramMap.put("KT_OLD_PS_PARAM_MORE", provMap.get("YY_OLD_PS_PARAM") + "---" + equiMap.get("KT_OLD_PS_PARAM"));
        }

        // �Ƚ�OLD_PS_PARAM���Ƚϲ��첿��
        if (null != provMap.get("YY_OLD_PS_PARAM") && !"".equals(provMap.get("YY_OLD_PS_PARAM").toString())
                && null != equiMap.get("KT_OLD_PS_PARAM") && !"".equals(equiMap.get("KT_OLD_PS_PARAM").toString())) {
            paramMap.put("DIFF_OLD_PS_PARAM", dic.dataCompare(provMap.get("YY_OLD_PS_PARAM").toString(), equiMap.get("KT_OLD_PS_PARAM").toString(), 2));
        } else {
            paramMap.put("DIFF_OLD_PS_PARAM", provMap.get("YY_OLD_PS_PARAM") + "---" + equiMap.get("KT_OLD_PS_PARAM"));
        }

    }

    public static void main(String[] args) throws Exception {
        try {
            TfFrameWork.main(new String[]{"DATA_INFO", "1", "0"});
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

}
