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

import java.util.Vector;

/**
 * 业务受理请求
 * 
 * @version $Revision$ $Date$
**/
public class ECProductOrderRequest implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * EC信息
    **/
    private java.util.Vector _ECBizInfoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ECProductOrderRequest() {
        super();
        _ECBizInfoList = new Vector();
    } //-- ECProductOrderRequest()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vECBizInfo
    **/
    public void addECBizInfo(ECBizInfo vECBizInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECBizInfoList.addElement(vECBizInfo);
    } //-- void addECBizInfo(ECBizInfo) 

    /**
     * 
     * 
     * @param index
     * @param vECBizInfo
    **/
    public void addECBizInfo(int index, ECBizInfo vECBizInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _ECBizInfoList.insertElementAt(vECBizInfo, index);
    } //-- void addECBizInfo(int, ECBizInfo) 

    /**
    **/
    public java.util.Enumeration enumerateECBizInfo()
    {
        return _ECBizInfoList.elements();
    } //-- java.util.Enumeration enumerateECBizInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public ECBizInfo getECBizInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECBizInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (ECBizInfo) _ECBizInfoList.elementAt(index);
    } //-- ECBizInfo getECBizInfo(int) 

    /**
    **/
    public ECBizInfo[] getECBizInfo()
    {
        int size = _ECBizInfoList.size();
        ECBizInfo[] mArray = new ECBizInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (ECBizInfo) _ECBizInfoList.elementAt(index);
        }
        return mArray;
    } //-- ECBizInfo[] getECBizInfo() 

    /**
    **/
    public int getECBizInfoCount()
    {
        return _ECBizInfoList.size();
    } //-- int getECBizInfoCount() 

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
    **/
    public void removeAllECBizInfo()
    {
        _ECBizInfoList.removeAllElements();
    } //-- void removeAllECBizInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public ECBizInfo removeECBizInfo(int index)
    {
        java.lang.Object obj = _ECBizInfoList.elementAt(index);
        _ECBizInfoList.removeElementAt(index);
        return (ECBizInfo) obj;
    } //-- ECBizInfo removeECBizInfo(int) 

    /**
     * 
     * 
     * @param index
     * @param vECBizInfo
    **/
    public void setECBizInfo(int index, ECBizInfo vECBizInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ECBizInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _ECBizInfoList.setElementAt(vECBizInfo, index);
    } //-- void setECBizInfo(int, ECBizInfo) 

    /**
     * 
     * 
     * @param ECBizInfoArray
    **/
    public void setECBizInfo(ECBizInfo[] ECBizInfoArray)
    {
        //-- copy array
        _ECBizInfoList.removeAllElements();
        for (int i = 0; i < ECBizInfoArray.length; i++) {
            _ECBizInfoList.addElement(ECBizInfoArray[i]);
        }
    } //-- void setECBizInfo(ECBizInfo) 

    /**
     * 
     * 
     * @param reader
    **/


}
