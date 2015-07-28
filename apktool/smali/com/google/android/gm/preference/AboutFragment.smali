.class public final Lcom/google/android/gm/preference/AboutFragment;
.super Landroid/app/Fragment;
.source "AboutFragment.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 31
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 35
    const/high16 v26, 0x7f040000

    const/16 v27, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v26

    move-object/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v25

    .line 37
    .local v25, "view":Landroid/view/View;
    const v26, 0x7f10000a

    invoke-virtual/range {v25 .. v26}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v24

    check-cast v24, Landroid/widget/TextView;

    .line 39
    .local v24, "versionTextView":Landroid/widget/TextView;
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gm/preference/AboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v26

    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gm/preference/AboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v27

    invoke-virtual/range {v27 .. v27}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v27

    const/16 v28, 0x0

    invoke-virtual/range {v26 .. v28}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v26

    move-object/from16 v0, v26

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    move-object/from16 v23, v0

    .line 42
    .local v23, "version":Ljava/lang/String;
    const v26, 0x7f0c013a

    const/16 v27, 0x1

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v27, v0

    const/16 v28, 0x0

    aput-object v23, v27, v28

    move-object/from16 v0, p0

    move/from16 v1, v26

    move-object/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/preference/AboutFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v26

    move-object/from16 v0, v24

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 47
    .end local v23    # "version":Ljava/lang/String;
    :goto_0
    const v26, 0x7f10000b

    invoke-virtual/range {v25 .. v26}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 48
    .local v6, "copyRightTextView":Landroid/widget/TextView;
    const v26, 0x7f0c0139

    const/16 v27, 0x1

    move/from16 v0, v27

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v27, v0

    const/16 v28, 0x0

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v29

    const/16 v30, 0x1

    invoke-virtual/range {v29 .. v30}, Ljava/util/Calendar;->get(I)I

    move-result v29

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v29

    aput-object v29, v27, v28

    move-object/from16 v0, p0

    move/from16 v1, v26

    move-object/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/preference/AboutFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v26

    move-object/from16 v0, v26

    invoke-virtual {v6, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 51
    const v26, 0x7f10000c

    invoke-virtual/range {v25 .. v26}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 53
    .local v7, "feebackLinkView":Landroid/widget/TextView;
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v11

    .line 54
    .local v11, "movementMethod":Landroid/text/method/MovementMethod;
    invoke-virtual {v7, v11}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 56
    new-instance v21, Lcom/google/android/gm/preference/AboutFragment$1;

    const-string v26, ""

    move-object/from16 v0, v21

    move-object/from16 v1, p0

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v2}, Lcom/google/android/gm/preference/AboutFragment$1;-><init>(Lcom/google/android/gm/preference/AboutFragment;Ljava/lang/String;)V

    .line 62
    .local v21, "surveyLinkSpan":Landroid/text/style/URLSpan;
    const v26, 0x7f0c0060

    move-object/from16 v0, p0

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Lcom/google/android/gm/preference/AboutFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 63
    .local v9, "feedbackString":Ljava/lang/String;
    new-instance v8, Landroid/text/SpannableString;

    invoke-direct {v8, v9}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 66
    .local v8, "feedback":Landroid/text/Spannable;
    const/16 v26, 0x0

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v27

    const/16 v28, 0x22

    move-object/from16 v0, v21

    move/from16 v1, v26

    move/from16 v2, v27

    move/from16 v3, v28

    invoke-interface {v8, v0, v1, v2, v3}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 67
    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 70
    const v26, 0x7f10000d

    invoke-virtual/range {v25 .. v26}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v20

    check-cast v20, Landroid/widget/TextView;

    .line 71
    .local v20, "reportProblemLinkView":Landroid/widget/TextView;
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gm/preference/AboutFragment;->getActivity()Landroid/app/Activity;

    move-result-object v26

    invoke-static/range {v26 .. v26}, Lcom/google/android/gm/Utils;->isGoogleFeedbackInstalled(Landroid/content/Context;)Z

    move-result v26

    if-eqz v26, :cond_0

    .line 73
    move-object/from16 v0, v20

    invoke-virtual {v0, v11}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 74
    new-instance v4, Lcom/google/android/gm/preference/AboutFragment$2;

    const-string v26, ""

    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v4, v0, v1}, Lcom/google/android/gm/preference/AboutFragment$2;-><init>(Lcom/google/android/gm/preference/AboutFragment;Ljava/lang/String;)V

    .line 82
    .local v4, "bugReportLinkSpan":Landroid/text/style/URLSpan;
    const v26, 0x7f0c0134

    move-object/from16 v0, p0

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Lcom/google/android/gm/preference/AboutFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 83
    .local v5, "bugReportString":Ljava/lang/String;
    new-instance v19, Landroid/text/SpannableString;

    move-object/from16 v0, v19

    invoke-direct {v0, v5}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 86
    .local v19, "reportProblem":Landroid/text/Spannable;
    const/16 v26, 0x0

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v27

    const/16 v28, 0x22

    move-object/from16 v0, v19

    move/from16 v1, v26

    move/from16 v2, v27

    move/from16 v3, v28

    invoke-interface {v0, v4, v1, v2, v3}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 88
    move-object/from16 v0, v20

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 95
    .end local v4    # "bugReportLinkSpan":Landroid/text/style/URLSpan;
    .end local v5    # "bugReportString":Ljava/lang/String;
    .end local v19    # "reportProblem":Landroid/text/Spannable;
    :goto_1
    const v26, 0x7f100010

    invoke-virtual/range {v25 .. v26}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    .line 97
    .local v14, "openSourceLicenseView":Landroid/widget/TextView;
    invoke-virtual {v14, v11}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 98
    new-instance v12, Lcom/google/android/gm/preference/AboutFragment$3;

    const-string v26, ""

    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v12, v0, v1}, Lcom/google/android/gm/preference/AboutFragment$3;-><init>(Lcom/google/android/gm/preference/AboutFragment;Ljava/lang/String;)V

    .line 106
    .local v12, "openSourceLicenseLinkSpan":Landroid/text/style/URLSpan;
    const v26, 0x7f0c0137

    move-object/from16 v0, p0

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Lcom/google/android/gm/preference/AboutFragment;->getString(I)Ljava/lang/String;

    move-result-object v13

    .line 107
    .local v13, "openSourceLicenseString":Ljava/lang/String;
    new-instance v10, Landroid/text/SpannableString;

    invoke-direct {v10, v13}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 110
    .local v10, "licenseSpannable":Landroid/text/Spannable;
    const/16 v26, 0x0

    invoke-virtual {v13}, Ljava/lang/String;->length()I

    move-result v27

    const/16 v28, 0x22

    move/from16 v0, v26

    move/from16 v1, v27

    move/from16 v2, v28

    invoke-interface {v10, v12, v0, v1, v2}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 112
    invoke-virtual {v14, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 115
    const v26, 0x7f100011

    invoke-virtual/range {v25 .. v26}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/widget/TextView;

    .line 117
    .local v17, "privacyPolicyLinkView":Landroid/widget/TextView;
    move-object/from16 v0, v17

    invoke-virtual {v0, v11}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 119
    invoke-virtual/range {v25 .. v25}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v26

    const-string v27, "gmail_privacy_policy_url"

    const-string v28, "http://www.google.com/policies/privacy/"

    invoke-static/range {v26 .. v28}, Lcom/google/android/gsf/Gservices;->getString(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 122
    .local v22, "url":Ljava/lang/String;
    new-instance v15, Landroid/text/style/URLSpan;

    move-object/from16 v0, v22

    invoke-direct {v15, v0}, Landroid/text/style/URLSpan;-><init>(Ljava/lang/String;)V

    .line 124
    .local v15, "privacyPolicyLinkSpan":Landroid/text/style/URLSpan;
    const v26, 0x7f0c0138

    move-object/from16 v0, p0

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Lcom/google/android/gm/preference/AboutFragment;->getString(I)Ljava/lang/String;

    move-result-object v16

    .line 125
    .local v16, "privacyPolicyLinkString":Ljava/lang/String;
    new-instance v18, Landroid/text/SpannableString;

    move-object/from16 v0, v18

    move-object/from16 v1, v16

    invoke-direct {v0, v1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 128
    .local v18, "privacySpannable":Landroid/text/Spannable;
    const/16 v26, 0x0

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->length()I

    move-result v27

    const/16 v28, 0x22

    move-object/from16 v0, v18

    move/from16 v1, v26

    move/from16 v2, v27

    move/from16 v3, v28

    invoke-interface {v0, v15, v1, v2, v3}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 130
    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 132
    const/16 v26, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Lcom/google/android/gm/preference/AboutFragment;->setHasOptionsMenu(Z)V

    .line 133
    return-object v25

    .line 90
    .end local v10    # "licenseSpannable":Landroid/text/Spannable;
    .end local v12    # "openSourceLicenseLinkSpan":Landroid/text/style/URLSpan;
    .end local v13    # "openSourceLicenseString":Ljava/lang/String;
    .end local v14    # "openSourceLicenseView":Landroid/widget/TextView;
    .end local v15    # "privacyPolicyLinkSpan":Landroid/text/style/URLSpan;
    .end local v16    # "privacyPolicyLinkString":Ljava/lang/String;
    .end local v17    # "privacyPolicyLinkView":Landroid/widget/TextView;
    .end local v18    # "privacySpannable":Landroid/text/Spannable;
    .end local v22    # "url":Ljava/lang/String;
    :cond_0
    const/16 v26, 0x8

    move-object/from16 v0, v20

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 91
    const v26, 0x7f10000e

    invoke-virtual/range {v25 .. v26}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v26

    const/16 v27, 0x8

    invoke-virtual/range {v26 .. v27}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1

    .line 43
    .end local v6    # "copyRightTextView":Landroid/widget/TextView;
    .end local v7    # "feebackLinkView":Landroid/widget/TextView;
    .end local v8    # "feedback":Landroid/text/Spannable;
    .end local v9    # "feedbackString":Ljava/lang/String;
    .end local v11    # "movementMethod":Landroid/text/method/MovementMethod;
    .end local v20    # "reportProblemLinkView":Landroid/widget/TextView;
    .end local v21    # "surveyLinkSpan":Landroid/text/style/URLSpan;
    :catch_0
    move-exception v26

    goto/16 :goto_0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)V
    .locals 0
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 138
    invoke-interface {p1}, Landroid/view/Menu;->clear()V

    .line 139
    return-void
.end method
