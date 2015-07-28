package com.android.ex.photo.provider;

public final class PhotoContract
{
  public static abstract interface PhotoQuery
  {
    public static final String[] PROJECTION = { "uri", "_display_name", "contentUri", "thumbnailUri", "contentType" };
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.provider.PhotoContract
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */