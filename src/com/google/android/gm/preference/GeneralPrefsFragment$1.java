package com.google.android.gm.preference;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.SearchRecentSuggestions;

class GeneralPrefsFragment$1
  extends AsyncTask<Void, Void, Void>
{
  GeneralPrefsFragment$1(GeneralPrefsFragment paramGeneralPrefsFragment, Context paramContext) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = val$context.getString(2131492882);
    new SearchRecentSuggestions(val$context, paramVarArgs, 1).clearHistory();
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.GeneralPrefsFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */