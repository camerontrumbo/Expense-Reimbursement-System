package service;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import models.Reimbursement;

import java.util.List;

public class ReimbursementService {
    ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();
    public List<Reimbursement> getAllReimbGivenId(Integer userId) {
            return reimbursementDao.getReimbWithId(userId);
    }

    public List<Reimbursement> getAllReimb() {
        return reimbursementDao.getAllReimb();
    }

    public void denyReimb(Integer reimbId, Integer managerId) {
        reimbursementDao.denyReimb(reimbId, managerId);
    }

    public void approveReimb(Integer reimbId, Integer managerId) {
        reimbursementDao.approveReimb(reimbId, managerId);
    }

    public void createReimb(Reimbursement reimbursement) {
        reimbursementDao.createReimb(reimbursement);
    }
}
