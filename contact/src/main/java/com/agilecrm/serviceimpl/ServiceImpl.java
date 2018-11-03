package com.agilecrm.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import com.agilecrm.dao.Dao;
import com.agilecrm.dto.Contact;
import com.agilecrm.service.Services;

public class ServiceImpl implements Services {
	Dao dao;

	public void saveContact(Contact contact) throws SQLException {
		dao.saveContact(contact);
	}
	public Contact updateContact(Contact contact) {
		return dao.updateContact(contact);
	}
	public List<Contact> listContacts() throws SQLException {
		return dao.listContacts();
	}
	public Contact getContactById(int id) throws SQLException {
		return dao.getContactById(id);
	}
	public void deleteContact(int id) {
		dao.deleteContact(id);
	}

}
