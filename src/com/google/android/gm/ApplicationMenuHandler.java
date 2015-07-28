package com.google.android.gm;

import android.content.Context;
import android.view.MenuItem;
import com.google.android.gm.persistence.Persistence;

public class ApplicationMenuHandler
{
  public static boolean handleApplicationMenu(int paramInt, Context paramContext, HelpCallback paramHelpCallback)
  {
    Persistence.getInstance();
    switch (paramInt)
    {
    default: 
      return false;
    case 2131755318: 
      Utils.showSettings(paramContext);
      return true;
    case 2131755312: 
      Utils.startSync(Persistence.getInstance().getActiveAccount(paramContext));
      return true;
    case 2131755298: 
      Utils.showHelp(paramContext, paramHelpCallback);
      return true;
    }
    Utils.showAbout(paramContext);
    return true;
  }
  
  public static boolean handleApplicationMenu(MenuItem paramMenuItem, Context paramContext, HelpCallback paramHelpCallback)
  {
    return handleApplicationMenu(paramMenuItem.getItemId(), paramContext, paramHelpCallback);
  }
  
  public static abstract interface HelpCallback
  {
    public abstract String getHelpContext();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ApplicationMenuHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */