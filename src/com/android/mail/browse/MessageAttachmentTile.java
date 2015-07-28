package com.android.mail.browse;

import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.android.ex.photo.Intents;
import com.android.ex.photo.Intents.PhotoViewIntentBuilder;
import com.android.ex.photo.util.ImageUtils;
import com.android.mail.photo.MailPhotoViewActivity;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.UIProvider;
import com.android.mail.ui.AttachmentTile;
import com.android.mail.ui.AttachmentTile.AttachmentPreviewCache;
import com.android.mail.ui.AttachmentTileGrid;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.util.List;

public class MessageAttachmentTile
  extends AttachmentTile
  implements View.OnClickListener, AttachmentViewInterface
{
  private static final String LOG_TAG = ;
  private final AttachmentActionHandler mActionHandler = new AttachmentActionHandler(paramContext, this);
  private Uri mAttachmentsListUri;
  private int mPhotoIndex;
  private ProgressBar mProgress;
  private View mTextContainer;
  
  public MessageAttachmentTile(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageAttachmentTile(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static MessageAttachmentTile inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return (MessageAttachmentTile)paramLayoutInflater.inflate(2130968615, paramViewGroup, false);
  }
  
  private boolean onClick(int paramInt, View paramView)
  {
    mActionHandler.showAndDownloadAttachments();
    return true;
  }
  
  public List<Attachment> getAttachments()
  {
    return ((AttachmentTileGrid)getParent()).getAttachments();
  }
  
  public void initialize(FragmentManager paramFragmentManager)
  {
    mActionHandler.initialize(paramFragmentManager);
  }
  
  public void onClick(View paramView)
  {
    onClick(paramView.getId(), paramView);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mTextContainer = findViewById(2131755122);
    mProgress = ((ProgressBar)findViewById(2131755118));
    setOnClickListener(this);
  }
  
  public void onUpdateStatus() {}
  
  public void render(Attachment paramAttachment, Uri paramUri, int paramInt, AttachmentTile.AttachmentPreviewCache paramAttachmentPreviewCache, boolean paramBoolean)
  {
    super.render(paramAttachment, paramUri, paramInt, paramAttachmentPreviewCache, paramBoolean);
    mAttachmentsListUri = paramUri;
    mPhotoIndex = paramInt;
    mActionHandler.setAttachment(mAttachment);
    mActionHandler.updateStatus(paramBoolean);
  }
  
  public void setThumbnail(Bitmap paramBitmap)
  {
    super.setThumbnail(paramBitmap);
    mTextContainer.setVisibility(8);
  }
  
  public void setThumbnailToDefault()
  {
    super.setThumbnailToDefault();
    mTextContainer.setVisibility(0);
  }
  
  public void updateProgress(boolean paramBoolean)
  {
    if (mAttachment.isDownloading())
    {
      mProgress.setMax(mAttachment.size);
      mProgress.setProgress(mAttachment.downloadedSize);
      ProgressBar localProgressBar = mProgress;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localProgressBar.setIndeterminate(paramBoolean);
        mProgress.setVisibility(0);
        return;
      }
    }
    mProgress.setVisibility(8);
  }
  
  public void viewAttachment()
  {
    if (ImageUtils.isImageMimeType(Utils.normalizeMimeType(mAttachment.contentType)))
    {
      localObject = Intents.newPhotoViewIntentBuilder(getContext(), MailPhotoViewActivity.class);
      ((Intents.PhotoViewIntentBuilder)localObject).setPhotosUri(mAttachmentsListUri.toString()).setProjection(UIProvider.ATTACHMENT_PROJECTION).setPhotoIndex(Integer.valueOf(mPhotoIndex));
      getContext().startActivity(((Intents.PhotoViewIntentBuilder)localObject).build());
      return;
    }
    Object localObject = new Intent("android.intent.action.VIEW");
    ((Intent)localObject).setFlags(524289);
    Utils.setIntentDataAndTypeAndNormalize((Intent)localObject, mAttachment.contentUri, mAttachment.contentType);
    try
    {
      getContext().startActivity((Intent)localObject);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      LogUtils.e(LOG_TAG, "Coun't find Activity for intent", new Object[] { localActivityNotFoundException });
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageAttachmentTile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */