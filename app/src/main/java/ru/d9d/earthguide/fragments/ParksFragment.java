package ru.d9d.earthguide.fragments;


import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ru.d9d.earthguide.R;
import ru.d9d.earthguide.activities.PlaceActivity;
import ru.d9d.earthguide.adapters.PlaceAdapter;
import ru.d9d.earthguide.models.Place;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParksFragment extends Fragment {


    public ParksFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.listview,container,false);

        final ArrayList<Place> places = new ArrayList<>();
        Resources res = getResources();
        String[] arrNames = res.getStringArray(R.array.parks_names);
        String[] arrDescriptions = res.getStringArray(R.array.parks_descriptions);
        TypedArray arrImages = res.obtainTypedArray(R.array.parks_images);

        for(int i=0;i<arrNames.length;i++){
            int imageRes=arrImages.getResourceId(i,-1);
            if(imageRes==-1) break;
            places.add(new Place(imageRes,arrNames[i],arrDescriptions[i]));
        }
        arrImages.recycle();

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.itemBackground);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                                                    long id) {
                                                Place place = places.get(position);
                                                Intent placeIntent = new Intent(getActivity(), PlaceActivity.class);
                                                placeIntent.putExtra("name", place.getName());
                                                placeIntent.putExtra("description", place.getDescription());
                                                placeIntent.putExtra("image", place.getImageResourceId());
                                                startActivity(placeIntent);
                                            }
                                        }
        );

        return rootView;
    }

}
