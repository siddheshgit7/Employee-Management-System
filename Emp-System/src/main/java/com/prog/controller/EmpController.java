package com.prog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Employee;
import com.prog.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<Employee> emp = service.getAllEmp();
		m.addAttribute("emp",emp); // whole data
		return "index.html";

	}
	
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp.html";
	}

	
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg", "Employee Added Successfully...");
		
		return "redirect:/";
	}
	
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)  //Modal is use to send data to the UI layer
	{
		
		Optional<Employee> e = service.getEmpById(id);
		
		m.addAttribute("emp", e);
		
		return "edit.html";
	}
	
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg","Employee Data Update Successfully...");
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session)
	{
		
		service.deleteEmp(id);
		session.setAttribute("msg", "Employee Deleted Successfully...");
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
































