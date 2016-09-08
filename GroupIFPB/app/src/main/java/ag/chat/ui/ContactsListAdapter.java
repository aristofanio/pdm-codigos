package ag.chat.ui;

import android.widget.BaseAdapter;

import ag.chat.model.ContactRepository;

/**
 * Created by arigarcia on 8/31/16.
 */
public abstract class ContactsListAdapter extends BaseAdapter {
    private ContactRepository contacts = new ContactRepository();

    @Override
    public int getCount() {
        return contacts.size();//
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
