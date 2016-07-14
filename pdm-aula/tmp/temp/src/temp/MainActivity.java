package temp;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//
		WebView view = new WebView(this);
		view.setLayoutParams(
				new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
		);
		//
		setContentView(view);
	}
	
}
