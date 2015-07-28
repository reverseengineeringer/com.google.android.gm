package com.android.mail.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

class MailboxSelectionActivity$3
  extends SimpleCursorAdapter
{
  MailboxSelectionActivity$3(MailboxSelectionActivity paramMailboxSelectionActivity, Context paramContext, int paramInt1, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt2)
  {
    super(paramContext, paramInt1, paramCursor, paramArrayOfString, paramArrayOfInt, paramInt2);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    ((TextView)paramView.findViewById(2131755211)).setText(com.android.mail.providers.AccountgetItemname);
    return paramView;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MailboxSelectionActivity.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */