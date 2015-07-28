package com.android.ex.chips;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RecipientAlternatesAdapter
  extends CursorAdapter
{
  private OnCheckedItemChangedListener mCheckedItemChangedListener;
  private int mCheckedItemPosition = -1;
  private final long mCurrentId;
  private final LayoutInflater mLayoutInflater;
  private Queries.Query mQuery;
  
  public RecipientAlternatesAdapter(Context paramContext, long paramLong1, long paramLong2, int paramInt1, int paramInt2, OnCheckedItemChangedListener paramOnCheckedItemChangedListener)
  {
    super(paramContext, getCursorForConstruction(paramContext, paramLong1, paramInt2), 0);
    mLayoutInflater = LayoutInflater.from(paramContext);
    mCurrentId = paramLong2;
    mCheckedItemChangedListener = paramOnCheckedItemChangedListener;
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
    Log.e("RecipAlternates", "Unsupported query type: " + paramInt2);
  }
  
  private static Cursor getCursorForConstruction(Context paramContext, long paramLong, int paramInt)
  {
    if (paramInt == 0) {}
    for (paramContext = paramContext.getContentResolver().query(Queries.EMAIL.getContentUri(), Queries.EMAIL.getProjection(), Queries.EMAIL.getProjection()[4] + " =?", new String[] { String.valueOf(paramLong) }, null);; paramContext = paramContext.getContentResolver().query(Queries.PHONE.getContentUri(), Queries.PHONE.getProjection(), Queries.PHONE.getProjection()[4] + " =?", new String[] { String.valueOf(paramLong) }, null)) {
      return removeDuplicateDestinations(paramContext);
    }
  }
  
  public static HashMap<String, RecipientEntry> getMatchingRecipients(Context paramContext, ArrayList<String> paramArrayList)
  {
    return getMatchingRecipients(paramContext, paramArrayList, 0);
  }
  
  public static HashMap<String, RecipientEntry> getMatchingRecipients(Context paramContext, ArrayList<String> paramArrayList, int paramInt)
  {
    Object localObject1;
    int i;
    String[] arrayOfString;
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      localObject1 = Queries.EMAIL;
      i = Math.min(50, paramArrayList.size());
      arrayOfString = new String[i];
      localStringBuilder = new StringBuilder();
      paramInt = 0;
      label36:
      if (paramInt >= i) {
        break label129;
      }
      localObject2 = Rfc822Tokenizer.tokenize(((String)paramArrayList.get(paramInt)).toLowerCase());
      if (localObject2.length <= 0) {
        break label116;
      }
    }
    label116:
    for (Object localObject2 = localObject2[0].getAddress();; localObject2 = (String)paramArrayList.get(paramInt))
    {
      arrayOfString[paramInt] = localObject2;
      localStringBuilder.append("?");
      if (paramInt < i - 1) {
        localStringBuilder.append(",");
      }
      paramInt += 1;
      break label36;
      localObject1 = Queries.PHONE;
      break;
    }
    label129:
    if (Log.isLoggable("RecipAlternates", 3)) {
      Log.d("RecipAlternates", "Doing reverse lookup for " + arrayOfString.toString());
    }
    paramArrayList = new HashMap();
    paramContext = paramContext.getContentResolver().query(((Queries.Query)localObject1).getContentUri(), ((Queries.Query)localObject1).getProjection(), localObject1.getProjection()[1] + " IN (" + localStringBuilder.toString() + ")", arrayOfString, null);
    if (paramContext != null) {}
    try
    {
      if (paramContext.moveToFirst())
      {
        boolean bool;
        do
        {
          localObject1 = paramContext.getString(1);
          paramArrayList.put(localObject1, RecipientEntry.constructTopLevelEntry(paramContext.getString(0), paramContext.getInt(7), paramContext.getString(1), paramContext.getInt(2), paramContext.getString(3), paramContext.getLong(4), paramContext.getLong(5), paramContext.getString(6)));
          if (Log.isLoggable("RecipAlternates", 3)) {
            Log.d("RecipAlternates", "Received reverse look up information for " + (String)localObject1 + " RESULTS: " + " NAME : " + paramContext.getString(0) + " CONTACT ID : " + paramContext.getLong(4) + " ADDRESS :" + paramContext.getString(1));
          }
          bool = paramContext.moveToNext();
        } while (bool);
      }
      return paramArrayList;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  private View newView()
  {
    return mLayoutInflater.inflate(R.layout.chips_recipient_dropdown_item, null);
  }
  
  static Cursor removeDuplicateDestinations(Cursor paramCursor)
  {
    MatrixCursor localMatrixCursor = new MatrixCursor(paramCursor.getColumnNames(), paramCursor.getCount());
    HashSet localHashSet = new HashSet();
    paramCursor.moveToPosition(-1);
    while (paramCursor.moveToNext())
    {
      String str = paramCursor.getString(1);
      if (!localHashSet.contains(str))
      {
        localHashSet.add(str);
        localMatrixCursor.addRow(new Object[] { paramCursor.getString(0), paramCursor.getString(1), Integer.valueOf(paramCursor.getInt(2)), paramCursor.getString(3), Long.valueOf(paramCursor.getLong(4)), Long.valueOf(paramCursor.getLong(5)), paramCursor.getString(6), Integer.valueOf(paramCursor.getInt(7)) });
      }
    }
    return localMatrixCursor;
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    int i = paramCursor.getPosition();
    TextView localTextView = (TextView)paramView.findViewById(16908310);
    ImageView localImageView = (ImageView)paramView.findViewById(16908294);
    RecipientEntry localRecipientEntry = getRecipientEntry(i);
    if (i == 0)
    {
      localTextView.setText(paramCursor.getString(0));
      localTextView.setVisibility(0);
      localImageView.setImageURI(localRecipientEntry.getPhotoThumbnailUri());
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      ((TextView)paramView.findViewById(16908308)).setText(paramCursor.getString(1));
      paramView = (TextView)paramView.findViewById(16908309);
      if (paramView != null) {
        paramView.setText(mQuery.getTypeLabel(paramContext.getResources(), paramCursor.getInt(2), paramCursor.getString(3)).toString().toUpperCase());
      }
      return;
      localTextView.setVisibility(8);
      localImageView.setVisibility(8);
    }
  }
  
  public long getItemId(int paramInt)
  {
    Cursor localCursor = getCursor();
    if (localCursor.moveToPosition(paramInt)) {
      localCursor.getLong(5);
    }
    return -1L;
  }
  
  public RecipientEntry getRecipientEntry(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return RecipientEntry.constructTopLevelEntry(localCursor.getString(0), localCursor.getInt(7), localCursor.getString(1), localCursor.getInt(2), localCursor.getString(3), localCursor.getLong(4), localCursor.getLong(5), localCursor.getString(6));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = newView();
    }
    if (localCursor.getLong(5) == mCurrentId)
    {
      mCheckedItemPosition = paramInt;
      if (mCheckedItemChangedListener != null) {
        mCheckedItemChangedListener.onCheckedItemChanged(mCheckedItemPosition);
      }
    }
    bindView(paramViewGroup, paramViewGroup.getContext(), localCursor);
    return paramViewGroup;
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return newView();
  }
  
  static abstract interface OnCheckedItemChangedListener
  {
    public abstract void onCheckedItemChanged(int paramInt);
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientAlternatesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */