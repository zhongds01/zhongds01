package com.asiainfo.sacenter.shcmcc.util;

import com.ai.sacenter.util.StringUtils;
import org.apache.log4j.net.SocketAppender;
import org.apache.log4j.spi.LoggingEvent;

import java.util.Map;

/**
 * Created by Think on 2017/8/5.
 */
public class ExtendSocketAppender extends SocketAppender {
    private static String ThreadName = "UnknownProcess";

    @Override
    public void append(LoggingEvent event) {
        event.setProperty("thread",ThreadName);
        super.append(event);
    }

    @Override
    public void setRemoteHost(String host){
//        if(startHost != null && !"".equals(startHost)){
//            super.setRemoteHost(startHost);
//        }else{
//            super.setRemoteHost(host);
//        }
    }

    @Override
    public void setPort(int port){
//        if(startPort != 0){
//            super.setPort(startPort);
//        }else{
//            super.setPort(port);
//        }
    }

    public ExtendSocketAppender(){
        String ServerName = System.getProperty("server.name");
        Map LogConfig = OthersConfigure.getItem("LogCenter",ServerName);
        if(LogConfig == null){
            int last = StringUtils.lastIndexOf(ServerName,"_");
            LogConfig =  OthersConfigure.getItem("LogCenter",last < 0 ?"default":ServerName.substring(0, last));
        }
        if(LogConfig == null) {
            LogConfig =  OthersConfigure.getItem("LogCenter","default");
        }
        if(LogConfig != null) {
            String host = (String) LogConfig.get("host");
            String port = (String) LogConfig.get("port");

            try {
                super.setPort(Integer.parseInt(port));
                super.setRemoteHost(host);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(ServerName != null && !"".equals(ServerName)){
            ThreadName = ServerName;
        }
    }
}
