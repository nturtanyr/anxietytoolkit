package com.woodensocks.anxietytoolkit;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.woodensocks.anxietytoolkit.Journal.JournalDailyMood;

public class HomePage extends FragmentActivity {

    HomeNavigation HomeNavigationFragment = new HomeNavigation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (savedInstanceState != null) {
            return;
        }
        else {
            if (findViewById(R.id.fragment_sp) != null) {

                // However, if we're being restored from a previous state,
                // then we don't need to do anything and should return or else
                // we could end up with overlapping fragments.

                // Create a new Fragment to be placed in the activity layout
                StatusPanel StatusPanelFragment = new StatusPanel();

                // In case this activity was started with special instructions from an
                // Intent, pass the Intent's extras to the fragment as arguments
                // firstFragment.setArguments(getIntent().getExtras());

                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_sp, StatusPanelFragment).commit();
            }

            if (findViewById(R.id.fragment_fd) != null) {

                // However, if we're being restored from a previous state,
                // then we don't need to do anything and should return or else
                // we could end up with overlapping fragments.

                // Create a new Fragment to be placed in the activity layout
                HomeFeatureDisplay HomeFeatureDisplayFragment = new HomeFeatureDisplay();

                // In case this activity was started with special instructions from an
                // Intent, pass the Intent's extras to the fragment as arguments
                // firstFragment.setArguments(getIntent().getExtras());

                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_fd, HomeFeatureDisplayFragment).commit();
            }

            if (findViewById(R.id.fragment_main) != null) {

                // However, if we're being restored from a previous state,
                // then we don't need to do anything and should return or else
                // we could end up with overlapping fragments.

                // Create a new Fragment to be placed in the activity layout

                // In case this activity was started with special instructions from an
                // Intent, pass the Intent's extras to the fragment as arguments
                // firstFragment.setArguments(getIntent().getExtras());

                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_main, HomeNavigationFragment).commit();
            }
        }
    }

    public void returnHome (View view)
    {
        // Create fragment and give it an argument specifying the article it should show

        if(!HomeNavigationFragment.isAdded()) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_main, HomeNavigationFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

    public void onNavigateJournal(View view)
    {
        // Create fragment and give it an argument specifying the article it should show
        JournalNavigation JournalNavigationFragment = new JournalNavigation();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_main, JournalNavigationFragment);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();
    }

    public void onButtonDailyMood(View view)
    {
        // Create fragment and give it an argument specifying the article it should show
        JournalDailyMood jdlFragment = new JournalDailyMood();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_main, jdlFragment);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();
    }
}