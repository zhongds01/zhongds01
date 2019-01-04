package com.ai.sacenter.comptel;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务能力级映射规范</p>
 * <p>Copyright: Copyright (c) 2015年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcpSystem {
	/**
	 * 服务能力产品级映射规范
	 * @param fromUpfgsm 映射规范
	 * @param fromUser 用户请求
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer[] finishSFUpfgsmc( IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm, 
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 服务能力级属性映射检验规范
	 * @param fromUpdbcpm 服务能力集
	 * @param fromUpfgsm 服务映射规范
	 * @param fromUpdcpm 服务能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgsmc( IProfessionalTemplate.IProductOffer fromUpdbcpm,
			IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm,
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 服务能力级属性映射检验规范
	 * @param fromUpdbcpm 服务能力集
	 * @param fromUpfgsm 服务映射规范
	 * @param fromUpdcpm 服务能力
	 * @param aContext
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgsmc( IProfessionalTemplate.IProductOffer fromUpdbcpm,
			IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm,
			IOVUpdcpOffer fromUpdcpm,
			IUpdcContext aContext ) throws SFException,Exception;
	/**
	 * 服务能力属性级映射规范
	 * @param fromUpfgsm 映射规范
	 * @param fromUser 用户请求
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUpdcpOffer finishSFUpfgsmc( IProfessionalTemplate.IUpdbfgsmxOffer fromUpfgsm, 
			IOVOrderUser fromUser,
			IUpdcContext aContext ) throws SFException,Exception;
}
