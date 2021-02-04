package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RatingDialog.SaveRatingListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUserRating();
    }

    private void initUserRating() {
        Button rateButton = findViewById(R.id.buttonRateMeal);
        rateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                RatingDialog ratingDialog = new RatingDialog();
                ratingDialog.show(fm, "Rate Your Food");
            }
        });
    }

    @Override
    public void didUserRate(float userRating) {
        TextView rating = findViewById(R.id.userRatingText);
        rating.setText(String.format("%s Star Rating", (userRating)));
    }
}