package org.jbehaviour.plugins.jdbc;

public interface IBehaviourResultSet {

	/**
	 * add columns
	 * @param name
	 */
	public abstract void addColumns(String name);

	/**
	 * add values
	 * @param value
	 * @param first
	 * @param last
	 */
	public abstract void addValues(String value, boolean first, boolean last);

	/**
	 * return number of rows
	 * @return
	 */
	public abstract Integer getRows();
}