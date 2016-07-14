package pdm.temp;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;


public class MainActivity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //
        WebView view = new WebView(this);
        view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl("http://192.168.1.117:8084/pdm-webview-hello-world");
        //

        setContentView(view);
    }
}
