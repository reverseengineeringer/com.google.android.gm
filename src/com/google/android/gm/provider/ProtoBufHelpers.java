package com.google.android.gm.provider;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.io.protocol.ProtoBuf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ProtoBufHelpers
{
  public static void getAllLongs(ProtoBuf paramProtoBuf, int paramInt, Collection<Long> paramCollection)
  {
    int j = paramProtoBuf.getCount(paramInt);
    int i = 0;
    while (i < j)
    {
      paramCollection.add(Long.valueOf(paramProtoBuf.getLong(paramInt, i)));
      i += 1;
    }
  }
  
  public static void getAllProtoBufs(ProtoBuf paramProtoBuf, int paramInt, Collection<ProtoBuf> paramCollection)
  {
    int j = paramProtoBuf.getCount(paramInt);
    int i = 0;
    while (i < j)
    {
      paramCollection.add(paramProtoBuf.getProtoBuf(paramInt, i));
      i += 1;
    }
  }
  
  public static void getAllStrings(ProtoBuf paramProtoBuf, int paramInt, Collection<String> paramCollection)
  {
    int j = paramProtoBuf.getCount(paramInt);
    int i = 0;
    while (i < j)
    {
      paramCollection.add(paramProtoBuf.getString(paramInt, i));
      i += 1;
    }
  }
  
  public static void printConfigInfoProto(ProtoBuf paramProtoBuf)
  {
    LogUtils.d("Gmail", "ConfigInfoProto: Conversation Age Days: %d", new Object[] { Long.valueOf(paramProtoBuf.getLong(1)) });
    HashSet localHashSet1 = Sets.newHashSet();
    HashSet localHashSet2 = Sets.newHashSet();
    getAllStrings(paramProtoBuf, 2, localHashSet1);
    LogUtils.d("Gmail", "ConfigInfoProto: Included Canonical Label Name: %s", new Object[] { localHashSet1 });
    getAllStrings(paramProtoBuf, 3, localHashSet2);
    LogUtils.d("Gmail", "ConfigInfoProto: Duration Canonical Label Name: %s", new Object[] { localHashSet2 });
  }
  
  public static void printForwardSyncProto(ProtoBuf paramProtoBuf)
  {
    LogUtils.d("Gmail", "ForwardSyncProto: operationid: %d", new Object[] { Long.valueOf(paramProtoBuf.getLong(1)) });
    boolean bool1;
    boolean bool2;
    label64:
    boolean bool3;
    if (paramProtoBuf.has(2))
    {
      paramProtoBuf = paramProtoBuf.getProtoBuf(2);
      long l = paramProtoBuf.getLong(2);
      int i = paramProtoBuf.getInt(1);
      if (i == 0)
      {
        bool1 = true;
        if (i != 1) {
          break label197;
        }
        bool2 = true;
        if (i != 2) {
          break label203;
        }
        bool3 = true;
        label72:
        LogUtils.d("Gmail", "ForwardSyncProto: ThreadLabelOrUnlabeled, conversationId: %d,labelAdded: %b labelRemoved: %b messagesExpunged: %b", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((bool1) || (bool2)) {
          LogUtils.d("Gmail", "ForwardSyncProto: ThreadLabelOrUnLabel, labelId: %d", new Object[] { Long.valueOf(paramProtoBuf.getLong(3)) });
        }
        i = paramProtoBuf.getInt(4);
        ArrayList localArrayList = Lists.newArrayList();
        getAllLongs(paramProtoBuf, 5, localArrayList);
        LogUtils.d("Gmail", "ForwardSyncProto: syncRationale: %d, messageIds: %s", new Object[] { Integer.valueOf(i), localArrayList });
      }
    }
    label197:
    label203:
    do
    {
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label64;
      bool3 = false;
      break label72;
      if (paramProtoBuf.has(3))
      {
        paramProtoBuf = paramProtoBuf.getProtoBuf(3);
        LogUtils.d("Gmail", "ForwardSyncProto: LabelCreated, labelId: %d canonicalName: %sdisplayName: %s", new Object[] { Long.valueOf(paramProtoBuf.getLong(1)), paramProtoBuf.getString(2), paramProtoBuf.getString(3) });
        return;
      }
      if (paramProtoBuf.has(4))
      {
        paramProtoBuf = paramProtoBuf.getProtoBuf(4);
        LogUtils.d("Gmail", "ForwardSyncProto: LabelRenamed, labelId: %d newCanonicalName: %s newDisplayName: %s", new Object[] { Long.valueOf(paramProtoBuf.getLong(1)), paramProtoBuf.getString(2), paramProtoBuf.getString(3) });
        return;
      }
    } while (!paramProtoBuf.has(5));
    LogUtils.d("Gmail", "ForwardSyncProto: LabelDeleted, labelId: %d", new Object[] { Long.valueOf(paramProtoBuf.getProtoBuf(5).getLong(1)) });
  }
  
  public static void printHttpResponseChunkProto(ProtoBuf paramProtoBuf)
  {
    StringBuffer localStringBuffer = new StringBuffer("HttpResponseChunk: ");
    if (paramProtoBuf.has(2)) {
      localStringBuffer.append("ConfigInfo");
    }
    for (;;)
    {
      LogUtils.d("Gmail", localStringBuffer.toString(), new Object[0]);
      return;
      if (paramProtoBuf.has(3)) {
        localStringBuffer.append("ConfigAccepted");
      } else if (paramProtoBuf.has(4)) {
        localStringBuffer.append("StartSync");
      } else if (paramProtoBuf.has(5)) {
        localStringBuffer.append("UphillSync");
      } else if (paramProtoBuf.has(7)) {
        localStringBuffer.append("ForwardSync");
      } else if (paramProtoBuf.has(8)) {
        localStringBuffer.append("CheckConversation");
      } else if (paramProtoBuf.has(9)) {
        localStringBuffer.append("BeginConversation");
      } else if (paramProtoBuf.has(10)) {
        localStringBuffer.append("BeginMessage");
      } else if (paramProtoBuf.has(16)) {
        localStringBuffer.append("NoConversation");
      } else if (paramProtoBuf.has(17)) {
        localStringBuffer.append("NoMessage");
      } else if (paramProtoBuf.has(14)) {
        localStringBuffer.append("SyncPostamble");
      }
    }
  }
  
  public static void printHttpResponseProto(ProtoBuf paramProtoBuf)
  {
    int i = -1;
    if (paramProtoBuf.has(2)) {
      i = paramProtoBuf.getInt(2);
    }
    if ((paramProtoBuf.has(3)) && (paramProtoBuf.getBool(3))) {}
    for (boolean bool = true;; bool = false)
    {
      long l = -1L;
      if (paramProtoBuf.has(6)) {
        l = paramProtoBuf.getInt(6);
      }
      String str = "noWipeDescription";
      if (paramProtoBuf.has(5)) {
        str = paramProtoBuf.getString(5);
      }
      int j = -1;
      if (paramProtoBuf.has(1)) {
        j = paramProtoBuf.getInt(1);
      }
      LogUtils.d("Gmail", "HttpProtoResponse: serverVersion: %d, hasVersionError: %b, delay: %d, responseVersion: %d wipeDescription: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(l), Integer.valueOf(j), str });
      return;
    }
  }
  
  public static void printStartSyncInfoProto(ProtoBuf paramProtoBuf)
  {
    int k = paramProtoBuf.getCount(4);
    LogUtils.d("Gmail", "StartSyncInfoProto: Labels: numLabels: %d", new Object[] { Integer.valueOf(k) });
    int i = 0;
    while (i < k)
    {
      ProtoBuf localProtoBuf = paramProtoBuf.getProtoBuf(4, i);
      long l = localProtoBuf.getLong(1);
      String str2 = localProtoBuf.getString(2);
      String str3 = localProtoBuf.getString(3);
      int m = localProtoBuf.getInt(4);
      int n = localProtoBuf.getInt(5);
      int j = -1;
      if (localProtoBuf.has(6)) {
        j = localProtoBuf.getInt(6);
      }
      String str1 = "Default";
      if (localProtoBuf.has(7)) {
        str1 = localProtoBuf.getString(7);
      }
      LogUtils.d("Gmail", "StartSyncInfoProto: Label id: %d canonicalName: %s displayName: %snumConversations: %d numUnreadConversations: %d color: %d visibility: %s", new Object[] { Long.valueOf(l), str2, str3, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), str1 });
      i += 1;
    }
  }
  
  public static void printSyncPostambleProto(ProtoBuf paramProtoBuf)
  {
    Object localObject = Lists.newArrayList();
    getAllProtoBufs(paramProtoBuf, 5, (Collection)localObject);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ProtoBuf localProtoBuf = (ProtoBuf)((Iterator)localObject).next();
      int j = localProtoBuf.getInt(2);
      int i = Integer.MAX_VALUE;
      if (localProtoBuf.has(4)) {
        i = localProtoBuf.getInt(4);
      }
      int k = localProtoBuf.getInt(3);
      long l = localProtoBuf.getLong(1);
      paramProtoBuf = "SHOW";
      if (localProtoBuf.has(5)) {
        paramProtoBuf = localProtoBuf.getString(5);
      }
      LogUtils.d("Gmail", "SyncPostAmbleProto: labelId: %d, count: %d, unreadCount: %d, color: %d, visibility: %s", new Object[] { Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramProtoBuf });
    }
  }
  
  public static void printUphillSyncProto(ProtoBuf paramProtoBuf)
  {
    int j = paramProtoBuf.getCount(1);
    LogUtils.d("Gmail", "UphillSyncProto: numNothandled: %d", new Object[] { Integer.valueOf(j) });
    int i = 0;
    ProtoBuf localProtoBuf;
    while (i < j)
    {
      localProtoBuf = paramProtoBuf.getProtoBuf(1, i);
      LogUtils.d("Gmail", "UphillSyncProto: Nothandled: messageId: %d, error: %s", new Object[] { Long.valueOf(localProtoBuf.getLong(1)), localProtoBuf.getString(2) });
      i += 1;
    }
    j = paramProtoBuf.getCount(2);
    LogUtils.d("Gmail", "UphillSyncProto: numSavedOrSent: %d", new Object[] { Integer.valueOf(j) });
    i = 0;
    while (i < j)
    {
      localProtoBuf = paramProtoBuf.getProtoBuf(2, i);
      LogUtils.d("Gmail", "UphillSyncProto: SavedOrSent: messageIDOnClient: %d messageId: %d conversationId: %d", new Object[] { Long.valueOf(localProtoBuf.getLong(1)), Long.valueOf(localProtoBuf.getLong(2)), Long.valueOf(localProtoBuf.getLong(3)) });
      i += 1;
    }
    if (paramProtoBuf.has(3)) {
      LogUtils.d("Gmail", "UphillSyncProto: handledOperationId: %d", new Object[] { Long.valueOf(paramProtoBuf.getLong(3)) });
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.ProtoBufHelpers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */