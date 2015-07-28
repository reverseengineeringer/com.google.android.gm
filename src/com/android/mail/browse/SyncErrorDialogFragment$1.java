package com.android.mail.browse;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class SyncErrorDialogFragment$1
  implements DialogInterface.OnClickListener
{
  SyncErrorDialogFragment$1(SyncErrorDialogFragment paramSyncErrorDialogFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
    localIntent.addFlags(524288);
    this$0.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SyncErrorDialogFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */