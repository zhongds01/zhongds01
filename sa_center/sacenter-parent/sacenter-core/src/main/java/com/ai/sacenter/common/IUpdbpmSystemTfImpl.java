package com.ai.sacenter.common;

import com.asiainfo.appframe.ext.exeframe.tf.interfaces.IAdvanceTransform;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: TF����ת��[ԭ��/��ʷ��/Ŀ���[����ͨ]][·������δ����]</p>
 * <p>Copyright: Copyright (c) 2016��3��2��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpdbpmSystemTfImpl extends UpdbcSystemTfImpl implements IAdvanceTransform{
	public IUpdbpmSystemTfImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.asiainfo.appframe.ext.exeframe.tf.interfaces.IAdvanceTransform#destFinish(java.util.HashMap[])
	 */
	public void destFinish(java.util.HashMap[] fromUpdbm) throws Exception {
		
	}
	
	/* (non-Javadoc)
	 * @see com.asiainfo.appframe.ext.exeframe.tf.interfaces.IAdvanceTransform#hisFinish(java.util.HashMap[])
	 */
	public void hisFinish(java.util.HashMap[] fromUpdbm) throws Exception {
		
	}
	
	/* (non-Javadoc)
	 * @see com.asiainfo.appframe.ext.exeframe.tf.interfaces.IAdvanceTransform#isSelfDestFinish()
	 */
	public boolean isSelfDestFinish() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.asiainfo.appframe.ext.exeframe.tf.interfaces.IAdvanceTransform#isSelfHisFinish()
	 */
	public boolean isSelfHisFinish() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.asiainfo.appframe.ext.exeframe.tf.interfaces.IAdvanceTransform#isSelfSrcFinish()
	 */
	public boolean isSelfSrcFinish() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.asiainfo.appframe.ext.exeframe.tf.interfaces.IAdvanceTransform#srcFinish(java.util.HashMap[])
	 */
	public void srcFinish(java.util.HashMap[] fromUpdbm) throws Exception {
		
	}
}
