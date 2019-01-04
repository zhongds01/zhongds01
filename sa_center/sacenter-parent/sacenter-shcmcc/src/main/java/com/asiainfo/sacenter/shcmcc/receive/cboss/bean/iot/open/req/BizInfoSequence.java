/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.asiainfo.sacenter.shcmcc.receive.cboss.bean.iot.open.req;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Vector;


/**
 * Class BizInfoSequence.
 * 
 * @version $Revision$ $Date$
 */
public class BizInfoSequence implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _prodInfoList
     */
    private java.util.Vector _prodInfoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BizInfoSequence() 
     {
        super();
        _prodInfoList = new Vector();
    } //-- BizInfoSequence()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addProdInfo
     * 
     * 
     * 
     * @param vProdInfo
     */
    public void addProdInfo(ProdInfo vProdInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _prodInfoList.addElement(vProdInfo);
    } //-- void addProdInfo(ProdInfo)

    /**
     * Method addProdInfo
     * 
     * 
     * 
     * @param index
     * @param vProdInfo
     */
    public void addProdInfo(int index, ProdInfo vProdInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _prodInfoList.insertElementAt(vProdInfo, index);
    } //-- void addProdInfo(int, ProdInfo)

    /**
     * Method enumerateProdInfo
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateProdInfo()
    {
        return _prodInfoList.elements();
    } //-- java.util.Enumeration enumerateProdInfo() 

    /**
     * Method getProdInfo
     * 
     * 
     * 
     * @param index
     * @return ProdInfo
     */
    public ProdInfo getProdInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _prodInfoList.size())) {
            throw new IndexOutOfBoundsException("getProdInfo: Index value '"+index+"' not in range [0.."+(_prodInfoList.size() - 1) + "]");
        }
        
        return (ProdInfo) _prodInfoList.elementAt(index);
    } //-- ProdInfo getProdInfo(int)

    /**
     * Method getProdInfo
     * 
     * 
     * 
     * @return ProdInfo
     */
    public ProdInfo[] getProdInfo()
    {
        int size = _prodInfoList.size();
        ProdInfo[] mArray = new ProdInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (ProdInfo) _prodInfoList.elementAt(index);
        }
        return mArray;
    } //-- ProdInfo[] getProdInfo()

    /**
     * Method getProdInfoCount
     * 
     * 
     * 
     * @return int
     */
    public int getProdInfoCount()
    {
        return _prodInfoList.size();
    } //-- int getProdInfoCount() 

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
     * Method removeAllProdInfo
     * 
     */
    public void removeAllProdInfo()
    {
        _prodInfoList.removeAllElements();
    } //-- void removeAllProdInfo() 

    /**
     * Method removeProdInfo
     * 
     * 
     * 
     * @param index
     * @return ProdInfo
     */
    public ProdInfo removeProdInfo(int index)
    {
        java.lang.Object obj = _prodInfoList.elementAt(index);
        _prodInfoList.removeElementAt(index);
        return (ProdInfo) obj;
    } //-- ProdInfo removeProdInfo(int)

    /**
     * Method setProdInfo
     * 
     * 
     * 
     * @param index
     * @param vProdInfo
     */
    public void setProdInfo(int index, ProdInfo vProdInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _prodInfoList.size())) {
            throw new IndexOutOfBoundsException("setProdInfo: Index value '"+index+"' not in range [0.." + (_prodInfoList.size() - 1) + "]");
        }
        _prodInfoList.setElementAt(vProdInfo, index);
    } //-- void setProdInfo(int, ProdInfo)

    /**
     * Method setProdInfo
     * 
     * 
     * 
     * @param prodInfoArray
     */
    public void setProdInfo(ProdInfo[] prodInfoArray)
    {
        //-- copy array
        _prodInfoList.removeAllElements();
        for (int i = 0; i < prodInfoArray.length; i++) {
            _prodInfoList.addElement(prodInfoArray[i]);
        }
    } //-- void setProdInfo(ProdInfo)

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return BizInfoSequence
     */


    /**
     * Method validate
     * 
     */


}
