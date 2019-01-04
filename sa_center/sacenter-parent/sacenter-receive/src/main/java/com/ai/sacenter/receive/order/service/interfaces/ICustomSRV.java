package com.ai.sacenter.receive.order.service.interfaces;

import com.ai.sacenter.SFException;
import com.ai.sacenter.receive.custom.valuebean.IOVCustom;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.util.CarbonList;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ��ͻ����ĶԽ�,���һ������</p>
 * <p>Copyright: Copyright (c) 2016��3��17��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface ICustomSRV {
	/**
	 * �����û���Ų�ѯ�ͻ������û�����
	 * @param aUSER_ID �û����
	 * @param aREGION_ID �û��������б���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFUser( long aUSER_ID, String aREGION_ID ) throws SFException,Exception; 
	/**
	 * ���ݿͻ���Ż�ȡ�ͻ���Ϣ
	 * @param aCUSTOM_ID �ͻ����
	 * @param aCUSTOM_TYPE �ͻ�����
	 * @param aREGION_ID �ͻ��������б���
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVCustom getSFCustom( long aCUSTOM_ID, String aCUSTOM_TYPE, String aREGION_ID ) throws SFException,Exception; 
	/**
	 * ���ݿ�ͨ�û���ѯ�û�������ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�û�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFOffer[] getSFUserOrder( IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ���񶩹���ѯ�û���Ӧ���ܷ��񶩹���ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�û�
	 * @param fromMsgFOffer ��ͨ���񶩹�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFOffer[] getSFUserOrder( IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer) throws SFException,Exception;
	/**
	 * �����û���Ų�ѯ�û�ȫ����Ч������ϵ
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�û�
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFUser getSFUserCentrex( IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser ) throws SFException,Exception;
	/**
	 * ��������ʱ�����Ч���Ϳ�ͨ�û��ʷѰ�
	 * @param fromRequest ��ͨ����
	 * @param fromMsgFUser ��ͨ�û�
	 * @param fromVALID ��Ч����
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVMsgFUser getSFUserCentrex( IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser, int fromVALID ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ��Ʒ��ѯ�ò�Ʒ��Ӧ�û�����
	 * @param fromRequest ��ͨ����
	 * @param fromOffer ��ͨ��Ʒ
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUser getSFOfferUser( IOVMsgFRequest fromRequest, IOVMsgFOffer fromOffer ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ�û��Ƿ�Ϊ��ǰ������������Ա
	 * @param fromUser ��ͨ�û�
	 * @return ��Ϊ����Ϊ������������Ա
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOffer getSFUserVpmnType( IOVMsgFUser fromUser ) throws SFException,Exception;
	/**
	 * ���ݿ�ͨ��Ʒ��ѯ�÷����Ʒ��Ӧʵ���߻�
	 * @param fromUser ��ͨ�û�
	 * @param fromOffer ��ͨ��������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IOVUserOffer getSFGroupOffer( IOVMsgFUser fromUser, IOVMsgFOffer fromOffer ) throws SFException,Exception;
	/**
	 * �����û��б�����û�������Ϣ
	 * @param fromUpdfmx �û��б�
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUserLoad( java.util.Map<String, CarbonList<Long>> fromUpdfmx ) throws SFException,Exception;
	/**
	 * �����û���Ų�ѯԤת���û�
	 * @param fromRequest ��ͨ����
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFCentrexUser( IOVMsgFRequest fromRequest ) throws SFException,Exception;
}
