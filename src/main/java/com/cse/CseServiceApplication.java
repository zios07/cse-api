package com.cse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cse.domain.Account;
import com.cse.domain.Location;
import com.cse.domain.Role;
import com.cse.domain.Subarea;
import com.cse.domain.Type;
import com.cse.domain.User;
import com.cse.repository.LocationRepository;
import com.cse.repository.RoleRepository;
import com.cse.repository.SubareaRepository;
import com.cse.repository.TypeRepository;
import com.cse.repository.UserRepository;

@SpringBootApplication
public class CseServiceApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private TypeRepository typeRepo;

	@Autowired
	private SubareaRepository subareaRepo;

	@Autowired
	private LocationRepository locationRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(CseServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role = new Role("ADMIN", "Administrator");
		role = roleRepo.save(role);
		
		Role role2 = new Role("USER", "User");
		role2 = roleRepo.save(role2);

		Account account = new Account("admin", encoder.encode("admin"));
		Account account2 = new Account("user", encoder.encode("user"));

		User user = new User("zakaria.kaoukab@gmail.com", "Zakaria", "Kaoukab", null, account, role);
		User user2 = new User("zakaria@gmail.com", "Zakaria", "Kaoukab", null, account2, role2);
		user = userRepo.save(user);
		user2 = userRepo.save(user2);
		
		Type type = new Type("VILLA", "Villa");
		type = typeRepo.save(type);
		
		Location location = new Location("LOC1", "Location 1", null, true, null);
		location = locationRepo.save(location);
		
		Subarea subarea = new Subarea("sub 1", 1234, 12442, location);
		subareaRepo.save(subarea);	
	}
}
