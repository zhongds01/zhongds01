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
 * 附加属性信息
 * 
 * @version $Revision$ $Date$
**/
public class AttrInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 附加属性编码
    **/
    private java.lang.String _attrKey;

    /**
     * 附加属性值
    **/
    private java.lang.String _attrValue;


      //----------------/
     //- Constructors -/
    //----------------/

    public AttrInfo() {
        super();
    } //-- AttrInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'attrKey'. The field 'attrKey'
     * has the following description: 附加属性编码
     * 
     * @return the value of field 'attrKey'.
    **/
    public java.lang.String getAttrKey()
    {
        return this._attrKey;
    } //-- java.lang.String getAttrKey() 

    /**
     * Returns the value of field 'attrValue'. The field
     * 'attrValue' has the following description: 附加属性值
     * 
     * @return the value of field 'attrValue'.
    **/
    public java.lang.String getAttrValue()
    {
        return this._attrValue;
    } //-- java.lang.String getAttrValue() 

    /**
    **/

    /**
     * 
     * 
     * @param handler
    **/


    /**
     * Sets the value of field 'attrKey'. The field 'attrKey' has
     * the following description: 附加属性编码
     * 
     * @param attrKey the value of field 'attrKey'.
    **/
    public void setAttrKey(java.lang.String attrKey)
    {
        this._attrKey = attrKey;
    } //-- void setAttrKey(java.lang.String) 

    /**
     * Sets the value of field 'attrValue'. The field 'attrValue'
     * has the following description: 附加属性值
     * 
     * @param attrValue the value of field 'attrValue'.
    **/
    public void setAttrValue(java.lang.String attrValue)
    {
        this._attrValue = attrValue;
    } //-- void setAttrValue(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/


}
