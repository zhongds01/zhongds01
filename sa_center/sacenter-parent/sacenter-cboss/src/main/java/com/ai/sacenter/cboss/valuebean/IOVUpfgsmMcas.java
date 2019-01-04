package com.ai.sacenter.cboss.valuebean;

import com.ai.sacenter.cboss.bo.IISAMcasIndex;
import com.ai.sacenter.cboss.bo.ISAMcasIndex;

/**
 * <p>Title: sacenter-cboss</p>
 * <p>Description: 内容计费</p>
 * <p>Copyright: Copyright (c) 2018年4月17日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpfgsmMcas extends IOVUpfgsmRabbit {
	private static final long serialVersionUID = -8437409055564880874L;
	public IOVUpfgsmMcas() throws Exception{
		super();
		_instance = new ISAMcasIndex();
	}

	public IOVUpfgsmMcas(IISAMcasIndex instance) throws Exception{
		super( instance );
	}

	public IOVUpfgsmMcas(IOVUpfgsmMcas provision) throws Exception{
		super( provision );
	}
}
