/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.asiainfo.sacenter.shcmcc.receive.cboss.bean.iot.ecsyn.rsp;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/


import java.util.Vector;

/**
 * Comment describing your root element
 * 
 * @version $Revision$ $Date$
 */
public class ECInfoNoticeRequest implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _rsltList
     */
    private java.util.Vector _rsltList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ECInfoNoticeRequest() 
     {
        super();
        _rsltList = new Vector();
    } //-- ECInfoNoticeRequest()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRslt
     * 
     * 
     * 
     * @param vRslt
     */
    public void addRslt(Rslt vRslt)
        throws java.lang.IndexOutOfBoundsException
    {
        _rsltList.addElement(vRslt);
    } //-- void addRslt(Rslt)

    /**
     * Method addRslt
     * 
     * 
     * 
     * @param index
     * @param vRslt
     */
    public void addRslt(int index, Rslt vRslt)
        throws java.lang.IndexOutOfBoundsException
    {
        _rsltList.insertElementAt(vRslt, index);
    } //-- void addRslt(int, Rslt)

    /**
     * Method enumerateRslt
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateRslt()
    {
        return _rsltList.elements();
    } //-- java.util.Enumeration enumerateRslt() 

    /**
     * Method getRslt
     * 
     * 
     * 
     * @param index
     * @return Rslt
     */
    public Rslt getRslt(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _rsltList.size())) {
            throw new IndexOutOfBoundsException("getRslt: Index value '"+index+"' not in range [0.."+(_rsltList.size() - 1) + "]");
        }
        
        return (Rslt) _rsltList.elementAt(index);
    } //-- Rslt getRslt(int)

    /**
     * Method getRslt
     * 
     * 
     * 
     * @return Rslt
     */
    public Rslt[] getRslt()
    {
        int size = _rsltList.size();
        Rslt[] mArray = new Rslt[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Rslt) _rsltList.elementAt(index);
        }
        return mArray;
    } //-- Rslt[] getRslt()

    /**
     * Method getRsltCount
     * 
     * 
     * 
     * @return int
     */
    public int getRsltCount()
    {
        return _rsltList.size();
    } //-- int getRsltCount() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean

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
     * Method removeAllRslt
     * 
     */
    public void removeAllRslt()
    {
        _rsltList.removeAllElements();
    } //-- void removeAllRslt() 

    /**
     * Method removeRslt
     * 
     * 
     * 
     * @param index
     * @return Rslt
     */
    public Rslt removeRslt(int index)
    {
        java.lang.Object obj = _rsltList.elementAt(index);
        _rsltList.removeElementAt(index);
        return (Rslt) obj;
    } //-- Rslt removeRslt(int)

    /**
     * Method setRslt
     * 
     * 
     * 
     * @param index
     * @param vRslt
     */
    public void setRslt(int index, Rslt vRslt)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _rsltList.size())) {
            throw new IndexOutOfBoundsException("setRslt: Index value '"+index+"' not in range [0.." + (_rsltList.size() - 1) + "]");
        }
        _rsltList.setElementAt(vRslt, index);
    } //-- void setRslt(int, Rslt)

    /**
     * Method setRslt
     * 
     * 
     * 
     * @param rsltArray
     */
    public void setRslt(Rslt[] rsltArray)
    {
        //-- copy array
        _rsltList.removeAllElements();
        for (int i = 0; i < rsltArray.length; i++) {
            _rsltList.addElement(rsltArray[i]);
        }
    } //-- void setRslt(Rslt)

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ECInfoNoticeRequest
     */


}
