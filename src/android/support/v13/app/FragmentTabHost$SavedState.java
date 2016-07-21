package android.support.v13.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import eh;

public class FragmentTabHost$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new eh();
  String a;
  
  public FragmentTabHost$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    a = paramParcel.readString();
  }
  
  FragmentTabHost$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + a + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(a);
  }
}

/* Location:
 * Qualified Name:     android.support.v13.app.FragmentTabHost.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */