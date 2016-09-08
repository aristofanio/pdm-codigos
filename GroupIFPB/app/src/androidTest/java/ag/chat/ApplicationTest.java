package ag.chat;

import android.test.AndroidTestCase;

import ag.chat.model.ContactRepository;


public class ApplicationTest extends AndroidTestCase {

    public void test() {
        ContactRepository repository = new ContactRepository();
        assertEquals(7, repository.size());
    }
}