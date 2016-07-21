package com.android.email.activity.setup;

import android.content.Context;
import android.content.Intent;

public class ForwardingIntent
  extends Intent
{
  public ForwardingIntent(Context paramContext, Class paramClass)
  {
    super(paramContext, paramClass);
    setFlags(33554432);
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.ForwardingIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */