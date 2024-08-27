package com.shyam.jpa_crud.entity

import jakarta.persistence.*


@Entity
@Table(name = "student")
class Student(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null,

    @Column(name = "email")
    var email: String? = null
) {

    constructor(firstName: String?, lastName: String?, email: String?) : this(
        id = null,
        firstName = firstName,
        lastName = lastName,
        email = email
    )

    override fun toString(): String {
        return "Student(id=$id, firstName=$firstName, lastName=$lastName, email=$email)"
    }
}
