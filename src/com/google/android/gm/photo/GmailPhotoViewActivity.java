package com.google.android.gm.photo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.android.mail.photo.MailPhotoViewActivity;
import com.android.mail.providers.Attachment;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.panorama.PanoramaClient;
import com.google.android.gms.panorama.PanoramaClient.OnPanoramaInfoLoadedListener;

public class GmailPhotoViewActivity
  extends MailPhotoViewActivity
  implements View.OnClickListener, GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener, PanoramaClient.OnPanoramaInfoLoadedListener
{
  private static final String LOG_TAG = ;
  private PanoramaClient mClient;
  private Attachment mCurrentAttachment;
  private Intent mCurrentViewerIntent;
  private ImageView mPanoramaButton;
  private Attachment mSavedAttachment;
  
  private Uri getUri(Attachment paramAttachment)
  {
    if (paramAttachment != null)
    {
      paramAttachment = contentUri;
      if (paramAttachment != null) {
        return Utils.normalizeUri(paramAttachment);
      }
    }
    return Uri.EMPTY;
  }
  
  private void loadPanoramaInfo(Attachment paramAttachment)
  {
    if (mClient != null)
    {
      mSavedAttachment = null;
      Uri localUri = getUri(paramAttachment);
      if ((!Utils.isEmpty(localUri)) && (paramAttachment.isPresentLocally()))
      {
        LogUtils.d(LOG_TAG, new Throwable(), "Panorama loading info for %s", new Object[] { paramAttachment });
        mCurrentAttachment = paramAttachment;
        mCurrentViewerIntent = null;
        paramAttachment = new Bundle();
        paramAttachment.putParcelable("attachmentUri", localUri);
        mClient.loadPanoramaInfoAndGrantAccess(this, localUri, paramAttachment);
        return;
      }
    }
    setAnimatedVisibility(mPanoramaButton, false);
  }
  
  private void setAnimatedVisibility(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0; paramView.getVisibility() == i; i = 8) {
      return;
    }
    paramView.setVisibility(i);
    if (paramBoolean) {}
    for (i = 2131034116;; i = 2131034117)
    {
      Animator localAnimator = AnimatorInflater.loadAnimator(this, i);
      localAnimator.setTarget(paramView);
      localAnimator.start();
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (mCurrentViewerIntent != null)
    {
      paramView = mCurrentViewerIntent;
      try
      {
        startActivity(paramView);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        LogUtils.e(LOG_TAG, localActivityNotFoundException, "Cannot view attachment: %s", new Object[] { paramView.getData() });
        return;
      }
    }
    LogUtils.e(LOG_TAG, "Viewer intent is null for attachment: %s", new Object[] { mCurrentAttachment });
  }
  
  public void onConnected()
  {
    LogUtils.d(LOG_TAG, "Panorama onConnected loading info for %s", new Object[] { mSavedAttachment });
    loadPanoramaInfo(mSavedAttachment);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    LogUtils.e(LOG_TAG, "Panorama connection failed: %s", new Object[] { paramConnectionResult });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == 0) {
      mClient = new PanoramaClient(this, this, this);
    }
    mPanoramaButton = ((ImageView)findViewById(2131755220));
    mPanoramaButton.setOnClickListener(this);
  }
  
  public void onDisconnected()
  {
    LogUtils.d(LOG_TAG, "Panorama disconnected", new Object[0]);
  }
  
  public void onNewPhotoLoaded()
  {
    super.onNewPhotoLoaded();
    Attachment localAttachment;
    if (mClient != null)
    {
      localAttachment = getCurrentAttachment();
      if (mClient.isConnected()) {
        loadPanoramaInfo(localAttachment);
      }
    }
    else
    {
      return;
    }
    LogUtils.d(LOG_TAG, "Panorama saving attachment %s", new Object[] { localAttachment });
    mSavedAttachment = localAttachment;
  }
  
  public void onPanoramaInfoLoaded(ConnectionResult paramConnectionResult, int paramInt, Intent paramIntent)
  {
    LogUtils.d(LOG_TAG, "Panorama found type: %d, viewerIntent: %s, result: %s", new Object[] { Integer.valueOf(paramInt), paramIntent, paramConnectionResult });
    if (paramIntent != null)
    {
      Uri localUri = (Uri)paramIntent.getExtras().getParcelable("attachmentUri");
      if ((localUri != null) && (localUri.equals(getUri(mCurrentAttachment)))) {
        if (paramConnectionResult.getErrorCode() == 0)
        {
          if ((paramInt != 0) && (paramIntent != null))
          {
            setAnimatedVisibility(mPanoramaButton, true);
            mCurrentViewerIntent = paramIntent;
          }
        }
        else {
          LogUtils.e(LOG_TAG, "Panorama error: %s", new Object[] { paramConnectionResult });
        }
      }
    }
    setAnimatedVisibility(mPanoramaButton, false);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) != 0)
    {
      if (mClient != null)
      {
        mClient.disconnect();
        mClient = null;
      }
      setAnimatedVisibility(mPanoramaButton, false);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (mClient != null) {
      mClient.connect();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (mClient != null) {
      mClient.disconnect();
    }
  }
  
  public void setViewActivated()
  {
    super.setViewActivated();
    onNewPhotoLoaded();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.photo.GmailPhotoViewActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */