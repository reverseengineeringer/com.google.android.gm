package com.google.android.gm.provider;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gm.provider.uiprovider.UIAttachment;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.io.Serializable;

public final class Gmail$Attachment
  implements UIAttachment, Serializable
{
  private static final long serialVersionUID = 1L;
  public String cachedContent;
  public String contentType;
  public String name;
  public Gmail.AttachmentOrigin origin;
  public String originExtras;
  public String partId;
  public String simpleContentType;
  public int size;
  private Integer transientDestination;
  private String transientSavedFileUri;
  private Integer transientStatus;
  
  /* Error */
  public static Attachment parseJoinedString(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 43
    //   3: invokestatic 49	android/text/TextUtils:split	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: arraylength
    //   9: bipush 7
    //   11: if_icmpge +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 2	com/google/android/gm/provider/Gmail$Attachment
    //   19: dup
    //   20: invokespecial 50	com/google/android/gm/provider/Gmail$Attachment:<init>	()V
    //   23: astore_3
    //   24: iconst_0
    //   25: iconst_1
    //   26: iadd
    //   27: istore_2
    //   28: aload_3
    //   29: aload_0
    //   30: iconst_0
    //   31: aaload
    //   32: putfield 52	com/google/android/gm/provider/Gmail$Attachment:partId	Ljava/lang/String;
    //   35: iload_2
    //   36: iconst_1
    //   37: iadd
    //   38: istore_1
    //   39: aload_3
    //   40: aload_0
    //   41: iload_2
    //   42: aaload
    //   43: putfield 54	com/google/android/gm/provider/Gmail$Attachment:name	Ljava/lang/String;
    //   46: aload_3
    //   47: getfield 54	com/google/android/gm/provider/Gmail$Attachment:name	Ljava/lang/String;
    //   50: astore 4
    //   52: iload_1
    //   53: iconst_1
    //   54: iadd
    //   55: istore_2
    //   56: aload_3
    //   57: aload 4
    //   59: aload_0
    //   60: iload_1
    //   61: aaload
    //   62: invokestatic 60	com/google/android/gm/provider/MimeType:inferMimeType	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   65: putfield 62	com/google/android/gm/provider/Gmail$Attachment:contentType	Ljava/lang/String;
    //   68: iload_2
    //   69: iconst_1
    //   70: iadd
    //   71: istore_1
    //   72: aload_3
    //   73: aload_0
    //   74: iload_2
    //   75: aaload
    //   76: invokestatic 68	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   79: putfield 70	com/google/android/gm/provider/Gmail$Attachment:size	I
    //   82: aload_3
    //   83: getfield 54	com/google/android/gm/provider/Gmail$Attachment:name	Ljava/lang/String;
    //   86: astore 4
    //   88: iload_1
    //   89: iconst_1
    //   90: iadd
    //   91: istore_2
    //   92: aload_3
    //   93: aload 4
    //   95: aload_0
    //   96: iload_1
    //   97: aaload
    //   98: invokestatic 60	com/google/android/gm/provider/MimeType:inferMimeType	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: putfield 72	com/google/android/gm/provider/Gmail$Attachment:simpleContentType	Ljava/lang/String;
    //   104: aload_3
    //   105: aload_0
    //   106: iload_2
    //   107: aaload
    //   108: invokestatic 78	com/google/android/gm/provider/Gmail$AttachmentOrigin:valueOf	(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;
    //   111: putfield 80	com/google/android/gm/provider/Gmail$Attachment:origin	Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;
    //   114: iload_2
    //   115: iconst_1
    //   116: iadd
    //   117: istore_1
    //   118: iload_1
    //   119: iconst_1
    //   120: iadd
    //   121: istore_2
    //   122: aload_3
    //   123: aload_0
    //   124: iload_1
    //   125: aaload
    //   126: putfield 82	com/google/android/gm/provider/Gmail$Attachment:originExtras	Ljava/lang/String;
    //   129: aload_0
    //   130: arraylength
    //   131: bipush 7
    //   133: if_icmple +46 -> 179
    //   136: aload_3
    //   137: aload_0
    //   138: iload_2
    //   139: aaload
    //   140: putfield 84	com/google/android/gm/provider/Gmail$Attachment:cachedContent	Ljava/lang/String;
    //   143: aload_3
    //   144: areturn
    //   145: astore_0
    //   146: aconst_null
    //   147: areturn
    //   148: astore 4
    //   150: aload_0
    //   151: iload_2
    //   152: aaload
    //   153: invokestatic 68	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   156: ifne +13 -> 169
    //   159: aload_3
    //   160: getstatic 87	com/google/android/gm/provider/Gmail$AttachmentOrigin:SERVER_ATTACHMENT	Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;
    //   163: putfield 80	com/google/android/gm/provider/Gmail$Attachment:origin	Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;
    //   166: goto -52 -> 114
    //   169: aload_3
    //   170: getstatic 90	com/google/android/gm/provider/Gmail$AttachmentOrigin:LOCAL_FILE	Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;
    //   173: putfield 80	com/google/android/gm/provider/Gmail$Attachment:origin	Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;
    //   176: goto -62 -> 114
    //   179: aload_3
    //   180: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramString	String
    //   38	87	1	i	int
    //   27	125	2	j	int
    //   23	157	3	localAttachment	Attachment
    //   50	44	4	str	String
    //   148	1	4	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   72	82	145	java/lang/NumberFormatException
    //   104	114	148	java/lang/IllegalArgumentException
  }
  
  public boolean downloadCompletedSuccessfully()
  {
    return (getStatus() == 3) || ((!TextUtils.isEmpty(transientSavedFileUri)) && (transientStatus != null) && (transientStatus.intValue() == 3));
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
      paramObject = (Attachment)paramObject;
    } while ((partId != null) && (partId != null) && (partId.equals(partId)) && (name.equals(name)) && (contentType.equals(contentType)) && (size == size) && (origin == origin) && (originExtras.equals(originExtras)));
    return false;
  }
  
  public String getContentType()
  {
    return MimeType.inferMimeType(name, contentType);
  }
  
  public int getDestination()
  {
    if (transientDestination != null) {
      return transientDestination.intValue();
    }
    if (TextUtils.isEmpty(partId)) {
      return 1;
    }
    return 0;
  }
  
  public int getDownloadedSize()
  {
    return 0;
  }
  
  public Uri getExternalFilePath()
  {
    if (transientSavedFileUri != null) {
      return Uri.parse(transientSavedFileUri);
    }
    return null;
  }
  
  public String getJoinedAttachmentInfo()
  {
    return toJoinedString();
  }
  
  public String getName()
  {
    return name;
  }
  
  public Gmail.AttachmentOrigin getOrigin()
  {
    return origin;
  }
  
  public String getOriginExtras()
  {
    return originExtras;
  }
  
  public Attachment getOriginal()
  {
    return this;
  }
  
  public String getPartId()
  {
    return partId;
  }
  
  public int getSize()
  {
    return size;
  }
  
  public int getStatus()
  {
    if (transientStatus != null) {
      return transientStatus.intValue();
    }
    if (TextUtils.isEmpty(partId)) {
      return 3;
    }
    return 0;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { partId, name, contentType, Integer.valueOf(size), origin, originExtras });
  }
  
  public boolean isDownloading()
  {
    return getStatus() == 2;
  }
  
  public boolean supportsOrigin()
  {
    return true;
  }
  
  public String toJoinedString()
  {
    String str1;
    String str2;
    label20:
    String str4;
    int i;
    String str5;
    String str6;
    String str7;
    if (partId == null)
    {
      str1 = "";
      if (name != null) {
        break label127;
      }
      str2 = "";
      str4 = contentType;
      i = size;
      str5 = simpleContentType;
      str6 = origin.toString();
      str7 = originExtras;
      if (cachedContent != null) {
        break label142;
      }
    }
    label127:
    label142:
    for (String str3 = "";; str3 = cachedContent)
    {
      return TextUtils.join("|", Lists.newArrayList(new Serializable[] { str1, str2, str4, Integer.valueOf(i), str5, str6, str7, str3 }));
      str1 = partId;
      break;
      str2 = name.replaceAll("[|\n]", "");
      break label20;
    }
  }
  
  public String toString()
  {
    return "Attachment{contentType='" + contentType + '\'' + ", partId='" + partId + '\'' + ", name='" + name + '\'' + ", size=" + size + ", simpleContentType='" + simpleContentType + '\'' + ", origin=" + origin + ", originExtras='" + originExtras + '\'' + ", cachedContent='" + cachedContent + '\'' + '}';
  }
  
  public void updateState(int paramInt1, int paramInt2, String paramString)
  {
    transientStatus = Integer.valueOf(paramInt1);
    transientDestination = Integer.valueOf(paramInt2);
    transientSavedFileUri = paramString;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Gmail.Attachment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */