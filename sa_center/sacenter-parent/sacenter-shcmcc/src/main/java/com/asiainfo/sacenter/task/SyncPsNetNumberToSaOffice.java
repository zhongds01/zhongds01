package com.asiainfo.sacenter.task;

import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.appframe.ext.exeframe.task.TaskFrameWork;
import com.asiainfo.appframe.ext.exeframe.task.interfaces.ITask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LYF on 2017/11/1.
 */
public class SyncPsNetNumberToSaOffice implements ITask {
    private static Log log = LogFactory.getLog(SyncPsNetNumberToSaOffice.class);

    public String doTask(long l) throws SQLException {
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement getMaxId = null;
        PreparedStatement getDifference = null;
        PreparedStatement insertStament = null;
        long maxId = 0;
        try {
            conn = ServiceManager.getSession().getNewConnection("base");
            getMaxId = conn.prepareStatement("select max(id) from kt_cfg.sa_office");
            resultSet = getMaxId.executeQuery();
            while (resultSet.next()) {
                maxId = resultSet.getLong(1);
            }
            if (maxId == 0) {
                maxId=10000000;
            }
            getMaxId.close();
            resultSet.close();

            getDifference = conn.prepareStatement("SELECT a.number_segment,a.region_code,a.ps_net_code  FROM NEWkt.Ps_Net_Number  a   MINUS " +
                    "SELECT b.headnum,b.region_code,b.ps_net_code  FROM kt_cfg.sa_office  b ");
            resultSet = getDifference.executeQuery();
            int i = 0;
            String insertSql = "insert into kt_cfg.sa_office (ID, HEADNUM, CATEGORY, START_NUM, END_NUM, PLATFROM, REGION_ID, REGION_CODE, PS_NET_CODE, CREATER, CREATE_DATE, STATE, MODIFIER, MODIFY_DATE)" +
                    "values (?, ?, 'MSISDN', null, null, ?, ?, ?, ?, 10001, sysdate, 'U', null, null)";
            insertStament = conn.prepareStatement(insertSql);
            while (resultSet.next()) {
                maxId++;
                i++;
                String head_num = resultSet.getString(1);
                String region_code = resultSet.getString(2);
                String ps_net_code = resultSet.getString(3);
                String region_id = String.valueOf(Long.valueOf(head_num) % 9 + 201);
                insertStament.setLong(1, maxId);
                insertStament.setString(2, String.valueOf(head_num));
                insertStament.setString(3, "HangbanZhcx_HLR" + ps_net_code);
                insertStament.setString(4, region_id);
                insertStament.setString(5, region_code);
                insertStament.setString(6, ps_net_code);
                insertStament.addBatch();
            }
            try {
                insertStament.executeBatch();
                conn.commit();
                log.info("同步ps_net_number表 至 sa_office 数据结束!,此次共插入" + i + "条数据");
            } catch (Exception e) {
                conn.rollback();
                log.error(e);
                return ("执行过程出现错误" + e);
            }
            return ("同步ps_net_number表 至 sa_office 数据结束!,此次共插入" + i + "条数据");
        } catch (Exception e) {
            log.error(e);
            return ("执行过程出现错误" + e);
        } finally {
            if (conn != null && !conn.isClosed()) {
                try {
                    conn.close();
                } catch (Exception e) {
                    log.error(e);
                }
            }
            if (getMaxId != null && !getMaxId.isClosed()) {
                try {
                    getMaxId.close();
                } catch (Exception e) {
                    log.error(e);
                }
            }
            if (getDifference != null && !getDifference.isClosed()) {
                try {
                    getDifference.close();
                } catch (Exception e) {
                    log.error(e);
                }
            }
            if (resultSet != null ) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    log.error(e);
                }
            }
            if (insertStament != null && !insertStament.isClosed()) {
                try {
                    insertStament.close();
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }

    public static void main(String args[]) {
        if (args.length != 3) {
            try {
                log.info("启动参数为 " + "SyncPsNetNumber2SaOffice   1   0");
                TaskFrameWork.main(new String[]{"SyncPsNetNumber2SaOffice", "1", "0"});
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            try {
                log.info("启动参数为 " + args[0] + "  " + args[1] + "  " + args[2]);
                TaskFrameWork.main(new String[]{args[0], args[1], args[2]});
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
