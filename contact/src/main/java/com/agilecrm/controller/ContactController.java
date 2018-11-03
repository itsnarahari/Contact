package com.agilecrm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agilecrm.dto.Contact;
import com.agilecrm.serviceimpl.ServiceImpl;

@WebServlet(name="ContactController", urlPatterns = {"/ContactController"})
public class ContactController extends HttpServlet {
	/**
	 * Author By Narahari
	 */
	private static final long serialVersionUID = 1L;
	private static String insertOrEdit = "/contactReg.jsp";
	private static String listContact = "/listContact.jsp";

	private ServiceImpl services;

	public ContactController() {
		services = new ServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String forward = "";
		String action = req.getParameter("action");
		if (action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			services.deleteContact(id);
			forward = listContact;
			try {
				req.setAttribute("contact", services.getClass());
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		else if (action.equalsIgnoreCase("edit")) {
			forward = insertOrEdit;
			int id = Integer.parseInt(req.getParameter("id"));

			try {

				Contact contact = services.getContactById(id);
				req.setAttribute("contact", contact);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		else if (action.equalsIgnoreCase("listContact")) {
			forward = listContact;

			try {
				req.setAttribute("contact", services.getClass());

			} catch (Exception e) {
				e.printStackTrace();

			}
		} else {
			forward = insertOrEdit;
		}
		RequestDispatcher view = req.getRequestDispatcher(forward);
		view.forward(req, resp);

		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		Contact contact = new Contact();
		String id = req.getParameter("id");
		contact.setFname(req.getParameter("fname"));
		contact.setLname(req.getParameter("lname"));
		contact.setEmail(req.getParameter("email"));
		contact.setMobile(req.getParameter("mobile"));

		if (id == null || id.isEmpty()) {
			try {
				services.saveContact(contact);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			contact.setId(Integer.parseInt(id));
			services.updateContact(contact);
		}
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
		super.doPost(req, resp);
	}

}
