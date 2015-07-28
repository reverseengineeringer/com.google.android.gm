.class public interface abstract Lcom/android/mail/ui/ActivityController;
.super Ljava/lang/Object;
.source "ActivityController.java"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Lcom/android/mail/browse/ConversationCursor$ConversationListener;
.implements Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;
.implements Lcom/android/mail/ui/AccountChangeListener;
.implements Lcom/android/mail/ui/AccountController;
.implements Lcom/android/mail/ui/ConversationListCallbacks;
.implements Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;
.implements Lcom/android/mail/ui/ConversationSetObserver;
.implements Lcom/android/mail/ui/ConversationUpdater;
.implements Lcom/android/mail/ui/ErrorListener;
.implements Lcom/android/mail/ui/FolderChangeListener;
.implements Lcom/android/mail/ui/FolderController;
.implements Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;
.implements Lcom/android/mail/ui/LayoutListener;
.implements Lcom/android/mail/ui/RecentFolderController;
.implements Lcom/android/mail/ui/UndoListener;
.implements Lcom/android/mail/ui/ViewMode$ModeChangeListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/android/mail/ui/LayoutListener;",
        "Lcom/android/mail/ui/ViewMode$ModeChangeListener;",
        "Lcom/android/mail/ui/ConversationListCallbacks;",
        "Lcom/android/mail/ui/FolderChangeListener;",
        "Lcom/android/mail/ui/AccountChangeListener;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Lcom/android/mail/ui/ConversationSetObserver;",
        "Lcom/android/mail/browse/ConversationCursor$ConversationListener;",
        "Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;",
        "Lcom/android/mail/ui/UndoListener;",
        "Lcom/android/mail/ui/ConversationUpdater;",
        "Lcom/android/mail/ui/ErrorListener;",
        "Lcom/android/mail/ui/FolderController;",
        "Lcom/android/mail/ui/AccountController;",
        "Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;",
        "Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;",
        "Lcom/android/mail/ui/RecentFolderController;"
    }
.end annotation


# virtual methods
.method public abstract exitSearchMode()V
.end method

.method public abstract getHierarchyFolder()Lcom/android/mail/providers/Folder;
.end method

.method public abstract getSelectedSet()Lcom/android/mail/ui/ConversationSelectionSet;
.end method

.method public abstract getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;
.end method

.method public abstract handleDrop(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)V
.end method

.method public abstract loadAccountInbox()V
.end method

.method public abstract onAccessibilityStateChanged()V
.end method

.method public abstract onActivityResult(IILandroid/content/Intent;)V
.end method

.method public abstract onAnimationEnd(Lcom/android/mail/ui/AnimatedAdapter;)V
.end method

.method public abstract onBackPressed()Z
.end method

.method public abstract onCreate(Landroid/os/Bundle;)Z
.end method

.method public abstract onCreateDialog(ILandroid/os/Bundle;)Landroid/app/Dialog;
.end method

.method public abstract onCreateOptionsMenu(Landroid/view/Menu;)Z
.end method

.method public abstract onDestroy()V
.end method

.method public abstract onKeyDown(ILandroid/view/KeyEvent;)Z
.end method

.method public abstract onOptionsItemSelected(Landroid/view/MenuItem;)Z
.end method

.method public abstract onPause()V
.end method

.method public abstract onPrepareDialog(ILandroid/app/Dialog;Landroid/os/Bundle;)V
.end method

.method public abstract onPrepareOptionsMenu(Landroid/view/Menu;)Z
.end method

.method public abstract onRestart()V
.end method

.method public abstract onRestoreInstanceState(Landroid/os/Bundle;)V
.end method

.method public abstract onResume()V
.end method

.method public abstract onSaveInstanceState(Landroid/os/Bundle;)V
.end method

.method public abstract onSearchRequested(Ljava/lang/String;)V
.end method

.method public abstract onStart()V
.end method

.method public abstract onStop()V
.end method

.method public abstract onTouchEvent(Landroid/view/MotionEvent;)V
.end method

.method public abstract onUpPressed()Z
.end method

.method public abstract onWindowFocusChanged(Z)V
.end method

.method public abstract shouldShowFirstConversation()Z
.end method

.method public abstract showFolderList()V
.end method

.method public abstract startDragMode()V
.end method

.method public abstract startSearch()V
.end method

.method public abstract stopDragMode()V
.end method

.method public abstract supportsDrag(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)Z
.end method
