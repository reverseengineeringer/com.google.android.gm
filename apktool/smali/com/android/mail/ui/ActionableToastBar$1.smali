.class Lcom/android/mail/ui/ActionableToastBar$1;
.super Ljava/lang/Object;
.source "ActionableToastBar.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/ActionableToastBar;->show(Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;ILjava/lang/CharSequence;ZIZLcom/android/mail/ui/ToastBarOperation;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/ActionableToastBar;

.field final synthetic val$listener:Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/ActionableToastBar;Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;)V
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/android/mail/ui/ActionableToastBar$1;->this$0:Lcom/android/mail/ui/ActionableToastBar;

    iput-object p2, p0, Lcom/android/mail/ui/ActionableToastBar$1;->val$listener:Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "widget"    # Landroid/view/View;

    .prologue
    .line 117
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar$1;->val$listener:Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;

    invoke-interface {v0}, Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;->onActionClicked()V

    .line 118
    iget-object v0, p0, Lcom/android/mail/ui/ActionableToastBar$1;->this$0:Lcom/android/mail/ui/ActionableToastBar;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/ActionableToastBar;->hide(Z)V

    .line 119
    return-void
.end method
