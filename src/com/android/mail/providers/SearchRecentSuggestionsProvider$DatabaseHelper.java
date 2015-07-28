package com.android.mail.providers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class SearchRecentSuggestionsProvider$DatabaseHelper
  extends SQLiteOpenHelper
{
  public SearchRecentSuggestionsProvider$DatabaseHelper(Context paramContext, int paramInt)
  {
    super(paramContext, "suggestions.db", null, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE suggestions (_id INTEGER PRIMARY KEY,display1 TEXT UNIQUE ON CONFLICT REPLACE,query TEXT,date LONG);");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS suggestions");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.SearchRecentSuggestionsProvider.DatabaseHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */