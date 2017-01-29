package com.example.sean.onedroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MoreInfo extends Fragment {
	public static String values = "";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.activity_more_info, container, false);
	}

	/**
	 * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
	 * has returned, but before any saved state has been restored in to the view.
	 * This gives subclasses a chance to initialize themselves once
	 * they know their view hierarchy has been completely created.  The fragment's
	 * view hierarchy is not however attached to its parent at this point.
	 *
	 * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
	 * @param savedInstanceState If non-null, this fragment is being re-constructed
	 */

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		//Create a text view to add more information about each component, with a switch case to determine what information gets displayed where.
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
		super.onViewCreated(view, savedInstanceState);
	}
}