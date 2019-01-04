package com.asiainfo.sacenter.audit.exe;

import com.ai.appframe2.common.ServiceManager;
import com.ai.sacenter.center.SFCenterFactory;
import com.asiainfo.appframe.ext.exeframe.tf.TfFrameWork;
import com.asiainfo.appframe.ext.exeframe.tf.interfaces.ITransform;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by ZiJunLi on 2018/1/10.
 */
public class DataInfoCompareTF implements ITransform {

    private static Log log = LogFactory.getLog(DataInfoCompareTF.class);

    public void transform(HashMap[] hashMaps) throws Exception {
        if (hashMaps != null && hashMaps.length > 0) {
            for (Map paramMap : hashMaps) {
                try {
                    if (paramMap.get("YY_OLD_PARAM") != null && paramMap.get("YY_PARAM") != null && paramMap.get("KT_OLD_PARAM") != null && paramMap.get("KT_PARAM") != null) {
                        // �Ƚϳ����ಿ�ֲ������ŵ�map��
                        String yyParamMore = dataCompare(paramMap.get("YY_PARAM").toString(), paramMap.get("KT_PARAM").toString(), 1);
                        String ktParamMore = dataCompare(paramMap.get("KT_PARAM").toString(), paramMap.get("YY_PARAM").toString(), 1);
                        String yyOldParamMore = dataCompare(paramMap.get("YY_OLD_PARAM").toString(), paramMap.get("KT_OLD_PARAM").toString(), 1);
                        String ktOldParamMore = dataCompare(paramMap.get("KT_OLD_PARAM").toString(), paramMap.get("YY_OLD_PARAM").toString(), 1);
                        paramMap.put("YY_PARAM_MORE", yyParamMore);
                        paramMap.put("KT_PARAM_MORE", ktParamMore);
                        paramMap.put("YY_OLD_PARAM_MORE", yyOldParamMore);
                        paramMap.put("KT_OLD_PARAM_MORE", ktOldParamMore);
                        // �ȶԳ����첿�֣��ŵ�map��
                        String diffParam = dataCompare(paramMap.get("KT_PARAM").toString(), paramMap.get("YY_PARAM").toString(), 2);
                        String diff_old_param = dataCompare(paramMap.get("KT_OLD_PARAM").toString(), paramMap.get("YY_OLD_PARAM").toString(), 2);
                        paramMap.put("DIFF_PARAM", diffParam);
                        paramMap.put("IDFF_OLD_PARAM", diff_old_param);
                        // ��������浽���ݿ�
                        // ����״̬��״̬��0δ����1�����У�2�Ѵ���9����
                        paramMap.put("STATE", "2");
                        saveResultMaps(paramMap);
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    /**
     * compType=1  �Ƚ϶���Ĳ��֣��Ƚ�moreStr��lessStr��Ĳ���
     * compType=2  �Ƚϲ��첿��
     * ���ز���ֱΪ��ͨ���е�����
     */
    public String dataCompare(String moreStr, String lessStr, Integer compType) throws Exception {
        // ����ֵ
        StringBuffer moreSb = new StringBuffer();
        String[] moreParams = moreStr.split(";");
        String[] lessParams = lessStr.split(";");
        Map moreMap = new HashMap(); // ket�����ԣ�value������+"="+ֵ
        Map lessMap = new HashMap(); // ket�����ԣ�value������+"="+ֵ

        //ѭ�������ݷŵ�map��
        for (String moreParam : moreParams) {
            String[] params = moreParam.split("=");
            moreMap.put(params[0], moreParam);
        }
        for (String lessParam : lessParams) {
            String[] params = lessParam.split("=");
            lessMap.put(params[0], lessParam);
        }

        // �޳�OSSTATUS��SOURCEID��REGIONID����3����������
        if(moreMap.containsKey("OSSTATUS")){
            moreMap.remove("OSSTATUS");
        }
        if(moreMap.containsKey("SOURCEID")){
            moreMap.remove("SOURCEID");
        }
        if(moreMap.containsKey("REGIONID")){
            moreMap.remove("REGIONID");
        }
        if(lessMap.containsKey("OSSTATUS")){
            lessMap.remove("OSSTATUS");
        }
        if(lessMap.containsKey("SOURCEID")){
            lessMap.remove("SOURCEID");
        }
        if(lessMap.containsKey("REGIONID")){
            lessMap.remove("REGIONID");
        }


        // ��ȡkey
        Set moreKey = moreMap.keySet();
        // moreStr��Ĳ���
        Iterator moreIt = moreKey.iterator();
        while (moreIt.hasNext()) {
            String moreProp = (String) moreIt.next();
            if (compType == 1) {
                if (!lessMap.containsKey(moreProp)) {
                    moreSb.append(moreMap.get(moreProp).toString()).append(";");
                }
            } else if (compType == 2) {
                if (lessMap.containsKey(moreProp)) {
                    if (!moreMap.get(moreProp).toString().equals(lessMap.get(moreProp).toString())) {
                        moreSb.append(moreMap.get(moreProp).toString()).append(";----").append(lessMap.get(moreProp).toString()).append(";").append("\n ");
                    }
                }
            }
        }
        return moreSb.toString();
    }

    /**
     * �����������������
     */
    public void saveResultMaps(Map retMap) {
        String sql = "update cmkt.DATA_INFO_COMPARE set yy_old_param_more = ?,yy_param_more=?,kt_old_param_more=?,kt_param_more=?,diff_old_param=?,diff_param=?,state=?,done_date=sysdate where done_code = ?";

        Connection conn = null;
        PreparedStatement insertStmt = null;

        try {
            SFCenterFactory.pushCenterInfo("200");
            conn = ServiceManager.getSession().getConnection("cmkt11");
            insertStmt = conn.prepareStatement(sql);
            insertStmt.setString(1, retMap.get("YY_OLD_PARAM_MORE").toString());
            insertStmt.setString(2, retMap.get("YY_PARAM_MORE").toString());
            insertStmt.setString(3, retMap.get("KT_OLD_PARAM_MORE").toString());
            insertStmt.setString(4, retMap.get("KT_PARAM_MORE").toString());
            insertStmt.setString(5, retMap.get("IDFF_OLD_PARAM").toString());
            insertStmt.setString(6, retMap.get("DIFF_PARAM").toString());
            insertStmt.setInt(7, Integer.parseInt(retMap.get("STATE").toString()));
            insertStmt.setString(8, retMap.get("DONE_CODE").toString());
            insertStmt.execute();
            insertStmt.close();
            conn.close();
        } catch (Exception e) {
            log.error(" UPDATE_SQL:" + sql, e);
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

    public static void main(String[] args) throws Exception {
        try {
            TfFrameWork.main(new String[]{"DATA_INFO", "1", "0"});
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

}
