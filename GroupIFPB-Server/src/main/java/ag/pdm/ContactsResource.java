package ag.pdm;

import java.util.List;

import org.restlet.ext.gson.GsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import ag.pdm.model.Contact;
import ag.pdm.model.ContactRepository;

public class ContactsResource extends ServerResource {

	@Get
	public Representation listAll(){
		List<Contact> contacts = ContactRepository.getContacts();		
		GsonRepresentation<List<Contact>> rep = new GsonRepresentation<List<Contact>>(contacts);
		return rep;
	}
}
