package com.google.android.gm.provider;

import android.content.Context;
import android.database.DataSetObservable;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gm.utils.LabelColorUtils;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Label
{
  private static final Pattern LABEL_COMPONENT_SEPARATOR_PATTERN = Pattern.compile("\\^\\*\\^");
  private static int sLabelRequeryDelayMs;
  private static HashMap<String, CharSequence> sSystemLabelCache;
  private static Object sSystemLabelCacheLock = new Object();
  private final String mAccount;
  private String mCanonicalName;
  private String mColor;
  private boolean mCountsInitialized;
  private final DataSetObservable mDataSetObservable = new DataSetObservable();
  private final Map<String, CharSequence> mFactorySystemLabelMap;
  private final long mId;
  private final boolean mIsHidden;
  private boolean mIsSystemLabel;
  private int mLabelCountBehavior = 0;
  private int mLabelSyncPolicy = 0;
  private long mLastTouched;
  private String mName;
  private int mNumConversations;
  private int mNumUnreadConversations;
  private String mSerializedInfo;
  
  static
  {
    sLabelRequeryDelayMs = -1;
  }
  
  Label(Context paramContext, String paramString1, long paramLong1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, long paramLong2, Map<String, CharSequence> paramMap)
  {
    mAccount = paramString1;
    mId = paramLong1;
    mIsHidden = paramBoolean;
    mFactorySystemLabelMap = paramMap;
    loadInternal(paramContext, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramInt4, paramLong2);
  }
  
  Label(Context paramContext, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, boolean paramBoolean, Map<String, CharSequence> paramMap)
  {
    mAccount = paramString1;
    mId = paramLong;
    mCanonicalName = paramString2;
    mIsSystemLabel = Gmail.isSystemLabel(paramString2);
    mFactorySystemLabelMap = paramMap;
    if ((mIsSystemLabel) && (paramString3.equals(mCanonicalName))) {}
    for (mName = getHumanSystemLabelName(paramContext);; mName = paramString3)
    {
      mColor = paramString4;
      mCountsInitialized = false;
      mIsHidden = paramBoolean;
      return;
    }
  }
  
  public static int getBackgroundColor(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = Gmail.isSystemLabel(paramString2);
    if (paramString2.equals("^g")) {}
    for (paramString1 = LabelColorUtils.getMutedColorInts(); bool; paramString1 = LabelColorUtils.getLabelColorInts(getColor(bool, paramString3), paramString1)) {
      return 16777215;
    }
    return paramString1[0];
  }
  
  static String getColor(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      paramString = "2147483647";
    }
    return paramString;
  }
  
  private String getHumanSystemLabelName(Context paramContext)
  {
    CharSequence localCharSequence = null;
    if (mFactorySystemLabelMap != null) {
      localCharSequence = (CharSequence)mFactorySystemLabelMap.get(mCanonicalName);
    }
    while (localCharSequence == null)
    {
      return mCanonicalName;
      if (paramContext != null) {
        synchronized (sSystemLabelCacheLock)
        {
          initLabelCache(paramContext);
          localCharSequence = (CharSequence)sSystemLabelCache.get(mCanonicalName);
        }
      }
    }
    return localCharSequence.toString();
  }
  
  static Uri getLabelUri(String paramString, Long paramLong)
  {
    return Uri.withAppendedPath(Gmail.getLabelUri(paramString), paramLong.toString());
  }
  
  static Map<String, CharSequence> getSystemLabelNameMap(Context paramContext)
  {
    HashMap localHashMap = null;
    if (paramContext != null)
    {
      localHashMap = Maps.newHashMap();
      loadSystemLabelNameMap(paramContext, localHashMap);
    }
    return localHashMap;
  }
  
  public static int getTextColor(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = Gmail.isSystemLabel(paramString2);
    if (paramString2.equals("^g")) {}
    for (paramString1 = LabelColorUtils.getMutedColorInts();; paramString1 = LabelColorUtils.getLabelColorInts(getColor(bool, paramString3), paramString1)) {
      return paramString1[1];
    }
  }
  
  private void initLabelCache(Context paramContext)
  {
    if (sSystemLabelCache == null) {
      sSystemLabelCache = new HashMap();
    }
    loadSystemLabelNameMap(paramContext, sSystemLabelCache);
  }
  
  private static void loadSystemLabelNameMap(Context paramContext, Map<String, CharSequence> paramMap)
  {
    paramMap.put("^f", paramContext.getString(2131493306));
    paramMap.put("^^out", paramContext.getString(2131493307));
    paramMap.put("^i", paramContext.getString(2131493308));
    paramMap.put("^r", paramContext.getString(2131493309));
    paramMap.put("^b", paramContext.getString(2131493310));
    paramMap.put("^all", paramContext.getString(2131493311));
    paramMap.put("^u", paramContext.getString(2131493312));
    paramMap.put("^k", paramContext.getString(2131493313));
    paramMap.put("^s", paramContext.getString(2131493314));
    paramMap.put("^t", paramContext.getString(2131493315));
    paramMap.put("^g", paramContext.getString(2131493316));
    paramMap.put("^io_im", paramContext.getString(2131493317));
    paramMap.put("^iim", paramContext.getString(2131493318));
  }
  
  public static Label parseJoinedString(String paramString)
  {
    return parseJoinedString(paramString, null);
  }
  
  static Label parseJoinedString(String paramString1, String paramString2, Map<String, CharSequence> paramMap, Map<Long, Label> paramMap1)
  {
    int i = paramString2.indexOf("^*^");
    long l;
    if (i != -1)
    {
      try
      {
        l = Long.valueOf(paramString2.substring(0, i)).longValue();
        if ((paramMap1 == null) || (!paramMap1.containsKey(Long.valueOf(l)))) {
          break label105;
        }
        paramString1 = (Label)paramMap1.get(Long.valueOf(l));
        return paramString1;
      }
      catch (NumberFormatException paramString1)
      {
        LogUtils.w("Gmail", "Problem parsing labelId: original string: %s", new Object[] { paramString2 });
        return null;
      }
    }
    else
    {
      LogUtils.w("Gmail", "Problem parsing labelId: original string: %s", new Object[] { paramString2 });
      return null;
    }
    label105:
    String[] arrayOfString = TextUtils.split(paramString2, LABEL_COMPONENT_SEPARATOR_PATTERN);
    if (arrayOfString.length < 5) {
      return null;
    }
    int j = 0 + 1;
    i = j + 1;
    String str1 = arrayOfString[j];
    j = i + 1;
    String str2 = arrayOfString[i];
    i = j + 1;
    String str3 = arrayOfString[j];
    try
    {
      i = Integer.valueOf(arrayOfString[i]).intValue();
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = new Label(null, paramString1, l, str1, str2, str3, bool, paramMap);
        if (paramMap1 != null) {
          paramMap1.put(Long.valueOf(l), paramString1);
        }
        return paramString1;
      }
      return null;
    }
    catch (NumberFormatException paramString1)
    {
      LogUtils.w("Gmail", "Problem parsing isHidden: %s original string: %s", new Object[] { paramString1.getMessage(), paramString2 });
    }
  }
  
  /* Error */
  static Label parseJoinedString(String paramString, Map<String, CharSequence> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 54	com/google/android/gm/provider/Label:LABEL_COMPONENT_SEPARATOR_PATTERN	Ljava/util/regex/Pattern;
    //   4: invokestatic 274	android/text/TextUtils:split	(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;
    //   7: astore 9
    //   9: aload 9
    //   11: arraylength
    //   12: bipush 6
    //   14: if_icmpge +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: iconst_0
    //   20: iconst_1
    //   21: iadd
    //   22: istore_3
    //   23: aload 9
    //   25: iconst_0
    //   26: aaload
    //   27: astore 11
    //   29: iload_3
    //   30: iconst_1
    //   31: iadd
    //   32: istore_2
    //   33: aload 9
    //   35: iload_3
    //   36: aaload
    //   37: invokestatic 248	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   40: invokevirtual 252	java/lang/Long:longValue	()J
    //   43: lstore 4
    //   45: iload_2
    //   46: iconst_1
    //   47: iadd
    //   48: istore_3
    //   49: aload 9
    //   51: iload_2
    //   52: aaload
    //   53: astore 10
    //   55: iload_3
    //   56: iconst_1
    //   57: iadd
    //   58: istore_2
    //   59: aload 9
    //   61: iload_3
    //   62: aaload
    //   63: astore 7
    //   65: aload 7
    //   67: ldc_w 297
    //   70: invokestatic 303	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: astore 8
    //   75: aload 8
    //   77: astore 7
    //   79: aload 11
    //   81: ldc_w 297
    //   84: invokestatic 303	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 8
    //   89: iload_2
    //   90: iconst_1
    //   91: iadd
    //   92: istore_3
    //   93: aload 9
    //   95: iload_2
    //   96: aaload
    //   97: astore 11
    //   99: aload 9
    //   101: iload_3
    //   102: aaload
    //   103: invokestatic 279	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   106: invokevirtual 283	java/lang/Integer:intValue	()I
    //   109: istore_2
    //   110: iload_2
    //   111: ifle +95 -> 206
    //   114: iconst_1
    //   115: istore 6
    //   117: new 2	com/google/android/gm/provider/Label
    //   120: dup
    //   121: aconst_null
    //   122: aload 8
    //   124: lload 4
    //   126: aload 10
    //   128: aload 7
    //   130: aload 11
    //   132: iload 6
    //   134: aload_1
    //   135: invokespecial 285	com/google/android/gm/provider/Label:<init>	(Landroid/content/Context;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V
    //   138: areturn
    //   139: astore_1
    //   140: ldc_w 260
    //   143: ldc_w 305
    //   146: iconst_2
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_1
    //   153: invokevirtual 290	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: aload_0
    //   160: aastore
    //   161: invokestatic 268	com/google/android/gm/provider/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   164: pop
    //   165: aconst_null
    //   166: areturn
    //   167: astore 8
    //   169: ldc_w 260
    //   172: aload 8
    //   174: ldc_w 307
    //   177: iconst_0
    //   178: anewarray 4	java/lang/Object
    //   181: invokestatic 311	com/google/android/gm/provider/LogUtils:wtf	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   184: pop
    //   185: goto -106 -> 79
    //   188: astore_0
    //   189: ldc_w 260
    //   192: aload_0
    //   193: ldc_w 313
    //   196: iconst_0
    //   197: anewarray 4	java/lang/Object
    //   200: invokestatic 311	com/google/android/gm/provider/LogUtils:wtf	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   203: pop
    //   204: aconst_null
    //   205: areturn
    //   206: iconst_0
    //   207: istore 6
    //   209: goto -92 -> 117
    //   212: astore_1
    //   213: ldc_w 260
    //   216: ldc_w 287
    //   219: iconst_2
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload_1
    //   226: invokevirtual 290	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   229: aastore
    //   230: dup
    //   231: iconst_1
    //   232: aload_0
    //   233: aastore
    //   234: invokestatic 268	com/google/android/gm/provider/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   237: pop
    //   238: aconst_null
    //   239: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   0	240	1	paramMap	Map<String, CharSequence>
    //   32	79	2	i	int
    //   22	80	3	j	int
    //   43	82	4	l	long
    //   115	93	6	bool	boolean
    //   63	66	7	localObject	Object
    //   73	50	8	str1	String
    //   167	6	8	localIllegalArgumentException	IllegalArgumentException
    //   7	93	9	arrayOfString	String[]
    //   53	74	10	str2	String
    //   27	104	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   33	45	139	java/lang/NumberFormatException
    //   65	75	167	java/lang/IllegalArgumentException
    //   65	75	188	java/io/UnsupportedEncodingException
    //   79	89	188	java/io/UnsupportedEncodingException
    //   169	185	188	java/io/UnsupportedEncodingException
    //   99	110	212	java/lang/NumberFormatException
  }
  
  public int getBackgroundColor()
  {
    try
    {
      int i = getBackgroundColor(mAccount, mCanonicalName, mColor);
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getCanonicalName()
  {
    try
    {
      String str = mCanonicalName;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getColor()
  {
    try
    {
      String str = getColor(isSystemLabel(), mColor);
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean getDisplayNoConversationCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/google/android/gm/provider/Label:mLabelCountBehavior	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_2
    //   9: if_icmpne +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	Label
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  /* Error */
  public boolean getDisplayTotalConversationCount()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 58	com/google/android/gm/provider/Label:mLabelCountBehavior	I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpne +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	Label
    //   8	4	1	i	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  /* Error */
  public boolean getForceSyncAll()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 60	com/google/android/gm/provider/Label:mLabelSyncPolicy	I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpne +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	Label
    //   8	4	1	i	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  /* Error */
  public boolean getForceSyncAllOrPartial()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 60	com/google/android/gm/provider/Label:mLabelSyncPolicy	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_3
    //   9: if_icmpne +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	Label
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  /* Error */
  public boolean getForceSyncNone()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 60	com/google/android/gm/provider/Label:mLabelSyncPolicy	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_2
    //   9: if_icmpne +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	Label
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public boolean getHidden()
  {
    try
    {
      boolean bool = mIsHidden;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getId()
  {
    try
    {
      long l = mId;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getLastTouched()
  {
    try
    {
      long l = mLastTouched;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getName()
  {
    try
    {
      String str = mName;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getNumConversations()
  {
    try
    {
      if (!mCountsInitialized) {
        throw new IllegalArgumentException("conversation counts were not initialized");
      }
    }
    finally {}
    int i = mNumConversations;
    return i;
  }
  
  public int getNumUnreadConversations()
  {
    try
    {
      if (!mCountsInitialized) {
        throw new IllegalArgumentException("unread conversation counts were not initialized");
      }
    }
    finally {}
    int i = mNumUnreadConversations;
    return i;
  }
  
  public int getTextColor()
  {
    try
    {
      int i = getTextColor(mAccount, mCanonicalName, mColor);
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isSystemLabel()
  {
    try
    {
      boolean bool = mIsSystemLabel;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void loadInternal(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    if (!paramString1.equals(mCanonicalName))
    {
      mCanonicalName = paramString1;
      mIsSystemLabel = Gmail.isSystemLabel(mCanonicalName);
      mSerializedInfo = null;
    }
    if (!Objects.equal(paramString3, mColor))
    {
      mColor = paramString3;
      mSerializedInfo = null;
    }
    paramString1 = paramString2;
    if (mIsSystemLabel) {
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (!mCanonicalName.equals(paramString2)) {}
      }
      else
      {
        paramString1 = getHumanSystemLabelName(paramContext);
      }
    }
    if (!Objects.equal(paramString1, mName))
    {
      mName = paramString1;
      mSerializedInfo = null;
    }
    mNumConversations = paramInt1;
    mNumUnreadConversations = paramInt2;
    mCountsInitialized = true;
    mLabelCountBehavior = paramInt3;
    mLabelSyncPolicy = paramInt4;
    mLastTouched = paramLong;
  }
  
  public String serialize()
  {
    for (;;)
    {
      try
      {
        if (mSerializedInfo != null)
        {
          localObject1 = mSerializedInfo;
          return (String)localObject1;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject1 = "";
        Object localObject3 = "";
        try
        {
          String str2 = URLEncoder.encode(mAccount, "UTF-8");
          localObject1 = str2;
          String str3 = URLEncoder.encode(mName, "UTF-8");
          localObject3 = str3;
          localObject1 = str2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          LogUtils.wtf("Gmail", localUnsupportedEncodingException, "unsupported encoding", new Object[0]);
          continue;
        }
        localStringBuilder.append((String)localObject1).append("^*^");
        localStringBuilder.append(mId).append("^*^");
        localStringBuilder.append(mCanonicalName).append("^*^");
        localStringBuilder.append((String)localObject3).append("^*^");
        localStringBuilder.append(mColor).append("^*^");
        if (mIsHidden)
        {
          localObject1 = "1";
          localStringBuilder.append((String)localObject1);
          mSerializedInfo = localStringBuilder.toString();
          localObject1 = mSerializedInfo;
        }
        else
        {
          String str1 = "0";
        }
      }
      finally {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Label
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */