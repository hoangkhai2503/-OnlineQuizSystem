package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.manager.entities.Superadmin;
import com.manager.repository.SuperAdminRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import com.manager.entities.Role;
@Service
public class SuperAdminServiceImpl implements SuperAdminService{
	@Autowired
	private SuperAdminRepository superAdminRepository;
	@Override
	public Iterable<Superadmin> findAll() {
		// TODO Auto-generated method stub
		return superAdminRepository.findAll();
	}
	@Override
	public boolean save(Superadmin superadmin) {
		try {
			superAdminRepository.save(superadmin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Superadmin loginAdmin(String username_superadmin, String password_superadmin) {
		try {
			return superAdminRepository.loginAdmin(username_superadmin, password_superadmin);
		} catch (Exception e) {
			e.printStackTrace();
			return null; // Trả về null nếu xảy ra lỗi hoặc không tìm thấy tài khoản.
		}
	}
	@Override
	public Superadmin findByUsernameAdmin(String username_superadmin) {
		return superAdminRepository.findByUsernameAdmin(username_superadmin);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Superadmin superadmin = superAdminRepository.findByUsernameAdmin(username);
	    if (superadmin == null) {
	        throw new UsernameNotFoundException("Username Not Found");
	    }

	    List<GrantedAuthority> authorities = new ArrayList<>();
	    Role role = superadmin.getRole();
	    if (role != null) {
	        authorities.add(new SimpleGrantedAuthority(role.getName_role()));
	    }

	    return new User(username, superadmin.getPassword_superadmin(), authorities);
	}

}
