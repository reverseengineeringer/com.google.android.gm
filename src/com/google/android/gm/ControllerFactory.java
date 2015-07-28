package com.google.android.gm;

import com.android.mail.utils.Utils;

public class ControllerFactory
{
  public static LabelsActivityController forActivity(LabelsActivityController.ControllableLabelsActivity paramControllableLabelsActivity)
  {
    if (Utils.useTabletUI(paramControllableLabelsActivity.getContext())) {
      return new TwoPaneLabelsController(paramControllableLabelsActivity);
    }
    return new OnePaneLabelsController(paramControllableLabelsActivity);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ControllerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */