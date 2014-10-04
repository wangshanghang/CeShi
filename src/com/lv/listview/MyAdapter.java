package com.lv.listview;

import java.util.List;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private MainActivity mainActivity;
	private List list;
	private ViewHolder viewHolder;
	private View view;
	private TextView title;
	private Button btnDel;

	public MyAdapter(MainActivity mainActivity, List<String> list) {
		// TODO Auto-generated constructor stub
		this.mainActivity = mainActivity;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			viewHolder = new ViewHolder();
			view = LayoutInflater.from(mainActivity).inflate(R.layout.item,
					null);
			title = (TextView) view.findViewById(R.id.title);
			btnDel = (Button) view.findViewById(R.id.del);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		// 为每个view项设置触摸监听
		view.setOnTouchListener(new OnTouchListener() {

			private float x;
			private float ux;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				final ViewHolder holder = (ViewHolder) v.getTag();
				// 当按下时处理
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					v.setBackgroundResource(R.drawable.ic_launcher);
					x = event.getX();
					// 判断之前是否出现删除按钮 如果存在就隐藏
					if (btnDel != null) {
						btnDel.setVisibility(View.GONE);
					} else if (event.getAction() == MotionEvent.ACTION_UP) {
						// 松开处理
						// 设置背景为为选中整成状态
						v.setBackgroundResource(R.drawable.ic_launcher);
						ux = event.getX();
						// 判断当前项中按钮不为空时
						if (holder.btnDl != null) {
							// 按下和松开绝对值差当大于20时显示删除按钮，否则不显示
							if (Math.abs(x - ux) > 20) {
								holder.btnDl.setVisibility(view.VISIBLE);
//								holder.btnDl;
							}

						}

					} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
						// 当滑动时背景为选中状态
						v.setBackgroundResource(R.drawable.ic_launcher);
					} else {// 其他 模式
							// 设置背景为为选中正常状态
						v.setBackgroundResource(R.drawable.ic_launcher);
					}

				}
				return true;
			}
		});
		return null;
	}

	final static class ViewHolder {
		TextView title;
		Button btnDl;
	}

}
