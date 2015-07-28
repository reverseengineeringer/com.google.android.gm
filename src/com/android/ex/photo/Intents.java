package com.android.ex.photo;

import android.content.Context;
import android.content.Intent;
import com.android.ex.photo.fragments.PhotoViewFragment;

public class Intents
{
  public static PhotoViewIntentBuilder newPhotoViewFragmentIntentBuilder(Context paramContext)
  {
    return new PhotoViewIntentBuilder(paramContext, PhotoViewFragment.class, null);
  }
  
  public static PhotoViewIntentBuilder newPhotoViewIntentBuilder(Context paramContext, Class<? extends PhotoViewActivity> paramClass)
  {
    return new PhotoViewIntentBuilder(paramContext, paramClass, null);
  }
  
  public static class PhotoViewIntentBuilder
  {
    private final Intent mIntent;
    private Integer mPhotoIndex;
    private String mPhotosUri;
    private String[] mProjection;
    private String mResolvedPhotoUri;
    private String mThumbnailUri;
    
    private PhotoViewIntentBuilder(Context paramContext, Class<?> paramClass)
    {
      mIntent = new Intent(paramContext, paramClass);
    }
    
    public Intent build()
    {
      mIntent.setAction("android.intent.action.VIEW");
      mIntent.setFlags(524288);
      if (mPhotoIndex != null) {
        mIntent.putExtra("photo_index", mPhotoIndex.intValue());
      }
      if (mPhotosUri != null) {
        mIntent.putExtra("photos_uri", mPhotosUri);
      }
      if (mResolvedPhotoUri != null) {
        mIntent.putExtra("resolved_photo_uri", mResolvedPhotoUri);
      }
      if (mProjection != null) {
        mIntent.putExtra("projection", mProjection);
      }
      if (mThumbnailUri != null) {
        mIntent.putExtra("thumbnail_uri", mThumbnailUri);
      }
      return mIntent;
    }
    
    public PhotoViewIntentBuilder setPhotoIndex(Integer paramInteger)
    {
      mPhotoIndex = paramInteger;
      return this;
    }
    
    public PhotoViewIntentBuilder setPhotosUri(String paramString)
    {
      mPhotosUri = paramString;
      return this;
    }
    
    public PhotoViewIntentBuilder setProjection(String[] paramArrayOfString)
    {
      mProjection = paramArrayOfString;
      return this;
    }
    
    public PhotoViewIntentBuilder setResolvedPhotoUri(String paramString)
    {
      mResolvedPhotoUri = paramString;
      return this;
    }
    
    public PhotoViewIntentBuilder setThumbnailUri(String paramString)
    {
      mThumbnailUri = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.Intents
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */