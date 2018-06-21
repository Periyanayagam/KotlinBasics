package com.perusudroid.kotlinbasics.normal.basic

data class Employee(val id: Long, val name: String)

data class Company(private val employees: List<Employee>) {
    operator fun get(pos: Int) = employees[pos]
}