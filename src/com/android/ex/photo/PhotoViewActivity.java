package com.android.ex.photo;

import android.app.ActionBar;
import android.app.ActionBar.OnMenuVisibilityListener;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Fragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.android.ex.photo.adapters.PhotoPagerAdapter;
import com.android.ex.photo.fragments.PhotoViewFragment;
import com.android.ex.photo.loaders.PhotoPagerLoader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PhotoViewActivity
  extends Activity
  implements LoaderManager.LoaderCallbacks<Cursor>, ViewPager.OnPageChangeListener, PhotoViewPager.OnInterceptTouchListener, ActionBar.OnMenuVisibilityListener
{
  public static int sMemoryClass;
  private long mActionBarHideDelayTime;
  private Runnable mActionBarHideRunnable = new Runnable()
  {
    public void run()
    {
      PhotoViewActivity.this.setLightsOutMode(true);
    }
  };
  private PhotoPagerAdapter mAdapter;
  private int mAlbumCount = -1;
  private Set<CursorChangedListener> mCursorListeners = new HashSet();
  private boolean mFullScreen;
  private final Handler mHandler = new Handler();
  private boolean mIsEmpty;
  private boolean mIsPaused = true;
  private int mPhotoIndex;
  private String mPhotosUri;
  private String[] mProjection;
  private boolean mRestartLoader;
  private Set<OnScreenListener> mScreenListeners = new HashSet();
  private PhotoViewPager mViewPager;
  
  private void cancelActionBarHideRunnable()
  {
    mHandler.removeCallbacks(mActionBarHideRunnable);
  }
  
  private void notifyCursorListeners(Cursor paramCursor)
  {
    try
    {
      Iterator localIterator = mCursorListeners.iterator();
      while (localIterator.hasNext()) {
        ((CursorChangedListener)localIterator.next()).onCursorChanged(paramCursor);
      }
    }
    finally {}
  }
  
  private void postActionBarHideRunnableWithDelay()
  {
    mHandler.postDelayed(mActionBarHideRunnable, mActionBarHideDelayTime);
  }
  
  private void setFullScreen(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1 != mFullScreen)
    {
      i = 1;
      mFullScreen = paramBoolean1;
      if (!mFullScreen) {
        break label83;
      }
      setLightsOutMode(true);
      cancelActionBarHideRunnable();
    }
    for (;;)
    {
      if (i == 0) {
        return;
      }
      Iterator localIterator = mScreenListeners.iterator();
      while (localIterator.hasNext()) {
        ((OnScreenListener)localIterator.next()).onFullScreenChanged(mFullScreen);
      }
      i = 0;
      break;
      label83:
      setLightsOutMode(false);
      if (paramBoolean2) {
        postActionBarHideRunnableWithDelay();
      }
    }
  }
  
  private void setLightsOutMode(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (paramBoolean) {}
      for (i = 1285;; i = 1280)
      {
        mViewPager.setSystemUiVisibility(i);
        return;
      }
    }
    ActionBar localActionBar = getActionBar();
    if (paramBoolean)
    {
      localActionBar.hide();
      if (!paramBoolean) {
        break label67;
      }
    }
    label67:
    for (int i = 1;; i = 0)
    {
      mViewPager.setSystemUiVisibility(i);
      return;
      localActionBar.show();
      break;
    }
  }
  
  public void addCursorListener(CursorChangedListener paramCursorChangedListener)
  {
    try
    {
      mCursorListeners.add(paramCursorChangedListener);
      return;
    }
    finally
    {
      paramCursorChangedListener = finally;
      throw paramCursorChangedListener;
    }
  }
  
  public void addScreenListener(OnScreenListener paramOnScreenListener)
  {
    mScreenListeners.add(paramOnScreenListener);
  }
  
  public Cursor getCursor()
  {
    if (mAdapter == null) {
      return null;
    }
    return mAdapter.getCursor();
  }
  
  public Cursor getCursorAtProperPosition()
  {
    if (mViewPager == null) {
      return null;
    }
    int i = mViewPager.getCurrentItem();
    Cursor localCursor = mAdapter.getCursor();
    if (localCursor == null) {
      return null;
    }
    localCursor.moveToPosition(i);
    return localCursor;
  }
  
  public boolean isFragmentActive(Fragment paramFragment)
  {
    if ((mViewPager == null) || (mAdapter == null)) {}
    while (mViewPager.getCurrentItem() != mAdapter.getItemPosition(paramFragment)) {
      return false;
    }
    return true;
  }
  
  public boolean isFragmentFullScreen(Fragment paramFragment)
  {
    if ((mViewPager == null) || (mAdapter == null) || (mAdapter.getCount() == 0)) {
      return mFullScreen;
    }
    return (mFullScreen) || (mViewPager.getCurrentItem() != mAdapter.getItemPosition(paramFragment));
  }
  
  public void onBackPressed()
  {
    if (mFullScreen)
    {
      toggleFullScreen();
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    sMemoryClass = ((ActivityManager)getApplicationContext().getSystemService("activity")).getMemoryClass();
    Intent localIntent = getIntent();
    int i = -1;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("com.google.android.apps.plus.PhotoViewFragment.ITEM", -1);
      mFullScreen = paramBundle.getBoolean("com.google.android.apps.plus.PhotoViewFragment.FULLSCREEN", false);
    }
    if (localIntent.hasExtra("photos_uri")) {
      mPhotosUri = localIntent.getStringExtra("photos_uri");
    }
    if (localIntent.hasExtra("projection")) {}
    for (mProjection = localIntent.getStringArrayExtra("projection");; mProjection = null)
    {
      int j = i;
      if (localIntent.hasExtra("photo_index"))
      {
        j = i;
        if (i < 0) {
          j = localIntent.getIntExtra("photo_index", -1);
        }
      }
      mPhotoIndex = j;
      setContentView(R.layout.photo_activity_view);
      mAdapter = new PhotoPagerAdapter(this, getFragmentManager(), null);
      mViewPager = ((PhotoViewPager)findViewById(R.id.photo_view_pager));
      mViewPager.setAdapter(mAdapter);
      mViewPager.setOnPageChangeListener(this);
      mViewPager.setOnInterceptTouchListener(this);
      getLoaderManager().initLoader(1, null, this);
      paramBundle = getActionBar();
      paramBundle.setDisplayHomeAsUpEnabled(true);
      mActionBarHideDelayTime = getResources().getInteger(R.integer.action_bar_delay_time_in_millis);
      paramBundle.addOnMenuVisibilityListener(this);
      paramBundle.setDisplayOptions(0, 8);
      return;
    }
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 1) {
      return new PhotoPagerLoader(this, Uri.parse(mPhotosUri), mProjection);
    }
    return null;
  }
  
  public void onFragmentVisible(PhotoViewFragment paramPhotoViewFragment)
  {
    updateActionBar(paramPhotoViewFragment);
  }
  
  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    if (paramLoader.getId() == 1)
    {
      if ((paramCursor != null) && (paramCursor.getCount() != 0)) {
        break label31;
      }
      mIsEmpty = true;
    }
    for (;;)
    {
      updateActionItems();
      return;
      label31:
      mAlbumCount = paramCursor.getCount();
      if (mIsPaused)
      {
        mRestartLoader = true;
        return;
      }
      mIsEmpty = false;
      int j = mPhotoIndex;
      int i = j;
      if (j < 0) {
        i = 0;
      }
      mAdapter.swapCursor(paramCursor);
      notifyCursorListeners(paramCursor);
      mViewPager.setCurrentItem(i, false);
      setViewActivated();
    }
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  public void onMenuVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      cancelActionBarHideRunnable();
      return;
    }
    postActionBarHideRunnableWithDelay();
  }
  
  public void onNewPhotoLoaded() {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    mPhotoIndex = paramInt;
    setViewActivated();
  }
  
  protected void onPause()
  {
    mIsPaused = true;
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    setFullScreen(mFullScreen, false);
    mIsPaused = false;
    if (mRestartLoader)
    {
      mRestartLoader = false;
      getLoaderManager().restartLoader(1, null, this);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("com.google.android.apps.plus.PhotoViewFragment.ITEM", mViewPager.getCurrentItem());
    paramBundle.putBoolean("com.google.android.apps.plus.PhotoViewFragment.FULLSCREEN", mFullScreen);
  }
  
  public PhotoViewPager.InterceptType onTouchIntercept(float paramFloat1, float paramFloat2)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    Iterator localIterator = mScreenListeners.iterator();
    while (localIterator.hasNext())
    {
      OnScreenListener localOnScreenListener = (OnScreenListener)localIterator.next();
      boolean bool2 = bool3;
      if (!bool3) {
        bool2 = localOnScreenListener.onInterceptMoveLeft(paramFloat1, paramFloat2);
      }
      boolean bool4 = bool1;
      if (!bool1) {
        bool4 = localOnScreenListener.onInterceptMoveRight(paramFloat1, paramFloat2);
      }
      localOnScreenListener.onViewActivated();
      bool3 = bool2;
      bool1 = bool4;
    }
    if (bool3)
    {
      if (bool1) {
        return PhotoViewPager.InterceptType.BOTH;
      }
      return PhotoViewPager.InterceptType.LEFT;
    }
    if (bool1) {
      return PhotoViewPager.InterceptType.RIGHT;
    }
    return PhotoViewPager.InterceptType.NONE;
  }
  
  public void removeCursorListener(CursorChangedListener paramCursorChangedListener)
  {
    try
    {
      mCursorListeners.remove(paramCursorChangedListener);
      return;
    }
    finally
    {
      paramCursorChangedListener = finally;
      throw paramCursorChangedListener;
    }
  }
  
  public void removeScreenListener(OnScreenListener paramOnScreenListener)
  {
    mScreenListeners.remove(paramOnScreenListener);
  }
  
  public void setViewActivated()
  {
    Iterator localIterator = mScreenListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnScreenListener)localIterator.next()).onViewActivated();
    }
  }
  
  public void toggleFullScreen()
  {
    if (!mFullScreen) {}
    for (boolean bool = true;; bool = false)
    {
      setFullScreen(bool, true);
      return;
    }
  }
  
  protected void updateActionBar(PhotoViewFragment paramPhotoViewFragment)
  {
    int j = mViewPager.getCurrentItem() + 1;
    int i;
    if (mAlbumCount >= 0)
    {
      i = 1;
      paramPhotoViewFragment = getCursorAtProperPosition();
      if (paramPhotoViewFragment == null) {
        break label96;
      }
      paramPhotoViewFragment = paramPhotoViewFragment.getString(paramPhotoViewFragment.getColumnIndex("_display_name"));
      label44:
      if ((!mIsEmpty) && (i != 0) && (j > 0)) {
        break label101;
      }
    }
    label96:
    label101:
    for (Object localObject = null;; localObject = getResources().getString(R.string.photo_view_count, new Object[] { Integer.valueOf(j), Integer.valueOf(mAlbumCount) }))
    {
      ActionBar localActionBar = getActionBar();
      localActionBar.setDisplayOptions(8, 8);
      localActionBar.setTitle(paramPhotoViewFragment);
      localActionBar.setSubtitle((CharSequence)localObject);
      return;
      i = 0;
      break;
      paramPhotoViewFragment = null;
      break label44;
    }
  }
  
  protected void updateActionItems() {}
  
  public static abstract interface CursorChangedListener
  {
    public abstract void onCursorChanged(Cursor paramCursor);
  }
  
  public static abstract interface OnScreenListener
  {
    public abstract void onFullScreenChanged(boolean paramBoolean);
    
    public abstract boolean onInterceptMoveLeft(float paramFloat1, float paramFloat2);
    
    public abstract boolean onInterceptMoveRight(float paramFloat1, float paramFloat2);
    
    public abstract void onViewActivated();
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.PhotoViewActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */