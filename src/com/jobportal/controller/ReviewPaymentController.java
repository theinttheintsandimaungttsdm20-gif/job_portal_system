/**
 * ReviewPaymentServlet class - show review payment page.
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package com.jobportal.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jobportal.model.PaymentModel;
import com.jobportal.model.RegisterPaymentForm;
import com.jobportal.service.PaymentServices;
import com.paypal.api.payments.*;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class ReviewPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewPaymentController() {
	}

	@RequestMapping(value="/cancel_payment",method=RequestMethod.GET)
	public String cancelPaymentServlet(HttpServletRequest request, HttpServletResponse response,ModelMap map)
			throws ServletException, IOException {
		return "cancel";
	}
	
	@RequestMapping(value="/review_payment",method=RequestMethod.GET)
	public String reviewPaymentServlet(HttpServletRequest request, HttpServletResponse response,ModelMap map)
			throws ServletException, IOException {
		String paymentId = request.getParameter("paymentId");
		String payerId = request.getParameter("PayerID");
		String recruiterId=request.getParameter("frmRecruiterId");
		
		System.out.println("Review Payment Controller : "+recruiterId);
		map.addAttribute("paymentId",paymentId);
		map.addAttribute("payerId",payerId);
		map.addAttribute("recruiterId",recruiterId);
		PaymentModel paymentModel=new PaymentModel();
		map.addAttribute("paymentModel",paymentModel);
		
		try {
			PaymentServices paymentServices = new PaymentServices();
			Payment payment = paymentServices.getPaymentDetails(paymentId);
			
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
			
		
			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);
			request.setAttribute("shippingAddress", shippingAddress);
			
			
			String url = "review.jsp?paymentId=" + paymentId + "&PayerID=" + payerId+"&frmRecruiterId="+recruiterId;
			
			return url;
			
			
		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			return "error";
		}		
	}

}
