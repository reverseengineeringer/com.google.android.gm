package com.android.mail.browse;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.style.CharacterStyle;
import android.util.LruCache;
import android.util.Pair;
import android.widget.TextView;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Folder;
import com.android.mail.providers.MessageInfo;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;

public class ConversationItemViewModel
{
  private static Folder sCachedModelsFolder;
  static LruCache<Pair<String, Long>, ConversationItemViewModel> sConversationHeaderMap = new LruCache(100);
  public boolean checkboxVisible;
  public Conversation conversation;
  Bitmap dateBackground;
  String dateText;
  boolean faded = false;
  public ConversationItemView.ConversationItemFolderDisplayer folderDisplayer;
  public boolean hasBeenForwarded;
  public boolean hasBeenRepliedTo;
  public boolean isInvite;
  private String mContentDescription;
  private int mDataHashCode;
  private int mLayoutHashCode;
  public SpannableStringBuilder messageInfoString;
  Bitmap paperclip;
  Bitmap personalLevelBitmap;
  final ArrayList<SenderFragment> senderFragments = Lists.newArrayList();
  StaticLayout sendersDisplayLayout;
  SpannableStringBuilder sendersDisplayText;
  String sendersText;
  public TextView sendersTextView;
  public int standardScaledDimen;
  public int styledMessageInfoStringOffset;
  public SpannableString[] styledSenders;
  public SpannableStringBuilder styledSendersString;
  SpannableStringBuilder subjectText;
  boolean unread;
  public int viewWidth;
  
  static ConversationItemViewModel forConversation(String paramString, Conversation paramConversation)
  {
    boolean bool2 = true;
    paramString = forConversationId(paramString, id);
    if (paramConversation != null)
    {
      faded = false;
      checkboxVisible = true;
      conversation = paramConversation;
      if (read) {
        break label101;
      }
      bool1 = true;
      unread = bool1;
      if ((convFlags & 0x8) != 8) {
        break label106;
      }
      bool1 = true;
      label58:
      hasBeenForwarded = bool1;
      if ((convFlags & 0x4) != 4) {
        break label111;
      }
      bool1 = true;
      label75:
      hasBeenRepliedTo = bool1;
      if ((convFlags & 0x10) != 16) {
        break label116;
      }
    }
    label101:
    label106:
    label111:
    label116:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      isInvite = bool1;
      return paramString;
      bool1 = false;
      break;
      bool1 = false;
      break label58;
      bool1 = false;
      break label75;
    }
  }
  
  static ConversationItemViewModel forConversationId(String paramString, long paramLong)
  {
    synchronized (sConversationHeaderMap)
    {
      ConversationItemViewModel localConversationItemViewModel2 = forConversationIdOrNull(paramString, paramLong);
      ConversationItemViewModel localConversationItemViewModel1 = localConversationItemViewModel2;
      if (localConversationItemViewModel2 == null)
      {
        paramString = new Pair(paramString, Long.valueOf(paramLong));
        localConversationItemViewModel1 = new ConversationItemViewModel();
        sConversationHeaderMap.put(paramString, localConversationItemViewModel1);
      }
      return localConversationItemViewModel1;
    }
  }
  
  static ConversationItemViewModel forConversationIdOrNull(String arg0, long paramLong)
  {
    Object localObject1 = new Pair(???, Long.valueOf(paramLong));
    synchronized (sConversationHeaderMap)
    {
      localObject1 = (ConversationItemViewModel)sConversationHeaderMap.get(localObject1);
      return (ConversationItemViewModel)localObject1;
    }
  }
  
  static ConversationItemViewModel forCursor(String paramString, Cursor paramCursor)
  {
    return forConversation(paramString, new Conversation(paramCursor));
  }
  
  private Object getConvInfo()
  {
    if (conversation.conversationInfo != null) {
      return conversation.conversationInfo;
    }
    return conversation.getSnippet();
  }
  
  private static int getHashCode(Context paramContext, String paramString1, Object paramObject, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (paramString1 == null) {
      return -1;
    }
    paramContext = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramContext = "";
    }
    return Objects.hashCode(new Object[] { paramObject, paramString1, paramContext, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private int getLayoutHashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(mDataHashCode), Integer.valueOf(viewWidth), Integer.valueOf(standardScaledDimen), Boolean.valueOf(checkboxVisible) });
  }
  
  public static void onAccessibilityUpdated()
  {
    sConversationHeaderMap.evictAll();
  }
  
  public static void onFolderUpdated(Folder paramFolder)
  {
    Uri localUri1;
    if (sCachedModelsFolder != null)
    {
      localUri1 = sCachedModelsFolderuri;
      if (paramFolder == null) {
        break label48;
      }
    }
    label48:
    for (Uri localUri2 = uri;; localUri2 = Uri.EMPTY)
    {
      if (!localUri1.equals(localUri2))
      {
        sCachedModelsFolder = paramFolder;
        sConversationHeaderMap.evictAll();
      }
      return;
      localUri1 = Uri.EMPTY;
      break;
    }
  }
  
  void addSenderFragment(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle, boolean paramBoolean)
  {
    paramCharacterStyle = new SenderFragment(paramInt1, paramInt2, sendersText, paramCharacterStyle, paramBoolean);
    senderFragments.add(paramCharacterStyle);
  }
  
  public CharSequence getContentDescription(Context paramContext)
  {
    Object localObject1;
    Object localObject2;
    String str;
    if (mContentDescription == null)
    {
      localObject1 = "";
      localObject2 = localObject1;
      if (conversation.conversationInfo != null)
      {
        str = "";
        if (conversation.conversationInfo.messageInfos == null) {
          break label208;
        }
        i = conversation.conversationInfo.messageInfos.size() - 1;
        if (i != -1) {
          str = conversation.conversationInfo.messageInfos.get(i)).sender;
        }
        if (!conversation.read) {
          break label220;
        }
        if (!TextUtils.isEmpty(str)) {
          break label213;
        }
        localObject1 = SendersView.getMe(paramContext);
        label109:
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = str;
        }
      }
      boolean bool = DateUtils.isToday(conversation.dateMs);
      localObject1 = DateUtils.getRelativeTimeSpanString(paramContext, conversation.dateMs).toString();
      if (!bool) {
        break label307;
      }
    }
    label208:
    label213:
    label220:
    label307:
    for (int i = 2131493014;; i = 2131493013)
    {
      mContentDescription = paramContext.getString(i, new Object[] { localObject2, conversation.subject, conversation.getSnippet(), localObject1 });
      return mContentDescription;
      i = -1;
      break;
      localObject1 = str;
      break label109;
      Object localObject3 = null;
      Iterator localIterator = conversation.conversationInfo.messageInfos.iterator();
      do
      {
        localObject2 = localObject3;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (MessageInfo)localIterator.next();
      } while (read);
      if (localObject2 == null) {
        break label109;
      }
      if (TextUtils.isEmpty(sender)) {}
      for (localObject1 = SendersView.getMe(paramContext);; localObject1 = sender) {
        break;
      }
    }
  }
  
  boolean isDataValid(Context paramContext)
  {
    return mDataHashCode == getHashCode(paramContext, dateText, getConvInfo(), conversation.getRawFoldersString(), conversation.starred, conversation.read, conversation.priority, conversation.sendingState);
  }
  
  boolean isLayoutValid(Context paramContext)
  {
    return (isDataValid(paramContext)) && (mLayoutHashCode == getLayoutHashCode());
  }
  
  public void resetContentDescription()
  {
    mContentDescription = null;
  }
  
  void validate(Context paramContext)
  {
    mDataHashCode = getHashCode(paramContext, dateText, getConvInfo(), conversation.getRawFoldersString(), conversation.starred, conversation.read, conversation.priority, conversation.sendingState);
    mLayoutHashCode = getLayoutHashCode();
  }
  
  static class SenderFragment
  {
    String ellipsizedText;
    int end;
    boolean isFixed;
    boolean shouldDisplay;
    int start;
    CharacterStyle style;
    int width;
    
    SenderFragment(int paramInt1, int paramInt2, CharSequence paramCharSequence, CharacterStyle paramCharacterStyle, boolean paramBoolean)
    {
      start = paramInt1;
      end = paramInt2;
      style = paramCharacterStyle;
      isFixed = paramBoolean;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationItemViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */