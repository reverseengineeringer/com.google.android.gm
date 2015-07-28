package com.android.ex.chips;

import android.content.res.Resources;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;

final class Queries$2
  extends Queries.Query
{
  Queries$2(String[] paramArrayOfString, Uri paramUri1, Uri paramUri2)
  {
    super(paramArrayOfString, paramUri1, paramUri2);
  }
  
  public CharSequence getTypeLabel(Resources paramResources, int paramInt, CharSequence paramCharSequence)
  {
    return ContactsContract.CommonDataKinds.Email.getTypeLabel(paramResources, paramInt, paramCharSequence);
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.Queries.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */