package com.google.android.gm.preference;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import com.google.android.gm.Utils;

public class IntegerPickerPreference
  extends DialogPreference
{
  private Callbacks mCallbacks;
  private final Context mContext;
  private int mConversationAgeDays;
  private TextView mNumberPickerDaysView;
  private NumberPicker mNumberPickerView;
  
  public IntegerPickerPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mContext = paramContext;
  }
  
  private void updateDays()
  {
    mNumberPickerDaysView.setText(Utils.formatPlural(mContext, 2131820577, mNumberPickerView.getValue()));
  }
  
  public void bind(Callbacks paramCallbacks, int paramInt)
  {
    mCallbacks = paramCallbacks;
    mConversationAgeDays = paramInt;
    paramCallbacks = mContext.getResources();
    setDialogLayoutResource(2130968632);
    setTitle(2131493282);
    setSummary(String.format(paramCallbacks.getQuantityText(2131820576, mConversationAgeDays).toString(), new Object[] { Integer.valueOf(mConversationAgeDays) }));
  }
  
  protected void onBindDialogView(View paramView)
  {
    super.onBindDialogView(paramView);
    mNumberPickerDaysView = ((TextView)paramView.findViewById(2131755189));
    mNumberPickerView = ((NumberPicker)paramView.findViewById(2131755188));
    mNumberPickerView.setMinValue(1);
    mNumberPickerView.setMaxValue(999);
    mNumberPickerView.setValue(mConversationAgeDays);
    updateDays();
    mNumberPickerView.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
    {
      public void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        IntegerPickerPreference.this.updateDays();
      }
    });
  }
  
  protected void onDialogClosed(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mNumberPickerView.clearFocus();
      mCallbacks.onNumberChanged(mNumberPickerView.getValue());
    }
  }
  
  protected void onPrepareDialogBuilder(AlertDialog.Builder paramBuilder)
  {
    super.onPrepareDialogBuilder(paramBuilder);
    paramBuilder.setTitle(getContext().getString(2131493282)).setCancelable(true);
  }
  
  public static abstract interface Callbacks
  {
    public abstract void onNumberChanged(int paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.IntegerPickerPreference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */