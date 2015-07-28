package com.android.mail.ui;

import com.android.mail.providers.Folder;

public abstract interface ErrorListener
{
  public abstract void onError(Folder paramFolder, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ErrorListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */