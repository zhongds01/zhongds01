package com.ai.sacenter.receive.order.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.receive.UpdbfsFactory;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.dbcp.IBusinesCapital;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmMiscHome;
import com.ai.sacenter.receive.util.UpdbfsUtils;
import com.ai.sacenter.receive.util.UpdbfxUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVUpffmxRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ���ڿ�ͨ������չ��</p>
 * <p>Copyright: Copyright (c) 2016��3��24��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ICustomCapitalImpl extends UpdcEclipseImpl implements IBusinesCapital {
	public ICustomCapitalImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: ���ڿ�ͨ�����û�ת���û�����</p>
	 * <p>Copyright: Copyright (c) 2017��3��7��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdffmxCustomImpl extends  ICustomCapitalImpl{
		public IUpdffmxCustomImpl(){
			super();
		}
		/**
		 * 
		 * <p>Library: IUpdffmxDefaultImpl</p>
		 * <p>Description: ��ͨ�û�Ԥת�����[��ͨ����������]</p>
		 * @param fromRequest ��ͨ����
		 * @param fromUpdcpm ��ͨ��������
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFMetaMXDefaultImpl(IOVMsgFRequest fromRequest, 
				IUpfgkmOfferHome fromUpdcpm,
	            IUpdcContext aContext) throws SFException, Exception{
			try
			{
				
			}
			finally{
				
			}
		}
		/**
		 * ��ͨ�û�Ԥת�����[��ͨ����������]
		 * <p>Library: IUpdffmxCustomImpl</p>
		 * <p>Description: ��ͨ�û�Ԥת�����[��ͨ����������]</p>
		 * @param fromRequest ��ͨ����
		 * @param fromUpdcpm ��ͨ��������
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFMetaMXUserImpl(IOVMsgFRequest fromRequest, 
				IUpfgkmOfferHome fromUpdcpm,
	            IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOrderFactory.getICustomSV().finishSFCentrexUser( fromRequest );
			}
			finally{
			
			}
		}
	}
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: ���ڿ�ͨ������չ��</p>
	 * <p>Copyright: Copyright (c) 2018��2��28��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author huiyu
	 * @version 3.0
	 */
	public static class IUpdffvmCustomImpl extends ICustomCapitalImpl{
		public IUpdffvmCustomImpl(){
			super();
		}
		
		/**
		 * ��ͨ����Ĭ����չ�ʲ�[�ֻ����][GSM]
		 * <p>Library: IUpdffvmDefaultImpl</p>
		 * <p>Description: ��ͨ����Ĭ����չ�ʲ�</p>
		 * @param fromRequest ��ͨ����
		 * @param IOVOrderUser ��ͨ�û�
		 * @param fromUpdcpm ��ͨ��������
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public void finishSFUpdfvmDefault(IOVMsgFRequest fromRequest,
				IOVOrderUser fromOrdUser,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext) throws SFException,Exception{
			try
			{
				
			}
			finally{
				
			}
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-receive</p>
	 * <p>Description: ���ڷ����Ʒ��չ��</p>
	 * <p>Copyright: Copyright (c) 2017��3��15��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbfxCustomImpl extends ICustomCapitalImpl{
		public IUpdbfxCustomImpl(){
			super();
		}
		
		/**
		 * �û�����������[�ֻ����][GSM]
		 * <p>Library: IUpdbfxUcm2MiscImpl</p>
		 * <p>Description: ���ݿ�ͨ��Ʒ��ȡ�����Ʒ���Ӧ������</p>
		 * @param fromRequest ��ͨ����
		 * @param fromMsgFOffer ��ͨ�����Ʒ
		 * @param fromUpffmx ��ͨ������
		 * @param fromUpdcpm ��ͨ��������
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2MiscImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			IUpfgkmMiscHome fromUpfgkmHome = null;
			try
			{
				/*SPID��ҵ����BIZCODEҵ�����BILLFLG�Ʒ�����GLOBAL���ݼƷ�[G��L��]SERVTYPEҵ������*/
				fromUpfgkmHome = UpdbfsFactory.getIProductSV().getUpSpInfoByProdId( fromMsgFOffer.getPRODUCT_ID() );
				if( fromUpfgkmHome == null || fromUpfgkmHome.getOFFER() == null || fromUpfgkmHome.getOFFER().size() <= 0 ){
					fromUpdfmx.getORDER().getORDER().add( UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer) );
				}
				else{
					for( java.util.Iterator<IUpfgkmMiscHome.IUpfgkmOfferHome> itera = fromUpfgkmHome.getOFFER().iterator(); itera.hasNext(); ){
						IUpfgkmMiscHome.IUpfgkmOfferHome fromOfferHome = (IUpfgkmMiscHome.IUpfgkmOfferHome)itera.next();
						IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
						UpdbfxUtils.ICustom._mergeAsSpInfo(fromRequest, 
								fromNature, 
								fromOfferHome, 
								fromUpdfmx, 
								aContext);
						fromUpdfmx.getORDER().getORDER().add( fromNature );
					}
				}
			}
			finally{
				if( fromUpfgkmHome != null ){ fromUpfgkmHome = null; }
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
		
		/**
		 * �û�����������[�ֻ����][GSM]
		 * <p>Library: IUpdbfxUcm2LmscImpl</p>
		 * <p>Description: ���ݿ�ͨ��Ʒ��ȡ�����Ʒ���Ӧ������</p>
		 * @param fromRequest ��ͨ����
		 * @param fromMsgFOffer ��ͨ�����Ʒ
		 * @param fromUpffmx ��ͨ������
		 * @param fromUpdcpm ��ͨ��������
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2LmscImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			IUpfgkmMiscHome fromUpfgkmHome = null;
			try
			{
				/*SPID��ҵ����BIZCODEҵ�����BILLFLG�Ʒ�����GLOBAL���ݼƷ�[G��L��]SERVTYPEҵ������*/
				fromUpfgkmHome = UpdbfsFactory.getIProductSV().getSpInfoByProdId( fromMsgFOffer.getPRODUCT_ID() );
				if( fromUpfgkmHome == null || fromUpfgkmHome.getOFFER() == null || fromUpfgkmHome.getOFFER().size() <= 0 ){
					fromUpdfmx.getORDER().getORDER().add( UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer) );
				}
				else{
					for( java.util.Iterator<IUpfgkmMiscHome.IUpfgkmOfferHome> itera = fromUpfgkmHome.getOFFER().iterator(); itera.hasNext(); ){
						IUpfgkmMiscHome.IUpfgkmOfferHome fromOfferHome = (IUpfgkmMiscHome.IUpfgkmOfferHome)itera.next();
						IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
						UpdbfxUtils.ICustom._mergeAsSpInfo(fromRequest, 
								fromNature, 
								fromOfferHome, 
								fromUpdfmx, 
								aContext);
						fromUpdfmx.getORDER().getORDER().add( fromNature );
					}
				}
			}
			finally{
				if( fromUpfgkmHome != null ){ fromUpfgkmHome = null; }
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
		
		/**
		 * �û�����ȫ�����Թ淶[�ֻ����][GSM]
		 * <p>Library: IUpdbfxUcm2LbfxImpl</p>
		 * <p>Description: ���ݿ�ͨ��Ʒ��ȡ�����Ʒ���Ӧȫ������</p>
		 * @param fromRequest ��ͨ����
		 * @param fromMsgFOffer ��ͨ�����Ʒ
		 * @param fromUpffmx ��ͨ������
		 * @param fromUpdcpm ��ͨ��������
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2LbfxImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			try
			{
				IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
				IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromNature.getUSER_ID() );
				if( fromNature.isORDER() ){
					UpdbfxUtils.ICustom._mergeAsGroup(fromRequest, 
							fromMsgFUser, 
							fromNature, 
							fromUpdfmx, 
							aContext);
				}
				fromUpdfmx.getORDER().getORDER().add( fromNature );
			}
			finally{
				
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
		
		/**
		 * �û������������Գ�Ա�淶[�ֻ����][GSM]
		 * <p>Library: IUpdbfxUcm2PLMXImpl</p>
		 * <p>Description: ���ݿ�ͨ��Ʒ��ȡ�������Գ�Ա�淶</p>
		 * @param fromRequest ��ͨ����
		 * @param fromMsgFOffer ��ͨ�����Ʒ
		 * @param fromUpffmx ��ͨ������
		 * @param fromUpdcpm ��ͨ��������
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2PLMXImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			IOVUpdfmxOffer fromAsGroup = null;
			try
			{
				IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
				IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromNature.getUSER_ID() );
				if( fromNature.isORDER() ){
					fromAsGroup = UpdbfxUtils.ICustom._mergeAsMultle(fromRequest, 
							fromNature, 
							fromUpdfmx, 
							aContext);
					for( java.util.Iterator<IOVMsgFOffer> itera = fromAsGroup.getORDER().getORDER().iterator(); itera.hasNext(); ){
						IOVMsgFOffer fromAsOffer = (IOVMsgFOffer)itera.next();
						fromUpdfmx.getORDER().getORDER().add( fromAsOffer );
					}
					UpdbfxUtils.ICustom._mergeAsGroup(fromRequest, 
							fromMsgFUser, 
							fromNature, 
							fromUpdfmx, 
							aContext);
				}
				fromUpdfmx.getORDER().getORDER().add( fromNature );
			}
			finally{
				if( fromAsGroup != null ){ fromAsGroup = null; }
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
		
		/**
		 * ���ų�Ա�������Ź淶[�ֻ����][GSM]
		 * <p>Library: IUpdbfxVGL2PLAXImpl</p>
		 * <p>Description:���ݼ��ų�Ա��ѯ���ŷ����Ʒ</p>
		 * @param fromRequest ��ͨ����
		 * @param fromMsgFOffer ��ͨ�����Ʒ
		 * @param fromUpffmx ��ͨ������
		 * @param fromUpdcpm ��ͨ��������
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishVGL2PLAXImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			try
			{
				IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
				IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromNature.getUSER_ID() );
				if( fromMsgFOffer.isORDER() /*�����û���ɫ*/){
					UpdbfxUtils.ICustom._mergeAsGroup(fromRequest, 
							fromMsgFUser, 
							fromNature, 
							fromUpdfmx, 
							aContext);
				}
				fromUpdfmx.getORDER().getORDER().add( fromNature );
			}
			finally{
			
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
		
		/**
		 * ���ų�Ա���������ݹ淶[�ֻ����][GSM]
		 * <p>Library: IUpdbfxVGL2MiscImpl</p>
		 * <p>Description:���ݼ��ų�Ա�����Ʒ���Ӧ������</p>
		 * @param fromRequest ��ͨ����
		 * @param fromMsgFOffer ��ͨ�����Ʒ
		 * @param fromUpffmx ��ͨ������
		 * @param fromUpdcpm ��ͨ��������
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishVGL2MiscImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			IUpfgkmMiscHome fromUpfgkmHome = null;
			try
			{
				IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
				fromUpfgkmHome = UpdbfsFactory.getIProductSV().getUpSpInfoByProdId( fromMsgFOffer.getPRODUCT_ID() );
				if( fromUpfgkmHome == null || fromUpfgkmHome.getOFFER() == null || fromUpfgkmHome.getOFFER().size() <= 0 ){
					IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
					UpdbfxUtils.ICustom._mergeAsGroup(fromRequest, 
							fromMsgFUser, 
							fromNature, 
							fromUpdfmx, 
							aContext);
					fromUpdfmx.getORDER().getORDER().add( fromNature );
				}
				else{
					for( java.util.Iterator<IUpfgkmMiscHome.IUpfgkmOfferHome> itera = fromUpfgkmHome.getOFFER().iterator(); itera.hasNext(); ){
						IUpfgkmMiscHome.IUpfgkmOfferHome fromOfferHome = (IUpfgkmMiscHome.IUpfgkmOfferHome)itera.next();
						IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer);
						UpdbfxUtils.ICustom._mergeAsSpInfo(fromRequest, 
								fromNature, 
								fromOfferHome, 
								fromUpdfmx, 
								aContext);
						UpdbfxUtils.ICustom._mergeAsGroup(fromRequest, 
								fromMsgFUser, 
								fromNature, 
								fromUpdfmx, 
								aContext);
						fromUpdfmx.getORDER().getORDER().add( fromNature );
					}
				}
			}
			finally{
				if( fromUpfgkmHome != null ){ fromUpfgkmHome = null; }
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER( IOVMsgFOffer.class );
		}
	}
}
