package com.example.sean.onedroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MoreInfo extends Fragment {
	public static String values = "";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.activity_more_info, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.activity_more_info);
		TextView textView = (TextView) view.findViewById(R.id.moreInfo);
		switch (values) {
			case "textView_more_info":
				textView.setText(R.string.textView_more_info);
				break;
			case "button_more_info":
				textView.setText(R.string.button_more_info);
				break;

			default:
				textView.setText("@TODO: Add more info");
				break;

		}
	}
}