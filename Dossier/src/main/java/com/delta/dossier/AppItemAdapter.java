package com.delta.dossier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Kin on 8/15/13.
 */
public class AppItemAdapter extends ArrayAdapter<AppItem> {

    Context mContext;
    int mLayoutResourceId;
    AppItem mData[] = null;

    public AppItemAdapter(Context context, int layoutResourceId, AppItem[] data) {
        super(context, layoutResourceId, data);
        this.mContext = context;
        this.mLayoutResourceId = layoutResourceId;
        this.mData = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        AppItemHolder holder = null;

        if(row == null) {
            // Create a new view
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId, parent, false);

            holder = new AppItemHolder();
            //assign item details to UI elements
            holder.appName = (TextView) row.findViewById(R.id.app_name);
            holder.appDescription = (TextView) row.findViewById(R.id.description);

            row.setTag(holder);
        } else {
            // use an existing view
            holder = (AppItemHolder) row.getTag();
        }

        AppItem appItem = mData[position];

        holder.appName.setText(appItem.getAppName());
        holder.appDescription.setText(appItem.getAppDescription());

        return row;
    }

    static class AppItemHolder {
        TextView appName;
        TextView appDescription;
    }
}