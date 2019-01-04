package com.ai.sacenter.subtable.impl;

import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.HQSQLUtils;
import com.ai.sacenter.util.TimeUtils;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 分表规则转换器</p>
 * <p>Copyright: Copyright (c) 2014-12-5</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class SFTableSplitWrapImpl extends ITableSplitWrapImpl implements java.io.Serializable{
	private static final long serialVersionUID = 6850987756352886025L;
	public SFTableSplitWrapImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.subtable.impl.AbstractTableSplitImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
	 */
	public String wrapper(String fromTable, String fromCol, Object fromObj) throws Exception {
		return fromObj != null?fromObj.toString():"";
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.subtable.impl.AbstractTableSplitImpl#magnetic(java.lang.String, java.lang.String, java.util.Map)
	 */
	public Object magnetic(String fromTable, String fromCol, java.util.Map fromPARAM) throws Exception {
		return fromPARAM.get( fromCol );
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 简单字符转换[分表规则转换规范]</p>
	 * <p>Copyright: Copyright (c) 2014-12-5</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class StringWrapImpl extends SFTableSplitWrapImpl{
		private static final long serialVersionUID = -5967003504088099322L;
		public StringWrapImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
		 */
		public String wrapper(String fromTable, 
				String fromCol, 
				Object fromObj) throws Exception {
			return fromObj.toString();
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 地市编码转换[分表规则转换规范]</p>
	 * <p>Copyright: Copyright (c) 2014-12-5</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class RegionIdWrapImpl extends SFTableSplitWrapImpl{
		private static final long serialVersionUID = 425073536870844427L;
		public RegionIdWrapImpl(){
			super();
		}
        /* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
		 */
		public String wrapper(String fromTable, 
				String fromCol, 
				Object fromObj) throws Exception {
			return fromObj.toString();
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 日期转换[分表规则转换规范]</p>
	 * <p>Copyright: Copyright (c) 2014-12-8</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class TimestampWrapImpl extends SFTableSplitWrapImpl{
		private static final long serialVersionUID = -3976756120452037603L;
		public TimestampWrapImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl#magnetic(java.lang.String, java.lang.String, java.util.Map)
		 */
		public Object magnetic(String fromTable, String fromCol, java.util.Map fromPARAM) throws Exception {
			java.util.Date fromTime = null;
			java.util.GregorianCalendar fromCalen = null;
			try
			{
				ISystemTemplate.IUpfgkmComposite fromSubTable = null;
				fromTime = (java.util.Date)fromPARAM.get( fromCol );
				fromSubTable = HQSQLUtils.ISystem.getSFUpfgkmComposite( fromTable );
				if( fromSubTable != null ){
					fromTime = BasicFactory.getIBaseSV().getSysdate();
					fromCalen = new java.util.GregorianCalendar();
					fromCalen.setTimeInMillis( fromTime.getTime() );
					fromCalen.add(java.util.GregorianCalendar.MONTH, 
							-(int)fromSubTable.getCYCLE() );
					fromTime = new java.sql.Timestamp( fromCalen.getTimeInMillis() );
				}
			}
			finally{
				if( fromCalen != null ){ fromCalen = null; }
			}
			return fromTime;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 年转换[分表规则转换规范]</p>
	 * <p>Copyright: Copyright (c) 2014-12-5</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class YYYYWrapImpl extends TimestampWrapImpl{
		private static final long serialVersionUID = 7037391771986966321L;
		public YYYYWrapImpl(){
			super();
		}
		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
		 */
		public String wrapper(String fromTable, 
				String fromCol, 
				Object fromObj) throws Exception {
			String fromYYYY = null;
			try
			{
				if( ClassUtils.IClass.isDate( fromObj ) == false ){
					ExceptionFactory.throwIllegal( "IOS0014017", new String[]{ fromTable , fromCol } );
				}
				fromYYYY = TimeUtils.yyyy( (java.util.Date)fromObj );
			}
			finally{
				
			}
			return fromYYYY;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 年月转换[分表规则转换规范]</p>
	 * <p>Copyright: Copyright (c) 2014-12-5</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class YYYYMMWrapImpl extends TimestampWrapImpl{
		private static final long serialVersionUID = -4101679655705253491L;
		public YYYYMMWrapImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
		 */
		public String wrapper(String fromTable, 
				String fromCol, 
				Object fromObj) throws Exception {
			String fromYYYYMM = null;
			try
			{
				if( ClassUtils.IClass.isDate( fromObj ) == false ){
					ExceptionFactory.throwIllegal( "IOS0014017", new String[]{ fromTable , fromCol } );
				}
				fromYYYYMM = TimeUtils.yyyymm( (java.util.Date)fromObj );
			}
			finally{
				
			}
			return fromYYYYMM;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 年月日转换[分表规则转换规范]</p>
	 * <p>Copyright: Copyright (c) 2014-12-5</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class YYYYMMDDWrapImpl extends TimestampWrapImpl{
		private static final long serialVersionUID = -1927271907487298437L;
		public YYYYMMDDWrapImpl(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFTableSplitWrapImpl#wrapper(java.lang.String, java.lang.String, java.lang.Object)
		 */
		public String wrapper(String fromTable, 
				String fromCol, 
				Object fromObj) throws Exception {
			String fromYYYYMM = null;
			try
			{
				if( ClassUtils.IClass.isDate( fromObj ) == false ){
					ExceptionFactory.throwIllegal( "IOS0014017", new String[]{ fromTable , fromCol } );
				}
				fromYYYYMM = TimeUtils.yyyymmdd( (java.util.Date)fromObj );
			}
			finally{
				
			}
			return fromYYYYMM;
		}
	}
}
