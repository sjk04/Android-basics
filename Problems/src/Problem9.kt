fun main() {

    val employees = listOf(
        EmployeeRecord(1, "Amit", "amit@company.com", "Engineering", 90000),
        EmployeeRecord(2, "Neha", null, "Engineering", 75000),
        EmployeeRecord(3, "Raj", "raj@company.com", null, 85000),
        EmployeeRecord(4, "Kiran", "kiran@company.com", "HR", 60000),
        EmployeeRecord(5, "Sonal", "sonal@company.com", "Engineering", 82000)
    )
    val filteredEmployees = employees.filter {
        it.department == "Engineering" && it.email != null
    }
    println("Engineering employees with email:")
    filteredEmployees.forEach { println(it.name) }
    val highSalaryEmployee = employees.find { it.salary > 80000 }

    println("First employee with salary > 80,000:")
    println(highSalaryEmployee)
    println("Employee Details:")
    employees.forEach { emp ->
        println("Name: ${emp.name}")
        println("Email: ${emp.email ?: "Not Available"}")
        println("Department: ${emp.department ?: "Unknown"}")
    }
}
data class EmployeeRecord(
    val id: Int,
    val name: String,
    val email: String?,
    val department: String?,
    val salary: Int
)
