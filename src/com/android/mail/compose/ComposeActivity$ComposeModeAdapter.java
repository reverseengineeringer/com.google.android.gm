package com.android.mail.compose;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class ComposeActivity$ComposeModeAdapter
  extends ArrayAdapter<String>
{
  private LayoutInflater mInflater;
  
  public ComposeActivity$ComposeModeAdapter(ComposeActivity paramComposeActivity, Context paramContext)
  {
    super(paramContext, 2130968604, 2131755098, paramComposeActivity.getResources().getStringArray(2131623942));
  }
  
  private LayoutInflater getInflater()
  {
    if (mInflater == null) {
      mInflater = LayoutInflater.from(getContext());
    }
    return mInflater;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = getInflater().inflate(2130968603, null);
    }
    ((TextView)localView.findViewById(2131755098)).setText((CharSequence)getItem(paramInt));
    return super.getView(paramInt, localView, paramViewGroup);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeActivity.ComposeModeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */