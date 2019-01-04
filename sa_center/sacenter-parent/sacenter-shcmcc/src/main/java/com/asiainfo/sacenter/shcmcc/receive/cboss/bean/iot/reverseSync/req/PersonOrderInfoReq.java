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
 * 业务受理请求
 * 
 * @version $Revision$ $Date$
**/
public class PersonOrderInfoReq implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 用户数据
    **/
    private java.util.Vector _personInfoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PersonOrderInfoReq() {
        super();
        _personInfoList = new Vector();
    } //-- PersonOrderInfoReq()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPersonInfo
    **/
    public void addPersonInfo(PersonInfo vPersonInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _personInfoList.addElement(vPersonInfo);
    } //-- void addPersonInfo(PersonInfo) 

    /**
     * 
     * 
     * @param index
     * @param vPersonInfo
    **/
    public void addPersonInfo(int index, PersonInfo vPersonInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _personInfoList.insertElementAt(vPersonInfo, index);
    } //-- void addPersonInfo(int, PersonInfo) 

    /**
    **/
    public java.util.Enumeration enumeratePersonInfo()
    {
        return _personInfoList.elements();
    } //-- java.util.Enumeration enumeratePersonInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public PersonInfo getPersonInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _personInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (PersonInfo) _personInfoList.elementAt(index);
    } //-- PersonInfo getPersonInfo(int) 

    /**
    **/
    public PersonInfo[] getPersonInfo()
    {
        int size = _personInfoList.size();
        PersonInfo[] mArray = new PersonInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (PersonInfo) _personInfoList.elementAt(index);
        }
        return mArray;
    } //-- PersonInfo[] getPersonInfo() 

    /**
    **/
    public int getPersonInfoCount()
    {
        return _personInfoList.size();
    } //-- int getPersonInfoCount() 

    /**
    **/


    /**
     * 
     * 
     * @param handler
    **/

    /**
    **/
    public void removeAllPersonInfo()
    {
        _personInfoList.removeAllElements();
    } //-- void removeAllPersonInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public PersonInfo removePersonInfo(int index)
    {
        java.lang.Object obj = _personInfoList.elementAt(index);
        _personInfoList.removeElementAt(index);
        return (PersonInfo) obj;
    } //-- PersonInfo removePersonInfo(int) 

    /**
     * 
     * 
     * @param index
     * @param vPersonInfo
    **/
    public void setPersonInfo(int index, PersonInfo vPersonInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _personInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _personInfoList.setElementAt(vPersonInfo, index);
    } //-- void setPersonInfo(int, PersonInfo) 

    /**
     * 
     * 
     * @param personInfoArray
    **/
    public void setPersonInfo(PersonInfo[] personInfoArray)
    {
        //-- copy array
        _personInfoList.removeAllElements();
        for (int i = 0; i < personInfoArray.length; i++) {
            _personInfoList.addElement(personInfoArray[i]);
        }
    } //-- void setPersonInfo(PersonInfo) 

    /**
     * 
     * 
     * @param reader
    **/


}
