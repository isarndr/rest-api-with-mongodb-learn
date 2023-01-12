package com.codewithisa.restapiwithmongodb;

import com.codewithisa.restapiwithmongodb.entity.Address;
import com.codewithisa.restapiwithmongodb.entity.Student;
import com.codewithisa.restapiwithmongodb.entity.enums.Gender;
import com.codewithisa.restapiwithmongodb.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
@Slf4j
public class RestApiWithMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiWithMongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository, MongoTemplate mongoTemplate){
		return args -> {
			Address address = Address.builder()
					.city("Jakarta")
					.country("Indonesia")
					.postCode("12345")
					.build();

			String email = "akbarbakar@yahoo.com";

			Student student = Student.builder()
					.firstName("Akbar")
					.lastName("Bakar")
					.address(address)
					.email(email)
					.created(LocalDateTime.now())
					.gender(Gender.MALE)
					.favouriteSubjects(Arrays.asList("Computer Science", "Calculus"))
					.totalSpentInBooks(BigDecimal.TEN)
					.build();

			Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);
			if(optionalStudent.isPresent()){
				log.error(student+" already exists");
			}
			else{
				studentRepository.save(student);
				log.info("Inserting student "+student);
			}
		};
	}

}
