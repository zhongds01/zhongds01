package com.ai.sacenter.util;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.common.UpfsvcVantage;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.comptel.valuebean.IOVUpdcpOfferImpl;
import com.ai.sacenter.comptel.valuebean.IOVUpdcpfxOfferImpl;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.jeval.JevalSTKEngine;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderOffer;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年10月13日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdcpUtils {
	public UpdcpUtils() {
		super();
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年10月13日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ICustom{
		public ICustom(){
			super();
		}
		/**
		 * 根据服务能力规范查询二级服务能力规范
		 * @param fromUpfgsm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProfessionalTemplate.IProductOffer _wrap( ISystemTemplate.IUpfgsmOffer fromUpfgsm ) throws SFException, Exception{
			IProfessionalTemplate.IProductOffer fromUpdcpm = null;
			try
			{
				if( fromUpfgsm.isUpdcpm()/*服务产品能力*/){
					IProfessionalTemplate.IUpdbfgsmOffer fromUpdpgm = null;
					fromUpdpgm = (IProfessionalTemplate.IUpdbfgsmOffer)fromUpfgsm;
					fromUpdcpm = fromUpdpgm.getCOMPETE_();
				}
				else if( fromUpfgsm.isUpdcpfm()/*服务属性能力*/){
					IProfessionalTemplate.IUpdbfgsmxOffer fromUpdpgm = null;
					fromUpdpgm = (IProfessionalTemplate.IUpdbfgsmxOffer)fromUpfgsm;
					fromUpdcpm = fromUpdpgm.getMAPPING_();
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		/**
		 * 
		 * @param fromUpfgsm
		 * @param fromCOMPTEL
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpOffer wrap( ISystemTemplate.IUpfgsmOffer fromUpfgsm, 
				String fromCOMPTEL ) throws SFException, Exception{
			IOVUpdcpOffer fromOffer = null;
			try
			{
				if( fromUpfgsm.isUpdcpm() /*服务操作能力*/){
					IProfessionalTemplate.IUpdbfgsmOffer fromUpdcpm = null;
					fromUpdcpm = (IProfessionalTemplate.IUpdbfgsmOffer)fromUpfgsm;
					fromOffer = IICustom._wrap( fromUpdcpm );
					fromOffer.setCOMPTEL( fromCOMPTEL );
				}
				else if( fromUpfgsm.isUpdcpfm()/*服务能力属性*/){
					IProfessionalTemplate.IUpdbfgsmxOffer fromUpdcpm = null;
					fromUpdcpm = (IProfessionalTemplate.IUpdbfgsmxOffer)fromUpfgsm;
					fromOffer = IICustom._wrap( fromUpdcpm );
					fromOffer.setCOMPTEL( fromCOMPTEL );
				}
			}
			finally{
				
			}
			return fromOffer;
		}
		/**
		 * 
		 * @param fromUpdcpm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdcpOffer wrap( IOVUpdcpOffer fromUpdcpm ) throws SFException, Exception{
			IOVUpdcpOffer fromOffer = null;
			try
			{
				fromOffer = ICustom.wrap(fromUpdcpm.getCATALOG(), fromUpdcpm.getCOMPTEL() );
				ClassUtils.IMerge.merge( fromUpdcpm.getCOMPLEX(), fromOffer.getCOMPLEX() );
			}
			finally{
				
			}
			return fromOffer;
		}
		/**
		 * 服务产品订购转换为服务产品变化轨迹
		 * @param fromOffer 开通服务产品
		 * @param fromTrail 服务产品轨迹
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static WeakLateTrail trajectory( IProfessionalTemplate.IProductComptel fromUpffx,
				String fromOffer, 
				WeakLateTrail fromTrail ) throws SFException, Exception{
			try
			{
				if( IIfElse.isCREATE( fromUpffx, fromOffer ) /*订购*/){
					if( fromTrail.getCREATE() == null ){
						fromTrail.setCREATE( new WeakLateTrail.WeakTrail() );
					}
				}
				else if( IIfElse.isCANCEL( fromUpffx, fromOffer ) /*退订*/){
					if( fromTrail.getCANCEL() == null ){
						fromTrail.setCANCEL( new WeakLateTrail.WeakTrail() );
					}
				}
				else if( IIfElse.isMODIFY( fromUpffx, fromOffer ) /*变化*/){
					if( fromTrail.getCHANGE() == null ){
						fromTrail.setCHANGE( new WeakLateTrail.WeakTrail() );
					}
				}
				else if( StringUtils.isBlank( fromOffer ) == false /*其他*/){
					if( fromTrail.getOTHER() == null ){
						fromTrail.setOTHER( new WeakLateTrail.WeakTrail() );
					}
				}
			}
			finally{
				
			}
			return fromTrail;
		}
		/**
		 * 服务产品变化轨迹转换为最终状态
		 * 1.所有服务产品[订购],则返回服务产品组为[订购[C]]
		 * 2.所有服务产品[退订],则返回服务产品组为[退订[E]]
		 * 3.所有服务产品[保持],则返回服务产品组为[保持[U]]
		 * 4.所有服务产品[依赖],则返回服务产品组为[依赖[U]]
		 * 5.所有服务产品[变更],则返回服务产品组为[保持[U]]
		 * 6.服务产品[订购,退订],则返回服务产品组为[变更[X]]
		 * 7.服务产品[订购,*],则返回服务产品组为[变更[X]]
		 * 8.服务产品[退订,*],则返回服务产品组为[变更[X]]
		 * @param fromTrail 服务产品轨迹
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String change(WeakLateTrail fromTrail ) throws SFException, Exception{
			String fromLate = null;
			try
			{
				if( fromTrail.getOTHER() != null && ( fromTrail.getCREATE() == null &&
						fromTrail.getCANCEL() == null && fromTrail.getCHANGE() == null )/*保持不变*/){
					fromLate = IUpdcConst.IState.U;
				}
				else if( fromTrail.getCHANGE() != null /*变更*/){
					fromLate = IUpdcConst.IState.X;
				}
				else if( fromTrail.getOTHER() != null && ( fromTrail.getCREATE() != null 
						|| fromTrail.getCANCEL() != null ) /*变更*/){
					fromLate = IUpdcConst.IState.X;
				}
				else if( fromTrail.getCREATE() != null && fromTrail.getCANCEL() == null /*订购*/){
					fromLate = IUpdcConst.IState.C;
				}
				else if( fromTrail.getCREATE() == null && fromTrail.getCANCEL() != null /*退订*/){
					fromLate = IUpdcConst.IState.E;
				}
				else if( fromTrail.getCREATE() != null && fromTrail.getCANCEL() != null/*变更*/){
					fromLate = IUpdcConst.IState.X;
				}
			}
			finally{
				
			}
			return fromLate;
		}
		/**
		 * 服务产品订购转换为服务产品变化轨迹
		 * @param fromOffer 开通服务产品
		 * @param fromTrail 服务产品轨迹
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static WeakLateTrail wrap( IOVUpdcpOffer fromOffer, 
				WeakLateTrail fromTrail ) throws SFException, Exception{
			try
			{
				IProfessionalTemplate.IProductOffer fromUpffx = null;
				IProfessionalTemplate.IProductComptel fromUpffxm = null;
				fromUpffx = fromOffer.getPROVIDER();
				if( fromUpffx != null ){ fromUpffxm = fromUpffx.getCOMPTEL(); }
				if( fromUpffxm != null && fromUpffxm.getCOMPTELX().isBASIC() ){
					fromTrail = ICustom.trajectory(fromUpffxm, fromOffer.getCOMPTEL(), fromTrail);
				}
			}
			finally{
				
			}
			return fromTrail;
		}
		/**
		 * 
		 * @param fromUpffmx
		 * @param fromOffer
		 * @param fromUpdcpm
		 * @throws SFException
		 * @throws Exception
		 */
		public static void wrap(IProfessionalTemplate.IUpdbfgsmxOffer fromUpffmx,
				IOVUpdcpOffer fromOffer,
				IOVUpdcpOffer fromUpdcpm )  throws SFException, Exception{
			try
			{
				IProfessionalTemplate.IProductOffer fromUpffx = fromUpffmx.getMAPPING_();
				ClassUtils.IMerge.merge( fromOffer.getCOMPLEX(), fromUpdcpm.getCOMPLEX() );
				if( StringUtils.isBlank( fromOffer.getCOMPTEL() ) == false ){
					if( StringUtils.isBlank( fromUpffmx.getMAPPING() ) == false ){
						fromUpdcpm.getCOMPLEX().put( fromUpffmx.getMAPPING(), fromOffer.getCOMPTEL() );
					}
					else if( fromUpffx != null ){
						fromUpdcpm.getCOMPLEX().put( fromUpffx.getCOMPETE(), fromOffer.getCOMPTEL() );
					}
				}
			}
			finally{
				
			}
		}
		/**
		 * 根据激活产品能力转移属性以^符号开头的额外开通串
		 * @param fromUpdcpm
		 * @param fromUpfwm
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.Map wrap( java.util.Map fromUpdcpm , 
				java.util.Map fromUpfwm ) throws SFException, Exception{
			try
			{
				for( java.util.Iterator itera = fromUpdcpm.entrySet().iterator(); itera.hasNext(); ){
					java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
					Object aFEATURE = fromEntry.getKey();
					if( aFEATURE != null && ClassUtils.IClass.isString( aFEATURE ) &&
							UpfwmUtils.IIfElse.isPARAM( (String)aFEATURE ) ){
						aFEATURE =StringUtils.substring((String)aFEATURE, 1 );
						fromUpfwm.put( aFEATURE, fromEntry.getValue() );
					}
				}
			}
			finally{
				
			}
			return fromUpfwm;
		}
		/**
		 * 服务变量编码转换为服务变量路径
		 * @param aCOMPETE
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String wrap( String aCOMPETE ) throws SFException,Exception{
			try
			{
				if( StringUtils.startWith( aCOMPETE, "$" ) ){
					IProfessionalTemplate.IComptelKernel fromUpdcpm = null;
					aCOMPETE = StringUtils.substring( aCOMPETE, 1 );
					fromUpdcpm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpKernel( aCOMPETE );
					if( fromUpdcpm != null ){ aCOMPETE = fromUpdcpm.getCOMPLEX(); }
				}
			}
			finally{
				
			}
			return aCOMPETE;
		}
		/**
		 * 批量属性转换为属性数组
		 * @param fromObject 批量属性(包含批量标志&或/)
		 * @return
		 */
		public static String[] batchx(String fromObject) {
			String fromArray[] = null;
			try {
				if (StringUtils.isBlank(fromObject))
					fromArray = new String[] {};
				else if (StringUtils.contains(fromObject, "/"))
					fromArray = StringUtils.wildcardArray(fromObject, "/");
				else if (StringUtils.contains(fromObject, "&"))
					fromArray = StringUtils.wildcardArray(fromObject, "&");
				else
					fromArray = new String[] { fromObject };
			} finally {

			}
			return fromArray;
		}
		/**
		 * 根据批量功能分解单条功能上发
		 * @param fromOffer
		 * @param aBatchxDL 多元素标签[APNDTIPL=APNDTIPL;APNJTIPL=APNJTIPL;APNJTIPLL=APNJTIPLL]
		 * @param aITagsIdL 是否只aIJevaDLL内标签包含订购中
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.Map[] batchx( java.util.Map fromOffer,
					String aBatchxDL, 
					boolean aITagsIdL, 
				    java.util.Map aContext) throws SFException, Exception{
			java.util.List fromBatch = new java.util.ArrayList();
			java.util.Map fromBatchX = JdomUtils.ICustom.wrap( aBatchxDL , (java.util.HashMap)null );
			try
			{
				int fromCount = 0;
				for( java.util.Iterator itera = fromBatchX.entrySet().iterator() ; itera.hasNext() ; ){
					java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
					String fromObject = (String)fromOffer.get( aEntry.getValue() );
					if( StringUtils.isBlank( fromObject ) == false ){
						fromCount = batchx( fromObject ).length;
						break;
					}
				}
				for(int index = 0 ; index < fromCount ; index++){
					java.util.Map aUpdgsmLife = new java.util.HashMap();
					if( aITagsIdL == false ) ClassUtils.IMerge.merge( fromOffer , aUpdgsmLife );
					for( java.util.Iterator itera = fromBatchX.entrySet().iterator() ; itera.hasNext() ; ){
						java.util.Map.Entry aEntry = (java.util.Map.Entry)itera.next();
						aUpdgsmLife.remove( aEntry.getValue() );
						String fromObject = (String)fromOffer.get( aEntry.getValue() );
						if( fromObject == null ) continue;
						String fromArray[] = batchx( fromObject );
						if( fromArray.length != fromCount ) ExceptionFactory.throwIllegal("IOS0010009", new String[]{(String)aEntry.getValue() } );
						if( fromArray[index] != null ) aUpdgsmLife.put( aEntry.getKey() , fromArray[index] );
					}
					fromBatch.add( aUpdgsmLife );
				}
			}
			finally{
				if( fromBatchX != null ){ fromBatchX.clear() ; fromBatchX = null;}
			}
			return (java.util.Map[])fromBatch.toArray( new java.util.Map[]{} );
		}
		public static class IICustom{
			public IICustom(){
				super();
			}
			/**
			 * 
			 * @param fromUpdcpm
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVUpdcpOffer _wrap( IProfessionalTemplate.IUpdbfgsmOffer fromUpdcpm ) throws SFException, Exception{
				IOVUpdcpOffer fromOffer = null;
				try
				{
					IProfessionalTemplate.IComptelOffer fromCATALOG = null;
					IProfessionalTemplate.IProductOffer fromCOMPTEL = null;
					fromCATALOG = fromUpdcpm.getCATALOG_();
					fromCOMPTEL = fromUpdcpm.getCOMPETE_();
					fromOffer = new IOVUpdcpOfferImpl( fromCATALOG.getCOMPETE(), 
							fromCATALOG.getCOMPETE(), 
							fromUpdcpm,
							fromCOMPTEL);
					if( fromCOMPTEL == null ) ExceptionFactory.throwIllegal("IOS0011019", new String[]{ fromUpdcpm.getCOMPETE() });
					if( fromCOMPTEL.getCOMPTEL() != null && StringUtils.isBlank( 
							fromCOMPTEL.getCOMPTEL().getCOMPLEX() ) == false ){
						JdomUtils.ICustom.wrap( fromCOMPTEL.getCOMPTEL().getCOMPLEX(), 
								fromOffer.getCOMPLEX() );
					}
				}
				finally{
					
				}
				return fromOffer;
			}
			/**
			 * 
			 * @param fromUpdcpm
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static IOVUpdcpOffer _wrap( IProfessionalTemplate.IUpdbfgsmxOffer fromUpdcpm ) throws SFException, Exception{
				IOVUpdcpOffer fromOffer = null;
				try
				{
					IProfessionalTemplate.IComptelCatalog fromCATALOG = null;
					IProfessionalTemplate.IProductOffer fromCOMPTEL = null;
					fromCATALOG = fromUpdcpm.getCATALOG_();
					fromCOMPTEL = fromUpdcpm.getMAPPING_();
					fromOffer = new IOVUpdcpfxOfferImpl( fromCATALOG.getPRODUCT(),
							fromUpdcpm,
							fromCOMPTEL);
					if( fromCOMPTEL.getCOMPTEL() != null && StringUtils.isBlank( 
							fromCOMPTEL.getCOMPTEL().getCOMPLEX() ) == false ){
						JdomUtils.ICustom.wrap( fromCOMPTEL.getCOMPTEL().getCOMPLEX(), 
								fromOffer.getCOMPLEX() );
					}
				}
				finally{
					
				}
				return fromOffer;
			}
		}
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		/**
		 * 获取当前线程上开通定单请求
		 * @param aContext
		 * @return
		 */
		public static IOVOrderRequest getOBJECTIVE( IUpdcContext aContext ){
			return (IOVOrderRequest)aContext.get( IUpdcConst.IUpdbm.IUpdbf.OBJECTIVE );
		}
		
		/**
		 * 获取当前线程上开通工单
		 * @param aContext
		 * @return
		 */
		public static IOVOrderPentium getORDER( IUpdcContext aContext ){
			return (IOVOrderPentium)aContext.get( IUpdcConst.IUpdbm.IUpdbf.ORDER );
		}
		
		/**
		 * 获取当前线程上服务能力集
		 * @param aContext
		 * @return
		 */
		public static IProfessionalTemplate.IProductOffer getPROGRAM( IUpdcContext aContext ){
			return (IProfessionalTemplate.IProductOffer)aContext.get( IUpdcConst.IUpdbm.IUpdbf.PROGRAM );
		}
		
		/**
		 * 获取当前线程上定单用户
		 * @param aContext
		 * @return
		 */
		public static IOVOrderUser getUSER( IUpdcContext aContext ){
			return (IOVOrderUser)aContext.get( IUpdcConst.IUpdbm.IUpdbf.USER );
		}
		
		/**
		 * 获取当前线程上服务群组用户
		 * @param aContext
		 * @return
		 */
		public static IOVOrderUser getGROUP( IUpdcContext aContext ){
			return (IOVOrderUser)aContext.get( IUpdcConst.IUpdbm.IUpdbf.GROUP );
		}
		
		/**
		 * 获取当前线程上服务群组成员用户
		 * @param aContext
		 * @return
		 */
		public static java.util.List getMEMBER( IUpdcContext aContext ){
			return (java.util.List)aContext.get( IUpdcConst.IUpdbm.IUpdbf.MEMBER );
		}
		
		/**
		 * 获取当前线程上用户服务产品订购
		 * @return
		 */
		public static IOVOrderOffer getOFFER( IUpdcContext aContext ){
			return (IOVOrderOffer)aContext.get( IUpdcConst.IUpdbm.IUpdbf.PRODUCTION );
		}
		
		/**
		 * 根据产品编号获取产品规范
		 * @param aCOMPETE_ID 产品编号
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProfessionalTemplate.IProductOffer getCOMPETE( long aCOMPETE_ID ) throws SFException, Exception{
			IProfessionalTemplate.IProductOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpOffer( aCOMPETE_ID );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据服务编码获取服务产品规范
		 * @param aCOMPETE 服务编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProfessionalTemplate.IProductOffer getCOMPETE( String aCOMPETE ) throws SFException, Exception{
			IProfessionalTemplate.IProductOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpComptel( aCOMPETE );
				if( fromUpdcpm == null && MathUtils.isNumeric( aCOMPETE ) ){
					fromUpdcpm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpOffer( MathUtils.decimal( aCOMPETE ) );
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据服务编码获取服务产品开通规范
		 * @param aCOMPETE 服务编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProfessionalTemplate.IProductComptel getSUBJECT( String aCOMPETE ) throws SFException, Exception{
			IProfessionalTemplate.IProductComptel fromUpffx = null;
			try
			{
				IProfessionalTemplate.IProductOffer fromUpdcpm = null;
				fromUpdcpm = ISystem.getCOMPETE( aCOMPETE );
				if( fromUpdcpm != null ){ fromUpffx = fromUpdcpm.getCOMPTEL(); }
			}
			finally{
				
			}
			return fromUpffx;
		}
		
		/**
		 * 根据产品规格和产品操作查询服务激活能力
		 * @param fromCATALOG 产品规格
		 * @param fromBUSINES 产品操作
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProfessionalTemplate.IProductOffer getBUSINES( long fromCATALOG, long fromBUSINES ) throws SFException, Exception{
			IProfessionalTemplate.IProductOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpBusines( String.valueOf( fromCATALOG ), 
						String.valueOf( fromBUSINES ) );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据开通工单和产品操作查询服务激活能力
		 * @param fromPentium 开通工单
		 * @param fromBUSINES 产品操作
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProfessionalTemplate.IProductOffer getBUSINES( IOVOrderPentium fromPentium, long fromBUSINES ) throws SFException, Exception{
			IProfessionalTemplate.IProductOffer fromUpdcpm = null;
			try
			{
				fromUpdcpm = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpBusines( fromPentium.getCATALOG(), 
						String.valueOf( fromBUSINES ) );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据开通工单和产品操作查询服务激活能力
		 * @param fromPentium 开通工单
		 * @param fromUpfgsm 产品操作
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IProfessionalTemplate.IProductOffer getBUSINES( IOVOrderPentium fromPentium, 
				IProfessionalTemplate.IUpdbfgsmOffer fromUpfgsm ) throws SFException,Exception{
			IProfessionalTemplate.IProductOffer fromUpdcpm = null;
			try
			{
				IProfessionalTemplate.IComptelOffer fromUpdbfgsm = null;
				fromUpdbfgsm = fromUpfgsm.getCATALOG_();
				fromUpdcpm = getBUSINES(fromPentium, fromUpdbfgsm.getCOMPETE() );
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		
		/**
		 * 根据枚举组编码获取枚举组
		 * @param aGROUP 枚举组编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IEnumGroup getENUM( String aGROUP ) throws SFException,Exception{
			ISystemTemplate.IEnumGroup fromGroup = null;
			try
			{
				fromGroup = IUpdcfgFactory.getIBasicSV().getSFEnumGroup( aGROUP );
			}
			finally{
				
			}
			return fromGroup;
		}
		
		/**
		 * 根据枚举组编码和枚举值获取枚举组
		 * @param aGROUP 枚举组编码
		 * @param aSTATIC 枚举值
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IEnumWrapper getENUM( String aGROUP, String aSTATIC ) throws SFException,Exception{
			ISystemTemplate.IEnumWrapper fromSTATIC = null;
			try
			{
				ISystemTemplate.IEnumGroup fromGroup = null;
				fromGroup = IUpdcfgFactory.getIBasicSV().getSFEnumGroup( aGROUP );
				if( fromGroup != null && StringUtils.isBlank( aSTATIC ) == false ){ 
					fromSTATIC = fromGroup.getENUM( aSTATIC ); 
				}
			}
			finally{
				
			}
			return fromSTATIC;
		}
		
		/**
		 * 
		 * @param fromUpfgsm
		 * @param fromUser
		 * @param fromOrdOffer
		 * @param fromLDAP
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _comptel( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
				IOVOrderUser fromUser, 
				IOVOrderOffer fromOrdOffer,
				java.util.Map fromLDAP) throws SFException, Exception{
			try
			{
				IProfessionalTemplate.IProductOffer fromUpffmx = null;
				if( fromUpfgsm.isUpdcpm() /*服务产品级*/){
					IProfessionalTemplate.IUpdbfgsmOffer fromUpdbfgsm = null;
					fromUpdbfgsm = (IProfessionalTemplate.IUpdbfgsmOffer)fromUpfgsm;
					fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.COMPETENCE, fromUpdbfgsm.getCOMPETE_() );
				}
				else if( fromUpfgsm.isUpdcpfm()/*服务产品属性级*/){
					IProfessionalTemplate.IUpdbfgsmxOffer fromUpdbfgsmx = null;
					fromUpdbfgsmx = (IProfessionalTemplate.IUpdbfgsmxOffer)fromUpfgsm;
					fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.COMPETENCE, fromUpdbfgsmx.getCOMPETE_() );
					fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.COMPOSITE , fromUpdbfgsmx.getMAPPING_() );
				}
				fromUpffmx = UpdcpUtils.ISystem.getCOMPETE( fromOrdOffer.getPRODUCT() );
				if( fromUpffmx != null ) fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.PROTECTION , fromUpffmx );
				fromLDAP.put( IUpdcConst.IUpdbm.IUpdbf.PRODUCTION, fromOrdOffer );
			}
			finally{
				
			}
		}
	}
	public static class IUpfvn{
		public IUpfvn(){
			super();
		}
		/**
		 * 
		 * @param fromUpfgsm
		 * @return
		 */
		public static IProfessionalTemplate.IProductOffer _get_comptel( ISystemTemplate.IUpfgsmOffer fromUpfgsm ){
			IProfessionalTemplate.IProductOffer fromUpdcpm = null;
			try
			{
				if( fromUpfgsm.isUpdcpm() /*服务操作能力*/){
					IProfessionalTemplate.IUpdbfgsmOffer fromCATALOG = null;
					fromCATALOG = (IProfessionalTemplate.IUpdbfgsmOffer)fromUpfgsm;
					fromUpdcpm = fromCATALOG.getCOMPETE_();
				}
				else if( fromUpfgsm.isUpdcpfm()/*服务能力属性*/){
					IProfessionalTemplate.IUpdbfgsmxOffer fromCATALOG = null;
					fromCATALOG = (IProfessionalTemplate.IUpdbfgsmxOffer)fromUpfgsm;
					fromUpdcpm = fromCATALOG.getMAPPING_();
				}
			}
			finally{
				
			}
			return fromUpdcpm;
		}
		/**
		 * 按照服务产品状态拆分服务产品状态转换规范
		 * @param fromUpfgsm 服务产品规范
		 * @param fromUser 服务用户
		 * @param fromOffer 服务产品
		 * @param fromCOMPLEX 服务拆分规范
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String _get_status_splite(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
				IOVOrderUser fromUser,
				IOVOrderOffer fromOffer,
				String fromCOMPLEX,
				IUpdcContext aContext ) throws SFException,Exception{
			Object fromCOMPTEL = null;
			try
			{
				fromCOMPTEL = fromOffer.getSTATUS();
				if( StringUtils.isBlank( fromCOMPLEX ) == false ){
					fromCOMPTEL = UpfgsmUtils.IUpfsm._jj_splite(fromUpfgsm, 
			    			fromUpfgsm.getCOMPETE(), 
			    			fromOffer.getSTATUS(), 
			    			fromOffer.getCOMPLEX(), 
			    			fromCOMPLEX, 
			    			aContext);
				}
			}
			finally{
				
			}
			return fromCOMPTEL != null?fromCOMPTEL.toString():null;
		}
		/**
		 * 按照服务产品状态拆分服务产品状态转换规范
		 * @param fromUpfgsm 服务产品规范
		 * @param fromUser 服务用户
		 * @param fromSTATUS 服务产品状态
		 * @param fromCOMPLEX 服务拆分规范
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String _get_status_splite(ISystemTemplate.IUpfgsmOffer fromUpfgsm,
				IOVOrderUser fromUser,
				String fromSTATUS,
				String fromCOMPLEX,
				IUpdcContext aContext ) throws SFException,Exception{
			Object fromCOMPTEL = null;
			try
			{
				fromCOMPTEL = fromSTATUS;
				if( StringUtils.isBlank( fromSTATUS ) == false &&
						StringUtils.isBlank( fromCOMPLEX ) == false ){
					fromCOMPTEL = UpfgsmUtils.IUpfsm._jj_splite(fromUpfgsm, 
			    			fromUpfgsm.getCOMPETE(), 
			    			fromSTATUS, 
			    			fromUser.getNATURE(), 
			    			fromCOMPLEX, 
			    			aContext);
				}
			}
			finally{
				
			}
			return fromCOMPTEL != null?fromCOMPTEL.toString():null;
		}
		/**
		 * 
		 * @param fromUpfgsm
		 * @param fromUser
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static Object _get_offerx_splite( ISystemTemplate.IUpfgsmOffer fromUpfgsm,
				IOVOrderUser fromUser,
				IUpdcContext aContext ) throws SFException,Exception{
			Object fromOBJECT = null;
			try
			{
				String aCOMPLEX[] = UpfgsmUtils.IUpfsm.getISTKJexpL( fromUpfgsm.getCOMPLEX() );
				if( aCOMPLEX == null || aCOMPLEX.length < 1 ){
					ExceptionFactory.throwIllegal("IOS0011021", new String[]{ fromUpfgsm.getCOMPETE(), "COMPLEX" } );
				}
				fromOBJECT = UpfgsmUtils.IUpfsm._jj_splite(fromUpfgsm, 
						aCOMPLEX[0], 
						fromUser.getNATURE(), 
						aCOMPLEX != null && aCOMPLEX.length > 1?aCOMPLEX[1]:null, 
						aCOMPLEX != null && aCOMPLEX.length > 2?aCOMPLEX[2]:null,
						aContext);
			}
			finally{
				
			}
			return fromOBJECT;
		}
		/**
		 * 
		 * @param aJEXP
		 * @param fromOffer
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static boolean decision( String aJEXP ,
				java.util.Map fromOffer , 
				IUpdcContext aContext ) throws SFException,Exception{
			boolean fromBool = true;
			try
			{
				if( StringUtils.isBlank( aJEXP ) == false ){
					UpfsvcVantage.IUpdfmxDeque fromUpdbpmHome = UpfsvcManager.getRocket().getBlankDeque();
					if( fromUpdbpmHome != null && fromUpdbpmHome.getJEVAL() != null ){
						fromBool = fromUpdbpmHome.getJEVAL().decision( aJEXP );
					}
					else{
						JevalSTKEngine aENGINE = UpfsvcManager.getMBean().getJEVAL();
						fromBool = aENGINE.decision( aJEXP , fromOffer, aContext );
					}
				}
			}
			finally{
				
			}
			return fromBool;
		}
		/**
		 * 
		 * @param aJEXP
		 * @param fromOffer
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String evaluate( String aJEXP , 
				java.util.Map fromOffer , 
				IUpdcContext aContext ) throws SFException,Exception{
			String fromUpffmx = null;
			try
			{
				UpfsvcVantage.IUpdfmxDeque fromUpdbpmHome = UpfsvcManager.getRocket().getBlankDeque();
				if( fromUpdbpmHome != null && fromUpdbpmHome.getJEVAL() != null ){
					fromUpffmx = fromUpdbpmHome.getJEVAL().evaluate( aJEXP );
				}
				else{
					JevalSTKEngine aENGINE = UpfsvcManager.getMBean().getJEVAL();
					fromUpffmx = aENGINE.evaluate( aJEXP, fromOffer, aContext );
				}
			}
			finally{
				
			}
			return fromUpffmx;
		}
		/**
		 * 
		 * @param aJEXP
		 * @param fromOffer
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static String arguments( String aJEXP , 
				java.util.Map fromOffer , 
				IUpdcContext aContext ) throws SFException,Exception{
			String aOBJECT = null;
			try
			{
				JevalSTKEngine aENGINE = UpfsvcManager.getMBean().getJEVAL();
				aOBJECT = aENGINE.arguments( aJEXP, fromOffer, aContext );
				if( StringUtils.isBlank( aOBJECT ) == false && StringUtils.equals( aOBJECT , 
					   IUpdcConst.IEnum.ISschk.NULL ) ) aOBJECT = null;
			}
			finally{
				
			}
			return aOBJECT;
		}
	}
	public static class IIfElse{
		public IIfElse(){
			super();
		}
		
		/**
		 * 是否订购服务产品
		 * @param fromUpffx
		 * @param fromOffer
		 * @return
		 */
		public static boolean isCREATE( IProfessionalTemplate.IProductComptel fromUpffx, 
				String fromOffer ){
			return StringUtils.isBlank( fromOffer ) == false &&
					StringUtils.equals( fromOffer, IUpdcConst.IState.C );
		}
		
		/**
		 * 是否变更服务产品
		 * @param fromUpffx
		 * @param fromOffer
		 * @return
		 */
		public static boolean isMODIFY( IProfessionalTemplate.IProductComptel fromUpffx, 
				String fromOffer ){
			return StringUtils.isBlank( fromOffer ) == false &&
					StringUtils.startWith( fromOffer, IUpdcConst.IState.X );
		}
		
		/**
		 * 是否退订服务产品
		 * @param fromUpffx
		 * @param fromOffer
		 * @return
		 */
		public static boolean isCANCEL( IProfessionalTemplate.IProductComptel fromUpffx, 
				String fromOffer ){
			return StringUtils.isBlank( fromOffer ) == false &&
					StringUtils.equals( fromOffer, IUpdcConst.IState.E );
		}
		
		/**
		 * 服务产品是否保持不变
		 * @param fromUpffx
		 * @param fromOffer
		 * @return
		 */
		public static boolean isHOLDING( IProfessionalTemplate.IProductComptel fromUpffx, 
				String fromOffer ){
			return StringUtils.isBlank( fromOffer ) == false &&
					StringUtils.equals( fromOffer, IUpdcConst.IState.U );
		}
		
		/**
		 * 是否依赖服务产品
		 * @param fromUpffx
		 * @param fromOffer
		 * @return
		 */
		public static boolean isDEPEND( IProfessionalTemplate.IProductComptel fromUpffx, 
				String fromOffer ){
			return StringUtils.isBlank( fromOffer ) == false &&
					StringUtils.equals( fromOffer, IUpdcConst.IState.D );
		}
		
		/**
		 * 是否其它服务产品
		 * @param fromUpffx
		 * @param fromOffer
		 * @return
		 */
		public static boolean isOTHER( IProfessionalTemplate.IProductComptel fromUpffx, 
				String fromOffer ){
			return StringUtils.isBlank( fromOffer ) == false &&
					StringUtils.contains( fromOffer, new String[]{ IUpdcConst.IState.C, 
							IUpdcConst.IState.X, IUpdcConst.IState.E, IUpdcConst.IState.U, 
							IUpdcConst.IState.D} );
		}
	}
}
