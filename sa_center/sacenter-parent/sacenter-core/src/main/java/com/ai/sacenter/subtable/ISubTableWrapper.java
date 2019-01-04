package com.ai.sacenter.subtable;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.jdbc.HQSQLEntityBean;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013-4-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ISubTableWrapper {
	/**
	 * ���ݵ�ǰ����Դ��¼ת��ΪĿ��Դ��¼
	 * @param fromBroke ��ǰ�������м�¼
	 * @param fromSubSQL Ŀ���淶
	 * @param aContext
	 * @return ��������[KEY=Ŀ���[���ֱ��־],VALUE=���ݼ�¼�б�(java.util.ArrayList)[Զ�����ݱ��¼]]
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.HashMap transform( HQSQLEntityBean fromBroke,
			ISubSQLOffer fromSubSQL,
			IUpdcContext aContext ) throws SFException,Exception;
}
