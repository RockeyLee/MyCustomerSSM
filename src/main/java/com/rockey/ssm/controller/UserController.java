package main.java.com.rockey.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import main.java.com.rockey.ssm.service.CustomerService;
import main.java.com.rockey.ssm.service.UserService;
import main.java.com.rockey.ssm.po.UserRegister;
import main.java.com.rockey.ssm.po.User;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("toLoginJsp")
	public String toLoginJsp(){
		return "user/login";
	}
	
	@RequestMapping("toRegisterJsp")
	public String toRegisterJsp(){
		return "user/register";
	}
	
	@RequestMapping("registerUser")
	public String  registerUser(Model model,@Validated UserRegister userRegister,BindingResult bindingResult) throws Exception{
		
		List<ObjectError> allErrors=null;
		//进行数据校验
		if (bindingResult.hasErrors()) {
			// 获取错误信息
			allErrors = bindingResult.getAllErrors();
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			//回显之前填写的数据
			model.addAttribute("userRegister", userRegister);		
			// 出错回到注册页面
			return "user/register";
		}
		//检验两次密码是否一致
		if(!userRegister.getPassword().equals(userRegister.getPassword2())){
			allErrors= new ArrayList<ObjectError>();
			ObjectError objError = new ObjectError("diff","password is different,please check!");
			allErrors.add(objError);
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			//回显之前填写的数据
			model.addAttribute("userRegister", userRegister);		
			// 出错回到注册页面
			return "user/register";
		}
		userService.addUser(userRegister);
		return "redirect:/index.jsp";
	}
	@RequestMapping("login")
	public String login(Model model,HttpSession session,@Validated User user,BindingResult bindingResult) throws Exception{
		
		List<ObjectError> allErrors =null;
		if (bindingResult.hasErrors()) {
			// 获取错误信息
			allErrors = bindingResult.getAllErrors();
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			//回显之前填写的数据
			model.addAttribute("userlogin", user);		
			// 出错回到登录页面
			return "user/login";
		}
		User currentuser = userService.findUserByNameAndPwd(user);
		if(currentuser==null){
			allErrors= new ArrayList<ObjectError>();
			ObjectError objError = new ObjectError("newerror","password or name is wrong,please check!");
			allErrors.add(objError);
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			//回显之前填写的数据
			model.addAttribute("userlogin", user);		
			// 出错回到登录页面
			return "user/login";
		}
		if(currentuser!=null)
			session.setAttribute("user", currentuser);
		return "redirect:/index.jsp";
	}
	@RequestMapping("logOut")
	public String logOut(HttpSession session){
		session.invalidate();
		return  "redirect:/index.jsp";
		
	}
}
