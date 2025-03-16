package edu.icet.service;

import edu.icet.dto.Admin;

import java.util.List;

public interface AdminService {
    Admin saveAdmin(Admin admin);
    List<Admin> getAllAdmins();
    Admin getAdminById(Long id);
    void deleteAdmin(Long id);
}
