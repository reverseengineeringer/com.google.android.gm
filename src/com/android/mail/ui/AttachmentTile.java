package com.android.mail.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ex.photo.util.ImageUtils;
import com.android.mail.providers.Attachment;
import com.android.mail.utils.AttachmentUtils;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;

public class AttachmentTile
  extends RelativeLayout
  implements AttachmentBitmapHolder
{
  private static final String LOG_TAG = ;
  protected Attachment mAttachment;
  private AttachmentPreviewCache mAttachmentPreviewCache;
  private String mAttachmentSizeText;
  private ImageView mDefaultIcon;
  private boolean mDefaultThumbnailSet = true;
  private String mDisplayType;
  private ImageView mIcon;
  private TextView mSubtitle;
  private ThumbnailLoadTask mThumbnailTask;
  private TextView mTitle;
  
  public AttachmentTile(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AttachmentTile(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static boolean isTiledAttachment(Attachment paramAttachment)
  {
    return ImageUtils.isImageMimeType(contentType);
  }
  
  private void updateSubtitleText()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(mAttachmentSizeText);
    localStringBuilder.append(' ');
    localStringBuilder.append(mDisplayType);
    mSubtitle.setText(localStringBuilder.toString());
  }
  
  public boolean bitmapSetToDefault()
  {
    return mDefaultThumbnailSet;
  }
  
  public ContentResolver getResolver()
  {
    return getContext().getContentResolver();
  }
  
  public int getThumbnailHeight()
  {
    return mIcon.getHeight();
  }
  
  public int getThumbnailWidth()
  {
    return mIcon.getWidth();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mTitle = ((TextView)findViewById(2131755088));
    mSubtitle = ((TextView)findViewById(2131755089));
    mIcon = ((ImageView)findViewById(2131755057));
    mDefaultIcon = ((ImageView)findViewById(2131755058));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ThumbnailLoadTask.setupThumbnailPreview(mThumbnailTask, this, mAttachment, null);
  }
  
  public void render(Attachment paramAttachment, Uri paramUri, int paramInt, AttachmentPreviewCache paramAttachmentPreviewCache, boolean paramBoolean)
  {
    if (paramAttachment == null)
    {
      setVisibility(4);
      return;
    }
    paramUri = mAttachment;
    mAttachment = paramAttachment;
    mAttachmentPreviewCache = paramAttachmentPreviewCache;
    LogUtils.d(LOG_TAG, "got attachment list row: name=%s state/dest=%d/%d dled=%d contentUri=%s MIME=%s", new Object[] { name, Integer.valueOf(state), Integer.valueOf(destination), Integer.valueOf(downloadedSize), contentUri, contentType });
    if ((paramUri == null) || (!TextUtils.equals(name, name))) {
      mTitle.setText(name);
    }
    if ((paramUri == null) || (size != size))
    {
      mAttachmentSizeText = AttachmentUtils.convertToHumanReadableSize(getContext(), size);
      mDisplayType = AttachmentUtils.getDisplayType(getContext(), paramAttachment);
      updateSubtitleText();
    }
    ThumbnailLoadTask.setupThumbnailPreview(mThumbnailTask, this, paramAttachment, paramUri);
  }
  
  public void setThumbnail(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    mDefaultIcon.setVisibility(8);
    int i = getResources().getInteger(2131361837);
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int m = getResourcesgetDisplayMetricsdensityDpi * j / 160;
    int n = getResourcesgetDisplayMetricsdensityDpi * k / 160;
    float f = Math.min(j / k, k / j);
    boolean bool1;
    boolean bool2;
    if ((j >= i) || (m >= mIcon.getWidth()) || (k >= i) || (n >= mIcon.getHeight()))
    {
      bool1 = true;
      if ((f >= 0.5F) || ((m >= mIcon.getHeight() * 0.5F) && (n >= mIcon.getWidth() * 0.5F))) {
        break label276;
      }
      bool2 = true;
      label177:
      LogUtils.d(LOG_TAG, "scaledWidth: %d, scaledHeight: %d, large: %b, skinny: %b", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1) {
        break label295;
      }
      if (!bool2) {
        break label282;
      }
      mIcon.setScaleType(ImageView.ScaleType.CENTER);
    }
    for (;;)
    {
      mIcon.setImageBitmap(paramBitmap);
      mAttachmentPreviewCache.set(mAttachment, paramBitmap);
      mDefaultThumbnailSet = false;
      return;
      bool1 = false;
      break;
      label276:
      bool2 = false;
      break label177;
      label282:
      mIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
      continue;
      label295:
      mIcon.setScaleType(ImageView.ScaleType.CENTER);
    }
  }
  
  public void setThumbnailToDefault()
  {
    Bitmap localBitmap = mAttachmentPreviewCache.get(mAttachment);
    if (localBitmap != null)
    {
      setThumbnail(localBitmap);
      return;
    }
    mDefaultIcon.setVisibility(0);
    mDefaultThumbnailSet = true;
  }
  
  public static final class AttachmentPreview
    implements Parcelable
  {
    public static final Parcelable.Creator<AttachmentPreview> CREATOR = new Parcelable.Creator()
    {
      public AttachmentTile.AttachmentPreview createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AttachmentTile.AttachmentPreview(paramAnonymousParcel, null);
      }
      
      public AttachmentTile.AttachmentPreview[] newArray(int paramAnonymousInt)
      {
        return new AttachmentTile.AttachmentPreview[paramAnonymousInt];
      }
    };
    public String attachmentIdentifier;
    public Bitmap preview;
    
    private AttachmentPreview(Parcel paramParcel)
    {
      attachmentIdentifier = paramParcel.readString();
      preview = ((Bitmap)paramParcel.readParcelable(null));
    }
    
    public AttachmentPreview(Attachment paramAttachment, Bitmap paramBitmap)
    {
      attachmentIdentifier = AttachmentUtils.getIdentifier(paramAttachment);
      preview = paramBitmap;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(attachmentIdentifier);
      paramParcel.writeParcelable(preview, 0);
    }
  }
  
  public static abstract interface AttachmentPreviewCache
  {
    public abstract Bitmap get(Attachment paramAttachment);
    
    public abstract void set(Attachment paramAttachment, Bitmap paramBitmap);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AttachmentTile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */