package com.android.ex.chips;

import android.content.Context;
import android.text.util.Rfc822Token;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class SingleRecipientArrayAdapter
  extends ArrayAdapter<RecipientEntry>
{
  private int mLayoutId;
  private final LayoutInflater mLayoutInflater;
  
  public SingleRecipientArrayAdapter(Context paramContext, int paramInt, RecipientEntry paramRecipientEntry)
  {
    super(paramContext, paramInt, new RecipientEntry[] { paramRecipientEntry });
    mLayoutInflater = LayoutInflater.from(paramContext);
    mLayoutId = paramInt;
  }
  
  private void bindView(View paramView, Context paramContext, RecipientEntry paramRecipientEntry)
  {
    paramContext = (TextView)paramView.findViewById(16908310);
    ImageView localImageView = (ImageView)paramView.findViewById(16908294);
    paramContext.setText(paramRecipientEntry.getDisplayName());
    paramContext.setVisibility(0);
    localImageView.setVisibility(0);
    ((TextView)paramView.findViewById(16908308)).setText(android.text.util.Rfc822Tokenizer.tokenize(paramRecipientEntry.getDestination())[0].getAddress());
  }
  
  private View newView()
  {
    return mLayoutInflater.inflate(mLayoutId, null);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = newView();
    }
    bindView(paramViewGroup, paramViewGroup.getContext(), (RecipientEntry)getItem(paramInt));
    return paramViewGroup;
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.SingleRecipientArrayAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */