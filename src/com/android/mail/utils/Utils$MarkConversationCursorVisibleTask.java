package com.android.mail.utils;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;

class Utils$MarkConversationCursorVisibleTask
  extends AsyncTask<Void, Void, Void>
{
  private final Cursor mCursor;
  private final boolean mIsFirstSeen;
  private final boolean mVisible;
  
  public Utils$MarkConversationCursorVisibleTask(Cursor paramCursor, boolean paramBoolean1, boolean paramBoolean2)
  {
    mCursor = paramCursor;
    mVisible = paramBoolean1;
    mIsFirstSeen = paramBoolean2;
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    if (mCursor == null) {
      return null;
    }
    paramVarArgs = new Bundle();
    if (mIsFirstSeen) {
      paramVarArgs.putBoolean("enteredFolder", true);
    }
    paramVarArgs.putBoolean("setVisibility", mVisible);
    Utils.access$000(mCursor, paramVarArgs, "setVisibility");
    return null;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.Utils.MarkConversationCursorVisibleTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */