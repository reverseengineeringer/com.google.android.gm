package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gfj;
import java.util.List;

public class GetConnectedNodesResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetConnectedNodesResponse> CREATOR = new gfj();
  public final int a;
  public final int b;
  public final List<NodeParcelable> c;
  
  public GetConnectedNodesResponse(int paramInt1, int paramInt2, List<NodeParcelable> paramList)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.b(paramParcel, 3, c, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetConnectedNodesResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */