package ag.pdm;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import ag.pdm.model.ContactRepository;

public class ContactsSizeResource extends ServerResource{

	@Get
	public Representation size(){
		int value = ContactRepository.getContacts().size();
		return new StringRepresentation(String.valueOf(value));
	}
}
