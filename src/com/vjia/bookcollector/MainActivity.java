package com.vjia.bookcollector;


import com.vjia.bookcollector.isbn.IsbnFileUtils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private final static String CLASSNAME = MainActivity.class.getName();
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//点击按钮跳转到二维码扫描界面
		Button mButton = (Button) findViewById(R.id.main2_start_scan);
		mButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, MipcaActivityCapture.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		//the button to show all local scanned books
		Button main2_show_booklist = (Button)findViewById(R.id.main2_show_booklist);
		main2_show_booklist.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, BookListActivity.class);
				startActivity(intent);
			}
		});

	}
	

}
