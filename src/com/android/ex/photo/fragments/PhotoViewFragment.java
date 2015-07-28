package com.android.ex.photo.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.ex.photo.PhotoViewActivity;
import com.android.ex.photo.PhotoViewActivity.CursorChangedListener;
import com.android.ex.photo.PhotoViewActivity.OnScreenListener;
import com.android.ex.photo.R.drawable;
import com.android.ex.photo.R.id;
import com.android.ex.photo.R.layout;
import com.android.ex.photo.adapters.PhotoPagerAdapter;
import com.android.ex.photo.loaders.PhotoBitmapLoader;
import com.android.ex.photo.util.ImageUtils;
import com.android.ex.photo.util.ImageUtils.ImageSize;
import com.android.ex.photo.views.PhotoView;
import com.android.ex.photo.views.ProgressBarWrapper;

public class PhotoViewFragment
  extends Fragment
  implements LoaderManager.LoaderCallbacks<Bitmap>, View.OnClickListener, PhotoViewActivity.OnScreenListener, PhotoViewActivity.CursorChangedListener
{
  public static Integer sPhotoSize;
  private PhotoPagerAdapter mAdapter;
  private PhotoViewActivity mCallback;
  private TextView mEmptyText;
  private boolean mFullScreen;
  private Intent mIntent;
  private View mPhotoPreviewAndProgress;
  private ImageView mPhotoPreviewImage;
  private ProgressBarWrapper mPhotoProgressBar;
  private PhotoView mPhotoView;
  private final int mPosition;
  private boolean mProgressBarNeeded = true;
  private String mResolvedPhotoUri;
  private ImageView mRetryButton;
  private String mThumbnailUri;
  
  public PhotoViewFragment()
  {
    mPosition = -1;
    mProgressBarNeeded = true;
  }
  
  public PhotoViewFragment(Intent paramIntent, int paramInt, PhotoPagerAdapter paramPhotoPagerAdapter)
  {
    mIntent = paramIntent;
    mPosition = paramInt;
    mAdapter = paramPhotoPagerAdapter;
    mProgressBarNeeded = true;
  }
  
  private void bindPhoto(Bitmap paramBitmap)
  {
    if (mPhotoView != null) {
      mPhotoView.bindPhoto(paramBitmap);
    }
  }
  
  private void resetPhotoView()
  {
    if (mPhotoView != null) {
      mPhotoView.bindPhoto(null);
    }
  }
  
  private void setViewVisibility()
  {
    setFullScreen(mCallback.isFragmentFullScreen(this));
  }
  
  public TextView getEmptyText()
  {
    return mEmptyText;
  }
  
  public ProgressBarWrapper getPhotoProgressBar()
  {
    return mPhotoProgressBar;
  }
  
  public ImageView getRetryButton()
  {
    return mRetryButton;
  }
  
  public boolean isPhotoBound()
  {
    return (mPhotoView != null) && (mPhotoView.isPhotoBound());
  }
  
  public boolean isProgressBarNeeded()
  {
    return mProgressBarNeeded;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    mCallback = ((PhotoViewActivity)paramActivity);
    if (mCallback == null) {
      throw new IllegalArgumentException("Activity must be a derived class of PhotoViewActivity");
    }
    ImageUtils.ImageSize localImageSize;
    if (sPhotoSize == null)
    {
      paramActivity = new DisplayMetrics();
      WindowManager localWindowManager = (WindowManager)getActivity().getSystemService("window");
      localImageSize = ImageUtils.sUseImageSize;
      localWindowManager.getDefaultDisplay().getMetrics(paramActivity);
    }
    switch (localImageSize)
    {
    default: 
      sPhotoSize = Integer.valueOf(Math.min(heightPixels, widthPixels));
      return;
    }
    sPhotoSize = Integer.valueOf(Math.min(heightPixels, widthPixels) * 800 / 1000);
  }
  
  public void onClick(View paramView)
  {
    mCallback.toggleFullScreen();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBundle("com.android.mail.photo.fragments.PhotoViewFragment.INTENT");
      if (paramBundle != null) {
        mIntent = new Intent().putExtras(paramBundle);
      }
    }
    if (mIntent != null)
    {
      mResolvedPhotoUri = mIntent.getStringExtra("resolved_photo_uri");
      mThumbnailUri = mIntent.getStringExtra("thumbnail_uri");
    }
  }
  
  public Loader<Bitmap> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new PhotoBitmapLoader(getActivity(), mResolvedPhotoUri);
    }
    return new PhotoBitmapLoader(getActivity(), mThumbnailUri);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.photo_fragment_view, paramViewGroup, false);
    mPhotoView = ((PhotoView)paramLayoutInflater.findViewById(R.id.photo_view));
    mPhotoView.setOnClickListener(this);
    mPhotoView.setFullScreen(mFullScreen, false);
    mPhotoView.enableImageTransforms(true);
    mPhotoPreviewAndProgress = paramLayoutInflater.findViewById(R.id.photo_preview);
    mPhotoPreviewImage = ((ImageView)paramLayoutInflater.findViewById(R.id.photo_preview_image));
    paramViewGroup = (ProgressBar)paramLayoutInflater.findViewById(R.id.indeterminate_progress);
    mPhotoProgressBar = new ProgressBarWrapper((ProgressBar)paramLayoutInflater.findViewById(R.id.determinate_progress), paramViewGroup, true);
    mEmptyText = ((TextView)paramLayoutInflater.findViewById(R.id.empty_text));
    mRetryButton = ((ImageView)paramLayoutInflater.findViewById(R.id.retry_button));
    setViewVisibility();
    return paramLayoutInflater;
  }
  
  public void onCursorChanged(Cursor paramCursor)
  {
    if ((paramCursor.moveToPosition(mPosition)) && (!isPhotoBound()))
    {
      localObject = getLoaderManager().getLoader(1);
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    Object localObject = (PhotoBitmapLoader)localObject;
    mResolvedPhotoUri = mAdapter.getPhotoUri(paramCursor);
    ((PhotoBitmapLoader)localObject).setPhotoUri(mResolvedPhotoUri);
    ((PhotoBitmapLoader)localObject).forceLoad();
  }
  
  public void onDestroyView()
  {
    if (mPhotoView != null)
    {
      mPhotoView.clear();
      mPhotoView = null;
    }
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    mCallback = null;
    super.onDetach();
  }
  
  public void onFullScreenChanged(boolean paramBoolean)
  {
    setViewVisibility();
  }
  
  public boolean onInterceptMoveLeft(float paramFloat1, float paramFloat2)
  {
    if (!mCallback.isFragmentActive(this)) {}
    while ((mPhotoView == null) || (!mPhotoView.interceptMoveLeft(paramFloat1, paramFloat2))) {
      return false;
    }
    return true;
  }
  
  public boolean onInterceptMoveRight(float paramFloat1, float paramFloat2)
  {
    if (!mCallback.isFragmentActive(this)) {}
    while ((mPhotoView == null) || (!mPhotoView.interceptMoveRight(paramFloat1, paramFloat2))) {
      return false;
    }
    return true;
  }
  
  public void onLoadFinished(Loader<Bitmap> paramLoader, Bitmap paramBitmap)
  {
    if (getView() == null) {
      return;
    }
    switch (paramLoader.getId())
    {
    default: 
    case 1: 
      for (;;)
      {
        if (!mProgressBarNeeded) {
          mPhotoProgressBar.setVisibility(8);
        }
        if (paramBitmap != null) {
          mCallback.onNewPhotoLoaded();
        }
        setViewVisibility();
        return;
        if (paramBitmap != null)
        {
          bindPhoto(paramBitmap);
          mPhotoPreviewAndProgress.setVisibility(8);
          mProgressBarNeeded = false;
        }
      }
    }
    if (isPhotoBound())
    {
      mPhotoPreviewAndProgress.setVisibility(8);
      mProgressBarNeeded = false;
      return;
    }
    mPhotoPreviewImage.setVisibility(0);
    if (paramBitmap == null)
    {
      mPhotoPreviewImage.setImageResource(R.drawable.default_image);
      mPhotoPreviewImage.setScaleType(ImageView.ScaleType.CENTER);
    }
    for (;;)
    {
      getLoaderManager().initLoader(1, null, this);
      break;
      mPhotoPreviewImage.setImageBitmap(paramBitmap);
    }
  }
  
  public void onLoaderReset(Loader<Bitmap> paramLoader) {}
  
  public void onPause()
  {
    super.onPause();
    mCallback.removeCursorListener(this);
    mCallback.removeScreenListener(this);
    resetPhotoView();
  }
  
  public void onResume()
  {
    mCallback.addScreenListener(this);
    mCallback.addCursorListener(this);
    getLoaderManager().initLoader(2, null, this);
    super.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (mIntent != null) {
      paramBundle.putParcelable("com.android.mail.photo.fragments.PhotoViewFragment.INTENT", mIntent.getExtras());
    }
  }
  
  public void onViewActivated()
  {
    if (!mCallback.isFragmentActive(this))
    {
      resetViews();
      return;
    }
    if (!isPhotoBound()) {
      getLoaderManager().restartLoader(2, null, this);
    }
    mCallback.onFragmentVisible(this);
  }
  
  public void resetViews()
  {
    if (mPhotoView != null) {
      mPhotoView.resetTransformations();
    }
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    mFullScreen = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.fragments.PhotoViewFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */