package com.woodensocks.anxietytoolkit.Database;

import androidx.room.*;

import java.util.List;

@Dao
public interface MoodEntryDao {
        @Query("SELECT * FROM moodEntries")
        List<MoodEntry> getAll();

        @Query("SELECT * FROM moodEntries WHERE dateid = (:dateid)")
        List<MoodEntry> findByID(long dateid);

        @Insert
        void insertAll(MoodEntry... moodEntries);

        @Delete
        void delete(MoodEntry moodEntry);
}
