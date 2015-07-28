package com.android.ex.chips;

import android.content.res.Resources;
import android.net.Uri;

abstract class Queries$Query
{
  private final Uri mContentFilterUri;
  private final Uri mContentUri;
  private final String[] mProjection;
  
  public Queries$Query(String[] paramArrayOfString, Uri paramUri1, Uri paramUri2)
  {
    mProjection = paramArrayOfString;
    mContentFilterUri = paramUri1;
    mContentUri = paramUri2;
  }
  
  public Uri getContentFilterUri()
  {
    return mContentFilterUri;
  }
  
  public Uri getContentUri()
  {
    return mContentUri;
  }
  
  public String[] getProjection()
  {
    return mProjection;
  }
  
  public abstract CharSequence getTypeLabel(Resources paramResources, int paramInt, CharSequence paramCharSequence);
}

/* Location:
 * Qualified Name:     com.android.ex.chips.Queries.Query
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */