package com.google.android.gm.provider;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;

class MailEngine$9
  implements SQLiteDatabase.CursorFactory
{
  MailEngine$9(MailEngine paramMailEngine, MailEngine.ConversationCursorLogic paramConversationCursorLogic) {}
  
  public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    return new MailEngine.ConversationCursor(this$0, paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery, val$logic);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */