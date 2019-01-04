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
 * 服务的附加属�?
 * 
 * @version $Revision$ $Date$
**/
public class ServiceAttrInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 附加属�?�信�?
    **/
    private java.util.Vector _attrInfoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ServiceAttrInfo() {
        super();
        _attrInfoList = new Vector();
    } //-- ServiceAttrInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAttrInfo
    **/
    public void addAttrInfo(AttrInfo vAttrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _attrInfoList.addElement(vAttrInfo);
    } //-- void addAttrInfo(AttrInfo) 

    /**
     * 
     * 
     * @param index
     * @param vAttrInfo
    **/
    public void addAttrInfo(int index, AttrInfo vAttrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _attrInfoList.insertElementAt(vAttrInfo, index);
    } //-- void addAttrInfo(int, AttrInfo) 

    /**
    **/
    public java.util.Enumeration enumerateAttrInfo()
    {
        return _attrInfoList.elements();
    } //-- java.util.Enumeration enumerateAttrInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public AttrInfo getAttrInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _attrInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (AttrInfo) _attrInfoList.elementAt(index);
    } //-- AttrInfo getAttrInfo(int) 

    /**
    **/
    public AttrInfo[] getAttrInfo()
    {
        int size = _attrInfoList.size();
        AttrInfo[] mArray = new AttrInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (AttrInfo) _attrInfoList.elementAt(index);
        }
        return mArray;
    } //-- AttrInfo[] getAttrInfo() 

    /**
    **/
    public int getAttrInfoCount()
    {
        return _attrInfoList.size();
    } //-- int getAttrInfoCount() 

    /**
    **/

    /**
     * 
     * 
     * @param handler
    **/


    /**
    **/
    public void removeAllAttrInfo()
    {
        _attrInfoList.removeAllElements();
    } //-- void removeAllAttrInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public AttrInfo removeAttrInfo(int index)
    {
        java.lang.Object obj = _attrInfoList.elementAt(index);
        _attrInfoList.removeElementAt(index);
        return (AttrInfo) obj;
    } //-- AttrInfo removeAttrInfo(int) 

    /**
     * 
     * 
     * @param index
     * @param vAttrInfo
    **/
    public void setAttrInfo(int index, AttrInfo vAttrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _attrInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _attrInfoList.setElementAt(vAttrInfo, index);
    } //-- void setAttrInfo(int, AttrInfo) 

    /**
     * 
     * 
     * @param attrInfoArray
    **/
    public void setAttrInfo(AttrInfo[] attrInfoArray)
    {
        //-- copy array
        _attrInfoList.removeAllElements();
        for (int i = 0; i < attrInfoArray.length; i++) {
            _attrInfoList.addElement(attrInfoArray[i]);
        }
    } //-- void setAttrInfo(AttrInfo) 

    /**
     * 
     * 
     * @param reader
    **/


}
