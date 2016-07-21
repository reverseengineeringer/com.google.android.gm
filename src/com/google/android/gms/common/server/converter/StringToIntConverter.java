package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import eof;
import eoh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class StringToIntConverter
  implements SafeParcelable, eoh<String, Integer>
{
  public static final eof CREATOR = new eof();
  final int a;
  final HashMap<String, Integer> b;
  private final HashMap<Integer, String> c;
  private final ArrayList<StringToIntConverter.Entry> d;
  
  public StringToIntConverter()
  {
    a = 1;
    b = new HashMap();
    c = new HashMap();
    d = null;
  }
  
  public StringToIntConverter(int paramInt, ArrayList<StringToIntConverter.Entry> paramArrayList)
  {
    a = paramInt;
    b = new HashMap();
    c = new HashMap();
    d = null;
    a(paramArrayList);
  }
  
  private final void a(ArrayList<StringToIntConverter.Entry> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      StringToIntConverter.Entry localEntry = (StringToIntConverter.Entry)paramArrayList.next();
      String str = b;
      int i = c;
      b.put(str, Integer.valueOf(i));
      c.put(Integer.valueOf(i), str);
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new StringToIntConverter.Entry(str, ((Integer)b.get(str)).intValue()));
    }
    emj.b(paramParcel, 2, localArrayList, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.converter.StringToIntConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */