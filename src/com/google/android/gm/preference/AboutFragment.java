package com.google.android.gm.preference;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gm.Utils;
import com.google.android.gsf.Gservices;
import java.util.Calendar;

public final class AboutFragment
  extends Fragment
{
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968576, null);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131755018);
    try
    {
      paramViewGroup.setText(getString(2131493178, new Object[] { getActivitygetPackageManagergetPackageInfogetActivitygetPackageName0versionName }));
      ((TextView)paramLayoutInflater.findViewById(2131755019)).setText(getString(2131493177, new Object[] { Integer.valueOf(Calendar.getInstance().get(1)) }));
      paramBundle = (TextView)paramLayoutInflater.findViewById(2131755020);
      paramViewGroup = LinkMovementMethod.getInstance();
      paramBundle.setMovementMethod(paramViewGroup);
      Object localObject1 = new URLSpan("")
      {
        public void onClick(View paramAnonymousView)
        {
          Utils.showFeedbackSurvey(paramAnonymousView.getContext());
        }
      };
      Object localObject2 = getString(2131492960);
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject2);
      localSpannableString.setSpan(localObject1, 0, ((String)localObject2).length(), 34);
      paramBundle.setText(localSpannableString);
      paramBundle = (TextView)paramLayoutInflater.findViewById(2131755021);
      if (Utils.isGoogleFeedbackInstalled(getActivity()))
      {
        paramBundle.setMovementMethod(paramViewGroup);
        localObject1 = new URLSpan("")
        {
          public void onClick(View paramAnonymousView)
          {
            Utils.launchGoogleFeedback(paramAnonymousView.getContext());
          }
        };
        localObject2 = getString(2131493172);
        localSpannableString = new SpannableString((CharSequence)localObject2);
        localSpannableString.setSpan(localObject1, 0, ((String)localObject2).length(), 34);
        paramBundle.setText(localSpannableString);
      }
      for (;;)
      {
        paramBundle = (TextView)paramLayoutInflater.findViewById(2131755024);
        paramBundle.setMovementMethod(paramViewGroup);
        localObject1 = new URLSpan("")
        {
          public void onClick(View paramAnonymousView)
          {
            Utils.showOpenSourceLicenses(paramAnonymousView.getContext());
          }
        };
        localObject2 = getString(2131493175);
        localSpannableString = new SpannableString((CharSequence)localObject2);
        localSpannableString.setSpan(localObject1, 0, ((String)localObject2).length(), 34);
        paramBundle.setText(localSpannableString);
        paramBundle = (TextView)paramLayoutInflater.findViewById(2131755025);
        paramBundle.setMovementMethod(paramViewGroup);
        paramViewGroup = new URLSpan(Gservices.getString(paramLayoutInflater.getContext().getContentResolver(), "gmail_privacy_policy_url", "http://www.google.com/policies/privacy/"));
        localObject1 = getString(2131493176);
        localObject2 = new SpannableString((CharSequence)localObject1);
        ((Spannable)localObject2).setSpan(paramViewGroup, 0, ((String)localObject1).length(), 34);
        paramBundle.setText((CharSequence)localObject2);
        setHasOptionsMenu(true);
        return paramLayoutInflater;
        paramBundle.setVisibility(8);
        paramLayoutInflater.findViewById(2131755022).setVisibility(8);
      }
    }
    catch (PackageManager.NameNotFoundException paramViewGroup)
    {
      for (;;) {}
    }
  }
  
  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.AboutFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */