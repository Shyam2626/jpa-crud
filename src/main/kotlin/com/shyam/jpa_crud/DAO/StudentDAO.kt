package com.shyam.jpa_crud.DAO
import com.shyam.jpa_crud.entity.Student

interface StudentDAO {
    fun save(theStudent : Student)
    fun findById(id : Int) : Student
    fun findAll(): List<Student>
    fun updateFirstName(id : Int, changeName : String)
    fun delete(id : Int)
}