package com.ai.sacenter.net;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.aif.csf.client.service.factory.CsfServiceCaller;

public class ICardPerformance {
	private final static Log log = LogFactory.getLog( ICardPerformance.class );
	public ICardPerformance() {
		super();
	}

	public static void main(String[] args) {
		try
		{
			int fromThreads = 5;
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
				while( true ){
					Object openObject=null;
					try
					{
						if(log.isDebugEnabled()){log.debug("开始调用用开通中心-----------------");}
						openObject=CsfServiceCaller.call(new Object[]{"open_IZjCmccCSV_rcmsICardDisp",
								"579909998888","571",String.valueOf( System.currentTimeMillis() )});
						if(log.isDebugEnabled()){log.debug("调用开通中心csf成功！！---------------"+openObject.toString());}
					}catch(Exception e){
						if(log.isDebugEnabled()){log.debug("调用开通中心csf异常"+e);}
					}
				}
			}
			finally{
				
			}
		}
		
	}
}
