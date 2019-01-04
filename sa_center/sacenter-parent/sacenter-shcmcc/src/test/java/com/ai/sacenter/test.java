package com.ai.sacenter;

import com.ai.aif.csf.client.service.factory.CsfServiceCaller;
import com.ai.aif.csf.server.start.CsfStartRemote;
import com.ai.sacenter.receive.OtherFactory;
import com.asiainfo.appframe.ext.exeframe.tf.TfFrameWork;
import com.asiainfo.appframe.ext.exeframe.ws.WsFrameWork;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Think on 2017/8/2.
 */
public class test {

	public test(){
		super();
	}
	
    public static void main(String args[]) throws Exception{
    	System.setProperty( "appframe.server.name", "SA-PROCESS_CSF");
		System.setProperty( "ucmframe.userlog.path", "F:/project/log/");
		System.setProperty( "oracle.jdbc.V8Compatible", "true" );
    	WsFrameWork.main( new String[]{"crm_open4pboss"});
    }


    public static void startTF_ROCKET(String args[]) throws Exception{
        TfFrameWork.main(args);
    }

    public static void startCSF_SERVER(String args[])throws Exception{
        CsfStartRemote.main(args);
    }

    public static void testPceImpl() throws Exception{
        try{
            Object aaa = OtherFactory.getIProductSV().getProductItemById( 191000000117l );
            System.out.println( aaa );
        }
        finally {

        }
    }

    public static void startCSF_CLIENT(String args[])throws Exception{
        Map   a = new HashMap();
        a.put("input","Hello World");
        Object backObject = CsfServiceCaller.call(new Object[]{"open_ISHUpdcCSV_orderReceive", "HelloWorld"});
        System.out.println(backObject);
    }
}
