package com.ai.sacenter.util;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-3-19</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public final class ByteBuffer
{
	private int size;
	private int position = 0;
	private byte[] buffer;
    public ByteBuffer(int aSize) {
		this.size = aSize;
		this.buffer = new byte[this.size];
		for (int i = 0; i < this.buffer.length; ++i) {
			this.buffer[i] = 0;
		}
		this.position = 0;
	}

	public ByteBuffer(byte[] aValue) {
		this.size = aValue.length;
		this.buffer = new byte[this.size];
		append(aValue);
		position = 0;
	}

	public byte[] toByteArray() {
		byte[] value = new byte[this.size];
		System.arraycopy(this.buffer, 0, value, 0, this.size);
		return value;
	}

	public byte[] toByteArray(int length) {
		byte[] value = new byte[length];
		System.arraycopy(this.buffer, 0, value, 0, value.length);
		return value;
	}

	protected void finalize() throws Throwable {
		this.buffer = null;
		super.finalize();
	}

	public void append(byte[] aValue, int aOffsetint, int aLength) {
		System.arraycopy(aValue, 0, this.buffer, aOffsetint, aLength);
		this.position += aOffsetint + aLength;
	}

	public void append(byte[] aValue) {
		System.arraycopy(aValue, 0, this.buffer, this.position, aValue.length);
		this.position += aValue.length;
	}

	public void append(String aValue) {
		append(aValue.getBytes());
	}

	public void append(int aValue) {
		byte[] intByte = MathUtils.IMath.toByteArray(aValue);
		append(intByte);
	}

	public void append(short aValue) {
		byte[] intByte = MathUtils.IMath.toByteArray(aValue);
		append(intByte);
	}

	public void append(byte aValue) {
		byte[] intByte = { aValue };
		append(intByte);
	}

	public void append(ByteBuffer aValue) {
		append(aValue.toByteArray());
	}

	public void insert(byte[] aValue, int aPostion) {
		System.arraycopy(aValue, 0, this.buffer, aPostion, aValue.length);
		this.position += aValue.length;
	}

	public void insert(int aValue, int aPostion) {
		byte[] intByte = MathUtils.IMath.toByteArray(aValue);
		insert(intByte, aPostion);
	}

	public void insert(short aValue, int aPostion) {
		byte[] intByte = MathUtils.IMath.toByteArray(aValue);
		insert(intByte, aPostion);
	}

	public void insert(String aValue, int aPostion) {
		insert(aValue.getBytes(), aPostion);
	}

	public void put(byte[] aByteArray) {
		System.arraycopy(this.buffer, this.position, aByteArray, 0,
				aByteArray.length);
		this.position += aByteArray.length;
	}

	public void put(ByteBuffer aByteBuffer) {
		byte[] temp = new byte[aByteBuffer.capacity()];
		System.arraycopy(this.buffer, this.position, temp, 0, temp.length);
		aByteBuffer.append(temp);
		this.position += temp.length;
	}

	public short getShort() {
		return getShort(0);
	}

	public short getShort(int aIndex) {
		return MathUtils.IMath.toShort(this.buffer, aIndex);
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int capacity() {
		return this.size;
	}

	public void reset() {
		for (int i = 0; i < this.buffer.length; ++i) {
			this.buffer[i] = 0;
		}
		this.position = 0;
	}

	public boolean equals(Object arg0) {
		if (this == arg0) {
			return true;
		}

		if (!(arg0 instanceof ByteBuffer))
			return false;
		if (((ByteBuffer) arg0).capacity() != capacity()) {
			return false;
		}
		byte[] value = ((ByteBuffer) arg0).toByteArray();
		boolean flag = true;
		for (int i = 0; i < value.length; ++i) {
			if (value[i] != this.buffer[i]) {
				flag = false;
				break;
			}
		}

		return flag;
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this.buffer);
	}

	/***
	 * 
	 * @author Administrator
	 * 规定长度字节数组
	 * 如长度超出规定长度的话,遵循FIFO规则
	 */
	public final static class ByteBufferAsFixL {
		private int size;

		private int position = 0;

		private byte[] buffer;

		public ByteBufferAsFixL(int aSize) {
			size = aSize;
			buffer = new byte[size];
			for (int i = 0; i < buffer.length; i++)
				buffer[i] = 0;
			position = 0;
		}

		/***
		 * 
		 * @param aByte
		 */
		public ByteBufferAsFixL(byte[] aByte) {
			size = aByte.length;
			buffer = new byte[aByte.length];
			append(aByte);
		}

		/***
		 * 
		 * @param aValue
		 */
		public void append(byte aValue) {
			if (position < size) {
				buffer[position] = aValue;
				position++;
			} else {
				for (int index = 0; index < position - 1; index++)
					buffer[index] = buffer[index + 1];
				buffer[position - 1] = aValue;
			}
		}

		/***
		 * 
		 * @param aByte
		 */
		public void append(byte aByte[]) {
			for (int i = 0; i < aByte.length; i++)
				append(aByte[i]);
		}

		/***
		 * 
		 *
		 */
		public void reset() {
			for (int i = 0; i < buffer.length; i++)
				buffer[i] = 0;
			this.position = 0;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof ByteBufferAsFixL || obj instanceof byte[]))
				return false;
			else if (obj instanceof ByteBufferAsFixL) {
				return toString().equals(((ByteBufferAsFixL) obj).toString());
			} else if (obj instanceof byte[]) {
				return toString().equals(
						MathUtils.IMath.byte2hex(((byte[]) obj)));
			}
			return false;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return MathUtils.IMath.byte2hex(buffer).toUpperCase();
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#finalize()
		 */
		protected void finalize() throws Throwable {
			buffer = null;
			super.finalize();
		}
	}
}