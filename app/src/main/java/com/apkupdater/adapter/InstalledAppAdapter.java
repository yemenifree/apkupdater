package com.apkupdater.adapter;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.apkupdater.installedapp.InstalledApp;
import com.apkupdater.view.InstalledAppView;
import com.apkupdater.view.InstalledAppView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@EBean
public class InstalledAppAdapter
	extends ArrayAdapter<InstalledApp>
{
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RootContext
	Context context;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public InstalledAppAdapter(
		Context context
	) {
		super(context, 0);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	@NonNull
	public View getView(
		int position,
		View convertView,
		@NonNull ViewGroup parent
	) {
		InstalledAppView app;

		if (convertView == null) {
			app = InstalledAppView_.build(context);
		} else {
			app = (InstalledAppView) convertView;
		}

		app.bind(getItem(position));

		return app;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void notifyDataSetChanged(
	) {
		super.notifyDataSetChanged();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public InstalledApp[] getValues(
	) {
		InstalledApp [] values = new InstalledApp[getCount()];
		for (int i = 0; i < getCount(); i++) {
			values[i] = getItem(i);
		}
		return values;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

