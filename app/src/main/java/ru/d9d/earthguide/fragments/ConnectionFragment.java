package ru.d9d.earthguide.fragments;


import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ru.d9d.earthguide.R;
import ru.d9d.earthguide.adapters.PlaceAdapter;
import ru.d9d.earthguide.models.Place;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConnectionFragment extends Fragment {


    public ConnectionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.listview,container,false);

        final ArrayList<Place> places = new ArrayList<>();
        Resources res = getResources();
        String[] arrNames = res.getStringArray(R.array.attraction_names);
        String[] arrDescriptions = res.getStringArray(R.array.attraction_descriptions);
        TypedArray arrImages = res.obtainTypedArray(R.array.attraction_images);

        for(int i=0;i<arrNames.length;i++){
            //Drawable drawable = arrWordsImages.getDrawable(i);
            int imageRes=arrImages.getResourceId(i,-1);
            if(imageRes==-1) break;
            places.add(new Place(imageRes,arrNames[i],arrDescriptions[i]));
        }
        arrImages.recycle();

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.itemBackground);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setBackgroundColor(getResources().getColor(R.color.itemBackground));
        return rootView;
    }

}
