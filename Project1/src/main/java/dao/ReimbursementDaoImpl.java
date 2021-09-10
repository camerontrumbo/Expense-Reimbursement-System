package dao;

import models.Reimbursement;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDaoImpl implements ReimbursementDao{

    String url = "jdbc:postgresql://revaturedatabase.caqhkgq4ux3z.us-east-1.rds.amazonaws.com/Project1";
    String username = "postgres";
    String password = "p4ssw0rd";

    @Override
    public Reimbursement createReimb(Reimbursement reimbursement) {
        try(Connection con = DriverManager.getConnection(url, username, password);){

            String sql = "INSERT INTO ers_reimbursement VALUES (DEFAULT, ?, default, null, ?, ?, ?, null, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setBigDecimal(1, BigDecimal.valueOf(reimbursement.getReimbAmount()));
            ps.setString(2, reimbursement.getReimbDescription());
            ps.setBinaryStream(3, reimbursement.getReimbReciept());
            ps.setInt(4, reimbursement.getReimbAuthor());
            ps.setInt(5, reimbursement.getReimbStatusId());
            ps.setInt(6, reimbursement.getReimbTypeId());

            if(ps.executeUpdate() != 0) {
                return reimbursement;
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reimbursement> getReimbWithId(Integer userId) {
        try(Connection con = DriverManager.getConnection(url, username, password);){
            List<Reimbursement> reimbursements = new ArrayList<>();

            String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = " + userId + ";";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                reimbursements.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), (FileInputStream) rs.getBinaryStream(6), rs.getInt(7),
                        rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
            return reimbursements;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Reimbursement> getAllReimb() {
        try(Connection con = DriverManager.getConnection(url, username, password);){

            String sql = "SELECT * FROM ers_reimbursement;";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Reimbursement> tempList = new ArrayList<>();
            while(rs.next()) {
                tempList.add(
                        new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), (FileInputStream) rs.getBinaryStream(6), rs.getInt(7),
                                rs.getInt(8), rs.getInt(9), rs.getInt(10))
                );
            }

            return tempList;

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean denyReimb(Integer id, Integer managerId) {
        try(Connection con = DriverManager.getConnection(url, username, password);){
            String sql = "update ers_reimbursement set (reimb_status_id, reimb_resolved, reimb_resolver) = " +
                    "(2, default, ?) where reimb_id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, managerId);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean approveReimb(Integer id, Integer managerId) {
        try(Connection con = DriverManager.getConnection(url, username, password);){
            String sql = "update ers_reimbursement set (reimb_status_id, reimb_resolved, reimb_resolver) = " +
                    "(3, default, ?) where reimb_id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, managerId);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
