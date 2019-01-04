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

import java.util.Vector;

/**
 * EC信息
 * 
 * @version $Revision$ $Date$
**/
public class ECBizInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * EC客户编码
    **/
    private java.lang.String _customerNumber;

    /**
     * 业务信息
    **/
    private java.util.Vector _bizInfoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ECBizInfo() {
        super();
        _bizInfoList = new Vector();
    } //-- ECBizInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vBizInfo
    **/
    public void addBizInfo(BizInfo vBizInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _bizInfoList.addElement(vBizInfo);
    } //-- void addBizInfo(BizInfo) 

    /**
     * 
     * 
     * @param index
     * @param vBizInfo
    **/
    public void addBizInfo(int index, BizInfo vBizInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _bizInfoList.insertElementAt(vBizInfo, index);
    } //-- void addBizInfo(int, BizInfo) 

    /**
    **/
    public java.util.Enumeration enumerateBizInfo()
    {
        return _bizInfoList.elements();
    } //-- java.util.Enumeration enumerateBizInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public BizInfo getBizInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bizInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (BizInfo) _bizInfoList.elementAt(index);
    } //-- BizInfo getBizInfo(int) 

    /**
    **/
    public BizInfo[] getBizInfo()
    {
        int size = _bizInfoList.size();
        BizInfo[] mArray = new BizInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (BizInfo) _bizInfoList.elementAt(index);
        }
        return mArray;
    } //-- BizInfo[] getBizInfo() 

    /**
    **/
    public int getBizInfoCount()
    {
        return _bizInfoList.size();
    } //-- int getBizInfoCount() 

    /**
     * Returns the value of field 'customerNumber'. The field
     * 'customerNumber' has the following description: EC客户编码
     * 
     * @return the value of field 'customerNumber'.
    **/
    public java.lang.String getCustomerNumber()
    {
        return this._customerNumber;
    } //-- java.lang.String getCustomerNumber() 

    /**
    **/

    /**
     * 
     * 
     * @param handler
    **/

    /**
    **/
    public void removeAllBizInfo()
    {
        _bizInfoList.removeAllElements();
    } //-- void removeAllBizInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public BizInfo removeBizInfo(int index)
    {
        java.lang.Object obj = _bizInfoList.elementAt(index);
        _bizInfoList.removeElementAt(index);
        return (BizInfo) obj;
    } //-- BizInfo removeBizInfo(int) 

    /**
     * 
     * 
     * @param index
     * @param vBizInfo
    **/
    public void setBizInfo(int index, BizInfo vBizInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bizInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _bizInfoList.setElementAt(vBizInfo, index);
    } //-- void setBizInfo(int, BizInfo) 

    /**
     * 
     * 
     * @param bizInfoArray
    **/
    public void setBizInfo(BizInfo[] bizInfoArray)
    {
        //-- copy array
        _bizInfoList.removeAllElements();
        for (int i = 0; i < bizInfoArray.length; i++) {
            _bizInfoList.addElement(bizInfoArray[i]);
        }
    } //-- void setBizInfo(BizInfo) 

    /**
     * Sets the value of field 'customerNumber'. The field
     * 'customerNumber' has the following description: EC客户编码
     * 
     * @param customerNumber the value of field 'customerNumber'.
    **/
    public void setCustomerNumber(java.lang.String customerNumber)
    {
        this._customerNumber = customerNumber;
    } //-- void setCustomerNumber(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/

}
