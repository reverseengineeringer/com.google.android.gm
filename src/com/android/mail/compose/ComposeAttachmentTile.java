package com.android.mail.compose;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.android.mail.ui.AttachmentTile;

public class ComposeAttachmentTile
  extends AttachmentTile
{
  private ImageButton mDeleteButton;
  
  public ComposeAttachmentTile(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComposeAttachmentTile(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static ComposeAttachmentTile inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return (ComposeAttachmentTile)paramLayoutInflater.inflate(2130968599, paramViewGroup, false);
  }
  
  public void addDeleteListener(View.OnClickListener paramOnClickListener)
  {
    mDeleteButton.setOnClickListener(paramOnClickListener);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mDeleteButton = ((ImageButton)findViewById(2131755087));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeAttachmentTile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */