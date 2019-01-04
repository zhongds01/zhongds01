package com.ai.sacenter.receive.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.UpdbfsFactory;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmItemHome;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmMiscHome;
import com.ai.sacenter.receive.valuebean.IOVMsgFCustom;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOfferX;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserOffer;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.IBeanWrapper;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.MathUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: ����ͨ��չ����</p>
 * <p>Copyright: Copyright (c) 2017��4��25��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdbfxUtils {
	private final static Log log = LogFactory.getLog( UpdbfxUtils.class );
	public UpdbfxUtils() {
		super();
	}
	public static class ICustom{
		public ICustom(){
			super();
		}
		
		/**
		 * ��ǰ�û��ⶩ�����Ժϲ�����ǰ���񶩹���
		 * @param fromRequest ��ͨ����
		 * @param fromMsgFUser ��ͨ�û�
		 * @param fromMsgFOffer ��ͨ����
		 * @param fromUpdfmx ��ǰ���񶩹�
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _mergeAsFuture( IOVMsgFRequest fromRequest,
				IOVMsgFUser fromMsgFUser,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpdfmxOffer fromUpdfmx, 
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOVMsgFUserOffer fromUserOffer = fromMsgFUser.getUserOffer( fromMsgFOffer.getINS_PROD_ID(), fromMsgFOffer.getSERVICE_ID() );
				if( fromUserOffer != null ){
					for( java.util.Iterator<IOVMsgFOfferX> itera = fromUserOffer.getFUTURE().iterator(); itera.hasNext(); ){
						IOVMsgFOfferX fromUserOfferX = (IOVMsgFOfferX)itera.next();
						if( fromMsgFOffer.getFUTURE( fromUserOfferX.getATTR_ID() ) == null ){
							IOVMsgFOfferX fromOrdOfferX = new IOVMsgFOfferX( fromUserOfferX );
							fromOrdOfferX.setSTATUS( IUpdbfsConst.IState.IOrder.S05 );
							fromMsgFOffer.getFUTURE().add( fromOrdOfferX );
						}
					}
				}
			}
			finally{
				
			}
		}
		
		/**
		 * ��Ʒ���������ӵ���ǰ���񶩹���
		 * @param fromRequest ��ͨ����
		 * @param fromMsgFOffer ��ͨ����
		 * @param fromUpfgkmHome ��Ʒ������
		 * @param fromUpdfmx ��ǰ���񶩹�
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _mergeAsSpInfo( IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IUpfgkmMiscHome.IUpfgkmOfferHome fromUpfgkmHome,
				IOVUpdfmxOffer fromUpdfmx, 
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "PRODUCT_ID", fromUpfgkmHome.getPRICE_ID() ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "PRICE_ID"  , fromUpfgkmHome.getPLAN_ID () ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "EFFECTIVE" , fromMsgFOffer.getEFFECTIVE() ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "EXPIRE"    , fromMsgFOffer.getEXPIRE   () ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "SERVTYPE"  , fromUpfgkmHome.getSERVTYPE() ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "SPID"      , fromUpfgkmHome.getSPID    () ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "BIZCODE"   , fromUpfgkmHome.getBIZCODE () ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "BILLFLG"   , fromUpfgkmHome.getBILLFLG () ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "PRODFLG"   , fromUpfgkmHome.getPRODFLG () ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "PLATFLG"   , fromUpfgkmHome.getPLATFLG () ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "GLOBAL"    , fromUpfgkmHome.getGLOBAL  () ) );
				
			}
			finally{
				
			}
		}
		
		/**
		 * Ⱥ���û�[�����ͻ�]��������/�û��ⶩ���������ӵ���ǰ���񶩹���
		 * @param fromRequest ��ͨ����
		 * @param fromMsgFUser ��ͨ�û�
		 * @param fromMsgFOffer ��ͨ����
		 * @param fromUpdfmx ��ǰ���񶩹�
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _mergeAsGroup( IOVMsgFRequest fromRequest,
				IOVMsgFUser fromMsgFUser,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpdfmxOffer fromUpdfmx, 
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IProfessionalTemplate.IProductGroup fromDepend = null;
				IProfessionalTemplate.IBusinesCatalog fromUpdcpm = UpdbfxUtils.ISystem.getPROGRAM( aContext );
				String fromGroupDepend = fromUpdcpm != null?(String)fromUpdcpm.getSUBFLOW( IUpdbfsConst.IUpdbm.IProduct.PROGRAM_DEPEND_MEMBER ):null;
				IOVMsgFUser fromGroup = fromRequest.getUSER( fromRequest.getUSER_ID() );
				ICustom._mergeAsFuture (fromRequest, fromMsgFUser, fromMsgFOffer, fromUpdfmx, aContext);
				ICustomX._jj_AsExtInfo(fromRequest, fromMsgFUser, fromMsgFOffer, fromUpdfmx, aContext);
				if( fromGroup != null && fromGroup.isGROUP() ){
					ICustom._mergeAsGroup(fromRequest, fromMsgFOffer, fromGroup, fromUpdfmx, aContext);
					if( fromMsgFUser.isMEMBER() && fromGroup.isGROUP()  ){
						if( StringUtils.isBlank( fromGroupDepend ) /*Ĭ�ϳ�Աȫ������Ⱥ��*/){
							ICustom._mergeAsDepend(fromRequest, 
									fromMsgFUser, 
									fromGroup, 
									fromUpdfmx, 
									aContext);
						}
						else{
							fromDepend = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpGroup( fromGroupDepend );
							if( fromDepend == null || fromDepend.getSUBFLOW().size() <= 0 /*Ĭ�ϳ�Աȫ������Ⱥ��*/ ){
								ICustom._mergeAsDepend(fromRequest, 
										fromMsgFUser, 
										fromGroup, 
										fromUpdfmx, 
										aContext);
							}
							else/*����ָ���Ա��������Ⱥ�������*/{
								ICustom._mergeAsDepend(fromRequest, 
										fromMsgFUser, 
										fromMsgFOffer, 
										fromGroup, 
										fromDepend, 
										fromUpdfmx, 
										aContext);
							}
						}
					}
				}
			}
			finally{
				
			}
		}
		
		/**
		 * Ⱥ���û�[�����ͻ�]�����������ӵ���ǰ���񶩹���
		 * @param fromRequest ��ͨ����
		 * @param fromMsgFOffer ��ͨ����
		 * @param fromGroup �����û�
		 * @param fromUpdfmx ��ǰ���񶩹�
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVMsgFOffer _mergeAsGroup(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVMsgFUser fromGroup,
				IOVUpdfmxOffer fromUpdfmx, 
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX    ( "GROUP_USERID"  , fromGroup.getUSER_ID     () ) );
				fromMsgFOffer.getFUTURE().add( ICustomX._jj_compete ( "GROUP_CATALOG" , fromGroup.getCATALOG     () ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX    ( "GROUP_BILLID"  , fromGroup.getBILL_ID     () ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX    ( "GROUP_SUBBILL" , fromGroup.getSUB_BILL_ID () ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX    ( "GROUP_CITYID"  , fromGroup.getREGION_ID   () ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX    ( "GROUP_COUNTRY" , fromGroup.getCOUNTRY_CODE() ) );
				fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX    ( "GROUP_USERTYPE", fromGroup.getUSER_TYPE   () ) );
				ICustomX._jj_groupUser   ( fromRequest, fromMsgFOffer, fromGroup , aContext );
				if( fromGroup.getCUSTOM() != null ){
					IOVMsgFCustom fromMsgFCust = fromGroup.getCUSTOM();
					fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "GROUP_ID"     , fromMsgFCust.getCUST_CODE  () ) );
					fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "GROUP_CUSTID" , fromMsgFCust.getCUST_ID    () ) );
					fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "GROUP_NAME"   , fromMsgFCust.getCUST_NAME  () ) );
					fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "GROUP_TYPE"   , fromMsgFCust.getCUST_TYPE  () ) );
					ICustomX._jj_groupCustom( fromRequest, fromMsgFOffer, fromGroup.getCUSTOM(), aContext );
				}
			}
			finally{
			
			}
			return fromMsgFOffer;
		}
		
		/**
		 * ���ݷ������Գ�Աת��Ϊ�������Գ�Ա����
		 * @param fromRequest ��ͨ����
		 * @param fromMember ��Ա�û�
		 * @param fromGroup �����û�
		 * @param fromUpdfmx ��ǰ���񶩹�
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdfmxOffer _mergeAsMultle(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpdfmxOffer fromUpdfmx, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromAsGroup = new IOVUpdfmxOffer( fromRequest );
			IOVUpdfmxOffer fromGroup = null;
			try
			{
				fromGroup = ICustomX._jj_lifite(fromRequest, fromMsgFOffer, aContext);
				for( java.util.Iterator<IOVMsgFOfferX> itera = fromGroup.getORDER().getORDER().iterator(); itera.hasNext(); ){
					IOVMsgFOfferX fromMsgFOfferX = (IOVMsgFOfferX)itera.next();
					IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap(fromRequest, fromMsgFOffer, fromMsgFOfferX);
					java.util.Map<String,String> fromAsLifite = ICustomX._jj_lifite(fromRequest, fromMsgFOfferX, aContext);
					for( java.util.Iterator<java.util.Map.Entry<String,String>> iterap = fromAsLifite.entrySet().iterator(); iterap.hasNext(); ){
						java.util.Map.Entry<String,String> fromEntry = (java.util.Map.Entry<String,String>)iterap.next();
						if( fromEntry.getValue() == null ){ continue; }
						IOVMsgFOfferX fromOfferX = new IOVMsgFOfferX( (String)fromEntry.getKey(), 
								(String)fromEntry.getValue() );
						fromNature.getFUTURE().add( fromOfferX );
					}
					ClassUtils.IMerge.merge( fromAsGroup.getORDER().getFUTURE(), fromNature.getFUTURE() );
					fromAsGroup.getORDER().getORDER().add( fromNature );
				}
			}
			finally{
				if( fromGroup != null ){ fromGroup = null; }
			}
			return fromAsGroup;
		}
				
		/**
		 * Ⱥ���û����񶩹����ӵ���ǰ���񶩹���
		 * @param fromRequest ��ͨ����
		 * @param fromMember ��Ա�û�
		 * @param fromGroup �����û�
		 * @param fromUpdfmx ��ǰ���񶩹�
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _mergeAsDepend( IOVMsgFRequest fromRequest,
				IOVMsgFUser fromMember,
				IOVMsgFUser fromGroup,
				IOVUpdfmxOffer fromUpdfmx, 
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOVMsgFOffer fromOrdOffer[] = IOrderFactory.getICustomSV().getSFUserOrder( fromRequest, fromGroup );
				for( int index = 0; fromOrdOffer != null && index < fromOrdOffer.length; index++ ){
					IOVMsgFOffer fromUserOffer = ICustomX._jj_depend(fromRequest, 
							fromGroup, 
							fromOrdOffer[index], 
							fromUpdfmx, 
							aContext);
					fromUpdfmx.getORDER().getORDER().add( fromUserOffer );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * Ⱥ���û����񶩹����ӵ���ǰ���񶩹���
		 * @param fromRequest ��ͨ����
		 * @param fromMember ��Ա�û�
		 * @param fromMsgFOffer ��Ա����
		 * @param fromGroup �����û�
		 * @param fromDepend ����������
		 * @param fromUpdfmx ��ǰ���񶩹�
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _mergeAsDepend( IOVMsgFRequest fromRequest,
				IOVMsgFUser fromMember,
				IOVMsgFOffer fromMsgFOffer,
				IOVMsgFUser fromGroup,
				IProfessionalTemplate.IProductGroup fromDepend,
				IOVUpdfmxOffer fromUpdfmx, 
				IUpdcContext aContext) throws SFException, Exception{
			try
			{
				IOVMsgFOffer fromOrdOffer[] = IOrderFactory.getICustomSV().getSFUserOrder( fromRequest, fromGroup );
				for( int index = 0; fromOrdOffer != null && index < fromOrdOffer.length; index++ ){
					IOVUpdfmxOffer fromCombine = ICustomX._jj_depend(fromRequest, fromOrdOffer[index], fromDepend, aContext);
					if( fromCombine != null ){
						IProfessionalTemplate.IProductCatalog fromCatalog = null;
						for( java.util.Iterator<IProfessionalTemplate.IProductCatalog> itera = fromCombine.getORDER().getORDER().iterator(); itera.hasNext(); ){
							fromCatalog = (IProfessionalTemplate.IProductCatalog)itera.next();
							if( StringUtils.equals( fromCatalog.getCATEGORY(), IUpdbfsConst.IUpdbm.IProduct.PROGRAM_DEPEND_FUTURE ) ){
								IOVMsgFOffer fromUserOffer = ICustomX._jj_groupDepend(fromRequest, 
										fromGroup, 
										fromOrdOffer[index], 
										fromUpdfmx, 
										aContext);
								ClassUtils.IMerge.merge( fromUserOffer.getFUTURE(), fromMsgFOffer.getFUTURE() );
							}
							else if( StringUtils.equals( fromCatalog.getCATEGORY(), IUpdbfsConst.IUpdbm.IProduct.PROGRAM_DEPEND_COMPETE ) ){
								IOVMsgFOffer fromUserOffer = ICustomX._jj_depend(fromRequest, 
										fromGroup, 
										fromOrdOffer[index], 
										fromUpdfmx, 
										aContext);
								fromUserOffer.setCOMPETE_ID( Long.parseLong( fromCatalog.getEXTEND_ATTR_A() ) );
								fromUpdfmx.getORDER().getORDER().add( fromUserOffer );
							}
							else{
								IOVMsgFOffer fromUserOffer = ICustomX._jj_depend(fromRequest, 
										fromGroup, 
										fromOrdOffer[index], 
										fromUpdfmx, 
										aContext);
								fromUserOffer.setCOMPETE_ID( Long.parseLong( fromCatalog.getEXTEND_ATTR_A() ) );
								fromUpdfmx.getORDER().getORDER().add( fromUserOffer );
							}
						}
					}
				}
			}
			finally{
				
			}
		}
		public static class ICustomX{
			public ICustomX(){
				super();
			}
			
			/**
			 * �����û�ת��Ϊ��ǰ�û���������
			 * @param fromRequest ��ͨ����
			 * @param fromMsgFOffer �û�����
			 * @param fromMsgFGroup �����û� 
			 * @param aContext
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVMsgFOffer _jj_groupUser(IOVMsgFRequest fromRequest,
					IOVMsgFOffer fromMsgFOffer,
					IOVMsgFUser fromMsgFGroup,
					IUpdcContext aContext) throws SFException, Exception{
				IBeanWrapper fromCustom = new IBeanWrapper( fromMsgFGroup );
				try
				{
					java.beans.PropertyDescriptor aDescriptor[] = fromCustom.getPropertyDescriptors();
					for( int index = 0; aDescriptor != null && index < aDescriptor.length; index++ ){
						if( aDescriptor[index].getReadMethod() != null && 
								ClassUtils.IClass.isPrimitive( aDescriptor[index].getPropertyType() ) ){
							String _descriptor = ClassUtils.getINDEX(new String[]{"GRPPTY_", StringUtils.replace( 
									aDescriptor[index].getName(), "_", "" ) } );
							Object _objective = fromCustom.getPropertyValue( aDescriptor[index].getName() );
							if( fromMsgFOffer.getFUTURE( _descriptor ) == null && _objective != null ){
								fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( _descriptor, _objective.toString() ) );
							}
						}
					}
					for( java.util.Iterator<IOVMsgFOfferX> itera = fromMsgFGroup.getNATURE().iterator(); itera.hasNext(); ){
						IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
						String _descriptor = ClassUtils.getINDEX(new String[]{"GRPPTY_", StringUtils.replace( 
								fromOfferX.getATTR_ID(), "_", "" ) } );
						if( fromMsgFOffer.getFUTURE( _descriptor ) == null && 
								StringUtils.isBlank( fromOfferX.getATTR_VALUE() ) == false ){
							fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( _descriptor, fromOfferX.getATTR_VALUE() ) );
						}
					}
				}
				finally{
					if( fromCustom != null ){ fromCustom = null; }
				}
				return fromMsgFOffer;
			}
			
			/**
			 * ���ſͻ�ת��Ϊ��ǰ�û���������
			 * @param fromRequest ��ͨ����
			 * @param fromMsgFOffer �û�����
			 * @param fromMsgFCustom ���ſͻ�
			 * @param aContext
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVMsgFOffer _jj_groupCustom(IOVMsgFRequest fromRequest,
					IOVMsgFOffer fromMsgFOffer,
					IOVMsgFCustom fromMsgFCustom,
					IUpdcContext aContext) throws SFException, Exception{
				IBeanWrapper fromCustom = new IBeanWrapper( fromMsgFCustom );
				try
				{
					java.beans.PropertyDescriptor aDescriptor[] = fromCustom.getPropertyDescriptors();
					for( int index = 0; aDescriptor != null && index < aDescriptor.length; index++ ){
						if( aDescriptor[index].getReadMethod() != null && 
								ClassUtils.IClass.isPrimitive( aDescriptor[index].getPropertyType() ) ){
							String _descriptor = ClassUtils.getINDEX(new String[]{"GROUP_", StringUtils.replace( 
									aDescriptor[index].getName(), "_", "" ) } );
							Object _objective = fromCustom.getPropertyValue( aDescriptor[index].getName() );
							if( fromMsgFOffer.getFUTURE( _descriptor ) == null && _objective != null ){
								fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( _descriptor, _objective.toString() ) );
							}
						}
					}
					for( java.util.Iterator<IOVMsgFOfferX> itera = fromMsgFCustom.getNATURE().iterator(); itera.hasNext(); ){
						IOVMsgFOfferX fromOfferX = (IOVMsgFOfferX)itera.next();
						String _descriptor = ClassUtils.getINDEX(new String[]{"GROUP_", StringUtils.replace( 
								fromOfferX.getATTR_ID(), "_", "" ) } );
						if( fromMsgFOffer.getFUTURE( _descriptor ) == null && 
								StringUtils.isBlank( fromOfferX.getATTR_VALUE() ) == false ){
							fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( _descriptor, fromOfferX.getATTR_VALUE() ) );
						}
					}
				}
				finally{
					if( fromCustom != null ){ fromCustom = null; }
				}
				return fromMsgFOffer;
			}
			
			/**
			 * ��Ʒ��չ�������ӵ���ǰ���񶩹���
			 * @param fromRequest ��ͨ����
			 * @param fromMsgFUser ��ͨ�û�
			 * @param fromMsgFOffer ��ͨ����
			 * @param fromUpdfmx ��ǰ���񶩹�
			 * @param aContext
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVMsgFOffer _jj_AsExtInfo( IOVMsgFRequest fromRequest,
					IOVMsgFUser fromMsgFUser,
					IOVMsgFOffer fromMsgFOffer,
					IOVUpdfmxOffer fromUpdfmx,
					IUpdcContext aContext) throws SFException, Exception{
				try
				{
					IUpfgkmItemHome fromUpfgkmHome = ICustomX._jj_price( fromMsgFOffer.getPRODUCT_ID() );
					if( fromUpfgkmHome != null ){
						IUpfgkmItemHome.IUpfgkmOfferHome fromOfferHome = fromUpfgkmHome.getOFFER();
						fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "PRODUCT_ID", fromOfferHome.getPRICE_ID () ) );
						fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "PRICE_ID"  , fromOfferHome.getPLAN_ID  () ) );
						fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "EFFECTIVE" , fromMsgFOffer.getEFFECTIVE() ) );
						fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( "EXPIRE"    , fromMsgFOffer.getEXPIRE   () ) );
					}
				}
				finally{
					
				}
				return fromMsgFOffer;
			}
			
			/**
			 * 
			 * @param fromRequest
			 * @param fromMsgFOffer
			 * @param fromDepend
			 * @param aContext
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVUpdfmxOffer _jj_depend( IOVMsgFRequest fromRequest,
					IOVMsgFOffer fromMsgFOffer,
					IProfessionalTemplate.IProductGroup fromDepend,
					IUpdcContext aContext) throws SFException, Exception{
				IOVUpdfmxOffer fromGroup = new IOVUpdfmxOffer( fromRequest );
				try
				{
					String aCOMPETE = String.valueOf( fromMsgFOffer.getPRODUCT_ID() );
					java.util.List<IProfessionalTemplate.IProductCatalog> fromCombine = fromDepend.getCOMBINE( aCOMPETE );
					if( fromCombine == null ){
						aCOMPETE = String.valueOf( fromMsgFOffer.getSERVICE_ID() );
						fromCombine = fromDepend.getCOMBINE( aCOMPETE );
					}
					if( fromCombine != null ){
						ClassUtils.IMerge.merge( fromCombine, fromGroup.getORDER().getORDER() );
					}
				}
				finally{
					
				}
				return fromGroup;
			}
			
			/**
			 * ��ǰ�û����񶩹����ӵ���ǰ���񶩹���
			 * @param fromRequest ��ͨ����
			 * @param fromGroup �����û�
			 * @param fromOrdOffer ���Ŷ���
			 * @param fromUpdfmx ��ǰ���񶩹�
			 * @param aContext
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVMsgFOffer _jj_depend( IOVMsgFRequest fromRequest,
					IOVMsgFUser fromGroup,
					IOVMsgFOffer fromOrdOffer,
					IOVUpdfmxOffer fromUpdfmx, 
					IUpdcContext aContext) throws SFException, Exception{
				IOVMsgFOffer fromUserOffer = null;
				try
				{
					fromUserOffer = UpdbfsUtils.ICustom._depend(fromRequest, 
							fromGroup, 
							fromOrdOffer);
					ICustomX._jj_AsExtInfo( fromRequest, 
							fromGroup, 
							fromUserOffer, 
							fromUpdfmx, 
							aContext );
				}
				finally{
					
				}
				return fromUserOffer;
			}
			
			/**
			 * Ⱥ���û����񶩹����ӵ���ǰ���񶩹���
			 * @param fromRequest ��ͨ����
			 * @param fromGroup �����û�
			 * @param fromOrdOffer ���Ŷ���
			 * @param fromUpdfmx ��ǰ���񶩹�
			 * @param aContext
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVMsgFOffer _jj_groupDepend( IOVMsgFRequest fromRequest,
					IOVMsgFUser fromGroup,
					IOVMsgFOffer fromOrdOffer,
					IOVUpdfmxOffer fromUpdfmx, 
					IUpdcContext aContext) throws SFException, Exception{
				IOVMsgFOffer fromUserOffer = null;
				try
				{
					fromUserOffer = UpdbfsUtils.ICustom._depend(fromRequest, 
							fromGroup, 
							fromOrdOffer);
					IUpfgkmItemHome fromUpfgkmHome = ICustomX._jj_price( fromUserOffer.getPRODUCT_ID() );
					if( fromUpfgkmHome != null ){
						IUpfgkmItemHome.IUpfgkmOfferHome fromOfferHome = fromUpfgkmHome.getOFFER();
						fromUserOffer.getFUTURE().add( new IOVMsgFOfferX( "GROUP_PRODUCTID", fromOfferHome.getPRICE_ID () ) );
						fromUserOffer.getFUTURE().add( new IOVMsgFOfferX( "GROUP_PRICEID"  , fromOfferHome.getPLAN_ID  () ) );
						fromUserOffer.getFUTURE().add( new IOVMsgFOfferX( "GROUP_EFFECTIVE", fromUserOffer.getEFFECTIVE() ) );
						fromUserOffer.getFUTURE().add( new IOVMsgFOfferX( "GROUP_EXPIRE"   , fromUserOffer.getEXPIRE   () ) );
					}
				}
				finally{
					
				}
				return fromUserOffer;
			}
			
			/**
			 * ���ݲ�Ʒ���ת����ͨ��������
			 * @param aCOMPETE ���Ա���
			 * @param aPRODUCT_ID ��Ʒ���
			 * @return
			 */
			public static IOVMsgFOfferX _jj_compete( final String aCOMPETE, final String aPRODUCT_ID ){
				IOVMsgFOfferX fromMsgFOfferX = null;
				try
				{
					IProfessionalTemplate.IProductOffer fromUpdfmx = null;
					fromMsgFOfferX = new IOVMsgFOfferX( aCOMPETE, aPRODUCT_ID );
					if( MathUtils.isNumeric( aPRODUCT_ID ) ){
						fromUpdfmx = IOrderFactory.getIProductSV().getSFProductOffer( Long.parseLong( aPRODUCT_ID ) );
						if( fromUpdfmx != null ){ fromMsgFOfferX.setATTR_VALUE( fromUpdfmx.getCOMPETE() );}
					}
				}
				catch( java.lang.Exception aException ){
					log.error( aException.getMessage(), aException );
				}
				finally{
					
				}
				return fromMsgFOfferX;
			}
			
			/**
			 * �������Գ�Ա����ʽΪAttr1=1000002,Attr2=2,Attr3=00:24:21:19:BD:E5,Attr3=20121220
			 * @param fromRequest
			 * @param fromMsgFOfferX
			 * @param aContext
			 * @param 
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static java.util.Map<String,String> _jj_lifite(IOVMsgFRequest fromRequest,
					IOVMsgFOfferX fromMsgFOfferX,
					IUpdcContext aContext) throws SFException,Exception{
				java.util.Map<String,String> fromAsGroup = null;
				try
				{
					if( StringUtils.isBlank( fromMsgFOfferX.getATTR_VALUE() ) ){
						fromAsGroup = new java.util.HashMap<String,String>();
					}
					else if( IIfElse.isCOMPLEX( fromMsgFOfferX.getATTR_VALUE(), "," ) ){
						fromAsGroup = JdomUtils.ICustom.wrap( fromMsgFOfferX.getATTR_VALUE(), "," );
					}
				}
				finally{
					
				}
				return fromAsGroup;
			}
			
			/**
			 * 
			 * @param fromRequest
			 * @param fromMsgFOffer
			 * @param aContext
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVUpdfmxOffer _jj_lifite(IOVMsgFRequest fromRequest,
					IOVMsgFOffer fromMsgFOffer, 
					IUpdcContext aContext) throws SFException, Exception{
				IOVUpdfmxOffer fromGroup = new IOVUpdfmxOffer( fromRequest );
				try
				{
					IProfessionalTemplate.IProductOffer fromUpdbfmx = null;
					IProfessionalTemplate.IProductComptel fromComptel = null;
					for( java.util.Iterator<IOVMsgFOfferX> itera = fromMsgFOffer.getFUTURE().iterator(); itera.hasNext(); ){
						IOVMsgFOfferX fromMsgFOfferX = (IOVMsgFOfferX)itera.next();
						fromUpdbfmx = IOrderFactory.getIProductSV().getSFProductOffer( fromMsgFOfferX );
						if( fromUpdbfmx != null && ( fromComptel = fromUpdbfmx.getCOMPTEL() ) != null && fromComptel.isMULTLE() ){
							fromGroup.getORDER().getORDER().add( fromMsgFOfferX );
						}
						else{
							fromGroup.getORDER().getFUTURE().add( fromMsgFOfferX );
						}
					}
				}
				finally{
					
				}
				return fromGroup;
			}
			
			/**
			 * �����ʷѲ�Ʒ��Ų�ѯ����Ʒ��Ԫ����
			 * @param aPRODUCT_ID ��Ʒ���
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IUpfgkmItemHome _jj_price( final long aPRODUCT_ID ) throws SFException,Exception{
				IUpfgkmItemHome fromItemHome = null;
				try
				{
					fromItemHome = UpdbfsFactory.getIProductSV().getProductItemById( aPRODUCT_ID );
				}
				finally{
					
				}
				return fromItemHome;
			}
		}
	}
	
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		/**
		 * ��ȡ��ǰ�����Ʒ��չ������
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProfessionalTemplate.IBusinesCatalog getPROGRAM( IUpdcContext aContext) throws SFException, Exception{
			IProfessionalTemplate.IBusinesCatalog fromCatalog = null;
			try
			{
				fromCatalog = (IProfessionalTemplate.IBusinesCatalog)aContext.get( IUpdcConst.IUpdbm.IUpdbf.PROGRAM );
			}
			finally{
				
			}
			return fromCatalog;
		}
		
		/**
		 * ��ȡ��ǰ�����Ʒ��չ������
		 * @param fromRequest ��ͨ����
		 * @param fromOffer �����Ʒ
		 * @param fromCatalog ������չ
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IUpdcContext getPROGRAM( IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromOffer,
				IProfessionalTemplate.IBusinesCatalog fromCatalog,
				IUpdcContext aContext) throws SFException, Exception{
			IUpdcContext fromLDAP = ClassUtils.getIContextImpl( aContext );
			try
			{
				fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.PROGRAM, fromCatalog );
			}
			finally{
				
			}
			return fromLDAP;
		}
		public static class ISystemX{
			public ISystemX(){
				super();
			}
		}
	}
	
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		
		/**
		 * �Ƿ��ʽΪA=1,B=1
		 * @param arguments �ַ���,��ʽΪA=1,B=1
		 * @param delimiter �ָ����
		 * @return
		 */
		public static boolean isCOMPLEX( final String arguments, final String delimiter ){
			java.util.StringTokenizer fromAsMultle = null;
			try
			{
				fromAsMultle = new java.util.StringTokenizer( arguments, delimiter );
				for( ; fromAsMultle.hasMoreTokens() ; ){
					String fromMultle = (String)fromAsMultle.nextToken();
					if( StringUtils.contains( fromMultle, "=" ) == false ){
						return false;
					}
				}
			}
			finally{
				if( fromAsMultle != null ){ fromAsMultle = null; }
			}
			return true;
		}
	}
}

