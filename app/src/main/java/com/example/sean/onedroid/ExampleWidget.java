package com.example.sean.onedroid;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.*;

import java.io.File;
import java.util.Calendar;

public class ExampleWidget extends Fragment {

	public static String widget;


	/**
	 * Called once the the fragment has been called
	 *
	 * @param inflater
	 * @param container
	 * @param savedInstanceState
	 * @return
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_example_widget, container, false);
		return view;
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
	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		//this linear layout will act as the parent layout for all the components implemented below.
		LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.activity_example_widget);
//       The switch statement determines what component has been clicked, and acts accordingly. The views are added programmatically to allow for dynamic creation of views. The other option would be to create a layout file for each component which is a lot of work. The cases in this switch contain similar code. We determine what string values to set for the more information and common methods tab for the component, then we create the component, finally add it to the linear layout above
		switch (widget) {
			case "TextView":
				MoreInfo.values = "textView_more_info";
				TextView textView = new TextView(getActivity());
				textView.setText("Example Text View");
				linearLayout.addView(textView);
				break;
			case "Button":
				MoreInfo.values = "button_more_info";
				Button button = new Button(getActivity());
				button.setText("Example Button");
				linearLayout.addView(button);
				break;
			case "ToggleButton":
				MoreInfo.values = "toggle_button_more_info";
				ToggleButton toggleButton = new ToggleButton(getActivity());
				toggleButton.setText("Toggle this");
				linearLayout.addView(toggleButton);
				break;
			case "CheckBox":
				MoreInfo.values = "check_box_more_info";
				CheckBox checkBox = new CheckBox(getActivity());
				checkBox.setText("Example Check Box");
				linearLayout.addView(checkBox);
				break;
			case "RadioButton":
				MoreInfo.values = "radio_button_more_info";
				RadioButton radioButton = new RadioButton(getActivity());
				radioButton.setText("Example Radio Button");
				linearLayout.addView(radioButton);
				break;
			case "CheckedTextView":
				MoreInfo.values = "checked_text_view";
				CheckedTextView checkedTextView = new CheckedTextView(getActivity());
				checkedTextView.setText("Example CheckedTextView");
				linearLayout.addView(checkedTextView);
				break;
			case "Spinner":
				MoreInfo.values = "spinner_more_info";
				Spinner spinner = new Spinner(getActivity());
				linearLayout.addView(spinner);
				break;
			case "ProgressBar":
				MoreInfo.values = "progress_bar_more_info";
				ProgressBar progressBar = new ProgressBar(getActivity(), null, android.R.attr.progressBarStyleLarge);
				progressBar.setIndeterminate(true);
				progressBar.setVisibility(View.VISIBLE);
				linearLayout.removeView(progressBar);
				TextView progressText = new TextView(getActivity());
				progressText.setText("Example ProgressBar");
				linearLayout.addView(progressBar);
				linearLayout.addView(progressText);
				break;
			case "SeekBar":
				MoreInfo.values = "seekbar_more_info";
				SeekBar seekBar = new SeekBar(getActivity());
				linearLayout.addView(seekBar);
				break;
			case "QuickContactBadge":
				MoreInfo.values = "quick_contact_badge_more_info";
				TextView quickContactBadgeText = new TextView(getActivity());
				quickContactBadgeText.setText("Will be implemented whenever");
				linearLayout.addView(quickContactBadgeText);
				break;
			case "RatingBar":
				MoreInfo.values = "rating_bar_more_info";
				RatingBar ratingBar = new RatingBar(getActivity());
				linearLayout.addView(ratingBar);
				break;
			case "Switch":
				MoreInfo.values = "switch_more_info";
				Switch swich = new Switch(getActivity());
				swich.setText("Example Switch");
				linearLayout.addView(swich);
				break;
			case "Space":
				MoreInfo.values = "space_more_info";
				TextView spaceText = new TextView(getActivity());
				spaceText.setText("Example Space");
				linearLayout.addView(spaceText);
				Space space = new Space(getActivity());
				linearLayout.addView(space);
				linearLayout.addView(spaceText);
				break;
			case "Plain Text":
				MoreInfo.values = "plain_text_more_info";
				EditText editText = new EditText(getActivity());
				editText.setInputType(InputType.TYPE_CLASS_TEXT);
				editText.setHint("Enter name");
				linearLayout.addView(editText);
				break;
			case "Password":
				MoreInfo.values = "password_more_info";
				EditText passwordText = new EditText(getActivity());
				passwordText.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                passwordText.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD);
				passwordText.setHint("Enter password");
				linearLayout.addView(passwordText);
				break;
			case "Email":
				MoreInfo.values = "email_more_info";
				EditText emailText = new EditText(getActivity());
				emailText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
				emailText.setHint("Enter email");
				linearLayout.addView(emailText);
				break;
			case "Phone":
				MoreInfo.values = "phone_more_info";
				EditText phone = new EditText(getActivity());
				phone.setInputType(InputType.TYPE_CLASS_PHONE);
				phone.setHint("Enter Phone");
				linearLayout.addView(phone);
				break;
			case "Postal Address":
				MoreInfo.values = "postal_address_more_info";
				EditText postalAddress = new EditText(getActivity());
				postalAddress.setInputType(InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
				postalAddress.setHint("Enter Postal Address");
				linearLayout.addView(postalAddress);
				break;
			case "Multiline Text":
				MoreInfo.values = "multiline_text_more_info";
				MultiAutoCompleteTextView multilineText = new MultiAutoCompleteTextView(getActivity());
//                multilineText.setTransformationMethod(MultiAutoCompleteTextView.ge);
				multilineText.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
//                multilineText.setTransformationMethod(MultiAutoCompleteTextView.);
				multilineText.setHint("Enter multiline text");
				linearLayout.addView(multilineText);
				break;
			case "Time":
				MoreInfo.values = "time_more_info";
				EditText time = new EditText(getActivity());
				time.setInputType(InputType.TYPE_DATETIME_VARIATION_TIME);
				time.setHint("Enter time");
				linearLayout.addView(time);

				break;
			case "Date":
				MoreInfo.values = "date_more_info";
				EditText date = new EditText(getActivity());
				date.setInputType(InputType.TYPE_DATETIME_VARIATION_DATE);
				date.setHint("Enter date");
				linearLayout.addView(date);
				break;
			case "Number":
				EditText number = new EditText(getActivity());
				number.setInputType(InputType.TYPE_CLASS_NUMBER);
				number.setHint("Enter Number");
				linearLayout.addView(number);
				break;
			case "AutoCompleteTextView":
				MoreInfo.values = "auto_complete_text_view_more_info";
				EditText autoCompleteTextView = new EditText(getActivity());
				autoCompleteTextView.setInputType(InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE);
				autoCompleteTextView.setHint("Enter Text");
				linearLayout.addView(autoCompleteTextView);
				break;
			case "MultilineAutoCompleteTextView":
				MoreInfo.values = "multiline_auto_complete_text_view_more_info";
				EditText multilineAutoCompleteTextView = new EditText(getActivity());
				multilineAutoCompleteTextView.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
				multilineAutoCompleteTextView.setHint("Enter Text");
				linearLayout.addView(multilineAutoCompleteTextView);
				break;
			case "ConstraintLayout":
				MoreInfo.values = "constraint_layout_more_info";
				break;
			case "GridLayout":
				MoreInfo.values = "grid_layout_more_info";
				GridLayout layout = new GridLayout(getActivity());
				int total = 12;
				int columns = 3;
				int rows = total / columns;
				layout.setRowCount(rows);
				layout.setColumnCount(columns);
				int c = 0;
				for (int i = 0, r = 0; i < total; i++) {
					if (c == columns) {
						c = 0;
						r++;
					}
					ImageView oImageView = new ImageView(layout.getContext());
					oImageView.setImageResource(R.drawable.ic_launcher);
					GridLayout.LayoutParams param = new GridLayout.LayoutParams();
					param.height = GridLayout.LayoutParams.WRAP_CONTENT;
					param.width = GridLayout.LayoutParams.WRAP_CONTENT;
					param.rightMargin = 5;
					param.topMargin = 5;
					param.setGravity(Gravity.CENTER);
					param.columnSpec = GridLayout.spec(c);
					param.rowSpec = GridLayout.spec(r);
					oImageView.setLayoutParams(param);
					layout.addView(oImageView);
					c++;
				}
				linearLayout.addView(layout);

				break;
			case "FrameLayout":
				MoreInfo.values = "framelayout_more_info";
				FrameLayout fl = new FrameLayout(getActivity());
				// Create Layout Parameters for FrameLayout
				FrameLayout.LayoutParams lpa = new FrameLayout.LayoutParams(
						FrameLayout.LayoutParams.MATCH_PARENT,
						FrameLayout.LayoutParams.MATCH_PARENT);
				// Apply the Layout Parameters for FrameLayout
				fl.setLayoutParams(lpa);
				// Apply 16 pixels padding each site of frame layout
				fl.setPadding(16, 16, 16, 16);

				// Assign a background color for frame layout
				fl.setBackgroundColor(Color.parseColor("#FFFDDB"));

				// Initialize a new ImageView to display monkey
				ImageView iv_monkey = new ImageView(fl.getContext());
				// Create LayoutParams for the monkey ImageView
				FrameLayout.LayoutParams lp_monkey = new FrameLayout.LayoutParams(
						200, // Width in pixel
						200, // Height in pixel
						Gravity.START | Gravity.TOP); // Layout Gravity (left top)
				// Apply the LayoutParams to monkey ImageView
				iv_monkey.setLayoutParams(lp_monkey);
				//  Set an image resource for ImageView
				iv_monkey.setImageResource(R.drawable.ic_launcher);

				// Initialize a new ImageView to display giraffe
				ImageView iv_giraffe = new ImageView(fl.getContext());
				// Create LayoutParams for the giraffe ImageView
				FrameLayout.LayoutParams lp_giraffe = new FrameLayout.LayoutParams(
						FrameLayout.LayoutParams.WRAP_CONTENT, // Width
						FrameLayout.LayoutParams.WRAP_CONTENT, // Height
						Gravity.CENTER); // Layout Gravity exact center
				// Apply the LayoutParams to giraffe ImageView
				iv_giraffe.setLayoutParams(lp_giraffe);
				//  Set an image resource for ImageView
				iv_giraffe.setImageResource(R.drawable.ic_launcher);

				// Initialize a new ImageView to display camel
				ImageView iv_camel = new ImageView(fl.getContext());
				// Create LayoutParams for the camel ImageView
				FrameLayout.LayoutParams lp_camel = new FrameLayout.LayoutParams(
						200, // Width in pixel
						200); // Height in pixel
				// Apply the LayoutParams to camel ImageView
				iv_camel.setLayoutParams(lp_camel);
				//  Set an image resource for ImageView
				iv_camel.setImageResource(R.drawable.ic_launcher);

				// Another way to assign layout gravity to a view
				FrameLayout.LayoutParams lp_iv_camel = (FrameLayout.LayoutParams) iv_camel.getLayoutParams();
				lp_iv_camel.gravity = Gravity.BOTTOM | Gravity.END;
				iv_camel.setLayoutParams(lp_iv_camel);

				//  Add those programmatically created ImageView to FrameLayout
				fl.addView(iv_monkey);
				fl.addView(iv_giraffe);
				fl.addView(iv_camel);

				linearLayout.addView(fl);
				break;
			case "LinearLayout":
				MoreInfo.values = "linear_layout_more_info";
				Button button1 = new Button(getActivity());
				TextView textView0 = new TextView(button1.getContext());
				button1.setText("Linear Button");
				textView0.setText("Linear Text View");
				linearLayout.addView(button1);
				linearLayout.addView(textView0);
				break;
			case "RelativeLayout":
				MoreInfo.values = "relative_layout_more_info";
				RelativeLayout relativeLayout = new RelativeLayout(getActivity());
				RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.MATCH_PARENT,
						RelativeLayout.LayoutParams.MATCH_PARENT);
				RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.WRAP_CONTENT,
						RelativeLayout.LayoutParams.WRAP_CONTENT);
				lp.addRule(RelativeLayout.CENTER_IN_PARENT);

				Button relativeBtn = new Button(relativeLayout.getContext());
				relativeBtn.setText("Example Button");
				relativeBtn.setLayoutParams(lp);
				relativeLayout.setLayoutParams(rlp);
				TextView textView1 = new TextView(relativeLayout.getContext());
				textView1.setText("Relative Text View");
				textView1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
				relativeLayout.addView(textView1);
				relativeLayout.addView(relativeBtn);
				linearLayout.addView(relativeLayout);
				break;
			case "TableLayout":
				MoreInfo.values = "table_layout_more_info";
				TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
				TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

				TableLayout tableLayout = new TableLayout(getActivity());
				tableLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));// assuming the parent view is a LinearLayout

				TableRow tableRow = new TableRow(tableLayout.getContext());
				tableRow.setLayoutParams(tableParams);// TableLayout is the parent view
				TableRow tableRow1 = new TableRow(tableLayout.getContext());
				tableRow.setLayoutParams(tableParams);// TableLayout is the parent view
				TableRow tableRow2 = new TableRow(tableLayout.getContext());
				tableRow.setLayoutParams(tableParams);// TableLayout is the parent view

				TextView tableText = new TextView(tableLayout.getContext());
				tableText.setText("Table Text");
				tableText.setLayoutParams(rowParams);// TableRow is the parent view
				TextView tableText1 = new TextView(tableLayout.getContext());
				tableText1.setText("Table Text 1");
				tableText1.setLayoutParams(rowParams);// TableRow is the parent view
				TextView tableText2 = new TextView(tableLayout.getContext());
				tableText2.setText("Table Text 2");
				tableText2.setLayoutParams(rowParams);// TableRow is the parent view

				tableLayout.addView(tableRow);
				tableLayout.addView(tableRow1);
				tableLayout.addView(tableRow2);
				tableRow.addView(tableText);
				tableRow1.addView(tableText1);
				tableRow2.addView(tableText2);
				linearLayout.addView(tableLayout);
				break;
			case "TableRow":
				MoreInfo.values = "table_row_more_info";
				TableRow.LayoutParams rowp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
				TableRow row = new TableRow(getActivity());
				row.setLayoutParams(rowp);// TableLayout is the
				TextView rowText = new TextView(row.getContext());
				rowText.setText("row Text");
				row.addView(rowText);
				linearLayout.addView(row);
				break;
			case "<fragment>":
				MoreInfo.values = "fragment_more_info";
				TextView fragmentText = new TextView(getActivity());
				fragmentText.setText("This is an example fragment, Swiping left will take you to another example fragment");
				linearLayout.addView(fragmentText);
				break;

			case "RadioGroup":
				MoreInfo.values = "radio_group_more_info";
				RadioGroup rg = new RadioGroup(getActivity()); //create the RadioGroup
				RadioButton radioButton1 = new RadioButton(rg.getContext());
				RadioButton radioButton2 = new RadioButton(rg.getContext());
				RadioButton radioButton3 = new RadioButton(rg.getContext());
				radioButton1.setId(1);
				radioButton1.setText("Male");
				radioButton2.setText("Female");
				radioButton2.setId(2);
				radioButton3.setId(3);
				radioButton3.setText("Other");
				rg.setOrientation(RadioGroup.HORIZONTAL);//or RadioGroup.VERTICAL
				rg.addView(radioButton1);
				rg.addView(radioButton2);
				rg.addView(radioButton3);
				linearLayout.addView(rg);
				break;
			case "ListView":
				MoreInfo.values = "list_view_more_info";
				ListView listview = new ListView(getActivity());
				RadioGroup radioGroup = new RadioGroup(listview.getContext());

				LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT
				);
				//layout.addView(radioGroup, p);

				RadioButton radioButtonView = new RadioButton(listview.getContext());
				radioButtonView.setText("RadioButton");
				radioGroup.addView(radioButtonView);

				RadioButton radioButtonView2 = new RadioButton(listview.getContext());
				radioButtonView2.setText("RadioButton2");
				radioGroup.addView(radioButtonView2);
				linearLayout.addView(listview);
				listview.addView(radioGroup, p);
				break;
			case "GridView":
				MoreInfo.values = "grid_view_more_info";
				String[] items = {"lorem", "ipsum", "dolor",
						"sit", "amet",
						"consectetuer", "adipiscing", "elit", "morbi", "vel",
						"ligula", "vitae", "arcu", "aliquet", "mollis",
						"etiam", "vel", "erat", "placerat", "ante",
						"porttitor", "sodales", "pellentesque", "augue", "purus"};
				GridView gridView = new GridView(getActivity());
//				gridView.setId(ViewIdentification.getId());
				gridView.setLayoutParams(new GridView.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.MATCH_PARENT));
				gridView.setBackgroundColor(Color.WHITE);
				gridView.setNumColumns(GridView.AUTO_FIT);
				gridView.setColumnWidth(GridView.AUTO_FIT);
				gridView.setVerticalSpacing(40);
				gridView.setHorizontalSpacing(5);
				gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
//				gridView.setGravity(GridView.TEXT_ALIGNMENT_CENTER);
//				TextView gridText=new TextView(gridView.getContext());
				gridView.setAdapter(new ArrayAdapter<>(gridView.getContext(), R.layout.gridcell, items));
				linearLayout.addView(gridView);
				break;

			case "ExpandableListView":
				MoreInfo.values = "expandable_list_view_more_info";
				TextView expandableText = new TextView(getActivity());
				expandableText.setText("The Launcher Activity is an Expandable list view. Please press the back button for illustration.");
				linearLayout.addView(expandableText);
				break;

			case "ScrollView":
				MoreInfo.values = "scroll_view_more_info";
				ScrollView scrollView = new ScrollView(getActivity());
				scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

				TextView scrollText = new TextView(scrollView.getContext());
				scrollText.setText(R.string.title_activity_lorem);
				scrollView.addView(scrollText);
				linearLayout.addView(scrollView);
				break;

			case "HorizontalScrollView":
				MoreInfo.values = "horizontal_scroll_view";
				HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getActivity());
				TextView horizontalText = new TextView(horizontalScrollView.getContext());
				horizontalText.setText("This is an example of random text to demonstrate a horizontal text view");
				horizontalText.setTextSize(25);
				horizontalScrollView.addView(horizontalText);
				linearLayout.addView(horizontalScrollView);

				break;
			case "TabHost":
				//The tabHost is returning null...i wonder why :(
/*				View rootView = LayoutInflater.inflate(R.layout.tabhost, null, false);
				final TabHost tabHost=(TabHost)getActivity().findViewById(R.id.tabHost);
				tabHost.setup();
				tabHost.addTab(tabHost.newTabSpec("tab1")
						.setIndicator("Monthly")
						.setContent(new TabHost.TabContentFactory() {
							@Override
							public View createTabContent(String tag) {
									TextView tabtext=new TextView(tabHost.getContext());
								if (tag.equals("tab1")) {
									tabtext.setText("Tab 1");
									return tabtext;
								}
								tabtext.setText("No tab selected");
								return tabtext;
								}
							}));
				tabHost.addTab(tabHost.newTabSpec("tab2")
						.setIndicator("Daily")
						.setContent(new TabHost.TabContentFactory() {
							@Override
							public View createTabContent(String tag) {
									TextView tabtext=new TextView(tabHost.getContext());
								if (tag.equals("tab2")) {
									tabtext.setText("Tab 2");
									return tabtext;
								}
								tabtext.setText("No tab selected");
								return tabtext;
								}
							}));
				linearLayout.addView(tabHost);*/
				break;

			case "WebView":
				MoreInfo.values = "web_view_more_info";
				//Give it some time to load...A progress bar should be added.
				WebView webView = new WebView(getActivity());
				webView.loadUrl("https://developer.android.com/guide/webapps/webview.html");
				linearLayout.addView(webView);
				break;

			case "SearchView":
				MoreInfo.values = "search_view_more_info";
				/**
				 * This will be implemented as part of this app's functionality. Expect to find the code for the search view commented out.
				 */

				break;
			case "ImageButton":
				MoreInfo.values = "image_button_more_info";
				final TextView imageText = new TextView(getActivity());
				imageText.setText("Click on the image button");
				ImageButton imageButton = new ImageButton(getActivity());
				imageButton.setImageResource(R.drawable.imagebutton);
				imageButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						imageText.setText("You clicked on the image");
					}
				});
				imageButton.setBackgroundColor(Color.TRANSPARENT);
//				imageButton.setMaxWidth(10);
//				imageButton.setMaxHeight(15);
				linearLayout.addView(imageButton);
				linearLayout.addView(imageText);
				break;

			case "ImageView":
				MoreInfo.values = "image_view_more_info";
				ImageButton imageButton1 = new ImageButton(getActivity());
				imageButton1.setImageResource(R.drawable.nougat_bg);
				linearLayout.addView(imageButton1);
				break;

			case "VideoView":
				MoreInfo.values = "video_view_more_info";
				VideoView videoView = new VideoView(getActivity());
				MediaController mediaController;
				//Make sure in your internal memory storage, you have a video file in the root folder. In my case its called Becky.mp4. Replace it with the name of your video.
				File clip = new File(Environment.getExternalStorageDirectory(),
						"Becky.mp4");

				if (clip.exists()) {
					videoView.setVideoPath(clip.getAbsolutePath());
//					videoView.setVideoPath("src/main/res/video/video.3gp");
					mediaController = new MediaController(videoView.getContext());
					mediaController.setMediaPlayer(videoView);
					videoView.setMediaController(mediaController);
					videoView.requestFocus();
					videoView.start();
					linearLayout.addView(videoView);
				}

				break;
			case "TimePicker":
				MoreInfo.values = "timepicker_more_info";
				final Button btn = new Button(getActivity());
				btn.setText("Set time");
				btn.setOnClickListener(new View.OnClickListener() {

					@RequiresApi(api = Build.VERSION_CODES.N)
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Calendar mcurrentTime = Calendar.getInstance();
						int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
						int minute = mcurrentTime.get(Calendar.MINUTE);
						TimePickerDialog mTimePicker;
						mTimePicker = new TimePickerDialog(btn.getContext(), new TimePickerDialog.OnTimeSetListener() {
							@Override
							public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
								btn.setText(selectedHour + ":" + selectedMinute);
							}
						}, hour, minute, true);//Yes 24 hour time
						mTimePicker.setTitle("Select Time");
						mTimePicker.show();

					}
				});
				linearLayout.addView(btn);
				break;
			case "DatePicker":
				MoreInfo.values = "date_picker_more_info";
				final Button dateBtn = new Button(getActivity());
				dateBtn.setText("Set Date");
				dateBtn.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//To show current date in the datepicker
						Calendar mcurrentDate = Calendar.getInstance();
						int mYear = mcurrentDate.get(Calendar.YEAR);
						int mMonth = mcurrentDate.get(Calendar.MONTH);
						int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

						DatePickerDialog mDatePicker;
						mDatePicker = new DatePickerDialog(dateBtn.getContext(), new DatePickerDialog.OnDateSetListener() {
							public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
								// TODO Auto-generated method stub
					/*      Your code   to get date and time    */
								selectedmonth = selectedmonth + 1;
								dateBtn.setText("" + selectedday + "/" + selectedmonth + "/" + selectedyear);
							}
						}, mYear, mMonth, mDay);
						mDatePicker.setTitle("Select Date");
						mDatePicker.show();
					}
				});
				linearLayout.addView(dateBtn);
				break;
			case "CalendarView":
				MoreInfo.values = "calendar_view_more_info";
				final CalendarView calendarView = new CalendarView(getActivity());


				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
						(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


				calendarView.setLayoutParams(params);
				linearLayout.addView(calendarView);
				calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

					@Override
					public void onSelectedDayChange(CalendarView view, int year, int month,
													int dayOfMonth) {
						// TODO Auto-generated method stub

						Toast.makeText(calendarView.getContext(), "Selected Date is\n\n"
										+ dayOfMonth + " : " + month + " : " + year,
								Toast.LENGTH_LONG).show();
					}
				});

				break;
			case "Chronometer":
				MoreInfo.values = "chronometer_more_info";
				LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				final Chronometer simpleChronometer = new Chronometer(getActivity());
				simpleChronometer.setLayoutParams(layoutParams);
				Button start = new Button(simpleChronometer.getContext());
				start.setText("Start");
				start.setLayoutParams(layoutParams);
				start.setWidth(200);
				Button stop = new Button(simpleChronometer.getContext());
				stop.setText("Stop");
				stop.setLayoutParams(layoutParams);
				stop.setWidth(200);

				Button restart = new Button(simpleChronometer.getContext());
				restart.setText("Restart");
				restart.setLayoutParams(layoutParams);
				restart.setWidth(200);
				// perform click  event on start button to start a chronometer
				start.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

						simpleChronometer.start();
					}
				});

				// perform click  event on stop button to stop the chronometer
				stop.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

						simpleChronometer.stop();
					}
				});

				// perform click  event on restart button to set the base time on chronometer
				restart.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

						simpleChronometer.setBase(SystemClock.elapsedRealtime());
					}
				});

				linearLayout.addView(start);
				linearLayout.addView(stop);
				linearLayout.addView(restart);
				linearLayout.addView(simpleChronometer);
				break;
			case "TextClock":
				MoreInfo.values = "text_clock_more_info";
				final DigitalClock simpleDigitalClock = new DigitalClock(getActivity());
				final AnalogClock simpleAnalogClock = new AnalogClock(simpleDigitalClock.getContext());
				TextView digitalText = new TextView(simpleDigitalClock.getContext());
				digitalText.setText("Digital Clock");
				TextView analogueText = new TextView(simpleDigitalClock.getContext());
				analogueText.setText("Anologue Clock");
				// perform click event on analog clock
				simpleAnalogClock.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Toast.makeText(simpleDigitalClock.getContext(), "Analog Clock", Toast.LENGTH_SHORT).show(); // display a toast for analog clock
					}
				});
				// perform click event on digital clock
				simpleDigitalClock.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Toast.makeText(simpleDigitalClock.getContext(), "Digital Clock", Toast.LENGTH_SHORT).show(); //display a toast for digital clock
					}
				});
				linearLayout.addView(analogueText);
				linearLayout.addView(simpleAnalogClock);
				linearLayout.addView(digitalText);
				linearLayout.addView(simpleDigitalClock);
				break;
			case "ImageSwitcher":
				MoreInfo.values = "image_switcher_more_info";
				// Array of Image IDs to Show In ImageSwitcher
				final int imageIds[] = {R.drawable.image1, R.drawable.nougat_bg, R.drawable.imagebutton, R.drawable.android7, R.drawable.design, R.drawable.devices};
				final int count = imageIds.length;
				// to keep current Index of ImageID array

				final Button btnNext = new Button(getContext());
				btnNext.setText("Next");
				final ImageSwitcher simpleImageSwitcher = new ImageSwitcher(btnNext.getContext());
				// Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
				simpleImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

					public View makeView() {
						// TODO Auto-generated method stub

						// Create a new ImageView and set it's properties
						ImageView imageView = new ImageView(btnNext.getContext());
						// set Scale type of ImageView to Fit Center
						imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
						// set the Height And Width of ImageView To MATCH_PARENT
						imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
						return imageView;
					}
				});

				// Declare in and out animations and load them using AnimationUtils class
				Animation in = AnimationUtils.loadAnimation(btnNext.getContext(), android.R.anim.slide_in_left);
				Animation out = AnimationUtils.loadAnimation(btnNext.getContext(), android.R.anim.slide_out_right);

				// set the animation type to ImageSwitcher
				simpleImageSwitcher.setInAnimation(in);
				simpleImageSwitcher.setOutAnimation(out);


				// ClickListener for NEXT button
				// When clicked on Button ImageSwitcher will switch between Images
				// The current Image will go OUT and next Image  will come in with specified animation
				btnNext.setOnClickListener(new View.OnClickListener() {

					public void onClick(View v) {
						//current index should be declare outside the event listener as final. But making it final will not allow for changes made during the switching. So this piece of code may not behave as expected. Only one image is being displayed.
						int currentIndex = -1;
						// TODO Auto-generated method stub
						currentIndex++;
						//  Check If index reaches maximum then reset it
						if (currentIndex == count)
							currentIndex = 0;
						simpleImageSwitcher.setImageResource(imageIds[currentIndex]); // set the image in ImageSwitcher
					}
				});
				linearLayout.addView(simpleImageSwitcher);
				linearLayout.addView(btnNext);
				break;
			case "AdapterViewFlipper":
				MoreInfo.values = "adapter_view_flipper_more_info";
				break;
			case "StackView":
				MoreInfo.values = "stackview_more_info";
				break;
			case "TextSwitcher":
				MoreInfo.values = "text_switcher_more_info";
				break;
			case "ViewAnimator":
				MoreInfo.values = "view_animator_more_info";
				break;
			case "ViewFlipper":
				MoreInfo.values = "view_flipper_more_info";
				break;
			case "ViewSwitcher":
				MoreInfo.values = "view_switcher_more_info";
				break;
			case "<include>":
				MoreInfo.values = "include_more_info";
				break;
			case "<requestFocus>":
				MoreInfo.values = "request_focus_more_info";
				break;
			case "<view>":
				MoreInfo.values = "view_more_info";
				break;
			case "ViewStub":
				MoreInfo.values = "view_stub_more_info";
				break;
			case "TextureView":
				MoreInfo.values = "texture_view_more_info";
				break;
			case "NumberPicker":
				MoreInfo.values = "number_picker_more_info";
				break;
			case "AdView":
				MoreInfo.values = "adview_more_info";
				break;
			case "MapFragment":
				MoreInfo.values = "map_fragment_more_info";
				break;
			case "MapView":
				MoreInfo.values = "map_view_more_info";
				break;
			case "CoordinatorLayout":
				MoreInfo.values = "coordinator_layout_more_info";
				break;
			case "AppBarLayout":
				MoreInfo.values = "appbar_layout_more_info";
				break;
			case "TabLayout":
				MoreInfo.values = "tab_layout_more_info";
				break;
			case "TabItem":
				MoreInfo.values = "tab_item_more_info";
				break;
			case "NestedScrollView":
				MoreInfo.values = "nested_scroll_view";
				break;
			case "FloatingActionButton":
				MoreInfo.values = "floating_action_button_more_info";
				break;
			case "TextInputLayout":
				MoreInfo.values = "text_input_layout_more_info";
				break;
			case "CardView":
				MoreInfo.values = "cardview_more_info";
				break;
			case "Grid_Layout":
				MoreInfo.values = "custom_grid_layout_more_info";
				break;
			case "RecyclerView":
				MoreInfo.values = "recycler_view_more_info";
				break;
			case "ToolBar":
				MoreInfo.values = "tool_bar_more_info";
				break;


			default:
				TextView defolt = new TextView(getActivity());
				defolt.setText("There is no Widget here.");
				linearLayout.addView(defolt);
				break;

		}
	}
}