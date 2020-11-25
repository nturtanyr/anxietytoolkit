package com.woodensocks.anxietytoolkit.Journal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.woodensocks.anxietytoolkit.Database.*;
import com.woodensocks.anxietytoolkit.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JournalDailyMood#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JournalDailyMood extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Calendar View declarations
    CalendarView calendar;
    Long dateid;
    JournalDatabase db;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JournalDailyMood() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JournalDailyMood.
     */
    // TODO: Rename and change types and number of parameters
    public static JournalDailyMood newInstance(String param1, String param2) {
        JournalDailyMood fragment = new JournalDailyMood();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_journal_daily_mood, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        db = Room.databaseBuilder(getContext(),
                JournalDatabase.class, "journalentries").build();
        Log.d("Calendar","View is now created!");
        calendar = (CalendarView) view.findViewById(R.id.mood_calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {

                // If the date selected has changed, reset the date
                dateid = (long) (10000 * year) + (100 * (month+1)) + dayOfMonth;
                Log.d("Calendar","Date is now " +dateid.toString());
                if(checkDatabaseForDate(dateid))
                {
                    updateMoodDisplay(view);
                }
                else
                {
                    showMoodOptions(view);
                }
            }
        });
    }

    private void showMoodOptions(CalendarView view) {
        Log.d("Calendar","No entry found for this date");
    }

    private void updateMoodDisplay(CalendarView view) {
        Log.d("Calendar","There was an entry found");
    }

    private boolean checkDatabaseForDate(Long dateid) {
        //TODO: Move to an async handler class
        List<MoodEntry> entry = db.moodEntryDao().findByID(dateid);
        if(entry.size() > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}