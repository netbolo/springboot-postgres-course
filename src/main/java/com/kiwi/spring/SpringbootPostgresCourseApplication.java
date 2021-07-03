package com.kiwi.spring;

import com.github.javafaker.Faker;
import com.kiwi.spring.model.Student;
import com.kiwi.spring.model.StudentIdCard;
import com.kiwi.spring.repository.StudentIdCardRepository;
import com.kiwi.spring.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringbootPostgresCourseApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootPostgresCourseApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(
      StudentRepository studentRepository,
      StudentIdCardRepository studentIdCardRepository) {
    return args -> {
      Faker faker = new Faker();

      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
      Student student = new Student(
          firstName,
          lastName,
          email,
          faker.number().numberBetween(17, 55));

      StudentIdCard studentIdCard = new StudentIdCard(
          "123456789",
          student);

      studentIdCardRepository.save(studentIdCard);

      studentRepository.findById(1L)
          .ifPresent(System.out::println);

      studentIdCardRepository.findById(1L)
          .ifPresent(System.out::println);

      studentRepository.deleteById(1L);

    };
  }

  private void generateRandomStudents(StudentRepository studentRepository) {
    Faker faker = new Faker();
    for (int i = 0; i < 20; i++) {
      String firstName = faker.name().firstName();
      String lastName = faker.name().lastName();
      String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
      Student student = new Student(
          firstName,
          lastName,
          email,
          faker.number().numberBetween(17, 55));
      studentRepository.save(student);
    }
  }
}
