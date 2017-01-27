package com.example.sean.onedroid;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.*;

import java.io.File;

public class ExampleWidget extends Fragment {
	//    static Context context;
	public static String widget;
	private View view;

	private String getWidget() {
		return widget;
	}

//	public void setWidget(String widget) {
//		ExampleWidget.widget = widget;
//	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
//        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.activity_example_widget, container, false);

//        createWidget(getWidget(), linearLayout);
		view = inflater.inflate(R.layout.activity_example_widget, container, false);
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
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.activity_example_widget);
//        linearLayout.removeAllViews();
		switch (getWidget()) {
			case "TextView":
				TextView textView = new TextView(getActivity());
				textView.setText("Example Text View");

				linearLayout.addView(textView);
				break;
			case "Button":
				Button button = new Button(getActivity());
				button.setText("Example Button");
				linearLayout.addView(button);
				break;
			case "ToggleButton":
				ToggleButton toggleButton = new ToggleButton(getActivity());
				toggleButton.setText("Toggle this");
				linearLayout.addView(toggleButton);
				break;
			case "CheckBox":
				CheckBox checkBox = new CheckBox(getActivity());
				checkBox.setText("Example Check Box");
				linearLayout.addView(checkBox);
				break;
			case "RadioButton":
				RadioButton radioButton = new RadioButton(getActivity());
				radioButton.setText("Example Radio Button");
				linearLayout.addView(radioButton);
				break;
			case "CheckedTextView":
				CheckedTextView checkedTextView = new CheckedTextView(getActivity());
				checkedTextView.setText("Example CheckedTextView");
				linearLayout.addView(checkedTextView);
				break;
			case "Spinner":
				Spinner spinner = new Spinner(getActivity());
				linearLayout.addView(spinner);
				break;
			case "ProgressBar":
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
				SeekBar seekBar = new SeekBar(getActivity());
				linearLayout.addView(seekBar);
				break;
			case "QuickContactBadge":
				TextView quickContactBadgeText = new TextView(getActivity());
				quickContactBadgeText.setText("Will be implemented whenever");
				linearLayout.addView(quickContactBadgeText);
				break;
			case "RatingBar":
				RatingBar ratingBar = new RatingBar(getActivity());
				linearLayout.addView(ratingBar);
				break;
			case "Switch":
				Switch swich = new Switch(getActivity());
				swich.setText("Example Switch");
				linearLayout.addView(swich);
				break;
			case "Space":
				TextView spaceText = new TextView(getActivity());
				spaceText.setText("Example Space");
				linearLayout.addView(spaceText);
				Space space = new Space(getActivity());
				linearLayout.addView(space);
				linearLayout.addView(spaceText);
				break;
			case "Plain Text":
				EditText editText = new EditText(getActivity());
				editText.setInputType(InputType.TYPE_CLASS_TEXT);
				editText.setHint("Enter name");
				linearLayout.addView(editText);
				break;
			case "Password":
				EditText passwordText = new EditText(getActivity());
				passwordText.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                passwordText.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD);
				passwordText.setHint("Enter password");
				linearLayout.addView(passwordText);
				break;
			case "Email":
				EditText emailText = new EditText(getActivity());
				emailText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
				emailText.setHint("Enter email");
				linearLayout.addView(emailText);
				break;
			case "Phone":
				EditText phone = new EditText(getActivity());
				phone.setInputType(InputType.TYPE_CLASS_PHONE);
				phone.setHint("Enter Phone");
				linearLayout.addView(phone);
				break;
			case "Postal Address":
				EditText postalAddress = new EditText(getActivity());
				postalAddress.setInputType(InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
				postalAddress.setHint("Enter Postal Address");
				linearLayout.addView(postalAddress);
				break;
			case "Multiline Text":
				MultiAutoCompleteTextView multilineText = new MultiAutoCompleteTextView(getActivity());
//                multilineText.setTransformationMethod(MultiAutoCompleteTextView.ge);
				multilineText.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
//                multilineText.setTransformationMethod(MultiAutoCompleteTextView.);
				multilineText.setHint("Enter multiline text");
				linearLayout.addView(multilineText);
				break;
			case "Time":
				EditText time = new EditText(getActivity());
				time.setInputType(InputType.TYPE_DATETIME_VARIATION_TIME);
				time.setHint("Enter time");
				linearLayout.addView(time);

				break;
			case "Date":
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
				EditText autoCompleteTextView = new EditText(getActivity());
				autoCompleteTextView.setInputType(InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE);
				autoCompleteTextView.setHint("Enter Text");
				linearLayout.addView(autoCompleteTextView);
				break;
			case "MultilineAutoCompleteTextView":
				EditText multilineAutoCompleteTextView = new EditText(getActivity());
				multilineAutoCompleteTextView.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
				multilineAutoCompleteTextView.setHint("Enter Text");
				linearLayout.addView(multilineAutoCompleteTextView);
				break;
			case "ConstraintLayout":
				break;
			case "GridLayout":
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
				Button button1 = new Button(getActivity());
				TextView textView0 = new TextView(button1.getContext());
				button1.setText("Linear Button");
				textView0.setText("Linear Text View");
				linearLayout.addView(button1);
				linearLayout.addView(textView0);
				break;
			case "RelativeLayout":
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
				TableRow.LayoutParams rowp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
				TableRow row = new TableRow(getActivity());
				row.setLayoutParams(rowp);// TableLayout is the
				TextView rowText = new TextView(row.getContext());
				rowText.setText("row Text");
				row.addView(rowText);
				linearLayout.addView(row);
				break;
			case "<fragment>":
				TextView fragmentText = new TextView(getActivity());
				fragmentText.setText("This is an example fragment, Swiping left will take you to another example fragment");
				linearLayout.addView(fragmentText);
				break;

			case "RadioGroup":
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
				TextView expandableText = new TextView(getActivity());
				expandableText.setText("The Launcher Activity is an Expandable list view. Please press the back button for illustration.");
				linearLayout.addView(expandableText);
				break;

			case "ScrollView":
				ScrollView scrollView = new ScrollView(getActivity());
				scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

				TextView scrollText = new TextView(scrollView.getContext());
				scrollText.setText(R.string.title_activity_lorem);
				scrollView.addView(scrollText);
				linearLayout.addView(scrollView);
				break;

			case "HorizontalScrollView":
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
				//Give it some time to load...A progress bar should be added.
				WebView webView = new WebView(getActivity());
				webView.loadUrl("https://developer.android.com/guide/webapps/webview.html");
				linearLayout.addView(webView);
				break;

			case "SearchView":
				/**
				 * This will be implemented as part of this app's functionality. Expect to find the code for the search view commented out.
				 */

				break;
			case "ImageButton":
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
				ImageButton imageButton1 = new ImageButton(getActivity());
				imageButton1.setImageResource(R.drawable.nougat_bg);
				linearLayout.addView(imageButton1);
				break;

			case "VideoView":
				VideoView videoView = new VideoView(getActivity());
				MediaController mediaController;
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
				break;
			case "DatePicker":
				break;
			case "CalenderView":
				break;
			case "Chronometer":
				break;
			case "TextClock":
				break;


			default:
				TextView defolt = new TextView(getActivity());
				defolt.setText("There is no Widget here.");
				linearLayout.addView(defolt);
				break;

		}
	}
}