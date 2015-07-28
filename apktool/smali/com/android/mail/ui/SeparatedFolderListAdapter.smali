.class public Lcom/android/mail/ui/SeparatedFolderListAdapter;
.super Landroid/widget/BaseAdapter;
.source "SeparatedFolderListAdapter.java"


# instance fields
.field public final sections:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/ui/FolderSelectorAdapter;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 30
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/SeparatedFolderListAdapter;->sections:Ljava/util/ArrayList;

    .line 36
    return-void
.end method


# virtual methods
.method public addSection(Lcom/android/mail/ui/FolderSelectorAdapter;)V
    .locals 1
    .param p1, "adapter"    # Lcom/android/mail/ui/FolderSelectorAdapter;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/android/mail/ui/SeparatedFolderListAdapter;->sections:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 40
    return-void
.end method

.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 95
    const/4 v0, 0x0

    return v0
.end method

.method public getCount()I
    .locals 4

    .prologue
    .line 60
    const/4 v2, 0x0

    .line 61
    .local v2, "total":I
    iget-object v3, p0, Lcom/android/mail/ui/SeparatedFolderListAdapter;->sections:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/FolderSelectorAdapter;

    .line 62
    .local v0, "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    invoke-virtual {v0}, Lcom/android/mail/ui/FolderSelectorAdapter;->getCount()I

    move-result v3

    add-int/2addr v2, v3

    goto :goto_0

    .line 64
    .end local v0    # "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    :cond_0
    return v2
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 4
    .param p1, "position"    # I

    .prologue
    .line 44
    iget-object v3, p0, Lcom/android/mail/ui/SeparatedFolderListAdapter;->sections:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/FolderSelectorAdapter;

    .line 45
    .local v0, "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    invoke-virtual {v0}, Lcom/android/mail/ui/FolderSelectorAdapter;->getCount()I

    move-result v2

    .line 48
    .local v2, "size":I
    if-eqz p1, :cond_0

    if-ge p1, v2, :cond_1

    .line 49
    :cond_0
    invoke-virtual {v0, p1}, Lcom/android/mail/ui/FolderSelectorAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v3

    .line 54
    .end local v0    # "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    .end local v2    # "size":I
    :goto_1
    return-object v3

    .line 52
    .restart local v0    # "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    .restart local v2    # "size":I
    :cond_1
    sub-int/2addr p1, v2

    .line 53
    goto :goto_0

    .line 54
    .end local v0    # "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    .end local v2    # "size":I
    :cond_2
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 118
    int-to-long v0, p1

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 5
    .param p1, "position"    # I

    .prologue
    .line 78
    const/4 v3, 0x0

    .line 79
    .local v3, "type":I
    iget-object v4, p0, Lcom/android/mail/ui/SeparatedFolderListAdapter;->sections:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/FolderSelectorAdapter;

    .line 80
    .local v0, "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    invoke-virtual {v0}, Lcom/android/mail/ui/FolderSelectorAdapter;->getCount()I

    move-result v2

    .line 82
    .local v2, "size":I
    if-eqz p1, :cond_0

    if-ge p1, v2, :cond_1

    .line 83
    :cond_0
    invoke-virtual {v0, p1}, Lcom/android/mail/ui/FolderSelectorAdapter;->getItemViewType(I)I

    move-result v4

    add-int/2addr v4, v3

    .line 90
    .end local v0    # "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    .end local v2    # "size":I
    :goto_1
    return v4

    .line 87
    .restart local v0    # "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    .restart local v2    # "size":I
    :cond_1
    sub-int/2addr p1, v2

    .line 88
    invoke-virtual {v0}, Lcom/android/mail/ui/FolderSelectorAdapter;->getViewTypeCount()I

    move-result v4

    add-int/2addr v3, v4

    .line 89
    goto :goto_0

    .line 90
    .end local v0    # "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    .end local v2    # "size":I
    :cond_2
    const/4 v4, -0x1

    goto :goto_1
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 105
    iget-object v3, p0, Lcom/android/mail/ui/SeparatedFolderListAdapter;->sections:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/FolderSelectorAdapter;

    .line 106
    .local v0, "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    invoke-virtual {v0}, Lcom/android/mail/ui/FolderSelectorAdapter;->getCount()I

    move-result v2

    .line 107
    .local v2, "size":I
    if-eqz p1, :cond_0

    if-ge p1, v2, :cond_1

    .line 108
    :cond_0
    invoke-virtual {v0, p1, p2, p3}, Lcom/android/mail/ui/FolderSelectorAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 113
    .end local v0    # "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    .end local v2    # "size":I
    :goto_1
    return-object v3

    .line 111
    .restart local v0    # "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    .restart local v2    # "size":I
    :cond_1
    sub-int/2addr p1, v2

    .line 112
    goto :goto_0

    .line 113
    .end local v0    # "adapter":Lcom/android/mail/ui/FolderSelectorAdapter;
    .end local v2    # "size":I
    :cond_2
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public getViewTypeCount()I
    .locals 4

    .prologue
    .line 70
    const/4 v2, 0x0

    .line 71
    .local v2, "total":I
    iget-object v3, p0, Lcom/android/mail/ui/SeparatedFolderListAdapter;->sections:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/FolderSelectorAdapter;

    .line 72
    .local v0, "adapter":Landroid/widget/Adapter;
    invoke-interface {v0}, Landroid/widget/Adapter;->getViewTypeCount()I

    move-result v3

    add-int/2addr v2, v3

    goto :goto_0

    .line 73
    .end local v0    # "adapter":Landroid/widget/Adapter;
    :cond_0
    return v2
.end method

.method public isEnabled(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 100
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/SeparatedFolderListAdapter;->getItemViewType(I)I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
