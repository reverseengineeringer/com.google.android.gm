package com.google.android.gm;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.google.android.gm.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

final class LabelSettingsFragment$LabelSettingsAdapter
  extends BaseAdapter
{
  private LabelSettingsFragment$LabelSettingsAdapter(LabelSettingsFragment paramLabelSettingsFragment) {}
  
  private String getVibrateValueDisplayString(String paramString)
  {
    int k = 2;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < LabelSettingsFragment.access$700(this$0).length)
      {
        if (LabelSettingsFragment.access$700(this$0)[i].equals(LabelSettingsFragment.access$1500(this$0))) {
          j = i;
        }
      }
      else {
        return LabelSettingsFragment.access$1700(this$0)[j];
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return LabelSettingsFragment.access$900(this$0).size() + 1;
  }
  
  public LabelSettingsFragment.Pair getItem(int paramInt)
  {
    if (paramInt == 0) {
      return new LabelSettingsFragment.Pair(Persistence.LABEL_SYNCHRONIZATION, null);
    }
    return (LabelSettingsFragment.Pair)LabelSettingsFragment.access$900(this$0).get(paramInt - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getItem(paramInt);
    View localView;
    TextView localTextView1;
    TextView localTextView2;
    CheckBox localCheckBox;
    boolean bool2;
    if (Persistence.isNotificationSubChoice(key))
    {
      paramInt = 2130968648;
      localView = LayoutInflater.from(LabelSettingsFragment.access$100(this$0)).inflate(paramInt, null);
      localTextView1 = (TextView)localView.findViewById(2131755205);
      localTextView2 = (TextView)localView.findViewById(2131755070);
      localCheckBox = (CheckBox)localView.findViewById(2131755204);
      if ((key != Persistence.LABEL_NOTIFICATION_ONCE) && (key != Persistence.LABEL_NOTIFICATION_ON)) {
        localCheckBox.setVisibility(8);
      }
      boolean bool1 = LabelSettingsFragment.access$1100(this$0).getIncludedLabels().contains(LabelSettingsFragment.access$1000(this$0));
      bool2 = LabelSettingsFragment.access$1100(this$0).getPartialLabels().contains(LabelSettingsFragment.access$1000(this$0));
      if ((bool1) || (bool2)) {
        break label277;
      }
      paramInt = 1;
      label159:
      if (key != Persistence.LABEL_SYNCHRONIZATION) {
        break label331;
      }
      localTextView1.setText(2131493348);
      if (!bool1) {
        break label282;
      }
      paramView = LabelSettingsFragment.access$1200(this$0).getString(2131493349);
      label194:
      localTextView2.setText(paramView);
    }
    for (;;)
    {
      if (((Persistence.isNotification(key)) && ((paramInt != 0) || (!LabelSettingsFragment.access$400(this$0)))) || ((Persistence.isNotificationSubChoice(key)) && (!LabelSettingsFragment.access$500(this$0))))
      {
        localView.setEnabled(false);
        localTextView1.setEnabled(false);
        localTextView2.setEnabled(false);
        localCheckBox.setEnabled(false);
      }
      return localView;
      paramInt = 2130968652;
      break;
      label277:
      paramInt = 0;
      break label159;
      label282:
      if (bool2)
      {
        paramView = Utils.formatPlural(LabelSettingsFragment.access$100(this$0), 2131820579, LabelSettingsFragment.access$1100(this$0).getNumberOfSyncDays());
        break label194;
      }
      paramView = LabelSettingsFragment.access$1200(this$0).getString(2131493350);
      break label194;
      label331:
      if (key == Persistence.LABEL_NOTIFICATION_ON)
      {
        localTextView1.setText(2131493227);
        localTextView2.setText(2131493230);
        localCheckBox.setChecked(LabelSettingsFragment.access$500(this$0));
      }
      else if (key == Persistence.LABEL_NOTIFICATION_RINGTONE)
      {
        localTextView1.setText(2131493272);
        localTextView2.setText(LabelSettingsFragment.access$1300(this$0, this$0.mRingtone));
      }
      else if ((LabelSettingsFragment.access$1400(this$0)) && (key == Persistence.LABEL_NOTIFICATION_VIBRATE))
      {
        localTextView1.setText(2131493271);
        localTextView2.setText(getVibrateValueDisplayString(LabelSettingsFragment.access$1500(this$0)));
      }
      else if (key == Persistence.LABEL_NOTIFICATION_ONCE)
      {
        localTextView1.setText(2131493231);
        localTextView2.setText(2131493232);
        localCheckBox.setChecked(LabelSettingsFragment.access$1600(this$0));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelSettingsFragment.LabelSettingsAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */