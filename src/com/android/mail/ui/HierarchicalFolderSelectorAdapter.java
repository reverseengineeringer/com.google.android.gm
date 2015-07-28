package com.android.mail.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.android.mail.providers.Folder;
import java.util.Set;

public class HierarchicalFolderSelectorAdapter
  extends FolderSelectorAdapter
{
  private Context mContext;
  
  public HierarchicalFolderSelectorAdapter(Context paramContext, Cursor paramCursor, int paramInt, String paramString, Folder paramFolder)
  {
    super(paramContext, paramCursor, paramInt, paramString, paramFolder);
    mContext = paramContext;
  }
  
  public HierarchicalFolderSelectorAdapter(Context paramContext, Cursor paramCursor, Set<String> paramSet, int paramInt, String paramString)
  {
    super(paramContext, paramCursor, paramSet, paramInt, paramString);
    mContext = paramContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.getView(paramInt, paramView, paramViewGroup);
    if (isHeader(paramInt)) {
      return paramViewGroup;
    }
    Folder localFolder = ((FolderSelectorAdapter.FolderRow)getItem(paramInt)).getFolder();
    CompoundButton localCompoundButton = (CompoundButton)paramViewGroup.findViewById(2131755204);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131755245);
    if (TextUtils.isEmpty(hierarchicalDesc))
    {
      paramView = name;
      if (localCompoundButton == null) {
        break label129;
      }
      if (!TextUtils.isEmpty(hierarchicalDesc)) {
        break label116;
      }
    }
    label116:
    for (paramView = name;; paramView = truncateHierarchy(hierarchicalDesc))
    {
      localCompoundButton.setText(paramView, TextView.BufferType.SPANNABLE);
      return paramViewGroup;
      paramView = truncateHierarchy(hierarchicalDesc);
      break;
    }
    label129:
    localTextView.setText(paramView, TextView.BufferType.SPANNABLE);
    return paramViewGroup;
  }
  
  protected SpannableStringBuilder truncateHierarchy(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    String[] arrayOfString;
    String str1;
    String str2;
    SpannableStringBuilder localSpannableStringBuilder;
    do
    {
      do
      {
        return paramString;
        arrayOfString = paramString.split("/");
        str1 = null;
        str2 = null;
        localSpannableStringBuilder = new SpannableStringBuilder();
        paramString = localSpannableStringBuilder;
      } while (arrayOfString == null);
      paramString = localSpannableStringBuilder;
    } while (arrayOfString.length <= 0);
    int i = arrayOfString.length;
    if (i > 2)
    {
      str1 = arrayOfString[0];
      str2 = arrayOfString[(i - 2)];
      paramString = arrayOfString[(i - 1)];
      if (TextUtils.isEmpty(str2)) {
        break label191;
      }
      if (i <= 3) {
        break label185;
      }
      i = 2131493116;
      label95:
      localSpannableStringBuilder.append(mContext.getResources().getString(i, new Object[] { str1, str2 }));
    }
    for (;;)
    {
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(2131296294), 0, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(paramString);
      return localSpannableStringBuilder;
      if (i > 1)
      {
        str1 = arrayOfString[0];
        paramString = arrayOfString[(i - 1)];
        break;
      }
      paramString = arrayOfString[0];
      break;
      label185:
      i = 2131493115;
      break label95;
      label191:
      if (!TextUtils.isEmpty(str1)) {
        localSpannableStringBuilder.append(mContext.getResources().getString(2131493117, new Object[] { str1, str2 }));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.HierarchicalFolderSelectorAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */