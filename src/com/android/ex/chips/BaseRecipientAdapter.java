package com.android.ex.chips;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BaseRecipientAdapter
  extends BaseAdapter
  implements Filterable
{
  private Account mAccount;
  private final ContentResolver mContentResolver;
  private final Context mContext;
  private CharSequence mCurrentConstraint;
  private final DelayedMessageHandler mDelayedMessageHandler = new DelayedMessageHandler(null);
  private List<RecipientEntry> mEntries;
  private LinkedHashMap<Long, List<RecipientEntry>> mEntryMap;
  private Set<String> mExistingDestinations;
  private final Handler mHandler = new Handler();
  private final LayoutInflater mInflater;
  private List<RecipientEntry> mNonAggregatedEntries;
  private final LruCache<Uri, byte[]> mPhotoCacheMap;
  private final int mPreferredMaxResultCount;
  private final Queries.Query mQuery;
  private final int mQueryType;
  private int mRemainingDirectoryCount;
  private List<RecipientEntry> mTempEntries;
  
  public BaseRecipientAdapter(Context paramContext)
  {
    this(paramContext, 10, 0);
  }
  
  public BaseRecipientAdapter(Context paramContext, int paramInt1, int paramInt2)
  {
    mContext = paramContext;
    mContentResolver = paramContext.getContentResolver();
    mInflater = LayoutInflater.from(paramContext);
    mPreferredMaxResultCount = paramInt1;
    mPhotoCacheMap = new LruCache(20);
    mQueryType = paramInt2;
    if (paramInt2 == 0)
    {
      mQuery = Queries.EMAIL;
      return;
    }
    if (paramInt2 == 1)
    {
      mQuery = Queries.PHONE;
      return;
    }
    mQuery = Queries.EMAIL;
    Log.e("BaseRecipientAdapter", "Unsupported query type: " + paramInt2);
  }
  
  private void cacheCurrentEntries()
  {
    mTempEntries = mEntries;
  }
  
  private void clearTempEntries()
  {
    mTempEntries = null;
  }
  
  private List<RecipientEntry> constructEntryList(boolean paramBoolean, LinkedHashMap<Long, List<RecipientEntry>> paramLinkedHashMap, List<RecipientEntry> paramList, Set<String> paramSet)
  {
    paramSet = new ArrayList();
    int i = 0;
    paramLinkedHashMap = paramLinkedHashMap.entrySet().iterator();
    int j;
    do
    {
      j = i;
      if (!paramLinkedHashMap.hasNext()) {
        break;
      }
      List localList = (List)((Map.Entry)paramLinkedHashMap.next()).getValue();
      int m = localList.size();
      int k = 0;
      j = i;
      i = k;
      while (i < m)
      {
        RecipientEntry localRecipientEntry = (RecipientEntry)localList.get(i);
        paramSet.add(localRecipientEntry);
        tryFetchPhoto(localRecipientEntry);
        j += 1;
        i += 1;
      }
      i = j;
    } while (j <= mPreferredMaxResultCount);
    if (j <= mPreferredMaxResultCount) {
      paramLinkedHashMap = paramList.iterator();
    }
    for (;;)
    {
      if (paramLinkedHashMap.hasNext())
      {
        paramList = (RecipientEntry)paramLinkedHashMap.next();
        if (j <= mPreferredMaxResultCount) {}
      }
      else
      {
        return paramSet;
      }
      paramSet.add(paramList);
      tryFetchPhoto(paramList);
      j += 1;
    }
  }
  
  private Cursor doQuery(CharSequence paramCharSequence, int paramInt, Long paramLong)
  {
    paramCharSequence = mQuery.getContentFilterUri().buildUpon().appendPath(paramCharSequence.toString()).appendQueryParameter("limit", String.valueOf(paramInt + 5));
    if (paramLong != null) {
      paramCharSequence.appendQueryParameter("directory", String.valueOf(paramLong));
    }
    if (mAccount != null)
    {
      paramCharSequence.appendQueryParameter("name_for_primary_account", mAccount.name);
      paramCharSequence.appendQueryParameter("type_for_primary_account", mAccount.type);
    }
    System.currentTimeMillis();
    paramCharSequence = mContentResolver.query(paramCharSequence.build(), mQuery.getProjection(), null, null, null);
    System.currentTimeMillis();
    return paramCharSequence;
  }
  
  private void fetchPhotoAsync(final RecipientEntry paramRecipientEntry, final Uri paramUri)
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void... paramAnonymousVarArgs)
      {
        paramAnonymousVarArgs = mContentResolver.query(paramUri, BaseRecipientAdapter.PhotoQuery.PROJECTION, null, null, null);
        if (paramAnonymousVarArgs != null) {}
        try
        {
          if (paramAnonymousVarArgs.moveToFirst())
          {
            final byte[] arrayOfByte = paramAnonymousVarArgs.getBlob(0);
            paramRecipientEntry.setPhotoBytes(arrayOfByte);
            mHandler.post(new Runnable()
            {
              public void run()
              {
                mPhotoCacheMap.put(val$photoThumbnailUri, arrayOfByte);
                notifyDataSetChanged();
              }
            });
          }
          return null;
        }
        finally
        {
          paramAnonymousVarArgs.close();
        }
      }
    }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
  }
  
  private List<RecipientEntry> getEntries()
  {
    if (mTempEntries != null) {
      return mTempEntries;
    }
    return mEntries;
  }
  
  private void putOneEntry(TemporaryEntry paramTemporaryEntry, boolean paramBoolean, LinkedHashMap<Long, List<RecipientEntry>> paramLinkedHashMap, List<RecipientEntry> paramList, Set<String> paramSet)
  {
    if (paramSet.contains(destination)) {
      return;
    }
    paramSet.add(destination);
    if (!paramBoolean)
    {
      paramList.add(RecipientEntry.constructTopLevelEntry(displayName, displayNameSource, destination, destinationType, destinationLabel, contactId, dataId, thumbnailUriString));
      return;
    }
    if (paramLinkedHashMap.containsKey(Long.valueOf(contactId)))
    {
      ((List)paramLinkedHashMap.get(Long.valueOf(contactId))).add(RecipientEntry.constructSecondLevelEntry(displayName, displayNameSource, destination, destinationType, destinationLabel, contactId, dataId, thumbnailUriString));
      return;
    }
    paramList = new ArrayList();
    paramList.add(RecipientEntry.constructTopLevelEntry(displayName, displayNameSource, destination, destinationType, destinationLabel, contactId, dataId, thumbnailUriString));
    paramLinkedHashMap.put(Long.valueOf(contactId), paramList);
  }
  
  private List<DirectorySearchParams> setupOtherDirectories(Cursor paramCursor)
  {
    PackageManager localPackageManager = mContext.getPackageManager();
    ArrayList localArrayList = new ArrayList();
    Object localObject = null;
    while (paramCursor.moveToNext())
    {
      long l = paramCursor.getLong(0);
      if (l != 1L)
      {
        DirectorySearchParams localDirectorySearchParams = new DirectorySearchParams();
        String str = paramCursor.getString(4);
        int i = paramCursor.getInt(5);
        directoryId = l;
        displayName = paramCursor.getString(3);
        accountName = paramCursor.getString(1);
        accountType = paramCursor.getString(2);
        if ((str != null) && (i != 0)) {}
        try
        {
          directoryType = localPackageManager.getResourcesForApplication(str).getString(i);
          if (directoryType == null) {
            Log.e("BaseRecipientAdapter", "Cannot resolve directory name: " + i + "@" + str);
          }
          if ((mAccount != null) && (mAccount.name.equals(accountName)) && (mAccount.type.equals(accountType))) {
            localObject = localDirectorySearchParams;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            Log.e("BaseRecipientAdapter", "Cannot resolve directory name: " + i + "@" + str, localNameNotFoundException);
          }
          localArrayList.add(localDirectorySearchParams);
        }
      }
    }
    if (localObject != null) {
      localArrayList.add(1, localObject);
    }
    return localArrayList;
  }
  
  private void startSearchOtherDirectories(CharSequence paramCharSequence, List<DirectorySearchParams> paramList, int paramInt)
  {
    int j = paramList.size();
    int i = 1;
    while (i < j)
    {
      DirectorySearchParams localDirectorySearchParams = (DirectorySearchParams)paramList.get(i);
      constraint = paramCharSequence;
      if (filter == null) {
        filter = new DirectoryFilter(localDirectorySearchParams);
      }
      filter.setLimit(paramInt);
      filter.filter(paramCharSequence);
      i += 1;
    }
    mRemainingDirectoryCount = (j - 1);
    mDelayedMessageHandler.sendDelayedLoadMessage();
  }
  
  private void tryFetchPhoto(RecipientEntry paramRecipientEntry)
  {
    Uri localUri = paramRecipientEntry.getPhotoThumbnailUri();
    if (localUri != null)
    {
      byte[] arrayOfByte = (byte[])mPhotoCacheMap.get(localUri);
      if (arrayOfByte != null) {
        paramRecipientEntry.setPhotoBytes(arrayOfByte);
      }
    }
    else
    {
      return;
    }
    fetchPhotoAsync(paramRecipientEntry, localUri);
  }
  
  private void updateEntries(List<RecipientEntry> paramList)
  {
    mEntries = paramList;
    notifyDataSetChanged();
  }
  
  protected void fetchPhoto(RecipientEntry paramRecipientEntry, Uri paramUri)
  {
    Object localObject = (byte[])mPhotoCacheMap.get(paramUri);
    if (localObject != null) {
      paramRecipientEntry.setPhotoBytes((byte[])localObject);
    }
    do
    {
      return;
      localObject = mContentResolver.query(paramUri, PhotoQuery.PROJECTION, null, null, null);
    } while (localObject == null);
    try
    {
      if (((Cursor)localObject).moveToFirst())
      {
        byte[] arrayOfByte = ((Cursor)localObject).getBlob(0);
        paramRecipientEntry.setPhotoBytes(arrayOfByte);
        mPhotoCacheMap.put(paramUri, arrayOfByte);
      }
      return;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  public int getCount()
  {
    List localList = getEntries();
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  protected int getDefaultPhotoResource()
  {
    return R.drawable.ic_contact_picture;
  }
  
  protected int getDestinationId()
  {
    return 16908308;
  }
  
  protected int getDestinationTypeId()
  {
    return 16908309;
  }
  
  protected int getDisplayNameId()
  {
    return 16908310;
  }
  
  public Filter getFilter()
  {
    return new DefaultFilter(null);
  }
  
  public Object getItem(int paramInt)
  {
    return getEntries().get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  protected int getItemLayout()
  {
    return R.layout.chips_recipient_dropdown_item;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((RecipientEntry)getEntries().get(paramInt)).getEntryType();
  }
  
  protected int getPhotoId()
  {
    return 16908294;
  }
  
  public int getQueryType()
  {
    return mQueryType;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RecipientEntry localRecipientEntry = (RecipientEntry)getEntries().get(paramInt);
    Object localObject4 = localRecipientEntry.getDisplayName();
    Object localObject3 = localRecipientEntry.getDestination();
    Object localObject2;
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject2 = localObject3;
      localObject1 = localObject4;
      if (!TextUtils.equals((CharSequence)localObject4, (CharSequence)localObject3)) {}
    }
    else
    {
      localObject4 = localObject3;
      localObject2 = localObject3;
      localObject1 = localObject4;
      if (localRecipientEntry.isFirstLevel())
      {
        localObject2 = null;
        localObject1 = localObject4;
      }
    }
    if (paramView != null)
    {
      localObject3 = (TextView)paramView.findViewById(getDisplayNameId());
      localObject4 = (TextView)paramView.findViewById(getDestinationId());
      TextView localTextView = (TextView)paramView.findViewById(getDestinationTypeId());
      paramViewGroup = (ImageView)paramView.findViewById(getPhotoId());
      ((TextView)localObject3).setText((CharSequence)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label270;
      }
      ((TextView)localObject4).setText((CharSequence)localObject2);
      label159:
      if (localTextView != null) {
        localTextView.setText(mQuery.getTypeLabel(mContext.getResources(), localRecipientEntry.getDestinationType(), localRecipientEntry.getDestinationLabel()).toString().toUpperCase());
      }
      if (!localRecipientEntry.isFirstLevel()) {
        break label289;
      }
      ((TextView)localObject3).setVisibility(0);
      if (paramViewGroup != null)
      {
        paramViewGroup.setVisibility(0);
        localObject1 = localRecipientEntry.getPhotoBytes();
        if ((localObject1 == null) || (paramViewGroup == null)) {
          break label279;
        }
        paramViewGroup.setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length));
      }
    }
    label270:
    label279:
    label289:
    do
    {
      return paramView;
      paramView = mInflater.inflate(getItemLayout(), paramViewGroup, false);
      break;
      ((TextView)localObject4).setText(null);
      break label159;
      paramViewGroup.setImageResource(getDefaultPhotoResource());
      return paramView;
      ((TextView)localObject3).setVisibility(8);
    } while (paramViewGroup == null);
    paramViewGroup.setVisibility(4);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return ((RecipientEntry)getEntries().get(paramInt)).isSelectable();
  }
  
  public void setAccount(Account paramAccount)
  {
    mAccount = paramAccount;
  }
  
  private final class DefaultFilter
    extends Filter
  {
    private DefaultFilter() {}
    
    public CharSequence convertResultToString(Object paramObject)
    {
      Object localObject = (RecipientEntry)paramObject;
      paramObject = ((RecipientEntry)localObject).getDisplayName();
      localObject = ((RecipientEntry)localObject).getDestination();
      if ((TextUtils.isEmpty((CharSequence)paramObject)) || (TextUtils.equals((CharSequence)paramObject, (CharSequence)localObject))) {
        return (CharSequence)localObject;
      }
      return new Rfc822Token((String)paramObject, (String)localObject, null).toString();
    }
    
    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      Object localObject2 = null;
      List localList1 = null;
      Object localObject3 = null;
      LinkedHashMap localLinkedHashMap = null;
      if (TextUtils.isEmpty(paramCharSequence)) {
        BaseRecipientAdapter.this.clearTempEntries();
      }
      Cursor localCursor;
      ArrayList localArrayList;
      HashSet localHashSet;
      for (;;)
      {
        return localFilterResults;
        localObject1 = localList1;
        try
        {
          localCursor = BaseRecipientAdapter.this.doQuery(paramCharSequence, mPreferredMaxResultCount, null);
          if (localCursor == null)
          {
            paramCharSequence = localLinkedHashMap;
            if (localCursor != null) {
              localCursor.close();
            }
            if (paramCharSequence != null)
            {
              paramCharSequence.close();
              return localFilterResults;
            }
          }
          else
          {
            localObject2 = localCursor;
            localObject1 = localList1;
            localLinkedHashMap = new LinkedHashMap();
            localObject2 = localCursor;
            localObject1 = localList1;
            localArrayList = new ArrayList();
            localObject2 = localCursor;
            localObject1 = localList1;
            localHashSet = new HashSet();
            for (;;)
            {
              localObject2 = localCursor;
              localObject1 = localList1;
              if (!localCursor.moveToNext()) {
                break;
              }
              localObject2 = localCursor;
              localObject1 = localList1;
              BaseRecipientAdapter.this.putOneEntry(new BaseRecipientAdapter.TemporaryEntry(localCursor), true, localLinkedHashMap, localArrayList, localHashSet);
            }
            localObject2 = localCursor;
          }
        }
        finally
        {
          if (localObject2 != null) {
            ((Cursor)localObject2).close();
          }
          if (localObject1 != null) {
            ((Cursor)localObject1).close();
          }
        }
      }
      Object localObject1 = localList1;
      List localList2 = BaseRecipientAdapter.this.constructEntryList(false, localLinkedHashMap, localArrayList, localHashSet);
      localObject2 = localCursor;
      localObject1 = localList1;
      if (mPreferredMaxResultCount - localHashSet.size() > 0)
      {
        localObject2 = localCursor;
        localObject1 = localList1;
        paramCharSequence = mContentResolver.query(BaseRecipientAdapter.DirectoryListQuery.URI, BaseRecipientAdapter.DirectoryListQuery.PROJECTION, null, null, null);
        localObject2 = localCursor;
        localObject1 = paramCharSequence;
        localList1 = BaseRecipientAdapter.this.setupOtherDirectories(paramCharSequence);
      }
      for (;;)
      {
        localObject2 = localCursor;
        localObject1 = paramCharSequence;
        values = new BaseRecipientAdapter.DefaultFilterResult(localList2, localLinkedHashMap, localArrayList, localHashSet, localList1);
        localObject2 = localCursor;
        localObject1 = paramCharSequence;
        count = 1;
        break;
        localList1 = null;
        paramCharSequence = (CharSequence)localObject3;
      }
    }
    
    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      BaseRecipientAdapter.access$702(BaseRecipientAdapter.this, paramCharSequence);
      BaseRecipientAdapter.this.clearTempEntries();
      if (values != null)
      {
        paramFilterResults = (BaseRecipientAdapter.DefaultFilterResult)values;
        BaseRecipientAdapter.access$802(BaseRecipientAdapter.this, entryMap);
        BaseRecipientAdapter.access$902(BaseRecipientAdapter.this, nonAggregatedEntries);
        BaseRecipientAdapter.access$1002(BaseRecipientAdapter.this, existingDestinations);
        if ((entries.size() == 0) && (paramsList != null)) {
          BaseRecipientAdapter.this.cacheCurrentEntries();
        }
        BaseRecipientAdapter.this.updateEntries(entries);
        if (paramsList != null)
        {
          int i = mPreferredMaxResultCount;
          int j = existingDestinations.size();
          BaseRecipientAdapter.this.startSearchOtherDirectories(paramCharSequence, paramsList, i - j);
        }
      }
    }
  }
  
  private static class DefaultFilterResult
  {
    public final List<RecipientEntry> entries;
    public final LinkedHashMap<Long, List<RecipientEntry>> entryMap;
    public final Set<String> existingDestinations;
    public final List<RecipientEntry> nonAggregatedEntries;
    public final List<BaseRecipientAdapter.DirectorySearchParams> paramsList;
    
    public DefaultFilterResult(List<RecipientEntry> paramList1, LinkedHashMap<Long, List<RecipientEntry>> paramLinkedHashMap, List<RecipientEntry> paramList2, Set<String> paramSet, List<BaseRecipientAdapter.DirectorySearchParams> paramList)
    {
      entries = paramList1;
      entryMap = paramLinkedHashMap;
      nonAggregatedEntries = paramList2;
      existingDestinations = paramSet;
      paramsList = paramList;
    }
  }
  
  private final class DelayedMessageHandler
    extends Handler
  {
    private DelayedMessageHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (mRemainingDirectoryCount > 0) {
        BaseRecipientAdapter.this.updateEntries(BaseRecipientAdapter.access$400(BaseRecipientAdapter.this, true, mEntryMap, mNonAggregatedEntries, mExistingDestinations));
      }
    }
    
    public void removeDelayedLoadMessage()
    {
      removeMessages(1);
    }
    
    public void sendDelayedLoadMessage()
    {
      sendMessageDelayed(obtainMessage(1, 0, 0, null), 1000L);
    }
  }
  
  private final class DirectoryFilter
    extends Filter
  {
    private int mLimit;
    private final BaseRecipientAdapter.DirectorySearchParams mParams;
    
    public DirectoryFilter(BaseRecipientAdapter.DirectorySearchParams paramDirectorySearchParams)
    {
      mParams = paramDirectorySearchParams;
    }
    
    public int getLimit()
    {
      try
      {
        int i = mLimit;
        return i;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      values = null;
      count = 0;
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        ArrayList localArrayList = new ArrayList();
        CharSequence localCharSequence = null;
        try
        {
          paramCharSequence = BaseRecipientAdapter.this.doQuery(paramCharSequence, getLimit(), Long.valueOf(mParams.directoryId));
          if (paramCharSequence != null) {
            for (;;)
            {
              localCharSequence = paramCharSequence;
              if (!paramCharSequence.moveToNext()) {
                break;
              }
              localCharSequence = paramCharSequence;
              localArrayList.add(new BaseRecipientAdapter.TemporaryEntry(paramCharSequence));
            }
          }
          if (paramCharSequence == null) {
            break label116;
          }
        }
        finally
        {
          if (localCharSequence != null) {
            localCharSequence.close();
          }
        }
        paramCharSequence.close();
        label116:
        if (!localArrayList.isEmpty())
        {
          values = localArrayList;
          count = 1;
        }
      }
      return localFilterResults;
    }
    
    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      mDelayedMessageHandler.removeDelayedLoadMessage();
      if (TextUtils.equals(paramCharSequence, mCurrentConstraint))
      {
        if (count > 0)
        {
          paramCharSequence = ((ArrayList)values).iterator();
          if (paramCharSequence.hasNext())
          {
            BaseRecipientAdapter.TemporaryEntry localTemporaryEntry = (BaseRecipientAdapter.TemporaryEntry)paramCharSequence.next();
            BaseRecipientAdapter localBaseRecipientAdapter = BaseRecipientAdapter.this;
            if (mParams.directoryId == 0L) {}
            for (boolean bool = true;; bool = false)
            {
              localBaseRecipientAdapter.putOneEntry(localTemporaryEntry, bool, mEntryMap, mNonAggregatedEntries, mExistingDestinations);
              break;
            }
          }
        }
        BaseRecipientAdapter.access$1510(BaseRecipientAdapter.this);
        if (mRemainingDirectoryCount > 0) {
          mDelayedMessageHandler.sendDelayedLoadMessage();
        }
        if ((count > 0) || (mRemainingDirectoryCount == 0)) {
          BaseRecipientAdapter.this.clearTempEntries();
        }
      }
      BaseRecipientAdapter.this.updateEntries(BaseRecipientAdapter.access$400(BaseRecipientAdapter.this, false, mEntryMap, mNonAggregatedEntries, mExistingDestinations));
    }
    
    public void setLimit(int paramInt)
    {
      try
      {
        mLimit = paramInt;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  private static class DirectoryListQuery
  {
    public static final String[] PROJECTION = { "_id", "accountName", "accountType", "displayName", "packageName", "typeResourceId" };
    public static final Uri URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "directories");
  }
  
  public static final class DirectorySearchParams
  {
    public String accountName;
    public String accountType;
    public CharSequence constraint;
    public long directoryId;
    public String directoryType;
    public String displayName;
    public BaseRecipientAdapter.DirectoryFilter filter;
  }
  
  private static class PhotoQuery
  {
    public static final String[] PROJECTION = { "data15" };
  }
  
  private static class TemporaryEntry
  {
    public final long contactId;
    public final long dataId;
    public final String destination;
    public final String destinationLabel;
    public final int destinationType;
    public final String displayName;
    public final int displayNameSource;
    public final String thumbnailUriString;
    
    public TemporaryEntry(Cursor paramCursor)
    {
      displayName = paramCursor.getString(0);
      destination = paramCursor.getString(1);
      destinationType = paramCursor.getInt(2);
      destinationLabel = paramCursor.getString(3);
      contactId = paramCursor.getLong(4);
      dataId = paramCursor.getLong(5);
      thumbnailUriString = paramCursor.getString(6);
      displayNameSource = paramCursor.getInt(7);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.BaseRecipientAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */