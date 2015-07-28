package com.android.mail.providers;

import android.content.AsyncQueryHandler;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Html;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import com.android.mail.utils.Utils;
import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Message
  implements Parcelable
{
  public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator()
  {
    public Message createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Message(paramAnonymousParcel, null);
    }
    
    public Message[] newArray(int paramAnonymousInt)
    {
      return new Message[paramAnonymousInt];
    }
  };
  private static Pattern INLINE_IMAGE_PATTERN = Pattern.compile("<img\\s+[^>]*src=", 10);
  public Uri accountUri;
  public boolean alwaysShowImages;
  public boolean appendRefMessageContent;
  public Uri attachmentListUri;
  public String attachmentsJson;
  public String bcc;
  public String bodyHtml;
  public String bodyText;
  public String cc;
  public Uri conversationUri;
  public long dateReceivedMs;
  public int draftType;
  public boolean embedsExternalResources;
  public Uri eventIntentUri;
  public String from;
  public boolean hasAttachments;
  public long id;
  public boolean isSending;
  private transient List<Attachment> mAttachments = null;
  private transient String[] mBccAddresses = null;
  private transient String[] mCcAddresses = null;
  private transient String[] mFromAddresses = null;
  private transient String[] mReplyToAddresses = null;
  private transient String[] mToAddresses = null;
  public long messageFlags;
  public int quotedTextOffset;
  public boolean read;
  public String refMessageId;
  public String replyTo;
  public String saveUri;
  public String sendUri;
  public String serverId;
  public String snippet;
  public int spamLinkType;
  public int spamWarningLevel;
  public String spamWarningString;
  public boolean starred;
  public String subject;
  public String to;
  public Uri uri;
  public String viaDomain;
  
  public Message() {}
  
  public Message(Cursor paramCursor)
  {
    Object localObject1;
    if (paramCursor != null)
    {
      id = paramCursor.getLong(0);
      serverId = paramCursor.getString(1);
      localObject1 = paramCursor.getString(2);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label590;
      }
      localObject1 = Uri.parse((String)localObject1);
      uri = ((Uri)localObject1);
      localObject1 = paramCursor.getString(3);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label596;
      }
      localObject1 = Uri.parse((String)localObject1);
      label119:
      conversationUri = ((Uri)localObject1);
      subject = paramCursor.getString(4);
      snippet = paramCursor.getString(5);
      from = paramCursor.getString(6);
      to = paramCursor.getString(7);
      cc = paramCursor.getString(8);
      bcc = paramCursor.getString(9);
      replyTo = paramCursor.getString(10);
      dateReceivedMs = paramCursor.getLong(11);
      bodyHtml = paramCursor.getString(12);
      bodyText = paramCursor.getString(13);
      if (paramCursor.getInt(14) == 0) {
        break label602;
      }
      bool1 = true;
      label256:
      embedsExternalResources = bool1;
      refMessageId = paramCursor.getString(15);
      draftType = paramCursor.getInt(16);
      if (paramCursor.getInt(17) == 0) {
        break label607;
      }
      bool1 = true;
      label298:
      appendRefMessageContent = bool1;
      if (paramCursor.getInt(18) == 0) {
        break label612;
      }
      bool1 = true;
      label316:
      hasAttachments = bool1;
      localObject1 = paramCursor.getString(19);
      if ((!hasAttachments) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        break label617;
      }
      localObject1 = Uri.parse((String)localObject1);
      label353:
      attachmentListUri = ((Uri)localObject1);
      messageFlags = paramCursor.getLong(20);
      saveUri = paramCursor.getString(22);
      sendUri = paramCursor.getString(23);
      if (paramCursor.getInt(24) == 0) {
        break label623;
      }
      bool1 = true;
      label408:
      alwaysShowImages = bool1;
      if (paramCursor.getInt(25) == 0) {
        break label628;
      }
      bool1 = true;
      label426:
      read = bool1;
      if (paramCursor.getInt(26) == 0) {
        break label633;
      }
      bool1 = true;
      label444:
      starred = bool1;
      quotedTextOffset = paramCursor.getInt(27);
      attachmentsJson = paramCursor.getString(28);
      String str = paramCursor.getString(30);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str)) {
        localObject1 = Uri.parse(str);
      }
      accountUri = ((Uri)localObject1);
      eventIntentUri = Utils.getValidUri(paramCursor.getString(31));
      spamWarningString = paramCursor.getString(32);
      spamWarningLevel = paramCursor.getInt(33);
      spamLinkType = paramCursor.getInt(34);
      viaDomain = paramCursor.getString(35);
      if (paramCursor.getInt(36) == 0) {
        break label638;
      }
    }
    label590:
    label596:
    label602:
    label607:
    label612:
    label617:
    label623:
    label628:
    label633:
    label638:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      isSending = bool1;
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label119;
      bool1 = false;
      break label256;
      bool1 = false;
      break label298;
      bool1 = false;
      break label316;
      localObject1 = null;
      break label353;
      bool1 = false;
      break label408;
      bool1 = false;
      break label426;
      bool1 = false;
      break label444;
    }
  }
  
  private Message(Parcel paramParcel)
  {
    id = paramParcel.readLong();
    serverId = paramParcel.readString();
    uri = ((Uri)paramParcel.readParcelable(null));
    conversationUri = ((Uri)paramParcel.readParcelable(null));
    subject = paramParcel.readString();
    snippet = paramParcel.readString();
    from = paramParcel.readString();
    to = paramParcel.readString();
    cc = paramParcel.readString();
    bcc = paramParcel.readString();
    replyTo = paramParcel.readString();
    dateReceivedMs = paramParcel.readLong();
    bodyHtml = paramParcel.readString();
    bodyText = paramParcel.readString();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      embedsExternalResources = bool1;
      refMessageId = paramParcel.readString();
      draftType = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {
        break label356;
      }
      bool1 = true;
      label195:
      appendRefMessageContent = bool1;
      if (paramParcel.readInt() == 0) {
        break label361;
      }
      bool1 = true;
      label209:
      hasAttachments = bool1;
      attachmentListUri = ((Uri)paramParcel.readParcelable(null));
      messageFlags = paramParcel.readLong();
      saveUri = paramParcel.readString();
      sendUri = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label366;
      }
      bool1 = true;
      label259:
      alwaysShowImages = bool1;
      quotedTextOffset = paramParcel.readInt();
      attachmentsJson = paramParcel.readString();
      accountUri = ((Uri)paramParcel.readParcelable(null));
      eventIntentUri = ((Uri)paramParcel.readParcelable(null));
      spamWarningString = paramParcel.readString();
      spamWarningLevel = paramParcel.readInt();
      spamLinkType = paramParcel.readInt();
      viaDomain = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label371;
      }
    }
    label356:
    label361:
    label366:
    label371:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      isSending = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label195;
      bool1 = false;
      break label209;
      bool1 = false;
      break label259;
    }
  }
  
  private boolean embedsExternalResources()
  {
    return (embedsExternalResources) || ((!TextUtils.isEmpty(bodyHtml)) && (INLINE_IMAGE_PATTERN.matcher(bodyHtml).find()));
  }
  
  public static String[] tokenizeAddresses(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new String[0];
      return paramString;
    }
    Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(paramString);
    String[] arrayOfString = new String[arrayOfRfc822Token.length];
    int i = 0;
    for (;;)
    {
      paramString = arrayOfString;
      if (i >= arrayOfRfc822Token.length) {
        break;
      }
      arrayOfString[i] = arrayOfRfc822Token[i].toString();
      i += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || ((paramObject != null) && ((paramObject instanceof Message)) && (Objects.equal(uri, uri)));
  }
  
  public List<Attachment> getAttachments()
  {
    if (mAttachments == null) {
      if (attachmentsJson == null) {
        break label30;
      }
    }
    label30:
    for (mAttachments = Attachment.fromJSONArray(attachmentsJson);; mAttachments = Collections.emptyList()) {
      return mAttachments;
    }
  }
  
  public String[] getBccAddresses()
  {
    try
    {
      if (mBccAddresses == null) {
        mBccAddresses = tokenizeAddresses(bcc);
      }
      String[] arrayOfString = mBccAddresses;
      return arrayOfString;
    }
    finally {}
  }
  
  public String getBodyAsHtml()
  {
    String str = "";
    if (!TextUtils.isEmpty(bodyHtml)) {
      str = bodyHtml;
    }
    while (TextUtils.isEmpty(bodyText)) {
      return str;
    }
    return Html.toHtml(new SpannedString(bodyText));
  }
  
  public String[] getCcAddresses()
  {
    try
    {
      if (mCcAddresses == null) {
        mCcAddresses = tokenizeAddresses(cc);
      }
      String[] arrayOfString = mCcAddresses;
      return arrayOfString;
    }
    finally {}
  }
  
  public String[] getFromAddresses()
  {
    try
    {
      if (mFromAddresses == null) {
        mFromAddresses = tokenizeAddresses(from);
      }
      String[] arrayOfString = mFromAddresses;
      return arrayOfString;
    }
    finally {}
  }
  
  public String[] getReplyToAddresses()
  {
    try
    {
      if (mReplyToAddresses == null) {
        mReplyToAddresses = tokenizeAddresses(replyTo);
      }
      String[] arrayOfString = mReplyToAddresses;
      return arrayOfString;
    }
    finally {}
  }
  
  public String[] getToAddresses()
  {
    try
    {
      if (mToAddresses == null) {
        mToAddresses = tokenizeAddresses(to);
      }
      String[] arrayOfString = mToAddresses;
      return arrayOfString;
    }
    finally {}
  }
  
  public int hashCode()
  {
    if (uri == null) {
      return 0;
    }
    return uri.hashCode();
  }
  
  public boolean isFlaggedCalendarInvite()
  {
    return (messageFlags & 0x10) == 16L;
  }
  
  public void markAlwaysShowImages(AsyncQueryHandler paramAsyncQueryHandler, int paramInt, Object paramObject)
  {
    alwaysShowImages = true;
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("alwaysShowImages", Integer.valueOf(1));
    paramAsyncQueryHandler.startUpdate(paramInt, paramObject, uri, localContentValues, null, null);
  }
  
  public boolean shouldShowImagePrompt()
  {
    return (!alwaysShowImages) && (embedsExternalResources());
  }
  
  public String toString()
  {
    return "[message id=" + id + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(id);
    paramParcel.writeString(serverId);
    paramParcel.writeParcelable(uri, 0);
    paramParcel.writeParcelable(conversationUri, 0);
    paramParcel.writeString(subject);
    paramParcel.writeString(snippet);
    paramParcel.writeString(from);
    paramParcel.writeString(to);
    paramParcel.writeString(cc);
    paramParcel.writeString(bcc);
    paramParcel.writeString(replyTo);
    paramParcel.writeLong(dateReceivedMs);
    paramParcel.writeString(bodyHtml);
    paramParcel.writeString(bodyText);
    if (embedsExternalResources)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(refMessageId);
      paramParcel.writeInt(draftType);
      if (!appendRefMessageContent) {
        break label307;
      }
      paramInt = 1;
      label155:
      paramParcel.writeInt(paramInt);
      if (!hasAttachments) {
        break label312;
      }
      paramInt = 1;
      label169:
      paramParcel.writeInt(paramInt);
      paramParcel.writeParcelable(attachmentListUri, 0);
      paramParcel.writeLong(messageFlags);
      paramParcel.writeString(saveUri);
      paramParcel.writeString(sendUri);
      if (!alwaysShowImages) {
        break label317;
      }
      paramInt = 1;
      label216:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(quotedTextOffset);
      paramParcel.writeString(attachmentsJson);
      paramParcel.writeParcelable(accountUri, 0);
      paramParcel.writeParcelable(eventIntentUri, 0);
      paramParcel.writeString(spamWarningString);
      paramParcel.writeInt(spamWarningLevel);
      paramParcel.writeInt(spamLinkType);
      paramParcel.writeString(viaDomain);
      if (!isSending) {
        break label322;
      }
    }
    label307:
    label312:
    label317:
    label322:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label155;
      paramInt = 0;
      break label169;
      paramInt = 0;
      break label216;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Message
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */