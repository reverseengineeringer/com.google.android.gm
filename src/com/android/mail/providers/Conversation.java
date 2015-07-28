package com.android.mail.providers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Conversation
  implements Parcelable
{
  public static final Parcelable.Creator<Conversation> CREATOR = new Parcelable.Creator()
  {
    public Conversation createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Conversation(paramAnonymousParcel, null);
    }
    
    public Conversation[] newArray(int paramAnonymousInt)
    {
      return new Conversation[paramAnonymousInt];
    }
  };
  public static final Collection<Conversation> EMPTY = ;
  public static final Uri MOVE_CONVERSATIONS_URI = Uri.parse("content://moveconversations");
  public Uri accountUri;
  private ArrayList<Folder> cachedDisplayableFolders;
  private ArrayList<Folder> cachedRawFolders;
  public int color;
  public int convFlags;
  public Uri conversationBaseUri;
  public ConversationInfo conversationInfo;
  public long dateMs;
  public boolean hasAttachments;
  public long id;
  public boolean isRemote;
  public transient boolean localDeleteOnUpdate;
  public Uri messageListUri;
  public boolean muted;
  private int numDrafts;
  private int numMessages;
  public int personalLevel;
  public boolean phishing;
  public transient int position;
  public int priority;
  private String rawFolders;
  public boolean read;
  @Deprecated
  public String senders;
  public int sendingState;
  @Deprecated
  public String snippet;
  public boolean spam;
  public boolean starred;
  public String subject;
  public Uri uri;
  private transient boolean viewed;
  
  public Conversation() {}
  
  public Conversation(Cursor paramCursor)
  {
    Object localObject1;
    if (paramCursor != null)
    {
      id = paramCursor.getLong(0);
      uri = Uri.parse(paramCursor.getString(1));
      dateMs = paramCursor.getLong(6);
      subject = paramCursor.getString(3);
      if (subject == null) {
        subject = "";
      }
      if (paramCursor.getInt(7) == 0) {
        break label450;
      }
      bool1 = true;
      hasAttachments = bool1;
      localObject1 = paramCursor.getString(2);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label455;
      }
      localObject1 = Uri.parse((String)localObject1);
      label116:
      messageListUri = ((Uri)localObject1);
      sendingState = paramCursor.getInt(10);
      priority = paramCursor.getInt(11);
      if (paramCursor.getInt(12) == 0) {
        break label461;
      }
      bool1 = true;
      label159:
      read = bool1;
      if (paramCursor.getInt(13) == 0) {
        break label466;
      }
      bool1 = true;
      label177:
      starred = bool1;
      rawFolders = paramCursor.getString(14);
      convFlags = paramCursor.getInt(15);
      personalLevel = paramCursor.getInt(16);
      if (paramCursor.getInt(17) == 0) {
        break label471;
      }
      bool1 = true;
      label231:
      spam = bool1;
      if (paramCursor.getInt(18) == 0) {
        break label476;
      }
      bool1 = true;
      label249:
      phishing = bool1;
      if (paramCursor.getInt(19) == 0) {
        break label481;
      }
      bool1 = true;
      label267:
      muted = bool1;
      color = paramCursor.getInt(20);
      localObject1 = paramCursor.getString(21);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label486;
      }
      localObject1 = Uri.parse((String)localObject1);
      label309:
      accountUri = ((Uri)localObject1);
      position = -1;
      localDeleteOnUpdate = false;
      conversationInfo = ConversationInfo.fromString(paramCursor.getString(5));
      String str = paramCursor.getString(23);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str)) {
        localObject1 = Uri.parse(str);
      }
      conversationBaseUri = ((Uri)localObject1);
      if (conversationInfo == null)
      {
        snippet = paramCursor.getString(4);
        senders = emptyIfNull(paramCursor.getString(22));
        numMessages = paramCursor.getInt(8);
        numDrafts = paramCursor.getInt(9);
      }
      if (paramCursor.getInt(24) == 0) {
        break label492;
      }
    }
    label450:
    label455:
    label461:
    label466:
    label471:
    label476:
    label481:
    label486:
    label492:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      isRemote = bool1;
      return;
      bool1 = false;
      break;
      localObject1 = null;
      break label116;
      bool1 = false;
      break label159;
      bool1 = false;
      break label177;
      bool1 = false;
      break label231;
      bool1 = false;
      break label249;
      bool1 = false;
      break label267;
      localObject1 = null;
      break label309;
    }
  }
  
  private Conversation(Parcel paramParcel)
  {
    id = paramParcel.readLong();
    uri = ((Uri)paramParcel.readParcelable(null));
    subject = paramParcel.readString();
    dateMs = paramParcel.readLong();
    snippet = paramParcel.readString();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      hasAttachments = bool1;
      messageListUri = ((Uri)paramParcel.readParcelable(null));
      senders = emptyIfNull(paramParcel.readString());
      numMessages = paramParcel.readInt();
      numDrafts = paramParcel.readInt();
      sendingState = paramParcel.readInt();
      priority = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {
        break label286;
      }
      bool1 = true;
      label128:
      read = bool1;
      if (paramParcel.readInt() == 0) {
        break label291;
      }
      bool1 = true;
      label142:
      starred = bool1;
      rawFolders = paramParcel.readString();
      convFlags = paramParcel.readInt();
      personalLevel = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {
        break label296;
      }
      bool1 = true;
      label180:
      spam = bool1;
      if (paramParcel.readInt() == 0) {
        break label301;
      }
      bool1 = true;
      label194:
      phishing = bool1;
      if (paramParcel.readInt() == 0) {
        break label306;
      }
      bool1 = true;
      label208:
      muted = bool1;
      color = paramParcel.readInt();
      accountUri = ((Uri)paramParcel.readParcelable(null));
      position = -1;
      localDeleteOnUpdate = false;
      conversationInfo = ConversationInfo.fromString(paramParcel.readString());
      conversationBaseUri = ((Uri)paramParcel.readParcelable(null));
      if (paramParcel.readInt() == 0) {
        break label311;
      }
    }
    label286:
    label291:
    label296:
    label301:
    label306:
    label311:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      isRemote = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label128;
      bool1 = false;
      break label142;
      bool1 = false;
      break label180;
      bool1 = false;
      break label194;
      bool1 = false;
      break label208;
    }
  }
  
  private void clearCachedFolders()
  {
    cachedRawFolders = null;
    cachedDisplayableFolders = null;
  }
  
  public static final boolean contains(Collection<Conversation> paramCollection, Conversation paramConversation)
  {
    boolean bool = true;
    if ((paramCollection == null) || (paramCollection.size() <= 0)) {
      bool = false;
    }
    while (paramConversation == null) {
      return bool;
    }
    long l = id;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (l == nextid) {
        return true;
      }
    }
    return false;
  }
  
  public static Conversation create(long paramLong1, Uri paramUri1, String paramString1, long paramLong2, String paramString2, boolean paramBoolean1, Uri paramUri2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, String paramString4, int paramInt5, int paramInt6, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, Uri paramUri3, ConversationInfo paramConversationInfo, Uri paramUri4, boolean paramBoolean7)
  {
    Conversation localConversation = new Conversation();
    id = paramLong1;
    uri = paramUri1;
    subject = paramString1;
    dateMs = paramLong2;
    snippet = paramString2;
    hasAttachments = paramBoolean1;
    messageListUri = paramUri2;
    senders = emptyIfNull(paramString3);
    numMessages = paramInt1;
    numDrafts = paramInt2;
    sendingState = paramInt3;
    priority = paramInt4;
    read = paramBoolean2;
    starred = paramBoolean3;
    rawFolders = paramString4;
    convFlags = paramInt5;
    personalLevel = paramInt6;
    spam = paramBoolean4;
    phishing = paramBoolean5;
    muted = paramBoolean6;
    color = 0;
    accountUri = paramUri3;
    conversationInfo = paramConversationInfo;
    conversationBaseUri = paramUri4;
    isRemote = paramBoolean7;
    return localConversation;
  }
  
  private static String emptyIfNull(String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  public static SpannableStringBuilder getSubjectAndSnippetForDisplay(Context paramContext, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramContext.getString(2131493016, new Object[] { paramString1, paramString2 });
    }
    return new SpannableStringBuilder(str);
  }
  
  public static Collection<Conversation> listOf(Conversation paramConversation)
  {
    if (paramConversation == null) {
      return EMPTY;
    }
    return ImmutableList.of(paramConversation);
  }
  
  public static String toString(Collection<Conversation> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramCollection.size() + " conversations:");
    int i = 0;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Conversation localConversation = (Conversation)paramCollection.next();
      i += 1;
      localStringBuilder.append("      " + i + ": " + localConversation.toString() + "\n");
    }
    return localStringBuilder.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Conversation)) {
      return uri.equals(uri);
    }
    return false;
  }
  
  public int getNumMessages()
  {
    if (conversationInfo != null) {
      return conversationInfo.messageCount;
    }
    return numMessages;
  }
  
  public ArrayList<Folder> getRawFolders()
  {
    if (cachedRawFolders == null)
    {
      if (!TextUtils.isEmpty(rawFolders)) {
        cachedRawFolders = Folder.getFoldersArray(rawFolders);
      }
    }
    else {
      return cachedRawFolders;
    }
    return new ArrayList();
  }
  
  public ArrayList<Folder> getRawFoldersForDisplay(Folder paramFolder)
  {
    Object localObject = getRawFolders();
    if (cachedDisplayableFolders == null)
    {
      cachedDisplayableFolders = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Folder localFolder = (Folder)((Iterator)localObject).next();
        if ((paramFolder == null) || (!paramFolder.equals(localFolder))) {
          cachedDisplayableFolders.add(localFolder);
        }
      }
    }
    return cachedDisplayableFolders;
  }
  
  public String getRawFoldersString()
  {
    return rawFolders;
  }
  
  public String getSnippet()
  {
    if ((conversationInfo != null) && (!TextUtils.isEmpty(conversationInfo.firstSnippet))) {
      return conversationInfo.firstSnippet;
    }
    return snippet;
  }
  
  public int hashCode()
  {
    return uri.hashCode();
  }
  
  public boolean isImportant()
  {
    return priority == 1;
  }
  
  public boolean isMostlyDead()
  {
    return (convFlags & 0x1) != 0;
  }
  
  public boolean isViewed()
  {
    return viewed;
  }
  
  public void markViewed()
  {
    viewed = true;
  }
  
  public void setRawFolders(String paramString)
  {
    clearCachedFolders();
    rawFolders = paramString;
  }
  
  public String toString()
  {
    return "[conversation id=" + id + ", subject =" + subject + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(id);
    paramParcel.writeParcelable(uri, paramInt);
    paramParcel.writeString(subject);
    paramParcel.writeLong(dateMs);
    paramParcel.writeString(snippet);
    if (hasAttachments)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeParcelable(messageListUri, 0);
      paramParcel.writeString(senders);
      paramParcel.writeInt(numMessages);
      paramParcel.writeInt(numDrafts);
      paramParcel.writeInt(sendingState);
      paramParcel.writeInt(priority);
      if (!read) {
        break label257;
      }
      paramInt = 1;
      label115:
      paramParcel.writeInt(paramInt);
      if (!starred) {
        break label262;
      }
      paramInt = 1;
      label129:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(rawFolders);
      paramParcel.writeInt(convFlags);
      paramParcel.writeInt(personalLevel);
      if (!spam) {
        break label267;
      }
      paramInt = 1;
      label167:
      paramParcel.writeInt(paramInt);
      if (!phishing) {
        break label272;
      }
      paramInt = 1;
      label181:
      paramParcel.writeInt(paramInt);
      if (!muted) {
        break label277;
      }
      paramInt = 1;
      label195:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(color);
      paramParcel.writeParcelable(accountUri, 0);
      paramParcel.writeString(ConversationInfo.toString(conversationInfo));
      paramParcel.writeParcelable(conversationBaseUri, 0);
      if (!isRemote) {
        break label282;
      }
    }
    label257:
    label262:
    label267:
    label272:
    label277:
    label282:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label115;
      paramInt = 0;
      break label129;
      paramInt = 0;
      break label167;
      paramInt = 0;
      break label181;
      paramInt = 0;
      break label195;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Conversation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */