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

import java.util.Vector;


/**
 * Class CustomerInfo.
 * 
 * @version $Revision$ $Date$
 */
public class CustomerInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _oprSeq
     */
    private java.lang.String _oprSeq;

    /**
     * Field _oprTime
     */
    private java.lang.String _oprTime;

    /**
     * Field _oprCode
     */
    private java.lang.String _oprCode;

    /**
     * Field _parentCustomerNumber
     */
    private java.lang.String _parentCustomerNumber;

    /**
     * Field _customer
     */
    private Customer _customer;

    /**
     * Field _customerManager
     */
    private CustomerManager _customerManager;

    /**
     * Field _keyPersonsList
     */
    private java.util.Vector _keyPersonsList;

    /**
     * Field _extInfoList
     */
    private java.util.Vector _extInfoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CustomerInfo() 
     {
        super();
        _keyPersonsList = new Vector();
        _extInfoList = new Vector();
    } //-- CustomerInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addExtInfo
     * 
     * 
     * 
     * @param vExtInfo
     */
    public void addExtInfo(ExtInfo vExtInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _extInfoList.addElement(vExtInfo);
    } //-- void addExtInfo(ExtInfo)

    /**
     * Method addExtInfo
     * 
     * 
     * 
     * @param index
     * @param vExtInfo
     */
    public void addExtInfo(int index, ExtInfo vExtInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _extInfoList.insertElementAt(vExtInfo, index);
    } //-- void addExtInfo(int, ExtInfo)

    /**
     * Method addKeyPersons
     * 
     * 
     * 
     * @param vKeyPersons
     */
    public void addKeyPersons(KeyPersons vKeyPersons)
        throws java.lang.IndexOutOfBoundsException
    {
        _keyPersonsList.addElement(vKeyPersons);
    } //-- void addKeyPersons(KeyPersons)

    /**
     * Method addKeyPersons
     * 
     * 
     * 
     * @param index
     * @param vKeyPersons
     */
    public void addKeyPersons(int index, KeyPersons vKeyPersons)
        throws java.lang.IndexOutOfBoundsException
    {
        _keyPersonsList.insertElementAt(vKeyPersons, index);
    } //-- void addKeyPersons(int, KeyPersons)

    /**
     * Method enumerateExtInfo
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateExtInfo()
    {
        return _extInfoList.elements();
    } //-- java.util.Enumeration enumerateExtInfo() 

    /**
     * Method enumerateKeyPersons
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateKeyPersons()
    {
        return _keyPersonsList.elements();
    } //-- java.util.Enumeration enumerateKeyPersons() 

    /**
     * Returns the value of field 'customer'.
     * 
     * @return Customer
     * @return the value of field 'customer'.
     */
    public Customer getCustomer()
    {
        return this._customer;
    } //-- Customer getCustomer()

    /**
     * Returns the value of field 'customerManager'.
     * 
     * @return CustomerManager
     * @return the value of field 'customerManager'.
     */
    public CustomerManager getCustomerManager()
    {
        return this._customerManager;
    } //-- CustomerManager getCustomerManager()

    /**
     * Method getExtInfo
     * 
     * 
     * 
     * @param index
     * @return ExtInfo
     */
    public ExtInfo getExtInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _extInfoList.size())) {
            throw new IndexOutOfBoundsException("getExtInfo: Index value '"+index+"' not in range [0.."+(_extInfoList.size() - 1) + "]");
        }
        
        return (ExtInfo) _extInfoList.elementAt(index);
    } //-- ExtInfo getExtInfo(int)

    /**
     * Method getExtInfo
     * 
     * 
     * 
     * @return ExtInfo
     */
    public ExtInfo[] getExtInfo()
    {
        int size = _extInfoList.size();
        ExtInfo[] mArray = new ExtInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (ExtInfo) _extInfoList.elementAt(index);
        }
        return mArray;
    } //-- ExtInfo[] getExtInfo()

    /**
     * Method getExtInfoCount
     * 
     * 
     * 
     * @return int
     */
    public int getExtInfoCount()
    {
        return _extInfoList.size();
    } //-- int getExtInfoCount() 

    /**
     * Method getKeyPersons
     * 
     * 
     * 
     * @param index
     * @return KeyPersons
     */
    public KeyPersons getKeyPersons(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _keyPersonsList.size())) {
            throw new IndexOutOfBoundsException("getKeyPersons: Index value '"+index+"' not in range [0.."+(_keyPersonsList.size() - 1) + "]");
        }
        
        return (KeyPersons) _keyPersonsList.elementAt(index);
    } //-- KeyPersons getKeyPersons(int)

    /**
     * Method getKeyPersons
     * 
     * 
     * 
     * @return KeyPersons
     */
    public KeyPersons[] getKeyPersons()
    {
        int size = _keyPersonsList.size();
        KeyPersons[] mArray = new KeyPersons[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (KeyPersons) _keyPersonsList.elementAt(index);
        }
        return mArray;
    } //-- KeyPersons[] getKeyPersons()

    /**
     * Method getKeyPersonsCount
     * 
     * 
     * 
     * @return int
     */
    public int getKeyPersonsCount()
    {
        return _keyPersonsList.size();
    } //-- int getKeyPersonsCount() 

    /**
     * Returns the value of field 'oprCode'.
     * 
     * @return String
     * @return the value of field 'oprCode'.
     */
    public java.lang.String getOprCode()
    {
        return this._oprCode;
    } //-- java.lang.String getOprCode() 

    /**
     * Returns the value of field 'oprSeq'.
     * 
     * @return String
     * @return the value of field 'oprSeq'.
     */
    public java.lang.String getOprSeq()
    {
        return this._oprSeq;
    } //-- java.lang.String getOprSeq() 

    /**
     * Returns the value of field 'oprTime'.
     * 
     * @return String
     * @return the value of field 'oprTime'.
     */
    public java.lang.String getOprTime()
    {
        return this._oprTime;
    } //-- java.lang.String getOprTime() 

    /**
     * Returns the value of field 'parentCustomerNumber'.
     * 
     * @return String
     * @return the value of field 'parentCustomerNumber'.
     */
    public java.lang.String getParentCustomerNumber()
    {
        return this._parentCustomerNumber;
    } //-- java.lang.String getParentCustomerNumber() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */


    /**
     * Method removeAllExtInfo
     * 
     */
    public void removeAllExtInfo()
    {
        _extInfoList.removeAllElements();
    } //-- void removeAllExtInfo() 

    /**
     * Method removeAllKeyPersons
     * 
     */
    public void removeAllKeyPersons()
    {
        _keyPersonsList.removeAllElements();
    } //-- void removeAllKeyPersons() 

    /**
     * Method removeExtInfo
     * 
     * 
     * 
     * @param index
     * @return ExtInfo
     */
    public ExtInfo removeExtInfo(int index)
    {
        java.lang.Object obj = _extInfoList.elementAt(index);
        _extInfoList.removeElementAt(index);
        return (ExtInfo) obj;
    } //-- ExtInfo removeExtInfo(int)

    /**
     * Method removeKeyPersons
     * 
     * 
     * 
     * @param index
     * @return KeyPersons
     */
    public KeyPersons removeKeyPersons(int index)
    {
        java.lang.Object obj = _keyPersonsList.elementAt(index);
        _keyPersonsList.removeElementAt(index);
        return (KeyPersons) obj;
    } //-- KeyPersons removeKeyPersons(int)

    /**
     * Sets the value of field 'customer'.
     * 
     * @param customer the value of field 'customer'.
     */
    public void setCustomer(Customer customer)
    {
        this._customer = customer;
    } //-- void setCustomer(Customer)

    /**
     * Sets the value of field 'customerManager'.
     * 
     * @param customerManager the value of field 'customerManager'.
     */
    public void setCustomerManager(CustomerManager customerManager)
    {
        this._customerManager = customerManager;
    } //-- void setCustomerManager(CustomerManager)

    /**
     * Method setExtInfo
     * 
     * 
     * 
     * @param index
     * @param vExtInfo
     */
    public void setExtInfo(int index, ExtInfo vExtInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _extInfoList.size())) {
            throw new IndexOutOfBoundsException("setExtInfo: Index value '"+index+"' not in range [0.." + (_extInfoList.size() - 1) + "]");
        }
        _extInfoList.setElementAt(vExtInfo, index);
    } //-- void setExtInfo(int, ExtInfo)

    /**
     * Method setExtInfo
     * 
     * 
     * 
     * @param extInfoArray
     */
    public void setExtInfo(ExtInfo[] extInfoArray)
    {
        //-- copy array
        _extInfoList.removeAllElements();
        for (int i = 0; i < extInfoArray.length; i++) {
            _extInfoList.addElement(extInfoArray[i]);
        }
    } //-- void setExtInfo(ExtInfo)

    /**
     * Method setKeyPersons
     * 
     * 
     * 
     * @param index
     * @param vKeyPersons
     */
    public void setKeyPersons(int index, KeyPersons vKeyPersons)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _keyPersonsList.size())) {
            throw new IndexOutOfBoundsException("setKeyPersons: Index value '"+index+"' not in range [0.." + (_keyPersonsList.size() - 1) + "]");
        }
        _keyPersonsList.setElementAt(vKeyPersons, index);
    } //-- void setKeyPersons(int, KeyPersons)

    /**
     * Method setKeyPersons
     * 
     * 
     * 
     * @param keyPersonsArray
     */
    public void setKeyPersons(KeyPersons[] keyPersonsArray)
    {
        //-- copy array
        _keyPersonsList.removeAllElements();
        for (int i = 0; i < keyPersonsArray.length; i++) {
            _keyPersonsList.addElement(keyPersonsArray[i]);
        }
    } //-- void setKeyPersons(KeyPersons)

    /**
     * Sets the value of field 'oprCode'.
     * 
     * @param oprCode the value of field 'oprCode'.
     */
    public void setOprCode(java.lang.String oprCode)
    {
        this._oprCode = oprCode;
    } //-- void setOprCode(java.lang.String) 

    /**
     * Sets the value of field 'oprSeq'.
     * 
     * @param oprSeq the value of field 'oprSeq'.
     */
    public void setOprSeq(java.lang.String oprSeq)
    {
        this._oprSeq = oprSeq;
    } //-- void setOprSeq(java.lang.String) 

    /**
     * Sets the value of field 'oprTime'.
     * 
     * @param oprTime the value of field 'oprTime'.
     */
    public void setOprTime(java.lang.String oprTime)
    {
        this._oprTime = oprTime;
    } //-- void setOprTime(java.lang.String) 

    /**
     * Sets the value of field 'parentCustomerNumber'.
     * 
     * @param parentCustomerNumber the value of field
     * 'parentCustomerNumber'.
     */
    public void setParentCustomerNumber(java.lang.String parentCustomerNumber)
    {
        this._parentCustomerNumber = parentCustomerNumber;
    } //-- void setParentCustomerNumber(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return CustomerInfo
     */


}
