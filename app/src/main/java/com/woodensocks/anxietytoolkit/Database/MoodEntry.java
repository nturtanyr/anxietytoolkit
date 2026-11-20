package com.woodensocks.anxietytoolkit.Database;

import androidx.room.*;

@Entity(tableName = "moodEntries",
        indices = {@Index(value = {"dateid"},
        unique = true)})
public class MoodEntry {

    @PrimaryKey
    public long dateid;

    @ColumnInfo(name = "face_id")
    public long faceid;

}
