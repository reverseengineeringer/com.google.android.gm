package com.android.ex.photo.adapters;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.LruCache;

class BaseFragmentPagerAdapter$FragmentCache
  extends LruCache<String, Fragment>
{
  public BaseFragmentPagerAdapter$FragmentCache(BaseFragmentPagerAdapter paramBaseFragmentPagerAdapter, int paramInt)
  {
    super(paramInt);
  }
  
  protected void entryRemoved(boolean paramBoolean, String paramString, Fragment paramFragment1, Fragment paramFragment2)
  {
    if ((paramBoolean) || ((paramFragment2 != null) && (paramFragment1 != paramFragment2))) {
      BaseFragmentPagerAdapter.access$000(this$0).remove(paramFragment1);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.adapters.BaseFragmentPagerAdapter.FragmentCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */