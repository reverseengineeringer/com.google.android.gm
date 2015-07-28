package com.android.mail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.android.mail.utils.LogUtils;

public abstract class FolderSelectionDialog
  implements DialogInterface.OnDismissListener
{
  private static boolean sDialogShown;
  
  protected static boolean isShown()
  {
    return sDialogShown;
  }
  
  public static void setDialogDismissed()
  {
    LogUtils.d("Gmail", "Folder Selection dialog dismissed", new Object[0]);
    sDialogShown = false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void show()
  {
    sDialogShown = true;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderSelectionDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */