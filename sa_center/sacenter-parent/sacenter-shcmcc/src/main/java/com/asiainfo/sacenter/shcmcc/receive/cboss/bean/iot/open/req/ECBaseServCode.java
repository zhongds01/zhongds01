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
 * EC基本接入号信息
 * 
 * @version $Revision$ $Date$
**/
public class ECBaseServCode implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * EC基本接入号
    **/
    private java.lang.String _baseServCode;

    /**
     * EC基本接入号的属性
    **/
    private java.lang.String _baseServCodeProp;

    /**
     * 业务承载方式
    **/
    private java.lang.String _bizServMode;


      //----------------/
     //- Constructors -/
    //----------------/

    public ECBaseServCode() {
        super();
    } //-- ECBaseServCode()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'baseServCode'. The field
     * 'baseServCode' has the following description: EC基本接入号
     * 
     * @return the value of field 'baseServCode'.
    **/
    public java.lang.String getBaseServCode()
    {
        return this._baseServCode;
    } //-- java.lang.String getBaseServCode() 

    /**
     * Returns the value of field 'baseServCodeProp'. The field
     * 'baseServCodeProp' has the following description: EC基本接入号的属性
     * 
     * @return the value of field 'baseServCodeProp'.
    **/
    public java.lang.String getBaseServCodeProp()
    {
        return this._baseServCodeProp;
    } //-- java.lang.String getBaseServCodeProp() 

    /**
     * Returns the value of field 'bizServMode'. The field
     * 'bizServMode' has the following description: 业务承载方式
     * 
     * @return the value of field 'bizServMode'.
    **/
    public java.lang.String getBizServMode()
    {
        return this._bizServMode;
    } //-- java.lang.String getBizServMode() 

    /**
    **/

    /**
     * 
     * 
     * @param handler
    **/

    /**
     * Sets the value of field 'baseServCode'. The field
     * 'baseServCode' has the following description: EC基本接入号
     * 
     * @param baseServCode the value of field 'baseServCode'.
    **/
    public void setBaseServCode(java.lang.String baseServCode)
    {
        this._baseServCode = baseServCode;
    } //-- void setBaseServCode(java.lang.String) 

    /**
     * Sets the value of field 'baseServCodeProp'. The field
     * 'baseServCodeProp' has the following description: EC基本接入号的属性
     * 
     * @param baseServCodeProp the value of field 'baseServCodeProp'
    **/
    public void setBaseServCodeProp(java.lang.String baseServCodeProp)
    {
        this._baseServCodeProp = baseServCodeProp;
    } //-- void setBaseServCodeProp(java.lang.String) 

    /**
     * Sets the value of field 'bizServMode'. The field
     * 'bizServMode' has the following description: 业务承载方式
     * 
     * @param bizServMode the value of field 'bizServMode'.
    **/
    public void setBizServMode(java.lang.String bizServMode)
    {
        this._bizServMode = bizServMode;
    } //-- void setBizServMode(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/


}
