package com.android.mail.ui;

import android.app.Activity;
import android.content.AsyncTaskLoader;
import android.net.Uri;
import android.util.Log;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.providers.Account;
import java.util.ArrayList;
import java.util.Iterator;

public class ConversationCursorLoader
  extends AsyncTaskLoader<ConversationCursor>
{
  private static final ArrayList<ConversationCursorLoader> sLoaders = new ArrayList();
  private final Activity mActivity;
  private boolean mClosed = false;
  private final ConversationCursor mConversationCursor;
  private boolean mInit = false;
  private boolean mInitialConversationLimit;
  private final String mName;
  private boolean mRetain = false;
  private boolean mRetained = false;
  private final Uri mUri;
  
  public ConversationCursorLoader(Activity paramActivity, Account paramAccount, Uri paramUri, String paramString)
  {
    super(paramActivity);
    mActivity = paramActivity;
    mUri = paramUri;
    mName = paramString;
    mInitialConversationLimit = paramAccount.supportsCapability(262144);
    mConversationCursor = new ConversationCursor(mActivity, mUri, mInitialConversationLimit, mName);
    addLoader();
  }
  
  private void addLoader()
  {
    Log.d("ConversationCursorLoader", "Add loader: " + mUri);
    sLoaders.add(this);
    if (sLoaders.size() > 1) {
      dumpLoaders();
    }
  }
  
  private void dumpLoaders()
  {
    Log.d("ConversationCursorLoader", "Loaders: ");
    Iterator localIterator = sLoaders.iterator();
    while (localIterator.hasNext())
    {
      ConversationCursorLoader localConversationCursorLoader = (ConversationCursorLoader)localIterator.next();
      Log.d("ConversationCursorLoader", " >> " + mName + " (" + mUri + ")");
    }
  }
  
  public ConversationCursor loadInBackground()
  {
    if (!mInit)
    {
      mConversationCursor.load();
      mInit = true;
    }
    return mConversationCursor;
  }
  
  public void onReset()
  {
    if (!mRetain)
    {
      Log.d("ConversationCursorLoader", "Reset loader/disable cursor: " + mName);
      mConversationCursor.disable();
      mClosed = true;
      sLoaders.remove(this);
      if (!sLoaders.isEmpty()) {
        dumpLoaders();
      }
      return;
    }
    Log.d("ConversationCursorLoader", "Reset loader/retain cursor: " + mName);
    mRetained = true;
  }
  
  protected void onStartLoading()
  {
    if (mClosed)
    {
      mClosed = false;
      mConversationCursor.load();
      addLoader();
      Log.d("ConversationCursorLoader", "Restarting reset loader: " + mName);
    }
    for (;;)
    {
      forceLoad();
      mConversationCursor.resume();
      return;
      if (mRetained)
      {
        mRetained = false;
        Log.d("ConversationCursorLoader", "Resuming retained loader: " + mName);
      }
    }
  }
  
  protected void onStopLoading()
  {
    cancelLoad();
    mConversationCursor.pause();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationCursorLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */