package com.ai.sacenter.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOffer;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOfferX;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年5月8日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class OfferUtils {
	public OfferUtils() {
		super();
	}
	public static class ICustom{
		public ICustom(){
			super();
		}
		/**
		 * 
		 * @param fromOrdOffer
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderOffer wrap( IOVOrderOffer fromOrdOffer[] )  throws SFException, Exception{
			IOVOrderOffer fromOffer = null;
			StringBuilder fromOsStatus = new StringBuilder();
			try
			{
				fromOffer = new IOVOrderOffer( fromOrdOffer[ 0 ] );
				fromOsStatus.append( fromOffer.getSTATUS() );
				for( int index = 1; index < fromOrdOffer.length; index++ ){
					fromOsStatus.append( fromOrdOffer[index].getSTATUS() );
					if( fromOrdOffer[index].isDEPEND() || fromOrdOffer[index].isHOLDING() ){
						fromOffer = new IOVOrderOffer( fromOrdOffer[index] );
					}
					else if( fromOffer.isCREATE() && fromOrdOffer[index].isCANCEL() ){
						fromOffer.setSTATUS( IUpdcConst.IState.CE );
				    	ICustomX._mergex( fromOrdOffer[index], fromOffer );
				    }
				    else if( fromOffer.isCANCEL() && fromOrdOffer[index].isCREATE() ){
				    	IOVOrderOffer fromOrdUsed = fromOffer;
				    	fromOffer = new IOVOrderOffer( fromOrdOffer[index] );
				    	fromOffer.setSTATUS( IUpdcConst.IState.EC );
				    	ICustomX._mergex( fromOrdUsed, fromOffer);
				    }
				    else if( ( fromOffer.isDEPEND() || fromOffer.isHOLDING() ) ){
				    	IOVOrderOffer fromOrdUsed = fromOffer;
				    	fromOffer = new IOVOrderOffer( fromOrdOffer[index] );
				    	fromOffer.setSTATUS( ClassUtils.getINDEX( new String[]{ fromOffer.getSTATUS(), 
				    			fromOrdOffer[index].getSTATUS() } ) );
				    	ICustomX._mergex( fromOrdUsed, fromOffer);
				    }
				    else if( StringUtils.contains( fromOffer.getSTATUS(), 
				    		fromOrdOffer[index].getSTATUS() ) ){
				    	ICustomX._mergex( fromOrdOffer[index], fromOffer);
				    }
				    else{
				    	IOVOrderOffer fromOrdUsed = fromOffer;
				    	fromOffer = new IOVOrderOffer( fromOrdOffer[index] );
				    	fromOffer.setSTATUS( fromOsStatus.toString() );
				    	ICustomX._mergex( fromOrdUsed, fromOffer);
				    }
				}
			}
			finally{
				if( fromOsStatus != null ){ fromOsStatus = null; }
			}
			return fromOffer;
		}
		
		public static class ICustomX{
			public ICustomX(){
				super();
			}
			/**
			 * 
			 * @param fromOrdUsed
			 * @param fromOrdOffer
			 * @throws SFException
			 * @throws Exception
			 */
			public static void _mergex( IOVOrderOffer fromOrdUsed,
					IOVOrderOffer fromOrdOffer ) throws SFException,Exception{
				try
				{
					for( java.util.Iterator itera = fromOrdUsed.getFEATURE().iterator(); itera.hasNext(); ){
						IOVOrderOfferX fromUsedX = (IOVOrderOfferX)itera.next();
						IOVOrderOfferX fromOfferX = fromOrdOffer.getFEATURE( fromUsedX.getCOMPETE() );
						if( fromOfferX == null ){ 
							fromOrdOffer.getFEATURE().add( fromUsedX ); 
						}
						else if( StringUtils.equals( fromOfferX.getATTR_VALUE(), fromUsedX.getATTR_VALUE() ) ){
							fromOfferX.setPRE_ATTR_VALUE( fromUsedX.getATTR_VALUE() );
							fromOfferX.setSTATUS( IUpdcConst.IState.U );
						}
						else{
							fromOfferX.setPRE_ATTR_VALUE( fromUsedX.getATTR_VALUE() );
							fromOfferX.setSTATUS( IUpdcConst.IState.X );
						}
					}
				}
				finally{
					
				}
			}
		}
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
		/**
		 * 根据服务能力规范查询当前用户服务产品订购
		 * @param fromUpfgsm 服务能力规范
		 * @param fromUser 服务定单用户
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderOffer[] getSFOrderOffer( ISystemTemplate.IUpfgsmOffer fromUpfgsm, 
				IOVOrderUser fromUser, 
				IUpdcContext aContext ) throws SFException, Exception{
			IOVOrderOffer fromOrdOffer[] = null;
			try
			{
				IProfessionalTemplate.IProductOffer fromUpdcpm = null;
				IProfessionalTemplate.IProductComptel fromComptel = null;
				fromUpdcpm = UpdcpUtils.ICustom._wrap( fromUpfgsm );
				fromComptel = fromUpdcpm != null?fromUpdcpm.getCOMPTEL():null;
				if( fromUpdcpm != null && fromUpdcpm.isPRICE() /*服务产品类开通*/){
					fromOrdOffer = ISystemX.getSFUpdcpPrice(fromUser, fromUpdcpm);
				}
				else if( fromComptel != null && fromComptel.isCOMPETE() /*服务类开通*/ ){
					fromOrdOffer = ISystemX.getSFUpdcpCompete(fromUser, fromUpdcpm);
				}
				else if( fromUpdcpm != null && fromComptel != null /*服务兼容类开通*/ ){
					fromOrdOffer = ISystemX.getSFUpdcpComposite(fromUser, fromUpdcpm);
				}
				else if( fromUpdcpm != null /*服务类开通*/){
					fromOrdOffer = ISystemX.getSFUpdcpCompete(fromUser, fromUpdcpm);
				}
			}
			finally{
				
			}
			return fromOrdOffer;
		}
		public static class ISystemX{
			public ISystemX(){
				super();
			}
			
			/**
			 * 基于服务产品类开通获取当前用户服务产品订购
			 * @param fromUser 开通用户
			 * @param fromUpdcpm
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVOrderOffer[] getSFUpdcpPrice( IOVOrderUser fromUser, 
					IProfessionalTemplate.IProductOffer fromUpdcpm ) throws SFException,Exception{
				java.util.List fromOffer = new java.util.ArrayList();
				try
				{
					for( java.util.Iterator itera = fromUser.getPRODUCTION().iterator(); itera.hasNext(); ){
						IOVOrderOffer fromOrdOffer = (IOVOrderOffer)itera.next();
						if( StringUtils.equals( fromUpdcpm.getID(), String.valueOf( fromOrdOffer.getPRODUCT() ) ) ){
							fromOffer.add( fromOrdOffer );
						}
					}
				}
				finally{
					
				}
				return (IOVOrderOffer[])fromOffer.toArray( new IOVOrderOffer[]{} );
			}
			
			/**
			 * 基于服务兼容类开通获取当前用户服务产品订购
			 * @param fromUser
			 * @param fromUpdcpm
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVOrderOffer[] getSFUpdcpComposite( IOVOrderUser fromUser, 
					IProfessionalTemplate.IProductOffer fromUpdcpm ) throws SFException,Exception{
				java.util.List fromOffer = new java.util.ArrayList();
				try
				{
					IProfessionalTemplate.IProductComptel fromUpdcpmx = fromUpdcpm.getCOMPTEL();
					for( java.util.Iterator itera = fromUser.getPRODUCTION().iterator(); itera.hasNext(); ){
						IOVOrderOffer fromOrdOffer = (IOVOrderOffer)itera.next();
						if( StringUtils.equals( fromUpdcpm.getID(), String.valueOf( fromOrdOffer.getCOMPETE() ) ) &&
								StringUtils.equals( fromOrdOffer.getCOMPOSITE(), fromUpdcpmx.getCATEGORY() ) ){
							fromOffer.add( fromOrdOffer );
						}
					}
				}
				finally{
					
				}
				return (IOVOrderOffer[])fromOffer.toArray( new IOVOrderOffer[]{} );
			}
			
			/**
			 * 基于服务类开通获取当前用户服务产品订购
			 * @param fromUser
			 * @param fromUpdcpm
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVOrderOffer[] getSFUpdcpCompete( IOVOrderUser fromUser, 
					IProfessionalTemplate.IProductOffer fromUpdcpm ) throws SFException,Exception{
				java.util.List fromOffer = new java.util.ArrayList();
				try
				{
					for( java.util.Iterator itera = fromUser.getPRODUCTION().iterator(); itera.hasNext(); ){
						IOVOrderOffer fromOrdOffer = (IOVOrderOffer)itera.next();
						if( StringUtils.equals( fromUpdcpm.getID(), String.valueOf( fromOrdOffer.getCOMPETE() ) ) ){
							fromOffer.add( fromOrdOffer );
						}
					}
				}
				finally{
					
				}
				return (IOVOrderOffer[])fromOffer.toArray( new IOVOrderOffer[]{} );
			}
			
			/**
			 * 基于原始服务类开通获取当前用户服务产品订购
			 * @param fromUser
			 * @param fromUpdcpm
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVOrderOffer[] getSFUpdcpComptel( IOVOrderUser fromUser, 
					IProfessionalTemplate.IProductOffer fromUpdcpm ) throws SFException,Exception{
				java.util.List fromOffer = new java.util.ArrayList();
				try
				{
					for( java.util.Iterator itera = fromUser.getPRODUCTION().iterator(); itera.hasNext(); ){
						IOVOrderOffer fromOrdOffer = (IOVOrderOffer)itera.next();
						if( StringUtils.equals( fromUpdcpm.getID(), String.valueOf( fromOrdOffer.getCOMPTEL() ) ) ){
							fromOffer.add( fromOrdOffer );
						}
					}
				}
				finally{
					
				}
				return (IOVOrderOffer[])fromOffer.toArray( new IOVOrderOffer[]{} );
			}
		}
	}
	public static class IIfElse{
		public IIfElse(){
			super();
		}
	}

}
