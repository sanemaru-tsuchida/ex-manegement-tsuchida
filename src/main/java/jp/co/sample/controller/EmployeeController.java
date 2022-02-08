package jp.co.sample.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * @author 土田真丸
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@ModelAttribute
	public UpdateEmployeeForm setUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}
	
	//**従業員⼀覧を出⼒する。*/
	@RequestMapping("/showList")
	public String showList(Model model) {
		model.addAttribute("employeeList", service.showList());
		
		return "employee/list";
	}
	
	@RequestMapping("/showDetail")
	public String showDetail(String id,Model model) {
		model.addAttribute("employee", service.showDetail(Integer.parseInt(id)));
		return "employee/detail";
	}
	//**従業員詳細(ここでは扶養⼈数のみ)を更新する。*/
	@RequestMapping("/update")
	public String update(UpdateEmployeeForm form) {
		Employee employee =service.showDetail(Integer.parseInt(form.getId()));
		employee.setDependentsCount(form.getDependentsCount());
		service.update(employee);
		return "redirect:/employee/showList";
	}
	
}