.class final Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;
.super Landroid/widget/BaseAdapter;
.source "LabelSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/LabelSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "LabelSettingsAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/LabelSettingsFragment;


# direct methods
.method private constructor <init>(Lcom/google/android/gm/LabelSettingsFragment;)V
    .locals 0

    .prologue
    .line 388
    iput-object p1, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gm/LabelSettingsFragment;Lcom/google/android/gm/LabelSettingsFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/google/android/gm/LabelSettingsFragment;
    .param p2, "x1"    # Lcom/google/android/gm/LabelSettingsFragment$1;

    .prologue
    .line 388
    invoke-direct {p0, p1}, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;-><init>(Lcom/google/android/gm/LabelSettingsFragment;)V

    return-void
.end method

.method private getVibrateValueDisplayString(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 474
    const/4 v0, 0x2

    .line 475
    .local v0, "currentIndex":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mVibrateSettingValues:[Ljava/lang/String;
    invoke-static {v2}, Lcom/google/android/gm/LabelSettingsFragment;->access$700(Lcom/google/android/gm/LabelSettingsFragment;)[Ljava/lang/String;

    move-result-object v2

    array-length v2, v2

    if-ge v1, v2, :cond_0

    .line 476
    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mVibrateSettingValues:[Ljava/lang/String;
    invoke-static {v2}, Lcom/google/android/gm/LabelSettingsFragment;->access$700(Lcom/google/android/gm/LabelSettingsFragment;)[Ljava/lang/String;

    move-result-object v2

    aget-object v2, v2, v1

    iget-object v3, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mVibrate:Ljava/lang/String;
    invoke-static {v3}, Lcom/google/android/gm/LabelSettingsFragment;->access$1500(Lcom/google/android/gm/LabelSettingsFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 477
    move v0, v1

    .line 482
    :cond_0
    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mVibrateSettingDisplayValues:[Ljava/lang/String;
    invoke-static {v2}, Lcom/google/android/gm/LabelSettingsFragment;->access$1700(Lcom/google/android/gm/LabelSettingsFragment;)[Ljava/lang/String;

    move-result-object v2

    aget-object v2, v2, v0

    return-object v2

    .line 475
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 391
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mAttributeList:Ljava/util/List;
    invoke-static {v0}, Lcom/google/android/gm/LabelSettingsFragment;->access$900(Lcom/google/android/gm/LabelSettingsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method public getItem(I)Lcom/google/android/gm/LabelSettingsFragment$Pair;
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 396
    if-nez p1, :cond_0

    .line 397
    new-instance v0, Lcom/google/android/gm/LabelSettingsFragment$Pair;

    sget v1, Lcom/google/android/gm/persistence/Persistence;->LABEL_SYNCHRONIZATION:I

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/google/android/gm/LabelSettingsFragment$Pair;-><init>(ILjava/lang/String;)V

    .line 399
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mAttributeList:Ljava/util/List;
    invoke-static {v0}, Lcom/google/android/gm/LabelSettingsFragment;->access$900(Lcom/google/android/gm/LabelSettingsFragment;)Ljava/util/List;

    move-result-object v0

    add-int/lit8 v1, p1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/LabelSettingsFragment$Pair;

    goto :goto_0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 388
    invoke-virtual {p0, p1}, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->getItem(I)Lcom/google/android/gm/LabelSettingsFragment$Pair;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 404
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 13
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 409
    invoke-virtual {p0, p1}, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->getItem(I)Lcom/google/android/gm/LabelSettingsFragment$Pair;

    move-result-object v3

    .line 413
    .local v3, "item":Lcom/google/android/gm/LabelSettingsFragment$Pair;
    iget v10, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    invoke-static {v10}, Lcom/google/android/gm/persistence/Persistence;->isNotificationSubChoice(I)Z

    move-result v10

    if-eqz v10, :cond_5

    const v4, 0x7f040048

    .line 415
    .local v4, "layout":I
    :goto_0
    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$100(Lcom/google/android/gm/LabelSettingsFragment;)Landroid/content/Context;

    move-result-object v10

    invoke-static {v10}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v10

    const/4 v11, 0x0

    invoke-virtual {v10, v4, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v9

    .line 416
    .local v9, "view":Landroid/view/View;
    const v10, 0x7f1000c5

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 417
    .local v8, "title":Landroid/widget/TextView;
    const v10, 0x7f10003e

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 418
    .local v1, "description":Landroid/widget/TextView;
    const v10, 0x7f1000c4

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    .line 421
    .local v0, "checkbox":Landroid/widget/CheckBox;
    iget v10, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v11, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_ONCE:I

    if-eq v10, v11, :cond_0

    iget v10, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v11, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_ON:I

    if-eq v10, v11, :cond_0

    .line 423
    const/16 v10, 0x8

    invoke-virtual {v0, v10}, Landroid/widget/CheckBox;->setVisibility(I)V

    .line 426
    :cond_0
    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$1100(Lcom/google/android/gm/LabelSettingsFragment;)Lcom/google/android/gm/LabelSettingsObservable;

    move-result-object v10

    invoke-interface {v10}, Lcom/google/android/gm/LabelSettingsObservable;->getIncludedLabels()Ljava/util/ArrayList;

    move-result-object v10

    iget-object v11, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mLabel:Ljava/lang/String;
    invoke-static {v11}, Lcom/google/android/gm/LabelSettingsFragment;->access$1000(Lcom/google/android/gm/LabelSettingsFragment;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v5

    .line 427
    .local v5, "syncAll":Z
    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$1100(Lcom/google/android/gm/LabelSettingsFragment;)Lcom/google/android/gm/LabelSettingsObservable;

    move-result-object v10

    invoke-interface {v10}, Lcom/google/android/gm/LabelSettingsObservable;->getPartialLabels()Ljava/util/ArrayList;

    move-result-object v10

    iget-object v11, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mLabel:Ljava/lang/String;
    invoke-static {v11}, Lcom/google/android/gm/LabelSettingsFragment;->access$1000(Lcom/google/android/gm/LabelSettingsFragment;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v7

    .line 428
    .local v7, "syncPartial":Z
    if-nez v5, :cond_6

    if-nez v7, :cond_6

    const/4 v6, 0x1

    .line 431
    .local v6, "syncNone":Z
    :goto_1
    iget v10, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v11, Lcom/google/android/gm/persistence/Persistence;->LABEL_SYNCHRONIZATION:I

    if-ne v10, v11, :cond_9

    .line 432
    const v10, 0x7f0c01e4

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setText(I)V

    .line 434
    if-eqz v5, :cond_7

    .line 435
    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mResources:Landroid/content/res/Resources;
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$1200(Lcom/google/android/gm/LabelSettingsFragment;)Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f0c01e5

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 443
    .local v2, "descriptionText":Ljava/lang/String;
    :goto_2
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 463
    .end local v2    # "descriptionText":Ljava/lang/String;
    :cond_1
    :goto_3
    iget v10, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    invoke-static {v10}, Lcom/google/android/gm/persistence/Persistence;->isNotification(I)Z

    move-result v10

    if-eqz v10, :cond_2

    if-nez v6, :cond_3

    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mDoesAccountNotify:Z
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$400(Lcom/google/android/gm/LabelSettingsFragment;)Z

    move-result v10

    if-eqz v10, :cond_3

    :cond_2
    iget v10, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    invoke-static {v10}, Lcom/google/android/gm/persistence/Persistence;->isNotificationSubChoice(I)Z

    move-result v10

    if-eqz v10, :cond_4

    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$500(Lcom/google/android/gm/LabelSettingsFragment;)Z

    move-result v10

    if-nez v10, :cond_4

    .line 465
    :cond_3
    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/view/View;->setEnabled(Z)V

    .line 466
    const/4 v10, 0x0

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 467
    const/4 v10, 0x0

    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 468
    const/4 v10, 0x0

    invoke-virtual {v0, v10}, Landroid/widget/CheckBox;->setEnabled(Z)V

    .line 470
    :cond_4
    return-object v9

    .line 413
    .end local v0    # "checkbox":Landroid/widget/CheckBox;
    .end local v1    # "description":Landroid/widget/TextView;
    .end local v4    # "layout":I
    .end local v5    # "syncAll":Z
    .end local v6    # "syncNone":Z
    .end local v7    # "syncPartial":Z
    .end local v8    # "title":Landroid/widget/TextView;
    .end local v9    # "view":Landroid/view/View;
    :cond_5
    const v4, 0x7f04004c

    goto/16 :goto_0

    .line 428
    .restart local v0    # "checkbox":Landroid/widget/CheckBox;
    .restart local v1    # "description":Landroid/widget/TextView;
    .restart local v4    # "layout":I
    .restart local v5    # "syncAll":Z
    .restart local v7    # "syncPartial":Z
    .restart local v8    # "title":Landroid/widget/TextView;
    .restart local v9    # "view":Landroid/view/View;
    :cond_6
    const/4 v6, 0x0

    goto :goto_1

    .line 436
    .restart local v6    # "syncNone":Z
    :cond_7
    if-eqz v7, :cond_8

    .line 437
    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$100(Lcom/google/android/gm/LabelSettingsFragment;)Landroid/content/Context;

    move-result-object v10

    const v11, 0x7f110023

    iget-object v12, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mSettingsObservable:Lcom/google/android/gm/LabelSettingsObservable;
    invoke-static {v12}, Lcom/google/android/gm/LabelSettingsFragment;->access$1100(Lcom/google/android/gm/LabelSettingsFragment;)Lcom/google/android/gm/LabelSettingsObservable;

    move-result-object v12

    invoke-interface {v12}, Lcom/google/android/gm/LabelSettingsObservable;->getNumberOfSyncDays()I

    move-result v12

    invoke-static {v10, v11, v12}, Lcom/google/android/gm/Utils;->formatPlural(Landroid/content/Context;II)Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "descriptionText":Ljava/lang/String;
    goto :goto_2

    .line 441
    .end local v2    # "descriptionText":Ljava/lang/String;
    :cond_8
    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mResources:Landroid/content/res/Resources;
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$1200(Lcom/google/android/gm/LabelSettingsFragment;)Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f0c01e6

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "descriptionText":Ljava/lang/String;
    goto :goto_2

    .line 444
    .end local v2    # "descriptionText":Ljava/lang/String;
    :cond_9
    iget v10, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v11, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_ON:I

    if-ne v10, v11, :cond_a

    .line 445
    const v10, 0x7f0c016b

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setText(I)V

    .line 446
    const v10, 0x7f0c016e

    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setText(I)V

    .line 447
    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$500(Lcom/google/android/gm/LabelSettingsFragment;)Z

    move-result v10

    invoke-virtual {v0, v10}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_3

    .line 448
    :cond_a
    iget v10, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v11, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_RINGTONE:I

    if-ne v10, v11, :cond_b

    .line 449
    const v10, 0x7f0c0198

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setText(I)V

    .line 450
    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    iget-object v11, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    iget-object v11, v11, Lcom/google/android/gm/LabelSettingsFragment;->mRingtone:Landroid/media/Ringtone;

    # invokes: Lcom/google/android/gm/LabelSettingsFragment;->getRingtoneString(Landroid/media/Ringtone;)Ljava/lang/String;
    invoke-static {v10, v11}, Lcom/google/android/gm/LabelSettingsFragment;->access$1300(Lcom/google/android/gm/LabelSettingsFragment;Landroid/media/Ringtone;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_3

    .line 451
    :cond_b
    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mCanVibrate:Z
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$1400(Lcom/google/android/gm/LabelSettingsFragment;)Z

    move-result v10

    if-eqz v10, :cond_c

    iget v10, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v11, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_VIBRATE:I

    if-ne v10, v11, :cond_c

    .line 452
    const v10, 0x7f0c0197

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setText(I)V

    .line 454
    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mVibrate:Ljava/lang/String;
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$1500(Lcom/google/android/gm/LabelSettingsFragment;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {p0, v10}, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->getVibrateValueDisplayString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_3

    .line 455
    :cond_c
    iget v10, v3, Lcom/google/android/gm/LabelSettingsFragment$Pair;->key:I

    sget v11, Lcom/google/android/gm/persistence/Persistence;->LABEL_NOTIFICATION_ONCE:I

    if-ne v10, v11, :cond_1

    .line 456
    const v10, 0x7f0c016f

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setText(I)V

    .line 457
    const v10, 0x7f0c0170

    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setText(I)V

    .line 458
    iget-object v10, p0, Lcom/google/android/gm/LabelSettingsFragment$LabelSettingsAdapter;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mNotifyOnce:Z
    invoke-static {v10}, Lcom/google/android/gm/LabelSettingsFragment;->access$1600(Lcom/google/android/gm/LabelSettingsFragment;)Z

    move-result v10

    invoke-virtual {v0, v10}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_3
.end method
