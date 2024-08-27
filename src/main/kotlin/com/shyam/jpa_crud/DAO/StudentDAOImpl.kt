package com.shyam.jpa_crud.DAO

import com.shyam.jpa_crud.entity.Student
import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class StudentDAOImpl(private val entityManager: EntityManager) : StudentDAO {

    // Implement save method
    @Transactional
    override fun save(theStudent: Student) {
        entityManager.persist(theStudent)
    }

    // Implement findById method
    override fun findById(id : Int): Student {
        return entityManager.find(Student::class.java, id)
    }

    override fun findAll(): List<Student> {
        //create query
        var query : TypedQuery<Student> = entityManager.createQuery("From Student", Student::class.java)
        // from Student is the class name not a table name

        //return result
        return query.resultList
    }

    @Transactional
    override fun updateFirstName(id: Int, changeName: String) {
        val theStudent : Student = entityManager.find(Student::class.java, id)

        theStudent.let {
            it.firstName = changeName
            entityManager.merge(it)
        }
    }

    @Transactional
    override fun delete(id: Int) {
        val theStudent : Student = entityManager.find(Student::class.java, id)
        entityManager.remove(theStudent)
    }
}
