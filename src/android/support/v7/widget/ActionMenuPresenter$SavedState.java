package android.support.v7.widget;

import afi;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ActionMenuPresenter$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new afi();
  public int a;
  
  ActionMenuPresenter$SavedState() {}
  
  public ActionMenuPresenter$SavedState(Parcel paramParcel)
  {
    a = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */