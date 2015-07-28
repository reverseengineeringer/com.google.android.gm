package com.android.ex.photo.loaders;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.android.ex.photo.provider.PhotoContract.PhotoQuery;

public class PhotoPagerLoader
  extends CursorLoader
{
  private final Uri mPhotosUri;
  private final String[] mProjection;
  
  public PhotoPagerLoader(Context paramContext, Uri paramUri, String[] paramArrayOfString)
  {
    super(paramContext);
    mPhotosUri = paramUri;
    if (paramArrayOfString != null) {}
    for (;;)
    {
      mProjection = paramArrayOfString;
      return;
      paramArrayOfString = PhotoContract.PhotoQuery.PROJECTION;
    }
  }
  
  public Cursor loadInBackground()
  {
    setUri(mPhotosUri.buildUpon().appendQueryParameter("contentType", "image/").build());
    setProjection(mProjection);
    return super.loadInBackground();
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.loaders.PhotoPagerLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */