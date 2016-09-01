package ag.chat.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import ag.chat.R;
import ag.chat.model.Contact;

public class ContactsList extends AppCompatActivity {


    private void initListView(){
        //
        ListAdapter adapter = new ContactsListAdapter() {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //
                Contact contact = (Contact) getItem(position);
                //
                View view  = getLayoutInflater().inflate(R.layout.fragment_contacts_list_item, null);
                TextView symbol = (TextView) view.findViewById(R.id.tvsymbol);
                symbol.setText(contact.getName().substring(0, 2));
                symbol.setBackgroundResource(position % 2 == 0 ? R.drawable.circtxt_blue : R.drawable.circtxt_red);
                TextView name = (TextView) view.findViewById(R.id.tvtitle);
                name.setText(contact.getName());
                TextView messa = (TextView) view.findViewById(R.id.tvmessage);
                messa.setText("Nenhuma mensagem por enquanto");
                //
                return view;
            }
        };
        //
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        //configurar o listview
        initListView();
    }
}
