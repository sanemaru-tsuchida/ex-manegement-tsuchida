package jp.co.sample.controller;





import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	@Autowired
	private HttpSession session;
	
	//**従業員⼀覧を出⼒する。*/
	@RequestMapping("/showList")
	public String showList(Model model) {
		model.addAttribute("employeeList", service.showList());
		if(session.getAttribute("administratorName")==null) {
			return "forward:/";
		}
		
		return "employee/list";
	}
	
	@RequestMapping("/showDetail")
	public String showDetail(String id,Model model) {
		if(session.getAttribute("administratorName")==null) {
			return "forward:/";
		}
		model.addAttribute("employee", service.showDetail(Integer.parseInt(id)));
		return "employee/detail";
	}
	//**従業員詳細(ここでは扶養⼈数のみ)を更新する。*/
	@RequestMapping("/update")
	public String update(@Validated UpdateEmployeeForm form,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return showDetail(form.getId(), model);
		}
		Employee employee =service.showDetail(Integer.parseInt(form.getId()));
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
		service.update(employee);
		return "redirect:/employee/showList";
	}
	
}