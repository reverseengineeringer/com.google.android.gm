package com.android.ex.chips;

import android.content.res.Resources;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;

final class Queries$1
  extends Queries.Query
{
  Queries$1(String[] paramArrayOfString, Uri paramUri1, Uri paramUri2)
  {
    super(paramArrayOfString, paramUri1, paramUri2);
  }
  
  public CharSequence getTypeLabel(Resources paramResources, int paramInt, CharSequence paramCharSequence)
  {
    return ContactsContract.CommonDataKinds.Phone.getTypeLabel(paramResources, paramInt, paramCharSequence);
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.Queries.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */