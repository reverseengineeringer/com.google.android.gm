package android.support.v7.app;

import abd;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mg;

public class AppCompatDelegateImplV7$PanelFeatureState$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = mg.a(new abd());
  public int a;
  public boolean b;
  public Bundle c;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a);
    if (b) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (b) {
        paramParcel.writeBundle(c);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */