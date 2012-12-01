package org.jbehaviour.plugins.remote;

public interface IResourcesItem {
	String getName();
	String getLongName();
	boolean isCanRead();
	boolean isCanWrite();
	long getSize();
	void setName(String name);
	void setLongName(String longName);
	void setCanRead(boolean canRead);
	void setCanWrite(boolean canWrite);
	void setSize(long _size);
}
