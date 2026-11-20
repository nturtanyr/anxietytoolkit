package com.woodensocks.anxietytoolkit.Database;

import androidx.room.*;

@Database(entities = {MoodEntry.class}, version = 1)
public abstract class JournalDatabase extends RoomDatabase {
    public abstract MoodEntryDao moodEntryDao();
}
