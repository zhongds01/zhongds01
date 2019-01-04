package com.ai.sacenter.servicefulfil;

import com.ai.sacenter.SFException;
import com.ai.sacenter.common.ISystemKernelImpl;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;

public class SystemKernelImpl extends ISystemKernelImpl {

	public SystemKernelImpl() {
		super();
	}
	
	/**
	 * 
	 * @param aOPRTIME
	 * @param aFORMAT
	 * @param fromORDER
	 * @return
	 * @throws Exception
	 */
	public String getSYSDATE( String aOPRTIME, String aFORMAT, IOVOrderPentium fromORDER ) throws Exception{
		return format( aOPRTIME, aFORMAT );
	}
	
	/**
	 * 
	 * @param aOPRTIME
	 * @param aFORMAT
	 * @param fromORDER
	 * @return
	 * @throws Exception
	 */
	public String getSYSDATE( String aOPRTIME, String aFORMAT, int aDays, IOVOrderPentium fromORDER ) throws Exception{
		return format( aOPRTIME, aFORMAT );
	}
	
	/**
	 * 
	 * @param fromUser
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public String getVPMN_FLGAS( IOVOrderUser fromUser ) throws SFException,Exception{
		return "C";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMULTLE(){
		return "TRUE";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMULTLE( int str1, String str2 ){
		return "TRUE";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMULTLE(Boolean map){
		return "TRUE";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMULTLE(char map){
		return "TRUE";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMULTLE(java.util.Map map){
		return "TRUE";
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMULTLE(java.util.List map){
		return "TRUE";
	}
}
