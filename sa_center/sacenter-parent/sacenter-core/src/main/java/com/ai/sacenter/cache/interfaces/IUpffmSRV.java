package com.ai.sacenter.cache.interfaces;

import com.ai.aif.csf.common.exception.CsfException;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IUpfgsmTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ����[��������]</p>
 * <p>Copyright: Copyright (c) 2015��10��6��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpffmSRV extends IDialect {
	/**
	 * ��ȡ��ͨϵͳ��Ԫ�淶
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOffer getSFUpffmOffer() throws SFException, Exception;
	/**
	 * ����ƽ̨��Ų�ѯƽ̨��������
	 * @param fromPLATFORM ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOffer getSFUpffmOffer(String fromPLATFORM) throws SFException, Exception;
	/**
	 * ����ƽ̨��Ų�ѯ��Ԫ��·����
	 * @param fromPLATFORM ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmNetWork getSFUpffmNetWork(String fromPLATFORM) throws SFException, Exception;
	/**
	 * ��ѯ������Ԫƽ̨
	 * @param fromPLATFORM ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOffer[] getSFUpffmParent( String fromPLATFORM ) throws SFException,Exception;
	/**
	 * ��ѯ�Ӽ���Ԫƽ̨
	 * @param fromPLATFORM ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOffer[] getSFUpffmChild( String fromPLATFORM ) throws SFException,Exception;
	/**
	 * ����ƽ̨���������ѯƽ̨��������
	 * @param fromOPERATE ��Ԫ��������
	 * @param fromUpffm ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOperate getSFUpffmOperate(String fromOPERATE, 
			IPlatformTemplate.IUpffmOffer fromUpffm) throws SFException, Exception;
	/**
	 * �����߼�ָ������ѯ�߼���������
	 * @param fromDIRECTIVE �߼�ָ�����
	 * @param fromPLATFORM �߼���Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmOperate getSFUpffmOperate( String fromDIRECTIVE,
			String fromPLATFORM )  throws SFException, Exception;
	/**
	 * ����ָ���Ų�ѯ��ָ���
	 * @param fromDIRECTIVE ��Ԫָ�����
	 * @param fromUpffm ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmDirective getSFUpffmLogical( String fromDIRECTIVE, 
			IPlatformTemplate.IUpffmOffer fromUpffm) throws SFException, Exception;
	/**
	 * ������ָ�����̺���Ԫ��ѯ��ָ���
	 * @param fromSUBFLOW �������̱���
	 * @param aPLATFORM ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffbpmOffer getSFUpffmSubFlow( String fromSUBFLOW, 
			IPlatformTemplate.IUpffmOffer fromUpffm) throws SFException, Exception;
	/**
	 * ������Ԫģ������ѯģ�嶨����Ϣ
	 * @param fromPROTOCOL ģ�����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmProtocol getSFUpffmProtocol( String fromPROTOCOL ) throws SFException, Exception;
	/**
	 * ��ѯ�û���������·��
	 * @param fromBILL �û�����
	 * @param fromUpffm ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmPhone getSFUpffmPhone( String fromBILL , 
			IPlatformTemplate.IUpffmOffer fromUpffm ) throws SFException, Exception;
	/**
	 * ��ѯ��Ԫ����ģ�ⱨ��
	 * @param fromDIRECTIVE ָ�����
	 * @param fromPLATFORM ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmDebuging  getSFUpffmDebug( String fromDIRECTIVE , 
			String fromPLATFORM ) throws SFException,Exception;
	/**
	 * ����ӳ�伯�����ѯӳ�伯��Ϣ
	 * @param fromMODULE ӳ�伯����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffsmOffer getSFUpffsmOffer( String fromMODULE ) throws SFException,Exception;
	/**
	 * ������Ԫ���Ͳ�ѯ��Ԫ������չ�淶
	 * @param fromMODULE ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IUpfgsmTemplate.IUpfgsmOffer getSFUpfgsmMisc( String fromMODULE ) throws SFException, Exception;
	/**
	 * ��ѯ���񼤻����������Զ���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map getSFUpffxOffer( ) throws SFException, Exception;
	/**
	 * ������Ԫ�����ѯ��Ԫ���Զ���
	 * @param fromPLATFORM ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public java.util.Map getSFUpffxOffer( String fromPLATFORM ) throws SFException, Exception; 
	/**
	 * ������Ԫ��������Ա����ѯ��Ԫ���Զ���
	 * @param fromFEATURE ��Ԫ���Ա���
	 * @param fromPLATFORM ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffxOffer getSFUpffxOffer( String fromFEATURE , 
			String fromPLATFORM ) throws SFException, Exception; 
	/**
	 * ������Ԫ�����ѯ�������淶��
	 * @param _platform ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsGroup getSFUpffmsGroup( String _platform) throws SFException, Exception;
	/**
	 * ���ݷ��������ѯ�������淶
	 * @param _coding ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( String _coding ) throws SFException, Exception;
	/**
	 * ���ݷ��������������Ԫ��ѯͳһ��������
	 * @param _coding ��������
	 * @param _platform ������Ԫ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer(String _coding,
			String _platform) throws SFException, Exception;
	/**
	 * ���ݷ������������ָ������ѯ��ܷ�������
	 * @param _coding   ��������
	 * @param _category ��������
	 * @param _platform ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( String _coding , 
			String _category, 
			String _platform ) throws SFException, Exception;
	/**
	 * �����쳣���ͻ�ȡ�쳣����淶����
	 * @param _exception �쳣����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( SFException _exception ) throws SFException, Exception;
	/**
	 * �����쳣���ͻ�ȡ�쳣����淶����
	 * @param _exception �쳣����
	 * @param _category ��������
	 * @param _platform ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( SFException _exception,
			String _category,
			String _platform ) throws SFException, Exception;
	/**
	 * �����쳣���ͻ�ȡ�쳣����淶����
	 * @param _exception �쳣����
	 * @param _platform ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( CsfException _exception,
			String _platform ) throws SFException, Exception;
	/**
	 * �����쳣���ͻ�ȡ�쳣����淶����
	 * @param _exception �쳣����
	 * @param _category ��������
	 * @param _platform ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsOffer getSFUpffmsOffer( CsfException _exception,
			String _category,
			String _platform ) throws SFException, Exception;
	/**
	 * ���ݷ������������ָ������ѯ��ܷ������ඨ��
	 * @param _coding ��������
	 * @param _category ��������
	 * @param fromPLATFORM ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IPlatformTemplate.IUpffmsCatalog getSFUpffmsCatalog( String _coding , 
			String _category, 
			String _platform ) throws SFException, Exception;
}
