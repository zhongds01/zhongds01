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
 * ��Ʒ�ĸ�������
 * 
 * @version $Revision$ $Date$
**/
public class ProdAttrInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * �������
    **/
    private java.lang.String _serviceID;

    /**
     * �������Ա���
    **/
    private java.lang.String _attrKey;

    /**
     * ��������ֵ
    **/
    private java.lang.String _attrValue;

    /**
     * ��������
    **/
    private java.lang.String _oprType;


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
     * has the following description: �������Ա���
     * 
     * @return the value of field 'attrKey'.
    **/
    public java.lang.String getAttrKey()
    {
        return this._attrKey;
    } //-- java.lang.String getAttrKey() 

    /**
     * Returns the value of field 'attrValue'. The field
     * 'attrValue' has the following description: ��������ֵ
     * 
     * @return the value of field 'attrValue'.
    **/
    public java.lang.String getAttrValue()
    {
        return this._attrValue;
    } //-- java.lang.String getAttrValue() 

    /**
     * Returns the value of field 'oprType'. The field 'oprType'
     * has the following description: ��������
     * 
     * @return the value of field 'oprType'.
    **/
    public java.lang.String getOprType()
    {
        return this._oprType;
    } //-- java.lang.String getOprType() 

    /**
     * Returns the value of field 'serviceID'. The field
     * 'serviceID' has the following description: �������
     * 
     * @return the value of field 'serviceID'.
    **/
    public java.lang.String getServiceID()
    {
        return this._serviceID;
    } //-- java.lang.String getServiceID() 


    /**
     * 
     * 
     * @param handler
    **/

    /**
     * Sets the value of field 'attrKey'. The field 'attrKey' has
     * the following description: �������Ա���
     * 
     * @param attrKey the value of field 'attrKey'.
    **/
    public void setAttrKey(java.lang.String attrKey)
    {
        this._attrKey = attrKey;
    } //-- void setAttrKey(java.lang.String) 

    /**
     * Sets the value of field 'attrValue'. The field 'attrValue'
     * has the following description: ��������ֵ
     * 
     * @param attrValue the value of field 'attrValue'.
    **/
    public void setAttrValue(java.lang.String attrValue)
    {
        this._attrValue = attrValue;
    } //-- void setAttrValue(java.lang.String) 

    /**
     * Sets the value of field 'oprType'. The field 'oprType' has
     * the following description: ��������
     * 
     * @param oprType the value of field 'oprType'.
    **/
    public void setOprType(java.lang.String oprType)
    {
        this._oprType = oprType;
    } //-- void setOprType(java.lang.String) 

    /**
     * Sets the value of field 'serviceID'. The field 'serviceID'
     * has the following description: �������
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
