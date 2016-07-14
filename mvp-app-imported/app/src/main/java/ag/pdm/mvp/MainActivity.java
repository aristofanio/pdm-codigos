package ag.pdm.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements Presenter {
	Model model = new Model();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				helloClick();
			}
		});

		Button btnGoto = (Button) findViewById(R.id.button);
		btnGoto.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				//navegar para a visão do calc
				//contexto = MainActivity.this
				//para onde = CalcActivity.class
				Intent intent = new Intent(MainActivity.this, CalcActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
	}

	@Override
	public void showHello(String name) {
		Toast.makeText(this, name, Toast.LENGTH_LONG).show();
	}

	@Override
	public void helloClick() {
		String oldname = getName();
		String newname = model.processHello(oldname);
		showHello(newname);
	}

	@Override
	public String getName() {
		EditText et = (EditText) findViewById(R.id.editText1);
		return et.getText().toString();
	}

}
