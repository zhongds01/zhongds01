/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id$
 */

package com.asiainfo.sacenter.shcmcc.receive.cboss.bean.iot.open.req;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/


/**
 * 每一位EC管理员参数信息
 * 
 * @version $Revision$ $Date$
**/
public class MgrInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * EC管理员标识
    **/
    private java.lang.String _mgrID;

    /**
     * EC管理员名称
    **/
    private java.lang.String _mgrName;

    /**
     * EC管理员手机号
    **/
    private java.lang.String _mgrMSISDN;


      //----------------/
     //- Constructors -/
    //----------------/

    public MgrInfo() {
        super();
    } //-- MgrInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'mgrID'. The field 'mgrID' has
     * the following description: EC管理员标识
     * 
     * @return the value of field 'mgrID'.
    **/
    public java.lang.String getMgrID()
    {
        return this._mgrID;
    } //-- java.lang.String getMgrID() 

    /**
     * Returns the value of field 'mgrMSISDN'. The field
     * 'mgrMSISDN' has the following description: EC管理员手机号
     * 
     * @return the value of field 'mgrMSISDN'.
    **/
    public java.lang.String getMgrMSISDN()
    {
        return this._mgrMSISDN;
    } //-- java.lang.String getMgrMSISDN() 

    /**
     * Returns the value of field 'mgrName'. The field 'mgrName'
     * has the following description: EC管理员名称
     * 
     * @return the value of field 'mgrName'.
    **/
    public java.lang.String getMgrName()
    {
        return this._mgrName;
    } //-- java.lang.String getMgrName() 

    /**
    **/


    /**
     * 
     * 
     * @param out
    **/


    /**
     * 
     * 
     * @param handler
    **/


    /**
     * Sets the value of field 'mgrID'. The field 'mgrID' has the
     * following description: EC管理员标识
     * 
     * @param mgrID the value of field 'mgrID'.
    **/
    public void setMgrID(java.lang.String mgrID)
    {
        this._mgrID = mgrID;
    } //-- void setMgrID(java.lang.String) 

    /**
     * Sets the value of field 'mgrMSISDN'. The field 'mgrMSISDN'
     * has the following description: EC管理员手机号
     * 
     * @param mgrMSISDN the value of field 'mgrMSISDN'.
    **/
    public void setMgrMSISDN(java.lang.String mgrMSISDN)
    {
        this._mgrMSISDN = mgrMSISDN;
    } //-- void setMgrMSISDN(java.lang.String) 

    /**
     * Sets the value of field 'mgrName'. The field 'mgrName' has
     * the following description: EC管理员名称
     * 
     * @param mgrName the value of field 'mgrName'.
    **/
    public void setMgrName(java.lang.String mgrName)
    {
        this._mgrName = mgrName;
    } //-- void setMgrName(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/

}
