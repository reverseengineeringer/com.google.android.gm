.class public interface abstract Lcom/android/mail/ui/FolderItemView$DropHandler;
.super Ljava/lang/Object;
.source "FolderItemView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/FolderItemView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "DropHandler"
.end annotation


# virtual methods
.method public abstract handleDrop(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)V
.end method

.method public abstract supportsDrag(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)Z
.end method
