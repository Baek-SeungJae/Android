package multi.android.datamanagementpro.exam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import multi.android.datamanagementpro.R;

public class ReadActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read);
		Intent intent = getIntent();
		String product = intent.getStringExtra("product");
		Bundle data = intent.getExtras();
		TextView t = (TextView)findViewById(R.id.show);
		t.setText(product);
	}
}
