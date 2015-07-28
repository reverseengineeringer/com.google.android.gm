.class interface abstract Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;
.super Ljava/lang/Object;
.source "FolderListFragment.java"

# interfaces
.implements Landroid/widget/ListAdapter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/FolderListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x60a
    name = "FolderListFragmentCursorAdapter"
.end annotation


# virtual methods
.method public abstract destroy()V
.end method

.method public abstract getFullFolder(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;)Lcom/android/mail/providers/Folder;
.end method

.method public abstract notifyDataSetChanged()V
.end method

.method public abstract setCursor(Landroid/database/Cursor;)V
.end method
