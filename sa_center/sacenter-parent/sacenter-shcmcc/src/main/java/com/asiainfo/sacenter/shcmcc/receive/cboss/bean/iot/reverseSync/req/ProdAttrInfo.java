/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id$
 */

package com.asiainfo.sacenter.shcmcc.receive.cboss.bean.iot.reverseSync.req;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/


/**
 * 产品的附加属�?
 * 
 * @version $Revision$ $Date$
**/
public class ProdAttrInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 服务编码
    **/
    private java.lang.String _serviceID;

    /**
     * 附加属�?�编�?
    **/
    private java.lang.String _attrKey;

    /**
     * 附加属�?��??
    **/
    private java.lang.String _attrValue;

    /**
     * 操作类型
    **/
    private java.lang.String _opertype;


      //----------------/
     //- Constructors -/
    //----------------/

    public ProdAttrInfo() {
        super();
    } //-- ProdAttrInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'attrKey'. The field 'attrKey'
     * has the following description: 附加属�?�编�?
     * 
     * @return the value of field 'attrKey'.
    **/
    public java.lang.String getAttrKey()
    {
        return this._attrKey;
    } //-- java.lang.String getAttrKey() 

    /**
     * Returns the value of field 'attrValue'. The field
     * 'attrValue' has the following description: 附加属�?��??
     * 
     * @return the value of field 'attrValue'.
    **/
    public java.lang.String getAttrValue()
    {
        return this._attrValue;
    } //-- java.lang.String getAttrValue() 

    /**
     * Returns the value of field 'opertype'. The field 'opertype'
     * has the following description: 操作类型
     * 
     * @return the value of field 'opertype'.
    **/
    public java.lang.String getOpertype()
    {
        return this._opertype;
    } //-- java.lang.String getOpertype() 

    /**
     * Returns the value of field 'serviceID'. The field
     * 'serviceID' has the following description: 服务编码
     * 
     * @return the value of field 'serviceID'.
    **/
    public java.lang.String getServiceID()
    {
        return this._serviceID;
    } //-- java.lang.String getServiceID() 

    /**
    **/

    /**
     * 
     * 
     * @param handler
    **/


    /**
     * Sets the value of field 'attrKey'. The field 'attrKey' has
     * the following description: 附加属�?�编�?
     * 
     * @param attrKey the value of field 'attrKey'.
    **/
    public void setAttrKey(java.lang.String attrKey)
    {
        this._attrKey = attrKey;
    } //-- void setAttrKey(java.lang.String) 

    /**
     * Sets the value of field 'attrValue'. The field 'attrValue'
     * has the following description: 附加属�?��??
     * 
     * @param attrValue the value of field 'attrValue'.
    **/
    public void setAttrValue(java.lang.String attrValue)
    {
        this._attrValue = attrValue;
    } //-- void setAttrValue(java.lang.String) 

    /**
     * Sets the value of field 'opertype'. The field 'opertype' has
     * the following description: 操作类型
     * 
     * @param opertype the value of field 'opertype'.
    **/
    public void setOpertype(java.lang.String opertype)
    {
        this._opertype = opertype;
    } //-- void setOpertype(java.lang.String) 

    /**
     * Sets the value of field 'serviceID'. The field 'serviceID'
     * has the following description: 服务编码
     * 
     * @param serviceID the value of field 'serviceID'.
    **/
    public void setServiceID(java.lang.String serviceID)
    {
        this._serviceID = serviceID;
    } //-- void setServiceID(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/


}
