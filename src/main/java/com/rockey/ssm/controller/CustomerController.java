package main.java.com.rockey.ssm.controller;

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
import org.springframework.web.servlet.ModelAndView;

import main.java.com.rockey.ssm.controller.validation.IAddAndModifyCustomer;
import main.java.com.rockey.ssm.controller.validation.IFindCustomerByConds;
import main.java.com.rockey.ssm.po.Customer;
import main.java.com.rockey.ssm.po.ModifyCustomer;
import main.java.com.rockey.ssm.po.Page;
import main.java.com.rockey.ssm.service.CustomerService;
import main.java.com.rockey.ssm.util.BasicUtil;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("addCustomer")
	public String  addCustomer(){
		return "customer/addCust";
	}
	
	@RequestMapping("insertNewCustomer")
	public String insertNewCustomer(Model model,@Validated(value={IAddAndModifyCustomer.class}) Customer customer,BindingResult bindingResult) throws Exception{
		//进行数据校验
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			model.addAttribute("custadd", customer);		
			return "customer/addCust";
		}
		//传入的preference是String[]需要做自定义类型绑定的转换
		customerService.addCust(customer);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("showCustomer")
	public String showCustomer(HttpServletRequest request) throws Exception{
		
		int targetpage=request.getParameter("targetpage")==null?1:Integer.parseInt(request.getParameter("targetpage"));
		Page page =customerService.findCustShowInPage(targetpage, request.getSession().getAttribute("page"));
		//放置到session域，可以在一次会话中记忆上一次查询的页。
		request.getSession().setAttribute("page", page);
		return  "customer/listCust";
	}
	
	@RequestMapping("modifyCustomer")
	public ModelAndView modifyCustomer(HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		Customer cust = customerService.findCustById(request.getParameter("custId"));
		mv.addObject("cust", cust);
		mv.setViewName("customer/modifyCust");
		return mv;
	}

	
	@RequestMapping("updateCustomer")
	public String updateCustomer(Model model,@Validated(value={IAddAndModifyCustomer.class}) ModifyCustomer modifyCustomer,BindingResult bindingResult) throws Exception{
		//进行数据校验
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			model.addAttribute("modifyCustomer", modifyCustomer);		
			return "customer/modifyCust";
		}
		customerService.updateCust(modifyCustomer);
		return "redirect:showCustomer.action?targetpage="+modifyCustomer.getPagenum();
	}
	
	@RequestMapping("deleteCustomer")
	public String deleteCustomer(HttpServletRequest request) throws Exception{
		String custId  = request.getParameter("custId");
		customerService.deleteCust(custId);
		int targetpage =((Page)request.getSession().getAttribute("page")).getThispage();
		
		return "redirect:showCustomer.action?targetpage="+targetpage;
	}
	
	@RequestMapping("batchDelelteCustomers")
	public String batchDelelteCustomers(HttpServletRequest request) throws Exception{
		String[] delIds = request.getParameterValues("delId");
		customerService.batchDelCustById(delIds);
		//Page page =  (Page)session.getAttribute("page");
		int targetpage = ((Page)request.getSession().getAttribute("page")).getThispage();
		return "redirect:showCustomer.action?targetpage="+targetpage;
	}
	
	@RequestMapping("findCustomerByConds")
	public String findCustomerByConds(HttpServletRequest request,Model model,@Validated(value={IFindCustomerByConds.class})Customer customer,BindingResult bindingResult) throws Exception{
		//进行数据校验
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			model.addAttribute("customerConds", customer);
			int targetpage = ((Page)request.getSession().getAttribute("page")).getThispage();
			return "forward:showCustomer.action";
		}
		List<Customer> listByConds =customerService.findCustomerByConds(customer);
		model.addAttribute("listByConds", listByConds);
		return  "customer/listCondsCust";
	}
}
