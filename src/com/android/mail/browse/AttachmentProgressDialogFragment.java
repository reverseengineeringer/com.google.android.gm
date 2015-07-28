package com.android.mail.browse;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.os.Bundle;
import com.android.mail.providers.Attachment;
import com.android.mail.utils.LogTag;
import com.google.common.base.Objects;

public class AttachmentProgressDialogFragment
  extends DialogFragment
{
  private static final String LOG_TAG = ;
  private Attachment mAttachment;
  private AttachmentCommandHandler mCommandHandler;
  private ProgressDialog mDialog;
  
  static AttachmentProgressDialogFragment newInstance(Attachment paramAttachment, int paramInt)
  {
    AttachmentProgressDialogFragment localAttachmentProgressDialogFragment = new AttachmentProgressDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("attachment", paramAttachment);
    localAttachmentProgressDialogFragment.setArguments(localBundle);
    return localAttachmentProgressDialogFragment;
  }
  
  public void cancelAttachment()
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("state", Integer.valueOf(0));
    mCommandHandler.sendCommand(mAttachment.uri, localContentValues);
  }
  
  public boolean isIndeterminate()
  {
    return (mDialog != null) && (mDialog.isIndeterminate());
  }
  
  public boolean isShowingDialogForAttachment(Attachment paramAttachment)
  {
    return (getDialog() != null) && (Objects.equal(uri, mAttachment.uri));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    mCommandHandler = new AttachmentCommandHandler(getActivity());
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    mDialog = null;
    cancelAttachment();
    super.onCancel(paramDialogInterface);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mAttachment = ((Attachment)getArguments().getParcelable("attachment"));
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    mDialog = new ProgressDialog(getActivity());
    mDialog.setTitle(2131492989);
    mDialog.setMessage(mAttachment.name);
    mDialog.setProgressStyle(1);
    mDialog.setIndeterminate(true);
    mDialog.setMax(mAttachment.size);
    mDialog.setProgressNumberFormat(null);
    return mDialog;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    mDialog = null;
    super.onDismiss(paramDialogInterface);
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    if (mDialog != null) {
      mDialog.setIndeterminate(paramBoolean);
    }
  }
  
  public void setProgress(int paramInt)
  {
    if (mDialog != null) {
      mDialog.setProgress(paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.AttachmentProgressDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */