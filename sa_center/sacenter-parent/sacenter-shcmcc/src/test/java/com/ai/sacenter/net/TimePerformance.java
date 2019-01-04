package com.ai.sacenter.net;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TimePerformance {
	private final static Log log = LogFactory.getLog( TimePerformance.class );
	public TimePerformance() {
		super();
	}

	public static void main(String[] args) {
		try
		{
			int fromThreads = 1;
			for( int index = 0; index < fromThreads; index++ ){
				new TimeClientHandler().start();
			}
			while( true ){
				try
				{
					Thread.currentThread().sleep( 1000 );
				}
				catch( java.lang.Exception aException ){
					
				}
				finally{
					
				}
			}
		}
		finally{
			
		}
	}
	public static class TimeClientHandler extends java.lang.Thread{
		public TimeClientHandler(){
			super();
		}

		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		public void run() {
			try
			{
				//ZjCmccCSFImpl fromICardImpl = new ZjCmccCSFImpl();
				while( true ){
					try
					{
						//if( log.isDebugEnabled() ) log.debug( fromICardImpl );
						//fromICardImpl.rcmsICardDisp("579909998888", "571", String.valueOf( System.currentTimeMillis() ) );
					}
					catch( java.lang.Exception aEXCEPTION ){
						if( log.isErrorEnabled() ) log.error( aEXCEPTION.getMessage(), aEXCEPTION );
					}
					finally{
						
					}
				}
			}
			finally{
				
			}
		}
		
	}
}
