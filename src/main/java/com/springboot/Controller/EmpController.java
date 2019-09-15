package com.springboot.Controller;

import com.springboot.dao.DepartmentDao;
import com.springboot.dao.EmployeeDao;
import com.springboot.entities.Department;
import com.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;
    /**
     * 跳转到员工列表页面
     * @param map
     * @return
     */
    @GetMapping("/emps")
    public String list(Map<String,Object> map){
        Collection<Employee> all = employeeDao.getAll();
        map.put("emps",all);
        return "emp/list";
    }

    /**
     * 跳转到员工添加页面
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Map<String,Object> map){
        Collection<Department> departmentList = departmentDao.getDepartments();
        map.put("departments",departmentList);
        return "emp/add";
    }


    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/emps ";
    }

    @GetMapping("/emp/{id}")
    public String editEmpPage(@PathVariable Integer id,Map<String,Object> map){
        //获取部门信息
        Collection<Department> departmentList = departmentDao.getDepartments();
        map.put("departments",departmentList);

        //获取员工信息
        Employee employee = employeeDao.get(id);
        map.put("emp",employee);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps ";
    }
}
