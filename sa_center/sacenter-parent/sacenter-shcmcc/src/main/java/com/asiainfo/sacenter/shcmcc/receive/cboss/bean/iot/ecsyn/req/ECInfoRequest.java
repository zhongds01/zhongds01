/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.asiainfo.sacenter.shcmcc.receive.cboss.bean.iot.ecsyn.req;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/


/**
 * Comment describing your root element
 * 
 * @version $Revision$ $Date$
 */
public class ECInfoRequest implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _customerInfo
     */
    private CustomerInfo _customerInfo;


      //----------------/
     //- Constructors -/
    //----------------/

    public ECInfoRequest() 
     {
        super();
    } //-- ECInfoRequest()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'customerInfo'.
     * 
     * @return CustomerInfo
     * @return the value of field 'customerInfo'.
     */
    public CustomerInfo getCustomerInfo()
    {
        return this._customerInfo;
    } //-- CustomerInfo getCustomerInfo()

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */

    /**
     * Method marshal
     * 
     * 
     * 
     * @param out
     */

    /**
     * Method marshal
     * 
     * 
     * 
     * @param handler
     */


    /**
     * Sets the value of field 'customerInfo'.
     * 
     * @param customerInfo the value of field 'customerInfo'.
     */
    public void setCustomerInfo(CustomerInfo customerInfo)
    {
        this._customerInfo = customerInfo;
    } //-- void setCustomerInfo(CustomerInfo)

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ECInfoRequest
     */


}
