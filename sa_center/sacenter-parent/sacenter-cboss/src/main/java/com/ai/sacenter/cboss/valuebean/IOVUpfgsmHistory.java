package com.ai.sacenter.cboss.valuebean;

import com.ai.sacenter.provision.bo.IISAProvision;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;

/**
 * 
 * <p>Title: sacenter-cboss</p>
 * <p>Description: ��CBOSS����ʷ</p>
 * <p>Copyright: Copyright (c) 2018��5��23��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public class IOVUpfgsmHistory extends IOVUpfwmOffer implements java.io.Serializable{
	private static final long serialVersionUID = -1125675926642854969L;
	public IOVUpfgsmHistory( IISAProvision provision ) throws Exception{
		super( provision );
	}
	
	public IOVUpfgsmHistory( IOVUpfgsmHistory provision ) throws Exception{
		super( provision );
	}

}
