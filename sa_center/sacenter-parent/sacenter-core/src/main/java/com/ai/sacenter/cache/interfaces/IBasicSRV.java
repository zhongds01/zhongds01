package com.ai.sacenter.cache.interfaces;

import com.ai.appframe2.complex.self.po.TableSplit;
import com.ai.appframe2.complex.self.po.TableSplitMapping;
import com.ai.appframe2.complex.tab.split.function.IFunction;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.ISubTableTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.asiainfo.appframe.ext.exeframe.http.query.po.CfgHttpClient;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��������[��������]</p>
 * <p>Copyright: Copyright (c) 2015��9��29��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IBasicSRV extends IDialect{
	/**
	 * ����HTTP�ͻ��˱����ѯHTTP�ͻ�������
	 * @param aHttpClientCode HTTP�ͻ��˱���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public CfgHttpClient getHttpClient( String aHttpClientCode ) throws SFException,Exception;
	/**
	 * ����ö��ֵ�嵥��ѯö��ֵת������
	 * @param fromCatalog ö���嵥,�ö��ŷָ�[��1λö������,��2λ��ʼΪö��ֵ�嵥]
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IEnumWrapper getSFEnumChain( String fromCatalog ) throws SFException,Exception;
	/**
	 * ����ö�������Ͳ�ѯ�ֵ�����Ϣ
	 * @param fromCATEGORY �ֶ�����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IEnumGroup getSFEnumGroup( String fromCATEGORY ) throws SFException,Exception;
	/**
	 * ���ݾ�̬�����Ͳ�ѯ��̬�б���
	 * @param aCATEGORY ��̬������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticCategory getSFStaticCategory( String aCATEGORY ) throws SFException,Exception;
	/**
	 * ���ݾ�̬�����Ͳ�ѯ��̬�б���
	 * @param aGROUP ��̬�����
	 * @param aCATEGORY ��̬������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticGroup getSFStaticGroup( String aGROUP, String aCATEGORY ) throws SFException,Exception;
	/**
	 * ���ݾ�̬������ѯ��̬�б���
	 * @param aGROUP ��̬�����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticGroup getSFStaticGroup( String aGROUP ) throws SFException,Exception; 
	/**
	 * ��ȡ�����ֶ����洢����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticOffer getSFStaticBytes() throws SFException,Exception; 
	/**
	 * ��ѯö��ֵ����
	 * @param aCATEGORY ����
	 * @param aSTATIC ֵ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticOffer getSFStaticOffer( String aCATEGORY, 
			String aSTATIC ) throws SFException,Exception;
	/**
	 * ��ѯö��ֵ����
	 * @param aCATEGORY ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IStaticOffer[] getSFStaticOffer( String aCATEGORY ) throws SFException,Exception;
	/**
	 * ���ݱ������������ͺ͵��б����ѯ���б��ת��������
	 * @param aTABLE ����
	 * @param aCHANNEL ��������
	 * @param aREGION  ���б���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISubTableTemplate.IdGenerator getSFIdGenerator( String aTABLE,
			String aCHANNEL,
			String aREGION ) throws SFException,Exception;
	/**
	 * ���ݵ�����Ų�ѯ���б��ת��������
	 * @param aREGION_NUMBER ͳһ���б���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISubTableTemplate.IdGenerator getSFIdGenerator( String aREGION_NUMBER )  throws SFException,Exception;
	/** 
	 * ����������Ͳ�ѯ��Ӧʵ�ֶ������,�粻���������쳣
	 * @param aIMPLCLASS �������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IImplCapital getSFUpfgkmLibrary( String aIMPLCLASS ) throws SFException, Exception;
	/**
	 * ��ȡ�����־û�����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmGroup getSFUpfgkmComposite( ) throws SFException,Exception;
	/**
	 * �������������ѯ�����־û�����
	 * @param _table_name
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmComposite getSFUpfgkmComposite( String _table_name ) throws SFException,Exception;
	/**
	 * ���ݱ�����ȡ��ǰ���Ӧ�ֱ����
	 * @param fromTableName ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public TableSplit getSFSubTableSplit( String fromTableName ) throws SFException,Exception;
	/**
	 * ���ݱ�����ȡ��ǰ���Ӧ�ֱ���ת������
	 * @param fromTableName ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public TableSplitMapping[] getSFSubTableMapping( String fromTableName ) throws SFException,Exception;
	/**
	 * ���ݷֱ�ת�����ȡ��ǰ���Ӧ��������
	 * @param fromCLASS
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IFunction getSFSubTableChain( String fromCLASS ) throws SFException,Exception;
	/**
	 * ��ȡ��Ԫȫ���ֱ�淶
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISubTableTemplate.ISubSQLCombine getSFSubTableGroup() throws SFException,Exception;
	/**
	 * ������Ԫ�����ѯ��Ԫ�ֱ�淶
	 * @param aPLATFORM ��Ԫ����
	 * @param aTableName ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISubTableTemplate.ISubSQLGroup getSFSubTableGroup( String aPLATFORM ) throws SFException,Exception;
	/**
	 * ������Ԫ�������������ֵ��ѯ��Ԫ������
	 * @param aPLATFORM ��Ԫ����
	 * @param aTABLE ����
	 * @param aCOLUMN ����
	 * @param aVALUE ��ֵ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISubTableTemplate.ISubSQLTableCau getSFSubTableCau( String aPLATFORM, 
			String aTABLE,
			String aCOLUMN , 
			String aVALUE ) throws SFException,Exception;
	/**
	 * ������Ԫ�����·�����Ͳ�ѯ����·��������
	 * @param aPLATFORM ��Ԫ����
	 * @param aCATEGORY ·������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterGroup getSFCenterGroup(String aPLATFORM,
			String aCATEGORY) throws SFException,Exception;
	/**
	 * ����·�ɱ������Ԫ�����ѯ����������Ϣ
	 * @param aROUTE ·�ɱ���
	 * @param aCATEGORY ·������
	 * @param aPLATFORM ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterRoute getSFCenterOffer( String aROUTE,
			String aCATEGORY,
			String aPLATFORM ) throws SFException,Exception;
	/**
	 * ����·�ɱ������Ԫ�����ѯ��Ԫ������Ϣ
	 * @param aROUTE_ID ·�ɱ���
	 * @param aROUTE_TYPE ·������
	 * @param fromUpfm ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterRoute getSFCenterOffer( String aROUTE_ID ,
			String aROUTE_TYPE,
			IPlatformTemplate.IUpffmOffer fromUpfm ) throws SFException, Exception;
	/**
	 * ��ȡ����ͨ����·�ɹ淶
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterRoute[] getSFCenterSubFlow( ) throws SFException, Exception;
	/**
	 * ���ݵ��б����ѯ����ͨ����·����Ϣ
	 * @param aREGION_ID ���б���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterRoute getSFCenterSubFlow( String aREGION_ID ) throws SFException, Exception;
	/**
	 * ���ݵ��б����ѯ����ͨ����·����Ϣ
	 * @param aREGION_NUMBER ���б��
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterRoute getSFCenterSubFlow( long aREGION_NUMBER ) throws SFException, Exception;
	/**
	 * ���������Ԫ��ѯ��Ԫ����ת������
	 * @param aIMPLCLASS ��
	 * @param fromUpfm ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterWrapper getSFCenterWrapper( String aIMPLCLASS , 
			IPlatformTemplate.IUpffmOffer fromUpfm ) throws SFException, Exception;
	/**
	 * ���ݷ����������Ͳ�ѯ��������ת���淶
	 * @param aCATEGORY ������������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterMapping getSFCenterMapping( String aCATEGORY ) throws SFException, Exception;
	/**
	 * ���ݷ������Ͳ�ѯ��������Ŀ¼���ù淶
	 * @param fromGROUP ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterCombine getSFCenterCatalog( String fromGROUP ) throws SFException, Exception;
	/**
	 * ���ݷ�����ͷ����������Ͳ�ѯ��ǰ�������Ӧ��������Ŀ¼
	 * @param aIMPLCLASS ������
	 * @param fromGROUP ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.ICenterCatalog getSFCenterCatalog( String aIMPLCLASS, String fromGROUP ) throws SFException, Exception;
	/**
	 * ����������ѯ���и�Ӳ�����Ϣ
	 * @param orignate ���𷽱���
	 * @param regionId ���б���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmParallel getSFUpfgkmParallel(String orignate,String regionId) throws SFException,Exception;
	/**
	 * ������Դ�����ѯ������Դ�淶
	 * @param resource ��Դ����
	 * @param category ��Դ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmResource getSFUpfgkmResource( String resource, String category ) throws SFException,Exception;
	/**
	 * ���ݺ���͵�������ͺŶ����Ͳ�ѯ�Ŷ���Ϣ
	 * @param fromBILL �û�����
	 * @param fromCATEGORY �Ŷ�����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmOfficeX getSFUpfgkmOffice( String fromBILL,
			String fromCATEGORY) throws SFException,Exception;
	/**
	 * ���ݾ�������ѯ���������Ϣ
	 * @param fromBILL_ID �û�����
	 * @param fromHEADNUM ����Ŷ�
	 * @param fromCATEGORY �Ŷ�����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpfgkmOfficeX getSFUpfgkmOffice( String fromBILL_ID,
			String fromHEADNUM,
			String fromCATEGORY) throws SFException,Exception;
	/**
	 * ����ҵ�������ѯ��ͨ�����������ȼ��淶
	 * @param fromCatalog ҵ�����
	 * @param fromBusines ҵ�����
	 * @param fromBatches �Ƿ�����(1��0��)
	 * @param fromChannel ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsCombine getSFUpdbfsOffer(String fromCatalog,
			String fromBusines,
			String fromBatches,
			String fromChannel) throws SFException,Exception;
	/**
	 * ��ѯ��ͨĬ�����ȼ��淶
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsGroup getSFUpffmxOffer() throws SFException,Exception;
	/**
	 * ���ݷ������ȼ���Ż�ȡ�������ȼ��淶
	 * @param aPRIORITY �������ȼ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsGroup getSFUpffmxOffer( long aPRIORITY ) throws SFException,Exception;
	/**
	 * ����ҵ�����ȼ������ȡ��ͨ��Ԫ�������ȼ��淶
	 * @param aPRIORITY �������ȼ����
	 * @param aPLATFORM ��Ԫ����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ISystemTemplate.IUpdbfsGroup getSFUpffmxOffer( long aPRIORITY,
			String aPLATFORM ) throws SFException,Exception;
}
