package com.ai.sacenter.comptel.bo;

import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer;
import com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务能力订购</p>
 * <p>Copyright: Copyright (c) 2015年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IOVUpdcpOffer {
	/**
	 * @return 服务能力编号
	 */
	public long getCOMPETE();
	
	/**
	 * @param cOMPETE 服务能力编号
	 */
	public void setCOMPETE(long cOMPETE);
	
	/**
	 * @return 服务产品编号
	 */
	public long getPRODUCT();
	
	/**
	 * @param pRODUCT 服务产品编号
	 */
	public void setPRODUCT(long pRODUCT);
	
	/**
	 * @return 服务属性值
	 */
	public String getCOMPTEL();
	
	/**
	 * @param cOMPTEL 服务属性值
	 */
	public void setCOMPTEL(String cOMPTEL);
	
	/**
	 * 服务流程编码
	 * @return
	 */
	public String getSUBFLOW();
	
	/**
	 * @return 服务映射规范
	 */
	public IUpfgsmOffer getCATALOG();
	
	/**
	 * @param cATALOG 服务映射规范
	 */
	public void setCATALOG(IUpfgsmOffer cATALOG);
	
	/**
	 * @return 服务产品
	 */
	public IProductOffer getPROVIDER();
	
	/**
	 * 
	 * @param pROVIDER 服务产品
	 */
	public void setPROVIDER( IProductOffer pROVIDER );
	
	/**
	 * @return 服务能力属性
	 */
	public java.util.Map getCOMPLEX();
}
