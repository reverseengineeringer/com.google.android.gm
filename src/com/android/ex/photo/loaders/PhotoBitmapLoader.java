package com.android.ex.photo.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.android.ex.photo.fragments.PhotoViewFragment;
import com.android.ex.photo.util.ImageUtils;

public class PhotoBitmapLoader
  extends AsyncTaskLoader<Bitmap>
{
  private Bitmap mBitmap;
  private String mPhotoUri;
  
  public PhotoBitmapLoader(Context paramContext, String paramString)
  {
    super(paramContext);
    mPhotoUri = paramString;
  }
  
  public void deliverResult(Bitmap paramBitmap)
  {
    if ((isReset()) && (paramBitmap != null)) {
      onReleaseResources(paramBitmap);
    }
    Bitmap localBitmap = mBitmap;
    mBitmap = paramBitmap;
    if (isStarted()) {
      super.deliverResult(paramBitmap);
    }
    if ((localBitmap != null) && (localBitmap != paramBitmap) && (!localBitmap.isRecycled())) {
      onReleaseResources(localBitmap);
    }
  }
  
  public Bitmap loadInBackground()
  {
    Object localObject = getContext();
    if ((localObject != null) && (mPhotoUri != null))
    {
      localObject = ImageUtils.createLocalBitmap(((Context)localObject).getContentResolver(), Uri.parse(mPhotoUri), PhotoViewFragment.sPhotoSize.intValue());
      if (localObject != null) {
        ((Bitmap)localObject).setDensity(160);
      }
      return (Bitmap)localObject;
    }
    return null;
  }
  
  public void onCanceled(Bitmap paramBitmap)
  {
    super.onCanceled(paramBitmap);
    onReleaseResources(paramBitmap);
  }
  
  protected void onReleaseResources(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    if (mBitmap != null)
    {
      onReleaseResources(mBitmap);
      mBitmap = null;
    }
  }
  
  protected void onStartLoading()
  {
    if (mBitmap != null) {
      deliverResult(mBitmap);
    }
    if ((takeContentChanged()) || (mBitmap == null)) {
      forceLoad();
    }
  }
  
  protected void onStopLoading()
  {
    cancelLoad();
  }
  
  public void setPhotoUri(String paramString)
  {
    mPhotoUri = paramString;
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.loaders.PhotoBitmapLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */