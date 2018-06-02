package ru.d9d.earthguide.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import ru.d9d.earthguide.R;

public class PlaceActivity extends AppCompatActivity {

    String name;
    String description;
    int imageResourceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            TextView nameTextView = (TextView) findViewById(R.id.text_name);
            nameTextView.setText(extras.getString("name"));

            TextView descriptionTextView = (TextView) findViewById(R.id.text_description);
            descriptionTextView.setText(extras.getString("description"));

            ImageView imageImageView = (ImageView) findViewById(R.id.image);
            imageImageView.setImageResource(extras.getInt("image"));
        }

    }

}
