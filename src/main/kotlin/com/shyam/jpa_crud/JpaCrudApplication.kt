package com.shyam.jpa_crud

import com.shyam.jpa_crud.DAO.StudentDAO
import com.shyam.jpa_crud.entity.Student
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class JpaCrudApplication {

	@Bean
	fun commandLineRunner(studentDAO : StudentDAO): CommandLineRunner {
		return CommandLineRunner { args ->
			//createStudent(studentDAO)
//			readStudent(studentDAO)
//			updateStudents(studentDAO)
//			findAllstudents(studentDAO)
			deleteStudent(studentDAO)
			findAllstudents(studentDAO)
		}
	}

	private fun deleteStudent(studentDAO: StudentDAO) {
		val studId = 2
		studentDAO.delete(2)
	}

	private fun updateStudents(studentDAO: StudentDAO) {
		val studId : Int = 1
		studentDAO.updateFirstName(studId, "Shyam")

	}

	private fun findAllstudents(studentDAO: StudentDAO) {
		var list : List<Student> = studentDAO.findAll()
		for(i in 0..list.size - 1){
			println(list[i])
		}
	}

	private fun readStudent(studentDAO: StudentDAO) {
		val sampleId  : Int = 1
		val myStudent : Student = studentDAO.findById(sampleId)
		println(myStudent)
	}

	private fun createStudent(studentDAO: StudentDAO) {
		//create student object
		println("Creating student Object...")
		val tempStudent = Student("abc","xyz","abcxyz@gmail.com")
		//store student object
		println("Storing the object...")
		studentDAO.save(tempStudent)
		//Display the id of the student
		println("Student saved. Generated id  : " + tempStudent.id)
	}
}

fun main(args: Array<String>) {
	runApplication<JpaCrudApplication>(*args)
}
