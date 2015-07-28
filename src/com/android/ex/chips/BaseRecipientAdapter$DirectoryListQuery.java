package com.android.ex.chips;

import android.net.Uri;
import android.provider.ContactsContract;

class BaseRecipientAdapter$DirectoryListQuery
{
  public static final String[] PROJECTION = { "_id", "accountName", "accountType", "displayName", "packageName", "typeResourceId" };
  public static final Uri URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "directories");
}

/* Location:
 * Qualified Name:     com.android.ex.chips.BaseRecipientAdapter.DirectoryListQuery
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */