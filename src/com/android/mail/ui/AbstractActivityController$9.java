package com.android.mail.ui;

import android.net.Uri;
import com.android.mail.providers.Folder;

class AbstractActivityController$9
  implements ActionableToastBar.ActionClickedListener
{
  AbstractActivityController$9(AbstractActivityController paramAbstractActivityController, Folder paramFolder) {}
  
  public void onActionClicked()
  {
    Uri localUri = val$folder.refreshUri;
    if (localUri != null) {
      AbstractActivityController.access$900(this$0, localUri);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractActivityController.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */