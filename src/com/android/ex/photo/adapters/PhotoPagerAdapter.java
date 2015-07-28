package com.android.ex.photo.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.database.Cursor;
import com.android.ex.photo.Intents;
import com.android.ex.photo.Intents.PhotoViewIntentBuilder;
import com.android.ex.photo.fragments.PhotoViewFragment;

public class PhotoPagerAdapter
  extends BaseCursorPagerAdapter
{
  private int mContentUriIndex;
  private int mThumbnailUriIndex;
  
  public PhotoPagerAdapter(Context paramContext, FragmentManager paramFragmentManager, Cursor paramCursor)
  {
    super(paramContext, paramFragmentManager, paramCursor);
  }
  
  public Fragment getItem(Context paramContext, Cursor paramCursor, int paramInt)
  {
    paramContext = paramCursor.getString(mContentUriIndex);
    paramCursor = paramCursor.getString(mThumbnailUriIndex);
    Intents.PhotoViewIntentBuilder localPhotoViewIntentBuilder = Intents.newPhotoViewFragmentIntentBuilder(mContext);
    localPhotoViewIntentBuilder.setResolvedPhotoUri(paramContext).setThumbnailUri(paramCursor);
    return new PhotoViewFragment(localPhotoViewIntentBuilder.build(), paramInt, this);
  }
  
  public String getPhotoUri(Cursor paramCursor)
  {
    return paramCursor.getString(mContentUriIndex);
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    if (paramCursor != null) {
      mContentUriIndex = paramCursor.getColumnIndex("contentUri");
    }
    for (mThumbnailUriIndex = paramCursor.getColumnIndex("thumbnailUri");; mThumbnailUriIndex = -1)
    {
      return super.swapCursor(paramCursor);
      mContentUriIndex = -1;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.adapters.PhotoPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */