package com.truck.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class AboutPage {
	int totalPage = 0;
	int total = 0;

	public void setTotalAndTotalPage(String sql) {

		Connection conn = DButil.getConnection();
		Statement stmt = DButil.createStatement(conn);
		ResultSet CountRs = null;
		try {
			CountRs = stmt.executeQuery(sql);
			while (CountRs.next()) {
				total++;
			}
			totalPage = (total % 8) > 0 ? total / 8 + 1 : total / 8;// ¹²¼¸Ò³
			if (totalPage == 0) {
				totalPage = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ò³Êý´íÎó!");
		} finally {
			DButil.close(stmt);
			DButil.close(conn);
		}

	}

	public List getDatas(String sql, Object obj) {
		Connection conn = DButil.getConnection();
		List data = new ArrayList();
		try {
			QueryRunner qr = new QueryRunner();
			data = (List) qr.query(conn, sql,
					new BeanListHandler(obj.getClass()));
		} catch (SQLException e) {
			System.out.println("Ò³Êý´íÎó£¡");
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return data;
	}

	public int getTotal() {
		return this.total;
	}

	public int getTotalPage() {
		return this.totalPage;
	}
}
