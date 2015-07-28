package com.android.mail.providers;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.graphics.Paint;
import android.graphics.drawable.PaintDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.android.mail.utils.Utils;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

public class Folder
  implements Parcelable, Comparable<Folder>
{
  public static final Parcelable.Creator<Folder> CREATOR = new Parcelable.Creator()
  {
    public Folder createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Folder(paramAnonymousParcel);
    }
    
    public Folder[] newArray(int paramAnonymousInt)
    {
      return new Folder[paramAnonymousInt];
    }
  };
  public static final Collection<Folder> EMPTY = ;
  private static final Pattern FOLDERS_SPLIT_REGEX;
  private static final Pattern SPLITTER_REGEX = Pattern.compile("\\^\\*\\^");
  public String bgColor;
  public int capabilities;
  public Uri childFoldersListUri;
  public Uri conversationListUri;
  public String fgColor;
  public boolean hasChildren;
  public String hierarchicalDesc;
  public long iconResId;
  public int id;
  public int lastSyncResult;
  public Uri loadMoreUri;
  public String name;
  public Folder parent;
  public Uri refreshUri;
  public int syncStatus;
  public int syncWindow;
  public int totalCount;
  public int type;
  public int unreadCount;
  public Uri uri;
  
  static
  {
    FOLDERS_SPLIT_REGEX = Pattern.compile("\\^\\*\\*\\^");
  }
  
  private Folder()
  {
    name = "Uninitialized!";
  }
  
  public Folder(Cursor paramCursor)
  {
    id = paramCursor.getInt(0);
    uri = Uri.parse(paramCursor.getString(1));
    name = paramCursor.getString(2);
    capabilities = paramCursor.getInt(4);
    if (paramCursor.getInt(3) == 1)
    {
      hasChildren = bool;
      syncWindow = paramCursor.getInt(5);
      localObject = paramCursor.getString(6);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label310;
      }
      localObject = Uri.parse((String)localObject);
      label101:
      conversationListUri = ((Uri)localObject);
      localObject = paramCursor.getString(7);
      if ((!hasChildren) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break label315;
      }
      localObject = Uri.parse((String)localObject);
      label134:
      childFoldersListUri = ((Uri)localObject);
      unreadCount = paramCursor.getInt(8);
      totalCount = paramCursor.getInt(9);
      localObject = paramCursor.getString(10);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label320;
      }
      localObject = Uri.parse((String)localObject);
      label184:
      refreshUri = ((Uri)localObject);
      syncStatus = paramCursor.getInt(11);
      lastSyncResult = paramCursor.getInt(12);
      type = paramCursor.getInt(13);
      iconResId = paramCursor.getLong(14);
      bgColor = paramCursor.getString(15);
      fgColor = paramCursor.getString(16);
      localObject = paramCursor.getString(17);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label325;
      }
    }
    label310:
    label315:
    label320:
    label325:
    for (Object localObject = Uri.parse((String)localObject);; localObject = null)
    {
      loadMoreUri = ((Uri)localObject);
      hierarchicalDesc = paramCursor.getString(18);
      parent = null;
      return;
      bool = false;
      break;
      localObject = null;
      break label101;
      localObject = null;
      break label134;
      localObject = null;
      break label184;
    }
  }
  
  public Folder(Parcel paramParcel)
  {
    id = paramParcel.readInt();
    uri = ((Uri)paramParcel.readParcelable(null));
    name = paramParcel.readString();
    capabilities = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      hasChildren = bool;
      syncWindow = paramParcel.readInt();
      conversationListUri = ((Uri)paramParcel.readParcelable(null));
      childFoldersListUri = ((Uri)paramParcel.readParcelable(null));
      unreadCount = paramParcel.readInt();
      totalCount = paramParcel.readInt();
      refreshUri = ((Uri)paramParcel.readParcelable(null));
      syncStatus = paramParcel.readInt();
      lastSyncResult = paramParcel.readInt();
      type = paramParcel.readInt();
      iconResId = paramParcel.readLong();
      bgColor = paramParcel.readString();
      fgColor = paramParcel.readString();
      loadMoreUri = ((Uri)paramParcel.readParcelable(null));
      hierarchicalDesc = paramParcel.readString();
      parent = ((Folder)paramParcel.readParcelable(null));
      return;
    }
  }
  
  public static CursorLoader forSearchResults(Account paramAccount, String paramString, Context paramContext)
  {
    if (searchUri != null)
    {
      paramAccount = searchUri.buildUpon();
      paramAccount.appendQueryParameter("query", paramString);
      return new CursorLoader(paramContext, paramAccount.build(), UIProvider.FOLDERS_PROJECTION, null, null, null);
    }
    return null;
  }
  
  public static Folder fromString(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Folder localFolder = new Folder();
    paramString = TextUtils.split(paramString, SPLITTER_REGEX);
    if (paramString.length < 20) {
      return null;
    }
    id = Integer.parseInt(paramString[0]);
    uri = getValidUri(paramString[1]);
    name = paramString[2];
    if (Integer.parseInt(paramString[3]) != 0) {}
    for (;;)
    {
      hasChildren = bool;
      capabilities = Integer.parseInt(paramString[4]);
      syncWindow = Integer.parseInt(paramString[5]);
      conversationListUri = getValidUri(paramString[6]);
      childFoldersListUri = getValidUri(paramString[7]);
      unreadCount = Integer.parseInt(paramString[8]);
      totalCount = Integer.parseInt(paramString[9]);
      refreshUri = getValidUri(paramString[10]);
      syncStatus = Integer.parseInt(paramString[11]);
      lastSyncResult = Integer.parseInt(paramString[12]);
      type = Integer.parseInt(paramString[13]);
      iconResId = Integer.parseInt(paramString[14]);
      bgColor = paramString[15];
      fgColor = paramString[16];
      loadMoreUri = getValidUri(paramString[17]);
      hierarchicalDesc = paramString[18];
      parent = fromString(paramString[19]);
      return localFolder;
      bool = false;
    }
  }
  
  public static Folder getDeficientDisplayOnlyFolder(Cursor paramCursor)
  {
    Folder localFolder = newUnsafeInstance();
    id = paramCursor.getInt(0);
    uri = Utils.getValidUri(paramCursor.getString(1));
    unreadCount = paramCursor.getInt(8);
    conversationListUri = Utils.getValidUri(paramCursor.getString(6));
    type = paramCursor.getInt(13);
    capabilities = paramCursor.getInt(4);
    bgColor = paramCursor.getString(15);
    name = paramCursor.getString(2);
    return localFolder;
  }
  
  public static ArrayList<Folder> getFoldersArray(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = TextUtils.split(paramString, FOLDERS_SPLIT_REGEX);
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localArrayList;
      if (i >= j) {
        break;
      }
      paramString = fromString(arrayOfString[i]);
      if (paramString != null) {
        localArrayList.add(paramString);
      }
      i += 1;
    }
  }
  
  public static String getSerializedFolderString(Collection<Folder> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(toString((Folder)localIterator.next()));
      if (i < paramCollection.size()) {
        localStringBuilder.append("^**^");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static final String[] getUriArray(ArrayList<Folder> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      paramArrayList = new String[0];
      return paramArrayList;
    }
    String[] arrayOfString = new String[paramArrayList.size()];
    int i = 0;
    Iterator localIterator = paramArrayList.iterator();
    for (;;)
    {
      paramArrayList = arrayOfString;
      if (!localIterator.hasNext()) {
        break;
      }
      arrayOfString[i] = nexturi.toString();
      i += 1;
    }
  }
  
  private static Uri getValidUri(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return Uri.parse(paramString);
  }
  
  public static HashMap<Uri, Folder> hashMapForFolders(ArrayList<Folder> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Folder localFolder = (Folder)paramArrayList.next();
      localHashMap.put(uri, localFolder);
    }
    return localHashMap;
  }
  
  public static Folder newUnsafeInstance()
  {
    return new Folder();
  }
  
  public static void setFolderBlockColor(Folder paramFolder, View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i;
    if (!TextUtils.isEmpty(bgColor))
    {
      i = 1;
      if (i == 0) {
        break label63;
      }
    }
    label63:
    for (int j = Integer.parseInt(bgColor);; j = 0)
    {
      if (j == Utils.getDefaultFolderBackgroundColor(paramView.getContext())) {
        i = 0;
      }
      if (i != 0) {
        break label68;
      }
      paramView.setBackgroundDrawable(null);
      paramView.setVisibility(8);
      return;
      i = 0;
      break;
    }
    label68:
    paramFolder = new PaintDrawable();
    paramFolder.getPaint().setColor(j);
    paramView.setBackgroundDrawable(paramFolder);
    paramView.setVisibility(0);
  }
  
  public static void setIcon(Folder paramFolder, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    long l = iconResId;
    if (l > 0L)
    {
      paramImageView.setImageResource((int)l);
      paramImageView.setVisibility(0);
      return;
    }
    paramImageView.setVisibility(4);
  }
  
  public static String toString(Folder paramFolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(id);
    localStringBuilder.append("^*^");
    localStringBuilder.append(uri);
    localStringBuilder.append("^*^");
    localStringBuilder.append(name);
    localStringBuilder.append("^*^");
    int i;
    String str;
    if (hasChildren)
    {
      i = 1;
      localStringBuilder.append(i);
      localStringBuilder.append("^*^");
      localStringBuilder.append(capabilities);
      localStringBuilder.append("^*^");
      localStringBuilder.append(syncWindow);
      localStringBuilder.append("^*^");
      localStringBuilder.append(conversationListUri);
      localStringBuilder.append("^*^");
      localStringBuilder.append(childFoldersListUri);
      localStringBuilder.append("^*^");
      localStringBuilder.append(unreadCount);
      localStringBuilder.append("^*^");
      localStringBuilder.append(totalCount);
      localStringBuilder.append("^*^");
      localStringBuilder.append(refreshUri);
      localStringBuilder.append("^*^");
      localStringBuilder.append(syncStatus);
      localStringBuilder.append("^*^");
      localStringBuilder.append(lastSyncResult);
      localStringBuilder.append("^*^");
      localStringBuilder.append(type);
      localStringBuilder.append("^*^");
      localStringBuilder.append(iconResId);
      localStringBuilder.append("^*^");
      str = bgColor;
      if (str == null) {
        break label378;
      }
      label278:
      localStringBuilder.append(str);
      localStringBuilder.append("^*^");
      str = fgColor;
      if (str == null) {
        break label385;
      }
      label301:
      localStringBuilder.append(str);
      localStringBuilder.append("^*^");
      localStringBuilder.append(loadMoreUri);
      localStringBuilder.append("^*^");
      localStringBuilder.append(hierarchicalDesc);
      localStringBuilder.append("^*^");
      if (parent == null) {
        break label392;
      }
      localStringBuilder.append(toString(parent));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      i = 0;
      break;
      label378:
      str = "";
      break label278;
      label385:
      str = "";
      break label301;
      label392:
      localStringBuilder.append("");
    }
  }
  
  public int compareTo(Folder paramFolder)
  {
    return name.compareToIgnoreCase(name);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Folder))) {
      return false;
    }
    return Objects.equal(uri, uri);
  }
  
  public int getBackgroundColor(int paramInt)
  {
    if (TextUtils.isEmpty(bgColor)) {
      return paramInt;
    }
    return Integer.parseInt(bgColor);
  }
  
  public int getForegroundColor(int paramInt)
  {
    if (TextUtils.isEmpty(fgColor)) {
      return paramInt;
    }
    return Integer.parseInt(fgColor);
  }
  
  public int hashCode()
  {
    if (uri == null) {
      return 0;
    }
    return uri.hashCode();
  }
  
  public boolean isDraft()
  {
    return type == 2;
  }
  
  public boolean isImportantOnly()
  {
    return supportsCapability(1024);
  }
  
  public boolean isInitialized()
  {
    return (name != "Uninitialized!") && (conversationListUri != null) && (!"null".equals(conversationListUri.toString()));
  }
  
  public boolean isProviderFolder()
  {
    return type != 0;
  }
  
  public boolean isSyncInProgress()
  {
    return UIProvider.SyncStatus.isSyncInProgress(syncStatus);
  }
  
  public boolean isTrash()
  {
    return type == 5;
  }
  
  public boolean isViewAll()
  {
    return type == 9;
  }
  
  public boolean supportsCapability(int paramInt)
  {
    return (capabilities & paramInt) != 0;
  }
  
  public final boolean wasSyncSuccessful()
  {
    return (lastSyncResult & 0xF) == 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(id);
    paramParcel.writeParcelable(uri, 0);
    paramParcel.writeString(name);
    paramParcel.writeInt(capabilities);
    if (hasChildren) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(syncWindow);
      paramParcel.writeParcelable(conversationListUri, 0);
      paramParcel.writeParcelable(childFoldersListUri, 0);
      paramParcel.writeInt(unreadCount);
      paramParcel.writeInt(totalCount);
      paramParcel.writeParcelable(refreshUri, 0);
      paramParcel.writeInt(syncStatus);
      paramParcel.writeInt(lastSyncResult);
      paramParcel.writeInt(type);
      paramParcel.writeLong(iconResId);
      paramParcel.writeString(bgColor);
      paramParcel.writeString(fgColor);
      paramParcel.writeParcelable(loadMoreUri, 0);
      paramParcel.writeString(hierarchicalDesc);
      paramParcel.writeParcelable(parent, 0);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Folder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */