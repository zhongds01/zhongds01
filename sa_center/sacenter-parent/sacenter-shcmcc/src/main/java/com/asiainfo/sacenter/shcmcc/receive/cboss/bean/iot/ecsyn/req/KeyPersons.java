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
 * Class KeyPersons.
 * 
 * @version $Revision$ $Date$
 */
public class KeyPersons implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _keyPersonList
     */
    private java.util.Vector _keyPersonList;


      //----------------/
     //- Constructors -/
    //----------------/

    public KeyPersons() 
     {
        super();
        _keyPersonList = new Vector();
    } //-- KeyPersons()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addKeyPerson
     * 
     * 
     * 
     * @param vKeyPerson
     */
    public void addKeyPerson(KeyPerson vKeyPerson)
        throws java.lang.IndexOutOfBoundsException
    {
        _keyPersonList.addElement(vKeyPerson);
    } //-- void addKeyPerson(KeyPerson)

    /**
     * Method addKeyPerson
     * 
     * 
     * 
     * @param index
     * @param vKeyPerson
     */
    public void addKeyPerson(int index, KeyPerson vKeyPerson)
        throws java.lang.IndexOutOfBoundsException
    {
        _keyPersonList.insertElementAt(vKeyPerson, index);
    } //-- void addKeyPerson(int, KeyPerson)

    /**
     * Method enumerateKeyPerson
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateKeyPerson()
    {
        return _keyPersonList.elements();
    } //-- java.util.Enumeration enumerateKeyPerson() 

    /**
     * Method getKeyPerson
     * 
     * 
     * 
     * @param index
     * @return KeyPerson
     */
    public KeyPerson getKeyPerson(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _keyPersonList.size())) {
            throw new IndexOutOfBoundsException("getKeyPerson: Index value '"+index+"' not in range [0.."+(_keyPersonList.size() - 1) + "]");
        }
        
        return (KeyPerson) _keyPersonList.elementAt(index);
    } //-- KeyPerson getKeyPerson(int)

    /**
     * Method getKeyPerson
     * 
     * 
     * 
     * @return KeyPerson
     */
    public KeyPerson[] getKeyPerson()
    {
        int size = _keyPersonList.size();
        KeyPerson[] mArray = new KeyPerson[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (KeyPerson) _keyPersonList.elementAt(index);
        }
        return mArray;
    } //-- KeyPerson[] getKeyPerson()

    /**
     * Method getKeyPersonCount
     * 
     * 
     * 
     * @return int
     */
    public int getKeyPersonCount()
    {
        return _keyPersonList.size();
    } //-- int getKeyPersonCount() 

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
     * @param handler
     */


    /**
     * Method removeAllKeyPerson
     * 
     */
    public void removeAllKeyPerson()
    {
        _keyPersonList.removeAllElements();
    } //-- void removeAllKeyPerson() 

    /**
     * Method removeKeyPerson
     * 
     * 
     * 
     * @param index
     * @return KeyPerson
     */
    public KeyPerson removeKeyPerson(int index)
    {
        java.lang.Object obj = _keyPersonList.elementAt(index);
        _keyPersonList.removeElementAt(index);
        return (KeyPerson) obj;
    } //-- KeyPerson removeKeyPerson(int)

    /**
     * Method setKeyPerson
     * 
     * 
     * 
     * @param index
     * @param vKeyPerson
     */
    public void setKeyPerson(int index, KeyPerson vKeyPerson)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _keyPersonList.size())) {
            throw new IndexOutOfBoundsException("setKeyPerson: Index value '"+index+"' not in range [0.." + (_keyPersonList.size() - 1) + "]");
        }
        _keyPersonList.setElementAt(vKeyPerson, index);
    } //-- void setKeyPerson(int, KeyPerson)

    /**
     * Method setKeyPerson
     * 
     * 
     * 
     * @param keyPersonArray
     */
    public void setKeyPerson(KeyPerson[] keyPersonArray)
    {
        //-- copy array
        _keyPersonList.removeAllElements();
        for (int i = 0; i < keyPersonArray.length; i++) {
            _keyPersonList.addElement(keyPersonArray[i]);
        }
    } //-- void setKeyPerson(KeyPerson)

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return KeyPersons
     */


}
