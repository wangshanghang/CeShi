package com.lv.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.list);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("选项"+i);
		}
		//实例自定义内容适配器
		MyAdapter adapter = new MyAdapter(this,list);
		//为listView设置适配器
		lv.setAdapter(adapter);
	}

}
