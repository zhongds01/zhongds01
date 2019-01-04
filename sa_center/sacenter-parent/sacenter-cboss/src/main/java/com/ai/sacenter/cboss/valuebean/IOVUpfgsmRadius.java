package com.ai.sacenter.cboss.valuebean;

import com.ai.sacenter.cboss.bo.IISARadiusIndex;
import com.ai.sacenter.cboss.bo.ISARadiusIndex;

/**
 * <p>Title: sacenter-cboss</p>
 * <p>Description: 平台测订购关系</p>
 * <p>Copyright: Copyright (c) 2018年4月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfgsmRadius extends IOVUpfgsmRabbit {
	private static final long serialVersionUID = 6564681468462223906L;
	public IOVUpfgsmRadius() throws Exception{
		super();
		_instance = new ISARadiusIndex();
	}

	public IOVUpfgsmRadius(IISARadiusIndex instance) throws Exception{
		super( instance );
	}

	public IOVUpfgsmRadius(IOVUpfgsmRadius provision) throws Exception{
		super( provision );
	}
}
