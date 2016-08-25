package com.example.bb;

import java.util.ArrayList;
import java.util.zip.Inflater;

import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class QAdapter extends BaseAdapter {
	ArrayList<Resource> list;

	public QAdapter(ArrayList<Resource> list) {
		super();
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list == null ? 0 : list.size();
	}

	@Override
	public Resource getItem(int position) {
		// TODO Auto-generated method stub
		return list == null ? null : list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v=View.inflate(parent.getContext(), R.layout.activity_rr, null);
		ImageView img=(ImageView) v.findViewById(R.id.img);
		TextView name= (TextView) v.findViewById(R.id.tv_name);
		TextView context= (TextView) v.findViewById(R.id.tv_context);
		TextView data= (TextView) v.findViewById(R.id.tv_data);
		Resource  c=getItem(position);
		img.setImageResource(c.getID());
		name.setText(c.getName());
		context.setText(c.getContext());
		data.setText(c.getData());
		return v;
	}

}
