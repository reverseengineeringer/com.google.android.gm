package com.android.ex.photo.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import java.util.HashMap;

public abstract class BaseCursorPagerAdapter
  extends BaseFragmentPagerAdapter
{
  Context mContext;
  private Cursor mCursor;
  private boolean mDataValid;
  private SparseIntArray mItemPosition;
  private HashMap<Object, Integer> mObjectRowMap = new HashMap();
  private int mRowIDColumn;
  
  public BaseCursorPagerAdapter(Context paramContext, FragmentManager paramFragmentManager, Cursor paramCursor)
  {
    super(paramFragmentManager);
    init(paramContext, paramCursor);
  }
  
  private void init(Context paramContext, Cursor paramCursor)
  {
    boolean bool;
    if (paramCursor != null)
    {
      bool = true;
      mCursor = paramCursor;
      mDataValid = bool;
      mContext = paramContext;
      if (!bool) {
        break label52;
      }
    }
    label52:
    for (int i = mCursor.getColumnIndex("uri");; i = -1)
    {
      mRowIDColumn = i;
      return;
      bool = false;
      break;
    }
  }
  
  private boolean moveCursorTo(int paramInt)
  {
    if ((mCursor != null) && (!mCursor.isClosed())) {
      return mCursor.moveToPosition(paramInt);
    }
    return false;
  }
  
  private void setItemPosition()
  {
    if ((!mDataValid) || (mCursor == null) || (mCursor.isClosed()))
    {
      mItemPosition = null;
      return;
    }
    SparseIntArray localSparseIntArray = new SparseIntArray(mCursor.getCount());
    mCursor.moveToPosition(-1);
    while (mCursor.moveToNext()) {
      localSparseIntArray.append(mCursor.getString(mRowIDColumn).hashCode(), mCursor.getPosition());
    }
    mItemPosition = localSparseIntArray;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    mObjectRowMap.remove(paramObject);
    super.destroyItem(paramView, paramInt, paramObject);
  }
  
  public int getCount()
  {
    if ((mDataValid) && (mCursor != null)) {
      return mCursor.getCount();
    }
    return 0;
  }
  
  public Cursor getCursor()
  {
    return mCursor;
  }
  
  public Fragment getItem(int paramInt)
  {
    if ((mDataValid) && (moveCursorTo(paramInt))) {
      return getItem(mContext, mCursor, paramInt);
    }
    return null;
  }
  
  public abstract Fragment getItem(Context paramContext, Cursor paramCursor, int paramInt);
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (Integer)mObjectRowMap.get(paramObject);
    if ((paramObject == null) || (mItemPosition == null)) {
      return -2;
    }
    return mItemPosition.get(((Integer)paramObject).intValue(), -2);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (!mDataValid) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (moveCursorTo(paramInt)) {}
    for (Integer localInteger = Integer.valueOf(mCursor.getString(mRowIDColumn).hashCode());; localInteger = null)
    {
      paramView = super.instantiateItem(paramView, paramInt);
      if (paramView != null) {
        mObjectRowMap.put(paramView, localInteger);
      }
      return paramView;
    }
  }
  
  protected String makeFragmentName(int paramInt1, int paramInt2)
  {
    if (moveCursorTo(paramInt2)) {
      return "android:pager:" + paramInt1 + ":" + mCursor.getString(mRowIDColumn).hashCode();
    }
    return super.makeFragmentName(paramInt1, paramInt2);
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    if (Log.isLoggable("BaseCursorPagerAdapter", 2))
    {
      localObject = new StringBuilder().append("swapCursor old=");
      if (mCursor != null) {
        break label72;
      }
      i = -1;
      localObject = ((StringBuilder)localObject).append(i).append("; new=");
      if (paramCursor != null) {
        break label85;
      }
    }
    label72:
    label85:
    for (int i = -1;; i = paramCursor.getCount())
    {
      Log.v("BaseCursorPagerAdapter", i);
      if (paramCursor != mCursor) {
        break label95;
      }
      return null;
      i = mCursor.getCount();
      break;
    }
    label95:
    Object localObject = mCursor;
    mCursor = paramCursor;
    if (paramCursor != null) {
      mRowIDColumn = paramCursor.getColumnIndex("uri");
    }
    for (mDataValid = true;; mDataValid = false)
    {
      setItemPosition();
      notifyDataSetChanged();
      return (Cursor)localObject;
      mRowIDColumn = -1;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.adapters.BaseCursorPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */