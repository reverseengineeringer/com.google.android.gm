package com.android.mail.ui;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.android.mail.browse.MessageAttachmentTile;
import com.android.mail.compose.ComposeAttachmentTile;
import com.android.mail.providers.Attachment;
import com.android.mail.utils.AttachmentUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AttachmentTileGrid
  extends FrameLayout
  implements AttachmentTile.AttachmentPreviewCache
{
  private HashMap<String, AttachmentTile.AttachmentPreview> mAttachmentPreviews;
  private List<Attachment> mAttachments;
  private Uri mAttachmentsListUri;
  private int mColumnCount;
  private FragmentManager mFragmentManager;
  private LayoutInflater mInflater;
  private final int mTileMinSize;
  
  public AttachmentTileGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mInflater = LayoutInflater.from(paramContext);
    mTileMinSize = paramContext.getResources().getDimensionPixelSize(2131427421);
    mAttachmentPreviews = Maps.newHashMap();
  }
  
  private void addMessageTileFromAttachment(Attachment paramAttachment, int paramInt, boolean paramBoolean)
  {
    MessageAttachmentTile localMessageAttachmentTile;
    if (getChildCount() <= paramInt)
    {
      localMessageAttachmentTile = MessageAttachmentTile.inflate(mInflater, this);
      localMessageAttachmentTile.initialize(mFragmentManager);
      addView(localMessageAttachmentTile);
    }
    for (;;)
    {
      localMessageAttachmentTile.render(paramAttachment, mAttachmentsListUri, paramInt, this, paramBoolean);
      return;
      localMessageAttachmentTile = (MessageAttachmentTile)getChildAt(paramInt);
    }
  }
  
  private void onLayoutForTiles()
  {
    int n = getChildCount();
    int i = 0;
    int k = 0;
    int m = 1;
    int j = 0;
    if (j < n)
    {
      View localView = getChildAt(j);
      int i1 = localView.getMeasuredWidth();
      int i2 = localView.getMeasuredHeight();
      if ((m == 0) && (j % mColumnCount == 0))
      {
        i = 0;
        k += i2;
      }
      for (;;)
      {
        localView.layout(i, k, i + i1, k + i2);
        i += i1;
        j += 1;
        break;
        m = 0;
      }
    }
  }
  
  private void onMeasureForTiles(int paramInt)
  {
    int j = View.MeasureSpec.getSize(paramInt);
    int m = getChildCount();
    if (m == 0)
    {
      setMeasuredDimension(j, 0);
      return;
    }
    mColumnCount = (j / mTileMinSize);
    if (mColumnCount == 0) {
      mColumnCount = 1;
    }
    int k = j / mColumnCount;
    int n = mColumnCount;
    paramInt = 0;
    if (paramInt < m)
    {
      View localView = getChildAt(paramInt);
      if (paramInt < j - n * k) {}
      for (int i = 1;; i = 0)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(k + i, 1073741824), View.MeasureSpec.makeMeasureSpec(k, 1073741824));
        paramInt += 1;
        break;
      }
    }
    paramInt = (m - 1) / mColumnCount;
    setMeasuredDimension(j, (getChildAt(0).getPaddingBottom() + k) * (paramInt + 1));
  }
  
  public ComposeAttachmentTile addComposeTileFromAttachment(Attachment paramAttachment)
  {
    ComposeAttachmentTile localComposeAttachmentTile = ComposeAttachmentTile.inflate(mInflater, this);
    addView(localComposeAttachmentTile);
    localComposeAttachmentTile.render(paramAttachment, null, -1, this, false);
    return localComposeAttachmentTile;
  }
  
  public void configureGrid(FragmentManager paramFragmentManager, Uri paramUri, List<Attachment> paramList, boolean paramBoolean)
  {
    mFragmentManager = paramFragmentManager;
    mAttachmentsListUri = paramUri;
    mAttachments = paramList;
    int i = 0;
    paramFragmentManager = paramList.iterator();
    while (paramFragmentManager.hasNext())
    {
      addMessageTileFromAttachment((Attachment)paramFragmentManager.next(), i, paramBoolean);
      i += 1;
    }
  }
  
  public Bitmap get(Attachment paramAttachment)
  {
    paramAttachment = AttachmentUtils.getIdentifier(paramAttachment);
    if (paramAttachment != null)
    {
      paramAttachment = (AttachmentTile.AttachmentPreview)mAttachmentPreviews.get(paramAttachment);
      if (paramAttachment != null) {
        return preview;
      }
    }
    return null;
  }
  
  public ArrayList<AttachmentTile.AttachmentPreview> getAttachmentPreviews()
  {
    return Lists.newArrayList(mAttachmentPreviews.values());
  }
  
  public List<Attachment> getAttachments()
  {
    return mAttachments;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onLayoutForTiles();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    onMeasureForTiles(paramInt1);
  }
  
  public void sendAccessibilityEvent(int paramInt) {}
  
  public void set(Attachment paramAttachment, Bitmap paramBitmap)
  {
    String str = AttachmentUtils.getIdentifier(paramAttachment);
    if (str != null) {
      mAttachmentPreviews.put(str, new AttachmentTile.AttachmentPreview(paramAttachment, paramBitmap));
    }
  }
  
  public void setAttachmentPreviews(ArrayList<AttachmentTile.AttachmentPreview> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        AttachmentTile.AttachmentPreview localAttachmentPreview = (AttachmentTile.AttachmentPreview)paramArrayList.next();
        mAttachmentPreviews.put(attachmentIdentifier, localAttachmentPreview);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AttachmentTileGrid
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */