.class Lcom/google/android/gm/LabelSettingsFragment$2;
.super Ljava/lang/Object;
.source "LabelSettingsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/LabelSettingsFragment;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/LabelSettingsFragment;


# direct methods
.method constructor <init>(Lcom/google/android/gm/LabelSettingsFragment;)V
    .locals 0

    .prologue
    .line 189
    iput-object p1, p0, Lcom/google/android/gm/LabelSettingsFragment$2;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    const/4 v3, 0x1

    .line 192
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment$2;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mPersistence:Lcom/google/android/gm/persistence/Persistence;
    invoke-static {v0}, Lcom/google/android/gm/LabelSettingsFragment;->access$300(Lcom/google/android/gm/LabelSettingsFragment;)Lcom/google/android/gm/persistence/Persistence;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/LabelSettingsFragment$2;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/google/android/gm/LabelSettingsFragment;->access$100(Lcom/google/android/gm/LabelSettingsFragment;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gm/LabelSettingsFragment$2;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # getter for: Lcom/google/android/gm/LabelSettingsFragment;->mAccount:Ljava/lang/String;
    invoke-static {v2}, Lcom/google/android/gm/LabelSettingsFragment;->access$200(Lcom/google/android/gm/LabelSettingsFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/android/gm/persistence/Persistence;->setEnableNotifications(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 193
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment$2;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # setter for: Lcom/google/android/gm/LabelSettingsFragment;->mDoesAccountNotify:Z
    invoke-static {v0, v3}, Lcom/google/android/gm/LabelSettingsFragment;->access$402(Lcom/google/android/gm/LabelSettingsFragment;Z)Z

    .line 194
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment$2;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # setter for: Lcom/google/android/gm/LabelSettingsFragment;->mDoesLabelNotify:Z
    invoke-static {v0, v3}, Lcom/google/android/gm/LabelSettingsFragment;->access$502(Lcom/google/android/gm/LabelSettingsFragment;Z)Z

    .line 195
    iget-object v0, p0, Lcom/google/android/gm/LabelSettingsFragment$2;->this$0:Lcom/google/android/gm/LabelSettingsFragment;

    # invokes: Lcom/google/android/gm/LabelSettingsFragment;->saveSettings()V
    invoke-static {v0}, Lcom/google/android/gm/LabelSettingsFragment;->access$600(Lcom/google/android/gm/LabelSettingsFragment;)V

    .line 196
    return-void
.end method
