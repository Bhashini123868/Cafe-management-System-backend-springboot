package edu.icet.service.impl;

import edu.icet.dto.Admin;
import edu.icet.entity.AdminEntity;
import edu.icet.repository.AdminRepository;
import edu.icet.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {
    final AdminRepository adminRepository;
    final ModelMapper mapper;

    @Override
    public Admin saveAdmin(Admin admin) {
        AdminEntity entity = mapper.map(admin, AdminEntity.class);
        AdminEntity savedEntity = adminRepository.save(entity);
        return mapper.map(savedEntity, Admin.class);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll().stream()
                .map(entity -> mapper.map(entity, Admin.class))
                .collect(Collectors.toCollection(null));
    }

    @Override
    public Admin getAdminById(Long id) {
        Optional<AdminEntity> entity = adminRepository.findById(id);
        return entity.map(adminEntity -> mapper.map(adminEntity, Admin.class)).orElse(null);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
