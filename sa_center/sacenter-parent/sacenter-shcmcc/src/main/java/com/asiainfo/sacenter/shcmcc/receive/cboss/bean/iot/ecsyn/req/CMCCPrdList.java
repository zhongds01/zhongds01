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
 * Class CMCCPrdList.
 * 
 * @version $Revision$ $Date$
 */
public class CMCCPrdList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _CMCCPrdList
     */
    private java.util.Vector _CMCCPrdList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CMCCPrdList() 
     {
        super();
        _CMCCPrdList = new Vector();
    } //-- CMCCPrdList()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addCMCCPrd
     * 
     * 
     * 
     * @param vCMCCPrd
     */
    public void addCMCCPrd(java.lang.Object vCMCCPrd)
        throws java.lang.IndexOutOfBoundsException
    {
        _CMCCPrdList.addElement(vCMCCPrd);
    } //-- void addCMCCPrd(java.lang.Object) 

    /**
     * Method addCMCCPrd
     * 
     * 
     * 
     * @param index
     * @param vCMCCPrd
     */
    public void addCMCCPrd(int index, java.lang.Object vCMCCPrd)
        throws java.lang.IndexOutOfBoundsException
    {
        _CMCCPrdList.insertElementAt(vCMCCPrd, index);
    } //-- void addCMCCPrd(int, java.lang.Object) 

    /**
     * Method enumerateCMCCPrd
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateCMCCPrd()
    {
        return _CMCCPrdList.elements();
    } //-- java.util.Enumeration enumerateCMCCPrd() 

    /**
     * Method getCMCCPrd
     * 
     * 
     * 
     * @param index
     * @return Object
     */
    public java.lang.Object getCMCCPrd(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _CMCCPrdList.size())) {
            throw new IndexOutOfBoundsException("getCMCCPrd: Index value '"+index+"' not in range [0.."+(_CMCCPrdList.size() - 1) + "]");
        }
        
        return (java.lang.Object) _CMCCPrdList.elementAt(index);
    } //-- java.lang.Object getCMCCPrd(int) 

    /**
     * Method getCMCCPrd
     * 
     * 
     * 
     * @return Object
     */
    public java.lang.Object[] getCMCCPrd()
    {
        int size = _CMCCPrdList.size();
        java.lang.Object[] mArray = new java.lang.Object[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (java.lang.Object) _CMCCPrdList.elementAt(index);
        }
        return mArray;
    } //-- java.lang.Object[] getCMCCPrd() 

    /**
     * Method getCMCCPrdCount
     * 
     * 
     * 
     * @return int
     */
    public int getCMCCPrdCount()
    {
        return _CMCCPrdList.size();
    } //-- int getCMCCPrdCount() 

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
     * Method removeAllCMCCPrd
     * 
     */
    public void removeAllCMCCPrd()
    {
        _CMCCPrdList.removeAllElements();
    } //-- void removeAllCMCCPrd() 

    /**
     * Method removeCMCCPrd
     * 
     * 
     * 
     * @param index
     * @return Object
     */
    public java.lang.Object removeCMCCPrd(int index)
    {
        java.lang.Object obj = _CMCCPrdList.elementAt(index);
        _CMCCPrdList.removeElementAt(index);
        return (java.lang.Object) obj;
    } //-- java.lang.Object removeCMCCPrd(int) 

    /**
     * Method setCMCCPrd
     * 
     * 
     * 
     * @param index
     * @param vCMCCPrd
     */
    public void setCMCCPrd(int index, java.lang.Object vCMCCPrd)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _CMCCPrdList.size())) {
            throw new IndexOutOfBoundsException("setCMCCPrd: Index value '"+index+"' not in range [0.." + (_CMCCPrdList.size() - 1) + "]");
        }
        _CMCCPrdList.setElementAt(vCMCCPrd, index);
    } //-- void setCMCCPrd(int, java.lang.Object) 

    /**
     * Method setCMCCPrd
     * 
     * 
     * 
     * @param CMCCPrdArray
     */
    public void setCMCCPrd(java.lang.Object[] CMCCPrdArray)
    {
        //-- copy array
        _CMCCPrdList.removeAllElements();
        for (int i = 0; i < CMCCPrdArray.length; i++) {
            _CMCCPrdList.addElement(CMCCPrdArray[i]);
        }
    } //-- void setCMCCPrd(java.lang.Object) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return CMCCPrdList
     */


}
