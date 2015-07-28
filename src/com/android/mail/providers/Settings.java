package com.android.mail.providers;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import com.google.common.base.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class Settings
  implements Parcelable
{
  public static final Parcelable.Creator<Settings> CREATOR = new Parcelable.Creator()
  {
    public Settings createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Settings(paramAnonymousParcel);
    }
    
    public Settings[] newArray(int paramAnonymousInt)
    {
      return new Settings[paramAnonymousInt];
    }
  };
  static final Settings EMPTY_SETTINGS;
  private static final String LOG_TAG = ;
  private static final Settings sDefault;
  public final int autoAdvance;
  public final boolean confirmArchive;
  public final boolean confirmDelete;
  public final boolean confirmSend;
  public final int conversationViewMode;
  public final Uri defaultInbox;
  public final String defaultInboxName;
  public final boolean forceReplyFromDefault;
  public final boolean hideCheckboxes;
  private int mHashCode;
  public final int maxAttachmentSize;
  public final int messageTextSize;
  public final boolean priorityArrowsEnabled;
  public final int replyBehavior;
  public final Uri setupIntentUri;
  public final String signature;
  public final int snapHeaders;
  public final int swipe;
  
  static
  {
    EMPTY_SETTINGS = new Settings();
    sDefault = EMPTY_SETTINGS;
  }
  
  private Settings()
  {
    signature = "";
    autoAdvance = 3;
    messageTextSize = 0;
    snapHeaders = 0;
    replyBehavior = 0;
    hideCheckboxes = false;
    confirmDelete = false;
    confirmArchive = false;
    confirmSend = false;
    defaultInbox = Uri.EMPTY;
    defaultInboxName = "";
    forceReplyFromDefault = false;
    maxAttachmentSize = 0;
    swipe = 0;
    priorityArrowsEnabled = false;
    setupIntentUri = Uri.EMPTY;
    conversationViewMode = -1;
  }
  
  public Settings(Cursor paramCursor)
  {
    signature = paramCursor.getString(26);
    autoAdvance = paramCursor.getInt(27);
    messageTextSize = paramCursor.getInt(28);
    snapHeaders = paramCursor.getInt(29);
    replyBehavior = paramCursor.getInt(30);
    if (paramCursor.getInt(31) != 0)
    {
      bool1 = true;
      hideCheckboxes = bool1;
      if (paramCursor.getInt(32) == 0) {
        break label258;
      }
      bool1 = true;
      label97:
      confirmDelete = bool1;
      if (paramCursor.getInt(33) == 0) {
        break label263;
      }
      bool1 = true;
      label115:
      confirmArchive = bool1;
      if (paramCursor.getInt(34) == 0) {
        break label268;
      }
      bool1 = true;
      label133:
      confirmSend = bool1;
      defaultInbox = Utils.getValidUri(paramCursor.getString(35));
      defaultInboxName = paramCursor.getString(36);
      if (paramCursor.getInt(37) == 0) {
        break label273;
      }
      bool1 = true;
      label178:
      forceReplyFromDefault = bool1;
      maxAttachmentSize = paramCursor.getInt(38);
      swipe = paramCursor.getInt(39);
      if (paramCursor.getInt(40) == 0) {
        break label278;
      }
    }
    label258:
    label263:
    label268:
    label273:
    label278:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      priorityArrowsEnabled = bool1;
      setupIntentUri = Utils.getValidUri(paramCursor.getString(41));
      conversationViewMode = paramCursor.getInt(42);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label97;
      bool1 = false;
      break label115;
      bool1 = false;
      break label133;
      bool1 = false;
      break label178;
    }
  }
  
  public Settings(Parcel paramParcel)
  {
    signature = paramParcel.readString();
    autoAdvance = paramParcel.readInt();
    messageTextSize = paramParcel.readInt();
    snapHeaders = paramParcel.readInt();
    replyBehavior = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      hideCheckboxes = bool1;
      if (paramParcel.readInt() == 0) {
        break label190;
      }
      bool1 = true;
      label69:
      confirmDelete = bool1;
      if (paramParcel.readInt() == 0) {
        break label195;
      }
      bool1 = true;
      label83:
      confirmArchive = bool1;
      if (paramParcel.readInt() == 0) {
        break label200;
      }
      bool1 = true;
      label97:
      confirmSend = bool1;
      defaultInbox = Utils.getValidUri(paramParcel.readString());
      defaultInboxName = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label205;
      }
      bool1 = true;
      label130:
      forceReplyFromDefault = bool1;
      maxAttachmentSize = paramParcel.readInt();
      swipe = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {
        break label210;
      }
    }
    label190:
    label195:
    label200:
    label205:
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      priorityArrowsEnabled = bool1;
      setupIntentUri = Utils.getValidUri(paramParcel.readString());
      conversationViewMode = paramParcel.readInt();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label69;
      bool1 = false;
      break label83;
      bool1 = false;
      break label97;
      bool1 = false;
      break label130;
    }
  }
  
  private Settings(JSONObject paramJSONObject)
  {
    signature = paramJSONObject.optString("signature", sDefaultsignature);
    autoAdvance = paramJSONObject.optInt("auto_advance", sDefaultautoAdvance);
    messageTextSize = paramJSONObject.optInt("message_text_size", sDefaultmessageTextSize);
    snapHeaders = paramJSONObject.optInt("snap_headers", sDefaultsnapHeaders);
    replyBehavior = paramJSONObject.optInt("reply_behavior", sDefaultreplyBehavior);
    hideCheckboxes = paramJSONObject.optBoolean("hide_checkboxes", sDefaulthideCheckboxes);
    confirmDelete = paramJSONObject.optBoolean("confirm_delete", sDefaultconfirmDelete);
    confirmArchive = paramJSONObject.optBoolean("confirm_archive", sDefaultconfirmArchive);
    confirmSend = paramJSONObject.optBoolean("confirm_send", sDefaultconfirmSend);
    defaultInbox = Utils.getValidUri(paramJSONObject.optString("default_inbox"));
    defaultInboxName = paramJSONObject.optString("default_inbox_name", sDefaultdefaultInboxName);
    forceReplyFromDefault = paramJSONObject.optBoolean("force_reply_from_default", sDefaultforceReplyFromDefault);
    maxAttachmentSize = paramJSONObject.optInt("max_attachment_size", sDefaultmaxAttachmentSize);
    swipe = paramJSONObject.optInt("swipe", sDefaultswipe);
    priorityArrowsEnabled = paramJSONObject.optBoolean("priority_inbox_arrows_enabled", sDefaultpriorityArrowsEnabled);
    setupIntentUri = Utils.getValidUri(paramJSONObject.optString("setup_intent_uri"));
    conversationViewMode = paramJSONObject.optInt("conversation_view_mode", -1);
  }
  
  private final int calculateHashCode()
  {
    return super.hashCode() ^ Objects.hashCode(new Object[] { signature, Integer.valueOf(autoAdvance), Integer.valueOf(messageTextSize), Integer.valueOf(replyBehavior), Boolean.valueOf(hideCheckboxes), Boolean.valueOf(confirmDelete), Boolean.valueOf(confirmArchive), Boolean.valueOf(confirmSend), defaultInbox, Boolean.valueOf(forceReplyFromDefault), Integer.valueOf(maxAttachmentSize), Integer.valueOf(swipe), Boolean.valueOf(priorityArrowsEnabled), setupIntentUri, Integer.valueOf(conversationViewMode) });
  }
  
  public static int getAutoAdvanceSetting(Settings paramSettings)
  {
    if ((paramSettings == null) || (autoAdvance == 0)) {
      return 3;
    }
    return autoAdvance;
  }
  
  public static Uri getDefaultInboxUri(Settings paramSettings)
  {
    if (paramSettings == null) {
      return sDefaultdefaultInbox;
    }
    return (Uri)getNonNull(defaultInbox, sDefaultdefaultInbox);
  }
  
  private static final Object getNonNull(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2;
    }
    return paramObject1;
  }
  
  public static int getSwipeSetting(Settings paramSettings)
  {
    if (paramSettings != null) {
      return swipe;
    }
    return sDefaultswipe;
  }
  
  public static Settings newInstance(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        localObject = new Settings((JSONObject)localObject);
        return (Settings)localObject;
      }
      catch (JSONException localJSONException2)
      {
        for (;;) {}
      }
      localJSONException1 = localJSONException1;
    }
    tmp31_28[0] = paramString;
    LogUtils.e(LOG_TAG, localJSONException1, "Could not create an settings from this input: \"%s\"", tmp31_28);
    return null;
  }
  
  public static Settings newInstance(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    return new Settings(paramJSONObject);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    LogUtils.d(LOG_TAG, "Settings.equals(%s)", new Object[] { paramObject });
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass())) {
        return false;
      }
      paramObject = (Settings)paramObject;
    } while ((TextUtils.equals(signature, signature)) && (autoAdvance == autoAdvance) && (messageTextSize == messageTextSize) && (replyBehavior == replyBehavior) && (hideCheckboxes == hideCheckboxes) && (confirmDelete == confirmDelete) && (confirmArchive == confirmArchive) && (confirmSend == confirmSend) && (Objects.equal(defaultInbox, defaultInbox)) && (forceReplyFromDefault == forceReplyFromDefault) && (maxAttachmentSize == maxAttachmentSize) && (swipe == swipe) && (priorityArrowsEnabled == priorityArrowsEnabled) && (setupIntentUri == setupIntentUri) && (conversationViewMode == conversationViewMode));
    return false;
  }
  
  public int getMaxAttachmentSize()
  {
    if (maxAttachmentSize <= 0) {
      return 5242880;
    }
    return maxAttachmentSize;
  }
  
  public int hashCode()
  {
    if (mHashCode == 0) {
      mHashCode = calculateHashCode();
    }
    return mHashCode;
  }
  
  public String serialize()
  {
    try
    {
      String str = toJSON().toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public JSONObject toJSON()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 131	org/json/JSONObject
    //   5: dup
    //   6: invokespecial 261	org/json/JSONObject:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: ldc -127
    //   13: aload_0
    //   14: getfield 63	com/android/mail/providers/Settings:signature	Ljava/lang/String;
    //   17: getstatic 54	com/android/mail/providers/Settings:sDefault	Lcom/android/mail/providers/Settings;
    //   20: getfield 63	com/android/mail/providers/Settings:signature	Ljava/lang/String;
    //   23: invokestatic 205	com/android/mail/providers/Settings:getNonNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: invokevirtual 265	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_1
    //   31: ldc -119
    //   33: aload_0
    //   34: getfield 65	com/android/mail/providers/Settings:autoAdvance	I
    //   37: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   40: pop
    //   41: aload_1
    //   42: ldc -113
    //   44: aload_0
    //   45: getfield 67	com/android/mail/providers/Settings:messageTextSize	I
    //   48: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   51: pop
    //   52: aload_1
    //   53: ldc -111
    //   55: aload_0
    //   56: getfield 69	com/android/mail/providers/Settings:snapHeaders	I
    //   59: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload_1
    //   64: ldc -109
    //   66: aload_0
    //   67: getfield 71	com/android/mail/providers/Settings:replyBehavior	I
    //   70: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload_1
    //   75: ldc -107
    //   77: aload_0
    //   78: getfield 73	com/android/mail/providers/Settings:hideCheckboxes	Z
    //   81: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload_1
    //   86: ldc -101
    //   88: aload_0
    //   89: getfield 75	com/android/mail/providers/Settings:confirmDelete	Z
    //   92: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_1
    //   97: ldc -99
    //   99: aload_0
    //   100: getfield 77	com/android/mail/providers/Settings:confirmArchive	Z
    //   103: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   106: pop
    //   107: aload_1
    //   108: ldc -97
    //   110: aload_0
    //   111: getfield 79	com/android/mail/providers/Settings:confirmSend	Z
    //   114: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload_1
    //   119: ldc -95
    //   121: aload_0
    //   122: getfield 86	com/android/mail/providers/Settings:defaultInbox	Landroid/net/Uri;
    //   125: getstatic 54	com/android/mail/providers/Settings:sDefault	Lcom/android/mail/providers/Settings;
    //   128: getfield 86	com/android/mail/providers/Settings:defaultInbox	Landroid/net/Uri;
    //   131: invokestatic 205	com/android/mail/providers/Settings:getNonNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: invokevirtual 265	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   137: pop
    //   138: aload_1
    //   139: ldc -90
    //   141: aload_0
    //   142: getfield 88	com/android/mail/providers/Settings:defaultInboxName	Ljava/lang/String;
    //   145: getstatic 54	com/android/mail/providers/Settings:sDefault	Lcom/android/mail/providers/Settings;
    //   148: getfield 88	com/android/mail/providers/Settings:defaultInboxName	Ljava/lang/String;
    //   151: invokestatic 205	com/android/mail/providers/Settings:getNonNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: invokevirtual 265	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload_1
    //   159: ldc -88
    //   161: aload_0
    //   162: getfield 90	com/android/mail/providers/Settings:forceReplyFromDefault	Z
    //   165: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   168: pop
    //   169: aload_1
    //   170: ldc -86
    //   172: aload_0
    //   173: getfield 92	com/android/mail/providers/Settings:maxAttachmentSize	I
    //   176: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   179: pop
    //   180: aload_1
    //   181: ldc -85
    //   183: aload_0
    //   184: getfield 94	com/android/mail/providers/Settings:swipe	I
    //   187: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload_1
    //   192: ldc -83
    //   194: aload_0
    //   195: getfield 96	com/android/mail/providers/Settings:priorityArrowsEnabled	Z
    //   198: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload_1
    //   203: ldc -81
    //   205: aload_0
    //   206: getfield 98	com/android/mail/providers/Settings:setupIntentUri	Landroid/net/Uri;
    //   209: invokevirtual 265	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   212: pop
    //   213: aload_1
    //   214: ldc -79
    //   216: aload_0
    //   217: getfield 100	com/android/mail/providers/Settings:conversationViewMode	I
    //   220: invokevirtual 268	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   223: pop
    //   224: aload_0
    //   225: monitorexit
    //   226: aload_1
    //   227: areturn
    //   228: astore_2
    //   229: getstatic 47	com/android/mail/providers/Settings:LOG_TAG	Ljava/lang/String;
    //   232: aload_2
    //   233: ldc_w 273
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 276	com/android/mail/utils/LogUtils:wtf	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   243: pop
    //   244: goto -20 -> 224
    //   247: astore_1
    //   248: aload_0
    //   249: monitorexit
    //   250: aload_1
    //   251: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	Settings
    //   9	218	1	localJSONObject	JSONObject
    //   247	4	1	localObject	Object
    //   228	5	2	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   10	224	228	org/json/JSONException
    //   2	10	247	finally
    //   10	224	247	finally
    //   229	244	247	finally
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString((String)getNonNull(signature, sDefaultsignature));
    paramParcel.writeInt(autoAdvance);
    paramParcel.writeInt(messageTextSize);
    paramParcel.writeInt(snapHeaders);
    paramParcel.writeInt(replyBehavior);
    if (hideCheckboxes)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!confirmDelete) {
        break label234;
      }
      paramInt = 1;
      label77:
      paramParcel.writeInt(paramInt);
      if (!confirmArchive) {
        break label239;
      }
      paramInt = 1;
      label91:
      paramParcel.writeInt(paramInt);
      if (!confirmSend) {
        break label244;
      }
      paramInt = 1;
      label105:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(((Uri)getNonNull(defaultInbox, sDefaultdefaultInbox)).toString());
      paramParcel.writeString((String)getNonNull(defaultInboxName, sDefaultdefaultInboxName));
      if (!forceReplyFromDefault) {
        break label249;
      }
      paramInt = 1;
      label162:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(maxAttachmentSize);
      paramParcel.writeInt(swipe);
      if (!priorityArrowsEnabled) {
        break label254;
      }
    }
    label234:
    label239:
    label244:
    label249:
    label254:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(((Uri)getNonNull(setupIntentUri, sDefaultsetupIntentUri)).toString());
      paramParcel.writeInt(conversationViewMode);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label77;
      paramInt = 0;
      break label91;
      paramInt = 0;
      break label105;
      paramInt = 0;
      break label162;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Settings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */