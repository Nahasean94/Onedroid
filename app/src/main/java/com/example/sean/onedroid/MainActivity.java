package com.example.sean.onedroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
	private List<String> categories;
	private Map<String, List<String>> items;

//    ExampleWidget exampleWidget = new ExampleWidget();

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
		fillData();
		ExpandableListAdapter expandableListAdapter = new MyExpListAdapter(this, categories, items);
		expandableListView.setAdapter(expandableListAdapter);
		expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				String widgetName = new MyExpListAdapter().returnChild(groupPosition, childPosition);

				System.out.println("We have obtained this shit " + widgetName);
				ExampleWidget.widget = widgetName;
				launchActivity();
				return false;
			}
		});


	}

	private void launchActivity() {
//                exampleWidget.setContext(this);
		Intent i = new Intent(this, TabbedActivity.class);
		startActivity(i);
	}

	private void fillData() {
		categories = new ArrayList<>();
		items = new HashMap<>();

		categories.add("Widgtes");
		categories.add("Text Fields");
		categories.add("Layouts");
		categories.add("Containers");
		categories.add("Images and Media");
		categories.add("Date and Time");
		categories.add("Transitions");
		categories.add("Advanced");
		categories.add("Custom-Google");
		categories.add("Custom-Design");
		categories.add("Custom-AppCompat");

		List<String> widgets = new ArrayList<>();
		List<String> textFields = new ArrayList<>();
		List<String> layouts = new ArrayList<>();
		List<String> containers = new ArrayList<>();
		List<String> imagesAndMedia = new ArrayList<>();
		List<String> dateAndTime = new ArrayList<>();
		List<String> transitions = new ArrayList<>();
		List<String> advanced = new ArrayList<>();
		List<String> customGoogle = new ArrayList<>();
		List<String> customDesign = new ArrayList<>();
		List<String> customAppCompat = new ArrayList<>();

		widgets.add("TextView");
		widgets.add("Button");
		widgets.add("ToggleButton");
		widgets.add("CheckBox");
		widgets.add("RadioButton");
		widgets.add("CheckedTextView");
		widgets.add("Spinner");
		widgets.add("ProgressBar");
		widgets.add("SeekBar");
		widgets.add("QuickContactBadge");
		widgets.add("RatingBar");
		widgets.add("Switch");
		widgets.add("Space");

		textFields.add("Plain Text");
		textFields.add("Password");
		textFields.add("Email");
		textFields.add("Phone");
		textFields.add("Postal Address");
		textFields.add("Multiline Text");
		textFields.add("Time");
		textFields.add("Date");
		textFields.add("Number");
		textFields.add("AutoCompleteTextView");
		textFields.add("MultilineAutoCompleteTextView");

		layouts.add("ConstraintLayout");
		layouts.add("GridLayout");
		layouts.add("FrameLayout");
		layouts.add("LinearLayout");
		layouts.add("RelativeLayout");
		layouts.add("TableLayout");
		layouts.add("TableRow");
		layouts.add("<fragment>");

		containers.add("RadioGroup");
		containers.add("ListView");
		containers.add("GridView");
		containers.add("ExpandableListView");
		containers.add("ScrollView");
		containers.add("HorizontalScrollView");
		containers.add("TabHost");
		containers.add("WebView");
		containers.add("SearchView");

		imagesAndMedia.add("ImageButton");
		imagesAndMedia.add("ImageView");
		imagesAndMedia.add("VideoView");

		dateAndTime.add("TimePicker");
		dateAndTime.add("DatePicker");
		dateAndTime.add("CalenderView");
		dateAndTime.add("Chronometer");
		dateAndTime.add("TextClock");

		transitions.add("ImageSwitcher");
		transitions.add("AdapterViewFlipper");
		transitions.add("StackView");
		transitions.add("TextSwitcher");
		transitions.add("ViewAnimator");
		transitions.add("ViewFlipper");
		transitions.add("ViewSwitcher");

		advanced.add("<include>");
		advanced.add("<requestFocus>");
		advanced.add("<view>");
		advanced.add("ViewStub");
		advanced.add("TextureView");
		advanced.add("NumberPicker");

		customGoogle.add("AdView");
		customGoogle.add("MapFragment");
		customGoogle.add("MapView");

		customDesign.add("CoordinatorLayout");
		customDesign.add("AppBarLayout");
		customDesign.add("TabLayout");
		customDesign.add("TabItem");
		customDesign.add("NestedScrollView");
		customDesign.add("FloatingActionButton");
		customDesign.add("TextInputLayout");

		customAppCompat.add("CardView");
		customAppCompat.add("GridLayout");
		customAppCompat.add("RecyclerView");
		customAppCompat.add("ToolBar");

		items.put(categories.get(0), widgets);
		items.put(categories.get(1), textFields);
		items.put(categories.get(2), layouts);
		items.put(categories.get(3), containers);
		items.put(categories.get(4), imagesAndMedia);
		items.put(categories.get(5), dateAndTime);
		items.put(categories.get(6), transitions);
		items.put(categories.get(7), advanced);
		items.put(categories.get(8), customGoogle);
		items.put(categories.get(9), customDesign);
		items.put(categories.get(10), customAppCompat);
	}
}
