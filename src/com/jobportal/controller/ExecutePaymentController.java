/**
 * ExecutePaymentServlet class - execute payment via PayPal.
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package com.jobportal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.PaymentModel;
import com.jobportal.model.RecruiterModel;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.model.RegisterPaymentForm;
import com.jobportal.service.PaymentDaoService;
import com.jobportal.service.PaymentServices;
import com.jobportal.service.RecruiterService;
import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class ExecutePaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PaymentDaoService myPaymentDaoService;

	public ExecutePaymentController() {
	}

	@RequestMapping(value="/execute_payment",method=RequestMethod.POST)
	public String executePaymentServlet(HttpServletRequest request, HttpServletResponse response,ModelMap map,@ModelAttribute(name="paymentModel")PaymentModel myModel)
			throws ServletException, IOException {
		String paymentId = request.getParameter("paymentId");//1
		String payerId = request.getParameter("PayerID");
		String recruiterId=request.getParameter("frmRecruiterId");//2
		System.out.println("Execute Payment Controller "+recruiterId);
		this.myPaymentDaoService.registerPayment(myModel);
		
		RegisterPaymentForm form=new RegisterPaymentForm();
		
		RecruiterModel model=new RecruiterModel();
		model.setFrmRecruiterId(recruiterId);
		form.setRecruiterModel(model);
		
		
		
		try {
			PaymentServices paymentServices = new PaymentServices();
			Payment payment = paymentServices.executePayment(paymentId, payerId);
			this.myPaymentDaoService.getRecruiterbyId(form.getRecruiterModel());
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			
			
			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);
			
			map.addAttribute("registerPaymentForm",form);
			return "receipt";
			//request.getRequestDispatcher("receipt.jsp").forward(request, response);
			
		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			
			return "error";
			//request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	
	

}
