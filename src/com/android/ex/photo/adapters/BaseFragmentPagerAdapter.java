package com.android.ex.photo.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.LruCache;
import android.view.View;

public abstract class BaseFragmentPagerAdapter
  extends PagerAdapter
{
  private FragmentTransaction mCurTransaction = null;
  private Fragment mCurrentPrimaryItem = null;
  private LruCache<String, Fragment> mFragmentCache = new FragmentCache(5);
  private final FragmentManager mFragmentManager;
  
  public BaseFragmentPagerAdapter(FragmentManager paramFragmentManager)
  {
    mFragmentManager = paramFragmentManager;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (mCurTransaction == null) {
      mCurTransaction = mFragmentManager.beginTransaction();
    }
    Fragment localFragment = (Fragment)paramObject;
    String str = localFragment.getTag();
    paramObject = str;
    if (str == null) {
      paramObject = makeFragmentName(paramView.getId(), paramInt);
    }
    mFragmentCache.put(paramObject, localFragment);
    mCurTransaction.detach(localFragment);
  }
  
  public void finishUpdate(View paramView)
  {
    if (mCurTransaction != null)
    {
      mCurTransaction.commitAllowingStateLoss();
      mCurTransaction = null;
      mFragmentManager.executePendingTransactions();
    }
  }
  
  public abstract Fragment getItem(int paramInt);
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (mCurTransaction == null) {
      mCurTransaction = mFragmentManager.beginTransaction();
    }
    Object localObject = makeFragmentName(paramView.getId(), paramInt);
    mFragmentCache.remove(localObject);
    localObject = mFragmentManager.findFragmentByTag((String)localObject);
    if (localObject != null) {
      mCurTransaction.attach((Fragment)localObject);
    }
    for (paramView = (View)localObject;; paramView = (View)localObject)
    {
      if (paramView != mCurrentPrimaryItem) {
        paramView.setMenuVisibility(false);
      }
      return paramView;
      localObject = getItem(paramInt);
      mCurTransaction.add(paramView.getId(), (Fragment)localObject, makeFragmentName(paramView.getId(), paramInt));
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    paramObject = ((Fragment)paramObject).getView();
    while ((paramView instanceof View))
    {
      if (paramView == paramObject) {
        return true;
      }
      paramView = ((View)paramView).getParent();
    }
    return false;
  }
  
  protected String makeFragmentName(int paramInt1, int paramInt2)
  {
    return "android:switcher:" + paramInt1 + ":" + paramInt2;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
  }
  
  public void setPrimaryItem(View paramView, int paramInt, Object paramObject)
  {
    paramView = (Fragment)paramObject;
    if (paramView != mCurrentPrimaryItem)
    {
      if (mCurrentPrimaryItem != null) {
        mCurrentPrimaryItem.setMenuVisibility(false);
      }
      if (paramView != null) {
        paramView.setMenuVisibility(true);
      }
      mCurrentPrimaryItem = paramView;
    }
  }
  
  public void startUpdate(View paramView) {}
  
  private class FragmentCache
    extends LruCache<String, Fragment>
  {
    public FragmentCache(int paramInt)
    {
      super();
    }
    
    protected void entryRemoved(boolean paramBoolean, String paramString, Fragment paramFragment1, Fragment paramFragment2)
    {
      if ((paramBoolean) || ((paramFragment2 != null) && (paramFragment1 != paramFragment2))) {
        mCurTransaction.remove(paramFragment1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.adapters.BaseFragmentPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */