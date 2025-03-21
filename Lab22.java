package com.coursecube.jdbc;

import com.coursecube.jdbc.util.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lab22 {
	public static void main(String[] args) {
		AccountService as = new AccountService();
		as.fundsTransfer(101, 102, 2000);
	}

	public static class AccountService {
		void fundsTransfer(int saccno, int daccno, double amt) {
			Connection con = null;
			PreparedStatement ps1 = null;
			PreparedStatement ps2 = null;
			ResultSet rs = null;

			try {
				con = DataSourceUtil.getConnection();
				con.setAutoCommit(false);//Tx Begin
				String SQL1 = "select bal from myaccounts where accno=?";
				String SQL2 = "update myaccounts set bal =? where accno=?";
				ps1 = con.prepareStatement(SQL1);
				ps2 = con.prepareStatement(SQL2);
				// Deposit
				ps1.setInt(1, daccno);// 102
				rs = ps1.executeQuery();
				if (rs.next()) {
					double bal = rs.getInt(1);
					bal = bal + amt;
					ps2.setDouble(1, bal);
					ps2.setDouble(2, daccno);
					ps2.executeUpdate();// Update commit

				} else {
					throw new InvalidAccountNumberException();
				}

				// withdraw
				ps1.setInt(1, saccno);// 101
				rs = ps1.executeQuery();
				if (rs.next()) {
					double bal = rs.getInt(1);
					if (bal >= amt) {
						bal = bal - amt;
						ps2.setDouble(1, bal);
						ps2.setDouble(2, saccno);
						ps2.executeUpdate();
					} else {
						throw new NoFundsException();
					}

				} else {
					throw new InvalidAccountNumberException();
				}
				con.commit();//Tx End
				System.out.println("----Done----");

			} catch (Exception ex) {
				try {
					con.rollback();//End of Tx
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				DataSourceUtil.cleanup(null, con);

			}

		}
	}

}
