package com.android.mail.ui;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Bundle;
import com.android.mail.ContactInfo;
import com.android.mail.ContactInfoSource;
import com.android.mail.SenderInfoLoader;
import com.google.common.collect.ImmutableMap;
import java.util.Set;

public class AbstractConversationViewFragment$ContactLoaderCallbacks
  implements ContactInfoSource, LoaderManager.LoaderCallbacks<ImmutableMap<String, ContactInfo>>
{
  private ImmutableMap<String, ContactInfo> mContactInfoMap;
  private DataSetObservable mObservable = new DataSetObservable();
  private Set<String> mSenders;
  
  protected AbstractConversationViewFragment$ContactLoaderCallbacks(AbstractConversationViewFragment paramAbstractConversationViewFragment) {}
  
  public ContactInfo getContactInfo(String paramString)
  {
    if (mContactInfoMap == null) {
      return null;
    }
    return (ContactInfo)mContactInfoMap.get(paramString);
  }
  
  public Loader<ImmutableMap<String, ContactInfo>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new SenderInfoLoader(this$0.mActivity.getActivityContext(), mSenders);
  }
  
  public void onLoadFinished(Loader<ImmutableMap<String, ContactInfo>> paramLoader, ImmutableMap<String, ContactInfo> paramImmutableMap)
  {
    mContactInfoMap = paramImmutableMap;
    mObservable.notifyChanged();
  }
  
  public void onLoaderReset(Loader<ImmutableMap<String, ContactInfo>> paramLoader) {}
  
  public void registerObserver(DataSetObserver paramDataSetObserver)
  {
    mObservable.registerObserver(paramDataSetObserver);
  }
  
  public void setSenders(Set<String> paramSet)
  {
    mSenders = paramSet;
  }
  
  public void unregisterObserver(DataSetObserver paramDataSetObserver)
  {
    mObservable.unregisterObserver(paramDataSetObserver);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractConversationViewFragment.ContactLoaderCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */