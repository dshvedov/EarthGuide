package ru.d9d.earthguide.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        // Set the content of the activity to use the activity_place.xml layout file
        setContentView(R.layout.activity_place);

        // Fill contents of layout elements with passed extras details
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            // Set activity title
            setTitle(extras.getString("name") + " (" + getApplicationContext().getString(R.string.app_name) + ")");

            // Set name
            TextView nameTextView = (TextView) findViewById(R.id.text_name);
            nameTextView.setText(extras.getString("name"));

            // Set description
            TextView descriptionTextView = (TextView) findViewById(R.id.text_description);
            descriptionTextView.setText(extras.getString("description"));

            // Set image
            ImageView imageImageView = (ImageView) findViewById(R.id.image);
            imageImageView.setImageResource(extras.getInt("image"));
        }

    }

}
