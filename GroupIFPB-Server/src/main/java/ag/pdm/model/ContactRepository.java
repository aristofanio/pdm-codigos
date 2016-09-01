package ag.pdm.model;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
	private static List<Contact> contacts = new ArrayList<Contact>();
	
	static {
        //c1
        Contact c1 = new Contact();
        c1.setCode("C-001");
        c1.setName("Antônio de Pádua");
        contacts.add(c1);
        //c2
        Contact c2 = new Contact();
        c2.setCode("C-002");
        c2.setName("Antônio Carlos");
        contacts.add(c2);
        //c3
        Contact c3 = new Contact();
        c3.setCode("C-003");
        c3.setName("Ana Maria");
        contacts.add(c3);
        //c4
        Contact c4 = new Contact();
        c4.setCode("C-004");
        c4.setName("João Pedro");
        contacts.add(c4);
        //c5
        Contact c5 = new Contact();
        c5.setCode("C-005");
        c5.setName("Luana Paiva");
        contacts.add(c5);
        //c4
        Contact c6 = new Contact();
        c6.setCode("C-006");
        c6.setName("Victor Manel");
        contacts.add(c6);
        //c4
        Contact c7 = new Contact();
        c7.setCode("C-007");
        c7.setName("Bel Bel");
        contacts.add(c7);
    }
	
	public static List<Contact> getContacts() {
		return contacts;
	}
}
