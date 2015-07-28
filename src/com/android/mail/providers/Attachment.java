package com.android.mail.providers;

import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Attachment
  implements Parcelable
{
  public static final Parcelable.Creator<Attachment> CREATOR = new Parcelable.Creator()
  {
    public Attachment createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Attachment(paramAnonymousParcel);
    }
    
    public Attachment[] newArray(int paramAnonymousInt)
    {
      return new Attachment[paramAnonymousInt];
    }
  };
  public static final String LOG_TAG = ;
  public String contentType;
  public Uri contentUri;
  public int destination;
  public int downloadedSize;
  private transient Uri mIdentifierUri;
  public String name;
  @Deprecated
  public int origin;
  @Deprecated
  public String originExtras;
  @Deprecated
  public String partId;
  public Uri previewIntentUri;
  public int size;
  public int state;
  public Uri thumbnailUri;
  public Uri uri;
  
  public Attachment() {}
  
  public Attachment(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return;
    }
    name = paramCursor.getString(paramCursor.getColumnIndex("_display_name"));
    size = paramCursor.getInt(paramCursor.getColumnIndex("_size"));
    uri = Uri.parse(paramCursor.getString(paramCursor.getColumnIndex("uri")));
    contentType = paramCursor.getString(paramCursor.getColumnIndex("contentType"));
    state = paramCursor.getInt(paramCursor.getColumnIndex("state"));
    destination = paramCursor.getInt(paramCursor.getColumnIndex("destination"));
    downloadedSize = paramCursor.getInt(paramCursor.getColumnIndex("downloadedSize"));
    contentUri = parseOptionalUri(paramCursor.getString(paramCursor.getColumnIndex("contentUri")));
    thumbnailUri = parseOptionalUri(paramCursor.getString(paramCursor.getColumnIndex("thumbnailUri")));
    previewIntentUri = parseOptionalUri(paramCursor.getString(paramCursor.getColumnIndex("previewIntentUri")));
  }
  
  public Attachment(Parcel paramParcel)
  {
    name = paramParcel.readString();
    size = paramParcel.readInt();
    uri = ((Uri)paramParcel.readParcelable(null));
    contentType = paramParcel.readString();
    state = paramParcel.readInt();
    destination = paramParcel.readInt();
    downloadedSize = paramParcel.readInt();
    contentUri = ((Uri)paramParcel.readParcelable(null));
    thumbnailUri = ((Uri)paramParcel.readParcelable(null));
    previewIntentUri = ((Uri)paramParcel.readParcelable(null));
    partId = paramParcel.readString();
    origin = paramParcel.readInt();
    originExtras = paramParcel.readString();
  }
  
  public Attachment(JSONObject paramJSONObject)
  {
    name = paramJSONObject.optString("_display_name", null);
    size = paramJSONObject.optInt("_size");
    uri = parseOptionalUri(paramJSONObject, "uri");
    contentUri = parseOptionalUri(paramJSONObject, "contentUri");
    contentType = paramJSONObject.optString("contentType", null);
    if (paramJSONObject.has("state")) {
      state = paramJSONObject.optInt("state");
    }
  }
  
  public static List<Attachment> fromJSONArray(String paramString)
  {
    localArrayList = Lists.newArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        localArrayList.add(new Attachment(paramString.getJSONObject(i)));
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  private static Uri parseOptionalUri(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString);
  }
  
  private static Uri parseOptionalUri(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optString(paramString, null);
    if (paramJSONObject == null) {
      return null;
    }
    return Uri.parse(paramJSONObject);
  }
  
  public static JSONObject toJSON(String paramString1, int paramInt, Uri paramUri1, Uri paramUri2, String paramString2, Integer paramInteger)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.putOpt("_display_name", paramString1);
    localJSONObject.putOpt("_size", Integer.valueOf(paramInt));
    if (paramUri1 != null) {
      localJSONObject.putOpt("uri", paramUri1.toString());
    }
    if (paramUri2 != null) {
      localJSONObject.putOpt("contentUri", paramUri2.toString());
    }
    localJSONObject.putOpt("contentType", paramString2);
    if (paramInteger != null) {
      localJSONObject.put("state", paramInteger.intValue());
    }
    return localJSONObject;
  }
  
  public static String toJSONArray(Collection<Attachment> paramCollection)
  {
    localJSONArray = new JSONArray();
    try
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        localJSONArray.put(((Attachment)paramCollection.next()).toJSON());
      }
      return localJSONArray.toString();
    }
    catch (JSONException paramCollection)
    {
      throw new IllegalArgumentException(paramCollection);
    }
  }
  
  public boolean canPreview()
  {
    return previewIntentUri != null;
  }
  
  public boolean canSave()
  {
    return (origin != 1) && (state != 2) && (!isSavedToExternal());
  }
  
  public boolean canShare()
  {
    return (isPresentLocally()) && (contentUri != null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean downloadFailed()
  {
    return state == 1;
  }
  
  public Uri getIdentifierUri()
  {
    if (mIdentifierUri == null) {
      if (!Utils.isEmpty(uri)) {
        break label31;
      }
    }
    label31:
    for (Uri localUri = Uri.EMPTY;; localUri = uri.buildUpon().clearQuery().build())
    {
      mIdentifierUri = localUri;
      return mIdentifierUri;
    }
  }
  
  public boolean isDownloading()
  {
    return state == 2;
  }
  
  public boolean isImage()
  {
    if (!TextUtils.isEmpty(contentType)) {
      return contentType.startsWith("image/");
    }
    return false;
  }
  
  public boolean isPresentLocally()
  {
    return (state == 3) || (origin == 1);
  }
  
  public boolean isSavedToExternal()
  {
    return (state == 3) && (destination == 1);
  }
  
  public boolean shouldShowProgress()
  {
    return (state == 2) && (size > 0) && (downloadedSize > 0) && (downloadedSize < size);
  }
  
  public JSONObject toJSON()
    throws JSONException
  {
    return toJSON(name, size, uri, contentUri, contentType, Integer.valueOf(state));
  }
  
  @Deprecated
  public String toJoinedString()
  {
    String str1;
    String str2;
    label23:
    String str4;
    int j;
    String str5;
    int i;
    label49:
    Uri localUri;
    if (partId == null)
    {
      str1 = "";
      if (name != null) {
        break label142;
      }
      str2 = "";
      str4 = contentType;
      j = size;
      str5 = contentType;
      if (contentUri == null) {
        break label160;
      }
      i = 1;
      localUri = contentUri;
      if (originExtras != null) {
        break label165;
      }
    }
    label142:
    label160:
    label165:
    for (String str3 = "";; str3 = originExtras)
    {
      return TextUtils.join("|", Lists.newArrayList(new Comparable[] { str1, str2, str4, Integer.valueOf(j), str5, Integer.valueOf(i), localUri, str3, "" }));
      str1 = partId;
      break;
      str2 = name.replaceAll("[|\n]", "");
      break label23;
      i = 0;
      break label49;
    }
  }
  
  public String toString()
  {
    try
    {
      String str = toJSON().toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      LogUtils.e(LOG_TAG, localJSONException, "JSONException in toString", new Object[0]);
    }
    return super.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(name);
    paramParcel.writeInt(size);
    paramParcel.writeParcelable(uri, paramInt);
    paramParcel.writeString(contentType);
    paramParcel.writeInt(state);
    paramParcel.writeInt(destination);
    paramParcel.writeInt(downloadedSize);
    paramParcel.writeParcelable(contentUri, paramInt);
    paramParcel.writeParcelable(thumbnailUri, paramInt);
    paramParcel.writeParcelable(previewIntentUri, paramInt);
    paramParcel.writeString(partId);
    paramParcel.writeInt(origin);
    paramParcel.writeString(originExtras);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Attachment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */