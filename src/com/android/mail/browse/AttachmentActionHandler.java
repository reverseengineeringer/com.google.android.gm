package com.android.mail.browse;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import com.android.mail.providers.Attachment;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AttachmentActionHandler
{
  private static final String LOG_TAG = ;
  private Attachment mAttachment;
  private final AttachmentCommandHandler mCommandHandler;
  private final Context mContext;
  private boolean mDialogClosed;
  private FragmentManager mFragmentManager;
  private final Handler mHandler;
  private final AttachmentViewInterface mView;
  
  public AttachmentActionHandler(Context paramContext, AttachmentViewInterface paramAttachmentViewInterface)
  {
    mCommandHandler = new AttachmentCommandHandler(paramContext);
    mView = paramAttachmentViewInterface;
    mContext = paramContext;
    mDialogClosed = false;
    mHandler = new Handler();
  }
  
  private void showDownloadingDialog(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = mFragmentManager.beginTransaction();
    Fragment localFragment = mFragmentManager.findFragmentByTag("attachment-progress");
    if (localFragment != null) {
      localFragmentTransaction.remove(localFragment);
    }
    localFragmentTransaction.addToBackStack(null);
    AttachmentProgressDialogFragment.newInstance(mAttachment, paramInt).show(localFragmentTransaction, "attachment-progress");
  }
  
  private void startDownloadingAttachment(Attachment paramAttachment, int paramInt)
  {
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("state", Integer.valueOf(2));
    localContentValues.put("destination", Integer.valueOf(paramInt));
    mCommandHandler.sendCommand(uri, localContentValues);
  }
  
  public void cancelAttachment()
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("state", Integer.valueOf(0));
    mCommandHandler.sendCommand(mAttachment.uri, localContentValues);
  }
  
  public boolean dialogJustClosed()
  {
    boolean bool = mDialogClosed;
    mDialogClosed = false;
    return bool;
  }
  
  public void initialize(FragmentManager paramFragmentManager)
  {
    mFragmentManager = paramFragmentManager;
  }
  
  public boolean isProgressDialogVisible()
  {
    Fragment localFragment = mFragmentManager.findFragmentByTag("attachment-progress");
    return (localFragment != null) && (localFragment.isVisible());
  }
  
  public void setAttachment(Attachment paramAttachment)
  {
    mAttachment = paramAttachment;
  }
  
  public void shareAttachment()
  {
    if (mAttachment.contentUri == null) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setFlags(524289);
    localIntent.putExtra("android.intent.extra.STREAM", Utils.normalizeUri(mAttachment.contentUri));
    localIntent.setType(Utils.normalizeMimeType(mAttachment.contentType));
    try
    {
      mContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      LogUtils.e(LOG_TAG, "Couldn't find Activity for intent", new Object[] { localActivityNotFoundException });
    }
  }
  
  public void shareAttachments(ArrayList<Parcelable> paramArrayList)
  {
    Intent localIntent = new Intent("android.intent.action.SEND_MULTIPLE");
    localIntent.setFlags(524289);
    localIntent.setType("image/*");
    localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", paramArrayList);
    try
    {
      mContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramArrayList)
    {
      LogUtils.e(LOG_TAG, "Couldn't find Activity for intent", new Object[] { paramArrayList });
    }
  }
  
  public void showAndDownloadAttachments()
  {
    Iterator localIterator = mView.getAttachments().iterator();
    while (localIterator.hasNext())
    {
      Attachment localAttachment = (Attachment)localIterator.next();
      if (!localAttachment.isPresentLocally()) {
        startDownloadingAttachment(localAttachment, 0);
      }
    }
    mView.viewAttachment();
  }
  
  public void showAttachment(int paramInt)
  {
    if ((mAttachment.isPresentLocally()) && ((paramInt == 0) || (mAttachment.destination == paramInt)))
    {
      mView.viewAttachment();
      return;
    }
    showDownloadingDialog(paramInt);
    startDownloadingAttachment(paramInt);
  }
  
  public void startDownloadingAttachment(int paramInt)
  {
    startDownloadingAttachment(mAttachment, paramInt);
  }
  
  public void startRedownloadingAttachment(Attachment paramAttachment)
  {
    showDownloadingDialog(destination);
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("state", Integer.valueOf(4));
    localContentValues.put("destination", Integer.valueOf(destination));
    mCommandHandler.sendCommand(uri, localContentValues);
  }
  
  public void updateStatus(boolean paramBoolean)
  {
    boolean bool = mAttachment.shouldShowProgress();
    final AttachmentProgressDialogFragment localAttachmentProgressDialogFragment = (AttachmentProgressDialogFragment)mFragmentManager.findFragmentByTag("attachment-progress");
    if ((localAttachmentProgressDialogFragment != null) && (localAttachmentProgressDialogFragment.isShowingDialogForAttachment(mAttachment)))
    {
      localAttachmentProgressDialogFragment.setProgress(mAttachment.downloadedSize);
      if ((!bool) && (localAttachmentProgressDialogFragment.isIndeterminate()))
      {
        bool = true;
        localAttachmentProgressDialogFragment.setIndeterminate(bool);
        if ((paramBoolean) && (!mAttachment.isDownloading())) {
          mHandler.post(new Runnable()
          {
            public void run()
            {
              localAttachmentProgressDialogFragment.dismiss();
            }
          });
        }
        if (mAttachment.state == 3) {
          mView.viewAttachment();
        }
      }
    }
    for (;;)
    {
      mView.onUpdateStatus();
      return;
      bool = false;
      break;
      mView.updateProgress(bool);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.AttachmentActionHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */