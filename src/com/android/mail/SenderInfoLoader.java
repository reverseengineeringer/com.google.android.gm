package com.android.mail;

import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.util.Pair;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SenderInfoLoader
  extends AsyncTaskLoader<ImmutableMap<String, ContactInfo>>
{
  private static final String[] DATA_COLS = { "_id", "data1", "contact_presence", "contact_id", "photo_id" };
  private static final String[] PHOTO_COLS = { "_id", "data15" };
  private final Set<String> mSenders;
  
  public SenderInfoLoader(Context paramContext, Set<String> paramSet)
  {
    super(paramContext);
    mSenders = paramSet;
  }
  
  static void appendQuestionMarks(StringBuilder paramStringBuilder, Iterable<?> paramIterable)
  {
    int i = 1;
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      paramIterable.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        paramStringBuilder.append('?');
        break;
        paramStringBuilder.append(',');
      }
    }
  }
  
  static ArrayList<String> getTruncatedQueryParams(Collection<String> paramCollection)
  {
    int k = Math.min(paramCollection.size(), 75);
    ArrayList localArrayList = new ArrayList(k);
    int i = 0;
    paramCollection = paramCollection.iterator();
    int j;
    do
    {
      if (!paramCollection.hasNext()) {
        break;
      }
      localArrayList.add((String)paramCollection.next());
      j = i + 1;
      i = j;
    } while (j < k);
    return localArrayList;
  }
  
  private static String[] toStringArray(Collection<String> paramCollection)
  {
    return (String[])paramCollection.toArray(new String[paramCollection.size()]);
  }
  
  public ImmutableMap<String, ContactInfo> loadInBackground()
  {
    Object localObject1;
    if ((mSenders == null) || (mSenders.isEmpty())) {
      localObject1 = null;
    }
    HashMap localHashMap1;
    HashMap localHashMap2;
    Object localObject7;
    Object localObject6;
    Object localObject5;
    Object localObject4;
    do
    {
      do
      {
        for (;;)
        {
          return (ImmutableMap<String, ContactInfo>)localObject1;
          localObject1 = null;
          localHashMap1 = Maps.newHashMap();
          localHashMap2 = Maps.newHashMap();
          localObject7 = new ArrayList();
          Object localObject2 = getTruncatedQueryParams(mSenders);
          localObject6 = new StringBuilder().append("mimetype").append("='").append("vnd.android.cursor.item/email_v2").append("' AND ").append("data1").append(" IN (");
          appendQuestionMarks((StringBuilder)localObject6, (Iterable)localObject2);
          ((StringBuilder)localObject6).append(')');
          try
          {
            localObject2 = getContext().getContentResolver().query(ContactsContract.Data.CONTENT_URI, DATA_COLS, ((StringBuilder)localObject6).toString(), toStringArray((Collection)localObject2), null);
            if (localObject2 == null)
            {
              localObject1 = null;
              return null;
            }
            i = -1;
            for (;;)
            {
              i += 1;
              localObject1 = localObject2;
              if (!((Cursor)localObject2).moveToPosition(i)) {
                break;
              }
              localObject1 = localObject2;
              String str = ((Cursor)localObject2).getString(1);
              localObject1 = localObject2;
              long l = ((Cursor)localObject2).getLong(3);
              localObject5 = null;
              localObject1 = localObject2;
              Uri localUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, l);
              localObject1 = localObject2;
              if (!((Cursor)localObject2).isNull(2))
              {
                localObject1 = localObject2;
                localObject5 = Integer.valueOf(((Cursor)localObject2).getInt(2));
              }
              localObject1 = localObject2;
              localObject5 = new ContactInfo(localUri, (Integer)localObject5, null);
              localObject1 = localObject2;
              if (!((Cursor)localObject2).isNull(4))
              {
                localObject1 = localObject2;
                l = ((Cursor)localObject2).getLong(4);
                localObject1 = localObject2;
                ((ArrayList)localObject7).add(Long.toString(l));
                localObject1 = localObject2;
                localHashMap2.put(Long.valueOf(l), Pair.create(str, localObject5));
              }
              localObject1 = localObject2;
              localHashMap1.put(str, localObject5);
            }
            localObject1 = localObject3;
          }
          finally
          {
            if (localObject1 != null) {
              ((Cursor)localObject1).close();
            }
          }
        }
        ((Cursor)localObject3).close();
        localObject1 = localObject3;
        if (!((ArrayList)localObject7).isEmpty()) {
          break;
        }
        localObject1 = localObject3;
        localObject5 = ImmutableMap.copyOf(localHashMap1);
        localObject1 = localObject5;
      } while (localObject3 == null);
      ((Cursor)localObject3).close();
      return (ImmutableMap<String, ContactInfo>)localObject5;
      localObject1 = localObject3;
      localObject5 = getTruncatedQueryParams((Collection)localObject7);
      localObject1 = localObject3;
      ((StringBuilder)localObject6).setLength(0);
      localObject1 = localObject3;
      ((StringBuilder)localObject6).append("_id").append(" IN (");
      localObject1 = localObject3;
      appendQuestionMarks((StringBuilder)localObject6, (Iterable)localObject5);
      localObject1 = localObject3;
      ((StringBuilder)localObject6).append(')');
      localObject1 = localObject3;
      localObject5 = getContext().getContentResolver().query(ContactsContract.Data.CONTENT_URI, PHOTO_COLS, ((StringBuilder)localObject6).toString(), toStringArray((Collection)localObject5), null);
      if (localObject5 != null) {
        break;
      }
      localObject1 = localObject5;
      localObject4 = ImmutableMap.copyOf(localHashMap1);
      localObject1 = localObject4;
    } while (localObject5 == null);
    ((Cursor)localObject5).close();
    return (ImmutableMap<String, ContactInfo>)localObject4;
    int i = -1;
    for (;;)
    {
      int j = i + 1;
      localObject1 = localObject5;
      if (!((Cursor)localObject5).moveToPosition(j)) {
        break;
      }
      localObject1 = localObject5;
      localObject6 = ((Cursor)localObject5).getBlob(1);
      i = j;
      if (localObject6 != null)
      {
        localObject1 = localObject5;
        localObject7 = (Pair)localHashMap2.get(Long.valueOf(((Cursor)localObject5).getLong(0)));
        localObject1 = localObject5;
        localObject4 = (String)first;
        localObject1 = localObject5;
        localObject7 = (ContactInfo)second;
        localObject1 = localObject5;
        localObject6 = BitmapFactory.decodeByteArray((byte[])localObject6, 0, localObject6.length);
        localObject1 = localObject5;
        localHashMap1.put(localObject4, new ContactInfo(contactUri, status, (Bitmap)localObject6));
        i = j;
      }
    }
    if (localObject5 != null) {
      ((Cursor)localObject5).close();
    }
    return ImmutableMap.copyOf(localHashMap1);
  }
  
  protected void onStartLoading()
  {
    forceLoad();
  }
  
  protected void onStopLoading()
  {
    cancelLoad();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.SenderInfoLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */