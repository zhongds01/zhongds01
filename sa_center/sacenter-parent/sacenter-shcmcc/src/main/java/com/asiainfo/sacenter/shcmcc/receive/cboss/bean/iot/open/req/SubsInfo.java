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
 * 用户信息
 * 
 * @version $Revision$ $Date$
**/
public class SubsInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 用户唯一标识
    **/
    private java.lang.String _subsID;

    /**
     * 服务号码
    **/
    private java.lang.String _servNumber;

    /**
     * 产品编码
    **/
    private java.lang.String _prodID;

    /**
     * 创建时间
    **/
    private java.lang.String _createDate;

    /**
     * 开始时间
    **/
    private java.lang.String _startDate;

    /**
     * 失效时间
    **/
    private java.lang.String _invalidDate;

    /**
     * 用户状态
    **/
    private java.lang.String _status;


      //----------------/
     //- Constructors -/
    //----------------/

    public SubsInfo() {
        super();
    } //-- SubsInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'createDate'. The field
     * 'createDate' has the following description: 创建时间
     * 
     * @return the value of field 'createDate'.
    **/
    public java.lang.String getCreateDate()
    {
        return this._createDate;
    } //-- java.lang.String getCreateDate() 

    /**
     * Returns the value of field 'invalidDate'. The field
     * 'invalidDate' has the following description: 失效时间
     * 
     * @return the value of field 'invalidDate'.
    **/
    public java.lang.String getInvalidDate()
    {
        return this._invalidDate;
    } //-- java.lang.String getInvalidDate() 

    /**
     * Returns the value of field 'prodID'. The field 'prodID' has
     * the following description: 产品编码
     * 
     * @return the value of field 'prodID'.
    **/
    public java.lang.String getProdID()
    {
        return this._prodID;
    } //-- java.lang.String getProdID() 

    /**
     * Returns the value of field 'servNumber'. The field
     * 'servNumber' has the following description: 服务号码
     * 
     * @return the value of field 'servNumber'.
    **/
    public java.lang.String getServNumber()
    {
        return this._servNumber;
    } //-- java.lang.String getServNumber() 

    /**
     * Returns the value of field 'startDate'. The field
     * 'startDate' has the following description: 开始时间
     * 
     * @return the value of field 'startDate'.
    **/
    public java.lang.String getStartDate()
    {
        return this._startDate;
    } //-- java.lang.String getStartDate() 

    /**
     * Returns the value of field 'status'. The field 'status' has
     * the following description: 用户状态
     * 
     * @return the value of field 'status'.
    **/
    public java.lang.String getStatus()
    {
        return this._status;
    } //-- java.lang.String getStatus() 

    /**
     * Returns the value of field 'subsID'. The field 'subsID' has
     * the following description: 用户唯一标识
     * 
     * @return the value of field 'subsID'.
    **/
    public java.lang.String getSubsID()
    {
        return this._subsID;
    } //-- java.lang.String getSubsID() 

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
     * Sets the value of field 'createDate'. The field 'createDate'
     * has the following description: 创建时间
     * 
     * @param createDate the value of field 'createDate'.
    **/
    public void setCreateDate(java.lang.String createDate)
    {
        this._createDate = createDate;
    } //-- void setCreateDate(java.lang.String) 

    /**
     * Sets the value of field 'invalidDate'. The field
     * 'invalidDate' has the following description: 失效时间
     * 
     * @param invalidDate the value of field 'invalidDate'.
    **/
    public void setInvalidDate(java.lang.String invalidDate)
    {
        this._invalidDate = invalidDate;
    } //-- void setInvalidDate(java.lang.String) 

    /**
     * Sets the value of field 'prodID'. The field 'prodID' has the
     * following description: 产品编码
     * 
     * @param prodID the value of field 'prodID'.
    **/
    public void setProdID(java.lang.String prodID)
    {
        this._prodID = prodID;
    } //-- void setProdID(java.lang.String) 

    /**
     * Sets the value of field 'servNumber'. The field 'servNumber'
     * has the following description: 服务号码
     * 
     * @param servNumber the value of field 'servNumber'.
    **/
    public void setServNumber(java.lang.String servNumber)
    {
        this._servNumber = servNumber;
    } //-- void setServNumber(java.lang.String) 

    /**
     * Sets the value of field 'startDate'. The field 'startDate'
     * has the following description: 开始时间
     * 
     * @param startDate the value of field 'startDate'.
    **/
    public void setStartDate(java.lang.String startDate)
    {
        this._startDate = startDate;
    } //-- void setStartDate(java.lang.String) 

    /**
     * Sets the value of field 'status'. The field 'status' has the
     * following description: 用户状态
     * 
     * @param status the value of field 'status'.
    **/
    public void setStatus(java.lang.String status)
    {
        this._status = status;
    } //-- void setStatus(java.lang.String) 

    /**
     * Sets the value of field 'subsID'. The field 'subsID' has the
     * following description: 用户唯一标识
     * 
     * @param subsID the value of field 'subsID'.
    **/
    public void setSubsID(java.lang.String subsID)
    {
        this._subsID = subsID;
    } //-- void setSubsID(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/


}
