package com.android.mail.ui;

import android.view.DragEvent;
import com.android.mail.providers.Folder;

public abstract interface FolderItemView$DropHandler
{
  public abstract void handleDrop(DragEvent paramDragEvent, Folder paramFolder);
  
  public abstract boolean supportsDrag(DragEvent paramDragEvent, Folder paramFolder);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderItemView.DropHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */