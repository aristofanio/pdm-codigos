package ag.pdm.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalcActivity extends Activity implements CalcPresenter {
	CalcModel model = new CalcModel();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calcmain);
		//soma
		Button btnSum = (Button) findViewById(R.id.btnSum);
		btnSum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sumClick();
			}
		});
		//diferença
		Button btnDiff = (Button) findViewById(R.id.btnDiff);
		btnDiff.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				diffClick();
			}
		});
	}

	@Override
	public int getValue1() {
		EditText et = (EditText) findViewById(R.id.etv1);
		String etv1 = et.getText().toString();
		return Integer.parseInt(etv1);
	}

	@Override
	public int getValue2() {
		EditText et = (EditText) findViewById(R.id.etv2);
		String etv2 = et.getText().toString();
		return Integer.parseInt(etv2);
	}

	@Override
	public void sumClick() {
		int r = model.sum(getValue1(), getValue2());
		showResult(r);
	}

	@Override
	public void diffClick() {
		int r = model.diff(getValue1(), getValue2());
		showResult(r);
	}

	@Override
	public void showResult(int r) {
		Toast.makeText(this, "O resultado é " + r, Toast.LENGTH_LONG).show();
	}
}
