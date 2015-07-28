package com.android.mail.ui;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.android.mail.providers.AccountObserver;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.LruCache;
import com.android.mail.utils.Utils;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class RecentFolderList
{
  private static final Comparator<Folder> ALPHABET_IGNORECASE;
  private com.android.mail.providers.Account mAccount = null;
  private final AccountObserver mAccountObserver = new AccountObserver()
  {
    public void onChanged(com.android.mail.providers.Account paramAnonymousAccount)
    {
      RecentFolderList.this.setCurrentAccount(paramAnonymousAccount);
    }
  };
  private final Context mContext;
  private final LruCache<String, RecentFolderListEntry> mFolderCache = new LruCache(7);
  
  static
  {
    if (!RecentFolderList.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ALPHABET_IGNORECASE = new Comparator()
      {
        public int compare(Folder paramAnonymousFolder1, Folder paramAnonymousFolder2)
        {
          return name.compareToIgnoreCase(name);
        }
      };
      return;
    }
  }
  
  public RecentFolderList(Context paramContext)
  {
    mContext = paramContext;
  }
  
  private void setCurrentAccount(com.android.mail.providers.Account paramAccount)
  {
    mAccount = paramAccount;
    mFolderCache.clear();
  }
  
  public void destroy()
  {
    mAccountObserver.unregisterAndDestroy();
  }
  
  public ArrayList<Folder> getRecentFolderList(Uri paramUri)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramUri != null) {
      localArrayList.add(paramUri);
    }
    if (mAccount == null) {}
    for (paramUri = Uri.EMPTY;; paramUri = Settings.getDefaultInboxUri(mAccount.settings))
    {
      if (!paramUri.equals(Uri.EMPTY)) {
        localArrayList.add(paramUri);
      }
      Object localObject = Lists.newArrayList();
      ((List)localObject).addAll(mFolderCache.values());
      Collections.sort((List)localObject);
      paramUri = Lists.newArrayList();
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentFolderListEntry localRecentFolderListEntry = (RecentFolderListEntry)((Iterator)localObject).next();
        if (!localArrayList.contains(mFolder.uri)) {
          paramUri.add(mFolder);
        }
      } while (paramUri.size() != 5);
      Collections.sort(paramUri, ALPHABET_IGNORECASE);
      return paramUri;
    }
  }
  
  public void initialize(ControllableActivity paramControllableActivity)
  {
    setCurrentAccount(mAccountObserver.initialize(paramControllableActivity.getAccountController()));
  }
  
  public void loadFromUiProvider(Cursor paramCursor)
  {
    if ((mAccount == null) || (paramCursor == null)) {
      return;
    }
    LogUtils.d("RecentFolderList", "Number of recents = %d", new Object[] { Integer.valueOf(paramCursor.getCount()) });
    if (!paramCursor.moveToLast())
    {
      LogUtils.d("RecentFolderList", "Not able to move to last in recent labels cursor", new Object[0]);
      return;
    }
    do
    {
      Folder localFolder = new Folder(paramCursor);
      RecentFolderListEntry localRecentFolderListEntry = new RecentFolderListEntry(localFolder);
      mFolderCache.putElement(uri.toString(), localRecentFolderListEntry);
      LogUtils.v("RecentFolderList", "Account %s, Recent: %s", new Object[] { mAccount.name, name });
    } while (paramCursor.moveToPrevious());
  }
  
  public void touchFolder(Folder paramFolder, com.android.mail.providers.Account paramAccount)
  {
    if ((mAccount == null) || (!mAccount.equals(paramAccount)))
    {
      if (paramAccount != null) {
        setCurrentAccount(paramAccount);
      }
    }
    else
    {
      if (($assertionsDisabled) || (paramFolder != null)) {
        break label58;
      }
      throw new AssertionError();
    }
    LogUtils.w("RecentFolderList", "No account set for setting recent folders?", new Object[0]);
    return;
    label58:
    paramAccount = new RecentFolderListEntry(paramFolder);
    mFolderCache.putElement(uri.toString(), paramAccount);
    new StoreRecent(mAccount, paramFolder).execute(new Void[0]);
  }
  
  private static class RecentFolderListEntry
    implements Comparable<RecentFolderListEntry>
  {
    private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
    private final Folder mFolder;
    private final int mSequence;
    
    RecentFolderListEntry(Folder paramFolder)
    {
      mFolder = paramFolder;
      mSequence = SEQUENCE_GENERATOR.getAndIncrement();
    }
    
    public int compareTo(RecentFolderListEntry paramRecentFolderListEntry)
    {
      return mSequence - mSequence;
    }
  }
  
  private class StoreRecent
    extends AsyncTask<Void, Void, Void>
  {
    private final com.android.mail.providers.Account mAccount;
    private final Folder mFolder;
    
    static
    {
      if (!RecentFolderList.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public StoreRecent(com.android.mail.providers.Account paramAccount, Folder paramFolder)
    {
      assert ((paramAccount != null) && (paramFolder != null));
      mAccount = paramAccount;
      mFolder = paramFolder;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      paramVarArgs = mAccount.recentFolderListUri;
      if (!Utils.isEmpty(paramVarArgs))
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put(mFolder.uri.toString(), Integer.valueOf(0));
        LogUtils.i("RecentFolderList", "Save: %s", new Object[] { mFolder.name });
        mContext.getContentResolver().update(paramVarArgs, localContentValues, null, null);
      }
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.RecentFolderList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */