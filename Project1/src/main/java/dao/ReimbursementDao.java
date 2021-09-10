package dao;

import models.Reimbursement;

import java.util.List;

public interface ReimbursementDao {
    Reimbursement createReimb(Reimbursement reimbursement);
    List<Reimbursement> getReimbWithId(Integer userId);
    List<Reimbursement> getAllReimb();
    Boolean denyReimb(Integer id, Integer managerId);
    Boolean approveReimb(Integer id, Integer managerId);
}
