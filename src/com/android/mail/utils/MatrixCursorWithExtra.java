package com.android.mail.utils;

import android.database.MatrixCursor;
import android.os.Bundle;

public class MatrixCursorWithExtra
  extends MatrixCursor
{
  private final Bundle mExtras;
  
  public MatrixCursorWithExtra(String[] paramArrayOfString, int paramInt, Bundle paramBundle)
  {
    super(paramArrayOfString, paramInt);
    mExtras = paramBundle;
  }
  
  public Bundle getExtras()
  {
    return mExtras;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.MatrixCursorWithExtra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */