package com.asiainfo.sacenter.shcmcc.receive.dbcp.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.order.dbcp.impl.ICustomCapitalImpl;
import com.ai.sacenter.receive.util.UpdbfsUtils;
import com.ai.sacenter.receive.valuebean.*;
import com.ai.sacenter.teaminvoke.valuebean.IUpfgkmOfferHome;
import com.ai.sacenter.util.*;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.ISystemTemplate;
import org.apache.ecs.html.OL;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * <p>Title: sacenter-shcmcc</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017年3月30日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IProductCapitalImpl extends ICustomCapitalImpl {

	public IProductCapitalImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: sacenter-shcmcc</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年4月11日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbfsExigenceImpl extends IProductCapitalImpl{
		public IUpdbfsExigenceImpl(){
			super();
		}
		
		/**
		 * 用户下周期订购预处规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2CYCLEImpl</p>
		 * <p>Description: 用户订购立即开通</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通网元组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2CycleImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			try
			{
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				if( TimeUtils.greaterEqual( fromMBean.getCREATOR(), fromMsgFOffer.getEFFECTIVE() ) /*已生效订购*/){
					fromUpdfmx.getORDER().getORDER().add( fromMsgFOffer );
				}
				else if( fromMsgFOffer.isVALID() /*下周期生效订购*/ ){
					if( TimeUtils.greaterEqual( fromMsgFOffer.getEFFECTIVE(), fromMBean.getCREATOR() ) ){
						fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( IUpdbfsConst.IUpdbm.IUser.CYCLE, 
								IUpdbfsConst.IState.C ) );
					}
					fromUpdfmx.getORDER().getORDER().add( fromMsgFOffer );
				}
				else/*生效时间与失效时间相等[无效退订]*/{
					java.sql.Timestamp aYestDayStartDate = TimeUtils.getYestDayStartDate( fromMsgFOffer.getEFFECTIVE() );
					if( TimeUtils.greaterEqual( fromMsgFOffer.getEFFECTIVE(), fromMBean.getCREATOR() ) ){
						fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX( IUpdbfsConst.IUpdbm.IUser.CYCLE, 
								IUpdbfsConst.IState.E ) );
						if( TimeUtils.greaterEqual( fromMBean.getCREATOR(), aYestDayStartDate ) /*退订服务产品*/){
							fromMsgFOffer.setEFFECTIVE( TimeUtils.getEffective      () );
							fromMsgFOffer.setSTATUS   ( IUpdbfsConst.IState.IOrder.S03 );
							fromUpdfmx.getORDER().getORDER().add( fromMsgFOffer );
						}
					}
				}
			}
			finally{
				
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER().toArray( new IOVMsgFOffer[]{} ); 
		}
		
		/**
		 * 用户订购立即开通预处规范[手机规格][GSM]
		 * <p>Library: IUpdbfsUcm2IMMEDImpl</p>
		 * <p>Description: 用户订购立即开通</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通网元组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2IMMEDImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm,
				IUpdcContext aContext) throws SFException, Exception{
			java.util.List fromNature = new java.util.ArrayList();
			try
			{
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				if( fromMsgFOffer.isCREATE() && fromMsgFOffer.isEFFECTIVE( fromMBean.getCREATOR() ) ){
					IOVMsgFOffer fromOrdOffer = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
					fromOrdOffer.setEFFECTIVE( TimeUtils.getEffective() );
					fromOrdOffer.setEXPIRE   ( TimeUtils.getMaxExpire() );
					fromNature.add( fromOrdOffer );
				}
				else if( fromMsgFOffer.isMODIFY() && fromMsgFOffer.isEXPIRE( fromMBean.getCREATOR() ) ){
					IOVMsgFOffer fromOrdOffer = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
					fromOrdOffer.setSTATUS   ( IUpdbfsConst.IState.IOrder.S03 );
					fromOrdOffer.setEXPIRE   ( TimeUtils.getMaxExpire      () );
					fromNature.add( fromOrdOffer );
				}
			}
			finally{
				
			}
			return  fromNature != null?(IOVMsgFOffer[])fromNature.toArray( new IOVMsgFOffer[]{}):null;
		}
		
	}
	/**
	 * 
	 * <p>Title: sacenter-shcmcc</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2017年3月30日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IUpdbfxCapitalImpl extends ICustomCapitalImpl.IUpdbfxCustomImpl{
		public IUpdbfxCapitalImpl(){
			super();
		}
		
		/**
		 * 用户呼叫转移号码规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2CFMNOImpl</p>
		 * <p>Description: 根据开通产品默认测试处理</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2CFNOImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			try
			{
				ISystemTemplate.IUpfgkmOfficeX fromOfficeX = null;
				fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
				IOVMsgFUser fromUSER = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
				IOVMsgFOfferX fromOfferX = fromNature.getFUTURE( "262100000100" );
				if( fromOfferX != null && StringUtils.isBlank( fromOfferX.getATTR_VALUE() ) == false ){
					fromOfficeX = CenterUtils.getSFUpfgkmOffice( fromUSER.getBILL_ID() );
					IOVMsgFOfferX fromNatureX = new IOVMsgFOfferX( fromOfferX );
					fromNatureX.setATTR_ID( "CFZYNUM" );
					if( StringUtils.startWith( fromOfficeX.getPS_NET_CODE(), "5" ) && 
							StringUtils.startWith( fromNatureX.getATTR_VALUE(), "1") == false && 
							StringUtils.startWith( fromNatureX.getATTR_VALUE(), "0") == false ){
						fromNatureX.setATTR_VALUE( StringUtils.trimLeft( new String[]{ "0", fromNatureX.getATTR_VALUE() } ) );
					}
					else if( StringUtils.startWith( fromOfficeX.getPS_NET_CODE(), "5" ) == false && 
							StringUtils.startWith( fromNatureX.getATTR_VALUE(), "0" ) ){
						fromNatureX.setATTR_VALUE( StringUtils.substring( fromNatureX.getATTR_VALUE(), 1 ) );
					}
					fromNature.getFUTURE().add( fromNatureX );
				}
			}
			finally{
			
			}
			return new IOVMsgFOffer[]{ fromNature };
		}
		
		/**
		 * 用户IP直通车规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2IPZTCImpl</p>
		 * <p>Description: 根据开通IP直通车产品处理</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2IPZTCImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			try
			{
				class SFUpdbfxIPZTCImpl{
					public SFUpdbfxIPZTCImpl(){
						super();
					}
					/**
					 * 
					 * @param fromRequest
					 * @param fromMsgFOffer
					 * @param fromUpdcpm
					 * @param aContext
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public java.util.List finishSFIPZTCCreate( IOVMsgFRequest fromRequest,
							IOVMsgFOffer fromMsgFOffer,
							IOVMsgFOfferX fromNatureX,
				            IUpfgkmOfferHome fromUpdcpm, 
				            IUpdcContext aContext) throws SFException, Exception{
						java.util.List fromNature = new java.util.ArrayList();
						try
						{
							String fromOfferX[] = StringUtils.wildcardArray( fromNatureX.getATTR_VALUE() , "|" );
							for( int index = 0; fromOfferX != null && index < fromOfferX.length; index++ ){
								StringBuilder fromIPZTCX = new StringBuilder();	
								if( "3".equals( fromOfferX[index].split(":")[0] ) == false ){
									fromIPZTCX.append("1").append( fromOfferX[index].substring( 1 ) );
									fromNature.add( fromIPZTCX.toString() );
								}
							}
						}
						finally{
							
						}
						return fromNature;
					}
					
					/**
					 * 
					 * @param fromRequest
					 * @param fromMsgFOffer
					 * @param fromUpdcpm
					 * @param aContext
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public java.util.List finishSFIPZTCUpdate( IOVMsgFRequest fromRequest,
							IOVMsgFOffer fromMsgFOffer,
							IOVMsgFOfferX fromNatureX,
				            IUpfgkmOfferHome fromUpdcpm, 
				            IUpdcContext aContext) throws SFException, Exception{
						java.util.List fromNature = new java.util.ArrayList();
						try
						{
							if( fromNatureX.isCANCEL() /*退订*/ ){
								fromNature.add( "4:0:0:0000000000:N:000000" );
							}
							else{
								String fromALL[] = StringUtils.wildcardArray( fromNatureX.getATTR_VALUE(), "|");
								String fromDELETE[] = StringUtils.wildcardArray( fromNatureX.getPRE_ATTR_VALUE(), "|");				
								String lstResult[] = StringUtils.wildcardDiff( fromALL, fromDELETE );	
								for(int t = 0; t < lstResult.length; t++){
									inter:
									if( "2".equals(lstResult[t].split(":")[0] ) ){
										String telNo = lstResult[t].split(":")[3];
										for(int j= 0;j < fromDELETE.length; j++ ){
												if( fromDELETE[j].contains(lstResult[t].substring(2) ) ){//过滤首位变了后面没变的数据
													break inter; 
												}
												else if(fromDELETE[j].contains(telNo)){
													StringBuilder lst = new StringBuilder();	
													if(lstResult[t].substring(lstResult[t].length()-6).equals(fromDELETE[j].substring(fromDELETE[j].length()-6)) == false) {//密码不相等，多拆一条
														lst.append("2:NULL").append(lstResult[t].substring(3));
														fromNature.add(lst.toString()) ;
													}//过滤用户只修改密码变更
													if(lstResult[t].substring(2, lstResult[t].length()-6).equals(fromDELETE[j].substring(2, fromDELETE[j].length()-6)) == false){
														fromNature.add(lstResult[t]) ;	
													}
													break inter; 
												} 
										}
									}
									else if ("4".equals(lstResult[t].split(":")[0] ) ){
										
									}
									else{
										fromNature.add(lstResult[t]);
									}
								}
							}
						}
						finally{
							
						}
						return fromNature;
					}
					
					/**
					 * 
					 * @param fromRequest
					 * @param fromMsgFOffer
					 * @param fromNatureX
					 * @param fromIPZTCX
					 * @param fromUpdcpm
					 * @param aContext
					 * @throws SFException
					 * @throws Exception
					 */
					public void finishSFIPZTCOffer( IOVMsgFRequest fromRequest,
							IOVMsgFOffer fromMsgFOffer,
							IOVMsgFOfferX fromNatureX,
							java.util.List fromIPZTCX,
				            IUpfgkmOfferHome fromUpdcpm, 
				            IUpdcContext aContext) throws SFException, Exception{
						try
						{
							StringBuilder fromBBILL = new StringBuilder();
							StringBuilder fromBPSWD = new StringBuilder();
							StringBuilder fromBMOSI = new StringBuilder();
							StringBuilder fromBPFLG = new StringBuilder();
							StringBuilder fromBIDDI = new StringBuilder();
							StringBuilder fromBLOCK = new StringBuilder();
							StringBuilder fromIPFLG = new StringBuilder();
							for( int index = 0; index < fromIPZTCX.size(); index++ ){
								String fromIPZTC = (String)fromIPZTCX.get( index );
								String fromOfferX[] = StringUtils.wildcardArray( fromIPZTC , ":");
								fromBBILL.append( fromOfferX[3] ).append( "/" );						
								fromBPSWD.append( fromOfferX[5] ).append( "/" );
								fromBMOSI.append( fromOfferX[0] ).append( "/" );
								fromBPFLG.append( fromOfferX[2] ).append( "/" );
								fromBIDDI.append( fromOfferX[1] ).append( "/" );					
								fromBLOCK.append( fromOfferX[4] ).append( "/" );
								if( index > 0 ){
									fromIPFLG.append("F").append( "/" );
								}
								else if( fromNatureX != null && StringUtils.isBlank( fromNatureX.getATTR_VALUE() ) == false && 
										StringUtils.isBlank( fromNatureX.getPRE_ATTR_VALUE() )  == true){
									fromIPFLG.append("T").append( "/" );
								}
								else{
									fromIPFLG.append("F").append( "/" );
								}
							}
							fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX("BBILL", fromBBILL.toString().substring( 0, fromBBILL.length()-1 ) ) );
							fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX("BPSWD", fromBPSWD.toString().substring( 0, fromBPSWD.length()-1 ) ) );
							fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX("BMOSI", fromBMOSI.toString().substring( 0, fromBMOSI.length()-1 ) ) );
							fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX("BPFLG", fromBPFLG.toString().substring( 0, fromBPFLG.length()-1 ) ) );
							fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX("BIDDI", fromBIDDI.toString().substring( 0, fromBIDDI.length()-1 ) ) );
							fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX("BLOCK", fromBLOCK.toString().substring( 0, fromBLOCK.length()-1 ) ) );
							fromMsgFOffer.getFUTURE().add( new IOVMsgFOfferX("IPFLG", fromIPFLG.toString().substring( 0, fromIPFLG.length()-1 ) ) );
						}
						finally{
							
						}
					}
				}
				SFUpdbfxIPZTCImpl fromUpdbfxImpl = new SFUpdbfxIPZTCImpl();
				java.util.List fromIPZTCX = null;
				try
				{
					fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
					IOVMsgFOfferX fromNatureX = fromNature.getFUTURE( "262100000101" );
					if( fromNatureX != null && StringUtils.isBlank( fromNatureX.getATTR_VALUE() ) == false ){
						if( StringUtils.isBlank( fromNatureX.getPRE_ATTR_VALUE() ) ){
							fromIPZTCX = fromUpdbfxImpl.finishSFIPZTCCreate(fromRequest, 
									fromNature, 
									fromNatureX, 
									fromUpdcpm, 
									aContext);
						}
						else{
							fromIPZTCX = fromUpdbfxImpl.finishSFIPZTCUpdate(fromRequest, 
									fromNature, 
									fromNatureX, 
									fromUpdcpm, 
									aContext);
						}
						if( fromIPZTCX != null && fromIPZTCX.size() > 0 ){
							fromUpdbfxImpl.finishSFIPZTCOffer(fromRequest, 
									fromNature,
									fromNatureX,
									fromIPZTCX, 
									fromUpdcpm, 
									aContext);
						}
					}
				}
				finally{
					if( fromIPZTCX != null ){ fromIPZTCX.clear(); fromIPZTCX = null; }
					if( fromUpdbfxImpl != null ){ fromUpdbfxImpl = null; }
				}
			}
			finally{
			
			}
			return new IOVMsgFOffer[]{ fromNature };
		}
		
		/**
		 * 用户VOLTE语音包属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2VolteImpl</p>
		 * <p>Description: 根据用户号码查询网元呼转号码属性</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2VolteImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			try
			{
				fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
			}
			finally{
			
			}
			return new IOVMsgFOffer[]{ fromNature };
		}
		
		/**
		 * 专有APN集团资源属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2QZYAPImpl</p>
		 * <p>Description: 专有APN集团资源属性</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2QZYAPImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			try
			{
				fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
				IOVMsgFOfferX fromOfferX = fromNature.getFUTURE( "260010001528" );
				if( fromOfferX != null && StringUtils.isBlank( fromOfferX.getATTR_VALUE() ) == false ){
					String fromSTATUS = UpdbfsUtils.ICustom.ICustomX._os_status(fromRequest, 
							fromMsgFOffer, 
							fromUpdcpm );
					if( StringUtils.isBlank( fromSTATUS ) == false ){
						IOVMsgFOfferX fromNatureX = new IOVMsgFOfferX( "QZYAPN_IDL", "" );
						fromNatureX.setATTR_VALUE( ClassUtils.getINDEX( new String[]{ fromOfferX.getATTR_VALUE(), "=", 
								fromSTATUS } ) );
						fromNature.getFUTURE().add( fromNatureX );
					}
				}
			}
			finally{
			
			}
			return new IOVMsgFOffer[]{ fromNature };
		}
		
		/**
		 * 省内一卡双号属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2YJSHImpl</p>
		 * <p>Description: 省内一卡双号属性</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2YJSHImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			try
			{
				fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
				IOVMsgFUser fromJMOUser[] = fromRequest.getMEMBER();
				if( fromJMOUser != null && fromJMOUser.length > 0 ){
					IOVMsgFUser fromMsgFUser = fromJMOUser[ fromJMOUser.length - 1 ];
					fromNature.getFUTURE().add( new IOVMsgFOfferX( "YJSHMNUM", fromMsgFUser.getBILL_ID    () ) );
					fromNature.getFUTURE().add( new IOVMsgFOfferX( "YJSHIMSI", fromMsgFUser.getSUB_BILL_ID() ) );
				}
			}
			finally{
			
			}
			return new IOVMsgFOffer[]{ fromNature };
		}
		
		/**
		 * 副号随意换属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2FHSYHImpl</p>
		 * <p>Description: 省内一卡双号属性</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2FHSYHImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			try
			{
				fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
				IOVMsgFOfferX fromOfferX = fromNature.getFUTURE( "262100000013" );
				if( fromOfferX != null && StringUtils.isBlank( fromOfferX.getATTR_VALUE() ) == false ){
					String fromYkShFh[] = StringUtils.split( fromOfferX.getATTR_VALUE(), "," );
					if( fromYkShFh != null && fromYkShFh.length <= 2 ){
						if( fromYkShFh.length == 1 ){
							fromNature.getFUTURE().add( new IOVMsgFOfferX( "FHSYH_FHMNUM", fromYkShFh[0] ) );
						}
						else if( fromYkShFh.length > 1 ){
							fromNature.getFUTURE().add( new IOVMsgFOfferX( "FHSYH_FHMNUM", fromYkShFh[0] ) );
							fromNature.getFUTURE().add( new IOVMsgFOfferX( "FHSYH_FHIMSI", fromYkShFh[1] ) );
						}
					}
					if( StringUtils.isBlank( fromOfferX.getPRE_ATTR_VALUE() ) == false ){
						fromYkShFh = StringUtils.split( fromOfferX.getPRE_ATTR_VALUE(), "," );
						if( fromYkShFh != null && fromYkShFh.length > 0 ){
							fromNature.getFUTURE().add( new IOVMsgFOfferX( "FHSYH_FHMONUM", fromYkShFh[0] ) );
						}	
					}
				}
			}
			finally{
			
			}
			return new IOVMsgFOffer[]{ fromNature };
		}
		
		/**
		 * 家庭短号[组网]属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxJTDH2AddGrpImpl</p>
		 * <p>Description: 省内一卡双号属性</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishJTDH2AddGrpImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			try
			{
				fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
				IOVMsgFUser fromGroup = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
				if( fromGroup != null && fromMsgFOffer.isORDER() /*开通定单测发起*/){
					IOVMsgFUser fromMember[] = fromRequest.getMEMBER();
					IOVMsgFOfferX fromOfferX = fromGroup.getNATURE( "100132" /*短号短信群组编号*/);
					if( fromOfferX != null ) fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_INTCODE", fromOfferX.getATTR_VALUE()) );
					if( fromMember != null && fromMember.length > 0 ){
						StringBuilder aJTDHTABLE = new StringBuilder();
						StringBuilder aJTDHMEMBILL = new StringBuilder();
						StringBuilder aJTDHMEMPHONE = new StringBuilder();
						for( int index = 0; fromMember != null && index < fromMember.length; index++ ){
							IOVMsgFOffer fromMemOffer[] = fromMember[index].getOrdOffer( 380000040443l );
							IOVMsgFOfferX fromMemPhone = fromMemOffer != null && fromMemOffer.length > 0?
									fromMemOffer[ fromMemOffer.length -1 ].getFUTURE("380000040441"):null;
							if( fromMemOffer == null || fromMemPhone == null ) continue;
							if( aJTDHTABLE.toString().length() > 0 ) aJTDHTABLE.append("&");
							if( aJTDHMEMBILL.toString().length() > 0 ) aJTDHMEMBILL.append("/");
							if( aJTDHMEMPHONE.toString().length() > 0) aJTDHMEMPHONE.append("/");
							aJTDHTABLE.append( fromMember[index].getBILL_ID() )
							          .append("|||||200000000012000000000000000000000000|")
							          .append( fromMemPhone.getATTR_VALUE() );
							aJTDHMEMBILL.append ( fromMember[index].getBILL_ID() );
							aJTDHMEMPHONE.append( fromMemPhone.getATTR_VALUE  () );
						}
						fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_INFO_TABLE", aJTDHTABLE.toString() ) );
						fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_MEM_BILL"  , aJTDHMEMBILL.toString() ) );
						fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_MEM_PHONE" , aJTDHMEMPHONE.toString() ) );
					}
				}
			}
			finally{
			
			}
			return new IOVMsgFOffer[]{ fromNature };
		} 
		
		/**
		 * 家庭短号[拆网]属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxJTDH2DelGrpImpl</p>
		 * <p>Description: 省内一卡双号属性</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishJTDH2DelGrpImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			try
			{
				fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
				IOVMsgFUser fromGroup = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
				if( fromGroup != null && fromMsgFOffer.isORDER() /*开通定单测发起*/){
					IOVMsgFUser fromMember[] = fromRequest.getMEMBER();
					IOVMsgFOfferX fromOfferX = fromGroup.getNATURE( "100132" /*短号短信群组编号*/);
					if( fromOfferX != null ) fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_INTCODE", fromOfferX.getATTR_VALUE()) );
					if( fromMember != null && fromMember.length > 0 ){
						StringBuilder aJTDHMEMBILL = new StringBuilder();
						StringBuilder aJTDHMEMPHONE = new StringBuilder();
						for( int index = 0; fromMember != null && index < fromMember.length; index++ ){
							IOVMsgFOffer fromMemOffer[] = fromMember[index].getOrdOffer( 380000040443l );
							IOVMsgFOfferX fromMemPhone = fromMemOffer != null && fromMemOffer.length > 0?
									fromMemOffer[ fromMemOffer.length -1 ].getFUTURE("380000040441"):null;
							if( fromMemOffer == null || fromMemPhone == null ) continue;
							if( aJTDHMEMBILL.toString().length() > 0 ) aJTDHMEMBILL.append("/");
							if( aJTDHMEMPHONE.toString().length() > 0) aJTDHMEMPHONE.append("/");
							aJTDHMEMBILL.append ( fromMember[index].getBILL_ID() );
							aJTDHMEMPHONE.append( fromMemPhone.getATTR_VALUE  () );
						}
						fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_MEM_BILL"  , aJTDHMEMBILL.toString() ) );
						fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_MEM_PHONE" , aJTDHMEMPHONE.toString() ) );
					}
				}
			}
			finally{
			
			}
			return new IOVMsgFOffer[]{ fromNature };
		}
	
		/**
		 * 家庭短号[成员]属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxJTDH2MemberImpl</p>
		 * <p>Description: 省内一卡双号属性</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishJTDH2MemberImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			try
			{
				fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
				IOVMsgFUser fromGroup = fromRequest.getUSER( fromRequest.getUSER_ID() );
				if( fromGroup != null && fromMsgFOffer.isORDER() /*开通定单测发起*/){
					IOVMsgFOfferX fromOfferX = fromGroup.getNATURE( "100132" /*短号短信群组编号*/);
					if( fromOfferX != null ) fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_INTCODE", fromOfferX.getATTR_VALUE()) );
					fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_MAIN_BILL"    , fromGroup.getBILL_ID                () ) );
					fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_MAIN_SUB"  , fromGroup.getSUB_BILL_ID            () ) );
					fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_MAIN_USER" , String.valueOf(fromGroup.getUSER_ID()) ) );
					fromNature.getFUTURE().add( new IOVMsgFOfferX( "JTDH_MAIN_CITY" , fromGroup.getREGION_ID              () ) );
				}
			}
			finally{
			
			}
			return new IOVMsgFOffer[]{ fromNature };
		} 
		
		/**
		 * 来电提醒属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2LDTXImpl</p>
		 * <p>Description: 来电提醒属性规范</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2LDTXImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			try
			{
				ISystemTemplate.IUpfgkmOfficeX fromOfficeX = null;
				fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
				IOVMsgFUser fromUser = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
				fromOfficeX = CenterUtils.getSFUpfgkmOffice( fromUser.getBILL_ID() );
				if( fromUser != null && fromOfficeX != null && StringUtils.equals( fromOfficeX.getPS_NET_CODE(), "TD1" ) ){
					fromNature.getFUTURE().add( new IOVMsgFOfferX( "LDTXTDFLAG", fromOfficeX.getPS_NET_CODE() ) );
				}
			}
			finally{
			
			}
			return new IOVMsgFOffer[]{ fromNature };
		} 
		 
		/**
		 * 亲情通属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2QQTCImpl</p>
		 * <p>Description: 亲情通属性规范</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2QQTCImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			try
			{
				class SFUpdbfxQQTCImpl{
					public SFUpdbfxQQTCImpl(){
						super();
					}
					/**
					 * 
					 * @param fromMSISDN
					 * @param fromSTATUS
					 * @param fromDQSI
					 */
					public void _os_status_qqtc( String fromMSISDN, String fromSTATUS, java.util.Map fromDQSI ){
						try
						{
							String fromUSED = (String)fromDQSI.get( fromMSISDN );
							if( fromUSED == null ){
								fromDQSI.put( fromMSISDN, fromSTATUS );
							}
							else if( StringUtils.equals( fromUSED, fromSTATUS ) == false ){
								fromDQSI.put( fromMSISDN, ClassUtils.getINDEX(new String[]{fromUSED, fromSTATUS} ) );
							}
						}
						finally{
							
						}
					}
					/**
					 * 
					 * @param fromRequest
					 * @param fromMsgFOffer
					 * @param fromDQSI
					 * @param fromUpdcpm
					 * @param aContext
					 * @throws SFException
					 * @throws Exception
					 */
					public void finishSFUpdbfxDQSI( IOVMsgFRequest fromRequest,
							IOVMsgFOffer fromMsgFOffer,
							java.util.Map fromDQSI,
							IUpfgkmOfferHome fromUpdcpm,
							IUpdcContext aContext) throws SFException, Exception{
						try
						{
							IOVMsgFOfferX fromOfferX[] = fromMsgFOffer.getFUTURE( new String[]{"262100000405","262100000406"} );
							for( int index = 0; fromOfferX != null && index < fromOfferX.length; index++ ){
								String aOsStatus = UpdbfsUtils.ICustom.ICustomX._os_status(fromRequest, 
										fromMsgFOffer, 
										fromOfferX[index], 
										fromUpdcpm);
								if( StringUtils.isBlank( fromOfferX[index].getATTR_VALUE() ) ) continue;
								if( StringUtils.isBlank( fromOfferX[index].getPRE_ATTR_VALUE() ) ){
									_os_status_qqtc(fromOfferX[index].getATTR_VALUE(), aOsStatus, fromDQSI );
								}
								else if( StringUtils.equals( fromOfferX[index].getATTR_VALUE(), 
										fromOfferX[index].getPRE_ATTR_VALUE() ) == false ){
									_os_status_qqtc(fromOfferX[index].getATTR_VALUE(), IUpdbfsConst.IState.C, fromDQSI );
									_os_status_qqtc(fromOfferX[index].getPRE_ATTR_VALUE(), IUpdbfsConst.IState.E, fromDQSI );
								}
							}
						}
						finally{
							
						}
					}
				}
				SFUpdbfxQQTCImpl fromUpdbfxImpl = new SFUpdbfxQQTCImpl();
				java.util.Map fromMSISDN = new java.util.HashMap();
				try
				{
					fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
					fromUpdbfxImpl.finishSFUpdbfxDQSI(fromRequest, 
							fromMsgFOffer, 
							fromMSISDN, 
							fromUpdcpm, 
							aContext);
					if( fromMSISDN != null && fromMSISDN.size() > 0 ){
						fromNature.getFUTURE().add( new IOVMsgFOfferX( "QQTCBILL", 
								StringUtils.join( fromMSISDN.keySet().iterator(), "/" ) ) );
						fromNature.getFUTURE().add( new IOVMsgFOfferX( "QQTCDQSI", 
								StringUtils.join( fromMSISDN.values().iterator(), "/" ) ) );
					}
				}
				finally{
					if( fromMSISDN != null ){ fromMSISDN.clear(); fromMSISDN = null; }
					if( fromUpdbfxImpl != null ){ fromUpdbfxImpl = null; }
				}
			}
			finally{
				
			}
			return new IOVMsgFOffer[]{ fromNature };
		}
		
		/**
		 * 家庭信息机属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2FemtoImpl</p>
		 * <p>Description: 家庭信息机属性规范</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2FemtoImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			java.util.Map fromFemto = new java.util.HashMap();
			try
			{
				fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
				IOVMsgFOfferX fromFetmoBill = fromMsgFOffer.getFUTURE( "262100000145" );
				String fromMsisdn[] = fromFetmoBill != null?StringUtils.split( fromFetmoBill.getATTR_VALUE(), "|" ):null;
				if( fromFetmoBill != null && fromMsisdn != null && fromMsisdn.length >= 2 ){
					IOVMsgFOfferX fromFemtoDQSI= fromMsgFOffer.getFUTURE( "262100000144" );
					ClassUtils.IMerge.merge( new Object[][]{{"FEMTOBILL", fromMsisdn[0]},{"FEMTOIMSI", fromMsisdn[1]}}, fromFemto, true );
					if( fromFemtoDQSI != null && StringUtils.isBlank( fromFetmoBill.getPRE_ATTR_VALUE() ) == false &&
							StringUtils.equals( fromFemtoDQSI.getATTR_VALUE(), "3" )/*1暂停2恢复3换卡4订购5退订*/){
						fromMsisdn = StringUtils.split( fromFetmoBill.getPRE_ATTR_VALUE(), "|" );
						if( fromMsisdn != null && fromMsisdn.length >= 2 ){
							ClassUtils.IMerge.merge( new Object[][]{{"FEMTOIMSI", fromMsisdn[1]}}, fromFemto, true );
						}
					}
					for( java.util.Iterator itera = fromFemto.entrySet().iterator(); itera.hasNext(); ){
						java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
						fromNature.getFUTURE().add( new IOVMsgFOfferX( fromEntry.getKey().toString(), fromEntry.getValue().toString() ) );
					}
				}
			}
			finally{
				if( fromFemto != null ){ fromFemto.clear(); fromFemto = null; }
			}
			return new IOVMsgFOffer[]{ fromNature };
		}
		
		/**
		 * WLAN流量共享属性规范[手机规格][GSM]
		 * <p>Library: IUpdbfxUcm2WlanGxImpl</p>
		 * <p>Description: WLAN流量共享属性规范</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2WlanGxImpl(IOVMsgFRequest fromRequest,
				IOVMsgFOffer fromMsgFOffer,
				IOVUpffmxRequest fromUpffmx,
				IUpfgkmOfferHome fromUpdcpm, 
				IUpdcContext aContext) throws SFException, Exception{
			IOVMsgFOffer fromNature = null;
			java.util.Map fromFemto = new java.util.HashMap();
			try
			{
				int fromTerminus = 0,fromNowTerminus = 1,fromNextTerminus = 1;
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				IOVMsgFUser fromOsUser = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
				fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
				java.sql.Timestamp fromNextMoth = TimeUtils.getNextMonthStartDate( fromMBean.getCREATE() );
				IOVMsgFOffer fromOrdOffer[] = fromOsUser.getOrdOffer( fromMsgFOffer.getSERVICE_ID() );
				for( int index = 0 ; fromOrdOffer != null && index < fromOrdOffer.length; index++ ){
					if( fromOrdOffer[index].isVALID() == false ) continue;
					if( TimeUtils.equal( fromOrdOffer[index].getEXPIRE(), fromNextMoth ) ){
						fromNowTerminus += 1;
					}
					else{
						fromTerminus += 1;fromNowTerminus += 1;fromNextTerminus += 1;
					}
				}
				fromOrdOffer = fromOsUser.getUserOffer( fromMsgFOffer.getSERVICE_ID() );
				for( int index = 0 ; fromOrdOffer != null && index < fromOrdOffer.length; index++ ){
					if( fromOrdOffer[index].isVALID() == false ) continue;
					if( TimeUtils.equal( fromOrdOffer[index].getEXPIRE(), fromNextMoth ) ){
						fromNowTerminus += 1;
					}
					else{
						fromNowTerminus += 1;fromNextTerminus += 1;
					}
				}
				if( fromTerminus == 4 ){ 
					fromNature.getFUTURE().add( new IOVMsgFOfferX( "WLANSHAR_PROM", "1" ) );
				}
				fromNature.getFUTURE().add( new IOVMsgFOfferX( "WLANSHAR_CUR" , String.valueOf( fromNowTerminus ) ) );
				fromNature.getFUTURE().add( new IOVMsgFOfferX( "WLANSHAR_NEXT", String.valueOf( fromNextTerminus) ) );
			}
			finally{
				if( fromFemto != null ){ fromFemto.clear(); fromFemto = null; }
			}
			return new IOVMsgFOffer[]{ fromNature };
		}

		/**
		 * SIP呼叫直连
		 * <p>Library: finishUcm2SIPHJZLImpl</p>
		 * <p>Description: WLAN流量共享属性规范</p>
		 * @param fromRequest 开通定单
		 * @param fromMsgFOffer 开通服务产品
		 * @param fromUpffmx 开通工单组
		 * @param fromUpdcpm 开通接入能力
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public IOVMsgFOffer[] finishUcm2SIPHJZLImpl(IOVMsgFRequest fromRequest,
												   IOVMsgFOffer fromMsgFOffer,
												   IOVUpffmxRequest fromUpffmx,
												   IUpfgkmOfferHome fromUpdcpm,
												   IUpdcContext aContext) throws SFException, Exception{
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer( fromRequest );
			java.util.Map<String, IOVMsgFOrdOffer> _change_ = new java.util.HashMap<String, IOVMsgFOrdOffer>();
			String DIDHMARR[] = null;
			String OLDDIDHM[] = null;
			try
			{
				IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
				IOVMsgFOffer fromNature = UpdbfsUtils.ICustom._wrap( fromRequest, fromMsgFOffer );
				IOVMsgFOfferX __DIDHM__ = fromNature.getFUTURE( "DIDHM" );
				IOVMsgFOfferX __OLDDIDHM__ = fromNature.getFUTURE( "OLDDIDHM" );
				java.util.Map<String,String> __DIDHMMAP__ = new HashMap<String, String>();
				java.util.Map<String,String> __OLDDIDHMMAP__ = new HashMap<String, String>();

				__DIDHMMAP__ = JdomUtils.ICustom.wrap( __DIDHM__.getATTR_VALUE() , "," ) ;  //MAP ___DIDHM__
				__OLDDIDHMMAP__ = JdomUtils.ICustom.wrap( __OLDDIDHM__.getATTR_VALUE() , "," );  // MAP ___OLDDIDHM__
				for( java.util.Iterator<String> itera = __DIDHMMAP__.keySet().iterator(); itera.hasNext(); ){
					String  ___DIDHMM__ = (String)itera.next();
					if( __OLDDIDHMMAP__.containsKey( ___DIDHMM__ ) ){
						IOVMsgFOrdOffer ordOffer = new IOVMsgFOrdOffer(fromMsgFUser,390020007494l,"4");
						ordOffer.getFUTURE().add(new IOVMsgFOfferX("SIPDIDHM",___DIDHMM__));
						_change_.put( ___DIDHMM__,ordOffer);
					}
					else{
						IOVMsgFOrdOffer ordOffer = new IOVMsgFOrdOffer(fromMsgFUser,390020007494l,"1");
						ordOffer.getFUTURE().add(new IOVMsgFOfferX("SIPDIDHM",___DIDHMM__));
						_change_.put( ___DIDHMM__ ,ordOffer);
					}
				}

				for( java.util.Iterator<String> itera = __OLDDIDHMMAP__.keySet().iterator(); itera.hasNext(); ){
					String  ___DIDHMM__ = (String)itera.next();
					if( __DIDHMMAP__.containsKey( ___DIDHMM__ ) ){
						IOVMsgFOrdOffer ordOffer = new IOVMsgFOrdOffer(fromMsgFUser,390020007494l,"4");
						ordOffer.getFUTURE().add(new IOVMsgFOfferX("SIPDIDHM", ___DIDHMM__));
						_change_.put( ___DIDHMM__,ordOffer);
					}
					else{
						IOVMsgFOrdOffer ordOffer = new IOVMsgFOrdOffer(fromMsgFUser,390020007494l,"3");
						ordOffer.getFUTURE().add(new IOVMsgFOfferX("SIPDIDHM",___DIDHMM__));
						_change_.put( ___DIDHMM__ ,ordOffer);
					}
				}

                for( java.util.Iterator<IOVMsgFOrdOffer> itera = _change_.values().iterator(); itera.hasNext(); ){
					IOVMsgFOrdOffer _msgfoffer_ = (IOVMsgFOrdOffer)itera.next();
					fromUpdfmx.getORDER().getORDER().add( _msgfoffer_ );
				}
				fromUpdfmx.getORDER().getORDER().add( fromNature );
			}
			finally{
				if( _change_  != null ){ _change_.clear(); _change_ = null; }
			}
			return (IOVMsgFOffer[])fromUpdfmx.getORDER().getORDER().toArray( new IOVMsgFOffer[]{} );
		}


	}
}
