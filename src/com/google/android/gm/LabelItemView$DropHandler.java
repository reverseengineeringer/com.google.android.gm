package com.google.android.gm;

import android.view.DragEvent;
import com.google.android.gm.provider.Label;

public abstract interface LabelItemView$DropHandler
{
  public abstract void handleDrop(DragEvent paramDragEvent, Label paramLabel);
  
  public abstract boolean supportsDrag(DragEvent paramDragEvent, Label paramLabel);
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelItemView.DropHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */