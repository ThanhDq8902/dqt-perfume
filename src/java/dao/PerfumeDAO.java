/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import DAL.DBContext;
import static dao.RegisterDAO.conn;
import entity.Brand;
import entity.Perfume;
import java.sql.*;
import java.util.*;

/**
 *
 * @author mrT
 */
public class PerfumeDAO {

  private Connection con;

  public String status = "";

  public PerfumeDAO() {
    try {
      con = new DBContext().getConnection();
      status = "Ket noi thanh cong";
    } catch (Exception e) {
      status = "ket noi that bai " + e.getMessage();
    }
  }

  public List<Perfume> getAll() {
    String sql = "select * from [perfume] ";
    List<Perfume> list = new ArrayList<>();
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(new Perfume(rs.getInt(1), rs.getString(2),
                rs.getString(3), rs.getInt(4),
                rs.getInt(5), rs.getString(6),
                rs.getInt(7), rs.getInt(8), rs.getString(9)));
      }
    } catch (Exception e) {
      System.out.println("Error");
      return null;
    }
    return list;
  }

  public List<Brand> getAllBrand() {
    String sql = "select * from [brand] ";
    List<Brand> list = new ArrayList<>();
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(new Brand(rs.getInt(1), rs.getString(2)));
      }
    } catch (Exception e) {
      System.out.println("Error");
      return null;
    }
    return list;
  }

  public Perfume getHot() {
    String query = "select top 1 * from perfume "
            + "order by sell__number DESC";
    try {
      PreparedStatement ps = con.prepareStatement(query);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        return new Perfume(rs.getInt(1), rs.getString(2),
                rs.getString(3), rs.getInt(4),
                rs.getInt(5), rs.getString(6),
                rs.getInt(7), rs.getInt(8), rs.getString(9));
      }
    } catch (Exception e) {
      System.out.println("Error");
    }
    return null;
  }

  public List<Perfume> getPerfumebyBid(String bid) {
    String query = "select * from perfume "
            + "Where brand_id = ?";
    List<Perfume> list = new ArrayList<>();
    try {
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, bid);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(new Perfume(rs.getInt(1), rs.getString(2),
                rs.getString(3), rs.getInt(4),
                rs.getInt(5), rs.getString(6),
                rs.getInt(7), rs.getInt(8), rs.getString(9)));
      }
    } catch (Exception e) {
      System.out.println("Error");
      return null;
    }
    return list;
  }

  public Perfume getDetailById(String bid) {
    String query = "select * from perfume "
            + "Where id = ?";

    try {
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, bid);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        return (new Perfume(rs.getInt(1), rs.getString(2),
                rs.getString(3), rs.getInt(4),
                rs.getInt(5), rs.getString(6),
                rs.getInt(7), rs.getInt(8), rs.getString(9)));
      }
    } catch (Exception e) {
      System.out.println("Error");
      return null;
    }
    return null;
  }

  public List<Perfume> getPerfumebyName(String Search) {
    String query = "select * from perfume  "
            + "where [name] like ? ";
    List<Perfume> list = new ArrayList<>();
    try {
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, "%" + Search + "%");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(new Perfume(rs.getInt(1), rs.getString(2),
                rs.getString(3), rs.getInt(4),
                rs.getInt(5), rs.getString(6),
                rs.getInt(7), rs.getInt(8), rs.getString(9)));
      }
    } catch (Exception e) {
      System.out.println("Error");
      return null;
    }
    return list;
  }

  public Brand getBrandByID(int id) {
    String sql = "select * from [brand] \n " + "WHERE [id] = ?";
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        return new Brand(rs.getInt(1), rs.getString(2));
      }
    } catch (Exception e) {
      System.out.println("Error");
      return null;
    }
    return null;
  }

  public void deleteProduct(String id) {
    String sql = "Delete from [perfume] WHERE [id] = ?";
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, id);
      ps.executeUpdate();
    } catch (Exception e) {
      System.out.println("Error");
    }
  }
}

