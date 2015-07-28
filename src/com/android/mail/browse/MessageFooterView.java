package com.android.mail.browse;

import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;
import com.android.mail.ui.AttachmentTile;
import com.android.mail.ui.AttachmentTileGrid;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageFooterView
  extends LinearLayout
  implements ConversationContainer.DetachListener, LoaderManager.LoaderCallbacks<Cursor>
{
  private static final String LOG_TAG = ;
  private LinearLayout mAttachmentBarList;
  private AttachmentTileGrid mAttachmentGrid;
  private AttachmentLoader.AttachmentCursor mAttachmentsCursor;
  private FragmentManager mFragmentManager;
  private final LayoutInflater mInflater;
  private LoaderManager mLoaderManager;
  private ConversationViewAdapter.MessageHeaderItem mMessageHeaderItem;
  private View mTitleBar;
  private TextView mTitleText;
  
  public MessageFooterView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mInflater = LayoutInflater.from(paramContext);
  }
  
  private Integer getAttachmentLoaderId()
  {
    Object localObject2 = null;
    if (mMessageHeaderItem == null) {}
    for (MessageCursor.ConversationMessage localConversationMessage = null;; localConversationMessage = mMessageHeaderItem.getMessage())
    {
      Object localObject1 = localObject2;
      if (localConversationMessage != null)
      {
        localObject1 = localObject2;
        if (hasAttachments)
        {
          localObject1 = localObject2;
          if (attachmentListUri != null) {
            localObject1 = Integer.valueOf(attachmentListUri.hashCode());
          }
        }
      }
      return (Integer)localObject1;
    }
  }
  
  private void renderAttachments(List<Attachment> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int i = paramList.size();
    ArrayList localArrayList1 = new ArrayList(i);
    ArrayList localArrayList2 = new ArrayList(i);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Attachment localAttachment = (Attachment)localIterator.next();
      if (AttachmentTile.isTiledAttachment(localAttachment)) {
        localArrayList1.add(localAttachment);
      } else {
        localArrayList2.add(localAttachment);
      }
    }
    mMessageHeaderItem.getMessage().attachmentsJson = Attachment.toJSONArray(paramList);
    mTitleText.setVisibility(0);
    mTitleBar.setVisibility(0);
    renderTiledAttachments(localArrayList1, paramBoolean);
    renderBarAttachments(localArrayList2, paramBoolean);
  }
  
  private void renderAttachments(boolean paramBoolean)
  {
    if ((mAttachmentsCursor != null) && (!mAttachmentsCursor.isClosed()))
    {
      int i = -1;
      ArrayList localArrayList = Lists.newArrayList();
      for (;;)
      {
        AttachmentLoader.AttachmentCursor localAttachmentCursor = mAttachmentsCursor;
        i += 1;
        localObject = localArrayList;
        if (!localAttachmentCursor.moveToPosition(i)) {
          break;
        }
        localArrayList.add(mAttachmentsCursor.get());
      }
    }
    Object localObject = mMessageHeaderItem.getMessage().getAttachments();
    renderAttachments((List)localObject, paramBoolean);
  }
  
  private void renderBarAttachments(List<Attachment> paramList, boolean paramBoolean)
  {
    mAttachmentBarList.setVisibility(0);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Attachment localAttachment = (Attachment)localIterator.next();
      Uri localUri = localAttachment.getIdentifierUri();
      MessageAttachmentBar localMessageAttachmentBar = (MessageAttachmentBar)mAttachmentBarList.findViewWithTag(localUri);
      paramList = localMessageAttachmentBar;
      if (localMessageAttachmentBar == null)
      {
        paramList = MessageAttachmentBar.inflate(mInflater, this);
        paramList.setTag(localUri);
        paramList.initialize(mFragmentManager);
        mAttachmentBarList.addView(paramList);
      }
      paramList.render(localAttachment, paramBoolean);
    }
  }
  
  private void renderTiledAttachments(List<Attachment> paramList, boolean paramBoolean)
  {
    mAttachmentGrid.setVisibility(0);
    mAttachmentGrid.configureGrid(mFragmentManager, mMessageHeaderItem.getMessage().attachmentListUri, paramList, paramBoolean);
  }
  
  public void bind(ConversationViewAdapter.MessageHeaderItem paramMessageHeaderItem, boolean paramBoolean)
  {
    int i = 0;
    if ((mMessageHeaderItem != null) && (mMessageHeaderItem.getMessage() != null) && (mMessageHeaderItem.getMessage().attachmentListUri != null) && (!mMessageHeaderItem.getMessage().attachmentListUri.equals(getMessageattachmentListUri)))
    {
      mAttachmentGrid.removeAllViewsInLayout();
      mAttachmentBarList.removeAllViewsInLayout();
      mTitleText.setVisibility(8);
      mTitleBar.setVisibility(8);
      mAttachmentGrid.setVisibility(8);
      mAttachmentBarList.setVisibility(8);
    }
    Integer localInteger = getAttachmentLoaderId();
    mMessageHeaderItem = paramMessageHeaderItem;
    paramMessageHeaderItem = getAttachmentLoaderId();
    if ((localInteger != null) && (!Objects.equal(localInteger, paramMessageHeaderItem))) {
      mLoaderManager.destroyLoader(localInteger.intValue());
    }
    if ((!paramBoolean) && (paramMessageHeaderItem != null))
    {
      LogUtils.i(LOG_TAG, "binding footer view, calling initLoader for message %d", new Object[] { paramMessageHeaderItem });
      mLoaderManager.initLoader(paramMessageHeaderItem.intValue(), Bundle.EMPTY, this);
    }
    if ((mAttachmentGrid.getChildCount() == 0) && (mAttachmentBarList.getChildCount() == 0)) {
      renderAttachments(false);
    }
    if (mMessageHeaderItem.isExpanded()) {}
    for (;;)
    {
      setVisibility(i);
      return;
      i = 8;
    }
  }
  
  public void initialize(LoaderManager paramLoaderManager, FragmentManager paramFragmentManager)
  {
    mLoaderManager = paramLoaderManager;
    mFragmentManager = paramFragmentManager;
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new AttachmentLoader(getContext(), mMessageHeaderItem.getMessage().attachmentListUri);
  }
  
  public void onDetachedFromParent() {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mTitleText = ((TextView)findViewById(2131755146));
    mTitleBar = findViewById(2131755147);
    mAttachmentGrid = ((AttachmentTileGrid)findViewById(2131755090));
    mAttachmentBarList = ((LinearLayout)findViewById(2131755091));
  }
  
  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    mAttachmentsCursor = ((AttachmentLoader.AttachmentCursor)paramCursor);
    if ((mAttachmentsCursor == null) || (mAttachmentsCursor.isClosed())) {
      return;
    }
    renderAttachments(true);
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader)
  {
    mAttachmentsCursor = null;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageFooterView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */