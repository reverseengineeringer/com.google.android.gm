package com.google.android.gm.provider;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Gmail$Settings
  implements Serializable
{
  static final long serialVersionUID = 1L;
  private long mConversationAgeDays;
  private transient BitSet mDirtyBits = new BitSet();
  private Set<String> mLabelsIncluded;
  private Set<String> mLabelsPartial;
  private long mMaxAttachmentSizeMb;
  private long mSwipe;
  
  public static Settings fromJson(JSONObject paramJSONObject)
    throws JSONException
  {
    Settings localSettings = new Settings();
    mConversationAgeDays = paramJSONObject.getLong("conversation_age_days");
    mMaxAttachmentSizeMb = paramJSONObject.getLong("max_attachment_size_mb");
    mLabelsIncluded = Sets.newHashSet();
    getStringsIntoCollection(paramJSONObject, "labels_included", mLabelsIncluded);
    mLabelsPartial = Sets.newHashSet();
    getStringsIntoCollection(paramJSONObject, "labels_partial", mLabelsPartial);
    return localSettings;
  }
  
  private BitSet getDirtyBits()
  {
    if (mDirtyBits == null) {
      mDirtyBits = new BitSet();
    }
    return mDirtyBits;
  }
  
  private static void getStringsIntoCollection(JSONObject paramJSONObject, String paramString, Collection<String> paramCollection)
    throws JSONException
  {
    if (paramJSONObject.has(paramString))
    {
      paramJSONObject = paramJSONObject.getJSONArray(paramString);
      int i = 0;
      int j = paramJSONObject.length();
      while (i < j)
      {
        paramCollection.add(paramJSONObject.getString(i));
        i += 1;
      }
    }
  }
  
  private boolean hasConversationAgeDaysChanged()
  {
    try
    {
      boolean bool = getDirtyBits().get(1);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean hasLabelsIncludedChanged()
  {
    try
    {
      boolean bool = getDirtyBits().get(3);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean hasLabelsPartialChanged()
  {
    try
    {
      boolean bool = getDirtyBits().get(4);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean hasMaxAttachmentSizeMbChanged()
  {
    try
    {
      boolean bool = getDirtyBits().get(2);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    mConversationAgeDays = paramObjectInputStream.readLong();
    mMaxAttachmentSizeMb = paramObjectInputStream.readLong();
    mLabelsIncluded = Sets.newHashSet((String[])paramObjectInputStream.readObject());
    mLabelsPartial = Sets.newHashSet((String[])paramObjectInputStream.readObject());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeLong(mConversationAgeDays);
    paramObjectOutputStream.writeLong(mMaxAttachmentSizeMb);
    paramObjectOutputStream.writeObject((String[])mLabelsIncluded.toArray(new String[mLabelsIncluded.size()]));
    paramObjectOutputStream.writeObject((String[])mLabelsPartial.toArray(new String[mLabelsPartial.size()]));
  }
  
  public long getConversationAgeDays()
  {
    try
    {
      long l = mConversationAgeDays;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public List<String> getLabelsIncluded()
  {
    try
    {
      ImmutableList localImmutableList = ImmutableList.copyOf(mLabelsIncluded.toArray(new String[mLabelsIncluded.size()]));
      return localImmutableList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public List<String> getLabelsPartial()
  {
    try
    {
      ImmutableList localImmutableList = ImmutableList.copyOf(mLabelsPartial.toArray(new String[mLabelsPartial.size()]));
      return localImmutableList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getMaxAttachmentSizeMb()
  {
    try
    {
      long l = mMaxAttachmentSizeMb;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setConversationAgeDays(long paramLong)
  {
    try
    {
      if (paramLong != mConversationAgeDays)
      {
        getDirtyBits().set(1);
        mConversationAgeDays = paramLong;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setLabelsIncluded(Collection<String> paramCollection)
  {
    try
    {
      paramCollection = Sets.newHashSet(paramCollection);
      if (!paramCollection.equals(mLabelsIncluded))
      {
        getDirtyBits().set(3);
        mLabelsIncluded = paramCollection;
      }
      return;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public void setLabelsPartial(Collection<String> paramCollection)
  {
    try
    {
      paramCollection = Sets.newHashSet(paramCollection);
      if (!paramCollection.equals(mLabelsPartial))
      {
        getDirtyBits().set(4);
        mLabelsPartial = paramCollection;
      }
      return;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public void setMaxAttachmentSizeMb(long paramLong)
  {
    try
    {
      if (paramLong != mMaxAttachmentSizeMb)
      {
        getDirtyBits().set(2);
        mMaxAttachmentSizeMb = paramLong;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public JSONObject toJson()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("conversation_age_days", mConversationAgeDays);
    localJSONObject.put("max_attachment_size_mb", mMaxAttachmentSizeMb);
    localJSONObject.put("labels_included", new JSONArray(mLabelsIncluded));
    localJSONObject.put("labels_partial", new JSONArray(mLabelsPartial));
    return localJSONObject;
  }
  
  public String toString()
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("Settings{mConversationAgeDays=").append(mConversationAgeDays).append(", mMaxAttachmentSizeMb=").append(mMaxAttachmentSizeMb).append(", mLabelsIncluded=");
    if (mLabelsIncluded == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", mLabelsPartial=");
      if (mLabelsPartial != null) {
        break label112;
      }
    }
    label112:
    for (Object localObject1 = localObject2;; localObject1 = Arrays.asList(new Set[] { mLabelsPartial }))
    {
      return localObject1 + ", mDirtyBits=" + getDirtyBits() + '}';
      localObject1 = Arrays.asList(new Set[] { mLabelsIncluded });
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Gmail.Settings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */