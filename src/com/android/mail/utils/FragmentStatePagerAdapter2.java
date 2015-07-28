package com.android.mail.utils;

import android.app.Fragment;
import android.app.Fragment.SavedState;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v13.app.FragmentCompat;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentStatePagerAdapter2
  extends PagerAdapter
{
  private FragmentTransaction mCurTransaction = null;
  private Fragment mCurrentPrimaryItem = null;
  private boolean mEnableSavedStates;
  private final FragmentManager mFragmentManager;
  private SparseArrayCompat<Fragment> mFragments = new SparseArrayCompat();
  private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();
  
  public FragmentStatePagerAdapter2(FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    mFragmentManager = paramFragmentManager;
    mEnableSavedStates = paramBoolean;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (mCurTransaction == null) {
      mCurTransaction = mFragmentManager.beginTransaction();
    }
    if (mEnableSavedStates)
    {
      while (mSavedState.size() <= paramInt) {
        mSavedState.add(null);
      }
      mSavedState.set(paramInt, mFragmentManager.saveFragmentInstanceState(paramViewGroup));
    }
    mFragments.delete(paramInt);
    mCurTransaction.remove(paramViewGroup);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (mCurTransaction != null)
    {
      mCurTransaction.commitAllowingStateLoss();
      mCurTransaction = null;
      mFragmentManager.executePendingTransactions();
    }
  }
  
  public Fragment getFragmentAt(int paramInt)
  {
    return (Fragment)mFragments.get(paramInt);
  }
  
  public abstract Fragment getItem(int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Fragment localFragment = (Fragment)mFragments.get(paramInt);
    if (localFragment != null) {
      return localFragment;
    }
    if (mCurTransaction == null) {
      mCurTransaction = mFragmentManager.beginTransaction();
    }
    localFragment = getItem(paramInt);
    if ((mEnableSavedStates) && (mSavedState.size() > paramInt))
    {
      Fragment.SavedState localSavedState = (Fragment.SavedState)mSavedState.get(paramInt);
      if (localSavedState != null) {
        localFragment.setInitialSavedState(localSavedState);
      }
    }
    if (localFragment != mCurrentPrimaryItem) {
      setItemVisible(localFragment, false);
    }
    mFragments.put(paramInt, localFragment);
    mCurTransaction.add(paramViewGroup.getId(), localFragment);
    return localFragment;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void notifyDataSetChanged()
  {
    SparseArrayCompat localSparseArrayCompat = new SparseArrayCompat(mFragments.size());
    int i = 0;
    if (i < mFragments.size())
    {
      int j = mFragments.keyAt(i);
      Fragment localFragment = (Fragment)mFragments.valueAt(i);
      int k = getItemPosition(localFragment);
      if (k != -2)
      {
        if (k < 0) {
          break label85;
        }
        j = k;
      }
      label85:
      for (;;)
      {
        localSparseArrayCompat.put(j, localFragment);
        i += 1;
        break;
      }
    }
    mFragments = localSparseArrayCompat;
    super.notifyDataSetChanged();
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      mFragments.clear();
      int i;
      if (mEnableSavedStates)
      {
        paramClassLoader = paramParcelable.getParcelableArray("states");
        mSavedState.clear();
        if (paramClassLoader != null)
        {
          i = 0;
          while (i < paramClassLoader.length)
          {
            mSavedState.add((Fragment.SavedState)paramClassLoader[i]);
            i += 1;
          }
        }
      }
      paramClassLoader = paramParcelable.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        String str = (String)paramClassLoader.next();
        if (str.startsWith("f"))
        {
          i = Integer.parseInt(str.substring(1));
          Fragment localFragment = mFragmentManager.getFragment(paramParcelable, str);
          if (localFragment != null)
          {
            setItemVisible(localFragment, false);
            mFragments.put(i, localFragment);
          }
          else
          {
            Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
          }
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (mEnableSavedStates)
    {
      localObject1 = localObject2;
      if (mSavedState.size() > 0)
      {
        localObject1 = new Bundle();
        localObject2 = new Fragment.SavedState[mSavedState.size()];
        mSavedState.toArray((Object[])localObject2);
        ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
      }
    }
    int i = 0;
    for (localObject2 = localObject1; i < mFragments.size(); localObject2 = localObject1)
    {
      int j = mFragments.keyAt(i);
      Fragment localFragment = (Fragment)mFragments.valueAt(i);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      localObject2 = "f" + j;
      mFragmentManager.putFragment((Bundle)localObject1, (String)localObject2, localFragment);
      i += 1;
    }
    return (Parcelable)localObject2;
  }
  
  public void setItemVisible(Fragment paramFragment, boolean paramBoolean)
  {
    FragmentCompat.setMenuVisibility(paramFragment, paramBoolean);
    FragmentCompat.setUserVisibleHint(paramFragment, paramBoolean);
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != mCurrentPrimaryItem)
    {
      if (mCurrentPrimaryItem != null) {
        setItemVisible(mCurrentPrimaryItem, false);
      }
      if (paramViewGroup != null) {
        setItemVisible(paramViewGroup, true);
      }
      mCurrentPrimaryItem = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup) {}
}

/* Location:
 * Qualified Name:     com.android.mail.utils.FragmentStatePagerAdapter2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */