package android.support.v7.widget;

import aly;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class SearchView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new aly();
  boolean a;
  
  public SearchView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    a = ((Boolean)paramParcel.readValue(null)).booleanValue();
  }
  
  SearchView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + a + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeValue(Boolean.valueOf(a));
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.SearchView.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */