package com.example.sean.onedroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by sean on 1/14/17.
 */
public class MyExpListAdapter extends BaseExpandableListAdapter {
	//Adapter class to initialize and provide data to the  expandable list view in the MainActivity class.
	static List<String> categories;
	static Map<String, List<String>> items;
	Context context;

	//default constructor
	public MyExpListAdapter() {

	}
//constructor to initialize the fields above

	/**
	 * @param context
	 * @param categories
	 * @param items
	 */
	public MyExpListAdapter(Context context, List<String> categories, Map<String, List<String>> items) {
		this.context = context;
		MyExpListAdapter.categories = categories;
		MyExpListAdapter.items = items;
	}

	/**
	 * Gets the number of groups.
	 *
	 * @return the number of groups
	 */
	@Override
	public int getGroupCount() {
		return categories.size();
	}

	/**
	 * Gets the number of children in a specified group.
	 *
	 * @param groupPosition the position of the group for which the children
	 *                      count should be returned
	 * @return the children count in the specified group
	 */
	@Override
	public int getChildrenCount(int groupPosition) {
		return items.get(categories.get(groupPosition)).size();
	}

	/**
	 * Gets the data associated with the given group.
	 *
	 * @param groupPosition the position of the group
	 * @return the data child for the specified group
	 */
	@Override
	public Object getGroup(int groupPosition) {
		return categories.get(groupPosition);
	}

	/**
	 * Gets the data associated with the given child within the given group.
	 *
	 * @param groupPosition the position of the group that the child resides in
	 * @param childPosition the position of the child with respect to other
	 *                      children in the group
	 * @return the data of the child
	 */
	@Override
	public Object getChild(int groupPosition, int childPosition) {

		return items.get(categories.get(groupPosition)).get(childPosition);
	}

	//method to return the name of the selected child
	public String returnChild(int groupPosition, int childPosition) {
		return items.get(categories.get(groupPosition)).get(childPosition);
	}


	/**
	 * Gets the ID for the group at the given position. This group ID must be
	 * unique across groups. The combined ID (see
	 * {@link #getCombinedGroupId(long)}) must be unique across ALL items
	 * (groups and all children).
	 *
	 * @param groupPosition the position of the group for which the ID is wanted
	 * @return the ID associated with the group
	 */
	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	/**
	 * Gets the ID for the given child within the given group. This ID must be
	 * unique across all children within the group. The combined ID (see
	 * {@link #getCombinedChildId(long, long)}) must be unique across ALL items
	 * (groups and all children).
	 *
	 * @param groupPosition the position of the group that contains the child
	 * @param childPosition the position of the child within the group for which
	 *                      the ID is wanted
	 * @return the ID associated with the child
	 */
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	/**
	 * Indicates whether the child and group IDs are stable across changes to the
	 * underlying data.
	 *
	 * @return whether or not the same ID always refers to the same object
	 * @see Adapter#hasStableIds()
	 */
	@Override
	public boolean hasStableIds() {
		return false;
	}

	/**
	 * Gets a View that displays the given group. This View is only for the
	 * group--the Views for the group's children will be fetched using
	 * {@link #getChildView(int, int, boolean, View, ViewGroup)}.
	 *
	 * @param groupPosition the position of the group for which the View is
	 *                      returned
	 * @param isExpanded    whether the group is expanded or collapsed
	 * @param convertView   the old view to reuse, if possible. You should check
	 *                      that this view is non-null and of an appropriate type before
	 *                      using. If it is not possible to convert this view to display
	 *                      the correct data, this method can create a new view. It is not
	 *                      guaranteed that the convertView will have been previously
	 *                      created by
	 *                      {@link #getGroupView(int, boolean, View, ViewGroup)}.
	 * @param parent        the parent that this view will eventually be attached to
	 * @return the View corresponding to the group at the specified position
	 */
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		String category = (String) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.layout_parent, null);
		}
		TextView parentTxtView = (TextView) convertView.findViewById(R.id.parentTextView);
		parentTxtView.setText(category);
		return convertView;
	}

	/**
	 * Gets a View that displays the data for the given child within the given
	 * group.
	 *
	 * @param groupPosition the position of the group that contains the child
	 * @param childPosition the position of the child (for which the View is
	 *                      returned) within the group
	 * @param isLastChild   Whether the child is the last child within the group
	 * @param convertView   the old view to reuse, if possible. You should check
	 *                      that this view is non-null and of an appropriate type before
	 *                      using. If it is not possible to convert this view to display
	 *                      the correct data, this method can create a new view. It is not
	 *                      guaranteed that the convertView will have been previously
	 *                      created by
	 *                      {@link #getChildView(int, int, boolean, View, ViewGroup)}.
	 * @param parent        the parent that this view will eventually be attached to
	 * @return the View corresponding to the child at the specified position
	 */
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		String item = (String) getChild(groupPosition, childPosition);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.layout_child, null);
		}
		TextView childTextView = (TextView) convertView.findViewById(R.id.childTextView);
		childTextView.setText(item);
		return convertView;
	}

	/**
	 * Whether the child at the specified position is selectable.
	 *
	 * @param groupPosition the position of the group that contains the child
	 * @param childPosition the position of the child within the group
	 * @return whether the child is selectable.
	 */
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
}
