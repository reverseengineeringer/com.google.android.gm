package com.google.android.gm.provider;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class LabelQueryBuilder
{
  private List<String> mArgs;
  private SQLiteQueryBuilder mBuilder = new SQLiteQueryBuilder();
  private SQLiteDatabase mDb;
  private int mLimit;
  private String[] mProjection;
  private boolean mRecent;
  private boolean whereAppended;
  
  public LabelQueryBuilder(Context paramContext, SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    mDb = paramSQLiteDatabase;
    mProjection = paramArrayOfString;
    mBuilder.setTables("labels");
    mBuilder.setProjectionMap(MailEngine.LABEL_PROJECTION_MAP);
    mArgs = Lists.newArrayList(QueryUtils.getQueryBindArgs(paramContext, paramArrayOfString, "name", new String[0]));
  }
  
  private void appendWhereClause(CharSequence paramCharSequence)
  {
    if (whereAppended) {
      mBuilder.appendWhere(" AND ");
    }
    for (;;)
    {
      mBuilder.appendWhere(paramCharSequence);
      return;
      whereAppended = true;
    }
  }
  
  private String getLimit()
  {
    if (mLimit != 0) {
      return Integer.toString(mLimit);
    }
    return null;
  }
  
  private String getOrder()
  {
    if (mRecent) {
      return "lastTouched DESC";
    }
    return "systemLabel DESC, sortOrder ASC";
  }
  
  public LabelQueryBuilder filterCanonicalName(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 1;
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (i != 0)
        {
          localStringBuilder.append("canonicalName IN (");
          i = 0;
        }
        for (;;)
        {
          localStringBuilder.append("?");
          mArgs.add(str);
          break;
          localStringBuilder.append(", ");
        }
      }
      localStringBuilder.append(")");
      appendWhereClause(localStringBuilder.toString());
    }
    return this;
  }
  
  List<String> getQueryArgs()
  {
    return mArgs;
  }
  
  String getQueryString()
  {
    return mBuilder.buildQuery(mProjection, null, null, null, getOrder(), getLimit());
  }
  
  public LabelQueryBuilder labelId(long paramLong)
  {
    if (paramLong != 0L)
    {
      appendWhereClause("_id = ?");
      mArgs.add(Long.toString(paramLong));
    }
    return this;
  }
  
  public Cursor query()
  {
    String[] arrayOfString = (String[])mArgs.toArray(new String[mArgs.size()]);
    return mBuilder.query(mDb, mProjection, null, arrayOfString, null, null, getOrder(), getLimit());
  }
  
  public LabelQueryBuilder setRecent(long paramLong, int paramInt)
  {
    if (paramLong != 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder("lastTouched");
      localStringBuilder.append(" != 0 AND ");
      localStringBuilder.append("lastTouched");
      localStringBuilder.append(" < ?");
      mArgs.add(Long.toString(paramLong));
      mLimit = paramInt;
      appendWhereClause(localStringBuilder.toString());
      mRecent = true;
    }
    return this;
  }
  
  public LabelQueryBuilder showHidden(boolean paramBoolean)
  {
    if (!paramBoolean) {
      appendWhereClause("hidden = 0");
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.LabelQueryBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */