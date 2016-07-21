package com.android.mail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import cvm;

public class FolderListLayout
  extends FrameLayout
{
  public FolderListLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FolderListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    cvm.b("MailBlankFragment", "FolderListLayout(%s).onLayout() called", new Object[] { this });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    cvm.b("MailBlankFragment", "FolderListLayout(%s).onMeasure() called", new Object[] { this });
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderListLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */