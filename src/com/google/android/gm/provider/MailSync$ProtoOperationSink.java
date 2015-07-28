package com.google.android.gm.provider;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.common.base.Strings;
import com.google.android.common.http.FilePart;
import com.google.android.common.http.Part;
import com.google.android.gsf.Gservices;
import com.google.common.collect.BiMap;
import com.google.common.collect.Lists;
import com.google.common.io.protocol.ProtoBuf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;

class MailSync$ProtoOperationSink
  extends MailSync.AbstractOperationSink
{
  private final ArrayList<NameValuePair> mParams;
  private ArrayList<Part> mParts;
  ProtoBuf mUphillSyncProto;
  
  MailSync$ProtoOperationSink(MailSync paramMailSync, ProtoBuf paramProtoBuf)
  {
    super(paramMailSync, null);
    mUphillSyncProto = paramProtoBuf;
    mParams = Lists.newArrayList();
    mParts = null;
  }
  
  private ProtoBuf newOperationProto(long paramLong)
  {
    ProtoBuf localProtoBuf = mUphillSyncProto.addNewProtoBuf(1);
    localProtoBuf.setLong(1, paramLong);
    return localProtoBuf;
  }
  
  private void notifyAttachmentFailed(MailSync.Message paramMessage, Gmail.Attachment paramAttachment)
  {
    paramAttachment = new Intent("com.google.android.gm.intent.ACTION_POST_SEND_ERROR");
    paramAttachment.putExtra("account", MailSync.access$300(this$0).getAccount());
    paramAttachment.putExtra("extraMessageSubject", subject);
    paramAttachment.putExtra("extraConversationId", conversationId);
    MailSync.access$000(this$0).sendBroadcast(paramAttachment);
  }
  
  private boolean shouldIgnoreLabelOperation(long paramLong)
  {
    return paramLong == 0L;
  }
  
  public void conversationLabelAddedOrRemoved(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    if (shouldIgnoreLabelOperation(paramLong3)) {
      return;
    }
    ProtoBuf localProtoBuf = newOperationProto(paramLong1).setNewProtoBuf(3);
    localProtoBuf.setBool(3, paramBoolean);
    localProtoBuf.setLong(1, paramLong2);
    if (!MailCore.isLabelIdLocal(paramLong3))
    {
      localProtoBuf.setLong(2, paramLong3);
      return;
    }
    localProtoBuf.setString(4, (String)Gmail.LOCAL_PRIORITY_LABELS.get(Long.valueOf(paramLong3)));
  }
  
  public int getNumOperations()
  {
    return mUphillSyncProto.getCount(1);
  }
  
  public ArrayList<Part> getParts()
  {
    return mParts;
  }
  
  public boolean hasAttachments()
  {
    return (mParts != null) && (mParts.size() > 0);
  }
  
  public void messageExpunged(long paramLong1, long paramLong2)
  {
    newOperationProto(paramLong1).setLong(5, paramLong2);
  }
  
  public void messageLabelAdded(long paramLong1, long paramLong2, long paramLong3)
  {
    if (shouldIgnoreLabelOperation(paramLong3)) {
      return;
    }
    ProtoBuf localProtoBuf = newOperationProto(paramLong1).setNewProtoBuf(2);
    localProtoBuf.setBool(3, true);
    localProtoBuf.setLong(1, paramLong2);
    if (!MailCore.isLabelIdLocal(paramLong3))
    {
      localProtoBuf.setLong(2, paramLong3);
      return;
    }
    localProtoBuf.setString(4, (String)Gmail.LOCAL_PRIORITY_LABELS.get(Long.valueOf(paramLong3)));
  }
  
  public void messageLabelRemoved(long paramLong1, long paramLong2, long paramLong3)
  {
    if (shouldIgnoreLabelOperation(paramLong3)) {
      return;
    }
    ProtoBuf localProtoBuf = newOperationProto(paramLong1).setNewProtoBuf(2);
    localProtoBuf.setBool(3, false);
    localProtoBuf.setLong(1, paramLong2);
    localProtoBuf.setLong(2, paramLong3);
  }
  
  public void messageSavedOrSent(long paramLong1, MailSync.Message paramMessage, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    LogUtils.v("Gmail", "MailSync posting operation %d (messageSavedOrSent)", new Object[] { Long.valueOf(paramLong1) });
    ProtoBuf localProtoBuf = newOperationProto(paramLong1).setNewProtoBuf(4);
    localProtoBuf.setBool(10, paramBoolean);
    localProtoBuf.setLong(1, paramLong2);
    localProtoBuf.setLong(2, paramLong3);
    localProtoBuf.setString(3, TextUtils.join(", ", toAddresses));
    localProtoBuf.setString(4, TextUtils.join(", ", ccAddresses));
    localProtoBuf.setString(5, TextUtils.join(", ", bccAddresses));
    String str;
    label135:
    int k;
    Iterator localIterator;
    if (subject != null)
    {
      str = subject;
      localProtoBuf.setString(6, str);
      if (body == null) {
        break label352;
      }
      str = body;
      localProtoBuf.setString(7, str);
      if ((!clientCreated) || (!includeQuotedText)) {
        break label360;
      }
      localProtoBuf.setBool(11, true);
      localProtoBuf.setLong(13, quoteStartPos);
      if (forward) {
        localProtoBuf.setBool(12, true);
      }
      if (!TextUtils.isEmpty(customFromAddress))
      {
        localProtoBuf.setBool(14, true);
        localProtoBuf.setString(15, customFromAddress);
        LogUtils.v("Gmail", "Uphill Sync operation with custom from address: %s", new Object[] { customFromAddress });
      }
      k = 1;
      localIterator = attachments.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label844;
      }
      Gmail.Attachment localAttachment = (Gmail.Attachment)localIterator.next();
      switch (MailSync.2.$SwitchMap$com$google$android$gm$provider$Gmail$AttachmentOrigin[origin.ordinal()])
      {
      default: 
        throw new IllegalArgumentException("Unknown origin: " + origin);
        str = "";
        break;
        str = "";
        break label135;
        localProtoBuf.setBool(11, false);
        break;
      case 1: 
        localProtoBuf.addString(8, originExtras);
        break;
      case 2: 
        label352:
        label360:
        str = originExtras;
        int i;
        label440:
        int j;
        byte[] arrayOfByte1;
        if (Strings.isNullOrEmpty(partId))
        {
          str = messageId + "-" + k;
          i = k + 1;
          if (Gservices.getInt(MailSync.access$200(this$0), "gmail_use_multipart_protobuf", 1) == 0) {
            break label633;
          }
          j = 1;
          arrayOfByte1 = null;
          if (j == 0) {
            break label711;
          }
        }
        for (;;)
        {
          Object localObject2;
          try
          {
            localObject2 = new FilePart(str, new MailSync.AttachmentPartSource(this$0, messageId, localAttachment), contentType, null);
            if (mParts == null) {
              mParts = new ArrayList();
            }
            mParts.add(localObject2);
            localObject2 = localProtoBuf.addNewProtoBuf(9);
            ((ProtoBuf)localObject2).setString(1, str);
            ((ProtoBuf)localObject2).setString(2, name);
            ((ProtoBuf)localObject2).setString(3, contentType);
            k = i;
            if (j != 0) {
              break;
            }
            ((ProtoBuf)localObject2).setBytes(4, arrayOfByte1);
            k = i;
            break;
            str = messageId + "-" + partId;
            i = k;
            break label440;
            label633:
            j = 0;
          }
          catch (IOException localIOException1)
          {
            LogUtils.e("Gmail", localIOException1, "IO error while reading attachment: %s", new Object[] { str });
            notifyAttachmentFailed(paramMessage, localAttachment);
            k = i;
            break;
          }
          catch (SecurityException localSecurityException)
          {
            LogUtils.e("Gmail", localSecurityException, "SecurityException while reading attachment: %S", new Object[] { str });
            notifyAttachmentFailed(paramMessage, localAttachment);
            k = i;
          }
          break;
          try
          {
            label711:
            Object localObject1 = MailSync.access$300(this$0).getInputStreamForUploadedAttachment(messageId, localAttachment);
            localObject2 = new ByteArrayOutputStream();
            byte[] arrayOfByte2 = new byte['Ѐ'];
            paramLong1 = SystemClock.elapsedRealtime();
            do
            {
              k = ((InputStream)localObject1).read(arrayOfByte2);
              if (k < 0)
              {
                localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
                break;
              }
              ((ByteArrayOutputStream)localObject2).write(arrayOfByte2, 0, k);
            } while (SystemClock.elapsedRealtime() - paramLong1 <= 3600000L);
            throw new IOException("Timed out reading attachment");
          }
          catch (IOException localIOException2)
          {
            LogUtils.e("Gmail", localIOException2, "IO error while reading attachment: %s", new Object[] { str });
            notifyAttachmentFailed(paramMessage, localAttachment);
            k = i;
          }
        }
      }
    }
    label844:
    LogUtils.v("Gmail", "messageSavedOrSent: message = %s", new Object[] { localProtoBuf });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSync.ProtoOperationSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */