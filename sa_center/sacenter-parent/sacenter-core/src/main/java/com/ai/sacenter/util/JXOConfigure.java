package com.ai.sacenter.util;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-3-19</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */

public class JXOConfigure implements java.io.Serializable {
	private static final long serialVersionUID = 5818364420910400512L;
	public JXOConfigure() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2013-4-7</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ITimeSpan implements java.io.Serializable{
		private static final long serialVersionUID = 448681394260185054L;
		private UUID ID = null;
		private String span;
		private long   start;
		private long   end;
		public ITimeSpan( String aTIMESPAN ){
			super();
			try
			{
				ID = UUID.getUUID();
				String aTimeSpan[] = StringUtils.wildcardArray( aTIMESPAN , "-");
				if( aTimeSpan == null || aTimeSpan.length != 2 || StringUtils.isBlank( aTimeSpan[0] ) || StringUtils.isBlank( aTimeSpan[1] ) )
					throw new java.lang.IllegalArgumentException();
				span = "ddHHmmss";
				String aStart=aTimeSpan[0],aEnd=aTimeSpan[1];
				if( aStart.length() != aEnd.length() ) throw new java.lang.IllegalArgumentException();
				if( aStart.length() == 6 ) span = "HHmmss";
				java.text.DateFormat dateformat = new java.text.SimpleDateFormat(span);
				dateformat.parseObject( aStart.trim() );
				dateformat.parseObject( aEnd.trim() );
				start = Long.parseLong( aStart.trim() );
				end = Long.parseLong( aEnd.trim() );
				if( start > end ){ start=0 ; end = span.length() == 6?235959l:31235959l;}
			}
			catch( java.lang.Exception ee){
				throw new java.lang.RuntimeException(ee);
			}
			finally{
				
			}
		}
		/**
		 * @return the end
		 */
		public long getEnd() {
			return end;
		}
		/**
		 * @return the start
		 */
		public long getStart() {
			return start;
		}
		/**
		 * @param end the end to set
		 */
		public void setEnd(long end) {
			this.end = end;
		}
		/**
		 * @param start the start to set
		 */
		public void setStart(long start) {
			this.start = start;
		}
		/**
		 * @return the span
		 */
		public String getSpan() {
			return span;
		}
		/**
		 * @param span the span to set
		 */
		public void setSpan(String span) {
			this.span = span;
		}
		/**
		 * @return the iD
		 */
		public UUID getID() {
			return ID;
		}
		/**
		 * 
		 * @param curTime
		 * @return
		 * @throws Exception
		 */
		public boolean isWork( java.sql.Timestamp curTime ) throws Exception{
			boolean aUpfmsp = false;
			try
			{
				java.text.DateFormat dateformat = new java.text.SimpleDateFormat( span );
				long cur = Long.parseLong(dateformat.format(curTime));
				aUpfmsp = cur >= start && cur <= end;
			}
			finally{
				
			}
			return aUpfmsp;
		}
	}
	/**
	 * 
	 * <p>Copyright: Copyright (c) 2010-12-3</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IMutexLock implements java.io.Serializable{
		private static final long serialVersionUID = -1171030212604917933L;
		private long   MutexCoSum = 0;
		private Object IMutex = new Object();
		public IMutexLock(){
			super();
		}
		/**
		 * 
		 * @throws Exception
		 */
		public void _waitMutex() throws Exception{
			while( true ){
				synchronized ( this ) {
					if( MutexCoSum <= 0 ) break;
					MutexCoSum -= 1;
					synchronized ( IMutex ) {
						IMutex.wait();
					}
				}
			}
		}
		/**
		 * 
		 * @throws Exception
		 */
		public void _notifyMutex(){
			synchronized ( IMutex ) {
				IMutex.notifyAll();
			}
		}
		/**
		 * 
		 *
		 */
		public void _addMutex( ){
			synchronized ( this ) {
				MutexCoSum += 1;
			}
		}
	}
}
