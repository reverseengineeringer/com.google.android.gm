package com.google.android.gm.provider;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.Loader.ForceLoadContentObserver;
import android.content.Loader.OnLoadCompleteListener;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gm.provider.uiprovider.UIAttachment;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AttachmentStatusLoader
  extends Loader<List<Result>>
{
  private static final String[] ATTACHMENT_STATUS_LOADER_PROJECTION = { "messages_messageId", "messages_partId", "downloadId", "mimeType", "saveToSd", "filename", "status", "desiredRendition" };
  private final String mAccount;
  private final Loader<Cursor> mAttachmentLoader;
  private List<Result> mAttachments;
  private final long mConversationId;
  private final DownloadStatusLoader mDownloadLoader;
  private final Map<Long, Result> mDownloadMap;
  
  public AttachmentStatusLoader(Context paramContext, String paramString, long paramLong, DownloadManager paramDownloadManager)
  {
    super(paramContext);
    mAccount = paramString;
    mConversationId = paramLong;
    mDownloadMap = Maps.newHashMap();
    mAttachmentLoader = new CursorLoader(paramContext, Gmail.getAttachmentsForConversationUri(mAccount, mConversationId), ATTACHMENT_STATUS_LOADER_PROJECTION, null, null, null);
    mAttachmentLoader.registerListener(mAttachmentLoader.getId(), new AttachmentListener(null));
    mDownloadLoader = new DownloadStatusLoader(paramContext, paramDownloadManager);
    mDownloadLoader.registerListener(mAttachmentLoader.getId(), new DownloadListener(null));
  }
  
  protected void onReset()
  {
    mAttachmentLoader.reset();
    mDownloadLoader.reset();
    mAttachments = null;
  }
  
  protected void onStartLoading()
  {
    mAttachmentLoader.startLoading();
  }
  
  protected void onStopLoading()
  {
    mAttachmentLoader.stopLoading();
    mDownloadLoader.stopLoading();
  }
  
  private class AttachmentListener
    implements Loader.OnLoadCompleteListener<Cursor>
  {
    private AttachmentListener() {}
    
    public void onLoadComplete(Loader<Cursor> paramLoader, Cursor paramCursor)
    {
      AttachmentStatusLoader.access$202(AttachmentStatusLoader.this, Lists.newArrayList());
      mDownloadMap.clear();
      int i = -1;
      int j = i + 1;
      if (paramCursor.moveToPosition(j))
      {
        long l1 = paramCursor.getLong(0);
        paramLoader = paramCursor.getString(1);
        long l2 = paramCursor.getLong(2);
        String str1 = paramCursor.getString(3);
        if (paramCursor.getInt(4) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          String str2 = paramCursor.getString(5);
          i = paramCursor.getInt(6);
          String str3 = paramCursor.getString(7);
          paramLoader = new AttachmentStatusLoader.Result(mConversationId, l1, paramLoader, bool, str2, str1, i, str3);
          i = mAttachments.indexOf(paramLoader);
          if ((i >= 0) && (!mAttachments.get(i)).saveToSd)) {
            mAttachments.remove(i);
          }
          mAttachments.add(paramLoader);
          i = j;
          if (l2 < 0L) {
            break;
          }
          if (mDownloadMap.containsKey(Long.valueOf(l2)))
          {
            i = j;
            if (!bool) {
              break;
            }
          }
          mDownloadMap.put(Long.valueOf(l2), paramLoader);
          i = j;
          break;
        }
      }
      if (mDownloadMap.isEmpty())
      {
        if (!mAttachments.isEmpty()) {
          deliverResult(mAttachments);
        }
        return;
      }
      mDownloadLoader.reset();
      mDownloadLoader.setIds(mDownloadMap.keySet());
      mDownloadLoader.startLoading();
    }
  }
  
  private class DownloadListener
    implements Loader.OnLoadCompleteListener<Cursor>
  {
    private DownloadListener() {}
    
    public void onLoadComplete(Loader<Cursor> paramLoader, Cursor paramCursor)
    {
      if (paramCursor == null) {
        return;
      }
      AttachmentStatusLoader.access$202(AttachmentStatusLoader.this, Lists.newArrayList(mAttachments));
      int k = paramCursor.getColumnIndexOrThrow("_id");
      int m = paramCursor.getColumnIndexOrThrow("bytes_so_far");
      int n = paramCursor.getColumnIndexOrThrow("status");
      int i = -1;
      for (;;)
      {
        int j = i + 1;
        if (!paramCursor.moveToPosition(j)) {
          break;
        }
        long l1 = paramCursor.getLong(k);
        long l2 = paramCursor.getLong(m);
        int i1 = paramCursor.getInt(n);
        i = j;
        if (mDownloadMap.containsKey(Long.valueOf(l1)))
        {
          mDownloadMap.get(Long.valueOf(l1))).downloadedSize = ((int)l2);
          mDownloadMap.get(Long.valueOf(l1))).downloadStatus = i1;
          i = j;
        }
      }
      deliverResult(mAttachments);
    }
  }
  
  private class DownloadStatusLoader
    extends CursorLoader
  {
    private long[] mDownloadIds;
    private final DownloadManager mDownloadManager;
    private final ContentObserver mObserver;
    
    public DownloadStatusLoader(Context paramContext, DownloadManager paramDownloadManager)
    {
      super();
      mDownloadManager = paramDownloadManager;
      mObserver = new Loader.ForceLoadContentObserver(this);
    }
    
    public Cursor loadInBackground()
    {
      Cursor localCursor = mDownloadManager.query(new DownloadManager.Query().setFilterById(mDownloadIds));
      if (localCursor != null) {
        localCursor.registerContentObserver(mObserver);
      }
      return localCursor;
    }
    
    public void setIds(Collection<Long> paramCollection)
    {
      mDownloadIds = new long[paramCollection.size()];
      int i = 0;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        long l = ((Long)paramCollection.next()).longValue();
        mDownloadIds[i] = l;
        i += 1;
      }
    }
  }
  
  public static class Result
    implements UIAttachment
  {
    public String contentType;
    public final long conversationId;
    public int downloadStatus;
    public int downloadedSize;
    public final String fileName;
    public Gmail.Attachment mOriginalAttachment;
    public final long messageId;
    public final String partId;
    public final Gmail.AttachmentRendition rendition;
    public final boolean saveToSd;
    public int size;
    public final int state;
    public final int status;
    private Integer transientDestination;
    private String transientSavedFileUri;
    private Integer transientStatus;
    
    public Result(long paramLong1, long paramLong2, String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt, String paramString4)
    {
      conversationId = paramLong1;
      messageId = paramLong2;
      partId = paramString1;
      saveToSd = paramBoolean;
      fileName = paramString2;
      contentType = paramString3;
      status = paramInt;
      rendition = Gmail.AttachmentRendition.valueOf(paramString4);
      if ((AttachmentManager.isStatusSuccess(paramInt)) && (AttachmentManager.isDownloadStillPresent(paramString2)))
      {
        if (paramBoolean) {}
        for (paramInt = 3;; paramInt = 2)
        {
          state = paramInt;
          return;
        }
      }
      if (AttachmentManager.isStatusRunning(paramInt))
      {
        state = 1;
        return;
      }
      state = 0;
    }
    
    private boolean updatedToCompleteState()
    {
      return (!TextUtils.isEmpty(transientSavedFileUri)) && (transientStatus != null) && (transientStatus.intValue() == 3);
    }
    
    public boolean downloadCompletedSuccessfully()
    {
      return getStatus() == 3;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if ((paramObject == null) || (paramObject.getClass() != getClass())) {
          return false;
        }
        paramObject = (Result)paramObject;
      } while ((messageId == messageId) && (partId.equals(partId)));
      return false;
    }
    
    public String getContentType()
    {
      return contentType;
    }
    
    public int getDestination()
    {
      if (transientDestination != null) {
        return transientDestination.intValue();
      }
      if (saveToSd) {
        return 1;
      }
      return 0;
    }
    
    public int getDownloadedSize()
    {
      return downloadedSize;
    }
    
    public Uri getExternalFilePath()
    {
      if (isDownloadedToSd()) {
        return Uri.parse(fileName);
      }
      if ((getStatus() == 3) && (getDestination() == 1) && (transientSavedFileUri != null)) {
        return Uri.parse(transientSavedFileUri);
      }
      return null;
    }
    
    public String getJoinedAttachmentInfo()
    {
      if (mOriginalAttachment != null) {
        return mOriginalAttachment.toJoinedString();
      }
      return null;
    }
    
    public String getName()
    {
      if (mOriginalAttachment != null)
      {
        String str = mOriginalAttachment.getName();
        if (!TextUtils.isEmpty(str)) {
          return str;
        }
      }
      return Uri.parse(fileName).getLastPathSegment();
    }
    
    public Gmail.AttachmentOrigin getOrigin()
    {
      return null;
    }
    
    public String getOriginExtras()
    {
      return null;
    }
    
    public Gmail.Attachment getOriginal()
    {
      return mOriginalAttachment;
    }
    
    public String getPartId()
    {
      return partId;
    }
    
    public int getSize()
    {
      if ((mOriginalAttachment != null) && (mOriginalAttachment.getSize() != 0)) {
        return mOriginalAttachment.getSize();
      }
      LogUtils.e("Gmail", "Returning inaccurate attachment size", new Object[0]);
      return downloadedSize;
    }
    
    public int getStatus()
    {
      if (isStatusError()) {
        return 1;
      }
      if (state == 1) {
        return 2;
      }
      if ((transientStatus != null) && (((AttachmentManager.isStatusSuccess(status)) && (!AttachmentManager.isDownloadStillPresent(fileName))) || (AttachmentManager.isStatusPending(status)) || ((transientStatus.intValue() == 2) && ((AttachmentManager.isStatusError(status)) || (AttachmentManager.isStatusSuccess(status)))))) {
        return transientStatus.intValue();
      }
      if ((isDownloadedToSd()) || (isDownloadedToCache()) || (updatedToCompleteState())) {
        return 3;
      }
      return 0;
    }
    
    public int hashCode()
    {
      return (int)(messageId ^ partId.hashCode());
    }
    
    public boolean isDownloadedToCache()
    {
      return state == 2;
    }
    
    public boolean isDownloadedToSd()
    {
      return state == 3;
    }
    
    public boolean isDownloading()
    {
      return getStatus() == 2;
    }
    
    public boolean isStatusError()
    {
      if (transientStatus != null) {}
      for (int i = transientStatus.intValue();; i = status) {
        return AttachmentManager.isStatusError(i);
      }
    }
    
    public boolean isStatusPaused()
    {
      return (AttachmentManager.isStatusPaused(status)) || (downloadStatus == 4);
    }
    
    public boolean isStatusPending()
    {
      return AttachmentManager.isStatusPending(status);
    }
    
    public boolean isStatusSuccess()
    {
      if (transientStatus != null) {}
      for (int i = transientStatus.intValue();; i = status) {
        return AttachmentManager.isStatusSuccess(i);
      }
    }
    
    public boolean isStatusValid()
    {
      return AttachmentManager.isStatusValid(status);
    }
    
    public boolean supportsOrigin()
    {
      return false;
    }
    
    public String toString()
    {
      return String.format("Result: conv=%d msg=%d part=%s fname=%s status=%d state=%d size=%d dled=%d transientStatus=%s, transientDestination=%s, transientFile=%s", new Object[] { Long.valueOf(conversationId), Long.valueOf(messageId), partId, fileName, Integer.valueOf(status), Integer.valueOf(state), Integer.valueOf(size), Integer.valueOf(downloadedSize), transientStatus, transientDestination, transientSavedFileUri });
    }
    
    public void updateState(int paramInt1, int paramInt2, String paramString)
    {
      transientStatus = Integer.valueOf(paramInt1);
      transientDestination = Integer.valueOf(paramInt2);
      transientSavedFileUri = paramString;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.AttachmentStatusLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */