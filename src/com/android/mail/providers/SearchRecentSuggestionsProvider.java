package com.android.mail.providers;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class SearchRecentSuggestionsProvider
  extends ContentProvider
{
  private String mAuthority;
  private ArrayList<String> mFullQueryTerms;
  private int mMode;
  private SQLiteOpenHelper mOpenHelper;
  private String mSuggestSuggestionClause;
  private String[] mSuggestionProjection;
  private Uri mSuggestionsUri;
  private UriMatcher mUriMatcher;
  
  private String[] createProjection(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[mSuggestionProjection.length];
    if (mFullQueryTerms != null) {}
    for (int i = mFullQueryTerms.size();; i = 0)
    {
      if (i <= 0) {
        break label165;
      }
      paramArrayOfString = "'";
      int j = 0;
      while (j < i)
      {
        String str = paramArrayOfString + (String)mFullQueryTerms.get(j);
        paramArrayOfString = str;
        if (j < i - 1) {
          paramArrayOfString = str + " ";
        }
        j += 1;
      }
    }
    label165:
    for (paramArrayOfString = paramArrayOfString + " ' || query AS " + "suggest_intent_query";; paramArrayOfString = "query AS suggest_intent_query")
    {
      i = 0;
      while (i < mSuggestionProjection.length)
      {
        arrayOfString[i] = mSuggestionProjection[i];
        i += 1;
      }
    }
    arrayOfString[(mSuggestionProjection.length - 2)] = paramArrayOfString;
    return arrayOfString;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = mOpenHelper.getWritableDatabase();
    if (paramUri.getPathSegments().size() != 1) {
      throw new IllegalArgumentException("Unknown Uri");
    }
    if (((String)paramUri.getPathSegments().get(0)).equals("suggestions"))
    {
      int i = localSQLiteDatabase.delete("suggestions", paramString, paramArrayOfString);
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
    }
    throw new IllegalArgumentException("Unknown Uri");
  }
  
  public String getType(Uri paramUri)
  {
    if (mUriMatcher.match(paramUri) == 1) {
      return "vnd.android.cursor.dir/vnd.android.search.suggest";
    }
    int i = paramUri.getPathSegments().size();
    if ((i >= 1) && (((String)paramUri.getPathSegments().get(0)).equals("suggestions")))
    {
      if (i == 1) {
        return "vnd.android.cursor.dir/suggestion";
      }
      if (i == 2) {
        return "vnd.android.cursor.item/suggestion";
      }
    }
    throw new IllegalArgumentException("Unknown Uri");
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = mOpenHelper.getWritableDatabase();
    int i = paramUri.getPathSegments().size();
    if (i < 1) {
      throw new IllegalArgumentException("Unknown Uri");
    }
    long l2 = -1L;
    String str = (String)paramUri.getPathSegments().get(0);
    Object localObject = null;
    paramUri = (Uri)localObject;
    long l1 = l2;
    if (str.equals("suggestions"))
    {
      paramUri = (Uri)localObject;
      l1 = l2;
      if (i == 1)
      {
        l2 = localSQLiteDatabase.insert("suggestions", "query", paramContentValues);
        paramUri = (Uri)localObject;
        l1 = l2;
        if (l2 > 0L)
        {
          paramUri = Uri.withAppendedPath(mSuggestionsUri, String.valueOf(l2));
          l1 = l2;
        }
      }
    }
    if (l1 < 0L) {
      throw new IllegalArgumentException("Unknown Uri");
    }
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  public boolean onCreate()
  {
    if ((mAuthority == null) || (mMode == 0)) {
      throw new IllegalArgumentException("Provider not configured");
    }
    int i = mMode;
    mOpenHelper = new DatabaseHelper(getContext(), i + 512);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString2 = mOpenHelper.getReadableDatabase();
    if (TextUtils.isEmpty(paramArrayOfString2[0]))
    {
      paramArrayOfString1 = null;
      paramString1 = null;
    }
    for (;;)
    {
      paramArrayOfString1 = paramString2.query("suggestions", createProjection(paramArrayOfString2), paramArrayOfString1, paramString1, null, null, "date DESC", null);
      paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
      return paramArrayOfString1;
      paramArrayOfString1 = "%" + paramArrayOfString2[0] + "%";
      paramString1 = new String[1];
      paramString1[0] = paramArrayOfString1;
      paramArrayOfString1 = mSuggestSuggestionClause;
    }
  }
  
  public void setFullQueryTerms(ArrayList<String> paramArrayList)
  {
    mFullQueryTerms = paramArrayList;
  }
  
  protected void setupSuggestions(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || ((paramInt & 0x1) == 0)) {
      throw new IllegalArgumentException();
    }
    mAuthority = new String(paramString);
    mMode = paramInt;
    mSuggestionsUri = Uri.parse("content://" + mAuthority + "/suggestions");
    mUriMatcher = new UriMatcher(-1);
    mUriMatcher.addURI(mAuthority, "search_suggest_query", 1);
    paramString = "android.resource://" + getContext().getPackageName() + "/" + 2130837580;
    mSuggestSuggestionClause = "display1 LIKE ?";
    mSuggestionProjection = new String[] { "_id", "display1 AS suggest_text_1", "query AS suggest_intent_query", "'" + paramString + "' AS " + "suggest_icon_1" };
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("Not implemented");
  }
  
  private static class DatabaseHelper
    extends SQLiteOpenHelper
  {
    public DatabaseHelper(Context paramContext, int paramInt)
    {
      super("suggestions.db", null, paramInt);
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
}

/* Location:
 * Qualified Name:     com.android.mail.providers.SearchRecentSuggestionsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */