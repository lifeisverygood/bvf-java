package com.rajeshpg.brv.messageprovider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

public class DBMessageProvider extends AbstractMessageProvider {

	private Properties dbProps = getProperties();
	private String msgTableName;
	private String msgIdColumnName;
	private String msgDescColumnName;
	private String langIdColumnName;

	private DataSource dataSource;
	private Connection connection;

	public DBMessageProvider(Properties dbProps) {
		super(dbProps);
	}

	public void configure() {
		loadProperties();
		executeQuery();
	}

	private void loadProperties() {

		this.msgTableName = dbProps.getProperty("dbMsgTableName");
		this.msgIdColumnName = dbProps.getProperty("dbMsgIdColName");
		this.msgDescColumnName = dbProps.getProperty("dbMsgDescColName");
		this.langIdColumnName = dbProps.getProperty("dbLangIdColName");

	}

	public void loadDescription(Message msg) {
		String msgDesc = (String)getMsgProviderMap().get(msg.getMessageId()+"_"+getLanguage());
		msg.setDescription(msgDesc);
	}

	protected Connection getConnection() throws SQLException {
		this.connection = dataSource.getConnection();
		return connection;
	}

	protected void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	protected Map executeQuery() {
		String msgQuery = buildQuery();
		String msgid_langid = getMsgIdColumnName() + "_"
				+ getLangIdColumnName();
		try {
			PreparedStatement preparedStatement = getConnection()
					.prepareStatement(msgQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				getMsgProviderMap().put(resultSet.getString(msgid_langid),resultSet.getString(getMsgDescColumnName()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return getMsgProviderMap();
	}

	private String buildQuery() {
		String space = " ";
		String comma = ",";
		StringBuffer msgQueryBuffer = new StringBuffer("SELECT ").append(space)
				.append(getMsgIdColumnName());
		msgQueryBuffer.append(comma).append(getMsgDescColumnName());
		msgQueryBuffer.append(comma).append(getLangIdColumnName());
		msgQueryBuffer.append(space).append("FROM").append(space).append(getMsgTableName());
		msgQueryBuffer.append(space).append("ORDER BY");
		msgQueryBuffer.append(space).append(getMsgIdColumnName()).append(comma);
		msgQueryBuffer.append(getLangIdColumnName());

		return msgQueryBuffer.toString();
	}

	protected String getMsgTableName() {
		return msgTableName;
	}

	protected String getMsgIdColumnName() {
		return msgIdColumnName;
	}

	protected String getMsgDescColumnName() {
		return msgDescColumnName;
	}

	protected String getLangIdColumnName() {
		return langIdColumnName;
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	}

}
