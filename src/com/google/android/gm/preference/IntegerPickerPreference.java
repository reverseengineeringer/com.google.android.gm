package com.google.android.gm.preference;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Parcelable;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import cxa;
import dfy;
import dga;
import dgd;
import dge;
import dnt;
import dnu;

public class IntegerPickerPreference
  extends DialogPreference
{
  public dnu a;
  public final Context b;
  public int c;
  private NumberPicker d;
  private TextView e;
  
  public IntegerPickerPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b = paramContext;
    setDialogLayoutResource(dga.u);
  }
  
  public final void a()
  {
    e.setText(cxa.a(b, dgd.g, d.getValue()));
  }
  
  protected void onBindDialogView(View paramView)
  {
    super.onBindDialogView(paramView);
    e = ((TextView)paramView.findViewById(dfy.aq));
    d = ((NumberPicker)paramView.findViewById(dfy.ar));
    d.setMinValue(1);
    d.setMaxValue(999);
    d.setValue(c);
    a();
    d.setOnValueChangedListener(new dnt(this));
  }
  
  protected void onDialogClosed(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d.clearFocus();
      if (a != null) {
        a.a(d.getValue());
      }
    }
  }
  
  protected void onPrepareDialogBuilder(AlertDialog.Builder paramBuilder)
  {
    super.onPrepareDialogBuilder(paramBuilder);
    paramBuilder.setTitle(getContext().getString(dge.fB)).setCancelable(true);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(IntegerPickerPreference.SavedState.class))) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (IntegerPickerPreference.SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
    } while (d == null);
    d.setValue(a);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    IntegerPickerPreference.SavedState localSavedState = new IntegerPickerPreference.SavedState(super.onSaveInstanceState());
    if (d != null) {
      a = d.getValue();
    }
    return localSavedState;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.IntegerPickerPreference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */