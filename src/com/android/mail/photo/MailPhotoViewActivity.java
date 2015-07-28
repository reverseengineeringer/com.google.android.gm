package com.android.mail.photo;

import android.app.ActionBar;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.ex.photo.PhotoViewActivity;
import com.android.ex.photo.fragments.PhotoViewFragment;
import com.android.ex.photo.views.ProgressBarWrapper;
import com.android.mail.browse.AttachmentActionHandler;
import com.android.mail.providers.Attachment;
import com.android.mail.utils.AttachmentUtils;
import com.android.mail.utils.Utils;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MailPhotoViewActivity
  extends PhotoViewActivity
{
  private AttachmentActionHandler mActionHandler;
  private Menu mMenu;
  private MenuItem mSaveAllItem;
  private MenuItem mSaveItem;
  private MenuItem mShareAllItem;
  private MenuItem mShareItem;
  
  private void downloadAttachment()
  {
    Attachment localAttachment = getCurrentAttachment();
    if ((localAttachment != null) && (localAttachment.canSave()))
    {
      mActionHandler.setAttachment(localAttachment);
      mActionHandler.startDownloadingAttachment(0);
    }
  }
  
  private List<Attachment> getAllAttachments()
  {
    Cursor localCursor = getCursor();
    if ((localCursor == null) || (localCursor.isClosed()) || (!localCursor.moveToFirst())) {
      return null;
    }
    ArrayList localArrayList = Lists.newArrayList();
    do
    {
      localArrayList.add(new Attachment(localCursor));
    } while (localCursor.moveToNext());
    return localArrayList;
  }
  
  private void saveAllAttachments()
  {
    Cursor localCursor = getCursorAtProperPosition();
    if (localCursor == null) {
      return;
    }
    int i = -1;
    for (;;)
    {
      i += 1;
      if (!localCursor.moveToPosition(i)) {
        break;
      }
      saveAttachment(new Attachment(localCursor));
    }
  }
  
  private void saveAttachment()
  {
    saveAttachment(getCurrentAttachment());
  }
  
  private void saveAttachment(Attachment paramAttachment)
  {
    if ((paramAttachment != null) && (paramAttachment.canSave()))
    {
      mActionHandler.setAttachment(paramAttachment);
      mActionHandler.startDownloadingAttachment(1);
    }
  }
  
  private void shareAllAttachments()
  {
    Cursor localCursor = getCursorAtProperPosition();
    if (localCursor == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = -1;
    for (;;)
    {
      i += 1;
      if (!localCursor.moveToPosition(i)) {
        break;
      }
      localArrayList.add(Utils.normalizeUri(AttachmentcontentUri));
    }
    mActionHandler.shareAttachments(localArrayList);
  }
  
  private void shareAttachment()
  {
    shareAttachment(getCurrentAttachment());
  }
  
  private void shareAttachment(Attachment paramAttachment)
  {
    if (paramAttachment != null)
    {
      mActionHandler.setAttachment(paramAttachment);
      mActionHandler.shareAttachment();
    }
  }
  
  private void updateProgressAndEmptyViews(PhotoViewFragment paramPhotoViewFragment, Attachment paramAttachment)
  {
    final ProgressBarWrapper localProgressBarWrapper = paramPhotoViewFragment.getPhotoProgressBar();
    TextView localTextView = paramPhotoViewFragment.getEmptyText();
    ImageView localImageView = paramPhotoViewFragment.getRetryButton();
    if (paramAttachment.shouldShowProgress())
    {
      localProgressBarWrapper.setMax(size);
      localProgressBarWrapper.setProgress(downloadedSize);
      localProgressBarWrapper.setIndeterminate(false);
    }
    while (paramAttachment.downloadFailed())
    {
      localTextView.setText(2131493103);
      localTextView.setVisibility(0);
      localImageView.setVisibility(0);
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          MailPhotoViewActivity.this.downloadAttachment();
          localProgressBarWrapper.setVisibility(0);
        }
      });
      localProgressBarWrapper.setVisibility(8);
      return;
      if (paramPhotoViewFragment.isProgressBarNeeded()) {
        localProgressBarWrapper.setIndeterminate(true);
      }
    }
    localTextView.setVisibility(8);
    localImageView.setVisibility(8);
  }
  
  protected Attachment getCurrentAttachment()
  {
    Cursor localCursor = getCursorAtProperPosition();
    if (localCursor == null) {
      return null;
    }
    return new Attachment(localCursor);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(2);
    super.onCreate(paramBundle);
    mActionHandler = new AttachmentActionHandler(this, null);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131886091, paramMenu);
    mMenu = paramMenu;
    mSaveItem = mMenu.findItem(2131755323);
    mSaveAllItem = mMenu.findItem(2131755324);
    mShareItem = mMenu.findItem(2131755325);
    mShareAllItem = mMenu.findItem(2131755326);
    return true;
  }
  
  public void onFragmentVisible(PhotoViewFragment paramPhotoViewFragment)
  {
    super.onFragmentVisible(paramPhotoViewFragment);
    updateProgressAndEmptyViews(paramPhotoViewFragment, getCurrentAttachment());
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332: 
      finish();
      return true;
    case 2131755323: 
      saveAttachment();
      return true;
    case 2131755324: 
      saveAllAttachments();
      return true;
    case 2131755325: 
      shareAttachment();
      return true;
    }
    shareAllAttachments();
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    updateActionItems();
    return true;
  }
  
  protected void updateActionBar(PhotoViewFragment paramPhotoViewFragment)
  {
    super.updateActionBar(paramPhotoViewFragment);
    paramPhotoViewFragment = getCurrentAttachment();
    ActionBar localActionBar = getActionBar();
    String str = AttachmentUtils.convertToHumanReadableSize(this, size);
    if (paramPhotoViewFragment.isSavedToExternal()) {
      localActionBar.setSubtitle(getResources().getString(2131492991) + " " + str);
    }
    for (;;)
    {
      updateActionItems();
      return;
      if ((paramPhotoViewFragment.isDownloading()) && (destination == 1)) {
        localActionBar.setSubtitle(2131492997);
      } else {
        localActionBar.setSubtitle(str);
      }
    }
  }
  
  protected void updateActionItems()
  {
    boolean bool3 = Utils.isRunningJellybeanOrLater();
    Object localObject1 = getCurrentAttachment();
    if ((localObject1 != null) && (mSaveItem != null) && (mShareItem != null))
    {
      localObject2 = mSaveItem;
      if ((!((Attachment)localObject1).isDownloading()) && (((Attachment)localObject1).canSave()) && (!((Attachment)localObject1).isSavedToExternal()))
      {
        bool1 = true;
        ((MenuItem)localObject2).setEnabled(bool1);
        mShareItem.setEnabled(((Attachment)localObject1).canShare());
        localObject1 = getAllAttachments();
        if (localObject1 != null)
        {
          bool2 = false;
          localObject2 = ((List)localObject1).iterator();
          do
          {
            bool1 = bool2;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localAttachment = (Attachment)((Iterator)localObject2).next();
          } while ((localAttachment.isDownloading()) || (!localAttachment.canSave()) || (localAttachment.isSavedToExternal()));
          bool1 = true;
          mSaveAllItem.setEnabled(bool1);
          bool2 = true;
          localObject1 = ((List)localObject1).iterator();
          do
          {
            bool1 = bool2;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
          } while (((Attachment)((Iterator)localObject1).next()).canShare());
          bool1 = false;
          mShareAllItem.setEnabled(bool1);
        }
        if (!bool3)
        {
          mShareItem.setVisible(false);
          mShareAllItem.setVisible(false);
        }
      }
    }
    while (mMenu == null) {
      for (;;)
      {
        Object localObject2;
        boolean bool2;
        Attachment localAttachment;
        return;
        boolean bool1 = false;
      }
    }
    mMenu.setGroupEnabled(2131755322, false);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.photo.MailPhotoViewActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */