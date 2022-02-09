package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;

import jp.co.sample.service.AdministratorService;

/**
 * @author 土田真丸
 *
 */
@Controller
@RequestMapping("")
public class AdministratorController {
	@Autowired
	private AdministratorService service;
	@Autowired
	private HttpSession session;
	
	
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
		}
	@ModelAttribute
	public LoginForm loginForm() {
		return new LoginForm();
	}
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
	
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}
	
	@RequestMapping("/insert")
	public String insert(@Validated InsertAdministratorForm form,BindingResult result) {
		if(result.hasErrors()){
			return toInsert();
			}
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
		administrator.setPass(form.getPassword());
		administrator.setEmail(form.getMailAddress());
		service.insert(administrator);
		return "/toInsert";
	}
	//** ログアウトする機能*/
	@RequestMapping("/login")
	public String login(LoginForm form,Model model) {
		Administrator administrator = service.login(form.getMailAddress(), form.getPassword());
		
		if(administrator == null) {
			model.addAttribute("notAdministrator","メールアドレスまたはパスワードが不正です。");
			
			return "administrator/login";
		}else {
			session.setAttribute("administratorName", administrator.getName());
			return "forward:/employee/showList";
		}
	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
}
