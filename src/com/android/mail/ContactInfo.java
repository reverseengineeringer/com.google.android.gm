package com.android.mail;

import android.graphics.Bitmap;
import android.net.Uri;

public class ContactInfo
{
  public final Uri contactUri;
  public final Bitmap photo;
  public final Integer status;
  
  public ContactInfo(Uri paramUri, Integer paramInteger, Bitmap paramBitmap)
  {
    contactUri = paramUri;
    status = paramInteger;
    photo = paramBitmap;
  }
  
  public String toString()
  {
    return "{status=" + status + " photo=" + photo + "}";
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ContactInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */