package com.savings.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.savings.app.models.Customer;
import com.savings.app.models.Transaction;
import com.savings.app.models.User;
import com.savings.app.service.CustomerService;
import com.savings.app.service.SavingstypeService;
import com.savings.app.service.TransactionService;
import com.savings.app.service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SavingstypeService savingstypeService;
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
	public ModelAndView LoginPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		  
		return model;
	}
	
	@RequestMapping(value= {"/home"}, method=RequestMethod.GET)
	 public ModelAndView home() {
	  ModelAndView model = new ModelAndView();
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  User user = userService.findUserByEmail(auth.getName());
	  model.addObject("totalCustomers",customerService.countAllCustomers());
	  model.addObject("totalCredit", transactionService.getTotalCredit());
	  model.addObject("totalDebit", transactionService.getTotalDebit());
	  model.addObject("userName", user.getFullname());
	  model.setViewName("home");
	  return model;
	 }
	
	@RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
	 public ModelAndView accessDenied() {
	  ModelAndView model = new ModelAndView();
	  model.setViewName("errors/access_denied");
	  return model;
	 }
	
	//create customers
	@RequestMapping(value = {"/create-depositors"}, method=RequestMethod.GET)
	public ModelAndView customerPage()
	{
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addObject("userName", user.getFullname());
		model.addObject("savingstype", savingstypeService.getAllSavingType());
		model.setViewName("customer");
		return model;
	}
	
	@RequestMapping(value = {"/create-depositors"}, method=RequestMethod.POST)
	public ModelAndView saveCustomerInfo(Customer customer, BindingResult bindingResult)
	{
		 ModelAndView model = new ModelAndView();
		 Customer ifExists = customerService.findCustomerEmail(customer.getEmail());
		  
		  if(ifExists != null) {
			  bindingResult.rejectValue("category", "error.category", "This RECORD already exists!");
		  }
		  if(bindingResult.hasErrors()) {
		   model.setViewName("customer");
		  } else {
			  customerService.saveCustomerDetails(customer);
			  model.addObject("msg", "Successfully saved!");
			  //model.addObject("title", materialService.findAll());
			  model.setViewName("customer");
		  }
		  
		  return model;
	}
	
	//debit transaction
	@RequestMapping(value = {"/debit"}, method = RequestMethod.GET)
	public ModelAndView displayDebitForm(Customer customer) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		ModelAndView model = new ModelAndView();
		model.addObject("customer", customerService.getAllCustomers());
		model.addObject("userName", user.getFullname());
		model.setViewName("debit");
		
		return model;
	}
	
	@RequestMapping(value = {"/debit"}, method = RequestMethod.POST)
	public ModelAndView saveDebitForm(Transaction transaction)
	{	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		ModelAndView model = new ModelAndView();
		transactionService.addDebit(transaction);
		model.addObject("msg", "Amount Debited!");
		model.addObject("customer", customerService.getAllCustomers());
		model.addObject("userName", user.getFullname());
		model.setViewName("debit");
		
		return model;
	}
	
	@RequestMapping(value = {"/credit"}, method = RequestMethod.GET)
	public ModelAndView displayCreditForm(Customer customer) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		ModelAndView model = new ModelAndView();
		model.addObject("customer", customerService.getAllCustomers());
		model.addObject("userName", user.getFullname());
		model.setViewName("credit");
		
		
		return model;
	}
	
	@RequestMapping(value = {"/credit"}, method = RequestMethod.POST)
	public ModelAndView saveCreditForm(Transaction transaction)
	{	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());	
		ModelAndView model = new ModelAndView();
		transactionService.addDebit(transaction);
		model.addObject("msg", "Amount Credited!");
		model.addObject("customer", customerService.getAllCustomers());
		model.addObject("userName", user.getFullname());
		model.setViewName("credit");
		
		return model;
	}
	
	//general report
	@RequestMapping(value = {"/general-report"}, method = RequestMethod.GET)
	public ModelAndView displayGenenalReportForm(Customer customer) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		ModelAndView model = new ModelAndView();
		model.addObject("transaction", customerService.getCustomersTransctions());
		model.addObject("userName", user.getFullname());
		model.setViewName("general-report");
		
		return model;
	}
	
	@RequestMapping(value = {"/view-depositors"}, method = RequestMethod.GET)
	public ModelAndView viewDepositors()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		ModelAndView model	= new ModelAndView();
		model.addObject("customers", customerService.getAllCustomers());
		model.addObject("userName", user.getFullname());
		model.setViewName("view-customers");
		
		return model;
	}
	
	@GetMapping("/view-customer-transaction/{id}")
	public ModelAndView getSingleTransaction(@PathVariable("id") Integer id ) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		ModelAndView model = new ModelAndView();
		model.addObject("transaction", customerService.getIndividualTransctions(id));
		model.addObject("userName", user.getFullname());
		
		model.setViewName("customer-transaction");
		
		return model;
	}
}
