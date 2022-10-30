package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAL.DBContext;
import entity.SecurityQuestion;
import entity.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegisterDAO {

  static Connection conn = null;
  static PreparedStatement ps = null;

  public static String hashString(String stringToHash) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(stringToHash.getBytes());
      String stringHash = new String(messageDigest.digest());
      return stringHash;
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return stringToHash;
  }

  public static void signup(String fullname, String username, String password, String phone_num,
           String email,int quesID,String answer) {
    String hashedUserName = hashString(username);
    String hashedPassword = hashString(password);

    String query = "insert into [user] values(?,?,?,?,null,?,?,?,0)";

    try {
      conn = new DBContext().getConnection();
      ps = conn.prepareStatement(query);
      ps.setString(1, fullname);
      ps.setString(2, hashedUserName);
      ps.setString(3, hashedPassword);
      ps.setString(4, phone_num);
      ps.setString(5, email);
      ps.setInt(6,quesID);
      ps.setString(7, answer);
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static User login(String username, String password) {
    ResultSet rs;
    String query = "Select * from [user] \n"
            + "where [name] = ?\n"
            + " and [password] = ?";
    String hashedUserName = hashString(username);
    String hashedPassword = hashString(password);
    try {
      conn = new DBContext().getConnection();
      ps = conn.prepareStatement(query);
      ps.setString(1, hashedUserName);
      ps.setString(2, hashedPassword);
      rs = ps.executeQuery();
      if (rs.next()) {
        return new User(rs.getInt(1), rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getInt(8),
                rs.getString(9),
                rs.getInt(10));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static List<SecurityQuestion> getQuestions() {
    String sql = "select * from [security_questions] ";
    List<SecurityQuestion> list = new ArrayList<>();
    try {
      conn = new DBContext().getConnection();
      PreparedStatement statement = conn.prepareStatement(sql);
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        list.add(new SecurityQuestion(rs.getInt(1),
                rs.getString(2)));
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return list;
  }
}
