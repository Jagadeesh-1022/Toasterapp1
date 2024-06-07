
package com.edubridge.mytoasterapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.mytoasterapp.model.Toaster;
import com.edubridge.mytoasterapp.utils.DBUtils;

public class ToasterDaoImpl implements ToasterDao {

	static Connection con = DBUtils.getConection();

	@Override
	public int addToaster(Toaster c) {
		String INSERT_QUERY = "insert into Toaster(Brand,Capacity,Colour,Price,Rating) values(?,?,?,?,?) ";
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, c.getBrand());
			ps.setString(2, c.getCapacity());
			ps.setString(3, c.getColour());
			ps.setFloat(4, c.getPrice());
			ps.setDouble(5, c.getRating());

			status = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return status;
	}

	public List<Toaster> findToasters() {

		String SELECT_QUERY = "select* from Toaster";

		List<Toaster> contactList = new ArrayList<>();

		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Toaster c = new Toaster();
				c.setId(rs.getInt("id"));
				c.setBrand(rs.getString("Brand"));
				c.setCapacity(rs.getString("Capacity"));
				c.setColour(rs.getString("Colour"));
				c.setPrice(rs.getFloat("price"));
				c.setRating(rs.getDouble("Rating"));
				contactList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactList;

	}

	@Override
	public int updateToaster(Toaster c) {
		String UPDATE_QUERY = "update Toaster set Brand=?,Capacity=?,Colour=?,Price=?,Rating=? where id=?";
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
			ps.setString(1, c.getBrand());
			ps.setString(2, c.getCapacity());
			ps.setString(3, c.getColour());
			ps.setFloat(4, c.getPrice());
			ps.setDouble(5, c.getRating());
			ps.setInt(6, c.getId());

			status = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return status;

	}

	@Override
	public int deleteToasterByBrand(String Brand) {
		String DELETE_QUERY = "delete from Toaster where Brand=?";
		int status = 0;

		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setString(1, Brand);
			status = ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return status;
	}

	@Override
	public void deleteAllToasters() {
		String DELETE_QUERY = "delete from Toaster";
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	

	@Override
	public Toaster findToastersByBrand(String brand) {
		Toaster c = null;

		String SELECT_QUERY = "Select * from Toaster where Brand=?";
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ps.setString(1, brand);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c = new Toaster();
				c.setId(rs.getInt("id"));
				c.setBrand(rs.getString("Brand"));
				c.setCapacity(rs.getString("Capacity"));
				c.setColour(rs.getString("Colour"));
				c.setPrice(rs.getFloat("Price"));
				c.setRating(rs.getDouble("Rating"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return c;
	}

}
