package Services;


import Repository.AdminRepository;
import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAlL(){
        return (List<Admin>) adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin){
        if(admin.getId()==null) {
            Optional<Admin> e = adminRepository.getAdmin(admin.getId());
            if (e.isPresent()) {
                if (admin.getEmail() != null) {
                    e.get().setEmail(admin.getEmail());
                }
                if (admin.getName() != null) {
                    e.get().setName(admin.getName());
                }
                if (admin.getPassword() != null) {
                    e.get().setPassword(admin.getPassword());
                }
                adminRepository.save(e.get());
                return e.get();
            } else {
                return admin;
            }
        }else{
            return admin;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Admin> p = adminRepository.getAdmin(id);
        if(p.isPresent()){
            adminRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }
}
