package com.woodensocks.anxietytoolkit.Journal;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.room.Room;

import com.woodensocks.anxietytoolkit.Database.JournalDatabase;
import com.woodensocks.anxietytoolkit.Database.MoodEntry;
import com.woodensocks.anxietytoolkit.Database.*;

import java.util.ArrayList;
import java.util.List;

public class JournalDatabaseAsyncTask extends AsyncTask<Void, Void, Boolean> {

    private Handler UIHandler;
    private long dateid;
    private MoodEntryDao dao;

    public JournalDatabaseAsyncTask(Handler handler, Long dateid, MoodEntryDao dao) {
        // Constructor - allows us to read what the main activity currently is
        this.UIHandler = handler;
        this.dateid = dateid;
        this.dao = dao;
    }
    @Override
    protected Boolean doInBackground(Void... params) {
        // Create API object to work with the API
        // Get the list of traders using getTraders function
        //TODO: Move to an async handler class
        List<MoodEntry> entry = dao.findByID(dateid);
        if(entry.size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean entryExists) {
        Message response;
        // Defined a general task that extends AsyncTask to then call/run API calls
        int responseCode;
        if(entryExists)
        {
            responseCode = 1;
        }
        else
        {
            responseCode = 0;
        }
        response = UIHandler.obtainMessage(responseCode);
        response.sendToTarget();
    }
}
