package ru.d9d.earthguide.adapters;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.d9d.earthguide.R;
import ru.d9d.earthguide.models.Place;

public class PlaceAdapter extends ArrayAdapter<Place> {

    private int mColorResouceId;

    public PlaceAdapter(Activity context, ArrayList<Place> places, int categoryColor) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, places);
        mColorResouceId = categoryColor;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Place place = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.text_name);
        nameTextView.setText(place.getName());

        ImageView imageImageView = (ImageView) listItemView.findViewById(R.id.image);
        if (place.hasImage()) {
            imageImageView.setImageResource(place.getImageResourceId());
        } else {
            imageImageView.setVisibility(View.INVISIBLE);
        }

        return listItemView;
    }
}
