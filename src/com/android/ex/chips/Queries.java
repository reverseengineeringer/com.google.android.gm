package com.android.ex.chips;

import android.content.res.Resources;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;

class Queries
{
  public static final Query EMAIL;
  public static final Query PHONE;
  
  static
  {
    Uri localUri1 = ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI;
    Uri localUri2 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    PHONE = new Query(new String[] { "display_name", "data1", "data2", "data3", "contact_id", "_id", "photo_thumb_uri", "display_name_source" }, localUri1, localUri2)
    {
      public CharSequence getTypeLabel(Resources paramAnonymousResources, int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        return ContactsContract.CommonDataKinds.Phone.getTypeLabel(paramAnonymousResources, paramAnonymousInt, paramAnonymousCharSequence);
      }
    };
    localUri1 = ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI;
    localUri2 = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
    EMAIL = new Query(new String[] { "display_name", "data1", "data2", "data3", "contact_id", "_id", "photo_thumb_uri", "display_name_source" }, localUri1, localUri2)
    {
      public CharSequence getTypeLabel(Resources paramAnonymousResources, int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        return ContactsContract.CommonDataKinds.Email.getTypeLabel(paramAnonymousResources, paramAnonymousInt, paramAnonymousCharSequence);
      }
    };
  }
  
  static abstract class Query
  {
    private final Uri mContentFilterUri;
    private final Uri mContentUri;
    private final String[] mProjection;
    
    public Query(String[] paramArrayOfString, Uri paramUri1, Uri paramUri2)
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
}

/* Location:
 * Qualified Name:     com.android.ex.chips.Queries
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */