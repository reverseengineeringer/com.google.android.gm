package com.google.android.gm.provider.uiprovider;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.text.TextUtils;

public class UICursorWapper
  extends CursorWrapper
{
  protected final String[] mResultProjection;
  
  public UICursorWapper(Cursor paramCursor, String[] paramArrayOfString)
  {
    super(paramCursor);
    mResultProjection = paramArrayOfString;
  }
  
  private static String toNonnullString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public int getColumnIndex(String paramString)
  {
    int i = 0;
    while (i < mResultProjection.length)
    {
      if (TextUtils.equals(paramString, mResultProjection[i])) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getColumnIndexOrThrow(String paramString)
    throws IllegalArgumentException
  {
    int i = getColumnIndex(paramString);
    if (i == -1) {
      throw new IllegalArgumentException("Column not found: " + paramString);
    }
    return i;
  }
  
  public String getColumnName(int paramInt)
  {
    return mResultProjection[paramInt];
  }
  
  public String[] getColumnNames()
  {
    return mResultProjection;
  }
  
  protected String getStringInColumn(int paramInt)
  {
    return toNonnullString(super.getString(paramInt));
  }
  
  public boolean move(int paramInt)
  {
    resetCursorRowState();
    return super.move(paramInt);
  }
  
  public boolean moveToFirst()
  {
    resetCursorRowState();
    return super.moveToFirst();
  }
  
  public boolean moveToNext()
  {
    resetCursorRowState();
    return super.moveToNext();
  }
  
  public boolean moveToPosition(int paramInt)
  {
    resetCursorRowState();
    return super.moveToPosition(paramInt);
  }
  
  public boolean moveToPrevious()
  {
    resetCursorRowState();
    return super.moveToPrevious();
  }
  
  protected void resetCursorRowState() {}
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.uiprovider.UICursorWapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */