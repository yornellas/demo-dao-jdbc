package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		List<Department> list = new ArrayList<>();
		
		System.out.println("=== TEST 1: Department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: Department findAll ===");
		list = departmentDao.findAll();
		for(Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("\n=== TEST 3: Department insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("New " +newDepartment.getName() +" department inserted. Id = " +newDepartment.getId());

		System.out.println("\n=== TEST 4: Department update ===");
		department = departmentDao.findById(3);
		department.setName("Underwear");
		departmentDao.update(department);
		System.out.println("Department updated.");
		
		System.out.println("\n=== TEST 5: Department delete ===");
		department = departmentDao.findById(5);
		departmentDao.deleteById(department.getId());
		System.out.println("Department " +department.getName() +" deleted.");
	}

}
