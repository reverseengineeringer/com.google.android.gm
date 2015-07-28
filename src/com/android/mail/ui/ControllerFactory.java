package com.android.mail.ui;

public class ControllerFactory
{
  public static ActivityController forActivity(MailActivity paramMailActivity, ViewMode paramViewMode, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new TwoPaneController(paramMailActivity, paramViewMode);
    }
    return new OnePaneController(paramMailActivity, paramViewMode);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ControllerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */