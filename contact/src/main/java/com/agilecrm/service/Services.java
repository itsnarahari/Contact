package com.agilecrm.service;

import java.sql.SQLException;
import java.util.List;

import com.agilecrm.dto.Contact;

public interface Services {
	
	public void saveContact(Contact contact) throws SQLException;
	public Contact updateContact(Contact contact);
	public List<Contact> listContacts() throws SQLException;
	public Contact getContactById(int id) throws SQLException;
	public void deleteContact(int id);

}
