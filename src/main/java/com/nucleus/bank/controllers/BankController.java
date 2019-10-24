package com.nucleus.bank.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nucleus.bank.model.persistence.account.Account;
import com.nucleus.bank.model.persistence.exceptions.AccountNotFoundException;
import com.nucleus.bank.model.service.account.AccountService;

@Controller
@RequestMapping
public class BankController {
	
	@Autowired
	AccountService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        System.out.println(role);
        String targetUrl = "";
        if(role.equals("[ROLE_ANONYMOUS]")) {
            targetUrl = "redirect:login";
        }
        else if(role.equals("[ROLE_ADMIN]")) {
            targetUrl = "redirect:account";
        } else if(role.equals("[ROLE_USER]")) {
            targetUrl = "redirect:guest";
        }
        return targetUrl;
	}

	
	
	
	@RequestMapping(value = "account", method = RequestMethod.GET)
	public ModelAndView accountGet(ModelAndView mv) {
		mv.addObject("account", new AccountFormBean());
		mv.setViewName("welcome");
		return mv;
	}

	@RequestMapping(value="show", method = RequestMethod.POST)
    public @ResponseBody List<Account>  showData() {	
		List<Account> ac = service.getAllAccounts();
		System.out.println(ac.toString());
		return ac;
	}
	
	@RequestMapping(value="submit", method = RequestMethod.POST)
    public @ResponseBody List<Account>  submittedFromData(@RequestBody Account account, HttpServletRequest request) {	
		//service.addAccount(new Account(account.getAccountNumber(), account.getAccountHolderName(), account.getAccountBalance(), "Active"));
		List<Account> ac = service.getAllAccounts();
		System.out.println(ac.toString());
		return ac;
	}
	
	@RequestMapping(value="delete", method = RequestMethod.POST)
    public @ResponseBody List<Account>  deleteData(@RequestBody Account account,HttpServletRequest request) {
		String acno = account.getAccountNumber();
        System.out.println(acno);
		try {
		service.deleteAccount(acno);
	} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Account> ac = service.getAllAccounts();
		System.out.println(ac.toString());
		return ac;
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
    public @ResponseBody Account  getAcno(HttpServletRequest request, Account account) {	
		String acno = account.getAccountNumber();
        System.out.println(acno);
		
		try {
			account = service.findAccount(acno);
			System.out.println(acno);
		} catch (AccountNotFoundException e) {
						e.printStackTrace();
		}
		
		return account;
	}
	//////
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		 
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("login");

	  return model;

	}
	
	
}
