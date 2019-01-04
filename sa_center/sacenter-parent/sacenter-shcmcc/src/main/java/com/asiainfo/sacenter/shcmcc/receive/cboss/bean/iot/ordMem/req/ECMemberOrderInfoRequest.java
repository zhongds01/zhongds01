/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id$
 */

package com.asiainfo.sacenter.shcmcc.receive.cboss.bean.iot.ordMem.req;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Vector;

/**
 * 业务受理请求
 * 
 * @version $Revision$ $Date$
**/
public class ECMemberOrderInfoRequest implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 用户数据
    **/
    private java.util.Vector _memInfoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ECMemberOrderInfoRequest() {
        super();
        _memInfoList = new Vector();
    } //-- ECMemberOrderInfoRequest()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vMemInfo
    **/
    public void addMemInfo(MemInfo vMemInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _memInfoList.addElement(vMemInfo);
    } //-- void addMemInfo(MemInfo) 

    /**
     * 
     * 
     * @param index
     * @param vMemInfo
    **/
    public void addMemInfo(int index, MemInfo vMemInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _memInfoList.insertElementAt(vMemInfo, index);
    } //-- void addMemInfo(int, MemInfo) 

    /**
    **/
    public java.util.Enumeration enumerateMemInfo()
    {
        return _memInfoList.elements();
    } //-- java.util.Enumeration enumerateMemInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public MemInfo getMemInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _memInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (MemInfo) _memInfoList.elementAt(index);
    } //-- MemInfo getMemInfo(int) 

    /**
    **/
    public MemInfo[] getMemInfo()
    {
        int size = _memInfoList.size();
        MemInfo[] mArray = new MemInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (MemInfo) _memInfoList.elementAt(index);
        }
        return mArray;
    } //-- MemInfo[] getMemInfo() 

    /**
    **/
    public int getMemInfoCount()
    {
        return _memInfoList.size();
    } //-- int getMemInfoCount() 

    /*

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
    public void removeAllMemInfo()
    {
        _memInfoList.removeAllElements();
    } //-- void removeAllMemInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public MemInfo removeMemInfo(int index)
    {
        java.lang.Object obj = _memInfoList.elementAt(index);
        _memInfoList.removeElementAt(index);
        return (MemInfo) obj;
    } //-- MemInfo removeMemInfo(int) 

    /**
     * 
     * 
     * @param index
     * @param vMemInfo
    **/
    public void setMemInfo(int index, MemInfo vMemInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _memInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _memInfoList.setElementAt(vMemInfo, index);
    } //-- void setMemInfo(int, MemInfo) 

    /**
     * 
     * 
     * @param memInfoArray
    **/
    public void setMemInfo(MemInfo[] memInfoArray)
    {
        //-- copy array
        _memInfoList.removeAllElements();
        for (int i = 0; i < memInfoArray.length; i++) {
            _memInfoList.addElement(memInfoArray[i]);
        }
    } //-- void setMemInfo(MemInfo) 

    /**
     * 
     * 
     * @param reader
    **/


}
