package com.android.mail.browse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.TextAppearanceSpan;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.MessageInfo;
import com.android.mail.utils.ObjectCache;
import com.android.mail.utils.ObjectCache.Callback;
import com.android.mail.utils.Utils;
import com.google.android.common.html.parser.HtmlParser;
import com.google.android.common.html.parser.HtmlTreeBuilder;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class SendersView
{
  private static final Integer DOES_NOT_EXIST = Integer.valueOf(-5);
  private static final ObjectCache<Map<Integer, Integer>> PRIORITY_LENGTH_MAP_CACHE = new ObjectCache(new ObjectCache.Callback()
  {
    public Map<Integer, Integer> newInstance()
    {
      return Maps.newHashMap();
    }
    
    public void onObjectReleased(Map<Integer, Integer> paramAnonymousMap)
    {
      paramAnonymousMap.clear();
    }
  }, 2);
  public static String SENDERS_VERSION_SEPARATOR = "^**^";
  public static Pattern SENDERS_VERSION_SEPARATOR_PATTERN = Pattern.compile("\\^\\*\\*\\^");
  private static BroadcastReceiver sConfigurationChangedReceiver;
  private static String sDraftCountFormatString;
  private static CharSequence sDraftPluralString;
  private static CharSequence sDraftSingularString;
  private static CharacterStyle sDraftsStyleSpan;
  public static CharSequence sElidedString;
  private static String sMeString;
  private static String sMessageCountSpacerString;
  private static CharacterStyle sMessageInfoStyleSpan;
  private static CharacterStyle sReadStyleSpan;
  private static String sSendersSplitToken;
  private static CharSequence sSendingString;
  private static CharacterStyle sSendingStyleSpan;
  private static CharacterStyle sUnreadStyleSpan;
  
  public static SpannableStringBuilder createMessageInfo(Context paramContext, Conversation paramConversation)
  {
    ConversationInfo localConversationInfo = conversationInfo;
    int n = sendingState;
    paramConversation = new SpannableStringBuilder();
    int j = 0;
    Iterator localIterator = messageInfos.iterator();
    do
    {
      i = j;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (TextUtils.isEmpty(nextsender));
    int i = 1;
    getSenderResources(paramContext);
    paramContext = paramConversation;
    int k;
    int m;
    if (localConversationInfo != null)
    {
      k = messageCount;
      m = draftCount;
      if (n != 2) {
        break label309;
      }
      j = 1;
      if (k > 1) {
        paramConversation.append(k + "");
      }
      paramConversation.setSpan(CharacterStyle.wrap(sMessageInfoStyleSpan), 0, paramConversation.length(), 0);
      if (m > 0)
      {
        if ((i != 0) || (k > 1)) {
          paramConversation.append(sSendersSplitToken);
        }
        paramContext = new SpannableStringBuilder();
        if (m != 1) {
          break label314;
        }
        paramContext.append(sDraftSingularString);
      }
    }
    for (;;)
    {
      paramContext.setSpan(CharacterStyle.wrap(sDraftsStyleSpan), 0, paramContext.length(), 33);
      paramConversation.append(paramContext);
      if (j != 0)
      {
        if ((k > 1) || (m > 0)) {
          paramConversation.append(sSendersSplitToken);
        }
        paramContext = new SpannableStringBuilder();
        paramContext.append(sSendingString);
        paramContext.setSpan(sSendingStyleSpan, 0, paramContext.length(), 0);
        paramConversation.append(paramContext);
      }
      if ((k <= 1) && ((m <= 0) || (i == 0)))
      {
        paramContext = paramConversation;
        if (j == 0) {}
      }
      else
      {
        paramContext = new SpannableStringBuilder(sMessageCountSpacerString).append(paramConversation);
      }
      return paramContext;
      label309:
      j = 0;
      break;
      label314:
      paramContext.append(sDraftPluralString + String.format(sDraftCountFormatString, new Object[] { Integer.valueOf(m) }));
    }
  }
  
  public static SpannableString[] format(Context paramContext, ConversationInfo paramConversationInfo, String paramString, int paramInt, HtmlParser paramHtmlParser, HtmlTreeBuilder paramHtmlTreeBuilder)
  {
    getSenderResources(paramContext);
    paramContext = handlePriority(paramContext, paramInt, paramString.toString(), paramConversationInfo, paramHtmlParser, paramHtmlTreeBuilder);
    return (SpannableString[])paramContext.toArray(new SpannableString[paramContext.size()]);
  }
  
  private static void formatDefault(ConversationItemViewModel paramConversationItemViewModel, String paramString, Context paramContext)
  {
    getSenderResources(paramContext);
    senderFragments.clear();
    String[] arrayOfString1 = TextUtils.split(paramString, ",");
    String[] arrayOfString2 = new String[arrayOfString1.length];
    int i = 0;
    while (i < arrayOfString1.length)
    {
      Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(arrayOfString1[i]);
      if ((arrayOfRfc822Token != null) && (arrayOfRfc822Token.length > 0))
      {
        paramContext = arrayOfRfc822Token[0].getName();
        paramString = paramContext;
        if (TextUtils.isEmpty(paramContext)) {
          paramString = arrayOfRfc822Token[0].getAddress();
        }
        arrayOfString2[i] = paramString;
      }
      i += 1;
    }
    generateSenderFragments(paramConversationItemViewModel, arrayOfString2);
  }
  
  public static void formatSenders(ConversationItemViewModel paramConversationItemViewModel, Context paramContext)
  {
    formatDefault(paramConversationItemViewModel, conversation.senders, paramContext);
  }
  
  private static void generateSenderFragments(ConversationItemViewModel paramConversationItemViewModel, String[] paramArrayOfString)
  {
    sendersText = TextUtils.join(", ", paramArrayOfString);
    paramConversationItemViewModel.addSenderFragment(0, sendersText.length(), getReadStyleSpan(), true);
  }
  
  static String getMe(Context paramContext)
  {
    if (sMeString == null) {
      sMeString = paramContext.getResources().getString(2131493019);
    }
    return sMeString;
  }
  
  private static CharacterStyle getReadStyleSpan()
  {
    return CharacterStyle.wrap(sReadStyleSpan);
  }
  
  private static void getSenderResources(Context paramContext)
  {
    if (sConfigurationChangedReceiver == null)
    {
      sConfigurationChangedReceiver = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          SendersView.access$002(null);
          SendersView.getSenderResources(paramAnonymousContext);
        }
      };
      paramContext.registerReceiver(sConfigurationChangedReceiver, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }
    if (sDraftSingularString == null)
    {
      Resources localResources = paramContext.getResources();
      sSendersSplitToken = localResources.getString(2131493120);
      sElidedString = localResources.getString(2131493122);
      sDraftSingularString = localResources.getQuantityText(2131820546, 1);
      sDraftPluralString = localResources.getQuantityText(2131820546, 2);
      sDraftCountFormatString = localResources.getString(2131493121);
      sMessageInfoStyleSpan = new TextAppearanceSpan(paramContext, 2131558471);
      sDraftsStyleSpan = new TextAppearanceSpan(paramContext, 2131558472);
      sUnreadStyleSpan = new TextAppearanceSpan(paramContext, 2131558475);
      sSendingStyleSpan = new TextAppearanceSpan(paramContext, 2131558473);
      sReadStyleSpan = new TextAppearanceSpan(paramContext, 2131558474);
      sMessageCountSpacerString = localResources.getString(2131493124);
      sSendingString = localResources.getString(2131493017);
    }
  }
  
  public static Typeface getTypeface(boolean paramBoolean)
  {
    if (paramBoolean) {
      return Typeface.DEFAULT_BOLD;
    }
    return Typeface.DEFAULT;
  }
  
  private static CharacterStyle getUnreadStyleSpan()
  {
    return CharacterStyle.wrap(sUnreadStyleSpan);
  }
  
  public static ArrayList<SpannableString> handlePriority(Context paramContext, int paramInt, String paramString, ConversationInfo paramConversationInfo, HtmlParser paramHtmlParser, HtmlTreeBuilder paramHtmlTreeBuilder)
  {
    int i2 = -1;
    int i3 = paramString.length();
    int i4 = 0;
    int j = 0;
    int m = 0;
    if (i3 > paramInt) {
      j = i3 - paramInt;
    }
    paramString = (Map)PRIORITY_LENGTH_MAP_CACHE.get();
    for (;;)
    {
      int k;
      int i1;
      int n;
      Object localObject2;
      int i;
      try
      {
        paramString.clear();
        localObject1 = messageInfos.iterator();
        k = i2;
        i1 = i3;
        n = i4;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageInfo)((Iterator)localObject1).next();
          if (TextUtils.isEmpty(sender)) {
            break label624;
          }
          i = sender.length();
          paramString.put(Integer.valueOf(priority), Integer.valueOf(i));
          m = Math.max(m, priority);
          continue;
        }
        if (k < m)
        {
          i2 = i1;
          i = n;
          if (!paramString.containsKey(Integer.valueOf(k + 1))) {
            break label640;
          }
          i = ((Integer)paramString.get(Integer.valueOf(k + 1))).intValue();
          i2 = i1 + i;
          i = i2;
          if (i1 > 0) {
            i = i2 + 2;
          }
          if ((i <= paramInt) || (n < 2)) {
            break label630;
          }
        }
        PRIORITY_LENGTH_MAP_CACHE.release(paramString);
        localObject2 = new ArrayList();
        i = 0;
        HashMap localHashMap = Maps.newHashMap();
        paramInt = 0;
        if (paramInt >= messageInfos.size()) {
          break label621;
        }
        MessageInfo localMessageInfo = (MessageInfo)messageInfos.get(paramInt);
        if (!TextUtils.isEmpty(sender))
        {
          paramString = sender;
          if (paramString.length() != 0) {
            break label546;
          }
          paramString = getMe(paramContext);
          localObject1 = paramString;
          if (j != 0) {
            localObject1 = paramString.substring(0, Math.max(paramString.length() - j, 0));
          }
          m = priority;
          if (read) {
            break label558;
          }
          paramString = getUnreadStyleSpan();
          if (m > k) {
            break label573;
          }
          SpannableString localSpannableString = new SpannableString((CharSequence)localObject1);
          if (!localHashMap.containsKey(sender)) {
            break label565;
          }
          localObject1 = (Integer)localHashMap.get(sender);
          n = ((Integer)localObject1).intValue();
          if (n != DOES_NOT_EXIST.intValue())
          {
            m = i;
            if (read) {}
          }
          else
          {
            if ((n != DOES_NOT_EXIST.intValue()) && (paramInt > 0) && (n == paramInt - 1) && (n < ((ArrayList)localObject2).size())) {
              ((ArrayList)localObject2).set(n, null);
            }
            localHashMap.put(sender, Integer.valueOf(paramInt));
            localSpannableString.setSpan(paramString, 0, localSpannableString.length(), 0);
            ((ArrayList)localObject2).add(localSpannableString);
            m = i;
          }
          paramInt += 1;
          i = m;
          continue;
        }
        paramString = "";
      }
      finally
      {
        PRIORITY_LENGTH_MAP_CACHE.release(paramString);
      }
      continue;
      label546:
      paramString = Utils.convertHtmlToPlainText(paramString, paramHtmlParser, paramHtmlTreeBuilder);
      continue;
      label558:
      paramString = getReadStyleSpan();
      continue;
      label565:
      Object localObject1 = DOES_NOT_EXIST;
      continue;
      label573:
      m = i;
      if (i == 0)
      {
        localObject1 = new SpannableString(sElidedString);
        ((SpannableString)localObject1).setSpan(paramString, 0, ((SpannableString)localObject1).length(), 0);
        m = 1;
        ((ArrayList)localObject2).add(localObject1);
        continue;
        label621:
        return (ArrayList<SpannableString>)localObject2;
        label624:
        i = 0;
        continue;
        label630:
        i2 = i;
        i = n + 1;
        label640:
        k += 1;
        i1 = i2;
        n = i;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SendersView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */