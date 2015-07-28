package com.android.ex.chips;

import android.os.AsyncTask;
import android.os.Handler;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class RecipientEditTextView$RecipientReplacementTask
  extends AsyncTask<Void, Void, Void>
{
  private RecipientEditTextView$RecipientReplacementTask(RecipientEditTextView paramRecipientEditTextView) {}
  
  private RecipientChip createFreeChip(RecipientEntry paramRecipientEntry)
  {
    try
    {
      if (RecipientEditTextView.access$1800(this$0)) {
        return null;
      }
      paramRecipientEntry = RecipientEditTextView.access$1900(this$0, paramRecipientEntry, -1, false, false);
      return paramRecipientEntry;
    }
    catch (NullPointerException paramRecipientEntry)
    {
      Log.e("RecipientEditTextView", paramRecipientEntry.getMessage(), paramRecipientEntry);
    }
    return null;
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    if (RecipientEditTextView.access$2000(this$0) != null) {
      RecipientEditTextView.access$2000(this$0).cancel(true);
    }
    final ArrayList localArrayList1 = new ArrayList();
    paramVarArgs = this$0.getSortedRecipients();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localArrayList1.add(paramVarArgs[i]);
      i += 1;
    }
    if (RecipientEditTextView.access$2100(this$0) != null) {
      localArrayList1.addAll(RecipientEditTextView.access$2100(this$0));
    }
    paramVarArgs = new ArrayList();
    i = 0;
    RecipientChip localRecipientChip1;
    while (i < localArrayList1.size())
    {
      localRecipientChip1 = (RecipientChip)localArrayList1.get(i);
      if (localRecipientChip1 != null) {
        paramVarArgs.add(this$0.createAddressText(localRecipientChip1.getEntry()));
      }
      i += 1;
    }
    HashMap localHashMap = RecipientAlternatesAdapter.getMatchingRecipients(this$0.getContext(), paramVarArgs);
    final ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      RecipientChip localRecipientChip2 = (RecipientChip)localIterator.next();
      localRecipientChip1 = null;
      paramVarArgs = localRecipientChip1;
      if (RecipientEntry.isCreatedRecipient(localRecipientChip2.getEntry().getContactId()))
      {
        paramVarArgs = localRecipientChip1;
        if (this$0.getSpannable().getSpanStart(localRecipientChip2) != -1) {
          paramVarArgs = RecipientEditTextView.access$2300(this$0, (RecipientEntry)localHashMap.get(RecipientEditTextView.access$2200(this$0, localRecipientChip2.getEntry().getDestination())));
        }
      }
      if (paramVarArgs != null) {
        localArrayList2.add(createFreeChip(paramVarArgs));
      } else {
        localArrayList2.add(localRecipientChip2);
      }
    }
    if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
      RecipientEditTextView.access$500(this$0).post(new Runnable()
      {
        public void run()
        {
          Editable localEditable = this$0.getText();
          int i = 0;
          Iterator localIterator = localArrayList1.iterator();
          while (localIterator.hasNext())
          {
            RecipientChip localRecipientChip = (RecipientChip)localIterator.next();
            int j = localEditable.getSpanStart(localRecipientChip);
            if (j != -1)
            {
              int k = localEditable.getSpanEnd(localRecipientChip);
              localEditable.removeSpan(localRecipientChip);
              localRecipientChip = (RecipientChip)localArrayList2.get(i);
              SpannableString localSpannableString = new SpannableString(this$0.createAddressText(localRecipientChip.getEntry()).trim());
              localSpannableString.setSpan(localRecipientChip, 0, localSpannableString.length(), 33);
              localEditable.replace(j, k, localSpannableString);
              localRecipientChip.setOriginalText(localSpannableString.toString());
            }
            i += 1;
          }
          localArrayList1.clear();
        }
      });
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView.RecipientReplacementTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */