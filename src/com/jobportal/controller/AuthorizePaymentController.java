/**
 * AuthorizePaymentServlet class - requests PayPal for payment.
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package com.jobportal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobportal.model.ApplicationModel;
import com.jobportal.model.OrderDetail;
import com.jobportal.model.PaymentModel;
import com.jobportal.service.PaymentServices;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class AuthorizePaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthorizePaymentController() {
	}
	@RequestMapping(value="/regPaymentPath",method=RequestMethod.GET)
	public String dispatchLoadRegister(ModelMap modelMap,
			HttpServletRequest req,HttpServletResponse resp) throws IOException{
		System.out.println("Load App Form");
		HttpSession session=req.getSession(true);
		String strId=(String)session.getAttribute("loginId");
		modelMap.addAttribute("recruiterId",strId);
		modelMap.addAttribute("orderDetail",new OrderDetail());
		return "preparePayment";
	}
	@RequestMapping(value="/authorize_payment",method=RequestMethod.POST)
	public String authorizePayment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String service = request.getParameter("service");
		String subtotal = request.getParameter("subtotal");
		String discount = request.getParameter("discount");
		String total = request.getParameter("total");
		String recruiterId=request.getParameter("recruiterId");
		OrderDetail orderDetail = new OrderDetail(service, subtotal, discount,total);

		try {
			PaymentServices paymentServices = new PaymentServices();
			String approvalLink = paymentServices.authorizePayment(orderDetail);

			return "redirect:"+approvalLink+"&frmRecruiterId="+recruiterId;
			
			
		} catch (PayPalRESTException ex) {
			request.setAttribute("errorMessage", ex.getMessage());
			ex.printStackTrace();
			return "error";
		}
	}

}
