package com.google.android.gm.provider;

import android.text.Html;
import android.text.TextUtils;
import android.text.TextUtils.SimpleStringSplitter;
import com.google.common.collect.Lists;
import com.google.common.io.protocol.ProtoBuf;
import com.google.wireless.gdata2.parser.xml.SimplePullParser;
import com.google.wireless.gdata2.parser.xml.SimplePullParser.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CompactSenderInstructions
{
  private static final ObjectCache<List<String>> SENDER_LIST_CACHE = new ObjectCache(new ObjectCache.Callback()
  {
    public List<String> newInstance()
    {
      return new ArrayList(8);
    }
    
    public void onObjectReleased(List<String> paramAnonymousList)
    {
      paramAnonymousList.clear();
    }
  }, 2);
  private static final TextUtils.SimpleStringSplitter SENDER_LIST_SPLITTER = new TextUtils.SimpleStringSplitter(Gmail.SENDER_LIST_SEPARATOR.charValue());
  private boolean mHasErrors = false;
  private boolean mHasSending = false;
  private SenderInstructions mSenderInstructions = new SenderInstructions();
  
  private static void appendElided(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("e");
    paramStringBuilder.append(Gmail.SENDER_LIST_SEPARATOR);
  }
  
  private static void appendNumDrafts(StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt != 0)
    {
      paramStringBuilder.append("d");
      paramStringBuilder.append(Gmail.SENDER_LIST_SEPARATOR);
      paramStringBuilder.append(paramInt);
      paramStringBuilder.append(Gmail.SENDER_LIST_SEPARATOR);
    }
  }
  
  private static void appendNumMessages(StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt > 1)
    {
      paramStringBuilder.append("n");
      paramStringBuilder.append(Gmail.SENDER_LIST_SEPARATOR);
      paramStringBuilder.append(paramInt);
      paramStringBuilder.append(Gmail.SENDER_LIST_SEPARATOR);
    }
  }
  
  private static void appendSendFailed(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramStringBuilder.append("f");
      paramStringBuilder.append(Gmail.SENDER_LIST_SEPARATOR);
    }
  }
  
  private static void appendSender(StringBuilder paramStringBuilder, boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (int i = 1;; i = 0)
    {
      paramStringBuilder.append(i);
      paramStringBuilder.append(Gmail.SENDER_LIST_SEPARATOR);
      paramStringBuilder.append(paramInt);
      paramStringBuilder.append(Gmail.SENDER_LIST_SEPARATOR);
      String str = paramString;
      if (paramBoolean2) {
        str = shortNameFromLongName(paramString);
      }
      paramStringBuilder.append(str);
      paramStringBuilder.append(Gmail.SENDER_LIST_SEPARATOR);
      return;
    }
  }
  
  private static void appendSending(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramStringBuilder.append("s");
      paramStringBuilder.append(Gmail.SENDER_LIST_SEPARATOR);
    }
  }
  
  private static String constructString(Collection<SenderInstructions.Sender> paramCollection, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    StringBuilder localStringBuilder = new StringBuilder();
    appendSending(localStringBuilder, paramBoolean1);
    appendSendFailed(localStringBuilder, paramBoolean2);
    appendNumMessages(localStringBuilder, paramInt1);
    appendNumDrafts(localStringBuilder, paramInt2);
    if (paramInt3 > 1)
    {
      paramBoolean1 = bool;
      paramInt1 = 0;
      paramCollection = paramCollection.iterator();
    }
    for (;;)
    {
      if (!paramCollection.hasNext()) {
        break label162;
      }
      SenderInstructions.Sender localSender = (SenderInstructions.Sender)paramCollection.next();
      switch (visibility)
      {
      default: 
        break;
      case ???: 
        appendSender(localStringBuilder, unread, priority, name, paramBoolean1);
        paramInt1 = 0;
        continue;
        paramBoolean1 = false;
        break;
      case ???: 
        if (paramInt1 == 0)
        {
          appendElided(localStringBuilder);
          paramInt1 = 1;
        }
        break;
      }
    }
    label162:
    return localStringBuilder.toString();
  }
  
  public static String instructionsStringFromProto(ProtoBuf paramProtoBuf)
  {
    int j = paramProtoBuf.getInt(1);
    int k = paramProtoBuf.getInt(2);
    ArrayList localArrayList = Lists.newArrayList();
    int i = 0;
    Object localObject = Lists.newArrayList();
    ProtoBufHelpers.getAllProtoBufs(paramProtoBuf, 3, (Collection)localObject);
    paramProtoBuf = ((List)localObject).iterator();
    while (paramProtoBuf.hasNext())
    {
      localObject = (ProtoBuf)paramProtoBuf.next();
      if (((ProtoBuf)localObject).getBool(1))
      {
        localObject = new SenderInstructions.Sender();
        visibility = SenderInstructions.Visibility.HIDDEN;
        localArrayList.add(localObject);
      }
      else
      {
        SenderInstructions.Sender localSender = new SenderInstructions.Sender();
        unread = ((ProtoBuf)localObject).getBool(2);
        priority = ((ProtoBuf)localObject).getInt(3);
        name = ((ProtoBuf)localObject).getString(4);
        visibility = SenderInstructions.Visibility.VISIBLE;
        i += 1;
        localArrayList.add(localSender);
      }
    }
    return constructString(localArrayList, j, k, i, false, false);
  }
  
  public static String instructionsStringFromXml(SimplePullParser paramSimplePullParser)
    throws IOException, SimplePullParser.ParseException
  {
    int j = paramSimplePullParser.getIntAttribute(null, "numMessages");
    int k = paramSimplePullParser.getIntAttribute(null, "numDrafts");
    ArrayList localArrayList = Lists.newArrayList();
    int i = 0;
    int m = paramSimplePullParser.getDepth();
    for (;;)
    {
      Object localObject = paramSimplePullParser.nextTag(m);
      if (localObject == null) {
        break;
      }
      if ("sender".equals(localObject))
      {
        localObject = new SenderInstructions.Sender();
        if (paramSimplePullParser.getIntAttribute(null, "unread") != 0) {}
        for (boolean bool = true;; bool = false)
        {
          unread = bool;
          priority = paramSimplePullParser.getIntAttribute(null, "priority");
          name = paramSimplePullParser.getStringAttribute(null, "name");
          visibility = SenderInstructions.Visibility.VISIBLE;
          i += 1;
          localArrayList.add(localObject);
          break;
        }
      }
      if ("elided".equals(localObject))
      {
        localObject = new SenderInstructions.Sender();
        visibility = SenderInstructions.Visibility.HIDDEN;
        localArrayList.add(localObject);
      }
    }
    return constructString(localArrayList, j, k, i, false, false);
  }
  
  public static void parseCompactSenderInstructions(String paramString, SenderInstructions paramSenderInstructions)
  {
    List localList = (List)SENDER_LIST_CACHE.get();
    try
    {
      localList.clear();
      synchronized (SENDER_LIST_SPLITTER)
      {
        SENDER_LIST_SPLITTER.setString(paramString);
        if (SENDER_LIST_SPLITTER.hasNext()) {
          localList.add(SENDER_LIST_SPLITTER.next());
        }
      }
    }
    finally
    {
      SENDER_LIST_CACHE.release(localList);
    }
    int i = 0;
    label365:
    label374:
    for (;;)
    {
      int j;
      boolean bool1;
      if (i < localList.size())
      {
        j = i + 1;
        paramString = (String)localList.get(i);
        if ("".equals(paramString))
        {
          i = j;
          break label374;
        }
        i = j;
        if ("e".equals(paramString)) {
          break label374;
        }
        if ("n".equals(paramString))
        {
          i = j + 1;
          break label374;
        }
        if ("d".equals(paramString))
        {
          paramSenderInstructions.setNumDrafts(Integer.parseInt((String)localList.get(j)));
          i = j + 1;
          break label374;
        }
        if ("l".equals(paramString))
        {
          paramString = Html.fromHtml((String)localList.get(j)).toString();
          if (paramString.length() == 0)
          {
            bool1 = true;
            paramSenderInstructions.addMessage(paramString, false, false, bool1, -1);
          }
        }
      }
      for (;;)
      {
        SENDER_LIST_CACHE.release(localList);
        return;
        bool1 = false;
        break;
        i = j;
        if ("s".equals(paramString)) {
          break label374;
        }
        i = j;
        if ("f".equals(paramString)) {
          break label374;
        }
        if (j + 2 <= localList.size())
        {
          if (Integer.parseInt(paramString) != 0)
          {
            bool1 = true;
            int k = j + 1;
            paramString = (String)localList.get(j);
            i = k + 1;
            ??? = (String)localList.get(k);
            j = Integer.parseInt(paramString);
            if (((String)???).length() != 0) {
              break label365;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            paramSenderInstructions.addMessage((String)???, false, bool1, bool2, j);
            break label374;
            bool1 = false;
            break;
          }
        }
      }
    }
  }
  
  private static String shortNameFromLongName(String paramString)
  {
    Object localObject1 = paramString.trim();
    paramString = (String)localObject1;
    if (((String)localObject1).startsWith("\""))
    {
      paramString = (String)localObject1;
      if (((String)localObject1).endsWith("\""))
      {
        paramString = (String)localObject1;
        if (((String)localObject1).length() >= 2) {
          paramString = ((String)localObject1).substring(1, ((String)localObject1).length() - 1).trim();
        }
      }
    }
    Object localObject2 = paramString;
    int m = ((String)localObject2).indexOf(',');
    localObject1 = localObject2;
    int j;
    int k;
    if (m != -1)
    {
      localObject1 = localObject2;
      if (m != ((String)localObject2).length() - 1)
      {
        localObject1 = TextUtils.split(((String)localObject2).substring(0, m), "\\s+");
        i = 0;
        j = 0;
        k = i;
        if (j < localObject1.length)
        {
          k = i;
          if (localObject1[j].endsWith(".")) {
            break label254;
          }
          i += 1;
          k = i;
          if (i < 2) {
            break label254;
          }
          k = i;
        }
        localObject1 = localObject2;
        if (k == 1) {
          localObject1 = ((String)localObject2).substring(m + 1).trim();
        }
      }
    }
    localObject2 = localObject1;
    if (((String)localObject1).toLowerCase().startsWith("the ")) {
      localObject2 = ((String)localObject1).substring("the ".length()).trim();
    }
    localObject1 = TextUtils.split((String)localObject2, "\\s+");
    int i = 0;
    for (;;)
    {
      if (i >= localObject1.length) {
        return paramString;
      }
      localObject2 = localObject1[i];
      if (!((String)localObject2).endsWith("."))
      {
        return (String)localObject2;
        label254:
        j += 1;
        i = k;
        break;
      }
      i += 1;
    }
    return paramString;
  }
  
  public void addMessage(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    boolean bool2 = true;
    SenderInstructions localSenderInstructions;
    if (paramBoolean4)
    {
      mHasSending = true;
      localSenderInstructions = mSenderInstructions;
      if (paramString != null) {
        break label77;
      }
      paramString = null;
      label25:
      bool1 = bool2;
      if (!paramBoolean3)
      {
        bool1 = bool2;
        if (!paramBoolean4) {
          if (!paramBoolean5) {
            break label85;
          }
        }
      }
    }
    label77:
    label85:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localSenderInstructions.addMessage(paramString, paramBoolean1, paramBoolean2, bool1, -1);
      return;
      if (!paramBoolean5) {
        break;
      }
      mHasErrors = true;
      break;
      paramString = Gmail.getNameFromAddressString(paramString);
      break label25;
    }
  }
  
  public String toInstructionString(int paramInt)
  {
    mSenderInstructions.calculateVisibility(paramInt);
    Collection localCollection = mSenderInstructions.getSenders();
    return constructString(localCollection, localCollection.size(), mSenderInstructions.getNumDrafts(), mSenderInstructions.getNumVisible(), mHasSending, mHasErrors);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.CompactSenderInstructions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */