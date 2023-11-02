package Projet.ete.Parapharmcie.service;

import Projet.ete.Parapharmcie.model.Admin;
import Projet.ete.Parapharmcie.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepo adminRepository;

    @Autowired
    public AdminService(AdminRepo adminRepository) {
        this.adminRepository = adminRepository;
    }
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public void updateAdmin(Long id, Admin updatedAdmin) {
        Admin admin = getAdminById(id);
        if (admin != null) {
            admin.setUsername(updatedAdmin.getUsername());
            admin.setPassword(updatedAdmin.getPassword());
            admin.setEmail(updatedAdmin.getEmail());
            adminRepository.save(admin);
        }
    }


    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
