package com.android.mail.browse;

import android.content.Context;
import arh;
import bwm;

public class EmailConversationProvider
  extends bwm
{
  private static String g;
  
  protected final String a()
  {
    if (g == null) {
      g = getContext().getString(arh.aX);
    }
    return g;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.EmailConversationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */