package com.example.mealrater;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.fragment.app.DialogFragment;

public class RatingDialog extends DialogFragment {

    RatingBar ratingBar;
    float userRating;

    public interface SaveRatingListener {
        void didUserRate(float userRating);
    }

    public RatingDialog() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.meal_dialog, container);
        final RatingBar rating = view.findViewById(R.id.ratingBar);
        getDialog().setTitle("Rate Your Dish");

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                userRating = ratingBar.getRating();
            }
        });

        //what happens when we click save
        Button saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveItem(userRating);
                getDialog().dismiss();
            }
        });

        return view;
    }

    //save item and change didUserRate to the rating we entered
    private void saveItem(float rating) {
        SaveRatingListener activity = (SaveRatingListener)getActivity();

        activity.didUserRate(userRating);
        getDialog().dismiss();
    }


}
