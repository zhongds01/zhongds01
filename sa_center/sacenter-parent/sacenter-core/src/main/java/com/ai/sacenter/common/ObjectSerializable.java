package com.ai.sacenter.common;

import java.beans.PropertyDescriptor;
import java.io.IOException;

import com.ai.sacenter.util.IBeanWrapper;
import com.ai.sacenter.util.MathUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 对象高效序列化</p>
 * <p>Copyright: Copyright (c) 2017年6月8日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ObjectSerializable implements java.lang.Cloneable, java.io.Externalizable{
	public final static byte TC_NULL      = (byte)0X70;
	public final static byte TC_DATA      = (byte)0X71;
	public final static byte TC_BASE      = (byte)0X81;
	public final static byte TC_DESC      = (byte)0X82;
	public final static byte TC_OBJECT    = (byte)0X83;
	public ObjectSerializable(){
		super();
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	public void writeExternal( java.io.ObjectOutput out) throws java.io.IOException {
		IBeanWrapper fromBean = new IBeanWrapper( this );
		try
		{
			PropertyDescriptor[] aDescriptor = fromBean.getPropertyDescriptors();
			out.writeByte( TC_OBJECT );
			out.writeInt( aDescriptor.length );
			for( int index = 0; aDescriptor != null && index < aDescriptor.length; index++ ){
				Object _objective = fromBean.getPropertyValue( aDescriptor[index].getName() );
				if( _objective != null ){
					out.writeByte( TC_DESC );
					out.writeUTF ( aDescriptor[index].getName() );
					out.writeByte( TC_BASE );
					out.writeObject( _objective );
				}
			}
		}
		catch( java.io.IOException exception ){
			throw exception;
		}
		catch( java.lang.Exception exception ){
			throw new java.io.IOException( exception.getMessage(), exception );
		}
		finally{
			if( fromBean != null ){ fromBean = null; }
		}
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	public void readExternal( java.io.ObjectInput in ) throws java.io.IOException, ClassNotFoundException {
		IBeanWrapper fromBean = new IBeanWrapper( this );
		try
		{
			byte _reference = in.readByte();
			if( _reference != TC_OBJECT ){
				throw new java.io.StreamCorruptedException( String.format("invalid type code: %02X", new Object[]{ Byte.valueOf( _reference )}));
			}
			int aDescriptor = in.readInt();
			for( int index = 0; index < aDescriptor; index++ ){
				byte _classdesc = in.readByte();
				if( _classdesc != TC_DESC ){
					throw new java.io.StreamCorruptedException( String.format("invalid type code: %02X", new Object[]{ Byte.valueOf( _classdesc )}));
				}
				String classDesc = in.readUTF();
				byte tcObject = in.readByte();
				if( tcObject != TC_BASE ){
					throw new java.io.StreamCorruptedException( String.format("invalid type code: %02X", new Object[]{ Byte.valueOf( tcObject )}));
				}
				Object _objective = in.readObject();
			    fromBean.setPropertyValue( classDesc, _objective );
			}
		}
		catch( java.io.IOException exception ){
			throw exception;
		}
		catch( java.lang.ClassNotFoundException exception ){
			throw exception;
		}
		catch( java.lang.Exception exception ){
			throw new java.io.IOException( exception.getMessage(), exception );
		}
		finally{
			if( fromBean != null ){ fromBean = null; }
		}
	}
	
	/**
	 * 
	 * @param _in
	 * @return
	 * @throws IOException
	 */
	public boolean readBoolean( java.io.ObjectInput _in ) throws IOException{
		return _in.readBoolean();
	}
	
	/**
	 * 
	 * @param _out
	 * @param _boolean
	 * @throws IOException
	 */
	public void writeBoolean( java.io.DataOutput _out, boolean _boolean ) throws IOException{
		_out.writeBoolean( _boolean );
	}
	
	/**
	 * 
	 * @param _in
	 * @return
	 * @throws IOException
	 */
	public byte readByte( java.io.ObjectInput _in ) throws IOException{
		return _in.readByte();
	}
	
	/**
	 * 
	 * @param _out
	 * @param _byte
	 * @throws IOException
	 */
	public void writeByte( java.io.DataOutput _out, byte _byte ) throws IOException{
		_out.writeByte( _byte );
	}
	
	/**
	 * 
	 * @param _in
	 * @return
	 * @throws IOException
	 */
	public short readShort( java.io.ObjectInput _in ) throws IOException{
		return _in.readShort();
	}
	
	/**
	 * 
	 * @param _out
	 * @param _short
	 * @throws IOException
	 */
	public void writeShort( java.io.DataOutput _out, short _short ) throws IOException{
		_out.writeShort( _short );
	}
	
	/**
	 * 
	 * @param _in
	 * @return
	 * @throws IOException
	 */
	public int readInteger( java.io.ObjectInput _in ) throws IOException{
		return _in.readInt();
	}
	
	/**
	 * 
	 * @param _out
	 * @param _integer
	 * @throws IOException
	 */
	public void writeInteger( java.io.DataOutput _out, short _integer ) throws IOException{
		_out.writeInt( _integer );
	}
	
	/**
	 * 
	 * @param _in
	 * @return
	 * @throws IOException
	 */
	public long readLong( java.io.ObjectInput _in ) throws IOException{
		return _in.readLong();
	}
	
	/**
	 * 
	 * @param _out
	 * @param _long
	 * @throws IOException
	 */
	public void writeLong( java.io.DataOutput _out, long _long ) throws IOException{
		_out.writeLong( _long );
	}
	
	/**
	 * 
	 * @param _in
	 * @return
	 * @throws IOException
	 */
	public float readFloat( java.io.ObjectInput _in ) throws IOException{
		return _in.readFloat();
	}
	
	/**
	 * 
	 * @param _out
	 * @param _long
	 * @throws IOException
	 */
	public void writeFloat( java.io.DataOutput _out, float _float ) throws IOException{
		_out.writeFloat( _float );
	}
	
	/**
	 * 
	 * @param _in
	 * @return
	 * @throws IOException
	 */
	public double readDouble( java.io.ObjectInput _in ) throws IOException{
		return _in.readDouble();
	}
	
	/**
	 * 
	 * @param _out
	 * @param _long
	 * @throws IOException
	 */
	public void writeDouble( java.io.DataOutput _out, double _double) throws IOException{
		_out.writeDouble( _double );
	}
	
	/**
	 * 
	 * @param _in
	 * @return
	 * @throws IOException
	 */
	public String readString( java.io.ObjectInput _in ) throws IOException{
		byte _tc = _in.readByte();
		if( _tc == TC_NULL ) return null;
		else return _in.readUTF();
	}
	
	/**
	 * 
	 * @param _out
	 * @param _string
	 * @throws IOException
	 */
	public void writeString( java.io.DataOutput _out, String _string ) throws IOException{
		if( _string == null ){
			_out.writeByte( TC_NULL );
		}
		else{
			_out.writeByte( TC_DATA );
			_out.writeUTF ( _string );
		}
	}
	
	/**
	 * 
	 * @param _in
	 * @return
	 * @throws IOException
	 */
	public java.util.Date readDate( java.io.ObjectInput _in ) throws IOException{
		byte _tc = _in.readByte();
		if( _tc == TC_NULL ){
			return null;
		}
		else{
			return new java.util.Date( _in.readLong() );
		}
	}
	
	/**
	 * 
	 * @param _out
	 * @param _date
	 * @throws IOException
	 */
	public void writeDate( java.io.DataOutput _out, java.util.Date _date ) throws IOException{
		if( _date == null ){
			_out.writeByte( TC_NULL );
		}
		else{
			_out.writeByte( TC_DATA );
			_out.writeLong( _date.getTime() );
		}
	}
	
	/**
	 * 
	 * @param _in
	 * @return
	 * @throws IOException
	 */
	public java.sql.Timestamp readTimestamp( java.io.ObjectInput _in ) throws IOException{
		byte _tc = _in.readByte();
		if( _tc == TC_NULL ){
			return null;
		}
		else{
			return new java.sql.Timestamp( _in.readLong() );
		}
	}
	
	/**
	 * 
	 * @param _out
	 * @param _timestamp
	 * @throws IOException
	 */
	public void writeTimestamp( java.io.DataOutput _out, java.sql.Timestamp _timestamp ) throws IOException{
		if( _timestamp == null ){
			_out.writeByte( TC_NULL );
		}
		else{
			_out.writeByte( TC_DATA );
			_out.writeLong( _timestamp.getTime() );
		}
	}
	
	/**
	 * 
	 * @param _in
	 * @return
	 * @throws IOException
	 */
	public Object readObject( java.io.ObjectInput _in ) throws ClassNotFoundException, IOException{
		byte _tc = _in.readByte();
		if( _tc == TC_NULL ){
			return null;
		}
		else{
			return _in.readObject();
		}
	}
	
	/**
	 * 
	 * @param _out
	 * @param _objective
	 * @throws IOException
	 */
	public void writeObject( java.io.ObjectOutput _out, Object _objective ) throws IOException{
		if( _objective == null ){
			_out.writeByte( TC_NULL );
		}
		else{
			_out.writeByte( TC_DATA );
			_out.writeObject( _objective );
		}
	}
	
	/**
	 * 对象深度克隆
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public Object clone() throws CloneNotSupportedException {
		Object aOBJECT = null;
		byte[] fromBytes = null;
		try
		{
			fromBytes = MathUtils.IMath.object2byte( this );
			aOBJECT = MathUtils.IMath.byte2object( fromBytes );
		}
		catch( java.lang.Exception exception ){
			throw new java.lang.CloneNotSupportedException( exception.getMessage() );
		}
		finally{
			
		}
		return aOBJECT;
	}

}
