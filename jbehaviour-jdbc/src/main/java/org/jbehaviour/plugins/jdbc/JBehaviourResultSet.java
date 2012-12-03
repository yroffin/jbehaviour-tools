/**
 *  Copyright 2012 Yannick Roffin
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.jbehaviour.plugins.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * implements a light and simple result set
 */
public class JBehaviourResultSet implements IBehaviourResultSet {
	private List<String> columns = new ArrayList<String>();
	private List<List<String>> values = new ArrayList<List<String>>();
	private ArrayList<String> current;
	StringBuilder sbFormat = new StringBuilder();
	private Formatter formatter = null;
	private int columnLength = 16;

	/**
	 * create it from rs
	 * @param columnLength 
	 * @param rs
	 * @throws SQLException
	 */
	public JBehaviourResultSet(int _columnLength, ResultSet rs) throws SQLException {
		columnLength = _columnLength;
		formatter = new Formatter(sbFormat);

		/**
		 * compute columns
		 */
		int iMaxCol = rs.getMetaData().getColumnCount() + 1;
		for(int iCol=1;iCol<iMaxCol;iCol++) {
			addColumns(rs.getMetaData().getColumnName(iCol));
		}
		/**
		 * compute rows
		 */
		while(rs.next()) {
			for(int iCol=1;iCol<iMaxCol;iCol++) {
				addValues(rs.getString(iCol),iCol==1,iCol==(iMaxCol-1));
			}
		}
		rs.close();
	}

	/**
	 * line formating
	 * @param iCol
	 * @param value
	 * @return
	 */
	private String format(int iCol, String value) {
		sbFormat.setLength(0);
		if(iCol != 0) {
			formatter.format("%-"+columnLength+"."+columnLength+"s |", value);
		} else {
			formatter.format("| %-"+columnLength+"."+columnLength+"s |", value);
		}
		return sbFormat.toString();
	}
	
	/**
	 * header formating
	 * @param iCol
	 * @param value
	 * @return
	 */
	private String formatHeader(int iCol) {
		sbFormat.setLength(0);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<columnLength;i++) sb.append('-');
		if(iCol != 0) {
			formatter.format("%-"+columnLength+"."+columnLength+"s-+", sb.toString());
		} else {
			formatter.format("+-%-"+columnLength+"."+columnLength+"s-+", sb.toString());
		}
		return sbFormat.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		/**
		 * compute header
		 */
		StringBuilder header = new StringBuilder();
		int iColHeader=0;
		for(@SuppressWarnings("unused") String column : columns) {
			header.append(formatHeader(iColHeader++));
		}
		header.append("\n");

		sb.append("\nRow(s):" + values.size() + "\n");
		sb.append(header);
		int iCol=0;
		for(String column : columns) {
			sb.append(format(iCol++,column));
		}
		sb.append("\n");
		sb.append(header);
		for(List<String> line : values) {
			int iColValue=0;
			for(String column : line) {
				sb.append(format(iColValue++,column));
			}
			sb.append("\n");
		}
		sb.append(header);
		return sb.toString();
	}

	@Override
	public void addColumns(String name) {
		columns.add(name);
	}
	
	@Override
	public void addValues(String value, boolean first, boolean last) {
		if(first) {
			current = new ArrayList<String>();
		}
		current.add(value);
		if(last) {
			values.add(current);
			current = null;
		}
	}

	@Override
	public Integer getRows() {
		return values.size();
	}
}
