package cofee.good.scheduler.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	DataSource dataSource;

	public String getUsers() throws SQLException {
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet rs = null;
		String rv = "";
		try {
			conn = dataSource.getConnection();
			p = conn.prepareStatement("Select * from billionaires");
			p.execute();
			rs = p.getResultSet();

			while (rs.next()) {
				rv += rs.getString(2);
				if(!rs.isLast()) {
					 rv += ", ";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (p != null) {
				p.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return rv;

	}
}
