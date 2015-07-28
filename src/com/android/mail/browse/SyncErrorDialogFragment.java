package com.android.mail.browse;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;

public class SyncErrorDialogFragment
  extends DialogFragment
{
  public static SyncErrorDialogFragment newInstance()
  {
    return new SyncErrorDialogFragment();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    new AlertDialog.Builder(getActivity()).setTitle(2131493112).setMessage(2131493113).setPositiveButton(2131493074, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    }).setNegativeButton(2131493114, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Intent localIntent = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
        localIntent.addFlags(524288);
        startActivity(localIntent);
        paramAnonymousDialogInterface.dismiss();
      }
    }).create();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SyncErrorDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */