package com.android.mail.providers;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.BaseAdapter;
import com.android.mail.ui.RestrictedActivity;
import com.android.mail.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FolderWatcher
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  private final RestrictedActivity mActivity;
  private BaseAdapter mConsumer;
  private final Map<Uri, Folder> mFolder = new HashMap();
  private final List<Uri> mUri = new ArrayList();
  
  public FolderWatcher(RestrictedActivity paramRestrictedActivity, BaseAdapter paramBaseAdapter)
  {
    mActivity = paramRestrictedActivity;
    mConsumer = paramBaseAdapter;
  }
  
  private static final int getLoaderFromPosition(int paramInt)
  {
    return paramInt + 100;
  }
  
  private static final int getPositionFromLoader(int paramInt)
  {
    return paramInt - 100;
  }
  
  public Folder get(Uri paramUri)
  {
    return (Folder)mFolder.get(paramUri);
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramInt = getPositionFromLoader(paramInt);
    if ((paramInt < 0) || (paramInt > mUri.size())) {
      return null;
    }
    return new CursorLoader(mActivity.getActivityContext(), (Uri)mUri.get(paramInt), UIProvider.FOLDERS_PROJECTION, null, null, null);
  }
  
  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.getCount() <= 0) || (!paramCursor.moveToFirst())) {
      return;
    }
    paramLoader = (Uri)mUri.get(getPositionFromLoader(paramLoader.getId()));
    paramCursor = new Folder(paramCursor);
    mFolder.put(paramLoader, paramCursor);
    mConsumer.notifyDataSetChanged();
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  public void startWatching(Uri paramUri)
  {
    if ((paramUri == null) || (mFolder.containsKey(paramUri))) {
      return;
    }
    int i = mUri.size();
    LogUtils.d("UnifiedEmail", "Watching %s, at position %d.", new Object[] { paramUri, Integer.valueOf(i) });
    mFolder.put(paramUri, null);
    mUri.add(paramUri);
    mActivity.getLoaderManager().initLoader(getLoaderFromPosition(i), null, this);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.FolderWatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */