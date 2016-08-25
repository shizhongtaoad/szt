package com.example.bb;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView) findViewById(R.id.listView1);
		ArrayList<Resource> list=new ArrayList<Resource>();
		list.add(new Resource(R.drawable.ic_launcher, "Сʱ", "�Է�", "11:11"));
		list.add(new Resource(R.drawable.leftmenu_about, "СС", "��ѧԺ", "11:12"));
		list.add(new Resource(R.drawable.leftmenu_clear_pressed, "С��", "��ˮ", "11:13"));
		list.add(new Resource(R.drawable.leftmenu_collect_normal, "С��", "˯��", "11:14"));
		QAdapter adapter=new QAdapter(list);
		lv.setAdapter(adapter);
	}



}
