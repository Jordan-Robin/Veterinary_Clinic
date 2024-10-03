package fr.eni.veterinary_clinic;

import fr.eni.veterinary_clinic.model.Staff;
import fr.eni.veterinary_clinic.repository.StaffDAOJdbcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VeterinaryClinicApplication implements CommandLineRunner {

	@Autowired
	private StaffDAOJdbcImpl staffDao;

	public static void main(String[] args) {
		SpringApplication.run(VeterinaryClinicApplication.class, args);
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//String malalanich = passwordEncoder.encode("malalanich");
	}

	@Override
	public void run(String... args) {
		Staff staff = staffDao.getStaffByMail("benoit-decajou@vet.com");
		System.out.println(staff);
	}


}
