package com.android.email.activity.setup;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity.Header;
import aqz;
import arh;
import avs;
import com.android.mail.drawer.CurrentFolderDialogState;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import cpd;
import cpe;
import crz;
import java.util.Arrays;

public class EmailFolderSettingsActivity
  extends crz
  implements cpd, cpe
{
  static boolean a;
  private cpe f;
  
  public static void a(Context paramContext, ListPreference paramListPreference, int paramInt, boolean paramBoolean)
  {
    paramContext = paramContext.getResources();
    CharSequence[] arrayOfCharSequence1;
    if (paramBoolean)
    {
      arrayOfCharSequence1 = paramContext.getTextArray(aqz.b);
      paramContext = paramContext.getTextArray(aqz.d);
    }
    for (int i = 1;; i = 0)
    {
      CharSequence[] arrayOfCharSequence2 = arrayOfCharSequence1;
      Object localObject = paramContext;
      if (paramInt > 0)
      {
        paramInt = i + paramInt;
        arrayOfCharSequence2 = (CharSequence[])Arrays.copyOf(arrayOfCharSequence1, paramInt);
        localObject = (CharSequence[])Arrays.copyOf(paramContext, paramInt);
      }
      paramListPreference.setEntries(arrayOfCharSequence2);
      paramListPreference.setEntryValues((CharSequence[])localObject);
      paramListPreference.setSummary(paramListPreference.getEntry());
      return;
      arrayOfCharSequence1 = paramContext.getTextArray(aqz.a);
      paramContext = paramContext.getTextArray(aqz.c);
    }
  }
  
  public final PreferenceActivity.Header a()
  {
    PreferenceActivity.Header localHeader = new PreferenceActivity.Header();
    titleRes = arh.bC;
    fragment = avs.class.getName();
    long l = d;
    Account localAccount = c;
    boolean bool = a;
    Bundle localBundle = new Bundle(3);
    localBundle.putLong("MailboxId", l);
    localBundle.putParcelable("Account", localAccount);
    localBundle.putBoolean("ServiceOfferLookback", bool);
    fragmentArguments = localBundle;
    return localHeader;
  }
  
  public final void a(PreferenceActivity.Header paramHeader, Folder paramFolder)
  {
    fragment = avs.class.getName();
    long l = a;
    paramFolder = c;
    boolean bool = a;
    Bundle localBundle = new Bundle(3);
    localBundle.putLong("MailboxId", l);
    localBundle.putParcelable("Account", paramFolder);
    localBundle.putBoolean("ServiceOfferLookback", bool);
    fragmentArguments = localBundle;
  }
  
  public final void a(Account paramAccount, CurrentFolderDialogState paramCurrentFolderDialogState)
  {
    if (f != null) {
      f.a(paramAccount, paramCurrentFolderDialogState);
    }
  }
  
  public final void a(cpe paramcpe)
  {
    f = paramcpe;
  }
  
  protected boolean isValidFragment(String paramString)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.EmailFolderSettingsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */