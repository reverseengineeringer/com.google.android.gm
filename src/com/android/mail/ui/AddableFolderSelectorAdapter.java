package com.android.mail.ui;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.android.mail.providers.UIProvider;
import java.util.Set;

public class AddableFolderSelectorAdapter
  extends FolderSelectorAdapter
{
  public AddableFolderSelectorAdapter(Context paramContext, Cursor paramCursor, Set<String> paramSet, int paramInt, String paramString)
  {
    super(paramContext, paramCursor, paramSet, paramInt, paramString);
  }
  
  public static Cursor filterFolders(Cursor paramCursor)
  {
    int i = UIProvider.FOLDERS_PROJECTION.length;
    MatrixCursor localMatrixCursor = new MatrixCursor(UIProvider.FOLDERS_PROJECTION);
    Object[] arrayOfObject = new Object[i];
    if (paramCursor.moveToFirst()) {
      do
      {
        i = paramCursor.getInt(13);
        if ((i == 1) || (i == 0))
        {
          arrayOfObject[0] = Long.valueOf(paramCursor.getLong(0));
          arrayOfObject[1] = paramCursor.getString(1);
          arrayOfObject[2] = paramCursor.getString(2);
          arrayOfObject[3] = Integer.valueOf(paramCursor.getInt(3));
          arrayOfObject[4] = Integer.valueOf(paramCursor.getInt(4));
          arrayOfObject[5] = Integer.valueOf(paramCursor.getInt(5));
          arrayOfObject[6] = paramCursor.getString(6);
          arrayOfObject[7] = paramCursor.getString(7);
          arrayOfObject[8] = Integer.valueOf(paramCursor.getInt(8));
          arrayOfObject[9] = Integer.valueOf(paramCursor.getInt(9));
          arrayOfObject[10] = paramCursor.getString(10);
          arrayOfObject[11] = Integer.valueOf(paramCursor.getInt(11));
          arrayOfObject[12] = Integer.valueOf(paramCursor.getInt(12));
          arrayOfObject[13] = Integer.valueOf(i);
          arrayOfObject[14] = Long.valueOf(paramCursor.getLong(14));
          arrayOfObject[15] = paramCursor.getString(15);
          arrayOfObject[16] = paramCursor.getString(16);
          arrayOfObject[17] = paramCursor.getString(17);
          arrayOfObject[18] = paramCursor.getString(18);
          localMatrixCursor.addRow(arrayOfObject);
        }
      } while (paramCursor.moveToNext());
    }
    return localMatrixCursor;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AddableFolderSelectorAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */