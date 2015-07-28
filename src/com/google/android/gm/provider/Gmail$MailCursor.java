package com.google.android.gm.provider;

import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Gmail$MailCursor
  extends ContentObserver
{
  protected String mAccount;
  protected Cursor mCursor;
  private final Set<Gmail.MailCursorObserver> mObservers = new HashSet();
  private ContentValues mUpdateValues;
  
  protected Gmail$MailCursor(Handler paramHandler, String paramString, Cursor paramCursor)
  {
    super(paramHandler);
    mCursor = paramCursor;
    mAccount = paramString;
    if (mCursor != null) {
      mCursor.registerContentObserver(this);
    }
  }
  
  protected void checkCursor()
  {
    if (mCursor == null) {
      throw new IllegalStateException("cannot read from an insertion cursor");
    }
  }
  
  protected void checkThread() {}
  
  public void close()
  {
    release();
    if ((mCursor != null) && (!mCursor.isClosed())) {
      mCursor.close();
    }
  }
  
  public final int count()
  {
    if (mCursor != null) {
      return mCursor.getCount();
    }
    return 0;
  }
  
  public final void deactivate()
  {
    if (mCursor != null) {
      mCursor.deactivate();
    }
  }
  
  public final boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public String getAccount()
  {
    return mAccount;
  }
  
  protected String getStringInColumn(int paramInt)
  {
    checkCursor();
    return Gmail.access$1000(mCursor.getString(paramInt));
  }
  
  protected ContentValues getUpdateValues()
  {
    if (mUpdateValues == null) {
      mUpdateValues = new ContentValues();
    }
    return mUpdateValues;
  }
  
  public final boolean isLast()
  {
    return (mCursor != null) && (mCursor.isLast());
  }
  
  public final boolean moveTo(int paramInt)
  {
    checkCursor();
    checkThread();
    boolean bool = mCursor.moveToPosition(paramInt);
    if (bool) {
      onCursorPositionChanged();
    }
    return bool;
  }
  
  public final boolean next()
  {
    checkCursor();
    checkThread();
    boolean bool = mCursor.moveToNext();
    if (bool) {
      onCursorPositionChanged();
    }
    return bool;
  }
  
  public void onChange(boolean paramBoolean)
  {
    Iterator localIterator = mObservers.iterator();
    while (localIterator.hasNext()) {
      ((Gmail.MailCursorObserver)localIterator.next()).onCursorChanged(this);
    }
  }
  
  protected void onCursorPositionChanged()
  {
    mUpdateValues = null;
  }
  
  public final int position()
  {
    if (mCursor != null) {
      return mCursor.getPosition();
    }
    return -1;
  }
  
  public final void release()
  {
    if (mCursor != null)
    {
      mCursor.unregisterContentObserver(this);
      mCursor.deactivate();
    }
  }
  
  public void requery()
  {
    mCursor.requery();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Gmail.MailCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */