.class public interface abstract Lcom/android/mail/ui/ControllableActivity;
.super Ljava/lang/Object;
.source "ControllableActivity.java"

# interfaces
.implements Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;
.implements Lcom/android/mail/ui/AnimatedAdapter$Listener;
.implements Lcom/android/mail/ui/FolderItemView$DropHandler;
.implements Lcom/android/mail/ui/RestrictedActivity;
.implements Lcom/android/mail/ui/UndoListener;


# virtual methods
.method public abstract getAccountController()Lcom/android/mail/ui/AccountController;
.end method

.method public abstract getConversationUpdater()Lcom/android/mail/ui/ConversationUpdater;
.end method

.method public abstract getErrorListener()Lcom/android/mail/ui/ErrorListener;
.end method

.method public abstract getFolderController()Lcom/android/mail/ui/FolderController;
.end method

.method public abstract getFolderListSelectionListener()Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;
.end method

.method public abstract getHierarchyFolder()Lcom/android/mail/providers/Folder;
.end method

.method public abstract getListHandler()Lcom/android/mail/ui/ConversationListCallbacks;
.end method

.method public abstract getRecentFolderController()Lcom/android/mail/ui/RecentFolderController;
.end method

.method public abstract getSelectedSet()Lcom/android/mail/ui/ConversationSelectionSet;
.end method

.method public abstract getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;
.end method

.method public abstract getViewMode()Lcom/android/mail/ui/ViewMode;
.end method

.method public abstract isAccessibilityEnabled()Z
.end method

.method public abstract startDragMode()V
.end method

.method public abstract stopDragMode()V
.end method

.method public abstract unsetViewModeListener(Lcom/android/mail/ui/ViewMode$ModeChangeListener;)V
.end method
